set style line 1 pt 2 lc 'forest-green' ps 2 lw 2
#set style line 5 pt 2 lc 'forest-green' ps 2 lw 2

set style line 2 pt 2 lc 'purple' ps 2 lw 2
#set style line 6 pt 2 lc 'purple' ps 2 lw 2

set style line 3 pt 3 lc 'orange' ps 2 lw 2
#set style line 7 pt 3 lc 'orange' ps 2 lw 2

set style line 4 pt 4 lc 'skyblue' ps 2 lw 2
#set style line 8 pt 4 lc 'skyblue' ps 2 lw 2

#set logscale y
set xlabel "Scale Factor"
set ylabel "Processing Time (Sec)"
set xrange [1:4]
set yrange [1:1000]
set xtics ("0.3" 1, "1" 2, "3" 3, "10" 4)
set ytics ("500" 500, "1000" 1000,"6000" 6000,"8000" 8000,"10000" 10000)
set key above
#set grid lt 0 lc 0 lw 1
set border lw 2

set term pngcairo size 700,350
set output "figure/snb4.png"
data = "snb4.dat"
plot data using 1:($2) title "SNB1" ls 1 w lp, \
     data using 1:($3) title "CROWN_{Single Thread}" ls 2 w lp, \
     data using 1:($4) title "CROWN_{16 Threads}" ls 3 w lp, \
     data using 1:($5) title "CROWN_{32 Threads}" ls 4 w lp