SCALE_FACTOR=$1
SCALE_FACTOR="${SCALE_FACTOR//./_}"

SCRIPT_PATH=$(dirname $(readlink -f $0))

PARENT_DIR=$(dirname $(dirname ${SCRIPT_PATH}))
PATH_SNB_DATA="${PARENT_DIR}/data/snb/snb_${SCALE_FACTOR}"
SRC_PATH="${PATH_SNB_DATA}/graphs/csv/raw/composite-merged-fk"


PG_USERNAME="postgres"
PG_PORT="5432"
PG_DATABASE="snb_sf${SCALE_FACTOR}"
psql_cmd="psql"

TARGET_PATH="${SCRIPT_PATH}/crown_data/crown_snb_${SCALE_FACTOR}"
raw_window_data_path="${TARGET_PATH}/raw_window"
raw_output_data_path="${TARGET_PATH}/ouput"

echo ${TARGET_PATH}

mkdir -p "${TARGET_PATH}"
mkdir -p "${raw_window_data_path}"
mkdir -p "${raw_output_data_path}"

chmod 777 "${raw_window_data_path}"
chmod 777 "${raw_output_data_path}"

mkdir -p "${TARGET_PATH}/snb1_window"
mkdir -p "${TARGET_PATH}/snb2_window"
mkdir -p "${TARGET_PATH}/snb3_window"
mkdir -p "${TARGET_PATH}/snb4_window"

rm -f pg_tmp.sql
touch pg_tmp.sql


psql_result=$(${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f ./get_tag_timestamp.sql)
echo $psql_result
tag_timestamp=$(echo ${psql_result} | awk -v FS=" " '{print $3}')
echo "pick tag_timestamp as ${tag_timestamp}"

echo ${raw_window_data_path}

echo "COPY (select * from messageW order by m_op_time asc, m_op desc) to '${raw_window_data_path}/message' DELIMITER '|';" >> pg_tmp.sql
echo "COPY (select * from personW order by p_op_time asc, p_op desc) to '${raw_window_data_path}/person' DELIMITER '|';" >> pg_tmp.sql
echo "COPY (select * from knowsW order by k_op_time asc, k_op desc) to '${raw_window_data_path}/knows' DELIMITER '|';" >> pg_tmp.sql
echo "COPY (select * from message_tagW order by mt_op_time asc, mt_op desc) to '${raw_window_data_path}/messagetag' DELIMITER '|';" >> pg_tmp.sql
echo "COPY (select ${tag_timestamp}, t_tagid, t_name, t_url, t_tagclassid from tag) to '${raw_window_data_path}/tag' DELIMITER '|';" >> pg_tmp.sql

echo "Know1 Know2"
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f ./pg_tmp.sql
cp "${raw_window_data_path}/knows" "${raw_window_data_path}/knows1"
cp "${raw_window_data_path}/knows" "${raw_window_data_path}/knows2"

echo "snb1"
# snb1
scala ./SnbDataConvertor.scala "${raw_window_data_path}" "knows,message,person" "180" "100" "${raw_output_data_path}" "window"
mv ${raw_output_data_path}/data.csv "${TARGET_PATH}/snb1_window/"

echo "snb2"
# snb2
scala ./SnbDataConvertor.scala "${raw_window_data_path}" "knows1,knows2,message,messagetag,tag" "180" "100" "${raw_output_data_path}" "window"
mv ${raw_output_data_path}/data.csv "${TARGET_PATH}/snb2_window/"

echo "snb3"
# snb3
scala ./SnbDataConvertor.scala "${raw_window_data_path}" "knows1,knows2,message,person" "180" "100" "${raw_output_data_path}" "window"
mv ${raw_output_data_path}/data.csv "${TARGET_PATH}/snb3_window/"

# snb4
echo "snb4"
scala ./SnbDataConvertor.scala "${raw_window_data_path}" "knows,message,messagetag,tag" "180" "100" "${raw_output_data_path}" "window"
mv ${raw_output_data_path}/data.csv "${TARGET_PATH}/snb4_window/"