#!/bin/bash

SCRIPT_PATH=$(dirname $(readlink -f $0))
cd $SCRIPT_PATH

REPO_URL="https://github.com/queryproc/optimizing-continuous-queries-using-wcojs.git"

TARGET_DIR=$(basename "${REPO_URL}" .git)

if [ ! -d "$SCRIPT_PATH/$TARGET_DIR" ]; then
    git clone "$REPO_URL" "$SCRIPT_PATH/$TARGET_DIR"
else    
    echo "Directory $TARGET_DIR already exists. Skipping clone."
fi

# Check if a container named "crown" exists
container_id=$(docker ps -aq --filter "name=graphflow2025")

if [ -n "$container_id" ]; then
    echo "Container 'graphflow2025' exists. Removing it..."
    # Remove the container
    docker rm -f graphflow2025
    echo "Container 'graphflow2025' has been removed."
else
    echo "No container named 'graphflow2025' exists."
fi


# Build the Docker image
docker build -f Dockerfile.graphflow2025 -t graphflow2025_image .

# Run the container with a valid default command
docker run -di --name graphflow2025 -v "$(pwd):/root" graphflow2025_image 

# Optional: Attach to the container
docker exec -it graphflow2025 bash
