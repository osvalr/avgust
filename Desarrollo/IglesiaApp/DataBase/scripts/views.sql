create view public.vw_cargo
as
    select
        tgd.valor_general AS id_cargo,
        tgd.campo_a AS descrip_cargo
    from
        (general.tabla_general tg
        join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
    where
        (tg.nombre_tabla_general = 'Cargos');
        

create view public.vw_categoria_estudio
as
    select 
        tgd.valor_general AS id_categoria_estudio,
        tgd.campo_a AS descrip_categoria_estudio
    from
        (general.tabla_general tg
        join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
    where
        (tg.nombre_tabla_general = 'Categoria_Estudio');




create view public.vw_departamentos
  as
  select 
  x.cod_depto AS cod_depto,
  x.nombre_ubicacion AS nombre_ubicacion
  from
  general.ubigeo x
  where
  ((x.cod_prov = '00')
  and (x.cod_dist = '00'));
  
  
  
  create view public.vw_estado_generico
    as  
  select 
  tgd.valor_general AS id_estado_generico,
  tgd.campo_a AS descrip_estado_generico
  from
  (general.tabla_general tg
    join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
    where
    (tg.nombre_tabla_general = 'Estado_Generico');



create view public.vw_provincias
as        
    select 
    x.cod_depto AS cod_depto,
    x.cod_prov AS cod_prov,
    x.nombre_ubicacion AS nombre_ubicacion
    from
    general.ubigeo x
    where
    (x.cod_dist = '00');
    
    
    create view public.vw_tipo_documento
      as        
      
    select 
    tgd.valor_general AS id_tipo_documento,
    tgd.campo_a AS descrip_tipo_documento
    from
    (general.tabla_general tg
      join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
      where
      (tg.nombre_tabla_general = 'Tipo_Documento_Identidad');
      
create view public.vw_tipo_estado_civil
as  
    select 
        tgd.valor_general AS id_estado_civil,
        tgd.campo_a AS descrip_estado_civil
    from
        (general.tabla_general tg
        join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
    where
        (tg.nombre_tabla_general = 'Estado_Civil');

create view public.vw_tipo_evento_eclesiastico
as  
    select 
        tgd.valor_general AS id_tipo_evento_eclesiastico,
        tgd.campo_a AS descrip_tipo_evento_eclesiastico
    from
        (general.tabla_general tg
        join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
    where
        (tg.nombre_tabla_general = 'Evento_Eclesiastico');

create view public.vw_tipo_genero_persona
as
    select 
        tgd.valor_general AS id_genero,
        tgd.campo_a AS descrip_genero
    from
        (general.tabla_general tg
        join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
    where
        (tg.nombre_tabla_general = 'Genero_Persona');

create view public.vw_tipo_grado_instruccion
as      
    select 
        tgd.valor_general AS id_tipo_grado_instruccion,
        tgd.campo_a AS descrip_tipo_grado_instruccion
    from
        (general.tabla_general tg
        join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
    where
        (tg.nombre_tabla_general = 'Nivel_Academico');

create view public.vw_tipo_persona_juridica
as  
    select 
        tgd.valor_general AS id_tipo_persona_juridica,
        tgd.campo_a AS descrip_tipo_persona_juridica
    from
        (general.tabla_general tg
        join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
    where
        (tg.nombre_tabla_general = 'Tipo_Persona_Juridica');

create view public.vw_tipo_telefono
as 
    select 
        tgd.valor_general AS id_tipo_telefono,
        tgd.campo_a AS descrip_tipo_telefono
    from
        (general.tabla_general tg
        join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
    where
        (tg.nombre_tabla_general = 'Tipo_Telefono');

create view public.vw_tipo_parentesco
as 

    select 
        tgd.valor_general AS id_tipo_parentesco,
        tgd.campo_a AS descrip_tipo_parentesco
    from
        (general.tabla_general tg
        join general.tabla_general_detalle tgd ON ((tg.id_tabla_general = tgd.id_tabla_general)))
    where
        (tg.nombre_tabla_general = 'Tipo_Parentesco');
    