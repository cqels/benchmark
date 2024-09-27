#!/bin/bash

# Directory where you want to clone the repo
TARGET_DIR="your-directory"

# URL of the Git repository
REPO_URL="https://github.com/your-username/your-repo.git"

# Check if the directory exists
if [ ! -d "$TARGET_DIR" ]; then
    echo "Directory $TARGET_DIR does not exist. Cloning the repository..."
    git clone "$REPO_URL" "$TARGET_DIR"
else
    echo "Directory $TARGET_DIR already exists. Skipping clone."
fi
