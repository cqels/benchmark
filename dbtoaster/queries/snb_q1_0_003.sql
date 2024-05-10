create stream message (
    m_op_time varchar,
    m_op varchar,
    m_explicitlyDeleted varchar,
    m_messageid varchar,
    m_ps_imagefile varchar,
    m_locationip varchar,
    m_browserused varchar,
    m_ps_language varchar,
    m_content varchar,
    m_length varchar,
    m_creatorid varchar,
    m_locationid varchar,
    m_ps_forumid varchar,
    m_c_parentpostid varchar,
    m_c_replyof varchar
)
FROM FILE '/root/benchmark/data_tool/ldbc_snb/snb/snb_0_003/message'
LINE DELIMITED CSV (delimiter := '|');

create stream person (
   p_op_time varchar,
   p_op varchar,
   p_explicitlyDeleted varchar,
   p_personid varchar,
   p_firstname varchar,
   p_lastname varchar,
   p_gender varchar,
   p_birthday varchar,
   p_locationip varchar,
   p_browserused varchar,
   p_placeid varchar,
   p_language varchar,
   p_email varchar
) 
FROM FILE '/root/benchmark/data_tool/ldbc_snb/snb/snb_0_003/person'
LINE DELIMITED CSV (delimiter := '|');

create stream knows (
   k_op_time varchar,
   p_op varchar,
   k_explicitlyDeleted varchar,
   k_personid1 varchar,
   k_personid2 varchar
) 
FROM FILE '/root/benchmark/data_tool/ldbc_snb/snb/snb_0_003/knows'
LINE DELIMITED CSV (delimiter := '|');

select p_personid, p_firstname, p_lastname, m_messageid, k_personid1
from person, message, knows
where
    p_personid = m_creatorid and
    k_personid2 = p_personid;