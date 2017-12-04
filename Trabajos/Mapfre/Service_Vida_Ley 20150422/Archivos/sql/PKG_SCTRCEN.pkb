CREATE OR REPLACE PACKAGE BODY OIM.pkg_sctrcen
AS
 vl_Cod_Cia NUMBER := 2;
 vl_Cod_Ramo NUMBER := 610;
 vl_cod_sistema VARCHAR2 (8) := 'GESTASEG';

/*==============================================================================
PROPOSITO: PERMISOS.
AUTOR: AALVARADO FECHA: 12/09/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - an_cod_grupo -> codigo de Grupo
 - an_param_01 -> Parametro 01
 - an_param_02 -> Parametro 02
 - an_param_03 -> Parametro 03
 - o_cursor -> Cursor
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Listado de Combos
==============================================================================*/
 PROCEDURE psctrcenmt000 (
 an_cod_grupo IN NUMBER,
 an_param_01 IN VARCHAR2,
 an_param_02 IN VARCHAR2 DEFAULT NULL,
 an_param_03 IN VARCHAR2 DEFAULT NULL,
 o_cursor OUT t_cursor
 )
 IS
 BEGIN
 IF an_cod_grupo = 1
 THEN
 --LISTAR TIPO DE DOCUMENTO
 OPEN o_cursor FOR
 SELECT 'DNI' codigo, 'DNI' descripcion
 FROM DUAL
 UNION
 SELECT 'RUC' codigo, 'RUC' descripcion
 FROM DUAL
 UNION
 SELECT 'CIP' codigo, 'CIP' descripcion
 FROM DUAL
 UNION
 SELECT 'CEX' codigo, 'CEX' descripcion
 FROM DUAL
 UNION
 SELECT 'PEX' codigo, 'PEX' descripcion
 FROM DUAL;
 ELSIF an_cod_grupo = 2
 THEN
 --LISTAR RIESGO
 OPEN o_cursor FOR
 SELECT '1' codigo, 'RIESGO 01' descripcion
 FROM DUAL
 UNION
 SELECT '2' codigo, 'RIESGO 02' descripcion
 FROM DUAL
 UNION
 SELECT '3' codigo, 'RIESGO 03' descripcion
 FROM DUAL
 UNION
 SELECT '4' codigo, 'RIESGO 04' descripcion
 FROM DUAL;
 ELSIF an_cod_grupo = 3
 THEN --Listado de polizas segun el cliente
 OPEN o_cursor FOR
 SELECT num_poliza codigo, num_poliza descripcion
 FROM a2000030@tron p
 WHERE p.cod_cia = 2
 AND p.cod_ramo = 610
 AND p.cod_agt = DECODE(an_param_01,'0',p.cod_agt,an_param_01)
 AND p.tip_docum = an_param_02
 AND p.cod_docum = an_param_03
 AND p.num_spto = (select max(num_spto)
 from a2000030@tron a
 where a.cod_cia=p.cod_cia
 and a.cod_ramo = p.cod_ramo
 and a.num_poliza = p.num_poliza
 and a.tip_docum = p.tip_docum
 and a.cod_docum = p.cod_docum
 and a.cod_agt = p.cod_agt
 and p.mca_provisional = 'N'
 and p.mca_poliza_anulada = 'N'
 and p.mca_spto_anulado = 'N')
 --sf_f_max_spto@tron (p.cod_cia, p.num_poliza, p.num_spto)
 AND p.num_apli = 0
 AND p.num_spto_apli = 0
 AND p.mca_provisional = 'N'
 AND p.mca_poliza_anulada = 'N'
 AND p.mca_spto_anulado = 'N';
 ELSIF an_cod_grupo = 4
 THEN --Lista de polizas por codigo de asegurado
 OPEN o_cursor FOR
 SELECT DISTINCT num_poliza codigo, num_poliza descripcion,tip_docum,cod_docum
 FROM oim.rcen_asegurados aseg LEFT JOIN oim.rcen_movimientos mov
 ON (aseg.cod_aseg = mov.cod_aseg)
 WHERE mov.cod_aseg = an_param_01
 AND mov.estado = 'A'
 AND aseg.estado = 'A'
 AND mov.cod_ramo = '610'
 AND cod_cia = 2;
 ELSIF an_cod_grupo = 5 -----Listado de tipos de documentos de TRON
 THEN
 OPEN o_cursor FOR
 SELECT TIP_DOCUM codigo, NOM_DOCUM descripcion
 --DECODE(TIP_DOCUM,'DNI','DNI','RUC', 'RUC', NOM_DOCUM) descripcion
 FROM A1002300@TRON
 WHERE TIP_DOCUM in('DNI','PEX','CEX','RUC')
 ORDER BY 2 DESC;
 END IF;
 END psctrcenmt000;

/*==============================================================================
PROPOSITO: LISTA GESTOR, AGENTE Y CLIENTE.
AUTOR: AALVARADO FECHA: 12/09/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_TipBusqueda -> Tipo de Busqueda
 - as_Codigo -> Codigo Gestor-Agente-Cliente
 - as_Descrip -> Descrpcion de Busqueda
 - as_CodGestor -> Codigo de Gestor para busqueda de Agente-Codigo de Agente para busqueda de Empresa
 - an_numpagina -> Numero de pagina
 - an_tampagina -> tamano de pagina
 - an_totregistro -> Total de registros
 - o_cursor -> Cursor
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Listado de Gestor, Agente y Cliente mediante parametros de busqueda (Codigo y Descripcion)
==============================================================================*/
 PROCEDURE psctrcenmt001 (
 as_tipbusqueda IN VARCHAR2,
 as_codigo IN VARCHAR2,
 as_descrip IN VARCHAR2,
 as_codgestor IN VARCHAR2,
 --paginado
 an_numpagina IN NUMBER,
 an_tampagina IN NUMBER,
 an_totregistro OUT NUMBER,
 o_cursor OUT t_cursor
 )
 IS

 Qselect VARCHAR2(4000);
 Qcountini VARCHAR2(4000);
 Qcountfin VARCHAR2(4000);
 Qcursorini VARCHAR2(4000);
 Qcursorfin VARCHAR2(4000);
 id_error number;

 BEGIN
 IF as_tipbusqueda = 'GESTOR'
 THEN
 --LISTAR GESTOR
 SELECT COUNT (*)
 INTO an_totregistro
 FROM (SELECT aa.cod_tercero
 FROM a1001390@tron aa, a1001399@tron bb
 WHERE aa.cod_act_tercero = '11'
 AND aa.cod_cia = bb.cod_cia
 AND aa.tip_docum = bb.tip_docum
 AND aa.cod_docum = bb.cod_docum
 --and aa.cod_tercero = nvl(l_codigo_gestor, aa.cod_tercero)
 AND EXISTS (
 SELECT 1
 FROM a1001332@tron oficina,
 mp_agentes_mpv@tron relacion
 WHERE relacion.tip_agt1 IN (10, 11)
 AND relacion.tip_agt2 IN
 (101, 112)
 --102 es el codigo de directores oficina
 AND relacion.mca_inh = 'N'
 AND relacion.cod_agt = oficina.cod_agt
 AND relacion.fec_validez =
 (SELECT MAX (fecha.fec_validez)
 FROM mp_agentes_mpv@tron fecha
 WHERE fecha.cod_agt =
 relacion.cod_agt)
 AND aa.cod_cia = oficina.cod_cia
 AND aa.tip_docum = oficina.tip_docum
 AND aa.cod_docum = oficina.cod_docum
 --and oficina.cod_nivel3 = nvl(l_codigo_oficina,oficina.cod_nivel3)
 ---AND RELACION.COD_AGT = nvl(as_Codigo,relacion.cod_agt)
 )
 --and usf_obtener_oficina_gestor(nvl(l_codigo_gestor, aa.cod_tercero)) = nvl(l_codigo_oficina, usf_obtener_oficina_gestor(nvl(l_codigo_gestor, aa.cod_tercero)))
 AND EXISTS (
 SELECT 1
 FROM a1001332@tron oficina
 WHERE aa.cod_cia =
 oficina.cod_cia
 -- and oficina.cod_nivel3 = nvl(l_codigo_oficina,oficina.cod_nivel3)
 AND aa.tip_docum = oficina.tip_docum
 AND aa.cod_docum = oficina.cod_docum)
 AND TRIM (ape1_tercero || ape2_tercero || nom_tercero) LIKE
 '%'
 || NVL (REPLACE (as_descrip, ' ', '%'),
 ape1_tercero
 )
 || '%'
 AND (as_codigo IS NULL OR aa.cod_tercero = as_codigo)
 --AND AA.COD_CIA=2
 GROUP BY aa.cod_tercero);

 OPEN o_cursor FOR
 SELECT *
 FROM (SELECT ROWNUM filas, t.*
 FROM (SELECT MAX
 (NVL (TRIM ( ape1_tercero
 || ' '
 || ape2_tercero
 || ' '
 || nom_tercero
 ),
 'SIN EJECUTIVO'
 )
 ) descripcion,
 aa.cod_tercero codigo
 FROM a1001390@tron aa, a1001399@tron bb
 WHERE aa.cod_act_tercero = '11'
 AND aa.cod_cia = bb.cod_cia
 AND aa.tip_docum = bb.tip_docum
 AND aa.cod_docum = bb.cod_docum
 --and aa.cod_tercero = nvl(l_codigo_gestor, aa.cod_tercero)
 AND EXISTS (
 SELECT 1
 FROM a1001332@tron oficina,
 mp_agentes_mpv@tron relacion
 WHERE relacion.tip_agt1 IN (10, 11)
 AND relacion.tip_agt2 IN
 (101, 112)
 --102 es el codigo de directores oficina
 AND relacion.mca_inh = 'N'
 AND relacion.cod_agt =
 oficina.cod_agt
 AND relacion.fec_validez =
 (SELECT MAX
 (fecha.fec_validez
 )
 FROM mp_agentes_mpv@tron fecha
 WHERE fecha.cod_agt =
 relacion.cod_agt)
 AND aa.cod_cia = oficina.cod_cia
 AND aa.tip_docum =
 oficina.tip_docum
 AND aa.cod_docum =
 oficina.cod_docum
 --and oficina.cod_nivel3 = nvl(l_codigo_oficina,oficina.cod_nivel3)
 ---AND RELACION.COD_AGT = nvl(as_Codigo,relacion.cod_agt)
 )
 --and usf_obtener_oficina_gestor(nvl(l_codigo_gestor, aa.cod_tercero)) = nvl(l_codigo_oficina, usf_obtener_oficina_gestor(nvl(l_codigo_gestor, aa.cod_tercero)))
 AND EXISTS (
 SELECT 1
 FROM a1001332@tron oficina
 WHERE aa.cod_cia =
 oficina.cod_cia
 -- and oficina.cod_nivel3 = nvl(l_codigo_oficina,oficina.cod_nivel3)
 AND aa.tip_docum =
 oficina.tip_docum
 AND aa.cod_docum =
 oficina.cod_docum)
 AND TRIM ( ape1_tercero
 || ape2_tercero
 || nom_tercero
 ) LIKE
 '%'
 || NVL (REPLACE (as_descrip, ' ', '%'),
 ape1_tercero
 )
 || '%'
 AND ( as_codigo IS NULL
 OR aa.cod_tercero = as_codigo
 )
 --AND AA.COD_CIA=2
 GROUP BY aa.cod_tercero
 ORDER BY descripcion ASC) t)
 WHERE filas BETWEEN (an_numpagina - 1) * an_tampagina + 1
 AND an_numpagina * an_tampagina;
 ELSIF as_tipbusqueda = 'AGENTE'
 THEN
 --LISTAR AGENTE
 SELECT COUNT (*)
 INTO an_totregistro
 FROM (SELECT agt.cod_agt,
 MAX (TRIM ( ter.ape1_tercero
 || ' '
 || ter.ape2_tercero
 || ' '
 || ter.nom_tercero
 )
 ) AS nom_agt
 FROM a1001332@tron agt, a1001399@tron ter
 WHERE agt.cod_cia = ter.cod_cia
 AND agt.tip_docum = ter.tip_docum
 AND agt.cod_docum = ter.cod_docum
 AND (as_codigo IS NULL OR agt.cod_agt = as_codigo)
 AND ( as_codgestor IS NULL
 OR agt.cod_ejecutivo = as_codgestor
 )
 --and agt.cod_nivel3 = nvl(l_codigo_oficina, agt.cod_nivel3)
 AND TRIM ( ter.ape1_tercero
 || ter.ape2_tercero
 || ter.nom_tercero
 ) LIKE
 '%' || NVL (as_descrip, ter.ape1_tercero)
 || '%'
 GROUP BY agt.cod_agt
 UNION --SW FACTORY 02/12/2013
 SELECT cc.cod_agt,
 bb.ape1_tercero
 || ' '
 || bb.ape2_tercero
 || ' '
 || bb.nom_tercero AS nom_agt
 FROM a1001390@tron aa,
 a1001399@tron bb,
 a1001332@tron cc
 WHERE aa.cod_act_tercero = '11'
 AND aa.cod_cia = bb.cod_cia
 AND aa.tip_docum = bb.tip_docum
 AND aa.cod_docum = bb.cod_docum
 AND aa.cod_cia = cc.cod_cia
 AND aa.tip_docum = cc.tip_docum
 AND aa.cod_docum = cc.cod_docum
 AND aa.cod_tercero = as_codgestor
 AND (as_codigo IS NULL OR cc.cod_agt = as_codigo)
 AND TRIM ( bb.ape1_tercero
 || bb.ape2_tercero
 || bb.nom_tercero
 ) LIKE
 '%'
 || NVL (REPLACE (as_descrip, ' ', '%'), '%')
 || '%'
 GROUP BY cc.cod_agt,
 bb.ape1_tercero
 || ' '
 || bb.ape2_tercero
 || ' '
 || bb.nom_tercero) x;

 OPEN o_cursor FOR
 SELECT *
 FROM (SELECT ROWNUM filas, t.*
 FROM (SELECT x.cod_agt codigo, x.nom_agt descripcion
 FROM (SELECT agt.cod_agt,
 MAX
 (TRIM ( ter.ape1_tercero
 || ' '
 || ter.ape2_tercero
 || ' '
 || ter.nom_tercero
 )
 ) AS nom_agt
 FROM a1001332@tron agt,
 a1001399@tron ter
 WHERE agt.cod_cia = ter.cod_cia
 AND agt.tip_docum = ter.tip_docum
 AND agt.cod_docum = ter.cod_docum
 AND ( as_codigo IS NULL
 OR agt.cod_agt = as_codigo
 )
 AND ( as_codgestor IS NULL
 OR agt.cod_ejecutivo =
 as_codgestor
 )
 --and agt.cod_nivel3 = nvl(l_codigo_oficina, agt.cod_nivel3)
 AND TRIM ( ter.ape1_tercero
 || ter.ape2_tercero
 || ter.nom_tercero
 ) LIKE
 '%'
 || NVL (as_descrip,
 ter.ape1_tercero
 )
 || '%'
 GROUP BY agt.cod_agt
 UNION --SW FACTORY 02/12/2013
 SELECT cc.cod_agt,
 bb.ape1_tercero
 || ' '
 || bb.ape2_tercero
 || ' '
 || bb.nom_tercero AS nom_agt
 FROM a1001390@tron aa,
 a1001399@tron bb,
 a1001332@tron cc
 WHERE aa.cod_act_tercero = '11'
 AND aa.cod_cia = bb.cod_cia
 AND aa.tip_docum = bb.tip_docum
 AND aa.cod_docum = bb.cod_docum
 AND aa.cod_cia = cc.cod_cia
 AND aa.tip_docum = cc.tip_docum
 AND aa.cod_docum = cc.cod_docum
 AND aa.cod_tercero = as_codgestor
 AND ( as_codigo IS NULL
 OR cc.cod_agt = as_codigo
 )
 AND TRIM ( bb.ape1_tercero
 || bb.ape2_tercero
 || bb.nom_tercero
 ) LIKE
 '%'
 || NVL
 (REPLACE (as_descrip,
 ' ',
 '%'
 ),
 '%'
 )
 || '%'
 GROUP BY cc.cod_agt,
 bb.ape1_tercero
 || ' '
 || bb.ape2_tercero
 || ' '
 || bb.nom_tercero) x
 ORDER BY x.nom_agt ASC) t)
 WHERE filas BETWEEN (an_numpagina - 1) * an_tampagina + 1
 AND an_numpagina * an_tampagina;
 ELSIF as_tipbusqueda = 'CLIENTE'
 THEN
 --LISTAR CLIENTE - EMPRESA
 /*--> Codigo original
 SELECT COUNT (*)
 INTO an_totregistro
 FROM (SELECT *
 FROM (SELECT b.cod_docum codigo,
 b.nom_tercero
 || ' '
 || b.ape1_tercero
 || ' '
 || b.ape2_tercero descripcion
 FROM tron2000.a2000030@tron a INNER JOIN tron2000.a1001399@tron b
 ON b.cod_cia = a.cod_cia
 AND b.tip_docum = a.tip_docum
 AND b.cod_docum = a.cod_docum
 WHERE a.cod_agt = NVL (as_codgestor, a.cod_agt)
 AND a.cod_cia = 2
 AND a.cod_ramo = 610 -- CIA : MPV - RAMO:610
 AND a.tip_docum = 'RUC'
 AND a.cod_docum = NVL (as_codigo, a.cod_docum)
 AND ( as_descrip IS NULL
 OR b.nom_tercero
 || ' '
 || b.ape1_tercero
 || ' '
 || b.ape2_tercero LIKE
 '%'
 || REPLACE (as_descrip, ' ', '%')
 || '%'
 ))
 GROUP BY codigo, descripcion);

 OPEN o_cursor FOR
 SELECT *
 FROM (SELECT ROWNUM filas, t.*
 FROM (SELECT *
 FROM (SELECT b.cod_docum codigo,
 b.nom_tercero
 || ' '
 || b.ape1_tercero
 || ' '
 || b.ape2_tercero descripcion
 FROM tron2000.a2000030@tron a INNER JOIN tron2000.a1001399@tron b
 ON b.cod_cia = a.cod_cia
 AND b.tip_docum = a.tip_docum
 AND b.cod_docum = a.cod_docum
 WHERE a.cod_agt =
 NVL (as_codgestor, a.cod_agt)
 AND a.cod_cia = 2
 AND a.cod_ramo =
 610
 -- CIA : MPV - RAMO:610
 AND a.tip_docum = 'RUC'
 AND a.cod_docum =
 NVL (as_codigo, a.cod_docum)
 AND ( as_descrip IS NULL
 OR b.nom_tercero
 || ' '
 || b.ape1_tercero
 || ' '
 || b.ape2_tercero LIKE
 '%'
 || REPLACE (as_descrip,
 ' ',
 '%'
 )
 || '%'
 ))
 GROUP BY codigo, descripcion) t)
 WHERE filas BETWEEN (an_numpagina - 1) * an_tampagina + 1
 AND an_numpagina * an_tampagina;*/

 Qselect:=Qselect ||' SELECT b.cod_docum codigo,
 b.nom_tercero
 || '' '' || b.ape1_tercero
 || '' ''|| b.ape2_tercero descripcion
 FROM tron2000.a2000030@tron a INNER JOIN tron2000.a1001399@tron b
 ON b.cod_cia = a.cod_cia
 AND b.tip_docum = a.tip_docum
 AND b.cod_docum = a.cod_docum
 WHERE 1=1 ';
 IF as_codgestor IS NOT NULL THEN --> PARA FILTRAR POR CODIGO DE AGENTE
 Qselect:= Qselect || ' AND a.cod_agt = '||as_codgestor||' ';
 END IF;
 Qselect:= Qselect || ' AND (a.cod_cia = 2 or a.cod_cia = 3)
 AND (a.cod_ramo = 610 or a.cod_ramo = 701 or a.cod_ramo = 702) ';
 -- CIA : MPV - RAMO:610
 IF as_codigo IS NOT NULL THEN
 Qselect:= Qselect || ' AND a.tip_docum = ''RUC''
 AND a.cod_docum = '''||as_codigo||''' ';
 END IF;

 IF as_descrip IS NOT NULL THEN
 Qselect:=Qselect || ' AND ( b.nom_tercero
 || '' ''
 || b.ape1_tercero
 || '' ''
 || b.ape2_tercero LIKE ''%''|| REPLACE ('''||as_descrip||''','' '',''%'')|| ''%'') ';
 END IF;

 Qcountini:= ' SELECT COUNT (*)
 FROM (SELECT *
 FROM ( ';

 Qcountfin:= ' )
 GROUP BY codigo, descripcion) ';

 Qcursorini :=' SELECT *
 FROM (SELECT ROWNUM filas, t.*
 FROM (SELECT *
 FROM ( ';

 Qcursorfin :=' ) GROUP BY codigo, descripcion) t)
 WHERE filas BETWEEN ( '||an_numpagina||' - 1) * '||an_tampagina||' + 1 AND '||an_numpagina|| ' * '|| an_tampagina ||' ';

 select max(id_error) + 1 into id_error
 from sctrmineria.log_error;

 insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
 values(id_error,Qcountini|| Qselect ||Qcountfin,'CONTADOR',1,'FTELLO',SYSDATE);
 COMMIT;

 select max(id_error) + 1 into id_error
 from sctrmineria.log_error;

 insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
 values(id_error,Qcursorini ||Qselect ||Qcursorfin,'CURSOR',1,'FTELLO',SYSDATE);
 COMMIT;

 EXECUTE IMMEDIATE Qcountini|| Qselect ||Qcountfin into an_totregistro;

 OPEN o_cursor FOR Qcursorini ||Qselect ||Qcursorfin;

 ELSIF as_tipbusqueda = 'ASEGURADO'
 THEN
 --LISTAR ASEGURADOS
 SELECT COUNT (*)
 INTO an_totregistro
 FROM (SELECT *
 FROM (SELECT a.nro_documento codigo,
 a.primer_nombre
 || ' '
 || a.segundo_nombre
 || ' '
 || a.ape_paterno
 || ' '
 || a.ape_materno descripcion,
 a.tipo_doc
 FROM oim.rcen_asegurados a
 WHERE a.nro_documento =
 NVL (as_codigo, a.nro_documento)
 AND ( as_descrip IS NULL
 OR a.primer_nombre
 || ' '
 || a.segundo_nombre
 || ' '
 || a.ape_paterno
 || ' '
 || a.ape_materno LIKE
 '%'
 || REPLACE (as_descrip, ' ', '%')
 || '%'
 ))
 GROUP BY codigo, descripcion, tipo_doc);

 OPEN o_cursor FOR
 SELECT *
 FROM (SELECT ROWNUM filas, t.*
 FROM (SELECT *
 FROM (SELECT a.nro_documento codigo,
 a.primer_nombre
 || ' '
 || a.segundo_nombre
 || ' '
 || a.ape_paterno
 || ' '
 || a.ape_materno descripcion,
 a.tipo_doc
 FROM oim.rcen_asegurados a
 WHERE a.nro_documento =
 NVL (as_codigo,
 a.nro_documento
 )
 AND ( as_descrip IS NULL
 OR a.primer_nombre
 || ' '
 || a.segundo_nombre
 || ' '
 || a.ape_paterno
 || ' '
 || a.ape_materno LIKE
 '%'
 || REPLACE (as_descrip,
 ' ',
 '%'
 )
 || '%'
 ))
 GROUP BY codigo, descripcion, tipo_doc) t)
 WHERE filas BETWEEN (an_numpagina - 1) * an_tampagina + 1
 AND an_numpagina * an_tampagina;
 END IF;
 END psctrcenmt001;

/*==============================================================================
PROPOSITO: LISTA POLIZA.
AUTOR: AALVARADO FECHA: 29/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_Cod_Corredor -> Codigo de Agente
 - as_Cod_Documen -> Codigo de Documento
 - as_Num_Poliza -> Numero de Poliza
 - as_Col_Asegura -> Colectivo Asegurado
 - o_cursor -> Cursor
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Listado de Poliza segun los parametro de entrada.
==============================================================================*/
 PROCEDURE psctrcen000 (
 as_cod_corredor IN VARCHAR2,
 as_cod_documen IN VARCHAR2,
 as_num_poliza IN VARCHAR2,
 as_col_asegura IN VARCHAR2,
 o_cursor OUT t_cursor
 )
 IS
 BEGIN
 OPEN o_cursor FOR
 SELECT DISTINCT (poliza.num_poliza), poliza.cod_ramo,
 (SELECT MAX (ramo.nom_ramo)
 FROM a1001800@tron ramo
 WHERE ramo.cod_ramo = poliza.cod_ramo) nom_ramo,
 (CASE TRIM
 (oim.oim_k_sctr.f_recupera_dv_ad
 (poliza.cod_cia,
 poliza.num_poliza,
 poliza.cod_agt,
 0,
 1,
 'MCA_POL_MES_ADELANTADO',
 poliza.cod_ramo,
 'VAL'
 )
 )
 WHEN 'S'
 THEN UPPER('mes adelantado')
 WHEN 'N'
 THEN UPPER('mes vencido')
 ELSE NULL
 END
 ) tip_declaracion,
 (SELECT f.fec_efec_poliza
 FROM a2000030@tron f
 WHERE f.cod_cia = poliza.cod_cia
 AND f.cod_ramo = poliza.cod_ramo
 AND f.num_poliza = poliza.num_poliza
 AND f.num_apli = 0
 AND f.num_spto = poliza.num_spto)
 fec_efec_poliza,
 (SELECT f.fec_vcto_poliza
 FROM a2000030@tron f
 WHERE f.cod_cia = poliza.cod_cia
 AND f.cod_ramo = poliza.cod_ramo
 AND f.num_poliza = poliza.num_poliza
 AND f.num_apli = 0
 AND f.num_spto = poliza.num_spto) vigencia,
 oim.oim_k_sctr.f_obtiene_poliza_enlace
 (poliza.num_poliza)
 poliza_relacionada,
 oim.oim_k_sctr.nom_colectivo
 (poliza.cod_cia,
 poliza.num_poliza
 ) colectivo,
 poliza.tip_docum, poliza.cod_docum, poliza.cod_agt,
 oim.oim_k_sctr.nom_contratante
 (poliza.cod_cia,
 poliza.tip_docum,
 poliza.cod_docum
 ) nombre_contratante
 FROM a2000030@tron poliza
 WHERE poliza.cod_cia = 2 --NAPFRE PERU VIDA
 AND poliza.cod_ramo = 610 --RAMO VIDA LEY
 AND poliza.fec_vcto_spto >= TRUNC (SYSDATE)
 AND poliza.fec_efec_spto - 15 <= TRUNC (SYSDATE)
 AND poliza.tip_docum = 'RUC'
 AND poliza.cod_docum = as_cod_documen
 AND (poliza.cod_agt = as_cod_corredor OR as_cod_corredor IS NULL)
 AND poliza.num_apli != 0
 AND poliza.mca_poliza_anulada = 'N'
 AND poliza.num_spto_apli =
 (SELECT MAX (p.num_spto_apli)
 FROM a2000030@tron p
 WHERE p.cod_cia = poliza.cod_cia
 AND p.cod_ramo = poliza.cod_ramo
 AND p.num_poliza = poliza.num_poliza
 AND p.num_spto = poliza.num_spto
 AND p.num_apli = poliza.num_apli
 AND p.tip_docum = poliza.tip_docum
 AND p.cod_docum = poliza.cod_docum
 AND p.cod_agt = poliza.cod_agt
 AND p.mca_spto_anulado = 'N'
 AND p.mca_poliza_anulada = 'N')
--> cambio de agenciamiento ---
 AND NOT EXISTS (
 SELECT 1
 FROM a2000030@tron p
 WHERE p.cod_cia = poliza.cod_cia
 AND p.cod_ramo = poliza.cod_ramo
 AND p.num_poliza = poliza.num_poliza
 AND p.tip_docum = poliza.tip_docum
 AND p.cod_docum = poliza.tip_docum
 AND p.num_apli = 0
 AND p.num_spto_apli = 0
 AND p.num_spto = -- :max_spto
 (SELECT MAX (num_spto)
 FROM a2000030@tron x
 WHERE x.cod_cia = poliza.cod_cia
 AND x.cod_ramo = poliza.cod_ramo
 AND x.num_poliza = poliza.num_poliza
 AND x.num_apli = 0
 AND p.num_spto_apli = 0
 AND p.tip_docum = poliza.tip_docum
 AND p.cod_docum = poliza.tip_docum
 AND p.tip_spto = 'CA')
 AND p.cod_agt != poliza.cod_agt
 AND p.tip_spto = 'CA'
 AND p.mca_poliza_anulada = 'N'
 AND p.mca_spto_anulado = 'N'
 AND p.fec_efec_spto <= poliza.fec_efec_spto)
---------------------------- cambio
 AND ( as_col_asegura IS NULL
 OR oim.oim_k_sctr.nom_colectivo (poliza.cod_cia,
 poliza.num_poliza
 ) LIKE
 '%' || as_col_asegura || '%'
 )
 AND (poliza.num_poliza IN
 (as_num_poliza,
 oim.oim_k_sctr.f_obtiene_poliza_relacionada
 (as_num_poliza)
 )
 OR
 as_num_poliza IS NULL
 )
 --and not trim(oim.oim_k_sctr.f_recupera_dv_ad(poliza.cod_cia, poliza.num_poliza, poliza.cod_agt, 0, 1, 'MCA_POL_MES_ADELANTADO', poliza.cod_ramo, 'VAL')) is null
 ORDER BY poliza_relacionada ASC, vigencia DESC;
 END psctrcen000;

/*==============================================================================
PROPOSITO: LISTA APLICACION.
AUTOR: AALVARADO FECHA: 23/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_Cod_Corredor -> Codigo de Agente
 - as_rol_web -> Rol de Usuario Web
 - as_tip_docum -> Tipo Documento Empresa
 - as_Cod_Documen -> Codigo de Documento Empresa
 - as_Num_Poliza -> Numero de Poliza
 - o_cursor -> Cursor
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Lista Aplicaciones de una determinada Poliza.
==============================================================================*/
 PROCEDURE psctrcen001 (
 as_cod_corredor IN VARCHAR2,
 as_rol_web IN VARCHAR2,
 as_tip_docum IN VARCHAR2,
 as_cod_documen IN VARCHAR2,
 as_num_poliza IN VARCHAR2,
 o_cursor OUT t_cursor
 )
 IS
 BEGIN
 OPEN o_cursor FOR
 SELECT x.tip_docum,x.cod_ramo,x.cod_docum,x.num_poliza,x.num_apli,
 TO_CHAR (x.fec_efec_poliza, 'DD/MM/YYYY') fec_efec_poliza,
 TO_CHAR (x.fec_vcto_poliza, 'DD/MM/YYYY') fec_vcto_poliza,
 (CASE
 WHEN oim.oim_k_sctr.usf_marca_declarada (x.cod_docum,x.cod_cia,x.num_poliza,x.num_spto,x.num_apli,x.num_spto_apli) = 'S'
 THEN UPPER('declarada')
 ELSE UPPER('no declarada')
 END) est_vigencia,
 x.num_spto, x.num_spto_apli, x.cod_cia
 FROM tron2000.a2000030@tron x
 WHERE x.cod_cia= 2
 AND x.cod_ramo = 610
 AND x.num_poliza = as_num_poliza
 AND x.tip_docum = as_tip_docum
 AND x.cod_docum = as_cod_documen
 AND x.cod_agt = NVL (as_cod_corredor, x.cod_agt)
 /*AND oim.oim_k_sctr.f_tiene_aplicacion_spto_poliza (x.num_poliza,
 x.num_spto
 ) = 'S'*/
 AND ( ( x.fec_efec_spto < SYSDATE
 AND x.fec_vcto_spto + 1 > SYSDATE)
 OR ( ( TO_CHAR (SYSDATE, 'DD') > 15
 AND TO_CHAR (LAST_DAY (SYSDATE) + 1, 'MM') =
 TO_CHAR (x.fec_efec_spto + 2, 'MM'))
 AND ( x.fec_efec_spto > SYSDATE
 AND (x.fec_efec_spto < SYSDATE + 20))
 )
 OR ( TO_CHAR (LAST_DAY (SYSDATE), 'RRRRMM') =
 TO_CHAR (x.fec_efec_spto, 'RRRRMM')
 AND x.fec_vcto_spto + 1 > SYSDATE
 )
 OR
 (0 = DECODE(as_rol_web,'ADMIN',(CASE WHEN to_char(sysdate,'DD')< 15
 THEN (CASE WHEN x.fec_vcto_spto BETWEEN (SYSDATE-16) AND SYSDATE
 THEN 0
 ELSE 1 END)
 ELSE 1 END),1))
 )
 AND x.num_apli != 0
 AND x.num_spto_apli =
 (SELECT MAX (num_spto_apli)
 FROM a2000030@tron b
 WHERE b.cod_cia = x.cod_cia
 AND b.cod_ramo = x.cod_ramo
 AND b.tip_docum = x.tip_docum
 AND b.cod_docum = x.cod_docum
 AND b.cod_agt = x.cod_agt
 AND b.num_poliza = x.num_poliza
 AND b.num_spto = x.num_spto
 AND b.num_apli = x.num_apli
 AND b.mca_spto_anulado = 'N')
 AND x.mca_poliza_anulada = 'N'
 AND NOT EXISTS(
 SELECT 1
 FROM a2000030@tron p
 WHERE p.cod_cia = x.cod_cia
 AND p.cod_ramo = x.cod_ramo
 AND p.tip_docum = x.tip_docum
 AND p.cod_docum = x.cod_docum
 AND p.cod_agt != x.cod_agt
 AND p.num_poliza = x.num_poliza
 AND p.num_spto >= x.num_spto + 1
 AND p.num_apli = 0
 AND p.tip_spto = 'CA'
 AND p.fec_efec_spto <= x.fec_efec_spto)

 ORDER BY x.fec_efec_poliza,x.fec_vcto_poliza,x.num_apli,x.num_spto_apli;
 /*SELECT x.num_apli,
 TO_CHAR (x.fec_efec_poliza, 'DD/MM/YYYY') fec_efec_poliza,
 TO_CHAR (x.fec_vcto_poliza, 'DD/MM/YYYY') fec_vcto_poliza,
 (CASE
 WHEN oim.oim_k_sctr.usf_marca_declarada (x.cod_docum,
 x.cod_cia,
 x.num_poliza,
 x.num_spto,
 x.num_apli,
 x.num_spto_apli
 ) = 'S'
 THEN 'declarada'
 ELSE 'no declarada'
 END
 ) est_vigencia,
 (SELECT r.num_recibo
 FROM a2990700@tron r
 WHERE r.num_poliza = x.num_poliza
 AND r.num_spto = x.num_spto
 AND r.num_apli = x.num_apli
 AND ( NOT (oim.oim_k_sctr.f_verifica_estado_rec
 (r.cod_cia,
 r.num_recibo,
 SYSDATE
 ) IN
 ('6', '7')
 )
 OR oim.oim_k_sctr.f_verifica_estado_rec
 (r.cod_cia,
 r.num_recibo,
 SYSDATE
 ) IS NULL
 )
 AND r.num_spto_apli =
 NVL ((SELECT MIN (num_spto_apli)
 FROM a2000030@tron s
 WHERE s.num_poliza = r.num_poliza
 AND s.num_spto = r.num_spto
 AND s.num_apli = r.num_apli
 AND s.sub_cod_spto = 30
 AND s.mca_poliza_anulada = 'N'
 AND s.mca_spto_anulado = 'N'),
 x.num_spto_apli
 )) num_recibo,
 (SELECT imp_recibo
 FROM a2990700@tron r
 WHERE r.num_poliza = x.num_poliza
 AND r.num_spto = x.num_spto
 AND r.num_apli = x.num_apli
 AND ( NOT (oim.oim_k_sctr.f_verifica_estado_rec
 (r.cod_cia,
 r.num_recibo,
 SYSDATE
 ) IN
 ('6', '7')
 )
 OR oim.oim_k_sctr.f_verifica_estado_rec
 (r.cod_cia,
 r.num_recibo,
 SYSDATE
 ) IS NULL
 )
 AND r.num_spto_apli =
 NVL ((SELECT MIN (num_spto_apli)
 FROM a2000030@tron s
 WHERE s.num_poliza = r.num_poliza
 AND s.num_spto = r.num_spto
 AND s.num_apli = r.num_apli
 AND s.sub_cod_spto = 30
 AND s.mca_poliza_anulada = 'N'
 AND s.mca_spto_anulado = 'N'),
 x.num_spto_apli
 )) monto,
 (SELECT oim.oim_k_sctr.f_estado_recibo
 (r.tip_situacion,
 x.fec_vcto_spto
 )
 FROM a2990700@tron r
 WHERE r.num_poliza = x.num_poliza
 AND r.num_spto = x.num_spto
 AND r.num_apli = x.num_apli
 AND ( NOT (oim.oim_k_sctr.f_verifica_estado_rec
 (r.cod_cia,
 r.num_recibo,
 SYSDATE
 ) IN
 ('6', '7')
 )
 OR oim.oim_k_sctr.f_verifica_estado_rec
 (r.cod_cia,
 r.num_recibo,
 SYSDATE
 ) IS NULL
 )
 AND r.num_spto_apli =
 NVL ((SELECT MIN (num_spto_apli)
 FROM a2000030@tron s
 WHERE s.num_poliza = r.num_poliza
 AND s.num_spto = r.num_spto
 AND s.num_apli = r.num_apli
 AND s.sub_cod_spto = 30
 AND s.mca_poliza_anulada = 'N'
 AND s.mca_spto_anulado = 'N'),
 x.num_spto_apli
 )) estado_recibo,
 (SELECT TRUNC
 (TO_DATE
 (oim.oim_k_sctr.fec_venci_recibo
 (x.cod_cia,
 r.tip_docum_pago,
 r.cod_docum_pago,
 r.num_recibo,
 x.fec_vcto_spto,
 x.fec_efec_spto
 )
 )
 )
 FROM a2990700@tron r
 WHERE r.num_poliza = x.num_poliza
 AND r.num_spto = x.num_spto
 AND r.num_apli = x.num_apli
 AND ( NOT (oim.oim_k_sctr.f_verifica_estado_rec
 (r.cod_cia,
 r.num_recibo,
 SYSDATE
 ) IN
 ('6', '7')
 )
 OR oim.oim_k_sctr.f_verifica_estado_rec
 (r.cod_cia,
 r.num_recibo,
 SYSDATE
 ) IS NULL
 )
 AND r.num_spto_apli =
 NVL ((SELECT MIN (num_spto_apli)
 FROM a2000030@tron s
 WHERE s.cod_cia = r.cod_cia
 AND s.num_poliza = r.num_poliza
 AND s.num_spto = r.num_spto
 AND s.num_apli = r.num_apli
 AND s.sub_cod_spto = 30
 AND s.mca_poliza_anulada = 'N'
 AND s.mca_spto_anulado = 'N'),
 x.num_spto_apli
 )) vencimiento,
 x.num_spto, x.num_spto_apli, x.cod_cia
 FROM tron2000.a2000030@tron x
 WHERE x.num_poliza = as_num_poliza
 AND x.tip_docum = 'RUC'
 AND x.cod_docum = as_cod_documen
 AND x.cod_agt = NVL (as_cod_corredor, x.cod_agt)
 AND oim.oim_k_sctr.f_tiene_aplicacion_spto_poliza (x.num_poliza,
 x.num_spto
 ) = 'S'
 AND ( ( x.fec_efec_spto < SYSDATE
 AND x.fec_vcto_spto + 1 > SYSDATE
 )
 OR ( ( TO_CHAR (SYSDATE, 'DD') > 15
 AND TO_CHAR (LAST_DAY (SYSDATE) + 1, 'MM') =
 TO_CHAR (x.fec_efec_spto + 2, 'MM')
 )
 AND ( x.fec_efec_spto > SYSDATE
 AND (x.fec_efec_spto < SYSDATE + 20)
 )
 )
 OR ( TO_CHAR (LAST_DAY (SYSDATE), 'RRRRMM') =
 TO_CHAR (x.fec_efec_spto, 'RRRRMM')
 AND x.fec_vcto_spto + 1 > SYSDATE
 )
 --OR
 --(0 = DECODE(p_rol_web,'ADMIN',(CASE WHEN to_char(sysdate,'DD')< 15
 -- THEN (CASE WHEN x.fec_vcto_spto BETWEEN (SYSDATE-16) AND SYSDATE
 -- THEN 0
 -- ELSE 1 END)
 -- ELSE 1 END),1))
 )
 AND x.num_apli != 0
 AND x.num_spto_apli =
 (SELECT MAX (num_spto_apli)
 FROM a2000030@tron b
 WHERE b.cod_cia = x.cod_cia
 AND b.cod_ramo = x.cod_ramo
 AND b.tip_docum = x.tip_docum
 AND b.cod_docum = x.cod_docum
 AND b.cod_agt = x.cod_agt
 AND b.num_poliza = x.num_poliza
 AND b.num_spto = x.num_spto
 AND b.num_apli = x.num_apli
 AND b.mca_spto_anulado = 'N')
 AND x.mca_poliza_anulada = 'N'
 AND NOT EXISTS (
 SELECT 1
 FROM a2000030@tron p
 WHERE p.cod_cia = x.cod_cia
 AND p.cod_ramo = x.cod_ramo
 AND p.tip_docum = x.tip_docum
 AND p.cod_docum = x.cod_docum
 AND p.cod_agt = x.cod_agt
 AND p.num_poliza = x.num_poliza
 AND p.num_spto = x.num_spto + 1
 AND p.num_apli = 0
 AND p.tip_spto = 'CA'
 AND p.fec_efec_spto <= x.fec_efec_spto)
 ORDER BY x.fec_efec_poliza,
 x.fec_vcto_poliza,
 x.num_apli,
 x.num_spto_apli;*/
 END psctrcen001;

/*==============================================================================
PROPOSITO: LISTA APLICACIONES Y VIGENCIAS
AUTOR: CQUISPE FECHA: 29/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_Cod_Corredor -> Codigo de Agente
 - as_Cod_Documen -> Codigo de Documento
 - as_Num_Poliza -> Numero de Poliza
 - o_cursor -> Cursor
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Lista Aplicaciones y vigencias de una determinada Poliza.
==============================================================================*/
 PROCEDURE psctrcen002 (
 as_cod_corredor IN VARCHAR,
 as_cod_documen IN VARCHAR,
 as_num_poliza IN VARCHAR,
 o_cursor OUT t_cursor
 )
 IS
 BEGIN
 OPEN o_cursor FOR
 SELECT x.num_apli, x.fec_efec_spto, x.fec_vcto_spto, x.num_spto
 FROM a2000030@tron x
 WHERE cod_cia = '2'
 AND cod_ramo = '610'
 AND x.cod_docum = as_cod_documen
 AND x.num_poliza = as_num_poliza
 AND x.cod_agt = NVL(as_cod_corredor,x.cod_agt)
 AND x.num_apli != 0
 AND x.mca_poliza_anulada = 'N'
 AND x.mca_spto_anulado = 'N'
 AND x.fec_efec_spto < TRUNC (SYSDATE)
 AND x.num_spto_apli =
 (SELECT MAX (b.num_spto_apli)
 FROM a2000030@tron b
 WHERE b.cod_cia = x.cod_cia
 AND b.cod_ramo = x.cod_ramo
 AND b.tip_docum = x.tip_docum
 AND b.cod_docum = x.cod_docum
 AND b.num_poliza = x.num_poliza
 AND b.num_spto = x.num_spto
 AND b.num_apli = x.num_apli)
 order by x.fec_vcto_spto desc;
 END psctrcen002;

/*==============================================================================
PROPOSITO: LISTA LOS DATOS DEL ASEGURADO
AUTOR: CQUISPE FECHA: 29/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_num_poliza -> Numero de poliza
 - as_num_apli -> Numero de aplicacion
 - an_cod_aseg -> Codigo de Asegurado
 - as_fec_ini -> Fecha inicio de vigenci
 - as_fec_fin -> Fecha fin de vigencia
 - o_cursor -> Cursor de resultado de la consulta
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Lista los datos del asegurado para una poliza con fecha de vigencia especifica - utilizado para exportar planilla excel
==============================================================================*/
 PROCEDURE psctrcen003 (
 as_num_poliza IN VARCHAR2,
 as_num_apli IN NUMBER DEFAULT NULL,
 an_cod_aseg IN NUMBER DEFAULT NULL,
 as_fec_ini IN DATE,
 as_fec_fin IN DATE,
 o_cursor OUT t_cursor
 )
 IS
 a_ramo NUMBER;
 BEGIN
 a_ramo := TO_NUMBER (SUBSTR (as_num_poliza, 1, 3));

 OPEN o_cursor FOR
 SELECT b.tipo_doc, b.nro_documento, b.ape_paterno, b.ape_materno,
 (b.primer_nombre || ' ' || b.segundo_nombre) nombres,
 b.nombre_completo, b.fec_nac, a.sueldo, a.ocupacion,
 a.mca_baja, b.ind_reniec, a.nro_movimiento, a.cod_aseg
 FROM oim.rcen_aseg0004 a INNER JOIN oim.rcen_asegurados b
 ON b.cod_aseg = a.cod_aseg
 WHERE a.num_poliza = as_num_poliza
 AND a.cod_aseg = NVL (an_cod_aseg, a.cod_aseg)
 AND a.num_apli = NVL (as_num_apli, a.num_apli)
 AND a.fec_ini_vig = TRUNC (as_fec_ini)
 AND a.fec_fin_vig = TRUNC (as_fec_fin)
 AND a.cod_ramo = a_ramo
 AND a.cod_cia = DECODE (a_ramo, 610, 2, 701, 2, 702, 3);
 END psctrcen003;

/*==============================================================================
PROPOSITO: LISTA LOS DOCUMENTOS RELACIONADOS A UN NUMERO DE POLIZA
AUTOR: CQUISPE FECHA: 30/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_Num_Poliza -> Numero de poliza
 - as_Num_Apli -> Numero de aplicacion
 - as_Fec_Ini -> Fecha de inicio de vigencia
 - as_Fec_Fin -> Fecha fin de vigencia
 - tip_documento -> Fecha fin de vigencia
 - cod_documento -> Fecha fin de vigencia
 - as_num_spto -> Fecha fin de vigencia
 - an_numpagina -> Numero de pagina
 - an_tampagina -> Tamano de pagina
 - an_totregistro -> Total de REgistros
 - o_cursor -> Cursor
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Lista los documentos relacionados a un numero de poliza
==============================================================================*/
 PROCEDURE psctrcen004 (
 as_num_poliza IN VARCHAR2,
 as_num_apli IN VARCHAR2,
 as_fec_ini IN DATE,
 as_fec_fin IN DATE,
 tip_documento IN VARCHAR2,
 cod_documento IN VARCHAR2,
 as_num_spto IN NUMBER,
 --paginado
 an_numpagina IN NUMBER,
 an_tampagina IN NUMBER,
 an_totregistro OUT NUMBER,
 o_cursor OUT t_cursor
 )
 IS
 cCantReg varchar(4000);
 cCantFrom varchar(4000);
 cCantWhere varchar(4000);

 cSelect varchar(4000);
 cFrom varchar(4000);
 cWhere varchar(4000);

 cAnd varchar(5);
 nInicio number;
 nFin number;

 a_ramo NUMBER;
 BEGIN
 a_ramo := TO_NUMBER (SUBSTR (as_num_poliza, 1, 3));

 nInicio := (an_numpagina - 1) * an_tampagina + 1;
 nFin := an_numpagina * an_tampagina;
 cAnd:='';
 an_totregistro:= 0;
 cCantReg := 'SELECT count(1) ';
 cCantFrom := ' FROM oim.rcen_aseg0001 a, oim.rcen_aseg0002 b ';
 cCantWhere := ' ';
 cCantWhere := cCantWhere || ' WHERE b.nro_movimiento = a.nro_movimiento';
 ------> datos del contratante
 cCantWhere := cCantWhere || ' AND a.TIP_DOCUMENTO = '''||tip_documento||'''';
 cCantWhere := cCantWhere || ' AND a.nro_documento = '''||cod_documento||'''';
 -->datos de la poliza----
 cCantWhere := cCantWhere || ' AND b.cod_cia = DECODE ('||TO_CHAR(a_ramo)||',610, 2, 701, 2, 702, 3)';
 cCantWhere := cCantWhere || ' AND b.cod_ramo = '||TO_CHAR(a_ramo);
 cCantWhere := cCantWhere || ' AND b.num_poliza = '''||as_num_poliza||'''';

 IF(as_num_spto IS NOT NULL)THEN
 cAnd := ' AND';
 cCantWhere := cCantWhere || cAnd || ' b.num_spto = '||TO_CHAR(as_num_spto);
 END IF;
 IF(as_num_apli IS NOT NULL)THEN
 cAnd := ' AND';
 cCantWhere := cCantWhere || cAnd || ' b.num_apli = '||TO_CHAR(as_num_apli);
 END IF;
 IF(as_fec_ini IS NOT NULL)THEN
 cAnd := ' AND';
 cWhere := cWhere || cAnd || ' a.fec_ini_vig = TO_DATE('''||TO_CHAR(as_fec_ini,'DD/MM/YYYY')||''',''DD/MM/YYYY'')';
 END IF;
 IF(as_fec_fin IS NOT NULL)THEN
 cAnd := ' AND';
 cWhere := cWhere || cAnd || ' a.fec_fin_vig = TO_DATE('''||TO_CHAR(as_fec_fin,'DD/MM/YYYY')||''',''DD/MM/YYYY'')';
 END IF;

 EXECUTE IMMEDIATE cCantReg || cCantFrom || cCantWhere INTO an_totregistro;

 ------
 cAnd := '';
 cSelect := 'SELECT * FROM (SELECT ROWNUM filas, t.* FROM ('
 || ' SELECT a.nro_movimiento, a.fec_ini_vig, a.fec_fin_vig,'
 || ' (SELECT b.PREFIJO||''/''||b.ANIO||''/''|| b.NRO_DOCUMENTO FROM oim.rcen_aseg0005 b where b.NRO_MOVIMIENTO =a.NRO_MOVIMIENTO) nro_constancia,'
 || ' a.fec_reg, a.cod_usr_reg, b.num_recibo, a.tipo_movimeinto, b.cod_cia, b.num_spto,'
 || ' b.num_spto_apli, b.cod_sistema, a.mca_facturado, a.mca_baja,'
 || ' oim.oim_k_sctr.validar_mov_anulado (b.num_poliza, b.num_spto, b.num_apli, b.num_spto_apli) mca_baja_tron,'
 || ' b.num_poliza, b.num_apli';
 cFrom := cCantFrom;
 cWhere := cCantWhere;
 cWhere := cWhere || ' order by a.FEC_REG desc) t) '
 || ' WHERE filas BETWEEN '||to_char(nInicio)||' and '||to_char(nFin)||' ';

 OPEN o_cursor FOR
 cSelect || cFrom || cWhere;

 END psctrcen004;

/*=====================================================================
 PROPOSITO: Actualizar datos de la Tabla RCEN_ASEG0001 - ANULAR UN MOVIMIENTO
 AUTOR: CQUISPE FECHA:06/01/2015
 ---------------------------------------------------------------------
 DATOS RELEVANTES:
 - an_NumMovimiento -> Numer de movimiento
 - as_Usuario -> Usuario Creador o Actualizador
 - an_Retorno -> Retorno (1: Actualizacion exitoso, -1: Error)
 - as_Mensaje -> Mensaje en caso de Error
 ---------------------------------------------------------------------
 DESCRIPCION FUNCIONAL:
 - Actualizar datos de la Tabla RCEN_ASEG0001 - ANULAR UN MOVIMIENTO
 ========================================================================*/
 PROCEDURE psctrcenmt002 (
 an_nummovimiento IN rcen_aseg0001.nro_movimiento%TYPE,
 as_usuario IN rcen_aseg0001.cod_usr_actu%TYPE,
 an_retorno OUT NUMBER,
 as_mensaje OUT VARCHAR
 )
 AS
 BEGIN
 UPDATE rcen_aseg0001
 SET mca_baja = 'S',
 cod_usr_actu = as_usuario,
 fec_actu = SYSDATE
 WHERE nro_movimiento = an_nummovimiento;

 UPDATE rcen_aseg0004
 SET mca_baja = 'S',
 cod_usr_actu = as_usuario,
 fec_actu = SYSDATE
 WHERE nro_movimiento = an_nummovimiento;

 UPDATE rcen_aseg0005
 SET mca_baja = 'S',
 cod_usr_actu = as_usuario,
 fec_actu = SYSDATE
 WHERE nro_movimiento = an_nummovimiento;

 UPDATE rcen_aseg0006
 SET mca_baja = 'S',
 cod_usr_actu = as_usuario,
 fec_actu = SYSDATE
 WHERE nro_movimiento = an_nummovimiento;

 UPDATE rcen_movimientos
 SET estado = 'I',
 cod_usr_baja = as_usuario,
 fec_baja = SYSDATE
 WHERE cod_movim_sc = an_nummovimiento;

 COMMIT;
 an_retorno := 1;
 EXCEPTION
 WHEN OTHERS
 THEN
 an_retorno := -1;
 as_mensaje := SQLERRM;
 END psctrcenmt002;

/*==============================================================================
PROPOSITO: LISTA DE ASEGURADO
AUTOR: JRODAS FECHA: 07/01/2015
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_tipo_docum -> Tipo de documento
 - as_num_docum -> Numero de aplicacion
 - as_nom_aseg -> Nombre de Asegurado
 - o_cursor -> Cursor de resultado de la consulta
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Lista los datos del asegurado por los filtros: tipo de documento, numero de documento o nombre del asegurado
==============================================================================*/
 PROCEDURE psctrcen005 (
 as_tipo_docum IN VARCHAR2,
 as_num_docum IN VARCHAR2,
 as_nom_aseg IN VARCHAR2,
 o_cursor OUT t_cursor
 )
 IS
 BEGIN
 OPEN o_cursor FOR
 SELECT a.tipo_doc, a.nro_documento, a.ape_paterno, a.ape_materno,
 (a.primer_nombre || ' ' || a.segundo_nombre) nombres,
 DECODE (
 A.ape_paterno,
 NULL, A.nombre_completo,
 A.ape_paterno
 || ' '
 || A.ape_materno
 || ', '
 || A.primer_nombre || ' ' || a.segundo_nombre) nombre_completo, a.cod_aseg, a.primer_nombre,
 a.segundo_nombre, a.sexo, a.fec_nac, a.estado, a.ind_reniec
 FROM oim.rcen_asegurados a
 WHERE a.tipo_doc = nvl(as_tipo_docum,a.tipo_doc) AND a.nro_documento = nvl(as_num_docum,a.nro_documento);
 END psctrcen005;

/*==============================================================================
PROPOSITO: LISTA LOS DOCUMENTOS RELACIONADOS A UN NUMERO DE POLIZA Y CONSTANCIA
AUTOR: JRODAS FECHA: 09/01/2015
---------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_tip_docum_aseg -> Tipo Documento Asegurado
 - as_num_docum_aseg -> Nro. Documento Asegurado
 - as_Num_Poliza -> Numero de poliza
 - an_Num_Constancia ->Numero de constancia
 - as_Ruc ->RUC
 - an_numpagina -> Numero de pagina
 - an_tampagina -> Tamano de pagina
 - an_totregistro -> Total Registros
 - o_cursor -> Cursor
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Lista los documentos relacionados a un numero de poliza y numero de constancia
==============================================================================*/
 PROCEDURE psctrcen006 (
 as_tip_docum_aseg IN VARCHAR2,
 as_num_docum_aseg IN VARCHAR2,
 as_num_poliza IN VARCHAR2,
 an_num_constancia IN NUMBER,
 as_ruc IN VARCHAR2,
 --paginado
 an_numpagina IN NUMBER,
 an_tampagina IN NUMBER,
 an_totregistro OUT NUMBER,
 o_cursor OUT t_cursor
 )
 IS
 c_select VARCHAR(4000);
 c_from VARCHAR(4000);
 c_where VARCHAR(4000);
 BEGIN
 c_select := 'SELECT aseg01.nro_movimiento, aseg01.fec_ini_vig, ';
 c_select := c_select || 'aseg01.fec_fin_vig, ';
 c_select := c_select || '(SELECT b.NRO_DOCUMENTO FROM oim.rcen_aseg0005 b where b.NRO_MOVIMIENTO =aseg01.NRO_MOVIMIENTO) nro_documento ';
 c_select := c_select || ',aseg01.fec_reg,aseg01.cod_usr_reg ';
 c_select := c_select || ',aseg02.num_recibo, ';
 c_select := c_select || 'aseg01.tipo_movimeinto, aseg02.cod_cia, aseg02.num_spto, ';
 c_select := c_select || 'decode(aseg01.tipo_movimeinto,''IN'',''INCLUSION'',''DE'',''DECLARACION'',''DO'',''DOCUMENTO'',aseg01.tipo_movimeinto) desc_tip_movimiento, ';
 c_select := c_select || 'aseg02.num_spto_apli, aseg02.cod_sistema, ';
 c_select := c_select || 'aseg01.mca_facturado, aseg01.mca_baja, ';
 c_select := c_select || 'oim.oim_k_sctr.validar_mov_anulado ';
 c_select := c_select || '(aseg02.num_poliza, ';
 c_select := c_select || 'aseg02.num_spto, ';
 c_select := c_select || 'aseg02.num_apli, ';
 c_select := c_select || 'aseg02.num_spto_apli ';
 c_select := c_select || ') mca_baja_tron ';
 c_select := c_select || ',(SELECT b.PREFIJO FROM oim.rcen_aseg0005 b where b.NRO_MOVIMIENTO =aseg01.NRO_MOVIMIENTO) prefijo ';
 c_select := c_select || ',(SELECT b.ANIO FROM oim.rcen_aseg0005 b where b.NRO_MOVIMIENTO =aseg01.NRO_MOVIMIENTO) anio ';
 --c_select := c_select || ',(SELECT c.cod_aseg FROM oim.rcen_aseg0004 b,oim.rcen_asegurados c where b.cod_aseg = c.cod_aseg and b.nro_movimiento = aseg01.nro_movimiento and c.TIPO_DOC =NVL( ''' || as_tip_docum_aseg || ''', c.TIPO_DOC) and c.NRO_DOCUMENTO =NVL( ''' || as_num_docum_aseg || ''',c.NRO_DOCUMENTO)) cod_aseg ';
 c_select := c_select || ',aseg02.num_poliza,aseg02.num_apli ';
 c_from := ' FROM oim.rcen_aseg0001 aseg01,oim.rcen_aseg0002 aseg02 ';
 c_where := 'where aseg01.NRO_MOVIMIENTO = aseg02.NRO_MOVIMIENTO ';
 -----> PARA BUSCAR POR TIPO Y NUMERO DE DOCUMENTO DEL CONTRATANTE
 if not as_ruc is null then
 c_where := c_where || 'AND aseg01.TIP_DOCUMENTO = ''RUC'' ';
 c_where := c_where || 'AND aseg01.NRO_DOCUMENTO =NVL( ''' || as_ruc || ''',aseg01.NRO_DOCUMENTO) ';
 end if;

 if not as_num_poliza is null then
 IF (SUBSTR(as_num_poliza,1,3) = 610) THEN
 c_where := c_where || 'AND aseg02.COD_cia = 2 ';
 c_where := c_where || 'AND aseg02.COD_RAMO = 610 ';
 ELSIF(SUBSTR(as_num_poliza,1,3) = 701 ) THEN
 c_where := c_where || 'AND aseg02.COD_cia = 2 ';
 c_where := c_where || 'AND aseg02.COD_RAMO = 701 ';
 ELSIF(SUBSTR(as_num_poliza,1,3) = 702 ) THEN
 c_where := c_where || 'AND aseg02.COD_cia = 3 ';
 c_where := c_where || 'AND aseg02.COD_RAMO = 702 ';
 END IF;
 c_where := c_where || 'AND aseg02.num_poliza =NVL( ''' || as_num_poliza || ''', aseg02.num_poliza) ';
 end if;

 -----> PARA BUSCAR POR TIPO Y NUMERO DE DOCUMENTO DEL ASEGURADO
 if as_num_docum_aseg is not null then
 c_where := c_where || 'AND EXISTS( ';
 c_where := c_where || 'SELECT 1 FROM oim.rcen_aseg0004 b, oim.rcen_asegurados c ';
 c_where := c_where || 'where b.cod_aseg = c.cod_aseg ';
 c_where := c_where || 'and b.nro_movimiento = aseg01.nro_movimiento ';
 c_where := c_where || 'and b.MCA_BAJA =''N'' ';
 c_where := c_where || 'and c.TIPO_DOC =NVL( ''' || as_tip_docum_aseg || ''', c.TIPO_DOC) ';
 c_where := c_where || 'and c.NRO_DOCUMENTO =NVL( ''' || as_num_docum_aseg || ''',c.NRO_DOCUMENTO)) ';
 end if;

 -----> PARA BUSCAR POR NUMERO DE CONSTANCIA
 if not an_num_constancia is null then
 c_where := c_where || 'AND EXISTS(SELECT 1 FROM oim.rcen_aseg0005 b ';
 c_where := c_where || 'where b.nro_movimiento = aseg01.nro_movimiento ';
 c_where := c_where || 'AND b.nro_documento =NVL( ' || an_num_constancia || ',b.nro_documento))';
 end if;

 --SELECT PARA TOTAL DE REGISTROS
 EXECUTE IMMEDIATE ('SELECT COUNT (*) ' || c_from || c_where) INTO an_totregistro ;

 --ARMANDO CONSULTA FINAL
 OPEN o_cursor FOR 'SELECT * FROM (SELECT ROWNUM filas, t.* FROM (' || c_select || c_from || c_where || ') t) WHERE filas BETWEEN (' || an_numpagina || ' - 1) * ' || an_tampagina || ' + 1 AND ' || an_numpagina || ' * ' || an_tampagina;
 END psctrcen006;

/*==============================================================================
PROPOSITO: LISTA LAS VIGENCIAS DE LAS P¿LIZAS
AUTOR: JRODAS FECHA: 09/01/2015
---------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_Num_Poliza -> Numero de poliza
 - an_Cod_Aseg ->Codigo de asegurado
 - o_cursor -> Cursor
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Lista las vigencias de una poliza seleccionada
==============================================================================*/
 PROCEDURE psctrcen007 (
 as_num_poliza IN VARCHAR2,
 an_cod_aseg IN NUMBER,
 o_cursor OUT t_cursor
 )
 IS
 BEGIN
 OPEN o_cursor FOR
 SELECT DISTINCT a.fec_ini_vig ini_vig, a.fec_fin_vig fin_vig
 FROM oim.rcen_aseg0004 a
 WHERE a.num_poliza = as_num_poliza
 AND a.cod_aseg = an_cod_aseg;
 END psctrcen007;

/*=====================================================================
 PROPOSITO: Actualizar datos de la Tabla RCEN_ASEG0001 - RCEN_ASEGURADOS
 AUTOR: JRODAS FECHA:09/01/2015
 ------------------------------------------------------------------------
 DATOS RELEVANTES:
 -an_codaseg -> Codigo Asegurado
 - an_NumMovimiento -> Numero de movimiento
 -as_TipoDoc -> Tipo de documento del asegurado
 -as_NroDoc -> Numero de documento del asegurado
 -as_NomCompleto -> Nombre completo de asegurado
 -as_nombres -> Primer nombre de asegurado
 -as_ApePat -> Apellido paterno del asegurado
 -as_ApeMat -> Apellido materno del asegurado
 -as_Ocupacion -> Ocupacion de asegurado
 -an_Sueldo -> Sueldo de asegurado
 -as_fecnac -> Fecha Nacimiento
 - as_Usuario -> Usuario Creador o Actualizador
 -an_Tipo -> Porcion de query a ejecutar
 - o_cursor -> Cursor de retorno
 ---------------------------------------------------------------------
 DESCRIPCION FUNCIONAL:
 - Actualizar datos de la Tabla RCEN_ASEG0001 - RCEN_ASEGURADOS
 ========================================================================*/
 PROCEDURE psctrcenmt003 (
 an_codaseg IN rcen_aseg0004.cod_aseg%TYPE,
 an_nummovimiento IN rcen_aseg0004.nro_movimiento%TYPE,
 as_tipodoc IN rcen_asegurados.tipo_doc%TYPE,
 as_nrodoc IN rcen_asegurados.nro_documento%TYPE,
 as_nomcompleto IN rcen_asegurados.nombre_completo%TYPE,
 as_nombres IN rcen_asegurados.primer_nombre%TYPE,
 as_apepat IN rcen_asegurados.ape_paterno%TYPE,
 as_apemat IN rcen_asegurados.ape_materno%TYPE,
 as_ocupacion IN rcen_aseg0004.ocupacion%TYPE,
 an_sueldo IN rcen_aseg0004.sueldo%TYPE,
 as_fecnac IN rcen_asegurados.fec_nac%TYPE,
 as_usuario IN rcen_aseg0004.cod_usr_actu%TYPE,
 an_tipo IN NUMBER,
 o_cursor OUT t_cursor
 )
 AS
 an_retorno NUMBER;
 as_mensaje VARCHAR2 (400 BYTE);
 as_primernom VARCHAR (50 BYTE);
 as_segundonom VARCHAR (50 BYTE);
 an_existe NUMBER := 0;
 an_nuevocodaseg NUMBER;
 an_nuevonummov NUMBER;
 er_Repetido EXCEPTION;
 an_contrepetido NUMBER:=0;
 BEGIN
 IF INSTR (as_nombres, ' ') <> 0
 THEN
 as_primernom := SUBSTR (as_nombres, 0, INSTR (as_nombres, ' ') - 1);
 as_segundonom := SUBSTR (as_nombres, INSTR (as_nombres, ' ') + 1);
 ELSE
 as_primernom := as_nombres;
 as_segundonom := '';
 END IF;

 IF an_tipo = 1
 THEN --Si no se cambia de tipo y numero de documento
 UPDATE oim.rcen_aseg0004
 SET ocupacion = as_ocupacion,
 sueldo = an_sueldo,
 cod_usr_actu = as_usuario,
 fec_actu = SYSDATE
 WHERE nro_movimiento = an_nummovimiento AND cod_aseg = an_codaseg;

 UPDATE oim.rcen_asegurados
 SET primer_nombre = as_primernom,
 segundo_nombre = as_segundonom,
 ape_paterno = as_apepat,
 ape_materno = as_apemat,
 nombre_completo = as_nomcompleto,
 fec_nac = TRUNC (as_fecnac),
 cod_usr_mod = as_usuario,
 fec_mod = SYSDATE
 WHERE cod_aseg = an_codaseg AND ind_reniec = 'N'
 OR ind_reniec IS NULL;
 ELSIF an_tipo = 2
 THEN --Se cambia de tipo y numero de documento
 BEGIN
 SELECT 1
 INTO an_existe
 FROM DUAL
 WHERE EXISTS (
 SELECT 1
 FROM oim.rcen_asegurados
 WHERE nro_documento = as_nrodoc
 AND tipo_doc = as_tipodoc
 AND estado = 'A');
 EXCEPTION
 WHEN NO_DATA_FOUND
 THEN
 an_existe := 0;
 END;

 IF an_existe = 0
 THEN
 oim.oim_k_rcen.insertar_asegurado (as_nombres,
 as_nomcompleto,
 as_apepat,
 as_apemat,
 TRUNC (as_fecnac),
 as_nrodoc,
 as_tipodoc,
 as_usuario,
 0,
 an_retorno,
 as_mensaje
 );
 ELSE
 UPDATE oim.rcen_asegurados
 SET primer_nombre = as_primernom,
 segundo_nombre = as_segundonom,
 ape_paterno = as_apepat,
 ape_materno = as_apemat,
 nombre_completo = as_nomcompleto,
 fec_nac = TRUNC (as_fecnac),
 cod_usr_mod = as_usuario,
 fec_mod = SYSDATE
 WHERE nro_documento = as_nrodoc
 AND tipo_doc = as_tipodoc
 AND estado = 'A'
 AND ind_reniec = 'N'
 OR ind_reniec IS NULL;
 END IF;
 --Actualizamos datos y damos de baja al registro
 UPDATE oim.rcen_aseg0004
 SET ocupacion = as_ocupacion,
 sueldo = an_sueldo,
 mca_baja = 'S',
 cod_usr_actu = as_usuario,
 fec_actu = SYSDATE
 WHERE nro_movimiento = an_nummovimiento AND cod_aseg = an_codaseg;

 --Obtenemos nuevo codigo de asegurado
 SELECT cod_aseg
 INTO an_nuevocodaseg
 FROM oim.rcen_asegurados
 WHERE nro_documento = as_nrodoc
 AND tipo_doc = as_tipodoc
 AND estado = 'A';

 SELECT COUNT(*) INTO an_contrepetido FROM OIM.RCEN_ASEG0004 WHERE NRO_MOVIMIENTO = an_nummovimiento AND COD_ASEG = an_nuevocodaseg;
 IF an_contrepetido>0 THEN
 RAISE er_Repetido;
 END IF;
 --Insertamos nuevo registro con nuevo codigo de asegurado
 INSERT INTO oim.rcen_aseg0004
 (cod_aseg, nro_movimiento, cod_cia, cod_ramo, num_poliza,
 num_spto, num_apli, num_spto_apli, fec_ini_vig,
 fec_fin_vig, mca_baja, sueldo, ocupacion, cod_usr_reg,
 fec_reg)
 SELECT an_nuevocodaseg, nro_movimiento, cod_cia, cod_ramo,
 num_poliza, num_spto, num_apli, num_spto_apli, fec_ini_vig,
 fec_fin_vig, 'N', sueldo, ocupacion, as_usuario, SYSDATE
 FROM oim.rcen_aseg0004
 WHERE nro_movimiento = an_nummovimiento AND cod_aseg = an_codaseg;

 --Damos de baja al movimiento en la tabla rcen_movimientos
 UPDATE oim.rcen_movimientos
 SET estado = 'I',
 fec_baja = SYSDATE,
 cod_usr_baja = as_usuario
 WHERE cod_aseg = an_codaseg AND cod_movim_sc = an_nummovimiento;

 --Insertamos nuevo movimiento a nuevo asegurado en tabla rcen_movimientos
 SELECT oim.seq_indice_movimiento.NEXTVAL
 INTO an_nuevonummov
 FROM DUAL;

 INSERT INTO oim.rcen_movimientos
 (cod_aseg, cod_movim, tip_docum, cod_docum, cod_cia,
 cod_ramo, num_poliza, num_spto, num_apli, num_spto_apli,
 fec_ini_vig, fec_fin_vig, sist_orig, fec_alta,
 cod_usuario, fec_creacion, ocup_aseg, estado,
 cod_movim_sc)
 SELECT an_nuevocodaseg, an_nuevonummov, tip_docum, tip_docum,
 cod_cia, cod_ramo, num_poliza, num_spto, num_apli,
 num_spto_apli, fec_ini_vig, fec_fin_vig, sist_orig,
 SYSDATE, as_usuario, SYSDATE, ocup_aseg, 'A', cod_movim_sc
 FROM oim.rcen_movimientos
 WHERE cod_aseg = an_codaseg AND cod_movim_sc = an_nummovimiento;
 END IF;

 COMMIT;
 an_retorno := 1;
 as_mensaje := 'OK';

 OPEN o_cursor FOR
 SELECT an_retorno retorno, as_mensaje mensaje
 FROM DUAL;
 EXCEPTION
 WHEN er_Repetido THEN
 an_retorno := -1;
 as_mensaje := 'EL NUMERO DE DOCUMENTO YA SE ENCUENTRA REGISTRADO EN EL MOVIMIENTO';
 ROLLBACK;

 OPEN o_cursor FOR
 SELECT an_retorno retorno, as_mensaje mensaje
 FROM DUAL;

 WHEN OTHERS THEN
 an_retorno := -1;
 as_mensaje := SQLERRM;
 ROLLBACK;

 OPEN o_cursor FOR
 SELECT an_retorno retorno, as_mensaje mensaje
 FROM DUAL;
 END psctrcenmt003;

/*==============================================================================
 PROPOSITO: Obtener los datos del asegurado para llenar la trama de emision de una poliza en especifico
 AUTOR: CQUISPE FECHA: 12/01/2015
 ------------------------------------------------------------------------------
 DATOS RELEVANTES
 - an_cod_cia -> Numero de CIA
 - an_cod_ramo -> Numero de Ramo
 - as_cod_docum -> Codigo de Documento
 - as_num_poliza -> Numero de poliza
 - o_cursor -> Cursor de resultado de la consulta
 ------------------------------------------------------------------------------
 DESCRIPCION FUNCIONAL
 - Obtener los datos del asegurado para llenar la trama de emision de una poliza en especifico
 ==============================================================================*/
 PROCEDURE psctrcen008 (
 an_cod_cia IN NUMBER,
 an_cod_ramo IN NUMBER,
 as_cod_docum IN VARCHAR2,
 as_num_poliza IN VARCHAR2,
 o_cursor OUT t_cursor)
 IS
 BEGIN
 OPEN o_cursor FOR
 SELECT T.*,C.SUELDO,C.OCUPACION FROM(
 SELECT a.cod_aseg, a.ape_paterno, a.ape_materno, a.primer_nombre,
 a.segundo_nombre, a.nombre_completo, a.tipo_doc, a.nro_documento,
 a.sexo, a.fec_nac, a.cod_usuario, a.fec_creacion, a.estado, ind_reniec,
 a.cod_usr_mod, a.fec_mod,B.cod_cia,B.COD_MOVIM_SC
 FROM oim.rcen_asegurados a ,oim.rcen_movimientos b
 WHERE a.cod_aseg=b.cod_aseg
 and
 b.cod_cia = an_cod_cia
 AND b.cod_ramo = an_cod_ramo
 and b.cod_docum=as_cod_docum
 AND b.num_poliza = as_num_poliza
 AND b.num_spto = 0
 AND b.num_apli = 1
 AND b.num_spto_apli = 1) T LEFT JOIN OIM.RCEN_ASEG0004 C
 ON C.COD_ASEG=T.cod_aseg AND C.NRO_MOVIMIENTO=T.COD_MOVIM_SC AND C.COD_CIA=T.cod_cia;
 END psctrcen008;

/*==============================================================================
PROPOSITO: Lista a los Asegurados que pertenecen a una poliza y aplicacion - paginado
AUTOR: CQUISPE FECHA: 15/01/2015
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_Num_Poliza -> Numero de poliza
 - an_Num_Spto -> Numero de suplemento
 - an_Num_Apli -> Numero de aplicacion
 - as_TipoDoc -> Tipo de documento del asegurado
 - as_NroDoc -> Numero de documento del asegurado
 - as_NomCompleto -> Nombre completo del asegurado
 - an_numpagina -> Numero de Pagina
 - an_tampagina -> Tamano de Pagina
 - an_totregistro -> Total Registros
 - o_cursor -> Cursor de resultado de la consulta
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Lista a los Asegurados que pertenecen a una poliza y aplicacion - paginado
==============================================================================*/
 PROCEDURE psctrcen009 (
 as_Num_Poliza IN rcen_aseg0004.num_poliza%TYPE,
 an_Num_Spto IN rcen_aseg0004.num_spto%TYPE,
 an_Num_Apli IN rcen_aseg0004.num_apli%TYPE,
 as_TipoDoc IN rcen_asegurados.tipo_doc%TYPE,
 as_NroDoc IN rcen_asegurados.nro_documento%TYPE,
 as_NomCompleto IN rcen_asegurados.nombre_completo%TYPE,
 an_numpagina IN NUMBER,
 an_tampagina IN NUMBER,
 an_totregistro OUT NUMBER,
 o_cursor OUT t_cursor
 )
 AS

 cCantReg varchar(4000);
 cCantFrom varchar(4000);
 cCantWhere varchar(4000);

 cSelect varchar(4000);
 cFrom varchar(4000);
 cWhere varchar(4000);

 cAnd varchar(5);
 nInicio number;
 nFin number;

 BEGIN
 nInicio := (an_numpagina - 1) * an_tampagina + 1;
 nFin := an_numpagina * an_tampagina;
 cAnd:='';
 an_totregistro:= 0;
 cCantReg := 'SELECT count(1) ';
 cCantFrom := ' FROM OIM.RCEN_ASEG0004 ase4 LEFT JOIN OIM.RCEN_ASEGURADOS aseg ON (ase4.cod_aseg= aseg.cod_aseg) ';
 cCantWhere := ' ';
 cCantWhere := cCantWhere || ' WHERE COD_CIA=2 AND COD_RAMO=610 AND MCA_BAJA= ''N''';
 IF(as_Num_Poliza IS NOT NULL)THEN
 cAnd := ' AND';
 cCantWhere := cCantWhere || cAnd ||' NUM_POLIZA = '''||as_Num_Poliza||'''';
 END IF;
 IF(an_Num_Spto IS NOT NULL)THEN
 cAnd := ' AND';
 cCantWhere := cCantWhere || cAnd || ' num_spto = '||TO_CHAR(an_Num_Spto);
 END IF;
 IF(an_Num_Apli IS NOT NULL)THEN
 cAnd := ' AND';
 cCantWhere := cCantWhere || cAnd || ' num_apli = '||TO_CHAR(an_Num_Apli);
 END IF;
 IF(as_TipoDoc IS NOT NULL)THEN
 cAnd := ' AND';
 cCantWhere := cCantWhere || cAnd || ' TIPO_DOC = '''||as_TipoDoc||'''';
 END IF;
 IF(as_NroDoc IS NOT NULL)THEN
 cAnd := ' AND';
 cCantWhere := cCantWhere || cAnd || ' NRO_DOCUMENTO = '''||as_NroDoc||'''';
 END IF;
 IF(as_NomCompleto IS NOT NULL)THEN
 cAnd := ' AND';
 cCantWhere := cCantWhere || cAnd || ' UPPER(NOMBRE_COMPLETO||'' ''||PRIMER_NOMBRE||'' ''||'' ''|| SEGUNDO_NOMBRE||'' ''||APE_PATERNO ||'' ''|| APE_MATERNO) LIKE ''%'' ||UPPER('''||as_NomCompleto||''')||''%''';
 END IF;


 EXECUTE IMMEDIATE cCantReg || cCantFrom || cCantWhere INTO an_totregistro;
 ------
 cAnd := '';

 IF an_numpagina=0 AND an_tampagina=0 THEN
 cSelect := ' SELECT ase4.COD_ASEG, NRO_MOVIMIENTO, COD_CIA, COD_RAMO, NUM_POLIZA, NUM_SPTO,'
 || ' NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG, FEC_FIN_VIG, MCA_BAJA, SUELDO, OCUPACION,'
 || ' COD_USR_REG, FEC_REG, COD_USR_ACTU, FEC_ACTU,'
 || ' APE_PATERNO, APE_MATERNO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, NOMBRE_COMPLETO, TIPO_DOC,'
 || ' NRO_DOCUMENTO, SEXO, FEC_NAC, COD_USUARIO, FEC_CREACION, ESTADO, IND_RENIEC, COD_USR_MOD, FEC_MOD';
 cFrom := cCantFrom;
 cWhere := cCantWhere;
 cWhere := cWhere;
 ELSE
 cSelect := 'SELECT z.* FROM ( SELECT x.*, ROWNUM AS Nrow FROM ('
 || ' SELECT ase4.COD_ASEG, NRO_MOVIMIENTO, COD_CIA, COD_RAMO, NUM_POLIZA, NUM_SPTO,'
 || ' NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG, FEC_FIN_VIG, MCA_BAJA, SUELDO, OCUPACION,'
 || ' COD_USR_REG, FEC_REG, COD_USR_ACTU, FEC_ACTU,'
 || ' APE_PATERNO, APE_MATERNO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, NOMBRE_COMPLETO, TIPO_DOC,'
 || ' NRO_DOCUMENTO, SEXO, FEC_NAC, COD_USUARIO, FEC_CREACION, ESTADO, IND_RENIEC, COD_USR_MOD, FEC_MOD';
 cFrom := cCantFrom;
 cWhere := cCantWhere;
 cWhere := cWhere || ' ORDER BY 1 DESC )x ) z '
 || ' WHERE Nrow BETWEEN '||to_char(nInicio)||' and '||to_char(nFin)||' ';
 END IF;
 OPEN o_cursor FOR
 cSelect || cFrom || cWhere;

 END psctrcen009;

/*==============================================================================
PROPOSITO: Lista datos de un asegurado en especifico
AUTOR: CQUISPE FECHA: 16/01/2015
------------------------------------------------------------------------------
DATOS RELEVANTES
 - an_Cod_Aseg -> Codigo asegurado
 - as_Num_Poliza -> Numero de poliza
 - an_Num_Apli -> Numero de aplicacion
 - an_Nro_Movimiento -> Numero de movimiento
 - an_Num_Spto -> Numero de suplemento
 - an_Num_Spto_Apli -> Numero de suplemento de aplicacion
 - o_cursor -> Cursor de resultado de la consulta
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
-Lista datos de un asegurado en especifico
==============================================================================*/
 PROCEDURE psctrcen010 (
 an_Cod_Aseg IN rcen_aseg0004.cod_aseg%TYPE,
 as_Num_Poliza IN rcen_aseg0004.num_poliza%TYPE,
 an_Num_Apli IN rcen_aseg0004.num_apli%TYPE,
 an_Nro_Movimiento IN rcen_aseg0004.nro_movimiento%TYPE,
 an_Num_Spto IN rcen_aseg0004.num_spto%TYPE,
 an_Num_Spto_Apli IN rcen_aseg0004.num_spto_apli%TYPE,
 o_cursor OUT t_cursor
 )
 AS

 BEGIN
 OPEN o_cursor FOR
 SELECT ase4.COD_ASEG, NRO_MOVIMIENTO, COD_CIA, COD_RAMO, NUM_POLIZA, NUM_SPTO,
 NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG, FEC_FIN_VIG, MCA_BAJA, SUELDO, OCUPACION,
 COD_USR_REG, FEC_REG, COD_USR_ACTU, FEC_ACTU,
 APE_PATERNO, APE_MATERNO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, NOMBRE_COMPLETO, TIPO_DOC,
 NRO_DOCUMENTO, SEXO, FEC_NAC, COD_USUARIO, FEC_CREACION, ESTADO, IND_RENIEC, COD_USR_MOD, FEC_MOD
 FROM OIM.RCEN_ASEG0004 ase4 LEFT JOIN OIM.RCEN_ASEGURADOS aseg ON (ase4.cod_aseg= aseg.cod_aseg)
 WHERE COD_CIA=2 AND COD_RAMO=610 AND MCA_BAJA= 'N'
 AND ase4.COD_ASEG = an_Cod_Aseg
 AND NUM_POLIZA = as_Num_Poliza
 AND NUM_APLI = an_Num_Apli
 AND NRO_MOVIMIENTO = an_Nro_Movimiento
 AND NUM_SPTO = an_Num_Spto
 AND NUM_SPTO_APLI = an_Num_Spto_Apli;

 END psctrcen010;

 /*=====================================================================
 PROPOSITO: Actualizar datos del asegurado
 AUTOR: CQUISPE FECHA:16/01/2015
 ------------------------------------------------------------------------
 DATOS RELEVANTES:
 -an_Cod_Aseg -> Codigo asegurado
 -as_Num_Poliza -> Numero de poliza
 -an_Num_Apli -> Numero de aplicacion
 -an_Nro_Movimiento -> Numero de movimiento
 -an_Num_Spto -> Numero de suplemento
 -an_Num_Spto_Apli -> Numero de suplemento de aplicacion
 -as_Tipo_Doc -> Tipo de documento del asegurado
 -as_Nro_Documento -> Numero de documento del asegurado
 -as_Nombre_Completo -> Nombre completo de asegurado
 -as_Primer_Nombre -> Primer nombre de asegurado
 -as_Segundo_Nombre -> Segundo nombre de asegurado
 -as_Ape_Paterno -> Apellido paterno del asegurado
 -as_Ape_Materno -> Apellido materno del asegurado
 -as_Ocupacion -> Ocupacion de asegurado
 -an_Sueldo -> Sueldo de asegurado
 - as_Cod_Usr -> Usuario Creador o Actualizador
 - an_Retorno -> Retorno (1: Actualizacion exitoso, -1: Error)
 - as_Mensaje -> Mensaje en caso de Error
 ---------------------------------------------------------------------
 DESCRIPCION FUNCIONAL:
 - Actualizar datos del asegurado
 ========================================================================*/
 PROCEDURE psctrcenmt004 (
 an_Cod_Aseg IN rcen_aseg0004.cod_aseg%TYPE,
 as_Num_Poliza IN rcen_aseg0004.num_poliza%TYPE,
 an_Num_Apli IN rcen_aseg0004.num_apli%TYPE,
 an_Nro_Movimiento IN rcen_aseg0004.nro_movimiento%TYPE,
 an_Num_Spto IN rcen_aseg0004.num_spto%TYPE,
 an_Num_Spto_Apli IN rcen_aseg0004.num_spto_apli%TYPE,
 as_Tipo_Doc IN rcen_asegurados.tipo_doc%TYPE,
 as_Nro_Documento IN rcen_asegurados.nro_documento%TYPE,
 as_Nombre_Completo IN rcen_asegurados.nombre_completo%TYPE,
 as_Primer_Nombre IN rcen_asegurados.primer_nombre%TYPE,
 as_Segundo_Nombre IN rcen_asegurados.segundo_nombre%TYPE,
 as_Ape_Paterno IN rcen_asegurados.ape_paterno%TYPE,
 as_Ape_Materno IN rcen_asegurados.ape_materno%TYPE,
 as_Ocupacion IN rcen_aseg0004.ocupacion%TYPE,
 an_Sueldo IN rcen_aseg0004.sueldo%TYPE,
 as_Cod_Usr IN rcen_aseg0004.cod_usr_actu%TYPE,
 an_Retorno OUT NUMBER,
 as_Mensaje OUT VARCHAR
 )
 AS

 BEGIN

 UPDATE OIM.RCEN_ASEG0004
 SET
 SUELDO = an_Sueldo,
 OCUPACION = as_Ocupacion,
 COD_USR_ACTU = as_Cod_Usr,
 FEC_ACTU = SYSDATE
 WHERE COD_CIA=2 AND COD_RAMO=610 AND MCA_BAJA= 'N'
 AND COD_ASEG = an_Cod_Aseg
 AND NUM_POLIZA = as_Num_Poliza
 AND NUM_APLI = an_Num_Apli
 AND NRO_MOVIMIENTO = an_Nro_Movimiento
 AND NUM_SPTO = an_Num_Spto
 AND NUM_SPTO_APLI = an_Num_Spto_Apli;

 UPDATE OIM.RCEN_ASEGURADOS
 SET
 APE_PATERNO= as_Ape_Paterno,
 APE_MATERNO= as_Ape_Materno,
 PRIMER_NOMBRE = as_Primer_Nombre,
 SEGUNDO_NOMBRE= as_Segundo_Nombre,
 NOMBRE_COMPLETO = as_Nombre_Completo,
 TIPO_DOC = NVL(as_Tipo_Doc, TIPO_DOC),
 NRO_DOCUMENTO = NVL(as_Nro_Documento, NRO_DOCUMENTO),
 COD_USR_MOD = as_Cod_Usr,
 FEC_MOD = SYSDATE
 WHERE
 COD_ASEG = an_Cod_Aseg;

 COMMIT;
 an_Retorno := 1;

 EXCEPTION
 WHEN OTHERS
 THEN
 an_Retorno := -1;
 as_Mensaje := SQLERRM;
 ROLLBACK;

 END psctrcenmt004;

 /*=====================================================================
 PROPOSITO: Ingresar datos a las tablas temporales, para el registro de Constancia
 AUTOR: CQUISPE FECHA:01901/2015
 ------------------------------------------------------------------------
 DATOS RELEVANTES:
 - as_Cadena -> Contiene el codigo del asegurado concatenado con numero de movimiento
 -an_Cod_Cia -> Codigo de compania
 -an_Cod_Ramo -> Codigo de ramo
 -as_Num_Poliza -> Numero de poliza
 -an_Num_Apli -> Numero de aplicacion
 -an_Num_Spto -> Numero de suplemento
 -an_Num_Spto_Apli -> Numero de suplemento de la aplicacion
 -as_Cod_Sistema -> Codigo del sistema
 -as_Tip_Docum -> Tipo de documento de la empresa
 -as_Nro_Docum -> Numero de documento de la empresa
 - ad_Fec_Ini_Vig -> Fecha de Inicio de vigencia
 -ad_Fec_Fin_Vig -> Fecha de fin de vigencia
 - as_Cod_Usr_Reg -> Usuario Creador o Actualizador
 -as_Ubicacion -> Ubicacion
 - an_Retorno -> Retorno (1: Actualizacion exitoso, -1: Error)
 - as_Mensaje -> Mensaje en caso de Error
 ---------------------------------------------------------------------
 DESCRIPCION FUNCIONAL:
 - Ingresar datos a las tablas temporales, para el registro de Constancia - rcen_aseg0001_temp, rcen_aseg0002_temp, rcen_aseg0004_temp
 ========================================================================*/
 PROCEDURE psctrcenmt005 (
 as_Cadena IN VARCHAR2,
 an_Cod_Cia IN NUMBER,
 an_Cod_Ramo IN NUMBER,
 as_Num_Poliza IN rcen_aseg0004.num_poliza%TYPE,
 an_Num_Apli IN rcen_aseg0004.num_apli%TYPE,
 an_Num_Spto IN rcen_aseg0004.num_spto%TYPE,
 an_Num_Spto_Apli IN rcen_aseg0004.num_spto_apli%TYPE,
 as_Cod_Sistema IN vARCHAR2,
 as_Tip_Docum IN VARCHAR2, -- principal
 as_Nro_Docum IN VARCHAR2, -- principal
 ad_Fec_Ini_Vig IN DATE,
 ad_Fec_Fin_Vig IN DATE,
 as_Cod_Usr_Reg IN rcen_aseg0004.cod_usr_actu%TYPE,
 as_Ubicacion IN VARCHAR2,
 an_Retorno OUT NUMBER,
 as_Mensaje OUT VARCHAR
 )
 AS
 nNro_Mov number;
 pStr varchar2(4000) := trim(as_Cadena);
 c_Split1 char := ';';
 c_Split2 char := '_';
 rpart varchar(255);
 nFila Number:=1;
 pos Number;
 pos2 Number;
 nCod_Aseg Varchar(20);
 nNro_Mov_Aseg Varchar(20);
 BEGIN
 SELECT OIM.SEQ_RCEN_ASEG0001.NEXTVAL INTO nNro_Mov FROM dual;

 INSERT INTO OIM.RCEN_ASEG0001_TEMP
 (NRO_MOVIMIENTO, TIP_DOCUMENTO, NRO_DOCUMENTO, FEC_INI_VIG, FEC_FIN_VIG, TIPO_MOVIMIENTO,
 MCA_FACTURADO, MCA_BAJA, COD_USR_REG, FEC_REG, COD_USR_ACTU, FEC_ACTU, UBICACION)
 VALUES
 (nNro_Mov, as_Tip_Docum, as_Nro_Docum, ad_Fec_Ini_Vig, ad_Fec_Fin_Vig, 'DO',
 'N', 'N', as_Cod_Usr_Reg, SYSDATE, as_Cod_Usr_Reg, SYSDATE, as_Ubicacion);

 INSERT INTO OIM.RCEN_ASEG0002_TEMP
 (NRO_MOVIMIENTO, COD_CIA, COD_RAMO, NUM_POLIZA, NUM_SPTO, NUM_APLI, NUM_SPTO_APLI, NUM_RECIBO,
 COD_SISTEMA, COD_USR_REG, FEC_REG, COD_USR_ACTU, FEC_ACTU)
 VALUES
 (nNro_Mov, an_Cod_Cia, an_Cod_Ramo, as_Num_Poliza, an_Num_Spto, an_Num_Apli, 0, NULL,
 as_Cod_Sistema, as_Cod_Usr_Reg, SYSDATE, as_Cod_Usr_Reg, SYSDATE);

 WHILE NVL(LENGTH(pStr),0) >0 LOOP
 pos:= INSTR(pStr, c_Split1);
 IF pos > 0 THEN
 rpart := SUBSTR(pStr, 1, pos-1);
 pStr := SUBSTR(pStr, pos+1, LENGTH(pStr));
 ---obteniendo el codigo de asegurado y nro de movimiento
 pos2 := INSTR(rpart, c_Split2);
 nCod_Aseg := SUBSTR(rpart, 1, pos2-1);
 nNro_Mov_Aseg := SUBSTR(rpart, pos2+1, LENGTH(rpart));
 ELSE
 rpart := pStr;
 pStr := NULL;
 ---obteniendo el codigo de asegurado y nro de movimiento
 pos2 := INSTR(rpart, c_Split2);
 nCod_Aseg := SUBSTR(rpart, 1, pos2-1);
 nNro_Mov_Aseg := SUBSTR(rpart, pos2+1, LENGTH(rpart));
 END IF;

 IF rpart IS NOT NULL THEN
 INSERT INTO OIM.RCEN_ASEG0004_TEMP
 (NRO_MOVIMIENTO, NRO_MOVIMIENTO_REG, NRO_FILA, TIPDOC, NUMDOC, APEPAT, APEMAT, NOMBRES,
 NOMBRECOMPLETO, FECNAC, SUELDO, OCUPACION, COD_USR_REG, FEC_REG)
 SELECT nNro_Mov, nNro_Mov_Aseg, nFila, TIPO_DOC, NRO_DOCUMENTO,
 SUBSTR(APE_PATERNO,1,20), SUBSTR(APE_MATERNO,1,20), SUBSTR(PRIMER_NOMBRE ||' ' || SEGUNDO_NOMBRE,1,30),
 SUBSTR(NOMBRE_COMPLETO,1,80), TO_CHAR(FEC_NAC, 'dd/mm/yyyy'), TO_CHAR(SUELDO), OCUPACION, as_Cod_Usr_Reg, SYSDATE
 FROM OIM.RCEN_ASEG0004 ase4 LEFT JOIN OIM.RCEN_ASEGURADOS aseg ON (ase4.cod_aseg= aseg.cod_aseg)
 WHERE COD_CIA=2 AND COD_RAMO=610 AND MCA_BAJA= 'N'
 AND ase4.COD_ASEG = nCod_Aseg
 AND NUM_POLIZA = as_Num_Poliza
 AND NUM_APLI = an_Num_Apli
 AND NRO_MOVIMIENTO = nNro_Mov_Aseg
 AND NUM_SPTO = an_Num_Spto
 --AND NUM_SPTO_APLI = an_Num_Spto_Apli
 AND ROWNUM = 1;

 nFila:= nFila+1;
 END IF;

 END LOOP
 COMMIT;
 an_Retorno := nNro_Mov;

 EXCEPTION
 WHEN OTHERS
 THEN
 an_Retorno := -1;
 as_Mensaje := SQLERRM;
 ROLLBACK;
 END psctrcenmt005;

/*==============================================================================
 PROPOSITO: VALIDAR LISTA DE TRABAJADORES SEGUN DECLARACION O INCLUSION.
 AUTOR: AALVARADO FECHA: 29/12/2014
 ------------------------------------------------------------------------------
 DATOS RELEVANTES
 - as_poliza -> Numero de Poliza
 - an_num_spto -> Numero de suplemento
 - an_num_apli -> Numero de Aplicacion
 - ad_fecini -> Fecha de Inicio
 - as_tip_movimiento -> Tipo de Movimiento
 - o_cursor -> Cursor
 ------------------------------------------------------------------------------
 DESCRIPCION FUNCIONAL
 - Lista de trabajadores faltantes para Declaracion, o trabajadores sobrantes para Inclusiones
 ==============================================================================*/
 PROCEDURE psctrcen011 (as_poliza IN VARCHAR2,
 an_num_spto IN NUMBER,
 an_num_apli IN NUMBER,
 ad_fecini IN DATE,
 as_tip_movimiento IN VARCHAR2,
 o_cursor OUT t_cursor)
 IS
 vl_fec_efec_spto DATE;
 vl_fec_vcto_spto DATE;
 BEGIN
 IF as_tip_movimiento = 'IN'
 THEN
 OPEN o_cursor FOR
 SELECT B.COD_ASEG,
 B.TIPO_DOC,
 B.NRO_DOCUMENTO,
 B.APE_PATERNO,
 B.APE_MATERNO,
 B.PRIMER_NOMBRE || ' ' || B.SEGUNDO_NOMBRE NOMBRES,
 B.NOMBRE_COMPLETO,
 B.SEXO,
 B.FEC_NAC,
 A.SUELDO,
 A.OCUPACION,
 (SELECT X.RIESGO
 FROM OIM.RCEN_ASEG0003 X
 WHERE X.NRO_MOVIMIENTO = A.NRO_MOVIMIENTO
 AND X.COD_CIA = A.COD_CIA
 AND X.COD_RAMO = A.COD_RAMO
 AND X.NUM_POLIZA = A.NUM_POLIZA
 AND X.NUM_SPTO = A.NUM_SPTO
 AND X.NUM_APLI = A.NUM_APLI
 AND X.NUM_SPTO_APLI = A.NUM_SPTO_APLI
 AND X.NUM_RIESGO=A.NUM_RIESGO)
 RIESGO
 FROM OIM.RCEN_ASEG0004 A
 INNER JOIN OIM.RCEN_ASEGURADOS B
 ON A.COD_ASEG = B.COD_ASEG
 --INNER JOIN OIM.RCEN_ASEG0001 C
 --ON C.NRO_MOVIMIENTO = B.NRO_MOVIMIENTO
 WHERE A.NUM_POLIZA = as_poliza
 --AND C.TIPO_MOVIMIENTO = 'IN'
 --AND C.MCA_FACTURADO='N'
-- AND C.FEC_INI_VIG = vl_fec_efec_spto
-- AND C.FEC_FIN_VIG = vl_fec_vcto_spto
 AND A.NUM_APLI=an_num_apli
 --AND A.NUM_SPTO=an_num_spto
 AND A.MCA_BAJA='N';
 ELSE
 BEGIN
 SELECT MAX (X.FEC_EFEC_SPTO), MAX (X.FEC_VCTO_SPTO)
 INTO vl_fec_efec_spto, vl_fec_vcto_spto
 FROM TRON2000.A2000030@TRON X
 WHERE X.NUM_POLIZA = as_poliza
 AND TRUNC (X.FEC_EFEC_SPTO) < ad_fecini --to_date(ad_fecini,'DD/MM/YYYY')
 AND X.NUM_APLI != 0
 AND X.MCA_POLIZA_ANULADA = 'N'
 AND X.MCA_SPTO_ANULADO = 'N';
 EXCEPTION
 WHEN NO_DATA_FOUND
 THEN
 vl_fec_efec_spto := SYSDATE;
 vl_fec_vcto_spto := SYSDATE;
 END;
 OPEN o_cursor FOR
 SELECT B.COD_ASEG,
 B.TIPO_DOC,
 B.NRO_DOCUMENTO,
 B.APE_PATERNO,
 B.APE_MATERNO,
 B.PRIMER_NOMBRE || ' ' || B.SEGUNDO_NOMBRE NOMBRES,
 B.NOMBRE_COMPLETO,
 B.SEXO,
 B.FEC_NAC,
 A.SUELDO,
 A.OCUPACION,
 (SELECT X.RIESGO
 FROM OIM.RCEN_ASEG0003 X
 WHERE X.NRO_MOVIMIENTO = A.NRO_MOVIMIENTO
 AND X.COD_CIA = A.COD_CIA
 AND X.COD_RAMO = A.COD_RAMO
 AND X.NUM_POLIZA = A.NUM_POLIZA
 AND X.NUM_SPTO = A.NUM_SPTO
 AND X.NUM_APLI = A.NUM_APLI
 AND X.NUM_SPTO_APLI = A.NUM_SPTO_APLI
 AND X.NUM_RIESGO=A.NUM_RIESGO)
 RIESGO
 FROM OIM.RCEN_ASEG0004 A
 INNER JOIN OIM.RCEN_ASEGURADOS B
 ON B.COD_ASEG = A.COD_ASEG
 INNER JOIN OIM.RCEN_ASEG0001 C
 ON C.NRO_MOVIMIENTO = A.NRO_MOVIMIENTO
 WHERE A.NUM_POLIZA = as_poliza
 AND C.FEC_INI_VIG = vl_fec_efec_spto
 AND C.FEC_FIN_VIG = vl_fec_vcto_spto
 --AND A.NUM_APLI=an_num_apli
 -- AND A.NUM_SPTO=an_num_spto
 AND C.TIPO_MOVIMIENTO = 'IN'
 AND C.MCA_FACTURADO='N'
 AND C.MCA_BAJA='N';
 END IF;
 END psctrcen011;

/*==============================================================================
 PROPOSITO: Registrar Movimiento
 AUTOR: AALVARADO FECHA: 20/01/2015
 ------------------------------------------------------------------------------
 DATOS RELEVANTES
 - as_Tip_Docum -> Tipo de Documento
 - as_Num_Docum -> Numero de Documento
 - ad_Fec_Ini -> Fecha Inicio
 - ad_Fec_Fin -> Fecha Fin
 - as_Tip_Movi -> Tipo Movimiento
 - as_Mca_Factura -> Marca Facturado
 - as_Usr -> Usuario de Registro
 -as_Ubicacion -> Ubicacion
 - p_nRetorno -> Indicador de Retorno
 - p_cMensaje -> Mensaje de Retorno
 ------------------------------------------------------------------------------
 DESCRIPCION FUNCIONAL
 - Registra un Movimiento en las tablas Reales.
 ==============================================================================*/
 PROCEDURE psctrcen012 (
 as_Tip_Docum IN OIM.RCEN_ASEG0001.TIP_DOCUMENTO%TYPE, --01
 as_Num_Docum IN OIM.RCEN_ASEG0001.NRO_DOCUMENTO%TYPE, --02
 ad_Fec_Ini IN OIM.RCEN_ASEG0001.FEC_INI_VIG%TYPE, --03
 ad_Fec_Fin OIM.RCEN_ASEG0001.FEC_FIN_VIG%TYPE, --04
 as_Tip_Movi IN OIM.RCEN_ASEG0001.TIPO_MOVIMIENTO%TYPE, --05
 as_Mca_Factura IN OIM.RCEN_ASEG0001.MCA_FACTURADO%TYPE, --06
 as_Usr IN OIM.RCEN_ASEG0001.COD_USR_REG%TYPE, --07
 as_Ubicacion IN OIM.RCEN_ASEG0001_TEMP.UBICACION%TYPE, --08
 --Variables de Retorno
 p_nRetorno OUT NUMBER, --09
 p_cMensaje OUT VARCHAR --10
 )
 IS
 vl_Nro_Movimiento NUMBER;
 BEGIN
 SELECT OIM.SEQ_RCEN_ASEG0001.NEXTVAL INTO vl_Nro_Movimiento FROM DUAL;

 INSERT INTO OIM.RCEN_ASEG0001_TEMP (NRO_MOVIMIENTO,
 TIP_DOCUMENTO,
 NRO_DOCUMENTO,
 FEC_INI_VIG,
 FEC_FIN_VIG,
 TIPO_MOVIMIENTO,
 MCA_FACTURADO,
 MCA_BAJA,
 COD_USR_REG,
 FEC_REG,
 UBICACION)
 VALUES (vl_Nro_Movimiento,
 as_Tip_Docum,
 as_Num_Docum,
 ad_Fec_Ini,
 ad_Fec_Fin,
 as_Tip_Movi,
 as_Mca_Factura,
 'N',
 as_Usr,
 SYSDATE,
 as_Ubicacion);

 p_nRetorno := 1;
 p_cMensaje :=vl_Nro_Movimiento;
 EXCEPTION
 WHEN OTHERS
 THEN
 p_nRetorno := -1;
 p_cMensaje := 'ER:' || SQLERRM;
 ROLLBACK;
 END psctrcen012;

/*==============================================================================
 PROPOSITO: Registrar Datos de Poliza
 AUTOR: AALVARADO FECHA: 20/01/2015
 ------------------------------------------------------------------------------
 DATOS RELEVANTES
 - as_Nro_Movimiento -> Numero de Movimiento
 - as_Num_Poliza -> Numero de Poliza
 - as_Num_Spto -> Numero de Suplemento
 - as_Num_Apli -> Numero de Aplicacion
 - as_Num_Spto_Apli -> Numero de Suplemeno Aplicacion
 - as_Usr -> Usuario de Registro
 - p_nRetorno -> Indicador de Retorno
 - p_cMensaje -> Mensaje de Retorno
 ------------------------------------------------------------------------------
 DESCRIPCION FUNCIONAL
 - Registra datos de la poliza en las tablas Reales
 ==============================================================================*/
 PROCEDURE psctrcen013 (
 as_Nro_Movimiento IN OIM.RCEN_ASEG0002.NRO_MOVIMIENTO%TYPE, --01
 as_Num_Poliza IN OIM.RCEN_ASEG0002.NUM_POLIZA%TYPE, --02
 as_Num_Spto IN OIM.RCEN_ASEG0002.NUM_SPTO%TYPE, --03
 as_Num_Apli IN OIM.RCEN_ASEG0002.NUM_APLI%TYPE, --04
 as_Num_Spto_Apli IN OIM.RCEN_ASEG0002.NUM_SPTO_APLI%TYPE, --05
 as_Usr IN OIM.RCEN_ASEG0002.COD_USR_REG%TYPE, --06
 --Variables de Retorno
 p_nRetorno OUT NUMBER, --07
 p_cMensaje OUT VARCHAR --08
 )
 IS
 BEGIN
 INSERT INTO OIM.RCEN_ASEG0002_TEMP (NRO_MOVIMIENTO,
 COD_CIA,
 COD_RAMO,
 NUM_POLIZA,
 NUM_SPTO,
 NUM_APLI,
 NUM_SPTO_APLI,
 NUM_RECIBO,
 COD_SISTEMA,
 COD_USR_REG,
 FEC_REG)
 VALUES (as_Nro_Movimiento,
 vl_cod_cia,
 vl_cod_ramo,
 as_Num_Poliza,
 as_Num_Spto,
 as_Num_Apli,
 as_Num_Spto_Apli,
 NULL,
 vl_cod_sistema,
 as_Usr,
 SYSDATE);

 p_nRetorno := 1;
 p_cMensaje := 'OK';
 EXCEPTION
 WHEN OTHERS
 THEN
 p_nRetorno := -1;
 p_cMensaje := 'ER:' || SQLERRM;
 ROLLBACK;
 END psctrcen013;

/*==============================================================================
 PROPOSITO: Registrar Datos de Riesgos
 AUTOR: AALVARADO FECHA: 20/01/2015
 ------------------------------------------------------------------------------
 DATOS RELEVANTES
 - an_Nro_Movimiento -> Numero de Movimiento
 - as_Num_Poliza -> Numero de Poliza
 - an_Num_Spto -> Numero de Suplemento
 - an_Num_Apli -> Numero de Aplicacion
 - an_Num_Spto_Apli -> Numero de Suplemeno Aplicacion
 - an_num_riesgo -> Numero Riesgo
 - as_riesgo -> Descripcion riesgo
 - an_cant_trab -> Cantidad Trabajadores
 - an_impor_planilla -> Importe Planilla
 - an_tasa -> Tasa
 - an_sub_total -> Sub Total
 - an_prima_neta -> Prima Neta
 - an_factor -> Factor
 - as_Usr -> Usuario de Registro
 - an_prima_total -> Prima Total
 - p_nRetorno -> Indicador de Retorno
 - p_cMensaje -> Mensaje de Retorno
 ------------------------------------------------------------------------------
 DESCRIPCION FUNCIONAL
 - Registra datos del Riesgo en las tablas Reales
 ==============================================================================*/
 PROCEDURE psctrcen014 (
 an_Nro_Movimiento IN OIM.RCEN_ASEG0003.NRO_MOVIMIENTO%TYPE, --01
 as_Num_Poliza IN OIM.RCEN_ASEG0003.NUM_POLIZA%TYPE, --02
 an_Num_Spto IN OIM.RCEN_ASEG0003.NUM_SPTO%TYPE, --03
 an_Num_Apli IN OIM.RCEN_ASEG0003.NUM_APLI%TYPE, --04
 an_Num_Spto_Apli IN OIM.RCEN_ASEG0003.NUM_SPTO_APLI%TYPE, --05
 an_num_riesgo IN OIM.RCEN_ASEG0003.NUM_RIESGO%TYPE, --06
 as_riesgo IN OIM.RCEN_ASEG0003.RIESGO%TYPE, --07
 an_cant_trab IN OIM.RCEN_ASEG0003.CANT_TRAB%TYPE, --08
 an_impor_planilla IN OIM.RCEN_ASEG0003.IMPOR_PLANILLA%TYPE, --09
 an_tasa IN OIM.RCEN_ASEG0003.TASA%TYPE, --10
 an_sub_total IN OIM.RCEN_ASEG0003.SUB_TOTAL%TYPE, --11
 an_prima_neta IN OIM.RCEN_ASEG0003.PRIMA_NETA%TYPE, --12
 an_factor IN OIM.RCEN_ASEG0003.FACTOR%TYPE, --13
 as_Usr IN OIM.RCEN_ASEG0003.COD_USR_REG%TYPE, --14
 an_prima_total IN OIM.RCEN_ASEG0003.PRIMA_TOTAL%TYPE, --15
 --Variables de Retorno
 p_nRetorno OUT NUMBER, --16
 p_cMensaje OUT VARCHAR --17
 )
 IS
 BEGIN
 INSERT INTO OIM.RCEN_ASEG0003_TEMP (NRO_MOVIMIENTO,
 COD_CIA,
 COD_RAMO,
 NUM_POLIZA,
 NUM_SPTO,
 NUM_APLI,
 NUM_SPTO_APLI,
 NUM_RIESGO,
 RIESGO,
 CANT_TRAB,
 IMPOR_PLANILLA,
 TASA,
 SUB_TOTAL,
 PRIMA_NETA,
 FACTOR,
 COD_USR_REG,
 FEC_REG,
 PRIMA_TOTAL)
 VALUES (an_Nro_Movimiento,
 vl_cod_cia,
 vl_cod_ramo,
 as_Num_Poliza,
 an_Num_Spto,
 an_Num_Apli,
 an_Num_Spto_Apli,
 an_num_riesgo,
 as_riesgo,
 an_cant_trab,
 an_impor_planilla,
 an_tasa,
 an_sub_total,
 an_prima_neta,
 an_factor,
 as_Usr,
 SYSDATE,
 an_prima_total);

 p_nRetorno := 1;
 p_cMensaje := 'OK';
 EXCEPTION
 WHEN OTHERS
 THEN
 p_nRetorno := -1;
 p_cMensaje := 'ER:' || SQLERRM;
 ROLLBACK;
 END psctrcen014;

/*==============================================================================
 PROPOSITO: Inserta planilla
 AUTOR: AALVARADO FECHA: 20/01/2015
 ------------------------------------------------------------------------------
 DATOS RELEVANTES
 - an_Nro_Movimiento -> Numero de Movimiento
 - an_fila -> Numero Fila
 - as_tip_docum -> Tipo de Documento
 - as_num_docum -> Numero de Documento
 - as_nombres -> Nombres
 - as_ape_pater -> Apellido Paterno
 - as_ape_mater -> Apellido Materno
 - as_nom_comple -> Nombre Completo
 - ad_fec_naci -> Fecha de Nacimiento
 - an_sueldo -> Sueldo
 - as_ocupacion -> Ocupacion
 - as_Usr -> Usuario
 - an_riesgo -> Riesgo
 - p_nRetorno -> Indicador de Retorno
 - p_cMensaje -> Mensaje de Retorno
 ------------------------------------------------------------------------------
 DESCRIPCION FUNCIONAL
 - Registra datos de los trabajadores en planilla
 ==============================================================================*/
 PROCEDURE psctrcen015 (
 an_Nro_Movimiento IN OIM.RCEN_ASEG0004_TEMP.NRO_MOVIMIENTO%TYPE, --01
 an_fila IN OIM.RCEN_ASEG0004_TEMP.NRO_FILA%TYPE, --02
 as_tip_docum IN OIM.RCEN_ASEG0004_TEMP.TIPDOC%TYPE, --03
 as_num_docum IN OIM.RCEN_ASEG0004_TEMP.NUMDOC%TYPE, --04
 as_nombres IN OIM.RCEN_ASEG0004_TEMP.NOMBRES%TYPE, --05
 as_ape_pater IN OIM.RCEN_ASEG0004_TEMP.APEPAT%TYPE, --06
 as_ape_mater IN OIM.RCEN_ASEG0004_TEMP.APEMAT%TYPE, --07
 as_nom_comple IN OIM.RCEN_ASEG0004_TEMP.NOMBRECOMPLETO%TYPE, --08
 ad_fec_naci IN DATE, --09
 an_sueldo IN OIM.RCEN_ASEG0004.SUELDO%TYPE, --10
 as_ocupacion IN OIM.RCEN_ASEG0004_TEMP.OCUPACION%TYPE, --11
 as_Usr IN OIM.RCEN_ASEG0004_TEMP.COD_USR_REG%TYPE, --12
 an_riesgo IN OIM.RCEN_ASEG0004_TEMP.NUM_RIESGO%TYPE, --13
 --Variables de Retorno
 p_nRetorno OUT NUMBER, --14
 p_cMensaje OUT VARCHAR --15
 )
 IS
 BEGIN
 INSERT INTO OIM.RCEN_ASEG0004_TEMP --Trabajadores
 ( NRO_MOVIMIENTO,
 NRO_MOVIMIENTO_REG,
 NRO_FILA,
 TIPDOC,
 NUMDOC,
 APEPAT,
 APEMAT,
 NOMBRES,
 NOMBRECOMPLETO,
 FECNAC,
 SUELDO,
 OCUPACION,
 COD_USR_REG,
 FEC_REG,
 NUM_RIESGO)
 VALUES (
 an_Nro_Movimiento,
 NULL,
 an_fila,
 as_tip_docum,
 as_num_docum,
 as_ape_pater,
 as_ape_mater,
 as_nombres,
 as_nom_comple,
 TO_CHAR(ad_fec_naci,'DD/MM/YYYY'),
 --an_sueldo,
 --REPLACE(REPLACE(an_sueldo,',',''),'.',','),
 TO_CHAR(an_sueldo),
 as_ocupacion,
 as_Usr,
 SYSDATE,
 an_riesgo);
 /* -- Insertar o Actualizar Asegurado.
 OIM.OIM_K_RCEN.INSERTAR_ASEGURADO (as_nombres,
 as_nom_comple,
 as_ape_pater,
 as_ape_mater,
 TO_CHAR (ad_fec_naci, 'DD/MM/YYYY'),
 as_num_docum,
 as_tip_docum,
 as_Usr,
 0,
 p_nRetorno,
 p_cMensaje);
 --Insertar Movimiento RCEN_MOVIMIENTOS.
 OIM.PCK_GEST_ASEG.INSERTAR_MOVIMIENTO_OIM (as_num_docum,
 as_tip_docum,
 as_Usr,
 an_Nro_Movimiento,
 p_nRetorno,
 p_cMensaje);

 SELECT X.COD_ASEG
 INTO vl_cod_aseg
 FROM OIM.RCEN_ASEGURADOS X
 WHERE X.TIPO_DOC = as_tip_docum
 AND X.NRO_DOCUMENTO = as_num_docum
 AND ROWNUM = 1;*/
 p_nRetorno := 1;
 p_cMensaje := 'OK';
 EXCEPTION
 WHEN OTHERS
 THEN
 p_nRetorno := -1;
 p_cMensaje := 'ER:' || SQLERRM;
 ROLLBACK;
 END psctrcen015;
/*==============================================================================
PROPOSITO: LISTA RIESGOS POR POLIZA
AUTOR: AALVARADO FECHA: 22/01/2015
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_num_poliza -> Numero de Poliza
 - an_num_spto -> Numero de Suplemento
 - an_num_aplicacion -> Numero de Aplicacion
 - o_cursor -> Cursor
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
 - Lista Riesgos de una determinada Poliza.
==============================================================================*/
 PROCEDURE psctrcen016 (
 as_num_poliza IN TRON2000.A2000031.NUM_POLIZA@TRON%TYPE,
 an_num_spto IN TRON2000.A2000031.NUM_SPTO@TRON%TYPE,
 an_num_aplicacion IN TRON2000.A2000031.NUM_APLI@TRON%TYPE,
 o_cursor OUT t_cursor
 )
 IS
 BEGIN
 OPEN o_cursor FOR
 SELECT T.NUM_RIESGO,T.NOM_RIESGO,
 TO_NUMBER(NVL(TRIM (SF_RECUPERA_DV@TRON (vl_Cod_Cia,as_num_poliza,an_num_spto,T.NUM_RIESGO,1,'VAL_TASA_RIESGO',vl_Cod_Ramo,'VAL')) ,'0'),'999999999.0000' ) TASA-- recupera la tasa para los riesgo
 FROM(
 SELECT DISTINCT(NUM_RIESGO),NOM_RIESGO
 FROM TRON2000.A2000031@TRON
 WHERE NUM_POLIZA =as_num_poliza
 AND NUM_SPTO = an_num_spto
 AND NUM_APLI = an_num_aplicacion
 AND MCA_BAJA_RIESGO = 'N'
 AND MCA_VIGENTE = 'S') T;


 END psctrcen016;
/*==============================================================================
PROPOSITO: ACTUALIZA N UMERO DE RECIBO EN TABLA TEMPORAL RCEN_ASEG0002
AUTOR: AALVARADO FECHA: 22/01/2015
------------------------------------------------------------------------------
DATOS RELEVANTES
 - an_cod_cia -> Numero de Cia
 - an_cod_ramo -> Numero de Ramo
 - as_tip_movi -> Tipo Movimiento
 - an_pri_minima -> Prima Minima
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
 - Actualiza Numero de Recibo en tabla temporal 0002.
==============================================================================*/
 PROCEDURE psctrcen017 (
 an_cod_cia IN NUMBER, --01
 an_cod_ramo IN NUMBER, --02
 as_tip_movi IN VARCHAR2, --03
 --Variables de Retorno
 an_pri_minima OUT NUMBER--04
 )
 IS
 BEGIN
 IF as_tip_movi='DE' THEN--DECLARACION
 psctrcen018(an_cod_cia,an_cod_ramo,1,an_pri_minima);
 ELSE--INCLUSION
 psctrcen019(an_cod_ramo,an_pri_minima);
 END IF;
 EXCEPTION
 WHEN OTHERS THEN
 an_pri_minima:=0;
 END psctrcen017;
/*==============================================================================
PROPOSITO: BUSCA LA PRIMA MINIMA PARA TIPO DE MOVIMIENTO DECLARACION
AUTOR: AALVARADO FECHA: 22/01/2015
------------------------------------------------------------------------------
DATOS RELEVANTES
 - p_cod_cia -> Codigo de compania
 - p_cod_ramo -> Codigo de ramo
 - p_cod_mon -> codigo de monto
 - p_prima_minima -> Prima Minima
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
 - Busca la prima minima para el tipo de movimiento de declaracion
==============================================================================*/
 procedure psctrcen018(
 p_cod_cia in number,
 p_cod_ramo in number,
 p_cod_mon in number,
 p_prima_minima out number
 ) is

 cursor c_prima_minima is
 SELECT a.imp_min_apli
 FROM tagenpm0@tron a
 WHERE a.cod_cia = p_cod_cia
 AND a.tip_nivel ='Z'
 AND a.num_poliza_grupo = 'ZZZZZZZZZZZZZ'
 AND a.num_poliza = 'ZZZZZZZZZZZZZ'
 AND a.tip_docum = 'ZZZ'
 AND a.cod_docum = 'ZZZZZZZZZZZZZ'
 AND a.cod_agt = 99999
 AND a.cod_ejecutivo = 99999
 AND a.cod_nivel3 = 9999
 AND a.cod_ramo = p_cod_ramo
 AND a.cod_modalidad = 99999
 AND a.cod_tip_vehi = 0
 AND a.cod_uso_vehi = 0
 AND a.cod_zona = 'Z'
 AND a.tip_volante = 'Z'
 AND a.cod_mon = p_cod_mon
 AND a.mca_inh = 'N'
 AND a.fec_validez
 =
 (SELECT MAX(b.fec_validez)
 FROM tagenpm0@tron b
 WHERE b.cod_cia = a.cod_cia
 AND b.tip_nivel = a.tip_nivel
 AND b.num_poliza_grupo = a.num_poliza_grupo
 AND b.num_poliza = a.num_poliza
 AND b.tip_docum = a.tip_docum
 AND b.cod_docum = a.cod_docum
 AND b.cod_agt = a.cod_agt
 AND b.cod_ejecutivo = a.cod_ejecutivo
 AND b.cod_nivel3 = a.cod_nivel3
 AND b.cod_ramo = a.cod_ramo
 AND b.cod_modalidad = a.cod_modalidad
 AND b.cod_tip_vehi = a.cod_tip_vehi
 AND b.cod_uso_vehi = a.cod_uso_vehi
 AND b.cod_zona = a.cod_zona
 AND b.tip_volante = a.tip_volante
 AND b.cod_mon = a.cod_mon
 AND b.fec_validez <= to_date(sysdate,'DD/MM/RRRR')
 );

 begin
 open c_prima_minima;
 fetch c_prima_minima into p_prima_minima;
 close c_prima_minima;

 end psctrcen018;

/*==============================================================================
PROPOSITO: BUSCA LA PRIMA MINIMA PARA TIPO DE MOVIMIENTO INCLUSION
AUTOR: AALVARADO FECHA: 22/01/2015
------------------------------------------------------------------------------
DATOS RELEVANTES
 - p_cod_ramo -> Codigo de ramo
 - p_prima_minima -> Prima Minima
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
 - Busca la prima minima para el tipo de movimiento de inclusion
==============================================================================*/
 procedure psctrcen019(
 p_cod_ramo in number,
 p_prima_minima out number
 ) is

 cursor c_prima_minima is
 select cod_item
 from targen49@tron
 where cod_rubro = 806
 and sub_cod_spto = 41
 and cod_spto = 999
 and cod_ramo = p_cod_ramo;

 begin
 open c_prima_minima;
 fetch c_prima_minima into p_prima_minima;
 close c_prima_minima;
 end psctrcen019;
/*==============================================================================
PROPOSITO: Genera Movimiento en tablas Temporales
AUTOR: AALVARADO FECHA: 17/11/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_Cod_Cia -> Codigo de Compania
 - as_Num_Poliza -> Numero de Poliza
 - as_Num_Spto -> Numero de Suplemento
 - as_Num_Apli -> Numero de Aplicacion
 - as_Num_Spto_Apli -> Numero de Suplemento Aplicacion
 - as_Cod_Usuario -> Codigo de Usuario
 - as_Cod_Sistema -> Codigo de Sistema
 - an_Num_Riesgo -> Numero de Riesgo
 - p_nRetorno -> Indicador de Retorno
 - p_cMensaje -> Mensaje de Retorno
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
 - Genera un nuevo movimiento para luego proceder con la insercion de la trama.
==============================================================================*/
 PROCEDURE psctrcen020(
 as_Cod_Cia IN VARCHAR2,--01
 as_Num_Poliza IN VARCHAR2,--02
 as_Num_Spto IN VARCHAR2,--03
 as_Num_Apli IN VARCHAR2,--04
 as_Num_Spto_Apli IN VARCHAR2,--05
 as_Cod_Usuario IN VARCHAR2,--06
 as_Cod_Sistema IN VARCHAR2,--07
 an_Num_Riesgo IN NUMBER,--08
 --Variables de Retorno
 p_nRetorno OUT NUMBER,--09
 p_cMensaje OUT VARCHAR--10
 )
 IS
 vl_Nro_Movimiento NUMBER;
 BEGIN
 BEGIN
 SELECT NRO_MOVIMIENTO INTO vl_Nro_Movimiento
 FROM OIM.RCEN_ASEG0002_TEMP
 WHERE COD_CIA=as_Cod_Cia
 AND NUM_POLIZA=as_Num_Poliza
 AND NUM_SPTO=as_Num_Spto
 AND NUM_APLI=as_Num_Apli
 AND NUM_SPTO_APLI=as_Num_Spto_Apli
 AND COD_USR_REG=as_Cod_Usuario
 AND COD_SISTEMA=as_Cod_Sistema;
 EXCEPTION
 WHEN NO_DATA_FOUND THEN
 vl_Nro_Movimiento:=0;
 END;

 IF vl_Nro_Movimiento = 0 THEN

 SELECT OIM.SEQ_RCEN_ASEG0001.NEXTVAL INTO vl_Nro_Movimiento FROM DUAL;

 INSERT INTO OIM.RCEN_ASEG0001_TEMP(NRO_MOVIMIENTO,TIP_DOCUMENTO,NRO_DOCUMENTO,FEC_INI_VIG,FEC_FIN_VIG,TIPO_MOVIMIENTO,MCA_FACTURADO,MCA_BAJA,COD_USR_REG,FEC_REG)
 SELECT vl_Nro_Movimiento,TIP_DOCUM,COD_DOCUM,FEC_EFEC_SPTO,FEC_VCTO_SPTO,'DE','S','N',as_Cod_Usuario,SYSDATE
 FROM A2000030@TRON
 WHERE COD_CIA=as_Cod_Cia
 AND COD_RAMO=SUBSTR(as_Num_Poliza,1,3)
 AND NUM_POLIZA =as_Num_Poliza
 AND NUM_SPTO=as_Num_Spto
 AND NUM_APLI=as_Num_Apli
 AND NUM_SPTO_APLI=as_Num_Spto_Apli
 AND ROWNUM=1;

 INSERT INTO OIM.RCEN_ASEG0002_TEMP
 (NRO_MOVIMIENTO,COD_CIA,COD_RAMO,NUM_POLIZA,NUM_SPTO,
 NUM_APLI,NUM_SPTO_APLI,COD_SISTEMA,COD_USR_REG,FEC_REG) VALUES
 (vl_Nro_Movimiento,as_Cod_Cia,SUBSTR(as_Num_Poliza,1,3),as_Num_Poliza,as_Num_Spto,
 as_Num_Apli,as_Num_Spto_Apli,as_Cod_Sistema,as_Cod_Usuario,SYSDATE);
 ELSE--BORRAMOS TODOS LOS TRABAJADORES DE LA TABLA TEMPORAL
 DELETE FROM OIM.RCEN_ASEG0004_TEMP WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento AND NUM_RIESGO=an_Num_Riesgo;
 END IF;
 p_nRetorno := vl_Nro_Movimiento;
 p_cMensaje := 'OK';
 EXCEPTION
 WHEN OTHERS THEN
 p_nRetorno := -1;
 p_cMensaje := 'ER:'||SQLERRM;
 ROLLBACK;
 END psctrcen020;
 /*==============================================================================
PROPOSITO: Borra Trama de trabajadores para un Movimiento y riesgo
AUTOR: AALVARADO FECHA: 17/11/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - an_Num_movimiento -> Numero Movimiento
 - an_Num_Riesgo -> Numero de Riesgo
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
 - Borra Trama de trabajadores para un Movimiento y riesgo
==============================================================================*/
 PROCEDURE psctrcen021(
 an_Num_movimiento IN NUMBER,--01
 an_Num_Riesgo IN VARCHAR2--02
 )
 IS
 BEGIN
 DELETE FROM OIM.RCEN_ASEG0004_TEMP WHERE NRO_MOVIMIENTO=an_Num_movimiento AND NUM_RIESGO=an_Num_Riesgo;
 END psctrcen021;
END;
/

