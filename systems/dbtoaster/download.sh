rm -r dbtoaster
git clone git@github.com:dbtoaster/dbtoaster-backend.git

#Require scala version 2.11

#Build DBToaser back end
#!/bin/bash

#build_log_file='build_dbtoaster.log'

#BASE_DIR=$(dirname $(readlink -f $0))

#echo $BASE_DIR

#rm -r dbtoaster-backend/target
#rm -r dbtoaster-backend/project/target
#rm -r dbtoaster-backend/project/project

#cd "${BASE_DIR}/dbtoaster-backend/"

#sbt clean >> ${build_log_file}
#sbt compile >> ${build_log_file} 
#assert "dbtoaster compile failed."

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

# chmod -Rf g=u "${dbtoaster_home}/target"
# chmod -Rf g=u "${dbtoaster_home}/project"