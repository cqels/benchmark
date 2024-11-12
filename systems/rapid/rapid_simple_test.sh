SF=$1
python3 data/ldbc_snb/ldbc_snb_to_graph.py $SF
bash data/ldbc_snb/refine_graph.sh $SF
python3 data/ldbc_snb/ldbc_snb_query_to_graph.py 

SF=$(echo "$SF" | sed 's/\./_/g')
GRAPH_BASE="data/ldbc_snb/static_id_snb_${SF}.g"
echo 
GRAPH_INSE="data/ldbc_snb/dynamic_id_snb_${SF}.g"
GRAPH_QUERY='data/ldbc_snb/queries/snb_ic01.g'

./RapidFlow/build/streaming/RapidFlow.out -d ${GRAPH_BASE} -u ${GRAPH_INSE} -q ${GRAPH_QUERY}
echo







