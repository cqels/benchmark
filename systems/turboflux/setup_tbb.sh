#!/bin/bash

rm -f tmp1
rm -f tmp2
find /usr -name "libtbbmalloc_proxy.so.2" 2> /dev/null > tmp1 
while read line; do
    echo ${line%/*} >> tmp2
done < tmp1
p=$(cat tmp2 | tr '\n' ':')
echo $p
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$p
echo "export LD_LIBRARY_PATH=$LD_LIBRARY_PATH" >> ~/.bashrc
source ~/.bashrc

rm -f tmp1 tmp2
