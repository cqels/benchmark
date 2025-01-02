SCRIPT_PATH=$(dirname $(readlink -f $0))

cd $SCRIPT_PATH

docker build -t crown_image 
docker run -d --name crown crown_image
docker exec -it crown bash
