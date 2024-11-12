SF=$1
SF=$(echo "$SF" | sed 's/\./_/g')

SCRIPT_PATH=$(dirname $(readlink -f $0))

STATIC_FILE="${SCRIPT_PATH}/static_id_snb_${SF}.g"
echo $STATIC_FILE
DYNAMIC_FILE="${SCRIPT_PATH}/dynamic_id_snb_${SF}.g"
echo $DYNAMIC_FILE

grep '^v' ${DYNAMIC_FILE} > temp_vertices.g
cat temp_vertices.g ${STATIC_FILE} > temp_static.g
mv temp_static.g ${STATIC_FILE}
rm temp_vertices.g

grep '^e' ${DYNAMIC_FILE} > temp_edges.g
mv temp_edges.g ${DYNAMIC_FILE}

awk '!seen[$0]++' ${STATIC_FILE} > temp_file.txt && mv temp_file.txt ${STATIC_FILE}
