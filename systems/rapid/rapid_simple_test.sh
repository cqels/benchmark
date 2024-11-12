#python3 data/ldbc_snb/ldbc_snb_to_graph.py 0.1
python3 data/ldbc_snb/ldbc_snb_query_to_lv_graph.py 

GRAPH_BASE='data/ldbc_snb/static_id_snb_0_1.g'
echo "test/test graph base:"
head ${GRAPH_BASE}
echo 

GRAPH_INSE='data/ldbc_snb/dynamic_id_snb_0_1.g'
echo "test/test graph insert:"
#head ${GRAPH_INSE}
echo 

GRAPH_QUERY='data/ldbc_snb/queries/snb_c_3clique.g'
echo "test query: ${GRAPH_QUERY}"
cat ${GRAPH_QUERY}
#./RapidFlow/build/streaming/RapidFlow.out -d ${GRAPH_BASE} -u ${GRAPH_INSE} -q ${GRAPH_QUERY}
echo







