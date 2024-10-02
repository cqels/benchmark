from pathlib import Path
import argparse
import os
import dask.dataframe as dd

def sort_large_by_time(path):
    input_path = Path(path)
    output_path = input_path.parent / f'sorted_{input_path.name.lower()}'

    # Specify the correct data types for columns that should be treated as strings
    dtype_spec = {
        'content': 'object',
        'language': 'object',
    }

    try:
        dask_df = dd.read_csv(input_path, delimiter='|', assume_missing=True, dtype=dtype_spec)
    except Exception as e:
        print(f"Error reading the CSV file {input_path}: {e}")
        return None

    sort_column = 'time' 
    
    if sort_column not in dask_df.columns:
        print(f"Column '{sort_column}' not found in the file.")
        return None

    sorted_dask_df = dask_df.sort_values(by=sort_column)
    sorted_dask_df = convert_floats_to_ints(sorted_dask_df)

    try:
        sorted_dask_df.to_csv(output_path, single_file=True, index=False, sep='|')
        print(f'Sorted data written to {output_path}')
    except Exception as e:
        print(f"Error writing sorted data to {output_path}: {e}")

    return output_path

def process_chunk(chunk, df_list):
    if 'explicitlyDeleted' not in chunk.columns:
        chunk = chunk.drop(chunk.columns[1], axis=1)
        chunk = chunk.rename(columns={'creationDate': 'time'})
        chunk['signal'] = '+'
        chunk = convert_floats_to_ints(chunk)
        df_list.append(chunk)
        return

    ddf_chunk = chunk[chunk['explicitlyDeleted']].iloc[:, 1:]
    ddf_chunk['signal'] = '-'
    ddf_chunk = ddf_chunk.rename(columns={'deletionDate': 'time'})
    ddf_chunk = ddf_chunk.drop(ddf_chunk.columns[2], axis=1)

    chunk = chunk[chunk['explicitlyDeleted'] == False]
    chunk = chunk.drop(chunk.columns[[1, 1]], axis=1)  # Drop columns after filter
    chunk = chunk.rename(columns={'creationDate': 'time'})
    chunk['signal'] = '+'
    chunk = chunk.drop("explicitlyDeleted", axis=1)

    chunk = convert_floats_to_ints(chunk)
    ddf_chunk = convert_floats_to_ints(ddf_chunk)

    df_list.append(chunk)
    df_list.append(ddf_chunk)

def convert_floats_to_ints(df):
    for col in df.columns:
        if df[col].dtype == 'float64':
            is_int_series = df[col].dropna().map(float.is_integer).compute()
            if is_int_series.all():
                df[col] = df[col].astype('Int64')
    return df

def prepare_insert_delete(path):
    output_file = path / f'{path.name.lower()}.csv'
    csv_files = [f for f in os.listdir(path) if f.endswith('.csv') and f.startswith('part')]

    if not csv_files:
        print(f'No CSV files found in the folder {path}')
        return None

    df_list = []

    for filename in csv_files:
        file_path = path / filename
        print(f'Reading file: {file_path}')
        
        try:
            dask_df = dd.read_csv(file_path, delimiter='|', assume_missing=True)
            process_chunk(dask_df, df_list)
        except Exception as e:
            print(f"Error reading {file_path}: {e}")
            continue

    if df_list:
        merged_df = dd.concat(df_list)
        try:
            merged_df.to_csv(output_file, single_file=True, index=False, sep='|')
            print(f'Merged data written to {output_file}')
        except Exception as e:
            print(f"Error writing merged data to {output_file}: {e}")

    return output_file

def process(path):
    print(f"Processing folder: {path}")
    merged_file = prepare_insert_delete(path)
    if merged_file:
        sort_large_by_time(merged_file)

def main():
    parser = argparse.ArgumentParser(description='SNB Data Processor')
    parser.add_argument('factor', type=str, help='Factor = 0.003, 0.1, 1, 3, 10')
    args = parser.parse_args()

    factor = args.factor.replace('.', '_')
    script_path = Path(__file__).parent.resolve()
    dataset_name = f'snb_{factor}'
    dataset_path = script_path / dataset_name / 'dynamic'

    paths = [
        'Comment', 
        'Comment_hasTag_Tag', 
        'Forum', 
        'Forum_hasMember_Person',
        'Forum_hasTag_Tag', 
        'Person', 
        'Person_hasInterest_Tag', 
        'Person_knows_Person',
        'Person_likes_Comment', 
        'Person_likes_Post', 
        'Person_studyAt_University',
        'Person_workAt_Company',
        'Post', 
        'Post_hasTag_Tag'
    ]

    for path in paths:
        process(dataset_path / path)

if __name__ == '__main__':
    main()
