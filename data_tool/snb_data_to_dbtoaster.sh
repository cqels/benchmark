SF=$1

SCRIPT_PATH=$(dirname $(readlink -f $0))
# PATH_SNB_DATA='/data/snb_data'
BASE_PATH="${SCRIPT_PATH}/dbtoaster"
TARGET_PATH="${BASE_PATH}/snb_sf${SF}"
# SRC_PATH="${PATH_SNB_DATA}/sf${SF}/graphs/csv/raw/composite-merged-fk"
# PG_USERNAME="postgres"
# PG_PORT="5432"
# PG_DATABASE="snb_sf${SF}"
# psql_cmd="psql"

echo "SF = ${SF}"
#echo "Path to source: ${SRC_PATH}"
echo "Path to target: ${TARGET_PATH}/"

raw_window_data_path="${TARGET_PATH}/raw_window"
raw_output_data_path="${TARGET_PATH}/tmp_output"

# snb1
scala -nobootcp -nc ./SnbDataConvertor.scala "${raw_window_data_path}" "knows,message,person" "180" "100" "${raw_output_data_path}" "window"
mkdir "${TARGET_PATH}/snb1/"
mv ${raw_output_data_path}/dbtoaster* "${TARGET_PATH}/snb1/"

# snb2
scala -nobootcp -nc ./SnbDataConvertor.scala "${raw_window_data_path}" "knows1,knows2,message,messagetag,tag" "180" "100" "${raw_output_data_path}" "window"
mkdir "${TARGET_PATH}/snb2/"
mv ${raw_output_data_path}/dbtoaster* "${TARGET_PATH}/snb2/"

# snb3
scala -nobootcp -nc ./SnbDataConvertor.scala "${raw_window_data_path}" "knows1,knows2,message,person" "180" "100" "${raw_output_data_path}" "window"
mkdir "${TARGET_PATH}/snb3/"
mv ${raw_output_data_path}/dbtoaster* "${TARGET_PATH}/snb3/"

# snb4
scala -nobootcp -nc ./SnbDataConvertor.scala "${raw_window_data_path}" "knows,message,messagetag,tag" "180" "100" "${raw_output_data_path}" "window"
mkdir "${TARGET_PATH}/snb4/"
mv ${raw_output_data_path}/dbtoaster* "${TARGET_PATH}/snb4/"
