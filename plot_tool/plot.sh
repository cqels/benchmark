#!/bin/bash

SCRIPT=$(readlink -f $0)
SCRIPT_PATH=$(dirname "${SCRIPT}")


mkdir -p "figure/"
gnuplot -c "exp1.plt"
gnuplot -c "exp2.plt"