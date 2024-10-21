GRAPH_BASE='data/ldbc_snb/static_id_snb_0_003.g'
GRAPH_INSE='data/ldbc_snb/dynamic_id_snb_0_003.g'
GRAPH_QUERY='data/ldbc_snb/queries/snb_bi03.g'

echo "test/test graph base:"
head ${GRAPH_BASE}
echo 

echo "test/test graph insert:"
head ${GRAPH_INSE}
echo 
echo

echo "test query:"
head ${GRAPH_QUERY}
echo 
echo

./SymBi/symbi ${GRAPH_BASE} ${GRAPH_INSE} ${GRAPH_QUERY}