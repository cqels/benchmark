GRAPH_BASE='symbi_graph_base.g'
GRAPH_INSE='/root/benchmark/systems/symbi/data/ldbc_snb/snb_0_003.g'
#GRAPH_INSE='symbi_graph_insert.g'
GRAPH_QUERY='symbi_graph_query.g'

echo "test graph base:"
cat ${GRAPH_BASE}
echo 

echo "test graph insert:"
cat ${GRAPH_INSE}
echo 
echo

echo "test query:"
cat ${GRAPH_QUERY}
echo 
echo

./SymBi/symbi symbi_graph_base.g ${GRAPH_INSE} symbi_graph_query.g