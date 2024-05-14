SCRIPT_PATH=$(dirname $(readlink -f $0))
FILE_QUERY_PATH=$1

FILE_QUERY=$(basename ${FILE_QUERY_PATH})
R="R${FILE_QUERY%.*}"

${SCRIPT_PATH}/dbtoaster-backend/ddbtoaster/release/bin/dbtoaster -l scala -o "${R}" "${FILE_QUERY_PATH}" 

mv "${SCRIPT_PATH}/${R}.scala" "src/main/scala/ddbt/gen/"
cp "${SCRIPT_PATH}/build.sbt.template" "${SCRIPT_PATH}/build.sbt"

sed -i "s/name/name := \"${R}\"/" $SCRIPT_PATH/build.sbt
sed -i "s/mainClass/mainClass in Compile := Some(\"ddbt.gen.${R}\")/" $SCRIPT_PATH/build.sbt
sed -i "s/assemblyOutputPath/assemblyOutputPath in assembly := file(\"target\/${R}.jar\")/" $SCRIPT_PATH/build.sbt

rm -rf "${SCRIPT_PATH}/target"
rm -rf "${SCRIPT_PATH}/project/target"
rm -rf "${SCRIPT_PATH}/project/project"
cd ${SCRIPT_PATH}

sbt compile
sbt assembly
# java -jar "target/${R}.jar"
# #timeout -s SIGKILL 14400s tasket -c 32 java  -Xms128g -Xmx128g -jar "target/${R}.jar"

#CONFIG_FILES=("${spec_file}" "${SCRIPT_PATH}/experiment.cfg")
executor_cores="$2"
execute_log="${FILE_QUERY}_${executor_cores}.log"


#execute_log="${SCRIPT_PATH}/dbtoaster/log/execute-${experiment}.log"
#execution_time_log="${SCRIPT_PATH}/dbtoaster/log/execution-time.log"
mkdir -p "${SCRIPT_PATH}/dbtoaster/log"
rm -f ${execute_log}
touch ${execute_log}
#rm -f ${execution_time_log}
#touch ${execution_time_log}
#enum_points_list=$(cat "${SCRIPT_PATH}/dbtoaster/${experiment}/enum-points-perf.txt")
timeout_time="14400s"

SECONDS=0
timeout -s SIGKILL "${timeout_time}"  \
taskset -c "${executor_cores}" \
java -Xms128g \
     -Xmx128g \
     -jar "target/${R}.jar" \
     -b100 \
     --no-output  \

echo "$SECONDS" >> ${execute_log}

# timeout -s SIGKILL "${timeout_time}" taskset -c "${executor_cores}" \
#     java -Xms500g -Xmx500g -jar\
#     "${SCRIPT_PATH}/dbtoaster/target/experiments-dbtoaster.jar" \
#     ${experiment} \
#     ${execution_time_log} \
#     -b$(prop 'batch.size.num') \
#     -d$(prop "task${current_task}.dataset.name") \
#     --cfg-file /spark.config.${experiment}.perf \
#     "-ep${enum_points_list}"\
#     --no-output >> ${execute_log} 2>&1    

# extracted_time=$(grep "Total time (running + hsync):" "${SCRIPT_PATH}/dbtoaster/log/execute-${experiment}.log" | awk '{print $7}')
# if [[ -n ${extracted_time} ]]; then
#     current_execution_time=${extracted_time}
#     execution_time=$(echo "scale=2; x=(${current_execution_time}/1000);  if(x<1){\"0\"};  x" | bc)
# fi