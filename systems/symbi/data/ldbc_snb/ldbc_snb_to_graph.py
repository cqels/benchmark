from pathlib import Path
import argparse
import os
import pandas as pd
import dask.dataframe as dd

REL_MAP = {
    'ForumId': 1,          # ForumId
    'PersonId': 2,         # PersonId
    'id': 3,               # id
    'firstName': 4,        # firstName
    'lastName': 5,         # lastName
    'gender': 6,           # gender
    'birthday': 7,         # birthday
    'locationIP': 8,       # locationIP
    'browserUsed': 9,      # browserUsed
    'LocationCityId': 10,  # LocationCityId
    'language': 11,        # language
    'email': 12,           # email
    'likes': 13,           # PostId
    'title': 14,           # title
    'ModeratorPersonId': 15, # ModeratorPersonId
    'imageFile': 16,       # imageFile
    'content': 17,         # content
    'length': 18,          # length
    'CreatorPersonId': 19, # CreatorPersonId
    'ContainerForumId': 20, # ContainerForumId
    'LocationCountryId': 21, # LocationCountryId
    'TagId': 22,           # TagId
    'ParentPostId': 23,    # ParentPostId
    'ParentCommentId': 24,  # ParentCommentId
    'CommentId': 25,       # CommentId
    'knows': 27,       # Person2Id
    'studyAt': 28,         # UniversityId
    'studyFrom': 29,       # classYear
    'workAt': 30,          # CompanyId
    'workFrom': 31         # workFrom
}

def write_to_file(filename, content):
    """Append content to the specified file."""
    with open(filename, 'a') as file:  # Open in append mode
        file.write(content + '\n')

def process_C(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
                f"v {row['id']} 0\n"
                f"v {row['locationIP']} 0\n"
                f"v {row['browserUsed']} 0\n"
                f"v {row['content']} 0\n"
                f"v {row['length']} 0\n"
                f"v {row['CreatorPersonId']} 0\n"
                f"v {row['LocationCountryId']} 0\n"
                f"{signal}e {row['id']} {row['locationIP']} {REL_MAP['locationIP']}\n"
                f"{signal}e {row['id']} {row['browserUsed']} {REL_MAP['browserUsed']}\n"
                f"{signal}e {row['id']} {row['content']} {REL_MAP['content']}\n"
                f"{signal}e {row['id']} {row['length']} {REL_MAP['length']}\n"
                f"{signal}e {row['id']} {row['CreatorPersonId']} {REL_MAP['CreatorPersonId']}\n"
                f"{signal}e {row['id']} {row['LocationCountryId']} {REL_MAP['LocationCountryId']}\n"
    )

    if str(row['ParentPostId']) != 'nan' :
       result = result + (
           f"v {row['ParentPostId']} 0\n" 
           f"{signal}e {row['id']} {row['ParentPostId']} {REL_MAP['ParentPostId']}\n" 
       )

    
    if str(row['ParentCommentId']) != 'nan' :
       result = result + (
           f"v {row['ParentCommentId']} 0\n"  
           f"{signal}e {row['id']} {row['ParentCommentId']} {REL_MAP['ParentCommentId']}\n" 
       )
       
    return result

def process_CT(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
                f"v {row['CommentId']} 0\n"
                f"v {row['TagId']} 0\n"
                f"{signal}e {row['CommentId']} {row['TagId']} {REL_MAP['TagId']}\n"
    )
    return result

def process_F(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
                f"v {row['id']} 0\n"
                f"v {row['title']} 0\n"
                f"v {row['ModeratorPersonId']} 0\n"
                f"{signal}e {row['id']} {row['title']} {REL_MAP['title']}\n"
                f"{signal}e {row['id']} {row['ModeratorPersonId']} {REL_MAP['ModeratorPersonId']}\n"
    )
    return result

def process_FP(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
                f"v {row['ForumId']} 0\n"
                f"v {row['PersonId']} 0\n"
                f"{signal}e {row['ForumId']} {row['PersonId']} {REL_MAP['PersonId']}\n"
    )
    return result

def process_FT(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
                f"v {row['ForumId']} 0\n"
                f"v {row['TagId']} 0\n"
                f"{signal}e {row['ForumId']} {row['TagId']} {REL_MAP['TagId']}\n"
    )
    return result

def process_P(row):
    signal = ''
    #if row['signal'] == '-':
    #    signal = '- '

    result = (
                f"v {row['id']} 0\n"
                f"v {row['firstName']} 0\n"
                f"v {row['lastName']} 0\n"
                f"v {row['gender']} 0\n"
                f"v {row['birthday']} 0\n"
                f"v {row['locationIP']} 0\n"
                f"v {row['browserUsed']} 0\n"
                f"v {row['LocationCityId']} 0\n"
                f"v {row['language']} 0\n"
                f"v {row['email']} 0\n"
                f"{signal}e {row['id']} {row['firstName']} {REL_MAP['firstName']}\n"
                f"{signal}e {row['id']} {row['lastName']} {REL_MAP['lastName']}\n"
                f"{signal}e {row['id']} {row['gender']} {REL_MAP['gender']}\n"
                f"{signal}e {row['id']} {row['birthday']} {REL_MAP['birthday']}\n"
                f"{signal}e {row['id']} {row['locationIP']} {REL_MAP['locationIP']}\n"
                f"{signal}e {row['id']} {row['browserUsed']} {REL_MAP['browserUsed']}\n"
                f"{signal}e {row['id']} {row['LocationCityId']} {REL_MAP['LocationCityId']}\n"
                f"{signal}e {row['id']} {row['language']} {REL_MAP['language']}\n"
                f"{signal}e {row['id']} {row['email']} {REL_MAP['email']}\n"
    )
    print(result)
    return result

def process_PT(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
                f"v {row['PersonId']} 0\n"
                f"v {row['TagId']} 0\n"
                f"{signal}e {row['PersonId']} {row['TagId']} {REL_MAP['TagId']}\n"
    )
    return result

def process_PP(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
                f"v {row['Person1Id']} 0\n"
                f"v {row['Person2Id']} 0\n"
                f"{signal}e {row['Person1Id']} {row['Person2Id']} {REL_MAP['knows']}\n"
    )
    return result

def process_PCo(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
                f"v {row['PersonId']} 0\n"
                f"v {row['CommentId']} 0\n"
                f"{signal}e {row['PersonId']} {row['CommentId']} {REL_MAP['likes']}\n"
    )
    return result

def process_PPo(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
        f"v {str(int(row['PersonId']))} 0\n"
        f"v {str(int(row['PostId']))} 0\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['PostId']))} {REL_MAP['likes']}\n"
    )
    return result

def process_PU(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
        f"v {row['PersonId']} 0\n"
        f"v {row['UniversityId']} 0\n"
        f"v {row['classYear']} 0\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['UniversityId']))} {REL_MAP['studyAt']}\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['classYear']))} {REL_MAP['studyFrom']}\n"
    )
    return result

def process_PC(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
        f"v {row['PersonId']} 0\n"
        f"v {row['CompanyId']} 0\n"
        f"v {row['workFrom']} 0\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['CompanyId']))} {REL_MAP['workAt']}\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['workFrom']))} {REL_MAP['workFrom']}\n"
    )
    return result

def process_Ps(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
                f"v {row['id']} 0\n"
                f"v {row['locationIP']} 0\n"
                f"v {row['browserUsed']} 0\n"
                f"v {row['length']} 0\n"
                f"v {row['CreatorPersonId']} 0\n"
                f"v {row['ContainerForumId']} 0\n"
                f"v {row['LocationCountryId']} 0\n"

                f"{signal}e {row['id']} {row['locationIP']} {REL_MAP['locationIP']}\n"
                f"{signal}e {row['id']} {row['browserUsed']} {REL_MAP['browserUsed']}\n"
                f"{signal}e {row['id']} {row['length']} {REL_MAP['length']}\n"
                f"{signal}e {row['id']} {row['CreatorPersonId']} {REL_MAP['CreatorPersonId']}\n"
                f"{signal}e {row['id']} {row['ContainerForumId']} {REL_MAP['ContainerForumId']}\n"
                f"{signal}e {row['id']} {row['LocationCountryId']} {REL_MAP['LocationCountryId']}\n"
    )


    if str(row['imageFile']) != 'nan' :
       result = result + (
           f"v {row['imageFile']} 0\n"  
           f"{signal}e {row['id']} {row['imageFile']} {REL_MAP['imageFile']}\n" 
       )

    if str(row['content']) != 'nan' :
       result = result + (
           f"v {row['content']} 0\n"  
           f"{signal}e {row['id']} {row['content']} {REL_MAP['content']}\n" 
       )

    if str(row['language']) != 'nan' :
       result = result + (
           f"v {row['language']} 0\n"  
           f"{signal}e {row['id']} {row['language']} {REL_MAP['language']}\n" 
       )

              
    return result

def process_PoT(row):
    signal = ''
    if row['signal'] == '-':
        signal = '- '

    result = (
        f"v {row['PostId']} 0\n"
        f"v {row['TagId']} 0\n"
        f"{signal}e {str(int(row['PostId']))} {str(int(row['TagId']))} {REL_MAP['TagId']}\n"
    )
    return result

def process_row(row, output_file):
    """
    Process the row based on its type and write the result to the output file.
    """
    # Mapping type value to processing function
    process_functions = {
        'C': process_C,
        'CT': process_CT,
        'F': process_F,
        'FP': process_FP,
        'FT': process_FT,
        'P': process_P,
        'PT': process_PT,
        'PP': process_PP,
        'PCo': process_PCo,
        'PPo': process_PPo,
        'PU': process_PU,
        'PC': process_PC,
        'Ps': process_Ps,
        'PoT': process_PoT,
    }

    type_value = row['type']
    process_function = process_functions.get(type_value)

    if process_function:
        result = process_function(row)
        if result:  
            write_to_file(output_file, result)


def convert_to_graph(input_file, output_file):
    """Convert input CSV file to graph representation."""
    
    print(f"Output file: {output_file}")

    # Remove the output file if it exists, or comment this line if you want to append instead
    if os.path.exists(output_file):
        os.remove(output_file)

    df = dd.read_csv(input_file, dtype=str)
                
    # Apply the processing function row-wise
    df.map_partitions(lambda part: part.apply(lambda row: process_row(row, output_file), axis=1)).compute()


def map_strings_to_ids(input_file, output_file):
    """Map string values to unique IDs."""

    df = dd.read_csv(input_file, dtype=str)

    keep_original_columns = {'type', 'signal', 'time'}
    unique_strings = set()

    for column in df.columns:
        if column not in keep_original_columns:
            unique_strings.update(df[column].dropna().unique().compute())

    string_to_id = {string: idx for idx, string in enumerate(unique_strings, start=32)}

    def map_to_id(row):
        return row.apply(lambda value: string_to_id.get(value, value) if value not in keep_original_columns else value)

    df_mapped = df.map_partitions(lambda df_partition: df_partition.apply(map_to_id, axis=1))

    for column in df_mapped.columns:
        if column not in keep_original_columns:
            df_mapped[column] = df_mapped[column].astype('Int64')

    df_mapped.to_csv(output_file, single_file=True, index=False)





def merge_into_big_graph(input_folder):
    """Merge pre-processed files into a big graph."""
    pre_processed_files = [f.name for f in input_folder.iterdir() if f.is_file() and f.name.startswith('preprocess')]

    df_list = [dd.read_csv(input_folder / file, delimiter='|') for file in pre_processed_files]
    df_concat = dd.concat(df_list, axis=0)

    df_sorted = df_concat.sort_values(by='time')
    df_sorted.to_csv(input_folder / 'sorted_concatenated_output.csv', single_file=True, index=False)


def add_prefix(chunk, prefix):
    """Add prefix to a DataFrame chunk."""
    chunk.insert(0, 'type', prefix)
    return chunk

def pre_process(input_folder, output_folder, prefix):
    """Pre-process input data and save it to the output folder."""
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

    input_file_path = process_dataset_path / 'sorted_concatenated_output.csv'
    output_file_path = process_dataset_path / 'id_concatenated_output.csv'

    # map_strings_to_ids(input_file_path, output_file_path)
    convert_to_graph(output_file_path, global_system_path / 'data' / 'ldbc_snb' / f"{dataset_name}.g")

if __name__ == '__main__':
    main()
