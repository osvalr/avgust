CREATE OR REPLACE PACKAGE PKG_SCTRCEN AS
/******************************************************************************
 NAME: PKG_WVLMT
 PURPOSE:

 REVISIONS:
 Ver Date Author Description
 --------- ---------- --------------- ------------------------------------
 1.0 21/11/2014 nfire 1. Created this package.
******************************************************************************/
TYPE t_cursor IS REF CURSOR;
--==============================================================================
--PROPOSITO: PERMISOS.
--AUTOR: AALVARADO FECHA: 12/09/2014
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- an_cod_grupo -> codigo de Grupo
-- an_param_01 -> Parametro 01
-- o_cursor -> Cursor
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Listado de Combos
--==============================================================================
 PROCEDURE PSCTRCENMT000(
 an_cod_grupo IN NUMBER,
 an_param_01 IN VARCHAR2,
 an_param_02 IN VARCHAR2 DEFAULT NULL,
 an_param_03 IN VARCHAR2 DEFAULT NULL,
 o_cursor OUT t_cursor);
--==============================================================================
--PROPOSITO: LISTA GESTOR, AGENTE Y CLIENTE.
--AUTOR: AALVARADO FECHA: 12/09/2014
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- as_TipBusqueda -> Tipo de Busqueda
-- as_Codigo -> Codigo Gestor-Agente-Cliente
-- as_Descrip -> Descrpcion de Busqueda
-- as_CodGestor -> Codigo de Gestor para busqueda de Agente
-- o_cursor -> Cursor
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Listado de Gestor, Agente y Cliente mediante parametros de busqueda (Codigo y Descripcion)
--==============================================================================
 PROCEDURE PSCTRCENMT001(
 as_TipBusqueda IN VARCHAR2,
 as_Codigo IN VARCHAR2,
 as_Descrip IN VARCHAR2,
 as_CodGestor IN VARCHAR2,
 --paginado
 an_NumPagina IN NUMBER,
 an_TamPagina IN NUMBER,
 an_TotRegistro OUT NUMBER,
 o_cursor OUT t_cursor);
--==============================================================================
--PROPOSITO: LISTA POLIZA.
--AUTOR: AALVARADO FECHA: 20/12/2014
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- as_Cod_Corredor -> Codigo de Agente
-- as_Cod_Documen -> Codigo de Documento
-- as_Num_Poliza -> Numero de Poliza
-- as_Col_Asegura -> Colectivo Asegurado
-- o_cursor -> Cursor
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Listado de Poliza segun los parametro de entrada.
--==============================================================================
 PROCEDURE PSCTRCEN000(
 as_Cod_Corredor IN VARCHAR2,
 as_Cod_Documen IN VARCHAR2,
 as_Num_Poliza IN VARCHAR2,
 as_Col_Asegura IN VARCHAR2,
 o_cursor OUT t_cursor);
--==============================================================================
--PROPOSITO: LISTA APLICACION.
--AUTOR: AALVARADO FECHA: 23/12/2014
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- as_Cod_Corredor -> Codigo de Agente
-- as_Cod_Documen -> Codigo de Documento
-- as_Num_Poliza -> Numero de Poliza
-- o_cursor -> Cursor
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Lista Aplicaciones de una determinada Poliza.
--==============================================================================
 PROCEDURE PSCTRCEN001(
 as_cod_corredor IN VARCHAR2,
 as_rol_web IN VARCHAR2,
 as_tip_docum IN VARCHAR2,
 as_cod_documen IN VARCHAR2,
 as_num_poliza IN VARCHAR2,
 o_cursor OUT t_cursor);

 --==============================================================================
 --PROPOSITO: LISTA APLICACIONES Y VIGENCIAS
 --AUTOR: CQUISPE FECHA: 29/12/2014
 --------------------------------------------------------------------------------
 --DATOS RELEVANTES
 -- as_Cod_Corredor -> Codigo de Agente
 -- as_Cod_Documen -> Codigo de Documento
 -- as_Num_Poliza -> Numero de Poliza
 -- o_cursor -> Cursor
 --------------------------------------------------------------------------------
 --DESCRIPCION FUNCIONAL
 --Lista Aplicaciones y vigencias de una determinada Poliza.
 --==============================================================================
 PROCEDURE PSCTRCEN002(
 as_Cod_Corredor IN VARCHAR,
 as_Cod_Documen IN VARCHAR,
 as_Num_Poliza IN VARCHAR,
 o_cursor OUT t_cursor);

 --==============================================================================
 --PROPOSITO: LISTA LOS DATOS DEL ASEGURADO
 --AUTOR: CQUISPE FECHA: 29/12/2014
 --------------------------------------------------------------------------------
 --DATOS RELEVANTES
 -- as_num_poliza -> Numero de poliza
 -- as_num_apli -> Numero de aplicacion
 -- as_fec_ini -> Fecha inicio de vigenci
 -- as_fec_fin -> Fecha fin de vigencia
 -- o_cursor -> Cursor de resultado de la consulta
 --------------------------------------------------------------------------------
 --DESCRIPCION FUNCIONAL
 --Lista los datos del asegurado para una poliza con fecha de vigencia especifica - utilizado para exportar planilla excel
 --==============================================================================
 PROCEDURE PSCTRCEN003(
 as_num_poliza IN VARCHAR2,
 as_num_apli IN NUMBER DEFAULT NULL,
 an_cod_aseg IN NUMBER DEFAULT NULL,
 as_fec_ini IN DATE,
 as_fec_fin IN DATE,
 o_cursor OUT t_cursor);

 --==============================================================================
--PROPOSITO: LISTA LOS DOCUMENTOS RELACIONADOS A UN NUMERO DE POLIZA
--AUTOR: CQUISPE FECHA: 30/12/2014
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- as_Num_Poliza -> Numero de poliza
-- as_Num_Apli -> Numero de aplicacion
-- as_Fec_Ini -> Fecha de inicio de vigencia
-- as_Fec_Fin -> Fecha fin de vigencia
-- o_cursor -> Cursor
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Lista los documentos relacionados a un numero de poliza
--==============================================================================
 PROCEDURE PSCTRCEN004(
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
 o_cursor OUT t_cursor);

 /*=====================================================================
PROPOSITO: Actualizar datos de la Tabla RCEN_ASEG0001 - ANULAR UN MOVIMIENTO
AUTOR: CQUISPE FECHA:06/01/2015
---------------------------------------------------------------------
DATOS RELEVANTES:
 - an_NumMovimiento = Numer de movimiento
 - as_Usuario = Usuario Creador o Actualizador
 - an_Retorno : Retorno (1: Actualizacion exitoso, -1: Error)
 - as_Mensaje : Mensaje en caso de Error
---------------------------------------------------------------------
DESCRIPCION FUNCIONAL:
 - Actualizar datos de la Tabla RCEN_ASEG0001 - ANULAR UN MOVIMIENTO
 ========================================================================*/
PROCEDURE PSCTRCENMT002 (
 an_NumMovimiento IN rcen_aseg0001.nro_movimiento%TYPE,
 as_Usuario IN rcen_aseg0001.cod_usr_actu%TYPE,
 an_Retorno OUT NUMBER,
 as_Mensaje OUT VARCHAR
 );

 --==============================================================================
 --PROPOSITO: LISTA DE ASEGURADO
 --AUTOR: JRODAS FECHA: 07/01/2015
 --------------------------------------------------------------------------------
 --DATOS RELEVANTES
 -- as_tipo_docum -> Tipo de documento
 -- as_num_docum -> Numero de aplicacion
 -- as_nom_aseg -> Nombre de Asegurado
 -- o_cursor -> Cursor de resultado de la consulta
 --------------------------------------------------------------------------------
 --DESCRIPCION FUNCIONAL
 --Lista los datos del asegurado por los filtros: tipo de documento, numero de documento o nombre del asegurado
 --==============================================================================
 PROCEDURE PSCTRCEN005(
 as_tipo_docum IN VARCHAR2,
 as_num_docum IN VARCHAR2,
 as_nom_aseg IN VARCHAR2,
 o_cursor OUT t_cursor);

 --==============================================================================
--PROPOSITO: LISTA LOS DOCUMENTOS RELACIONADOS A UN NUMERO DE POLIZA Y CONSTANCIA
--AUTOR: JRODAS FECHA: 09/01/2015
-----------------------------------------------------------------------------------
--DATOS RELEVANTES
-- as_Num_Poliza -> Numero de poliza
-- an_Num_Constancia ->Numero de constancia
-- as_Ruc ->RUC
-- o_cursor -> Cursor
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Lista los documentos relacionados a un numero de poliza y numero de constancia
--==============================================================================
 PROCEDURE PSCTRCEN006(
 as_Tip_Docum_Aseg IN VARCHAR2,
 as_Num_Docum_aseg IN VARCHAR2,
 as_Num_Poliza IN VARCHAR2,
 an_Num_Constancia IN NUMBER,
 as_Ruc IN VARCHAR2,
 --paginado
 an_NumPagina IN NUMBER,
 an_TamPagina IN NUMBER,
 an_TotRegistro OUT NUMBER,
 o_cursor OUT t_cursor);

 --==============================================================================
--PROPOSITO: LISTA LAS VIGENCIAS DE LAS P¿LIZAS
--AUTOR: JRODAS FECHA: 09/01/2015
-----------------------------------------------------------------------------------
--DATOS RELEVANTES
-- as_Num_Poliza -> Numero de poliza
-- an_Cod_Aseg ->Codigo de asegurado
-- o_cursor -> Cursor
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Lista las vigencias de una poliza seleccionada
--==============================================================================
 PROCEDURE PSCTRCEN007(
 as_Num_Poliza IN VARCHAR2,
 an_Cod_Aseg IN NUMBER,
 o_cursor OUT t_cursor);

 /*=====================================================================
PROPOSITO: Actualizar datos de la Tabla RCEN_ASEG0001 - RCEN_ASEGURADOS
AUTOR: JRODAS FECHA:09/01/2015
------------------------------------------------------------------------
DATOS RELEVANTES:
 - an_NumMovimiento = Numero de movimiento
 -as_TipoDoc : Tipo de documento del asegurado
 -as_NroDoc : Numero de documento del asegurado
 -as_NomCompleto : Nombre completo de asegurado
 -as_PrimerNom : Primer nombre de asegurado
 -as_SegundoNom : Segundo nombre de asegurado
 -as_ApePat : Apellido paterno del asegurado
 -as_ApeMat : Apellido materno del asegurado
 -as_Ocupacion : Ocupacion de asegurado
 -an_Sueldo : Sueldo de asegurado
 -as_FecNac _ Fecha de nacimiento
 - as_Usuario = Usuario Creador o Actualizador
 -an_Tipo : Porcion de query a ejecutar
 - an_Retorno : Retorno (1: Actualizacion exitoso, -1: Error)
 - as_Mensaje : Mensaje en caso de Error
---------------------------------------------------------------------
DESCRIPCION FUNCIONAL:
 - Actualizar datos de la Tabla RCEN_ASEG0001 - RCEN_ASEGURADOS
 ========================================================================*/
PROCEDURE PSCTRCENMT003 (
 an_CodAseg IN rcen_aseg0004.cod_aseg%TYPE,
 an_NumMovimiento IN rcen_aseg0004.nro_movimiento%TYPE,
 as_TipoDoc IN rcen_asegurados.tipo_doc%TYPE,
 as_NroDoc IN rcen_asegurados.nro_documento%TYPE,
 as_NomCompleto IN rcen_asegurados.nombre_completo%TYPE,
 as_Nombres IN rcen_asegurados.primer_nombre%TYPE,
 as_ApePat IN rcen_asegurados.ape_paterno%TYPE,
 as_ApeMat IN rcen_asegurados.ape_materno%TYPE,
 as_Ocupacion IN rcen_aseg0004.ocupacion%TYPE,
 an_Sueldo IN rcen_aseg0004.sueldo%TYPE,
 as_FecNac IN rcen_asegurados.fec_nac%TYPE,
 as_Usuario IN rcen_aseg0004.cod_usr_actu%TYPE,
 an_Tipo IN NUMBER,
 o_cursor OUT t_cursor);

--==============================================================================
 --PROPOSITO: Obtener los datos del asegurado para llenar la trama de emision de una poliza en especifico
 --AUTOR: CQUISPE FECHA: 12/01/2015
 --------------------------------------------------------------------------------
 --DATOS RELEVANTES
 -- an_cod_cia -> Numero de CIA
 -- an_cod_ramo -> Numero de Ramo
 -- as_cod_docum -> Codigo de Documento
 -- as_num_poliza -> Numero de poliza
 -- o_cursor -> Cursor de resultado de la consulta
 --------------------------------------------------------------------------------
 --DESCRIPCION FUNCIONAL
 --Obtener los datos del asegurado para llenar la trama de emision de una poliza en especifico
 --==============================================================================
 PROCEDURE psctrcen008 (
 an_cod_cia IN NUMBER,
 an_cod_ramo IN NUMBER,
 as_cod_docum IN VARCHAR2,
 as_num_poliza IN VARCHAR2,
 o_cursor OUT t_cursor);

 --==============================================================================
--PROPOSITO: Lista a los Asegurados que pertenecen a una poliza y aplicacion - paginado
--AUTOR: CQUISPE FECHA: 15/01/2015
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- as_Num_Poliza -> Numero de poliza
-- an_Num_Spto -> Numero de suplemento
-- an_Num_Apli -> Numero de aplicacion
-- as_TipoDoc -> Tipo de documento del asegurado
-- as_NroDoc -> Numero de documento del asegurado
-- as_NomCompleto -> Nombre completo del asegurado
-- o_cursor -> Cursor de resultado de la consulta
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Lista a los Asegurados que pertenecen a una poliza y aplicacion - paginado
--==============================================================================
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
 );

 --==============================================================================
--PROPOSITO: Lista datos de un asegurado en especifico
--AUTOR: CQUISPE FECHA: 16/01/2015
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- an_Cod_Aseg -> Codigo asegurado
-- as_Num_Poliza -> Numero de poliza
-- an_Num_Apli -> Numero de aplicacion
-- an_Nro_Movimiento -> Numero de movimiento
-- an_Num_Spto -> Numero de suplemento
-- an_Num_Spto_Apli -> Numero de suplemento de aplicacion
-- o_cursor -> Cursor de resultado de la consulta
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Lista datos de un asegurado en especifico
--==============================================================================
 PROCEDURE psctrcen010 (
 an_Cod_Aseg IN rcen_aseg0004.cod_aseg%TYPE,
 as_Num_Poliza IN rcen_aseg0004.num_poliza%TYPE,
 an_Num_Apli IN rcen_aseg0004.num_apli%TYPE,
 an_Nro_Movimiento IN rcen_aseg0004.nro_movimiento%TYPE,
 an_Num_Spto IN rcen_aseg0004.num_spto%TYPE,
 an_Num_Spto_Apli IN rcen_aseg0004.num_spto_apli%TYPE,
 o_cursor OUT t_cursor
 );

 /*=====================================================================
 PROPOSITO: Actualizar datos del asegurado
 AUTOR: CQUISPE FECHA:16/01/2015
 ------------------------------------------------------------------------
 DATOS RELEVANTES:
 -an_Cod_Aseg : Codigo asegurado
 -as_Num_Poliza : Numero de poliza
 -an_Num_Apli : Numero de aplicacion
 -an_Nro_Movimiento : Numero de movimiento
 -an_Num_Spto : Numero de suplemento
 -an_Num_Spto_Apli : Numero de suplemento de aplicacion
 -as_TipoDoc : Tipo de documento del asegurado
 -as_NroDoc : Numero de documento del asegurado
 -as_NomCompleto : Nombre completo de asegurado
 -as_PrimerNom : Primer nombre de asegurado
 -as_SegundoNom : Segundo nombre de asegurado
 -as_ApePat : Apellido paterno del asegurado
 -as_ApeMat : Apellido materno del asegurado
 -as_Ocupacion : Ocupacion de asegurado
 -an_Sueldo : Sueldo de asegurado
 - as_Usuario = Usuario Creador o Actualizador
 - an_Retorno : Retorno (1: Actualizacion exitoso, -1: Error)
 - as_Mensaje : Mensaje en caso de Error
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
 );

 /*=====================================================================
 PROPOSITO: Ingresar datos a las tablas temporales, para el registro de Constancia
 AUTOR: CQUISPE FECHA:01901/2015
 ------------------------------------------------------------------------
 DATOS RELEVANTES:
 - as_Cadena : Contiene el codigo del asegurado concatenado con numero de movimiento
 -an_Cod_Cia : Codigo de compania
 -an_Cod_Ramo : Codigo de ramo
 -as_Num_Poliza : Numero de poliza
 -an_Num_Apli : Numero de aplicacion
 -an_Num_Spto : Numero de suplemento
 -an_Num_Spto_Apli : Numero de suplemento de la aplicacion
 -as_Cod_Sistema : Codigo del sistema
 -as_Tip_Docum : Tipo de documento de la empresa
 -as_Nro_Docum : Numero de documento de la empresa
 - ad_Fec_Ini_Vig = Fecha de Inicio de vigencia
 -ad_Fec_Fin_Vig : Fecha de fin de vigencia
 - as_Cod_Usr_Reg = Usuario Creador o Actualizador
 -as_Ubicacion : Ubicacion
 - an_Retorno : Retorno (1: Actualizacion exitoso, -1: Error)
 - as_Mensaje : Mensaje en caso de Error
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
 );
 --==============================================================================
 --PROPOSITO: VALIDAR LISTA DE TRABAJADORES SEGUN DECLARACION O INCLUSION.
 --AUTOR: AALVARADO FECHA: 29/12/2014
 --------------------------------------------------------------------------------
 --DATOS RELEVANTES
 -- as_poliza -> Numero de Poliza
 -- an_num_spto -> Numero de suplemento
 -- an_num_apli -> Numero de Aplicacion
 -- ad_fecini -> Fecha de Inicio
 -- as_tip_movimiento -> Tipo de Movimiento
 -- o_cursor -> Cursor
 --------------------------------------------------------------------------------
 --DESCRIPCION FUNCIONAL
 --Lista de trabajadores faltantes para Declaracion, o trabajadores sobrantes para Inclusiones
 --==============================================================================
 PROCEDURE psctrcen011 (as_poliza IN VARCHAR2,
 an_num_spto IN NUMBER,
 an_num_apli IN NUMBER,
 ad_fecini IN DATE,
 as_tip_movimiento IN VARCHAR2,
 o_cursor OUT t_cursor);

--==============================================================================
 --PROPOSITO: Registrar Movimiento
 --AUTOR: AALVARADO FECHA: 20/01/2015
 --------------------------------------------------------------------------------
 --DATOS RELEVANTES
 -- as_Tip_Docum -> Tipo de Documento
 -- as_Num_Docum -> Numero de Documento
 -- ad_Fec_Ini -> Fecha Inicio
 -- ad_Fec_Fin -> Fecha Fin
 -- as_Tip_Movi -> Tipo Movimiento
 -- as_Mca_Factura -> Marca Facturado
 -- as_Usr -> Usuario de Registro
 -- p_nRetorno -> Indicador de Retorno
 -- p_cMensaje -> Mensaje de Retorno
 --------------------------------------------------------------------------------
 --DESCRIPCION FUNCIONAL
 --Registra un Movimiento en las tablas Reales.
 --==============================================================================
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
 );
 --==============================================================================
 --PROPOSITO: Registrar Datos de Poliza
 --AUTOR: AALVARADO FECHA: 20/01/2015
 --------------------------------------------------------------------------------
 --DATOS RELEVANTES
 -- as_Nro_Movimiento -> Numero de Movimiento
 -- as_Num_Poliza -> Numero de Poliza
 -- as_Num_Spto -> Numero de Suplemento
 -- as_Num_Apli -> Numero de Aplicacion
 -- as_Num_Spto_Apli -> Numero de Suplemeno Aplicacion
 -- as_Usr -> Usuario de Registro
 -- p_nRetorno -> Indicador de Retorno
 -- p_cMensaje -> Mensaje de Retorno
 --------------------------------------------------------------------------------
 --DESCRIPCION FUNCIONAL
 --Registra datos de la poliza en las tablas Reales
 --==============================================================================
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
 );
--==============================================================================
 --PROPOSITO: Registrar Datos de Riesgos
 --AUTOR: AALVARADO FECHA: 20/01/2015
 --------------------------------------------------------------------------------
 --DATOS RELEVANTES
 -- as_Nro_Movimiento -> Numero de Movimiento
 -- as_Num_Poliza -> Numero de Poliza
 -- as_Num_Spto -> Numero de Suplemento
 -- as_Num_Apli -> Numero de Aplicacion
 -- as_Num_Spto_Apli -> Numero de Suplemeno Aplicacion
 -- as_Usr -> Usuario de Registro
 -- p_nRetorno -> Indicador de Retorno
 -- p_cMensaje -> Mensaje de Retorno
 --------------------------------------------------------------------------------
 --DESCRIPCION FUNCIONAL
 --Registra datos del Riesgo en las tablas Reales
 --==============================================================================
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
 );
--==============================================================================
 --PROPOSITO: Inserta planilla
 --AUTOR: AALVARADO FECHA: 20/01/2015
 --------------------------------------------------------------------------------
 --DATOS RELEVANTES
 -- as_Nro_Movimiento -> Numero de Movimiento
 -- as_tip_docum -> Tipo de Documento
 -- as_num_docum -> Numero de Documento
 -- as_nombres -> Nombres
 -- as_ape_pater -> Apellido Paterno
 -- as_ape_mater -> Apellido Materno
 -- as_nom_comple -> Nombre Completo
 -- ad_fec_nac -> Fecha de Nacimiento
 -- as_Num_Poliza -> Numero de Poliza
 -- as_Num_Spto -> Numero de Suplemento
 -- as_Num_Apli -> Numero de Aplicacion
 -- as_Num_Spto_Apli -> Numero de Suplemeno Aplicacion
 -- ad_fec_ini_vig -> Fecha de Inicio de Vigencia
 -- ad_fec_fin_vig -> Fecha de Fin de Vigencia
 -- an_sueldo -> Sueldo
 -- as_ocupacion -> Ocupacion
 -- as_Usr -> Usuario de Registro
 -- p_nRetorno -> Indicador de Retorno
 -- p_cMensaje -> Mensaje de Retorno
 --------------------------------------------------------------------------------
 --DESCRIPCION FUNCIONAL
 --Registra datos de los trabajadores en planilla
 --==============================================================================
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
 );
--==============================================================================
--PROPOSITO: LISTA RIESGOS POR POLIZA
--AUTOR: AALVARADO FECHA: 22/01/2015
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- as_num_poliza -> Numero de Poliza
-- an_num_spto -> Numero de Suplemento
-- an_num_aplicacion -> Numero de Aplicacion
-- o_cursor -> Cursor
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Lista Riesgos de una determinada Poliza.
--==============================================================================
 PROCEDURE psctrcen016 (
 as_num_poliza IN TRON2000.A2000031.NUM_POLIZA@TRON%TYPE,
 an_num_spto IN TRON2000.A2000031.NUM_SPTO@TRON%TYPE,
 an_num_aplicacion IN TRON2000.A2000031.NUM_APLI@TRON%TYPE,
 o_cursor OUT t_cursor
 );
--==============================================================================
--PROPOSITO: ACTUALIZA N UMERO DE RECIBO EN TABLA TEMPORAL RCEN_ASEG0002
--AUTOR: AALVARADO FECHA: 22/01/2015
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- an_Nro_Movimiento -> Numero de Movimiento
-- an_Nro_Cia -> Numero de Cia
-- an_Nro_Ramo -> Numero de Ramo
-- an_Nro_Recibo -> Numero de Recibo
-- p_nRetorno -> Variable de Retorno
-- p_cMensaje -> Variable de Retorno
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Actualiza Numero de Recibo en tabla temporal 0002.
--==============================================================================
 PROCEDURE psctrcen017 (
 an_cod_cia IN NUMBER, --01
 an_cod_ramo IN NUMBER, --02
 as_tip_movi IN VARCHAR2, --03
 --Variables de Retorno
 an_pri_minima OUT NUMBER--04
 );
--==============================================================================
--PROPOSITO: BUSCA LA PRIMA MINIMA PARA TIPO DE MOVIMIENTO DECLARACION
--AUTOR: AALVARADO FECHA: 22/01/2015
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- p_cod_cia -> Codigo de compania
-- p_cod_ramo -> Codigo de ramo
-- p_cod_mon -> codigo de monto
-- p_prima_minima -> Prima Minima
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Busca la prima minima para el tipo de movimiento de declaracion
--==============================================================================
 procedure psctrcen018(
 p_cod_cia in number,
 p_cod_ramo in number,
 p_cod_mon in number,
 p_prima_minima out number
 );
--==============================================================================
--PROPOSITO: BUSCA LA PRIMA MINIMA PARA TIPO DE MOVIMIENTO INCLUSION
--AUTOR: AALVARADO FECHA: 22/01/2015
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- p_cod_ramo -> Codigo de ramo
-- p_prima_minima -> Prima Minima
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Busca la prima minima para el tipo de movimiento de inclusion
--==============================================================================
 procedure psctrcen019(
 p_cod_ramo in number,
 p_prima_minima out number
 );
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
 );
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
 );
END;
/

