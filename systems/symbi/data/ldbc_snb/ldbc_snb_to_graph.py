from pathlib import Path
import argparse
import os
#import pandas as pd
import dask.dataframe as dd
import json

def write_to_file(filename, content):
    """Append content to the specified file."""
    with open(filename, 'a') as file:  # Open in append mode
        file.write(content + '\n')

def process_C(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
                f"v {row['id']} 0\n"
                f"v {row['locationIP']} 0\n"
                f"v {row['browserUsed']} 0\n"
                f"v {row['content']} 0\n"
                f"v {row['length']} 0\n"
                f"v {row['CreatorPersonId']} 0\n"
                f"v {row['LocationCountryId']} 0\n"
                f"{signal}e {row['id']} {row['locationIP']} {REL_MAP[':hasLocationIP']}\n"
                f"{signal}e {row['id']} {row['browserUsed']} {REL_MAP[':usedBrowser']}\n"
                f"{signal}e {row['id']} {row['content']} {REL_MAP[':hasContent']}\n"
                f"{signal}e {row['id']} {row['length']} {REL_MAP[':contentLength']}\n"
                f"{signal}e {row['id']} {row['CreatorPersonId']} {REL_MAP[':hasCreator']}\n"
                f"{signal}e {row['id']} {row['LocationCountryId']} {REL_MAP[':isLocatedIn']}\n"
    )

    if str(row['ParentPostId']) != 'nan' :
       result = result + (
           f"v {row['ParentPostId']} 0\n" 
           f"{signal}e {row['id']} {row['ParentPostId']} {REL_MAP[':isReplyOf']}\n" 
       )

    
    if str(row['ParentCommentId']) != 'nan' :
       result = result + (
           f"v {row['ParentCommentId']} 0\n"  
           f"{signal}e {row['id']} {row['ParentCommentId']} {REL_MAP[':isReplyOf']}\n" 
       )
       
    return result

def process_CT(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
                f"v {row['CommentId']} 0\n"
                f"v {row['TagId']} 0\n"
                f"{signal}e {row['CommentId']} {row['TagId']} {REL_MAP[':hasTag']}\n"
    )
    return result

def process_F(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
                f"v {row['id']} 0\n"
                f"v {row['title']} 0\n"
                f"v {row['ModeratorPersonId']} 0\n"
                f"{signal}e {row['id']} {row['title']} {REL_MAP[':hasTitle']}\n"
                f"{signal}e {row['id']} {row['ModeratorPersonId']} {REL_MAP[':hasModerator']}\n"
    )
    return result

def process_FP(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
                f"v {row['ForumId']} 0\n"
                f"v {row['PersonId']} 0\n"
                f"{signal}e {row['ForumId']} {row['PersonId']} {REL_MAP[':hasMember']}\n"
    )
    return result

def process_FT(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
                f"v {row['ForumId']} 0\n"
                f"v {row['TagId']} 0\n"
                f"{signal}e {row['ForumId']} {row['TagId']} {REL_MAP[':hasTag']}\n"
    )
    return result

def process_P(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

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
                f"{signal}e {row['id']} {row['firstName']} {REL_MAP[':firstName']}\n"
                f"{signal}e {row['id']} {row['lastName']} {REL_MAP[':lastName']}\n"
                f"{signal}e {row['id']} {row['gender']} {REL_MAP[':hasGender']}\n"
                f"{signal}e {row['id']} {row['birthday']} {REL_MAP[':hasBirthday']}\n"
                f"{signal}e {row['id']} {row['locationIP']} {REL_MAP[':hasLocationIP']}\n"
                f"{signal}e {row['id']} {row['browserUsed']} {REL_MAP[':usedBrowser']}\n"
                f"{signal}e {row['id']} {row['LocationCityId']} {REL_MAP[':isLocatedIn']}\n"
                f"{signal}e {row['id']} {row['language']} {REL_MAP[':spokenLanguage']}\n"
                f"{signal}e {row['id']} {row['email']} {REL_MAP[':hasEmail']}\n"
    )
    return result

def process_PT(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
                f"v {row['PersonId']} 0\n"
                f"v {row['TagId']} 0\n"
                f"{signal}e {row['PersonId']} {row['TagId']} {REL_MAP[':hasInterest']}\n"
    )
    return result

def process_PP(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
                f"v {row['Person1Id']} 0\n"
                f"v {row['Person2Id']} 0\n"
                f"{signal}e {row['Person1Id']} {row['Person2Id']} {REL_MAP[':knows']}\n"
    )
    return result

def process_PCo(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
                f"v {row['PersonId']} 0\n"
                f"v {row['CommentId']} 0\n"
                f"{signal}e {row['PersonId']} {row['CommentId']} {REL_MAP[':likes']}\n"
    )
    return result

def process_PPo(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
        f"v {str(int(row['PersonId']))} 0\n"
        f"v {str(int(row['PostId']))} 0\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['PostId']))} {REL_MAP[':likes']}\n"
    )
    return result

def process_PU(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
        f"v {row['PersonId']} 0\n"
        f"v {row['UniversityId']} 0\n"
        f"v {row['classYear']} 0\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['UniversityId']))} {REL_MAP[':studyAt']}\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['classYear']))} {REL_MAP[':studyFrom']}\n"
    )
    return result

def process_PC(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
        f"v {row['PersonId']} 0\n"
        f"v {row['CompanyId']} 0\n"
        f"v {row['workFrom']} 0\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['CompanyId']))} {REL_MAP[':workAt']}\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['workFrom']))} {REL_MAP[':workFrom']}\n"
    )
    return result

def process_Ps(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
                f"v {row['id']} 0\n"
                f"v {row['locationIP']} 0\n"
                f"v {row['browserUsed']} 0\n"
                f"v {row['length']} 0\n"
                f"v {row['CreatorPersonId']} 0\n"
                f"v {row['ContainerForumId']} 0\n"
                f"v {row['LocationCountryId']} 0\n"

                f"{signal}e {row['id']} {row['locationIP']} {REL_MAP[':hasLocationIP']}\n"
                f"{signal}e {row['id']} {row['browserUsed']} {REL_MAP[':usedBrowser']}\n"
                f"{signal}e {row['id']} {row['length']} {REL_MAP[':contentLength']}\n"
                f"{signal}e {row['id']} {row['CreatorPersonId']} {REL_MAP[':hasCreator']}\n"
                f"{signal}e {row['ContainerForumId']} {row['id']}  {REL_MAP[':containerOf']}\n"
                f"{signal}e {row['id']} {row['LocationCountryId']} {REL_MAP[':isLocatedIn']}\n"
    )


    if str(row['imageFile']) != 'nan' :
       result = result + (
           f"v {row['imageFile']} 0\n"  
           f"{signal}e {row['id']} {row['imageFile']} {REL_MAP[':imageFile']}\n" 
       )

    if str(row['content']) != 'nan' :
       result = result + (
           f"v {row['content']} 0\n"  
           f"{signal}e {row['id']} {row['content']} {REL_MAP[':hasContent']}\n" 
       )

    if str(row['language']) != 'nan' :
       result = result + (
           f"v {row['language']} 0\n"  
           f"{signal}e {row['id']} {row['language']} {REL_MAP[':writtenLanguage']}\n" 
       )

              
    return result

def process_PoT(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
        f"v {row['PostId']} 0\n"
        f"v {row['TagId']} 0\n"
        f"{signal}e {str(int(row['PostId']))} {str(int(row['TagId']))} {REL_MAP[':hasTag']}\n"
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
    print(f"output_file: {output_file}")

    # Remove the output file if it exists, or comment this line if you want to append instead
    if os.path.exists(output_file):
        os.remove(output_file)

    df = dd.read_csv(input_file, dtype=str)
                
    # Apply the processing function row-wise
    df.map_partitions(lambda part: part.apply(lambda row: process_row(row, output_file), axis=1)).compute()


def map_strings_to_ids(input_file, output_file):
    """Map string values to unique IDs."""
    df = dd.read_csv(input_file, dtype=str)
    df = dd.read_csv(input_file, delimiter='|', dtype=str)

    keep_original_columns = {'type', 'signal', 'time'}
    unique_strings = set()

    for column in df.columns:
        if column not in keep_original_columns:
            unique_strings.update(df[column].dropna().unique().compute())

    string_to_id = {string: idx for idx, string in enumerate(unique_strings, start=28)}

    def map_to_id(row):
        return row.apply(lambda value: string_to_id.get(value, value) if value not in keep_original_columns else value)

    df_mapped = df.map_partitions(lambda df_partition: df_partition.apply(map_to_id, axis=1))

    for column in df_mapped.columns:
        if column not in keep_original_columns:
            df_mapped[column] = df_mapped[column].astype('Int64')

    df_mapped.to_csv(output_file, single_file=True, index=False)

def main():
    parser = argparse.ArgumentParser(description='SNB Data Processor')
    parser.add_argument('factor', type=str, help='Factor = 0.003, 0.1, 1, 3, 10')
    args = parser.parse_args()

    factor = args.factor.replace('.', '_')
    script_path = Path(__file__).parent.resolve()

    global_snb_data_path = script_path.parents[3] / 'data' / 'ldbc_snb' 
    global_system_path = script_path.parents[1]
    
    dataset_name = f'snb_{factor}'
    dataset_path = global_snb_data_path / dataset_name / 'dynamic'
    dataset_path_symbi = global_system_path / 'data' / 'ldbc_snb' 

    input_file_path = dataset_path / 'dynamic.csv'
    dataset_path_symbi_id    = dataset_path_symbi / f'{dataset_name}_dynamic_id.csv'
    dataset_path_symbi_graph = dataset_path_symbi /  f'{dataset_name}_dynamic.g' 

    global REL_MAP 
    with open(global_snb_data_path / 'rel_map.json', 'r') as file:
        REL_MAP = json.load(file)
        
    map_strings_to_ids(input_file_path, dataset_path_symbi_id)
    convert_to_graph(dataset_path_symbi_id, dataset_path_symbi_graph)

if __name__ == '__main__':
    main()
