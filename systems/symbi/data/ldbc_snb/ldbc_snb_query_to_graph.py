from pathlib import Path
import os
import json

import re

def convert_to_graph_query(input_file, output_file):
    content = ''
    result = ''

    with open(input_file, 'r') as file:
        content = file.read()

    lines = content.strip().split('\n')
    content = ''
    
    for line in lines:
        if not line or line.startswith('#'):
            continue
        content = content + line + '\n'

    variables = sorted(set(re.findall(r'\?\w+', content)))
    var_to_id = {var: idx for idx, var in enumerate(variables, start = 0)}

    for var, id in var_to_id.items():
        result = result + f'v {id} 0 -1\n'

    lines = content.strip().split('\n')

    for line in lines:
        if not line or line.startswith('#'):
            continue

        nodes = line.strip().split(' ')
        result = result + f"e {var_to_id[nodes[0]]} {var_to_id[nodes[2]]} {REL_MAP[nodes[1]]}\n"
    
    with open(output_file, 'w') as file:
        file.write(f'{result}')            
   
def main():
    script_path = Path(__file__).parent.resolve()

    global_snb_data_path        = script_path.parents[3] / 'data' / 'ldbc_snb' 
    global_snb_query_path       = global_snb_data_path / 'queries'

    system_symbi_path           = script_path.parents[3] / 'systems' / 'symbi'
    system_symbi_query_path     = system_symbi_path / 'data/ldbc_snb/queries'

    global REL_MAP 
    with open(global_snb_data_path / 'rel_map.json', 'r') as file:
        REL_MAP = json.load(file)

    query_files = sorted(global_snb_query_path.iterdir(), key=lambda f: f.name);

    for query_file in query_files:
        if (os.path.isfile(query_file)):    
            symbi_query_file = query_file.name.replace('.q', '.g')
            symbi_query_path = system_symbi_query_path / symbi_query_file
            convert_to_graph_query(query_file, symbi_query_path)

        
if __name__ == '__main__':
    main()
