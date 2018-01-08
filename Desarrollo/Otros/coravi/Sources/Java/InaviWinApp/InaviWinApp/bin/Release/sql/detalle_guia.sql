select

tpg.descrip_item descrip_tipo_peso,
g.num_jabas,
g.num_aves,
g.peso_obtenido

from

inavi.guia_peso g
INNER join general.vw_catalogo tpg on g.id_tipo_peso = tpg.valor_item and tpg.nombre_catalogo = 'tipo_peso_guia'

where

g.id_guia = coalesce(@id_guia,g.id_guia)

order by g.id_tipo_peso