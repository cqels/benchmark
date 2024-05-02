SF=$1

for ((i=1; i<=5; i++))
do
    echo "Number: $i"
    bash query_snb1_crown.sh "$SF"
    #bash query_snb2_crown.sh "$SF"
    #bash query_snb3_crown.sh "$SF"
    #bash query_snb4_crown.sh "$SF"
done