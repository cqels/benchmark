#!/bin/bash

# Set the scaling factor
SF=$1

# Run initial Python scripts and refinement bash script
python3 data/ldbc_snb/ldbc_snb_to_graph.py "$SF"
bash data/ldbc_snb/refine_graph.sh "$SF"
python3 data/ldbc_snb/ldbc_snb_query_to_graph.py 

# Replace '.' with '_' in scaling factor for filenames
SF=$(echo "$SF" | sed 's/\./_/g')

# Define paths for the graph files
GRAPH_BASE="data/ldbc_snb/static_id_snb_${SF}.g"
GRAPH_INSE="data/ldbc_snb/dynamic_id_snb_${SF}.g"

# Define the list of query files
queries=(
    "snb_c_triangle.g"
    "snb_c_3clique.g"
    "snb_c_4clique.g"
    "snb_c_diamon.g"
    "snb_c_dumbell.g"
    "snb_c_retangular.g"
)

# Loop through each query and run the RapidFlow command
for query in "${queries[@]}"; do
    GRAPH_QUERY="data/ldbc_snb/queries/${query}"
    ./RapidFlow/build/streaming/RapidFlow.out -d "${GRAPH_BASE}" -u "${GRAPH_INSE}" -q "${GRAPH_QUERY}"
    echo
done
