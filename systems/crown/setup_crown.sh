SCRIPT_PATH=$(dirname $(readlink -f $0))

REPO_URL="https://github.com/hkustDB/CROWN.git"

TARGET_DIR=$(basename "${REPO_URL}" .git)

echo $TARGET_DIR
echo $SCRIPT_PATH

if [ ! -d "$SCRIPT_PATH/$TARGET_DIR" ]; then
    git clone "$REPO_URL" "$SCRIPT_PATH/$TARGET_DIR"
else    
    echo "Directory $TARGET_DIR already exists. Skipping clone."
fi


