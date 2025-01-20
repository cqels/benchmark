#!/bin/bash

SCRIPT_PATH=$(dirname $(readlink -f $0))
cd $SCRIPT_PATH

REPO_URL="https://github.com/hkustDB/CROWN.git"

TARGET_DIR=$(basename "${REPO_URL}" .git)

if [ ! -d "$SCRIPT_PATH/$TARGET_DIR" ]; then
    git clone "$REPO_URL" "$SCRIPT_PATH/$TARGET_DIR"
else    
    echo "Directory $TARGET_DIR already exists. Skipping clone."
fi

# Check if a container named "crown" exists
container_id=$(docker ps -aq --filter "name=crown")

if [ -n "$container_id" ]; then
    echo "Container 'crown' exists. Removing it..."
    # Remove the container
    docker rm -f crown
    echo "Container 'crown' has been removed."
else
    echo "No container named 'crown' exists."
fi


# Build the Docker image
docker build -f Dockerfile.crown -t crown_image .

# Run the container with a valid default command
docker run -di --name crown -v "$(pwd):/root" crown_image 

# Optional: Attach to the container
# docker exec -it crown bash
