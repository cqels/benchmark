echo "test graph base:"
cat symbi_graph_base.g
echo 

echo "test graph insert:"
cat symbi_graph_insert.g
echo 
echo

echo "test query:"
cat symbi_graph_query.g
echo 
echo

./SymBi/symbi symbi_graph_base.g symbi_graph_insert.g symbi_graph_query.g