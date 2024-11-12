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
                f"v {row['isLocatedIn']} 0\n"
                f"{signal}e {row['id']} {row['locationIP']} {REL_MAP[':hasLocationIP']}\n"
                f"{signal}e {row['id']} {row['browserUsed']} {REL_MAP[':usedBrowser']}\n"
                f"{signal}e {row['id']} {row['content']} {REL_MAP[':hasContent']}\n"
                f"{signal}e {row['id']} {row['length']} {REL_MAP[':contentLength']}\n"
                f"{signal}e {row['id']} {row['CreatorPersonId']} {REL_MAP[':hasCreator']}\n"
                f"{signal}e {row['id']} {row['isLocatedIn']} {REL_MAP[':isLocatedIn']}\n"
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
                f"v {row['TagName']} 0\n"
                f"{signal}e {row['CommentId']} {row['TagName']} {REL_MAP[':hasTag']}\n"
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
                f"v {row['TagName']} 0\n"
                f"{signal}e {row['ForumId']} {row['TagName']} {REL_MAP[':hasTag']}\n"
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
                f"v {row['isLocatedIn']} 0\n"
                f"v {row['language']} 0\n"
                f"v {row['email']} 0\n"
                f"{signal}e {row['id']} {row['firstName']} {REL_MAP[':firstName']}\n"
                f"{signal}e {row['id']} {row['lastName']} {REL_MAP[':lastName']}\n"
                f"{signal}e {row['id']} {row['gender']} {REL_MAP[':hasGender']}\n"
                f"{signal}e {row['id']} {row['birthday']} {REL_MAP[':hasBirthday']}\n"
                f"{signal}e {row['id']} {row['locationIP']} {REL_MAP[':hasLocationIP']}\n"
                f"{signal}e {row['id']} {row['browserUsed']} {REL_MAP[':usedBrowser']}\n"
                f"{signal}e {row['id']} {row['isLocatedIn']} {REL_MAP[':isLocatedIn']}\n"
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
                f"v {row['TagName']} 0\n"
                f"{signal}e {row['PersonId']} {row['TagName']} {REL_MAP[':hasInterest']}\n"
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
        f"v {row['University']} 0\n"
        f"v {row['classYear']} 0\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['University']))} {REL_MAP[':studyAt']}\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['classYear']))} {REL_MAP[':studyFrom']}\n"
    )
    return result

def process_PC(row):
    signal = ''
    if row['signal'] == '-':
        signal = '-'

    result = (
        f"v {row['PersonId']} 0\n"
        f"v {row['Company']} 0\n"
        f"v {row['workFrom']} 0\n"
        f"{signal}e {str(int(row['PersonId']))} {str(int(row['Company']))} {REL_MAP[':workAt']}\n"
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
                f"v {row['isLocatedIn']} 0\n"

                f"{signal}e {row['id']} {row['locationIP']} {REL_MAP[':hasLocationIP']}\n"
                f"{signal}e {row['id']} {row['browserUsed']} {REL_MAP[':usedBrowser']}\n"
                f"{signal}e {row['id']} {row['length']} {REL_MAP[':contentLength']}\n"
                f"{signal}e {row['id']} {row['CreatorPersonId']} {REL_MAP[':hasCreator']}\n"
                f"{signal}e {row['ContainerForumId']} {row['id']}  {REL_MAP[':containerOf']}\n"
                f"{signal}e {row['id']} {row['isLocatedIn']} {REL_MAP[':isLocatedIn']}\n"
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
        f"v {row['TagName']} 0\n"
        f"{signal}e {str(int(row['PostId']))} {str(int(row['TagName']))} {REL_MAP[':hasTag']}\n"
    )
    return result

def to_csv(df, output_file_path):
    df.dropna()
    df.to_csv(output_file_path, single_file=True, index=False, sep='|')
    
def read_csv(input_file_path):
    return dd.read_csv(input_file_path, delimiter = '|', dtype = str)


def convert_dynamic_graph(input, output):
    if (os.path.exists(output)):
        os.remove(output)

    df = read_csv(input)

    def process_dynamic(row, file):
        process_functions = {
            'C': process_C,     #Comment
            # 'CT': process_CT,   #Comment_hasTag_Tag
            # 'F': process_F,     #Forum
            # 'FP': process_FP,   #Forum_hasMember_Person
            # 'FT': process_FT,   #Forum_hasTag_Tag
            # 'P': process_P,     #Person
            # 'PT': process_PT,   #Person_hasInterest_Tag
            # 'PP':process_PP,     #Person_knows_Person
            # 'PCo': process_PCo,  #Person_likes_Comment
            # 'PPo': process_PPo,  #Person_likes_Post
            # 'PU': process_PU,   #Person_studyAt_University
            # 'PC': process_PC,   #Person_workAt_Company 
            # 'Ps': process_Ps,   #Post
            # 'PoT': process_PoT, #Post_hasTag_Tag 
        }

        type_value = row['type']
        process_function = process_functions.get(type_value)

        if process_function:
            result = process_function(row)

            if result:  
                file.write(f"{result}")    
    
    with open(output, 'w') as file:
        df.map_partitions(lambda part : part.apply(lambda row : process_dynamic(row, file), axis =1)).compute()

def convert_static_graph(input, output):
    if (os.path.exists(output)):
        os.remove(output)

    df = read_csv(input)

    def stack_partition(df_partition):
        return df_partition.stack()

    nodes = df.map_partitions(stack_partition).unique().compute()

    def proccess_static(row, file):
        result = ""

        if str(row['TagClass']) != 'nan' :
            result = result + (f"e {row['name']} {row['TagClass']} {REL_MAP[':isA']}\n" 
            )

        if str(row['isLocatedIn']) != 'nan' :
            result = result + (f"e {row['name']} {row['isLocatedIn']} {REL_MAP[':isLocatedIn']}\n" 
        )

        if str(row['subClass']) != 'nan' :
            result = result + (f"e {row['name']} {row['subClass']} {REL_MAP[':isSubClassOf']}\n" 
        )

        if str(row['isPartOf']) != 'nan' :
            result = result + (f"e {row['name']} {row['isPartOf']} {REL_MAP[':isPartOf']}\n" 
        )
    
        result = result + f"e {row['name']} {row['url']} {REL_MAP[':hasURL']}\n" 
        
        file.write(f"{result}")
        
    with open(output, 'w') as file:
        for node in nodes:
            file.write(f"v {node} 0\n")
        df.map_partitions(lambda part: part.apply(lambda row: proccess_static(row, file), axis=1)).compute()
        
   
def main():
    parser = argparse.ArgumentParser(description='SNB Data Processor')
    parser.add_argument('factor', type=str, help='Factor = 0.003, 0.1, 1, 3, 10')
    args = parser.parse_args()

    factor = args.factor.replace('.', '_')
    script_path = Path(__file__).parent.resolve()

    global_snb_data_path        = script_path.parents[3] / 'data' / 'ldbc_snb' 
    
    dataset_name = f'snb_{factor}'
    dataset_path = global_snb_data_path / dataset_name 

    static_file_path  = dataset_path / f"static_id_{dataset_name}.csv"
    dynamic_file_path = dataset_path / f"dynamic_id_{dataset_name}.csv"

    global REL_MAP 
    with open(global_snb_data_path / 'rel_map.json', 'r') as file:
        REL_MAP = json.load(file)

    static_graph_file  = script_path / f"static_id_{dataset_name}.g"
    dynamic_graph_file = script_path / f"dynamic_id_{dataset_name}.g"
    convert_static_graph(static_file_path, static_graph_file)
    convert_dynamic_graph(dynamic_file_path, dynamic_graph_file)            

if __name__ == '__main__':
    main()
