COPY (select * from messageW order by m_op_time asc, m_op desc) to '/root/benchmark/crown/crown_snb_0_003/raw_window/message' DELIMITER '|';
COPY (select * from personW order by p_op_time asc, p_op desc) to '/root/benchmark/crown/crown_snb_0_003/raw_window/person' DELIMITER '|';
COPY (select * from knowsW order by k_op_time asc, k_op desc) to '/root/benchmark/crown/crown_snb_0_003/raw_window/knows' DELIMITER '|';
COPY (select * from message_tagW order by mt_op_time asc, mt_op desc) to '/root/benchmark/crown/crown_snb_0_003/raw_window/messagetag' DELIMITER '|';
COPY (select 1262531430, t_tagid, t_name, t_url, t_tagclassid from tag) to '/root/benchmark/crown/crown_snb_0_003/raw_window/tag' DELIMITER '|';
