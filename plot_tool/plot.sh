#!/bin/bash

SCRIPT=$(readlink -f $0)
SCRIPT_PATH=$(dirname "${SCRIPT}")


mkdir -p "figure/"
gnuplot -c "exp1.plt"
gnuplot -c "snb1.plt"
gnuplot -c "snb2.plt"
gnuplot -c "snb3.plt"
gnuplot -c "snb4.plt"