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
FROM FILE '<message>'
LINE DELIMITED CSV (delimiter := '|');

create stream knows1 (
   k_op_time varchar,
   k_op varchar,
   k_explicitlyDeleted varchar,
   k_personid1 varchar,
   k_personid2 varchar
) FROM FILE '<knows1>'
LINE DELIMITED CSV (delimiter := '|');

create stream knows2 (
   k_op_time varchar,
   k_op varchar,
   k_explicitlyDeleted varchar,
   k_personid1 varchar,
   k_personid2 varchar
) FROM FILE '<knows2>'
LINE DELIMITED CSV (delimiter := '|');

create stream tag (
   t_tagid varchar,
   t_name varchar,
   t_url varchar,
   t_tagclassid varchar
) FROM FILE '<tag>'
LINE DELIMITED CSV (delimiter := '|');

create stream message_tag (
   k_op_time varchar,
   k_op varchar,
   mt_messageid varchar,
   mt_tagid varchar
) FROM FILE '<message_tag>'
LINE DELIMITED CSV (delimiter := '|');

select k1.k_personid1, k1.k_personid2, k2.k_personid2, t_tagid, m_messageid
from tag, message, message_tag, knows1 k1, knows2 k2
where
    m_messageid = mt_messageid and
    mt_tagid = t_tagid and
    k1.k_personid2 = k2.k_personid1 and
    m_creatorid = k2.k_personid2 and
    m_c_replyof = '\\N' and
    regexp_match('^.{0,5}$',k1.k_personid1) = 1