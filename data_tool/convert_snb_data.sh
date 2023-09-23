#!/bin/bash

#script path
SCRIPT_PATH=$(dirname $(readlink -f $0))
PATH_SNB_DATA='/data/snb_data'

echo $SCRIPT_PATH

SF=$1
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

if [ -d "${TARGET_PATH}" ] 
then
   rm -r "${TARGET_PATH}"
fi

mkdir -p "${TARGET_PATH}"

if [ -f "convert_snb_data.log" ]
then 
    rm "convert_snb_data.log"
fi


echo "drop database" >> convert_snb_data.log
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -c "DROP DATABASE ${PG_DATABASE}" >> convert_snb_data.log

echo "list all databases" >> convert_snb_data.log
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -c "SELECT datname FROM pg_database;" >> convert_snb_data.log


echo "create database" >> convert_snb_data.log
 ${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -c "CREATE DATABASE ${PG_DATABASE}" >> convert_snb_data.log

echo "list all databases" >> convert_snb_data.log
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -c "SELECT datname FROM pg_database;" >> convert_snb_data.log


echo "create tables in pg" >> convert_snb_data.log
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f create_snb_tables.sql >> convert_snb_data.log

rm -f pg_tmp.sql
touch pg_tmp.sql


comment_files=$(find "${SRC_PATH}/dynamic/Comment" -name "part*.csv" | head)
for comment_file in ${comment_files[@]}; do
	echo "copy message from ${comment_file}"
 	echo "COPY message (m_creationdate, m_deletionDate, m_explicitlyDeleted, m_messageid, m_locationip, m_browserused, m_content, m_length, m_creatorid, m_locationid, m_c_parentpostid, m_c_replyof) FROM '${comment_file}' WITH DELIMITER '|' CSV HEADER;" >> pg_tmp.sql
done

post_files=$(find "${SRC_PATH}/dynamic/Post" -name "part*.csv" | head)
for post_file in ${post_files[@]}; do
   echo "copy message from ${post_file}"
   echo "COPY message (m_creationdate, m_deletionDate, m_explicitlyDeleted, m_messageid, m_ps_imagefile, m_locationip, m_browserused, m_ps_language, m_content, m_length, m_creatorid, m_ps_forumid, m_locationid) FROM '${post_file}' WITH DELIMITER '|' CSV HEADER;" >> pg_tmp.sql
done

person_files=$(find "${SRC_PATH}/dynamic/Person" -name "part*.csv" | head)
for person_file in ${person_files[@]}; do
   echo "copy person from ${person_file}"
   echo "COPY person FROM '${person_file}' WITH DELIMITER '|' CSV HEADER;" >> pg_tmp.sql
done

knows_files=$(find "${SRC_PATH}/dynamic/Person_knows_Person" -name "part*.csv" | head)
for knows_file in ${knows_files[@]}; do
  echo "copy knows from ${knows_file}"
  echo "COPY knows ( k_creationdate, k_deletiondate, k_explicitlyDeleted, k_person1id, k_person2id) FROM '${knows_file}' WITH DELIMITER '|' CSV HEADER;" >> pg_tmp.sql
  echo "COPY knows ( k_creationdate, k_deletiondate, k_explicitlyDeleted, k_person2id, k_person1id) FROM '${knows_file}' WITH DELIMITER '|' CSV HEADER;" >> pg_tmp.sql
done

message_tag_files=$(find "${SRC_PATH}/dynamic/Post_hasTag_Tag" -name "part*.csv" | head)
for message_tag_file in ${message_tag_files[@]}; do
  echo "copy message_tag from ${message_tag_file}"
  echo "COPY message_tag FROM '${message_tag_file}' WITH DELIMITER '|' CSV HEADER;" >> pg_tmp.sql
done

message_tag2_files=$(find "${SRC_PATH}/dynamic/Forum_hasTag_Tag" -name "part*.csv" | head)
for message_tag2_file in ${message_tag2_files[@]}; do
  echo "copy message_tag from ${message_tag2_file}"
  echo "COPY message_tag FROM '${message_tag2_file}' WITH DELIMITER '|' CSV HEADER;" >> pg_tmp.sql
done

tag_files=$(find "${SRC_PATH}/static/Tag" -name "part*.csv" | head)
for tag_file in ${tag_files[@]}; do
  echo "copy tag from ${tag_file}"
  echo "COPY tag FROM '${tag_file}' WITH DELIMITER '|' CSV HEADER;" >> pg_tmp.sql
done

echo "execute load data sql"
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f pg_tmp.sql

echo "execute convert data sql"
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f convert_data.sql

psql_result=$(${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f get_tag_timestamp.sql)
tag_timestamp=$(echo ${psql_result} | awk -v FS=" " '{print $3}')
echo "pick tag_timestamp as ${tag_timestamp}"

# first create raw data for acq(D/F), dbt(spark/cpp)
raw_window_data_path="${TARGET_PATH}/raw_window"
raw_output_data_path="${TARGET_PATH}/tmp_output"
mkdir -m777 -p "${raw_window_data_path}"
mkdir -m777 -p "${raw_output_data_path}"

# acq_data_path="${TARGET_PATH}/crown"
# mkdir -p "${acq_data_path}" 
# mkdir -p "${acq_data_path}/SNBQ1_window"
# mkdir -p "${acq_data_path}/SNBQ2_window"
# mkdir -p "${acq_data_path}/SNBQ3_window"
# mkdir -p "${acq_data_path}/SNBQ4_window"

# window
# rm -f pg_tmp.sql
# touch pg_tmp.sql

# echo "\copy (select * from messageW order by m_op_time asc, m_op desc) to '${raw_window_data_path}/message' DELIMITER '|';" >> pg_tmp.sql
# echo "\copy (select * from personW order by p_op_time asc, p_op desc) to '${raw_window_data_path}/person' DELIMITER '|';" >> pg_tmp.sql
# echo "\copy (select * from knowsW order by k_op_time asc, k_op desc) to '${raw_window_data_path}/knows' DELIMITER '|';" >> pg_tmp.sql
# echo "\copy (select * from message_tagW order by mt_op_time asc, mt_op desc) to '${raw_window_data_path}/messagetag' DELIMITER '|';" >> pg_tmp.sql
# echo "\copy (select ${tag_timestamp}, t_tagid, t_name, t_url, t_tagclassid from tag) to '${raw_window_data_path}/tag' DELIMITER '|';" >> pg_tmp.sql

# ${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f pg_tmp.sql
# cp "${raw_window_data_path}/knows" "${raw_window_data_path}/knows1"
# cp "${raw_window_data_path}/knows" "${raw_window_data_path}/knows2"

# # snb1
# scala ./SnbDataConvertor.scala "${raw_window_data_path}" "knows,message,person" "180" "100" "${raw_output_data_path}" "window"
# # mv ${raw_output_data_path}/dbtoaster_cpp* "${dbtcpp_data_path}/snb1_window/"
# # mv ${raw_output_data_path}/dbtoaster* "${dbt_data_path}/snb1_window/"
# # mv ${raw_output_data_path}/enum* "${dbt_data_path}/snb1_window/"
# mv ${raw_output_data_path}/data.csv "${acq_data_path}/SNBQ1_window/"

# # snb2
# scala ./SnbDataConvertor.scala "${raw_window_data_path}" "knows1,knows2,message,messagetag,tag" "180" "100" "${raw_output_data_path}" "window"
# # mv ${raw_output_data_path}/dbtoaster_cpp* "${dbtcpp_data_path}/snb2_window/"
# # mv ${raw_output_data_path}/dbtoaster* "${dbt_data_path}/snb2_window/"
# # mv ${raw_output_data_path}/enum* "${dbt_data_path}/snb2_window/"
# mv ${raw_output_data_path}/data.csv "${acq_data_path}/SNBQ2_window/"

# # snb3
# scala ./SnbDataConvertor.scala "${raw_window_data_path}" "knows1,knows2,message,person" "180" "100" "${raw_output_data_path}" "window"
# # mv ${raw_output_data_path}/dbtoaster_cpp* "${dbtcpp_data_path}/snb3_window/"
# # mv ${raw_output_data_path}/dbtoaster* "${dbt_data_path}/snb3_window/"
# # mv ${raw_output_data_path}/enum* "${dbt_data_path}/snb3_window/"
# mv ${raw_output_data_path}/data.csv "${acq_data_path}/SNBQ3_window/"

# # snb4
# scala ./SnbDataConvertor.scala "${raw_window_data_path}" "knows,message,messagetag,tag" "180" "100" "${raw_output_data_path}" "window"
# # mv ${raw_output_data_path}/dbtoaster_cpp* "${dbtcpp_data_path}/snb4_window/"
# # mv ${raw_output_data_path}/dbtoaster* "${dbt_data_path}/snb4_window/"
# # mv ${raw_output_data_path}/enum* "${dbt_data_path}/snb4_window/"
# mv ${raw_output_data_path}/data.csv "${acq_data_path}/SNBQ4_window/"

# # # arbitrary
# # rm -f pg_tmp.sql
# # touch pg_tmp.sql

# # echo "COPY (select * from messageT order by m_op_time asc, m_op desc) to '${raw_arbitrary_data_path}/message' DELIMITER '|';" >> pg_tmp.sql
# # echo "COPY (select * from personT order by p_op_time asc, p_op desc) to '${raw_arbitrary_data_path}/person' DELIMITER '|';" >> pg_tmp.sql
# # echo "COPY (select * from knowsT order by k_op_time asc, k_op desc) to '${raw_arbitrary_data_path}/knows' DELIMITER '|';" >> pg_tmp.sql
# # echo "COPY (select * from message_tagT order by mt_op_time asc, mt_op desc) to '${raw_arbitrary_data_path}/messagetag' DELIMITER '|';" >> pg_tmp.sql
# # echo "COPY (select ${tag_timestamp}, t_tagid, t_name, t_url, t_tagclassid from tag) to '${raw_arbitrary_data_path}/tag' DELIMITER '|';" >> pg_tmp.sql

# # ${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f ./pg_tmp.sql
# # cp "${raw_arbitrary_data_path}/knows" "${raw_arbitrary_data_path}/knows1"
# # cp "${raw_arbitrary_data_path}/knows" "${raw_arbitrary_data_path}/knows2"

# # # snb1
# # scala ./SnbDataConvertor.scala "${raw_arbitrary_data_path}" "knows,message,person" "180" "100" "${raw_output_data_path}" "arbitrary"
# # mv ${raw_output_data_path}/dbtoaster_cpp* "${dbtcpp_data_path}/snb1_arbitrary/"
# # mv ${raw_output_data_path}/dbtoaster* "${dbt_data_path}/snb1_arbitrary/"
# # mv ${raw_output_data_path}/enum* "${dbt_data_path}/snb1_arbitrary/"
# # mv ${raw_output_data_path}/data.csv "${acq_data_path}/snb1_arbitrary/"

# # # snb2
# # scala ./SnbDataConvertor.scala "${raw_arbitrary_data_path}" "knows1,knows2,message,messagetag,tag" "180" "100" "${raw_output_data_path}" "arbitrary"
# # mv ${raw_output_data_path}/dbtoaster_cpp* "${dbtcpp_data_path}/snb2_arbitrary/"
# # mv ${raw_output_data_path}/dbtoaster* "${dbt_data_path}/snb2_arbitrary/"
# # mv ${raw_output_data_path}/enum* "${dbt_data_path}/snb2_arbitrary/"
# # mv ${raw_output_data_path}/data.csv "${acq_data_path}/snb2_arbitrary/"

# # # snb3
# # scala ./SnbDataConvertor.scala "${raw_arbitrary_data_path}" "knows1,knows2,message,person" "180" "100" "${raw_output_data_path}" "arbitrary"
# # mv ${raw_output_data_path}/dbtoaster_cpp* "${dbtcpp_data_path}/snb3_arbitrary/"
# # mv ${raw_output_data_path}/dbtoaster* "${dbt_data_path}/snb3_arbitrary/"
# # mv ${raw_output_data_path}/enum* "${dbt_data_path}/snb3_arbitrary/"
# # mv ${raw_output_data_path}/data.csv "${acq_data_path}/snb3_arbitrary/"

# # # snb4
# # scala ./SnbDataConvertor.scala "${raw_arbitrary_data_path}" "knows,message,messagetag,tag" "180" "100" "${raw_output_data_path}" "arbitrary"
# # mv ${raw_output_data_path}/dbtoaster_cpp* "${dbtcpp_data_path}/snb4_arbitrary/"
# # mv ${raw_output_data_path}/dbtoaster* "${dbt_data_path}/snb4_arbitrary/"
# # mv ${raw_output_data_path}/enum* "${dbt_data_path}/snb4_arbitrary/"
# # mv ${raw_output_data_path}/data.csv "${acq_data_path}/snb4_arbitrary/"