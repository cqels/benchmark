from pathlib import Path

import argparse
import os
import pandas as pd
import dask.dataframe as dd


def merge_into_big_graph(input_folder):
    #list all pre processed files:
    pre_processed_files = [f.name for f in input_folder.iterdir() if f.is_file() and f.name.startswith('preprocess')]

    # Load and concatenate all files
    df_list = [dd.read_csv(input_folder / file, delimiter='|') for file in pre_processed_files]
    df_concat = dd.concat(df_list, axis=0)

    # Save the final concatenated DataFrame to a CSV file
    df_concat.to_csv('merged_output.csv', single_file=True, index=False)
    df_sorted = df_concat.sort_values(by='time')
    df_sorted.to_csv('sorted_concatenated_output.csv', single_file=True, index=False)

def add_prefix(chunk, prefix):
    chunk.insert(0, 'type', prefix)
    return chunk;

def pre_process(input_folder, output_folder, prefix):

    output_folder.mkdir(parents=True, exist_ok=True)
    df_list = []
    input_file = f'{input_folder.name.lower()}.csv'
    input_file_path = input_folder / input_file
    
    try:
        for chunk in pd.read_csv(input_file_path, delimiter='|', chunksize=100000):
            chunk = add_prefix(chunk, prefix)
            df_list.append(chunk)
    except pd.errors.ParserError as e:
        print(f"Error reading {input_file_path}: {e}")

    output_file = 'preprocess_' + input_file
    output_file_path = output_folder / output_file

    if df_list:
       merged_df = pd.concat(df_list, ignore_index=True)
       try:
           merged_df.to_csv(output_file_path, index=False, sep='|')
           print(f'Data written to {output_file_path}')
       except Exception as e:
           print(f"Error writing merged data to {output_file_path}: {e}")


def main():
    parser = argparse.ArgumentParser(description='SNB Data Processor')
    parser.add_argument('factor', type=str, help='Factor = 0.003, 0.1, 1, 3, 10')
    args = parser.parse_args()

    factor = args.factor.replace('.', '_')
    script_path = Path(__file__).parent.resolve()

    global_data_path = script_path.parents[3]
    global_system_path = script_path.parents[1]
    
    dataset_name = f'snb_{factor}'
    dataset_path = global_data_path / 'data' / 'ldbc_snb' / dataset_name / 'dynamic'
    process_dataset_path = global_system_path / 'data' / 'ldbc_snb' / dataset_name / 'dynamic'

    paths = {
    'Comment': 'C', 
    'Comment_hasTag_Tag': 'CT', 
    'Forum': 'F',
    'Forum_hasMember_Person': 'FP',
    'Forum_hasTag_Tag': 'FT', 
    'Person': 'P', 
    'Person_hasInterest_Tag': 'PT', 
    'Person_knows_Person': 'PP',
    'Person_likes_Comment': 'PCo', 
    'Person_likes_Post': 'PPo', 
    'Person_studyAt_University': 'PU',
    'Person_workAt_Company': 'PC',
    'Post': 'Ps', 
    'Post_hasTag_Tag': 'PoT'
    }

    for path, prefix in paths.items():
       pre_process(dataset_path / path, process_dataset_path, prefix)

    merge_into_big_graph(process_dataset_path)


if __name__ == '__main__':
    main()