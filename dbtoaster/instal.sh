#befor building make sure Scala 2.11 was installed

BASE_DIR=$(dirname $(readlink -f $0))

build_log_file="${BASE_DIR}/build_dbtoaster.log"

DBTOASTER_HOME="${BASE_DIR}/dbtoaster-backend"

rm -r "${DBTOASTER_HOME}/project/"


cd "${DBTOASTER_HOME}"
sbt clean >> ${build_log_file}
sbt compile >> ${build_log_file} 
sbt release >> ${build_log_file}


#echo $BASE_DIR

#!/bin/bash
#CONFIG_FILES=("${SCRIPT_PATH}/experiment.cfg")
#log_file="${SCRIPT_PATH}/log/prepare-system.log"
# sbt clean >> ${log_file}
# sbt compile >> ${log_file}
# assert "dbtoaster compile failed."

# release_path="${dbtoaster_home}/ddbtoaster/release"
# sbt release >> ${log_file}
# assert "dbtoaster release failed."

# rm -rf "${SCRIPT_PATH}/lib"
# mkdir -p "${SCRIPT_PATH}/lib"
# cp ${release_path}/lib/dbt_scala/dbtoaster*.jar ${SCRIPT_PATH}/lib/
# chmod -Rf g=u "${release_path}"
# chmod -Rf g=u "${SCRIPT_PATH}/lib/"

chmod -Rf g=u "${DBTOASTER_HOME}/target"
chmod -Rf g=u "${DBTOASTER_HOME}/project"