from pathlib import Path
import os
import json
import re

def convert_to_graph_query(input_file, output_file):
    content = ''
    result = ''

    # Read the content of the input file
    with open(input_file, 'r') as file:
        content = file.read()

    # Filter out empty lines and comments
    lines = content.strip().split('\n')
    content = ''
    
    for line in lines:
        if not line or line.startswith('#'):
            continue
        content += line + '\n'

    # Identify variables in the content and create a mapping to unique IDs
    variables = sorted(set(re.findall(r'\?\w+', content)))
    var_to_id = {var: idx for idx, var in enumerate(variables, start=0)}

    # Initialize vertices_map and edges
    vertices_map = {}
    edges = ''
    lines = content.strip().split('\n')

    # Process each line to populate vertices_map and edges based on relationships
    for line in lines:
        if not line or line.startswith('#'):
            continue

        nodes = line.strip().split(' ')

        try:
            start_id = var_to_id[nodes[0]]
            end_id = var_to_id[nodes[2]]

            # Perform actions based on the relationship type
            if nodes[1] == ":knows":
                vertices_map[start_id] = CLS_MAP['Person']
                vertices_map[end_id] = CLS_MAP['Person']
                edges += f'{start_id} {end_id} 0 \n'

            elif nodes[1] == "isA":
                print(f"Handling 'isA' relationship between {start_id} and {end_id}")

            elif nodes[1] == "hasGender":
                print(f"Handling 'hasGender' relationship between {start_id} and {end_id}")

            elif nodes[1] == "hasBirthday":
                print(f"Handling 'hasBirthday' relationship between {start_id} and {end_id}")

            elif nodes[1] == "hasLocationIP":
                print(f"Handling 'hasLocationIP' relationship between {start_id} and {end_id}")

            elif nodes[1] == "usedBrowser":
                print(f"Handling 'usedBrowser' relationship between {start_id} and {end_id}")

            elif nodes[1] == "spokenLanguage":
                print(f"Handling 'spokenLanguage' relationship between {start_id} and {end_id}")

            elif nodes[1] == "hasEmail":
                print(f"Handling 'hasEmail' relationship between {start_id} and {end_id}")

            elif nodes[1] == ":likes":
                vertices_map[start_id] = CLS_MAP['Person']
                vertices_map[end_id] = CLS_MAP['Message']
                edges += f'{start_id} {end_id} 0 \n'
                print(f"Handling 'likes' relationship between {start_id} and {end_id}")

            elif nodes[1] == "hasMember":
                print(f"Handling 'hasMember' relationship between {start_id} and {end_id}")

            elif nodes[1] == "writtenLanguage":
                print(f"Handling 'writtenLanguage' relationship between {start_id} and {end_id}")

            elif nodes[1] == "hasTitle":
                print(f"Handling 'hasTitle' relationship between {start_id} and {end_id}")

            elif nodes[1] == "hasModerator":
                print(f"Handling 'hasModerator' relationship between {start_id} and {end_id}")

            elif nodes[1] == "imageFile":
                print(f"Handling 'imageFile' relationship between {start_id} and {end_id}")

            elif nodes[1] == "hasContent":
                print(f"Handling 'hasContent' relationship between {start_id} and {end_id}")

            elif nodes[1] == "contentLength":
                print(f"Handling 'contentLength' relationship between {start_id} and {end_id}")

            elif nodes[1] == ":hasCreator":
                vertices_map[start_id] = CLS_MAP['Message']
                vertices_map[end_id] = CLS_MAP['Person']
                edges += f'{start_id} {end_id} 0 \n'

            elif nodes[1] == "isLocatedIn":
                print(f"Handling 'isLocatedIn' relationship between {start_id} and {end_id}")

            elif nodes[1] == "isReplyOf":
                print(f"Handling 'isReplyOf' relationship between {start_id} and {end_id}")

            elif nodes[1] == ":hasTag":
                vertices_map[start_id] = CLS_MAP['Message']
                vertices_map[end_id] = CLS_MAP['Tag']
                edges += f'{start_id} {end_id} 0 \n'
                print(f"Handling 'hasTag' relationship between {start_id} and {end_id}")

            elif nodes[1] == ":hasInterest":
                vertices_map[start_id] = CLS_MAP['Person']
                vertices_map[end_id] = CLS_MAP['Tag']
                edges += f'{start_id} {end_id} 0 \n'
                print(f"Handling 'hasInterest' relationship between {start_id} and {end_id}")

            elif nodes[1] == "containerOf":
                print(f"Handling 'containerOf' relationship between {start_id} and {end_id}")

            elif nodes[1] == "studyAt":
                print(f"Handling 'studyAt' relationship between {start_id} and {end_id}")

            elif nodes[1] == "studyFrom":
                print(f"Handling 'studyFrom' relationship between {start_id} and {end_id}")

            elif nodes[1] == "workAt":
                print(f"Handling 'workAt' relationship between {start_id} and {end_id}")

            elif nodes[1] == "workFrom":
                print(f"Handling 'workFrom' relationship between {start_id} and {end_id}")

            elif nodes[1] == "hasURL":
                print(f"Handling 'hasURL' relationship between {start_id} and {end_id}")

            elif nodes[1] == "isSubClassOf":
                print(f"Handling 'isSubClassOf' relationship between {start_id} and {end_id}")

            elif nodes[1] == "isPartOf":
                print(f"Handling 'isPartOf' relationship between {start_id} and {end_id}")

        except KeyError as e:
            print(f"Error: Missing key {e} in var_to_id or REL_MAP. Skipping line: {line}")

    # Sort vertices_map by vertex ID and build the vertices string
    sorted_vertices_map = sorted(vertices_map.items(), key=lambda item: item[0])

    vertices = ''
    for vertex, class_id in sorted_vertices_map:
        vertices += f'{vertex} {class_id}\n'

    result = vertices + edges

    # Write the result to the output file
    with open(output_file, 'w') as file:
        file.write(result)

def main():
    script_path = Path(__file__).parent.resolve()

    global_snb_data_path = script_path.parents[3] / 'data' / 'ldbc_snb' 
    global_snb_query_path = global_snb_data_path / 'queries'

    query_folder_path = script_path / 'queries'

    if not os.path.exists(query_folder_path):
        os.makedirs(query_folder_path)

    global REL_MAP 
    with open(global_snb_data_path / 'rel_map.json', 'r') as file:
        REL_MAP = json.load(file)

    global CLS_MAP
    with open(global_snb_data_path / 'class_map.json', 'r') as file:
        CLS_MAP = json.load(file)

    print("CLS_MAP:", CLS_MAP)

    ldbc_query_files = sorted(global_snb_query_path.iterdir(), key=lambda f: f.name)

    for ldbc_query_file in ldbc_query_files:
        if os.path.isfile(ldbc_query_file):    
            query_file = ldbc_query_file.name.replace('.q', '.g')
            query_file_path = query_folder_path / query_file
            convert_to_graph_query(ldbc_query_file, query_file_path)
            print("Generated:", query_file_path)

if __name__ == '__main__':
    main()
