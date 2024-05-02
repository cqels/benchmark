SCALE_FACTOR=$1

SCRIPT_PATH=$(dirname $(readlink -f $0))

SOURCE_PATH="${SCRIPT_PATH}/ldbc_snb_datagen_spark"
TARGET_PATH="${SOURCE_PATH}/target"
SCRIPTS="${SOURCE_PATH}/scripts"
TOOLS="${SOURCE_PATH}/tools"

source "${HOME}/.profile"

if [ -f "${TARGET_PATH}/gen.jar" ]
then 
    echo "Tool is ready to run"
else
    rm -r ${TARGET_PATH}
    cd "${SOURCE_PATH}" && bash "${SCRIPTS}/build.sh"
    cd "${TARGET_PATH}" && mv $(find . -type f -name "*.jar" | shuf -n 1) gen.jar
fi

export LDBC_SNB_DATAGEN_JAR="${TARGET_PATH}/gen.jar"

${TOOLS}/run.py --parallelism 1 --memory 180g -- --format csv --scale-factor $1 --mode raw
SCALE_FACTOR="${SCALE_FACTOR//./_}"
cd "${SCRIPT_PATH}/out" && mv "${SCRIPT_PATH}/out" "${SCRIPT_PATH}/snb_${SCALE_FACTOR}"

PARENT_DIR=$(dirname $(dirname ${SCRIPT_PATH}))

if [ -d "${PARENT_DIR}" ]; then
    mv "${SCRIPT_PATH}/snb_${SCALE_FACTOR}" "${PARENT_DIR}/data/snb/"
fi
