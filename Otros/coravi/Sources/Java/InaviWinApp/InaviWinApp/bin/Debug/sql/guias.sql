select 

g.id_guia,
g.fecha_jornada,
g.descrip_tipo_producto,
g.nombre_cliente,
g.cant_aves_bruto,
g.cant_aves_devolucion,
g.total_peso_bruto,
g.total_peso_tara,
g.total_peso_devolucion,
g.total_peso_neto,
--g.precio_aplicado,
g.total_importe,
g.total_amortizado,
g.total_deuda,
g.descrip_estado,
g.fecha_registro

from

(
select 

g.id_guia,
g.num_anio,
g.num_mes,
g.num_dia,
j.fecha_jornada fecha_jornada_date,
to_char(j.fecha_jornada,'dd/mm/yyyy') fecha_jornada,
tp.descrip_item descrip_tipo_producto,
g.id_cliente,
(CASE WHEN pt.id_tipo_persona = 2 THEN c.razon_social
     ELSE coalesce(c.nombres,'')  || ' ' ||coalesce(c.ape_pater,'') || ' ' || coalesce(c.ape_mater,'')
END) nombre_cliente,
(select sum(gp.num_aves) from inavi.guia_peso gp where gp.id_guia = g.id_guia and gp.id_tipo_peso = 1) cant_aves_bruto,
(select coalesce(sum(gp.num_aves),0) from inavi.guia_peso gp where gp.id_guia = g.id_guia and gp.id_tipo_peso in (2,3)) cant_aves_devolucion,
g.total_peso_bruto,
g.total_peso_tara,
g.total_peso_devolucion,
g.total_peso_neto,
g.precio_aplicado,
g.total_importe,
coalesce((select sum(gs.monto_amortizado) from inavi.guia_saldo gs where gs.id_guia = g.id_guia),0) total_amortizado,
(g.total_importe - coalesce((select sum(gs.monto_amortizado) from inavi.guia_saldo gs where gs.id_guia = g.id_guia),0)) total_deuda,
eg.descrip_item as descrip_estado,
to_char(g.fecha_registro,'dd/mm/yyyy') fecha_registro

from inavi.guia g
inner join inavi.jornada j on g.num_anio = j.num_anio and g.num_mes = j.num_mes and g.num_dia = j.num_dia
inner join general.persona c on g.id_cliente = c.id_persona
inner join general.persona_tipo pt on g.id_cliente = pt.id_persona
INNER join general.vw_catalogo eg on g.id_estado = eg.valor_item and eg.nombre_catalogo = 'estado_guia_venta'
INNER join general.vw_catalogo tp on g.id_tipo_producto = tp.valor_item and tp.nombre_catalogo = 'tipo_producto'
)
g

WHERE 

g.num_anio = coalesce(@num_anio,g.num_anio)
and g.num_mes = coalesce(@num_mes,g.num_mes)
and g.num_dia = coalesce(@num_dia,g.num_dia)
and g.id_cliente = coalesce(@id_cliente,g.id_cliente)

order by g.fecha_jornada_date