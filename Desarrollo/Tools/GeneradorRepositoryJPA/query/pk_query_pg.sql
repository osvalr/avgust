select 
kc.column_name
from information_schema.table_constraints tc
join information_schema.key_column_usage kc 
on kc.constraint_name = tc.constraint_name
where
1=1
and tc.constraint_schema=kc.table_schema
and tc.constraint_schema=?
and tc.table_name = ?
and tc.constraint_type = 'PRIMARY KEY';