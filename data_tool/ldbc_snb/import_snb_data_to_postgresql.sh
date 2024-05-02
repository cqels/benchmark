#!/bin/bash
SCALE_FACTOR=$1
SCALE_FACTOR="${SCALE_FACTOR//./_}"

SCRIPT_PATH=$(dirname $(readlink -f $0))

PARENT_DIR=$(dirname $(dirname ${SCRIPT_PATH}))
PATH_SNB_DATA="${PARENT_DIR}/data/snb/snb_${SCALE_FACTOR}"
SRC_PATH="${PATH_SNB_DATA}/graphs/csv/raw/composite-merged-fk"

#echo $PATH_SNB_DATA

#BASE_PATH="${SCRIPT_PATH}/snb"
#TARGET_PATH="${BASE_PATH}/snb_${SCALE_FACTOR}"

PG_USERNAME="postgres"
PG_PORT="5432"
PG_DATABASE="snb_sf${SCALE_FACTOR}"
psql_cmd="psql"

if [ ! -d ${SRC_PATH} ];
then
  echo "Path ${SRC_PATH} is not found"
  echo "Scale factor may be missed"
  echo "ex: bash import_snb_data_to_postgresql.sh 1"
  exit 0  
fi

echo "SCALE_FACTOR = ${SCALE_FACTOR}"
echo "Path to source: ${SRC_PATH}"
# echo "Path to target: ${TARGET_PATH}/"

# if [ -d "${TARGET_PATH}" ] 
# then
#    rm -r "${TARGET_PATH}"
# else 
#    mkdir -m777 -p "${TARGET_PATH}"
# fi

#Create new database
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -c "DROP DATABASE ${PG_DATABASE};"  >> /dev/null

${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -c "CREATE DATABASE ${PG_DATABASE};" >> /dev/null

#Create table
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f "${SCRIPT_PATH}/sql/create_snb_tables.sql"  >> /dev/null

#Common -> Message
rm -f /tmp/*.sql
comment_files=$(find "${SRC_PATH}/dynamic/Comment" -name "part*.csv" | head)
for comment_file in ${comment_files[@]}; do
	echo "copy message from ${comment_file}"
 	echo "COPY message (m_creationdate, m_deletionDate, m_explicitlyDeleted, \
                      m_messageid, m_locationip, m_browserused, m_content, m_length, \
                      m_creatorid, m_locationid, m_c_parentpostid, m_c_replyof) \
                      FROM '${comment_file}' WITH DELIMITER '|' CSV HEADER;" >> /tmp/pg_tmp.sql
done

#Person
post_files=$(find "${SRC_PATH}/dynamic/Post" -name "part*.csv" | head)
for post_file in ${post_files[@]}; do
   echo "copy message from ${post_file}"
   echo "COPY message (m_creationdate, m_deletionDate, m_explicitlyDeleted, \
                       m_messageid, m_ps_imagefile, m_locationip, m_browserused, \
                       m_ps_language, m_content, m_length, m_creatorid, m_ps_forumid, m_locationid) \
                       FROM '${post_file}' WITH DELIMITER '|' CSV HEADER;" >> /tmp/pg_tmp.sql
done

person_files=$(find "${SRC_PATH}/dynamic/Person" -name "part*.csv" | head)
for person_file in ${person_files[@]}; do
   echo "copy person from ${person_file}"
   echo "COPY person FROM '${person_file}' WITH DELIMITER '|' CSV HEADER;" >> /tmp/pg_tmp.sql
done


knows_files=$(find "${SRC_PATH}/dynamic/Person_knows_Person" -name "part*.csv" | head)
for knows_file in ${knows_files[@]}; do
  echo "COPY knows ( k_creationdate, k_deletiondate, k_explicitlyDeleted, k_person1id, k_person2id) \
  FROM '${knows_file}' WITH DELIMITER '|' CSV HEADER;" >> /tmp/pg_tmp.sql
  echo "COPY knows ( k_creationdate, k_deletiondate, k_explicitlyDeleted, k_person2id, k_person1id) \
  FROM '${knows_file}' WITH DELIMITER '|' CSV HEADER;" >> /tmp/pg_tmp.sql
done


message_tag_files=$(find "${SRC_PATH}/dynamic/Post_hasTag_Tag" -name "part*.csv" | head)
for message_tag_file in ${message_tag_files[@]}; do
  echo "copy message_tag from ${message_tag_file}"
  echo "COPY message_tag FROM '${message_tag_file}' WITH DELIMITER '|' CSV HEADER;" >> /tmp/pg_tmp.sql
done

message_tag2_files=$(find "${SRC_PATH}/dynamic/Forum_hasTag_Tag" -name "part*.csv" | head)
for message_tag2_file in ${message_tag2_files[@]}; do
  echo "copy message_tag from ${message_tag2_file}"
  echo "COPY message_tag FROM '${message_tag2_file}' WITH DELIMITER '|' CSV HEADER;" >> /tmp/pg_tmp.sql
done

tag_files=$(find "${SRC_PATH}/static/Tag" -name "part*.csv" | head)
for tag_file in ${tag_files[@]}; do
  echo "copy tag from ${tag_file}"
  echo "COPY tag FROM '${tag_file}' WITH DELIMITER '|' CSV HEADER;" >> /tmp/pg_tmp.sql
done

echo "execute load data sql"
cat /tmp/pg_tmp.sql
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f /tmp/pg_tmp.sql >> /dev/null
${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f ${SCRIPT_PATH}/sql/convert_data.sql >> /dev/null

# echo "execute convert data sql"
# ${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f "${SCRIPT_PATH}/sql/message.sql"       >> /dev/null
# ${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f "${SCRIPT_PATH}/sql/person.sql"        >> /dev/null
# ${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f "${SCRIPT_PATH}/sql/knows.sql"         >> /dev/null
# ${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f "${SCRIPT_PATH}/sql/message-tag.sql"   >> /dev/null



# # window
# rm -f /tmp/pg_tmp.sql
# touch /tmp/pg_tmp.sql

# echo "\copy (select * from messageT order by m_op_time asc, m_op desc) \
#  to '${TARGET_PATH}/message' DELIMITER '|';" >> /tmp/pg_tmp.sql

# echo "\copy (select * from personT order by p_op_time asc, p_op desc) \
#  to '${TARGET_PATH}/person' DELIMITER '|';" >> /tmp/pg_tmp.sql

# echo "\copy (select * from knowsT order by k_op_time asc, k_op desc) \
#  to '${TARGET_PATH}/knows' DELIMITER '|';" >> /tmp/pg_tmp.sql

# echo "\copy (select * from message_tagT order by mt_op_time asc, mt_op desc) \
#  to '${TARGET_PATH}/message_tag' DELIMITER '|';" >> /tmp/pg_tmp.sql

# echo "\copy (select t_tagid, t_name, t_url, t_tagclassid from tag) \
#  to '${TARGET_PATH}/tag' DELIMITER '|';" >> /tmp/pg_tmp.sql

# ${psql_cmd} -p "${PG_PORT}" -U "${PG_USERNAME}" -d "${PG_DATABASE}" -f /tmp/pg_tmp.sql >> /dev/null

# cp "${TARGET_PATH}/knows" "${TARGET_PATH}/knows1"
# cp "${TARGET_PATH}/knows" "${TARGET_PATH}/knows2"