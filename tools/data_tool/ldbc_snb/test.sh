SCRIPT_PATH=$(dirname $(readlink -f $0))
echo $SCRIPT_PATH
PARENT_DIR=$(dirname $(dirname ${SCRIPT_PATH}))
echo $PARENT_DIR