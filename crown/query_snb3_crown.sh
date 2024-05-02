SCRIPT_PATH=$(dirname $(readlink -f $0))

SCALE_FACTOR=$1
SCALE_FACTOR="${SCALE_FACTOR//./_}"

timeout_time="14400s"
executor_cores="8"
crown_class_name="SNBQ3Job"
input_file="${SCRIPT_PATH}/crown_snb_${SCALE_FACTOR}/snb3_window/data.csv"
input_path=$(dirname "${input_file}")
input_file_name=$(basename "${input_file}")
parallelism="1"
delta_enable="false"
full_enable="true"
filter_value="-1"
execute_log="${crown_class_name}_${SCALE_FACTOR}.log"

if [ -f ${execute_log} ]; then
    rm ${execute_log}
fi

task_result_file="result_${execute_log}"

if [[ ${filter_value} -ge 0 ]]; then
    timeout -s SIGKILL "${timeout_time}" \ 
    taskset -c "${executor_cores}" \
    java -Xms128g \
         -Xmx128g \
         -DexecutionTimeLogPath=${SCRIPT_PATH}/crown/log/execution-time.log \
         -cp "target/CROWN-1.0-SNAPSHOT.jar" ${crown_class_name} \
         "--path" "${input_path}" \
         "--graph" "${input_file_name}" \
         "--parallelism" "${parallelism}" \
         "--deltaEnumEnable" "${delta_enable}" \
         "--fullEnumEnable" "${full_enable}" \
         "--n" "${filter_value}" >> ${execute_log} 2>&1
else
    timeout -s SIGKILL "${timeout_time}" \
    taskset -c "${executor_cores}" \
    java -Xms128g -Xmx128g -DexecutionTimeLogPath=${SCRIPT_PATH}/crown/log/execution-time.log \
    -cp "target/CROWN-1.0-SNAPSHOT.jar" ${crown_class_name} \
    "--path" "${input_path}" \
    "--graph" "${input_file_name}" \
    "--parallelism" "${parallelism}" \
    "--deltaEnumEnable" "${delta_enable}" \
    "--fullEnumEnable" "${full_enable}" >> ${execute_log} 2>&1
fi

extracted_time=$(grep "StartTime" "${execute_log}" | grep "EndTime" | grep "AccumulateTime" | awk '{print $13}' | sort -n | tail -n1)
    if [[ -n ${extracted_time} ]]; then
        current_execution_time=${extracted_time}
        execution_time=$(echo "scale=2; ${current_execution_time}/1000000000" | bc)
    fi

echo "${execution_time}\n" >> ${task_result_file}