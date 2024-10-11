v 0 0 
v 1 0 
v 2 0  
e 0 1 4  
e 0 2 5 .,/

echo "test query:"
cat ${GRAPH_QUERY}
echo 
echo

ContinuousSubgraphMatching/build/csm -q ${GRAPH_QUERY} -d ${GRAPH_BASE} -u ${GRAPH_INSE} -a ${ALG} 