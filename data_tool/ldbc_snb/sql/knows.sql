INSERT INTO knowsT
select extract(EPOCH FROM knows.k_creationdate) as k_op_time,
1 as k_op,
knows.k_explicitlyDeleted,
knows.k_person1id,
knows.k_person2id
from knows;