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

${TOOLS}/run.py --parallelism 1 --memory 12g -- --format csv --scale-factor $1 --mode raw
SCALE_FACTOR="${SCALE_FACTOR//./_}"

if [ -d "${SCRIPT_PATH}/snb_${SCALE_FACTOR}/" ] 
then
   rm -r "${SCRIPT_PATH}/snb_${SCALE_FACTOR}/"
fi


mkdir "${SCRIPT_PATH}/snb_${SCALE_FACTOR}/"

mv "${SCRIPT_PATH}/out/graphs/csv/raw/composite-merged-fk/dynamic/" "${SCRIPT_PATH}/snb_${SCALE_FACTOR}/dynamic/"
mv "${SCRIPT_PATH}/out/graphs/csv/raw/composite-merged-fk/static/" "${SCRIPT_PATH}/snb_${SCALE_FACTOR}/static/"

if [ -d "${SCRIPT_PATH}/out/" ] 
then
   rm -r "${SCRIPT_PATH}/out/"
fi

