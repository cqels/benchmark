ALG='sj-tree'
ALG='graphflow'
ALG='iedyn'
ALG='turboflux'
ALG='symbi'

#python3 data/ldbc_snb/ldbc_snb_to_graph.py 0.003
python3 data/ldbc_snb/ldbc_snb_query_to_graph.py 

GRAPH_BASE='data/ldbc_snb/static_id_snb_0_003.g'
echo "test/test graph base:"
head ${GRAPH_BASE}
echo 

GRAPH_INSE='data/ldbc_snb/dynamic_id_snb_0_003.g'
echo "test/test graph insert:"
head ${GRAPH_INSE}
echo 

GRAPH_QUERY='data/ldbc_snb/queries/snb_c_triangle.g'
echo "test query: ${GRAPH_QUERY}"
head ${GRAPH_QUERY}
ContinuousSubgraphMatching/build/csm -q ${GRAPH_QUERY} -d ${GRAPH_BASE} -u ${GRAPH_INSE} -a ${ALG}
echo

# GRAPH_QUERY='data/ldbc_snb/queries/snb_c_3clique.g'
# echo "test query: ${GRAPH_QUERY}"
# head ${GRAPH_QUERY}
# ContinuousSubgraphMatching/build/csm -q ${GRAPH_QUERY} -d ${GRAPH_BASE} -u ${GRAPH_INSE} -a ${ALG}
# echo

# GRAPH_QUERY='data/ldbc_snb/queries/snb_c_4clique.g'
# echo "test query:${GRAPH_QUERY}"
# head ${GRAPH_QUERY}
#ContinuousSubgraphMatching/build/csm -q ${GRAPH_QUERY} -d ${GRAPH_BASE} -u ${GRAPH_INSE} -a ${ALG}
# echo

# GRAPH_QUERY='data/ldbc_snb/queries/snb_c_diamon.g'
# echo "test query: ${GRAPH_QUERY}"
# head ${GRAPH_QUERY}
# ContinuousSubgraphMatching/build/csm -q ${GRAPH_QUERY} -d ${GRAPH_BASE} -u ${GRAPH_INSE} -a ${ALG}
# echo


# GRAPH_QUERY='data/ldbc_snb/queries/snb_c_dumbell.g'
# echo "test query: ${GRAPH_QUERY}"
# head ${GRAPH_QUERY}
# ContinuousSubgraphMatching/build/csm -q ${GRAPH_QUERY} -d ${GRAPH_BASE} -u ${GRAPH_INSE} -a ${ALG}
# echo

# GRAPH_QUERY='data/ldbc_snb/queries/snb_c_retangular.g'
# echo "test query: ${GRAPH_QUERY}"
# head ${GRAPH_QUERY}
# ContinuousSubgraphMatching/build/csm -q ${GRAPH_QUERY} -d ${GRAPH_BASE} -u ${GRAPH_INSE} -a ${ALG}
# echo










