create stream message (
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
FROM FILE '/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.message.window.csv'
LINE DELIMITED CSV (delimiter := '|');

create stream knows (
   k_explicitlyDeleted varchar,
   k_person1id varchar,
   k_person2id varchar
) FROM FILE '/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.knows.window.csv'
LINE DELIMITED CSV (delimiter := '|');

create stream tag (
   t_tagid varchar,
   t_name varchar,
   t_url varchar,
   t_tagclassid varchar
) FROM FILE '/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.tag.window.csv'
LINE DELIMITED CSV (delimiter := '|');

create stream message_tag (
   mt_messageid varchar,
   mt_tagid varchar
) FROM FILE 'dbtoaster.messagetag.window.csv'
LINE DELIMITED CSV (delimiter := '|');

select t_name, t_tagid, count(distinct m_messageid)
from tag, message, message_tag, knows
where
    m_messageid = mt_messageid and
    mt_tagid = t_tagid and
    m_creatorid = k_person2id and
    m_c_replyof = '\\N' 
group by
t_name, t_tagid