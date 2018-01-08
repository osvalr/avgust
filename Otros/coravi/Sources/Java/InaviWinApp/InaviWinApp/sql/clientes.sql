select 

p.id_persona,
(CASE WHEN pt.id_tipo_persona = 2 THEN p.razon_social
     ELSE coalesce(p.nombres,'') || ' ' || coalesce(p.ape_pater,'') || ' ' || coalesce(p.ape_mater,'')
END) nombres

from 
general.persona p
inner join general.persona_tipo pt on p.id_persona = pt.id_persona

where
 
p.id_estado = 1
and pt.id_tipo_persona in (1,2)
and pt.id_sub_tipo_persona = 1

order by nombres