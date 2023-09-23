\copy (select * from messageW order by m_op_time asc, m_op desc) to '/root/benchmark/data_tool/dbtoaster/snb_sf1/raw_window/message' DELIMITER '|';
\copy (select * from personW order by p_op_time asc, p_op desc) to '/root/benchmark/data_tool/dbtoaster/snb_sf1/raw_window/person' DELIMITER '|';
\copy (select * from knowsW order by k_op_time asc, k_op desc) to '/root/benchmark/data_tool/dbtoaster/snb_sf1/raw_window/knows' DELIMITER '|';
\copy (select * from message_tagW order by mt_op_time asc, mt_op desc) to '/root/benchmark/data_tool/dbtoaster/snb_sf1/raw_window/messagetag' DELIMITER '|';
\copy (select 1262310842, t_tagid, t_name, t_url, t_tagclassid from tag) to '/root/benchmark/data_tool/dbtoaster/snb_sf1/raw_window/tag' DELIMITER '|';
