query=$1
sf=$2
cores=$3

if test "$1" = "all"
then    
    for query in 1 2 3 4
    do
        bash dbtoaster_query_snb_sf.sh "${query}" "$2" "$3"
    done
    exit 0
else
    bash dbtoaster_query_snb_sf.sh "$1" "$2" "$3"
fi