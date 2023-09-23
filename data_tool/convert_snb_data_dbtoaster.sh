SF=$1

SCRIPT_PATH=$(dirname $(readlink -f $0))
PATH_SNB_DATA='/data/snb_data'
BASE_PATH="${SCRIPT_PATH}/dbtoaster"
TARGET_PATH="${BASE_PATH}/snb_sf${SF}"
SRC_PATH="${PATH_SNB_DATA}/sf${SF}/graphs/csv/raw/composite-merged-fk"
PG_USERNAME="postgres"
PG_PORT="5432"
PG_DATABASE="snb_sf${SF}"
psql_cmd="psql"

echo "SF = ${SF}"
echo "Path to source: ${SRC_PATH}"
echo "Path to target: ${TARGET_PATH}/"

psql_result=$(${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f get_tag_timestamp.sql)
tag_timestamp=$(echo ${psql_result} | awk -v FS=" " '{print $3}')
echo "pick tag_timestamp as ${tag_timestamp}"


raw_window_data_path="${TARGET_PATH}/raw_window"
raw_output_data_path="${TARGET_PATH}/tmp_output"

rm -f pg_tmp.sql
touch pg_tmp.sql
echo "\copy (select * from messageW order by m_op_time asc, m_op desc) to '${raw_window_data_path}/message' DELIMITER '|';" >> pg_tmp.sql
echo "\copy (select * from personW order by p_op_time asc, p_op desc) to '${raw_window_data_path}/person' DELIMITER '|';" >> pg_tmp.sql
echo "\copy (select * from knowsW order by k_op_time asc, k_op desc) to '${raw_window_data_path}/knows' DELIMITER '|';" >> pg_tmp.sql
echo "\copy (select * from message_tagW order by mt_op_time asc, mt_op desc) to '${raw_window_data_path}/messagetag' DELIMITER '|';" >> pg_tmp.sql
echo "\copy (select ${tag_timestamp}, t_tagid, t_name, t_url, t_tagclassid from tag) to '${raw_window_data_path}/tag' DELIMITER '|';" >> pg_tmp.sql

${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f pg_tmp.sql
cp "${raw_window_data_path}/knows" "${raw_window_data_path}/knows1"
cp "${raw_window_data_path}/knows" "${raw_window_data_path}/knows2"

# # snb1
scala ./SnbDataConvertor.scala "${raw_window_data_path}" "knows,message,person" "180" "100" "${raw_output_data_path}" "window"
