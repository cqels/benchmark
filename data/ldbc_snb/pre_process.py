from pathlib import Path
from dateutil import parser

import argparse
import os
import dask.dataframe as dd
import pandas as pd

def to_csv(df, output_file_path):
    df.dropna()
    df.to_csv(output_file_path, single_file=True, index=False, sep='|')
    
def read_csv(input_file_path):
    return dd.read_csv(input_file_path, delimiter = '|', dtype = str)


def id_to_name(df):
    return  df[['id', 'name']].compute().set_index('id')['name'].to_dict()


def merge_many_files_to_one(list_input_file_paths, output_file_path):
    df_list = [read_csv(input_file_path) for input_file_path in list_input_file_paths]
    df_merged = dd.concat(df_list, axis = 0)
    to_csv(df_merged, output_file_path)

    
def merge_part_files_to_one(input_folder):
    output_file_path = input_folder / f'{input_folder.name.lower()}.csv'

    if os.path.exists(output_file_path):
        os.remove(output_file_path)
    
    list_input_file_path = [input_folder / f for f in os.listdir(input_folder) if f.startswith('part')]
    merge_many_files_to_one(list_input_file_path, output_file_path)
    return output_file_path


def date_to_timestamp(time_as_string):
    dt_obj = parser.parse(time_as_string)
    return str(int(dt_obj.timestamp() * 1000))


def process_deletion(df, type):
    del_df = df[df['explicitlyDeleted'] == "true"]
    del_df['signal'] = '-'
    del_df['type'] = type

    del_df['deletionDate'] = del_df['deletionDate'].map_partitions(
        lambda series: series.apply(date_to_timestamp),
        meta=('deletionDate', 'str')
    )    

    del_df = del_df[[col for col in del_df.columns if col != 'creationDate']]
    del_df = del_df[[col for col in del_df.columns if col != 'explicitlyDeleted']]
    del_df = del_df.rename(columns={'deletionDate': 'time'})
    return del_df

def process_creation(df, type):
    df['creationDate'] = df['creationDate'].map_partitions(
        lambda series: series.apply(date_to_timestamp),
        meta=('creationDate', 'str')
    )
    df = df.rename(columns={'creationDate': 'time'})
    df = df[[col for col in df.columns if col != 'deletionDate']]
    df = df[[col for col in df.columns if col != 'explicitlyDeleted']]
    df['signal'] = '+'
    df['type'] = type
    return df    

def process_simple_dynamic(path, prefix):
    df = read_csv(path)
    cre_df = process_creation(df, prefix)
    del_df = process_deletion(df, prefix)
    
    df = dd.concat([del_df, cre_df], axis=0)
    to_csv(df, path)


def process_post_tag(dataset_path):
    file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Post_hasTag_Tag')
    df = read_csv(file_path)

    tag_id_to_name = id_to_name(read_csv(dataset_path / 'static' / 'Tag' / 'tag.csv'))
    df['TagName'] = df['TagId'].map(tag_id_to_name)
    df = df[[col for col in df.columns if col != 'TagId']]

    df = process_creation(df, 'PoT')
    to_csv(df, file_path)

    
def process_post(dataset_path):
    file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Post')
    df = read_csv(file_path)

    place_id_to_name = id_to_name(read_csv(dataset_path / 'static' / 'Place' / 'place.csv'))
    df['isLocatedIn'] = df['LocationCountryId'].map(place_id_to_name)
    df = df[[col for col in df.columns if col != 'LocationCountryId']]

    cre_df = process_creation(df, 'Ps')
    del_df = process_deletion(df, 'Ps')
    
    df = dd.concat([del_df, cre_df], axis=0)
    to_csv(df, file_path)
   

def process_person_company(dataset_path):
    file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Person_workAt_Company')
    df = read_csv(file_path)

    un_id_to_name = id_to_name(read_csv(dataset_path / 'static' / 'Organisation' / 'organisation.csv'))
    df['Company'] = df['CompanyId'].map(un_id_to_name)

    df = process_creation(df, 'PC')
    df = df[[col for col in df.columns if col != 'CompanyId']]
    to_csv(df, file_path)


def process_person_university(dataset_path):
    file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Person_studyAt_University')
    df = read_csv(file_path)

    un_id_to_name = id_to_name(read_csv(dataset_path / 'static' / 'Organisation' / 'organisation.csv'))
    df['University'] = df['UniversityId'].map(un_id_to_name)

    df = process_creation(df, 'PU')
    df = df[[col for col in df.columns if col != 'UniversityId']]
    to_csv(df, file_path)
    

def process_person_likes_post(dataset_path):
    file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Person_likes_Post')
    process_simple_dynamic(file_path, 'PPo')


def process_person_likes_comment(dataset_path):
    file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Person_likes_Comment')
    process_simple_dynamic(file_path, 'PCo')


def process_person_knows_person(dataset_path):
    file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Person_knows_Person')
    process_simple_dynamic(file_path, 'PP')


def process_person_tag(dataset_path):
    person_tag_file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Person_hasInterest_Tag')
    person_tag_df = read_csv(person_tag_file_path)

    tag_id_to_name = id_to_name(read_csv(dataset_path / 'static' / 'Tag' / 'tag.csv'))
    person_tag_df['TagName'] = person_tag_df['TagId'].map(tag_id_to_name)

    person_tag_df = process_creation(person_tag_df, 'PT')
    person_tag_df = person_tag_df[[col for col in person_tag_df.columns if col != 'TagId']]
    
    to_csv(person_tag_df, person_tag_file_path)
    

def process_person(dataset_path):
    person_file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Person')
    person_df = read_csv(person_file_path)

    place_id_to_name = id_to_name(read_csv(dataset_path / 'static' / 'Place' / 'place.csv'))
    person_df['isLocatedIn'] = person_df['LocationCityId'].map(place_id_to_name)

    cre_df = process_creation(person_df, 'P')
    cre_df = cre_df[[col for col in cre_df.columns if col != 'LocationCityId']]

    del_df = process_deletion(person_df, 'P')
    del_df = del_df[[col for col in del_df.columns if col != 'LocationCityId']]

    person_df = dd.concat([del_df, cre_df], axis=0)
    to_csv(person_df, person_file_path)


def process_forum_tag(dataset_path):
    forum_tag_file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Forum_hasTag_Tag')
    forum_tag_df = read_csv(forum_tag_file_path)

    tag_id_to_name = id_to_name(read_csv(dataset_path / 'static' / 'Tag' / 'tag.csv'))
    forum_tag_df['TagName'] = forum_tag_df['TagId'].map(tag_id_to_name)

    forum_tag_df = process_creation(forum_tag_df, 'FT')
    forum_tag_df = forum_tag_df[[col for col in forum_tag_df.columns if col != 'TagId']]
    
    to_csv(forum_tag_df, forum_tag_file_path)
    

def process_forum_member(dataset_path):
    forum_member_file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Forum_hasMember_Person')
    process_simple_dynamic(forum_member_file_path, 'FP')


def process_forum(dataset_path):
    forum_file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Forum')
    process_simple_dynamic(forum_file_path, 'F')
    

def process_comment_tag(dataset_path):
    comment_tag_file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Comment_hasTag_Tag')
    comment_tag_df = read_csv(comment_tag_file_path)

    tag_id_to_name = id_to_name(read_csv(dataset_path / 'static' / 'Tag' / 'tag.csv'))
    comment_tag_df['TagName'] = comment_tag_df['TagId'].map(tag_id_to_name)

    cre_df = process_creation(comment_tag_df, 'Ct')
    cre_df = cre_df[[col for col in cre_df.columns if col != 'TagId']]

    to_csv(cre_df, comment_tag_file_path)

    
def process_comment(dataset_path):
    comment_file_path = merge_part_files_to_one(dataset_path / 'dynamic' / 'Comment')
    comment_df = read_csv(comment_file_path)

    place_id_to_name = id_to_name(read_csv(dataset_path / 'static' / 'Place' / 'place.csv'))
    comment_df['isLocatedIn'] = comment_df['LocationCountryId'].map(place_id_to_name)

    cre_df = process_creation(comment_df, 'C')
    cre_df = cre_df[[col for col in cre_df.columns if col != 'LocationCountryId']]

    del_df = process_deletion(comment_df, 'C')
    del_df = del_df[[col for col in del_df.columns if col != 'LocationCountryId']]
    
    comment_df = dd.concat([del_df, cre_df], axis=0)
    to_csv(comment_df, comment_file_path)


def process_tag(dataset_path):
    tag_file_path = merge_part_files_to_one(dataset_path / 'static' / 'Tag')
    tag_df = read_csv(tag_file_path)

    tag_class_df = read_csv(dataset_path / 'static' / 'TagClass' / 'tagclass.csv')
    tag_class_id_to_name = id_to_name(tag_class_df)

    tag_df['TagClass'] = tag_df['TypeTagClassId'].map(tag_class_id_to_name)
    tag_df = tag_df[[col for col in tag_df.columns if col != 'TypeTagClassId']]
    to_csv(tag_df, tag_file_path)


def process_tag_class(dataset_path):
    tag_class_file_path = merge_part_files_to_one(dataset_path / 'static' / 'TagClass')
    tag_class_df = read_csv(tag_class_file_path)

    tag_class_id_to_name = id_to_name(tag_class_df)
    tag_class_df['subClass'] = tag_class_df['SubclassOfTagClassId'].map(tag_class_id_to_name)
    tag_class_df = tag_class_df[[col for col in tag_class_df if col != 'SubclassOfTagClassId']]

    to_csv(tag_class_df, tag_class_file_path)
        
    
def process_organisation(dataset_path):
    org_path_file = merge_part_files_to_one(dataset_path / 'static' / 'Organisation')

    place_df = read_csv(dataset_path / 'static' / 'Place' / 'place.csv')
    place_id_to_name = id_to_name(place_df)

    org_df = read_csv(org_path_file)
    org_df['isLocatedIn'] = org_df['LocationPlaceId'].map(place_id_to_name)
    org_df = org_df[[col for col in org_df.columns if col !='LocationPlaceId']]
    to_csv(org_df, org_path_file)

    
def process_place(dataset_path):
    place_path_file = merge_part_files_to_one(dataset_path / 'static' / 'Place')
    place_df = read_csv(place_path_file)

    place_id_to_name = id_to_name(place_df)
    place_df['isLocatedIn'] = place_df['PartOfPlaceId'].map(place_id_to_name)
    place_df = place_df[[col for col in place_df.columns if col != 'PartOfPlaceId']]
    to_csv(place_df, place_path_file)



def map_strings_to_ids(dataset_path):
    input_file_path_dynamic  = dataset_path / f'dynamic_{dataset_path.name.lower()}.csv'
    input_file_path_static  = dataset_path / f'static_{dataset_path.name.lower()}.csv'

    output_file_path_dynamic = dataset_path / f'dynamic_id_{dataset_path.name.lower()}.csv'
    output_file_path_static  = dataset_path / f'static_id_{dataset_path.name.lower()}.csv'

    df_dynamic = dd.read_csv(input_file_path_dynamic, delimiter='|', dtype=str)
    df_static  = dd.read_csv(input_file_path_static, delimiter='|', dtype=str)

    df_static = df_static[[col for col in df_static.columns if col !='id']]
    df_static = df_static[[col for col in df_static.columns if col !='type']]
    
    keep_original_columns = {'type', 'signal', 'time'}
    unique_strings = set()


    for column in df_static.columns:            
        unique_strings.update(df_static[column].dropna().unique().compute())

    for column in df_dynamic.columns:
        if column not in keep_original_columns:
            unique_strings.update(df_dynamic[column].dropna().unique().compute())

    
    string_to_id = {string: idx for idx, string in enumerate(unique_strings, start=32)}


    def map_value(value):
        if pd.isna(value):
            return value 

        if value not in keep_original_columns:
            return str(string_to_id.get(value, value))  # Map to ID and convert to string

        return value 

    df_static =  df_static.map_partitions(lambda partition: partition.applymap(map_value))
    to_csv(df_static, output_file_path_static)
    
    df_dynamic =  df_dynamic.map_partitions(lambda partition: partition.applymap(map_value))
    to_csv(df_dynamic, output_file_path_dynamic)


def merge_to_one_graph(dataset_path):
    output_file_path_dynamic = dataset_path / f'dynamic_{dataset_path.name.lower()}.csv'
    output_file_path_static  = dataset_path / f'static_{dataset_path.name.lower()}.csv'
    if os.path.exists(output_file_path_dynamic):
        os.remove(output_file_path_dynamic)

    dynamic_list_files = []

    for dir in os.listdir(dataset_path / 'dynamic') : 
        dynamic_list_files.append(dataset_path / 'dynamic' / dir / f'{dir.lower()}.csv')

    dynamic_list_files = [dd.read_csv(file, delimiter='|', dtype=str) for file in dynamic_list_files]
    df_concat = dd.concat(dynamic_list_files, axis=0)
    df_sorted = df_concat.sort_values(by='time')
    to_csv(df_sorted, output_file_path_dynamic )

    static_list_files = []

    for dir in os.listdir(dataset_path / 'static') : 
        static_list_files.append(dataset_path / 'static' / dir / f'{dir.lower()}.csv')

    static_list_files = [dd.read_csv(file, delimiter='|', dtype=str) for file in static_list_files]
    df_concat = dd.concat(static_list_files, axis=0)      
    df_concat.to_csv(output_file_path_static, single_file=True, index=False,  sep='|')  
    to_csv(df_concat, output_file_path_static)

def main():
    parser = argparse.ArgumentParser(description='SNB Data Processor')
    parser.add_argument('factor', type=str, help='Factor = 0.003, 0.1, 1, 3, 10')
    args = parser.parse_args()

    factor = args.factor.replace('.', '_')
    script_path = Path(__file__).parent.resolve()
    dataset_name = f'snb_{factor}'
    dataset_path = script_path / dataset_name 

    #Process static data
    process_place(dataset_path)
    process_organisation(dataset_path)
    process_tag_class(dataset_path)
    process_tag(dataset_path)

    #Process dynamic data
    process_comment(dataset_path)
    process_comment_tag(dataset_path)
    process_forum(dataset_path)
    process_forum_member(dataset_path)
    process_forum_tag(dataset_path)
    process_person(dataset_path)
    process_person_tag(dataset_path)
    process_person_knows_person(dataset_path)
    process_person_likes_comment(dataset_path)
    process_person_likes_post(dataset_path)
    process_person_university(dataset_path)
    process_person_company(dataset_path)
    process_post(dataset_path)
    process_post_tag(dataset_path)

    merge_to_one_graph(dataset_path)
    map_strings_to_ids(dataset_path)
    
if __name__ == '__main__':
    main()