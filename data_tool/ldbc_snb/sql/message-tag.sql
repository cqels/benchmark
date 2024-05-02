INSERT INTO message_tagT
select extract(EPOCH FROM message_tag.mt_creationdate) as mt_op_time,
1 as mt_op,
message_tag.mt_messageid,
message_tag.mt_tagid
from message_tag;