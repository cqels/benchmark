SCRIPT_PATH=$(dirname $(readlink -f $0))

SCALE_FACTOR=$1
SCALE_FACTOR="${SCALE_FACTOR//./_}"

CORES=$2
PARA=$3


timeout_time="14400s"
executor_cores=$CORES
crown_class_name="SNBQ3Job"
input_file="${SCRIPT_PATH}/crown_data/crown_snb_${SCALE_FACTOR}/snb3_window/data.csv"
input_path=$(dirname "${input_file}")
input_file_name=$(basename "${input_file}")
parallelism=$PARA
delta_enable="false"
full_enable="true"
filter_value="100000"

execute_log="${crown_class_name}_sf_${SCALE_FACTOR}_parallelism_${parallelism}.log"
task_result_file="crown_result/result_${execute_log}"

if [ -f "crown_log/${execute_log}" ]; then
    rm "crown_log/${execute_log}"
fi

echo "RUNNING SNB3 - core :${executor_cores} - parallelism ${parallelism} - SF ${SCALE_FACTOR}"

if [[ ${filter_value} -ge 0 ]]; then
    timeout -s SIGKILL "${timeout_time}" \
    taskset -c "${executor_cores}" \
    java -Xms128g \
         -Xmx128g \
         -DexecutionTimeLogPath=${SCRIPT_PATH}/crown/execution-time.log \
         -cp "target/CROWN-1.0-SNAPSHOT.jar" ${crown_class_name} \
         "--path" "${input_path}" \
         "--graph" "${input_file_name}" \
         "--parallelism" "${parallelism}" \
         "--deltaEnumEnable" "${delta_enable}" \
         "--fullEnumEnable" "${full_enable}" \
         "--n" "${filter_value}" >> "crown_log/${execute_log}" 2>&1
else
    timeout -s SIGKILL "${timeout_time}" \
    taskset -c "${executor_cores}" \
    java -Xms128g -Xmx128g -DexecutionTimeLogPath=${SCRIPT_PATH}/crown/execution-time.log \
    -cp "target/CROWN-1.0-SNAPSHOT.jar" ${crown_class_name} \
    "--path" "${input_path}" \
    "--graph" "${input_file_name}" \
    "--parallelism" "${parallelism}" \
    "--deltaEnumEnable" "${delta_enable}" \
    "--fullEnumEnable" "${full_enable}" >> "crown_log/${execute_log}" 2>&1
fi

extracted_time=$(grep "StartTime" "crown_log/${execute_log}" | grep "EndTime" | grep "AccumulateTime" | awk '{print $13}' | sort -n | tail -n1)
    if [[ -n ${extracted_time} ]]; then
        current_execution_time=${extracted_time}
        execution_time=$(echo "scale=2; ${current_execution_time}/1000000000" | bc)
    fi



echo "${execution_time}\n" >> ${task_result_file}