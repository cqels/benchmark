INSERT INTO messageT
select extract(EPOCH FROM message.m_creationdate) as m_op_time,
1 as m_op,
message.m_explicitlyDeleted,
message.m_messageid,
message.m_ps_imagefile,
message.m_locationip,
message.m_browserused,
message.m_ps_language,
message.m_content,
message.m_length,
message.m_creatorid,
message.m_locationid,
message.m_ps_forumid,
message.m_c_parentpostid,
message.m_c_replyof
from message;