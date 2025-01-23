#!/bin/bash

SCRIPT_PATH=$(dirname $(readlink -f $0))
cd $SCRIPT_PATH

REPO_URL="https://github.com/queryproc/continuous-subgraph-querying/"

TARGET_DIR=$(basename "${REPO_URL}" .git)

if [ ! -d "$SCRIPT_PATH/$TARGET_DIR" ]; then
    git clone "$REPO_URL" "$SCRIPT_PATH/$TARGET_DIR"
else    
    echo "Directory $TARGET_DIR already exists. Skipping clone."
fi

# Check if a container named "crown" exists
container_id=$(docker ps -aq --filter "name=graphflow2017")

if [ -n "$container_id" ]; then
    echo "Container 'graphflow2017' exists. Removing it..."
    # Remove the container
    docker rm -f graphflow2017
    echo "Container 'graphflow2017' has been removed."
else
    echo "No container named 'graphflow2017' exists."
fi


# Build the Docker image
docker build -f Dockerfile.graphflow2017 -t graphflow2017_image .

# Run the container with a valid default command
docker run -di --name graphflow2017 -v "$(pwd):/root" graphflow2017_image 

# Optional: Attach to the container
#docker exec -it graphflow2017 bash
