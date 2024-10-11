from pathlib import Path
from dateutil import parser
import argparse
import os
import dask.dataframe as dd
import json

# Convert date time to timestamp in milliseconds
def date_to_timestamp(time_as_string):
    dt_obj = parser.parse(time_as_string)
    return str(int(dt_obj.timestamp() * 1000))

# Process the DataFrame
def process_deleted_records(df, entry_type):
    m_df = df[df['explicitlyDeleted'] == "true"]
    m_df['signal'] = '-'
    m_df['type'] = entry_type

    m_df['deletionDate'] = m_df['deletionDate'].map_partitions(
        lambda series: series.apply(date_to_timestamp),
        meta=('deletionDate', 'str')
    )
    m_df = m_df.drop(['creationDate', 'explicitlyDeleted'], axis=1)
    m_df = m_df.rename(columns={'deletionDate': 'time'})

    # Reorder columns
    m_df = reorder_columns(m_df)

    return m_df

def process_non_deleted_records(df, entry_type):
    df['creationDate'] = df['creationDate'].map_partitions(
        lambda series: series.apply(date_to_timestamp),
        meta=('creationDate', 'str')
    )
    df = df.rename(columns={'creationDate': 'time'})
    df = df.drop('deletionDate', axis=1)
    df['signal'] = '+'
    df['type'] = entry_type

    # Reorder columns
    df = reorder_columns(df)

    return df

def reorder_columns(df):
    # Reorder 'type' and 'signal' columns
    df = df[['type'] + [col for col in df.columns if col != 'type']]
    df = df[['signal'] + [col for col in df.columns if col != 'signal']]
    return df

def pre_process(df, entry_type):
    m_df = None
    
    if 'explicitlyDeleted' in df.columns:
        m_df = process_deleted_records(df, entry_type)

    df = process_non_deleted_records(df, entry_type)

    if m_df is not None:
        df = dd.concat([df, m_df], axis=0)
    
    return df

def convert_to_stream(input_folder, entry_type):
    output_file_path = input_folder / f'{input_folder.name.lower()}.csv'
    df_list = []

    for f in os.listdir(input_folder):
        if f.endswith('.csv') and f.startswith('part'):
            df = dd.read_csv(input_folder / f, delimiter='|', dtype=str)
            df = pre_process(df, entry_type)
            df_list.append(df)

    if df_list:
        df = dd.concat(df_list)
        df.to_csv(output_file_path, single_file=True, index=False, sep='|')

    
def merge_to_big_graph(input_folder):
    """Merge pre-processed files into a big graph."""
    #pre_processed_files = [f.name for f in input_folder.iterdir() if f.is_file() and not f.name.startswith('part')]
    output_file_path = input_folder / f'{input_folder.name.lower()}.csv'
    if os.path.exists(output_file_path):
        os.remove(output_file_path)

    files_list = []
    for d in os.listdir(input_folder):
        path_to_file = input_folder / d / f'{d.lower()}.csv'
        files_list.append(path_to_file)

    df_list = [dd.read_csv(file, delimiter='|', dtype=str) for file in files_list]
    df_concat = dd.concat(df_list, axis=0)
    df_sorted = df_concat.sort_values(by='time')
    df_sorted.to_csv(output_file_path, single_file=True, index=False,  sep='|')



def main():
    parser = argparse.ArgumentParser(description='SNB Data Processor')
    parser.add_argument('factor', type=str, help='Factor = 0.003, 0.1, 1, 3, 10')
    args = parser.parse_args()

    factor = args.factor.replace('.', '_')
    script_path = Path(__file__).parent.resolve()
    dataset_name = f'snb_{factor}'
    dataset_path = script_path / dataset_name / 'dynamic'

    with open(script_path / 'prefix_map.json', 'r') as file:
        prefix_map = json.load(file)

    for input_folder, entry_type in prefix_map.items():
        convert_to_stream(dataset_path / input_folder, entry_type)

    merge_to_big_graph(dataset_path)
    
if __name__ == '__main__':
    main()
