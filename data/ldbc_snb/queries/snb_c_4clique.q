# Data SF 0.003, 0.1 does not cover this query
?person_x :knows ?person_y
?message_v :hasCreator ?person_x
?message_t :isReplyOf ?message_v
?message_t :hasCreator ?person_y
?person_x :likes ?message_t
?person_y :likes ?message_v