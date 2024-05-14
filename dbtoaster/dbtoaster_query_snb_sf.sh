query=$1
sf=$2
cores=$3


if test "$2" = "all"; then
    for sf in 0.3 1 3 10; do
        bash dbtoaster_exe_query.sh "${query}" "$sf" "$3"
    done
    exit 0
else
    bash dbtoaster_exe_query.sh "$1" "$2" "$3"
fi
