SELECT 

c.column_name,
c.data_type,
c.character_maximum_length,
c.character_octet_length,
c.numeric_precision,
c.numeric_precision_radix,
c.numeric_scale,
c.datetime_precision,
c.is_nullable

FROM information_schema.columns c
WHERE c.table_schema = ?
  AND c.table_name   = ?
order by c.ordinal_position