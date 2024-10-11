N/A
Given a $datetime, find all Messages created before that moment. Group them by a 3-level grouping:
1. by year of creation
2. for each year, group into Message types: is Comment or not
3. for each year-type group, split into four groups based on length of their content
description
• 0: 0 ≤ length < 40 (short)
• 1: 40 ≤ length < 80 (one liner)
• 2: 80 ≤ length < 160 (tweet)
• 3: 160 ≤ length (long)