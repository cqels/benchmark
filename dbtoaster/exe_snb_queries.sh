#!/bin/bash
SCRIPT_PATH=$(dirname $(readlink -f $0))
SCRIPT_NAME=$(basename "$0")
PARENT_SCRIPT_PATH=$(dirname ${SCRIPT_PATH})
SCALE_FACTOR=${2//./_}
#DATA_TOOL_PATH="${PARENT_SCRIPT_PATH}/data_tool/ldbc_snb/snb"

queries=(1 2 3 4)

if test "$1" = "all"
then
    for q in 1 2 3 4
    do
        bash "${SCRIPT_PATH}/${SCRIPT_NAME}" "${q}" "${SCALE_FACTOR}"        
    done
    exit 0
else
    if [[ " ${queries[@]} " =~ " $1 " ]]; 
    then
        #Start process a query
        #Check if template file exists
        FILE_QUERY_TEMPLATE_NAME="snb_data_q${1}.sql"
        FILE_QUERY_TEMPLATE_PATH="${SCRIPT_PATH}/snb_queries/${FILE_QUERY_TEMPLATE_NAME}"
        
        #Check query template
        if [ -f "${FILE_QUERY_TEMPLATE_PATH}" ] 
        then
            #Copy query template file to queries folder
            FOLDER_QUERY_PATH="${SCRIPT_PATH}/queries"
            cp "$FILE_QUERY_TEMPLATE_PATH" "${FOLDER_QUERY_PATH}"
            
            #Rename the query file
         
            FILE_QUERY_NAME="snb_q${1}_${SCALE_FACTOR}.sql"
            mv "${FOLDER_QUERY_PATH}/${FILE_QUERY_TEMPLATE_NAME}" "${FOLDER_QUERY_PATH}/${FILE_QUERY_NAME}"
            FILE_QUERY_PATH="${FOLDER_QUERY_PATH}/${FILE_QUERY_NAME}"
          
            #Check if query file is correct
            if [ -f "${FILE_QUERY_PATH}" ] 
            then
                #Prepare path to data
                SNB_DATA_PATH="${SCRIPT_PATH}/dbtoaster_data/snb_${SCALE_FACTOR}/ouput"

                #<PERSON>
                if grep -q '<person>' "${FILE_QUERY_PATH}"; then
                    PERSON_FILE="${SNB_DATA_PATH}/dbtoaster.person.window.csv"
                    if [ -f "${PERSON_FILE}" ]
                    then 
                        sed -i "s#<person>#${PERSON_FILE}#" "${FILE_QUERY_PATH}"
                    else
                        echo "${PERSON_FILE} can not be found"
                    fi
                fi

                #<MESSAGE>
                if grep -q '<message>' "${FILE_QUERY_PATH}"; then
                    MESSAGE_FILE="${SNB_DATA_PATH}/dbtoaster.message.window.csv"
                    if [ -f "${MESSAGE_FILE}" ]
                    then 
                        sed -i "s#<message>#${MESSAGE_FILE}#" "${FILE_QUERY_PATH}"
                    else
                        echo "${MESSAGE_FILE} can not be found"
                    fi
                fi

                #<MESSAGE_TAG>
                if grep -q '<message_tag>' "${FILE_QUERY_PATH}"; then
                    MESSAGE_TAG="${SNB_DATA_PATH}/dbtoaster.messagetag.window.csv"
                    if [ -f "${MESSAGE_TAG}" ]
                    then 
                        sed -i "s#<message_tag>#${MESSAGE_TAG}#" "${FILE_QUERY_PATH}"
                    else
                        echo "${MESSAGE_TAG} can not be found"
                    fi
                fi

                #<TAG>
                if grep -q '<tag>' "${FILE_QUERY_PATH}"; then
                    TAG_FILE="${SNB_DATA_PATH}/dbtoaster.tag.window.csv"
                    if [ -f "${TAG_FILE}" ]
                    then 
                        sed -i "s#<tag>#${TAG_FILE}#" "${FILE_QUERY_PATH}"
                    else
                        echo "${TAG_FILE} can not be found"
                    fi
                fi

                #<KNOWS>
                if grep -q '<knows>' "${FILE_QUERY_PATH}"; then
                    KNOWS_FILE="${SNB_DATA_PATH}/dbtoaster.knows.window.csv"
                    if [ -f "${KNOWS_FILE}" ]
                    then 
                        sed -i "s#<knows>#${KNOWS_FILE}#" "${FILE_QUERY_PATH}"
                    else
                        echo "${KNOWS_FILE} can not be found"
                    fi
                fi

                #<KNOWS1>
                if grep -q '<knows1>' "${FILE_QUERY_PATH}"; then
                    KNOWS1_FILE="${SNB_DATA_PATH}/dbtoaster.knows1.window.csv"
                    if [ -f "${KNOWS1_FILE}" ]
                    then 
                        sed -i "s#<knows1>#${KNOWS1_FILE}#" "${FILE_QUERY_PATH}"
                    else
                        echo "${KNOWS1_FILE} can not be found"
                    fi
                fi

                #<KNOWS2>
                if grep -q '<knows2>' "${FILE_QUERY_PATH}"; then
                    KNOWS2_FILE="${SNB_DATA_PATH}/dbtoaster.knows2.window.csv"
                    if [ -f "${KNOWS2_FILE}" ]
                    then 
                        sed -i "s#<knows2>#${KNOWS2_FILE}#" "${FILE_QUERY_PATH}"
                    else
                        echo "${KNOWS2_FILE} can not be found"
                    fi
                fi

                if test "$3" = "all" 
                then
                    for core in 2 4 8 16 32
                    do
                        bash "${SCRIPT_PATH}/exe_query.sh" "${FILE_QUERY_PATH}" "${core}"
                    done
                else
                    bash "${SCRIPT_PATH}/exe_query.sh" "${FILE_QUERY_PATH}" "$3"
                fi
            
            else 
                echo "Could not find ${FILE_QUERY_PATH}"
                exit 0
            fi                
        else
            echo "Could not find ${FILE_QUERY_TEMPLATE_PATH}"
            exit 0
        fi            
        exit 0
    fi
fi
echo "Can not recognize varaible: $1 $2"