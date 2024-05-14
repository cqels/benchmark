#!/bin/bash
SCRIPT_PATH=$(dirname $(readlink -f $0))
SCRIPT_NAME=$(basename "$0")
PARENT_SCRIPT_PATH=$(dirname ${SCRIPT_PATH})
SCALE_FACTOR=${2//./_}


echo "dbtoaster exe query snb ${1} $2 $3"
#Prepare queries
queries=(1 2 3 4)
if [[ " ${queries[@]} " =~ " $1 " ]]; then
    #Start process a query
    #Check if template file exists
    FILE_QUERY_TEMPLATE_NAME="snb_data_q${1}.sql"
    FILE_QUERY_TEMPLATE_PATH="${SCRIPT_PATH}/snb_queries/${FILE_QUERY_TEMPLATE_NAME}"

    #Check query template
    if [ -f "${FILE_QUERY_TEMPLATE_PATH}" ]; then
        #Copy query template file to queries folder
        FOLDER_QUERY_PATH="${SCRIPT_PATH}/queries"
        cp "$FILE_QUERY_TEMPLATE_PATH" "${FOLDER_QUERY_PATH}"

        #Rename the query file

        FILE_QUERY_NAME="snb_q${1}_${SCALE_FACTOR}.sql"
        mv "${FOLDER_QUERY_PATH}/${FILE_QUERY_TEMPLATE_NAME}" "${FOLDER_QUERY_PATH}/${FILE_QUERY_NAME}"
        FILE_QUERY_PATH="${FOLDER_QUERY_PATH}/${FILE_QUERY_NAME}"

        #Check if query file is correct
        if [ -f "${FILE_QUERY_PATH}" ]; then
            #Prepare path to data
            SNB_DATA_PATH="${SCRIPT_PATH}/dbtoaster_data/snb_${SCALE_FACTOR}/ouput"

            #<PERSON>
            if grep -q '<person>' "${FILE_QUERY_PATH}"; then
                PERSON_FILE="${SNB_DATA_PATH}/dbtoaster.person.window.csv"
                if [ -f "${PERSON_FILE}" ]; then
                    sed -i "s#<person>#${PERSON_FILE}#" "${FILE_QUERY_PATH}"
                else
                    echo "${PERSON_FILE} can not be found"
                fi
            fi

            #<MESSAGE>
            if grep -q '<message>' "${FILE_QUERY_PATH}"; then
                MESSAGE_FILE="${SNB_DATA_PATH}/dbtoaster.message.window.csv"
                if [ -f "${MESSAGE_FILE}" ]; then
                    sed -i "s#<message>#${MESSAGE_FILE}#" "${FILE_QUERY_PATH}"
                else
                    echo "${MESSAGE_FILE} can not be found"
                fi
            fi

            #<MESSAGE_TAG>
            if grep -q '<message_tag>' "${FILE_QUERY_PATH}"; then
                MESSAGE_TAG="${SNB_DATA_PATH}/dbtoaster.messagetag.window.csv"
                if [ -f "${MESSAGE_TAG}" ]; then
                    sed -i "s#<message_tag>#${MESSAGE_TAG}#" "${FILE_QUERY_PATH}"
                else
                    echo "${MESSAGE_TAG} can not be found"
                fi
            fi

            #<TAG>
            if grep -q '<tag>' "${FILE_QUERY_PATH}"; then
                TAG_FILE="${SNB_DATA_PATH}/dbtoaster.tag.window.csv"
                if [ -f "${TAG_FILE}" ]; then
                    sed -i "s#<tag>#${TAG_FILE}#" "${FILE_QUERY_PATH}"
                else
                    echo "${TAG_FILE} can not be found"
                fi
            fi

            #<KNOWS>
            if grep -q '<knows>' "${FILE_QUERY_PATH}"; then
                KNOWS_FILE="${SNB_DATA_PATH}/dbtoaster.knows.window.csv"
                if [ -f "${KNOWS_FILE}" ]; then
                    sed -i "s#<knows>#${KNOWS_FILE}#" "${FILE_QUERY_PATH}"
                else
                    echo "${KNOWS_FILE} can not be found"
                fi
            fi

            #<KNOWS1>
            if grep -q '<knows1>' "${FILE_QUERY_PATH}"; then
                KNOWS1_FILE="${SNB_DATA_PATH}/dbtoaster.knows1.window.csv"
                if [ -f "${KNOWS1_FILE}" ]; then
                    sed -i "s#<knows1>#${KNOWS1_FILE}#" "${FILE_QUERY_PATH}"
                else
                    echo "${KNOWS1_FILE} can not be found"
                fi
            fi

            #<KNOWS2>
            if grep -q '<knows2>' "${FILE_QUERY_PATH}"; then
                KNOWS2_FILE="${SNB_DATA_PATH}/dbtoaster.knows2.window.csv"
                if [ -f "${KNOWS2_FILE}" ]; then
                    sed -i "s#<knows2>#${KNOWS2_FILE}#" "${FILE_QUERY_PATH}"
                else
                    echo "${KNOWS2_FILE} can not be found"
                fi
            fi

        else
            echo "Could not find ${FILE_QUERY_PATH}"
        fi
    else
        echo "Could not find ${FILE_QUERY_TEMPLATE_PATH}"
    fi
fi

#Compile
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

mkdir -p "${SCRIPT_PATH}/db_toaster_result/"

timeout_time="14400s"

if test "$3" = "all"; then
    for executor_cores in 2 4 8 16 32; do
        echo "Runing experiment snb${1} with scale factor ${2} with number of cores (all cores) ${executor_cores}"
        execute_log="db_toaster_result/${FILE_QUERY}_${executor_cores}.log"
        SECONDS=0
        timeout -s SIGKILL "${timeout_time}" \
            taskset -c "${executor_cores}" \
            java -Xms128g \
            -Xmx128g \
            -jar "target/${R}.jar" \
            -b100 \
            --no-output
        echo "$SECONDS" >>${execute_log}
    done
else
     echo "Runing experiment snb${1} with scale factor ${2} with number of cores ${executor_cores}"
    executor_cores="$3"
    execute_log="db_toaster_result/${FILE_QUERY}_${executor_cores}.log"
    SECONDS=0
    timeout -s SIGKILL "${timeout_time}" \
        taskset -c "${executor_cores}" \
        java -Xms128g \
        -Xmx128g \
        -jar "target/${R}.jar" \
        -b100 \
        --no-output
    echo "$SECONDS" >>${execute_log}
fi
