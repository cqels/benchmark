INSERT INTO personT
select extract(EPOCH FROM person.p_creationdate) as p_op_time,
1 as p_op,
person.p_explicitlyDeleted,
person.p_personid,
person.p_firstname,
person.p_lastname,
person.p_gender,
person.p_birthday,
person.p_locationip,
person.p_browserused,
person.p_placeid,
person.p_language,
person.p_email
from person;

