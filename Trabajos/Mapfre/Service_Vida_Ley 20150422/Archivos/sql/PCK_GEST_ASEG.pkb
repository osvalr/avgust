CREATE OR REPLACE PACKAGE BODY pck_gest_aseg AS
/******************************************************************************
 NAME: OIM.pck_gest_aseg
 PURPOSE:

 REVISIONS:
 Ver Date Author Description
 --------- ---------- --------------- ------------------------------------
 1.0 10/11/2014 nfire 1. Created this package body.
******************************************************************************/
FUNCTION f_conviertecadena (
 p_cadena VARCHAR2
 )RETURN VARCHAR2
 IS
 cont INT := 1;
 salida VARCHAR2(120);
 BEGIN

 WHILE cont < LENGTH(p_cadena) +1 LOOP
 IF (SUBSTR(p_cadena,cont,1) IN ('*','@','"','_','#','?','¿','¿'))
 THEN
 salida := salida ||'¿';
 ELSE
 salida := salida || SUBSTR(p_cadena,cont,1);
 END IF;
 cont := cont + 1;
 END LOOP;
 RETURN salida;
 END f_conviertecadena;
 FUNCTION f_nom_contratante (
 p_cod_cia NUMBER,
 p_tip_docum VARCHAR2,
 p_cod_docum VARCHAR2
 )RETURN VARCHAR2
 IS
 l_existe BOOLEAN;
 l_contratante VARCHAR2 (200);
 CURSOR c_a1001399
 IS
 SELECT *
 FROM A1001399@TRON
 WHERE COD_CIA = p_cod_cia
 AND TIP_DOCUM = p_tip_docum
 AND COD_DOCUM = p_cod_docum;

 reg A1001399@TRON%ROWTYPE;
 BEGIN
 OPEN c_a1001399;

 FETCH c_a1001399
 INTO reg;

 l_existe := c_a1001399%FOUND;

 CLOSE c_a1001399;
 --
 IF NOT l_existe THEN
 l_contratante := 'NO EXISTE';
 ELSE
 l_contratante :=
 TRIM (reg.nom_tercero)
 || ' '
 || TRIM (reg.ape1_tercero)
 || ' '
 || TRIM (reg.ape2_tercero);
 END IF;
 --
 RETURN l_contratante;
 END f_nom_contratante;
FUNCTION F_ValidarTipDocumento(
 p_NroFila IN NUMBER,
 p_TipDocumento IN VARCHAR2
 ) RETURN VARCHAR2
 IS
BEGIN
 IF p_TipDocumento IS NULL OR p_TipDocumento='' THEN
 RETURN 'TIPO DE DOCUMENTO VACIO O NULO, FILA: '||p_NroFila||', DATO OBLIGATORIO.';
 ELSIF LENGTH(p_TipDocumento)<>3 THEN
 RETURN 'TIPO DE DOCUMENTO INCORRECTO, FILA: '||p_NroFila||', LONGITUD DE 3 CARACTERES.';
 ELSIF UPPER(p_TipDocumento)<>'DNI' AND UPPER(p_TipDocumento)<>'CEX' AND UPPER(p_TipDocumento)<>'PEX' THEN
 RETURN 'TIPO DE DOCUMENTO INCORRECTO, FILA: '||p_NroFila||', VALORES PERMITIDOS DNI, CEX, PEX.';
 ELSE
 RETURN '';
 END IF;
 EXCEPTION
 WHEN OTHERS THEN
 RETURN '';
END F_ValidarTipDocumento;
FUNCTION F_ValidarNroDocumento(
 p_NroFila IN NUMBER,
 p_TipDocumento IN VARCHAR2,
 p_NroDocumento IN VARCHAR2
 ) RETURN VARCHAR2
 IS
 cEsNro VARCHAR2(2):='';
BEGIN
 SELECT CASE WHEN TRANSLATE(UPPER(p_NroDocumento), 'T0123456789', 'T') IS NULL AND p_NroDocumento IS NOT NULL THEN 'SI'--ES NUMERO
 ELSE 'NO'--NULO
 END INTO cEsNro
 FROM DUAL;
 IF p_NroDocumento IS NULL OR p_NroDocumento='' THEN
 RETURN 'NUMERO DE DOCUMENTO VACIO O NULO, FILA: '||p_NroFila||', DATO OBLIGATORIO.';
 ELSIF cEsNro='NO' THEN
 RETURN 'NUMERO DE DOCUMENTO INCORRECTO, FILA: '||p_NroFila||', VALOR DEBE SER NUMERICO.';
 ELSIF UPPER(p_TipDocumento)='DNI' AND LENGTH(p_NroDocumento)<>8 THEN
 RETURN 'NUMERO DE DOCUMENTO INCORRECTO, FILA: '||p_NroFila||', LONGITUD 8 DIGITOS.';
 ELSIF LENGTH(p_NroDocumento)>15 THEN
 RETURN 'NUMERO DE DOCUMENTO INCORRECTO, FILA: '||p_NroFila||', LONGITUD MAX. 15 DIGITOS.';
 ELSE
 RETURN '';
 END IF;
 EXCEPTION
 WHEN OTHERS THEN
 RETURN '';
END F_ValidarNroDocumento;
FUNCTION F_ValidarNomCompleto(
 p_NroFila IN NUMBER,
 p_NomCompleto IN VARCHAR2,
 p_Nombre IN VARCHAR2,
 p_ApePaterno IN VARCHAR2,
 p_ApeMaterno IN VARCHAR2
 ) RETURN VARCHAR2
 IS
 cEsLetra VARCHAR2(2):='';
 cMsjRetorno VARCHAR2(4000):='';
BEGIN
 SELECT CASE
 WHEN (TRANSLATE(UPPER(p_NomCompleto), '0ABCDEFGHIJKLMNOPQRSTUVWXYZ ', '0') IS NULL AND p_NomCompleto IS NOT NULL) OR p_NomCompleto IS NULL THEN 'SI'--ES TEXTO
 ELSE 'NO'--NULO
 END INTO cEsLetra
 FROM DUAL;
 IF (p_Nombre IS NULL OR TRIM(p_Nombre)='') AND (p_ApePaterno IS NULL OR TRIM(p_ApePaterno)='') AND (p_ApeMaterno IS NULL OR TRIM(p_ApeMaterno)='') AND (p_NomCompleto IS NULL OR TRIM(p_NomCompleto)='') THEN
 cMsjRetorno:= 'NOMBRES VACIO O NULO, FILA: '||p_NroFila||', DATO OBLIGATORIO NOMBRE, APE. PATERNO, APE. MATERNO O NOMBRE COMPLETO.';
 END IF;
 IF cEsLetra='NO' THEN
 IF cMsjRetorno IS NULL THEN
 RETURN 'NOMBRE COMPLETO INCORRECTO, FILA: '||p_NroFila||', VALORES PERMITIDOS SOLO LETRAS.';
 ELSE
 RETURN cMsjRetorno||'|NOMBRE COMPLETO INCORRECTO, FILA: '||p_NroFila||', VALORES PERMITIDOS SOLO LETRAS.';
 END IF;
 ELSIF LENGTH(p_NomCompleto) > 80 THEN
 IF cMsjRetorno IS NULL THEN
 RETURN 'NOMBRE COMPLETO INCORRECTO, FILA: '||p_NroFila||', LONGITUD MAX. 80 CARACTERES.';
 ELSE
 RETURN cMsjRetorno||'|NOMBRE COMPLETO INCORRECTO, FILA: '||p_NroFila||', LONGITUD MAX. 80 CARACTERES.';
 END IF;
 ELSE
 RETURN '';
 END IF;
 EXCEPTION
 WHEN OTHERS THEN
 RETURN '';
END F_ValidarNomCompleto;
FUNCTION F_ValidarNombre(
 p_NroFila IN NUMBER,
 p_Nombre IN VARCHAR2
 ) RETURN VARCHAR2
 IS
 cEsLetra VARCHAR2(2):='';
BEGIN
 SELECT CASE
 WHEN (TRANSLATE(UPPER(p_Nombre), '0ABCDEFGHIJKLMNOPQRSTUVWXYZ ', '0') IS NULL AND p_Nombre IS NOT NULL) OR p_Nombre IS NULL THEN 'SI'--ES TEXTO
 ELSE 'NO'--NUMERICO
 END INTO cEsLetra
 FROM DUAL;
 IF cEsLetra='NO' THEN
 RETURN 'NOMBRE INCORRECTO, FILA: '||p_NroFila||', VALORES PERMITIDOS SOLO LETRAS.';
 ELSIF LENGTH(p_Nombre) > 30 THEN
 RETURN 'NOMBRE INCORRECTO, FILA: '||p_NroFila||', LONGITUD MAX. 30 CARACTERES.';
 ELSE
 RETURN '';
 END IF;
 EXCEPTION
 WHEN OTHERS THEN
 RETURN '';
END F_ValidarNombre;
FUNCTION F_ValidarApellido(
 p_NroFila IN NUMBER,
 p_Apellido IN VARCHAR2,
 p_TipApellido IN VARCHAR2
 ) RETURN VARCHAR2
 IS
 cEsLetra VARCHAR2(2):='';
BEGIN
 SELECT CASE
 WHEN (TRANSLATE(UPPER(p_Apellido), '0ABCDEFGHIJKLMNOPQRSTUVWXYZ ', '0') IS NULL AND p_Apellido IS NOT NULL) OR p_Apellido IS NULL THEN 'SI'--ES TEXTO
 ELSE 'NO'--NUMERICO
 END INTO cEsLetra
 FROM DUAL;
 IF cEsLetra='NO' THEN
 RETURN 'APELLIDO '||p_TipApellido||' INCORRECTO, FILA: '||p_NroFila||', VALORES PERMITIDOS SOLO LETRAS.';
 ELSIF LENGTH(p_Apellido) > 20 THEN
 RETURN 'APELLIDO '||p_TipApellido||' INCORRECTO, FILA: '||p_NroFila||', LONGITUD MAX. 20 CARACTERES.';
 ELSE
 RETURN '';
 END IF;
 EXCEPTION
 WHEN OTHERS THEN
 RETURN '';
END F_ValidarApellido;
FUNCTION F_ValidarFecNaci(
 p_NroFila IN NUMBER,
 p_FecNacimiento IN VARCHAR2
 ) RETURN VARCHAR2
 IS
 cFecha DATE;
BEGIN
 BEGIN
 cFecha:=TO_DATE(p_FecNacimiento,'DD/MM/YYYY');
 EXCEPTION
 WHEN OTHERS THEN
 RETURN 'FECHA DE NACIMIENTO INCORRECTA, FILA: '||p_NroFila||', FORMATO DEBE SER DD/MM/YYYY.';
 END;
 IF EXTRACT(YEAR FROM cFecha)<1900 THEN
 RETURN 'FECHA DE NACIMIENTO INCORRECTA, FILA: '||p_NroFila||', FECHA DEBE SER MAYOR A 1900.';
 ELSE
 RETURN '';
 END IF;
 EXCEPTION
 WHEN OTHERS THEN
 RETURN '';
END F_ValidarFecNaci;
FUNCTION F_ValidarSueldo(
 p_NroMovimiento NUMBER,
 p_NroFila IN NUMBER,
 p_Sueldo IN VARCHAR2
 ) RETURN VARCHAR2
 IS
 cEsNro VARCHAR2(2):='';
 vl_Sueldo_Tope NUMBER:=0;
 vl_Cod_Cia NUMBER;
 vl_Cod_Ramo NUMBER;
 vl_Sueldo NUMBER;
BEGIN
 BEGIN
 vl_Sueldo:=TO_NUMBER(p_Sueldo);
 EXCEPTION
 WHEN OTHERS THEN
 cEsNro:='NO';
 END;
 SELECT COD_CIA,COD_RAMO INTO vl_Cod_Cia,vl_Cod_Ramo FROM OIM.RCEN_ASEG0002_TEMP WHERE NRO_MOVIMIENTO=p_NroMovimiento;

 IF vl_Cod_Ramo=610 THEN
 SCTR.SCTR_GEST_ASEG.P_RECUPERA_SUELDO_TOPE(vl_Cod_Cia,vl_Cod_Ramo,vl_Sueldo_Tope);
 END IF;
 IF p_Sueldo IS NULL OR p_Sueldo='' THEN
 RETURN 'SUELDO VACIO O NULO, FILA: '||p_NroFila||', DATO OBLIGATORIO.';
 ELSIF cEsNro='NO' THEN
 RETURN 'SUELDO INCORRECTO, FILA: '||p_NroFila||', VALOR DEBE SER NUMERICO.';
 ELSIF TO_NUMBER(p_Sueldo)<750 THEN
 RETURN 'SUELDO INCORRECTO, FILA: '||p_NroFila||', VALOR MINIMO 750.';
 ELSIF vl_Sueldo_Tope>0 AND TO_NUMBER(p_Sueldo)>vl_Sueldo_Tope THEN
 RETURN 'SUELDO INCORRECTO, FILA: '||p_NroFila || ', SUPERO EL TOPE DE SUELDO DE S/.' || vl_Sueldo_Tope;
 ELSE
 RETURN '';
 END IF;
 EXCEPTION
 WHEN OTHERS THEN
 RETURN '';
END F_ValidarSueldo;
FUNCTION F_ValidarOcupacion(
 p_NroFila IN NUMBER,
 p_Ocupacion IN VARCHAR2
 ) RETURN VARCHAR2
 IS
 cEsLetra VARCHAR2(2):='';
BEGIN
 SELECT CASE WHEN TRANSLATE(UPPER(p_Ocupacion), '0ABCDEFGHIJKLMNOPQRSTUVWXYZ ', '0') IS NULL AND p_Ocupacion IS NOT NULL THEN 'SI'--ES TEXTO
 ELSE 'NO'--NULO
 END INTO cEsLetra
 FROM DUAL;
 IF cEsLetra='NO' THEN
 RETURN 'OCUPACION INCORRECTA, FILA: '||p_NroFila||', VALORES PERMITIDOS SOLO LETRAS.';
 ELSIF LENGTH(p_Ocupacion) > 40 THEN
 RETURN 'OCUPACION INCORRECTA, FILA: '||p_NroFila||', LONGITUD MAX. 30 CARACTERES.';
 ELSE
 RETURN '';
 END IF;
 EXCEPTION
 WHEN OTHERS THEN
 RETURN '';
END F_ValidarOcupacion;
FUNCTION F_ValidarFilaRepetida(
 p_NroFila IN NUMBER,
 p_NroMovimiento IN NUMBER,
 p_TipDocumento IN VARCHAR2,
 p_NroDocumento IN VARCHAR2
 ) RETURN VARCHAR2
 IS
 vl_Mensaje VARCHAR2(4000);
BEGIN

 DECLARE CURSOR cur IS
 SELECT NRO_MOVIMIENTO,NRO_FILA,TIPDOC,NUMDOC FROM OIM.RCEN_ASEG0004_TEMP
 WHERE NRO_MOVIMIENTO= p_NroMovimiento AND NRO_FILA>p_NroFila;
 BEGIN
 FOR v_reg IN cur LOOP
 --VERIFICAMOS SI TIENE TIPO Y NUMERO DE DOCUMENTO IGUALES
 IF v_reg.TIPDOC=p_TipDocumento AND v_reg.NUMDOC=p_NroDocumento THEN
 IF vl_Mensaje IS NULL THEN vl_Mensaje:='NUMDOC DUPLICADO, FILAS: ('||p_NroFila||' Y '|| v_reg.NRO_FILA||'), DATO UNICO.';
 ELSE vl_Mensaje:=vl_Mensaje||'|NUMDOC DUPLICADO, FILAS: ('||p_NroFila||' Y '|| v_reg.NRO_FILA||'), DATO UNICO.';
 END IF;
 END IF;
 END LOOP;
 END;
 RETURN vl_Mensaje;
 EXCEPTION
 WHEN OTHERS THEN
 RETURN '';
END F_ValidarFilaRepetida;
function f_forma_pago (p_cod_cia number, p_num_poliza varchar2)
 return varchar2
 is
 l_existe boolean;
 lccolectivo varchar2(30);

 cursor cur_colectivo
 is
 select *
 from a2000020@tron
 where cod_cia = p_cod_cia
 and num_poliza = p_num_poliza
 and cod_campo = 'COD_FORMA_PAGO';

 reg a2000020@tron%rowtype;
 begin
 open cur_colectivo;

 fetch cur_colectivo into reg;

 l_existe := cur_colectivo%found;

 close cur_colectivo;

 if not l_existe
 then
 lccolectivo := 'NO EXISTE';
 else
 lccolectivo := reg.txt_campo;
 end if;

 --
 return lccolectivo;
 end f_forma_pago;
 function f_nom_moneda (p_cod_mon number)
 return varchar2
 is
 l_txt_mensaje varchar2(69);
 l_existe boolean;
 reg a1000400@tron%rowtype;

 --
 cursor c_a1000400
 is
 select *
 from a1000400@tron
 where cod_mon = p_cod_mon;
 --
 begin
 --
 open c_a1000400;

 fetch c_a1000400 into reg;

 l_existe := c_a1000400%found;

 close c_a1000400;

 --
 if not l_existe
 then
 l_txt_mensaje := 'X';
 else
 l_txt_mensaje := reg.nom_mon;
 end if;

 --
 return l_txt_mensaje;
 --
 exception
 when no_data_found
 then
 return 'X';
 end f_nom_moneda;
 function f_nom_colectivo (p_cod_cia number, p_num_poliza varchar2)
 return varchar2
 is
 l_existe boolean;
 lccolectivo varchar2 (200);

 cursor cur_colectivo
 is
 select *
 from a2000020@tron
 where cod_cia = p_cod_cia
 and num_poliza = p_num_poliza
 and cod_campo = 'NOM_COLECTIVO_ASEG'
 and mca_vigente = 'S'; -- NFSE RMUCHA 27/03/13 Mostrar solo un colectivo asegurado

 reg a2000020@tron%rowtype;
 begin
 open cur_colectivo;

 fetch cur_colectivo into reg;

 l_existe := cur_colectivo%found;

 close cur_colectivo;

 if not l_existe
 then
 lccolectivo := 'NO EXISTE';
 else
 if reg.txt_campo is null
 then
 lccolectivo := reg.val_campo;
 else
 lccolectivo := reg.txt_campo;
 end if;
 end if;

 --
 return lccolectivo;
 end f_nom_colectivo;
function f_act_economica (p_cod_cia number, p_num_poliza varchar2)
 return varchar2
 is
 l_existe boolean;
 lccolectivo varchar2 (200);

 cursor cur_colectivo
 is
 select *
 from a2000020@tron
 where cod_cia = p_cod_cia
 and num_poliza = p_num_poliza
 and cod_campo = 'COD_ACTIVIDAD'
 and MCA_VIGENTE = 'S'
 and MCA_VIGENTE_APLI = 'S';

 reg a2000020@tron%rowtype;
 begin
 open cur_colectivo;

 fetch cur_colectivo
 into reg;

 l_existe := cur_colectivo%found;

 close cur_colectivo;

 if not l_existe
 then
 lccolectivo := 'NO EXISTE';
 else
 lccolectivo := reg.val_campo || ' - ' || reg.txt_campo;
 end if;

 --
 return lccolectivo;
 end f_act_economica;

function f_obte_num_mvto_por_plz (
 p_Cod_Cia IN VARCHAR2,--02
 p_Num_Poliza IN VARCHAR2,--03
 p_Num_Spto IN VARCHAR2,--04
 p_Num_Apli IN VARCHAR2,--05
 p_Num_Spto_Apli IN VARCHAR2,--06
 p_Cod_Usuario IN VARCHAR2,--06
 p_Cod_Sistema IN VARCHAR2--07
 )
 return number
 is
 vl_Nro_Movimiento NUMBER;

 begin

 begin

 select

 x.NRO_MOVIMIENTO into vl_Nro_Movimiento

 from RCEN_ASEG0002_TEMP x

 where x.COD_CIA = p_Cod_Cia and

 x.num_poliza = p_Num_Poliza and
 x.num_spto = p_Num_Spto and
 x.num_apli = p_Num_Apli and
 x. num_spto_apli = p_Num_Spto_Apli and

 x.COD_USR_REG = p_Cod_Usuario and
 x.COD_SISTEMA = p_Cod_Sistema;

 EXCEPTION
 WHEN NO_DATA_FOUND THEN
 vl_Nro_Movimiento := null;
 end;

 return vl_Nro_Movimiento;

 end f_obte_num_mvto_por_plz;

function f_obt_ultima_fila_aseg (
 p_Num_Movimiento in number
 )
 return number
 is
 vl_Nro_fila NUMBER;

 begin

 begin
 select (decode(max(x.nro_fila),null,0,max(x.nro_fila))+1) into vl_Nro_fila from RCEN_ASEG0004_TEMP x
 where x.nro_movimiento = p_Num_Movimiento;
 EXCEPTION
 WHEN NO_DATA_FOUND THEN
 vl_Nro_fila := 1;
 end;

 return vl_Nro_fila;

 end f_obt_ultima_fila_aseg;
/*==============================================================================
PROPOSITO: Inserta Log
AUTOR: AALVARADO FECHA: 11/11/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_Usuario -> Codigo de Usuario
 - as_Sistema -> Sistema
 - as_Nro_Poliza -> Numero de poliza
 - ad_Fecha -> Fecha de registro
 - as_Parametros -> Parametros del metodo
 - as_Mensaje -> Mensaje
 - p_nRetorno -> Indicador de Retorno
 - p_cMensaje -> Mensaje de Retorno
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
 - Inserta Log de Auditoria de los Procedimientos que se utilizan en el servicio Centralizado "WSAsegurados"
==============================================================================*/
 PROCEDURE PGEAS000(
 as_Usuario IN RCEN_ASEG0007_LOG.USUARIO%TYPE,
 as_Sistema IN RCEN_ASEG0007_LOG.SISTEMA%TYPE,
 as_Nro_Poliza IN RCEN_ASEG0007_LOG.POLIZA%TYPE,
 ad_Fecha IN RCEN_ASEG0007_LOG.FECHA_HORA%TYPE,
 as_Parametros IN RCEN_ASEG0007_LOG.PARAMETROS%TYPE,
 as_Mensaje IN RCEN_ASEG0007_LOG.MENSAJE%TYPE,
 p_nRetorno OUT NUMBER,
 p_cMensaje OUT VARCHAR
 )
 IS
 vl_Id_Log NUMBER;
 BEGIN
 SELECT NVL(MAX(ID_LOG),0)+1 INTO vl_Id_Log FROM OIM.RCEN_ASEG0007_LOG;
 INSERT INTO OIM.RCEN_ASEG0007_LOG (ID_LOG,USUARIO,SISTEMA,POLIZA,FECHA_HORA,PARAMETROS,MENSAJE)
 VALUES (vl_Id_Log,as_Usuario,as_Sistema,as_Nro_Poliza,ad_Fecha,as_Parametros,as_Mensaje);
 p_nRetorno := 1;
 p_cMensaje := 'OK';
 EXCEPTION
 WHEN OTHERS THEN
 p_nRetorno := -1;
 p_cMensaje := 'ER:'||SQLERRM;
 END PGEAS000;
/*==============================================================================
PROPOSITO: Genera Movimiento en tablas Temporales
AUTOR: AALVARADO FECHA: 17/11/2014
AUTOR: JRAFFO FECHA: 28/08/2015
SE HIZO UN AJUSTO PARA QUE SE TOME EN CUENTA EL CAMPO DE AUDITORIA COD_SISTEMA
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
 PROCEDURE PGEAS001(
 as_Cod_Cia IN VARCHAR2,--01
 as_Num_Poliza IN VARCHAR2,--02
 as_Num_Spto IN VARCHAR2,--03
 as_Num_Apli IN VARCHAR2,--04
 as_Num_Spto_Apli IN VARCHAR2,--05
 as_Cod_Usuario IN VARCHAR2,--06
 as_Cod_Sistema IN VARCHAR2,--07
 --Variables de Retorno
 p_nRetorno OUT NUMBER,--08
 p_cMensaje OUT VARCHAR--09
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

 INSERT INTO OIM.RCEN_ASEG0001_TEMP(NRO_MOVIMIENTO,TIP_DOCUMENTO,NRO_DOCUMENTO,FEC_INI_VIG,FEC_FIN_VIG,TIPO_MOVIMIENTO,MCA_FACTURADO,MCA_BAJA,COD_USR_REG,FEC_REG,COD_SISTEMA)
 SELECT vl_Nro_Movimiento,TIP_DOCUM,COD_DOCUM,FEC_EFEC_SPTO,FEC_VCTO_SPTO,'DE','S','N',as_Cod_Usuario,SYSDATE,as_Cod_Sistema
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
 DELETE FROM OIM.RCEN_ASEG0004_TEMP WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento;
 END IF;
 p_nRetorno := vl_Nro_Movimiento;
 p_cMensaje := 'OK';
 EXCEPTION
 WHEN OTHERS THEN
 p_nRetorno := -1;
 p_cMensaje := 'ER:'||SQLERRM;
 ROLLBACK;
 END PGEAS001;
/*==============================================================================
PROPOSITO: Inserta Datos Asegurado
AUTOR: AALVARADO FECHA: 11/11/2014
AUTOR: JRAFFO FECHA: 28/08/2015
SE HIZO UN AJUSTO PARA QUE SE TOME EN CUENTA EL CAMPO DE AUDITORIA COD_SISTEMA
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_TipDoc -> Tipo de Documento
 - as_NumDoc -> Numero de Documento
 - as_ApePaterno -> Apellido Paterno
 - as_ApeMaterno -> Apellido Materno
 - as_Nombres -> Nombres
 - as_NombreCompleto -> Nombre Completo
 - as_Fec_Nacimiento -> Fecha de Nacimiento
 - as_Sueldo -> Sueldo
 - as_Ocupacion -> Ocupacion
 - as_NroMovimiento -> Numero de Movimiento
 - as_Cod_Usuario -> Codigo de Usuario
 - as_Cod_Sistema -> Codigo de Sistema
 - an_NumFila -> Numero de Fila
 - p_nRetorno -> Indicador de Retorno
 - p_cMensaje -> Mensaje de Retorno
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
 - Inserta datos de Asegurado para ser validados
==============================================================================*/
 PROCEDURE PGEAS002(
 as_TipDoc IN VARCHAR2,--01
 as_NumDoc IN VARCHAR2,--02
 as_ApePaterno IN VARCHAR2,--03
 as_ApeMaterno IN VARCHAR2,--04
 as_Nombres IN VARCHAR2,--05
 as_NombreCompleto IN VARCHAR2,--06
 as_Fec_Nacimiento IN VARCHAR2,--07
 an_Sueldo IN NUMBER,--08
 as_Ocupacion IN VARCHAR2,--09
 as_Nro_Movimiento IN VARCHAR2,--10
 as_Cod_Usuario IN VARCHAR2,--11
 as_Cod_Sistema IN VARCHAR2,--12
 an_NumFila IN NUMBER,--13
 --Variables de Retorno
 p_nRetorno OUT NUMBER,--14
 p_cMensaje OUT VARCHAR--15
 )
 IS
 BEGIN
 INSERT INTO OIM.RCEN_ASEG0004_TEMP (NRO_MOVIMIENTO,NRO_MOVIMIENTO_REG,NRO_FILA,TIPDOC,NUMDOC,
 APEPAT,APEMAT,NOMBRES,NOMBRECOMPLETO,FECNAC,
 SUELDO,OCUPACION,COD_USR_REG,FEC_REG,COD_SISTEMA) VALUES
 (as_Nro_Movimiento,NULL,an_NumFila,as_TipDoc,as_NumDoc,
 as_ApePaterno,as_ApeMaterno,as_Nombres,as_NombreCompleto,as_Fec_Nacimiento,
 TO_CHAR(an_Sueldo),as_Ocupacion,as_Cod_Usuario,SYSDATE,as_Cod_Sistema
 );
 p_nRetorno := 1;
 p_cMensaje := 'OK';
 EXCEPTION
 WHEN OTHERS THEN
 p_nRetorno := -1;
 p_cMensaje := 'ER:'||SQLERRM;
 ROLLBACK;
 END PGEAS002;
/*==============================================================================
PROPOSITO: Valida Registros Tabla Temp Asegurados.
AUTOR: AALVARADO FECHA: 12/11/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_Num_Movimiento -> Ocupacion
 - as_Cod_Cia -> Codigo de Compania
 - as_Num_Poliza -> Numero de Poliza
 - as_Num_Spto -> Numero de Suplemento
 - as_Num_Apli -> Numero de Aplicacion
 - as_Num_Spto_Apli -> Numero de Suplemento Aplicacion
 - as_Cod_Usuario -> Codigo de Usuario
 - as_Cod_Sistema -> Codigo de Sistema
 - an_NumFila -> Numero de Fila
 - o_cursor -> Cursor
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
 - Valida todos los registros cargados en la tabla temporal por Movimiento o Nro Poliza.
==============================================================================*/
 PROCEDURE PGEAS003(
 as_Num_Movimiento IN VARCHAR2,
 as_Cod_Cia IN VARCHAR2,
 as_Num_Poliza IN VARCHAR2,
 as_Num_Spto IN VARCHAR2,
 as_Num_Apli IN VARCHAR2,
 as_Num_Spto_Apli IN VARCHAR2,
 as_Cod_Usuario IN VARCHAR2,
 as_Cod_Sistema IN VARCHAR2,
 --Variables de Retorno
 o_cursor OUT t_cursor
 )
 IS
 vl_Nro_Movimiento NUMBER;
 BEGIN
 IF as_Num_Movimiento IS NULL THEN
 SELECT NRO_MOVIMIENTO INTO vl_Nro_Movimiento
 FROM OIM.RCEN_ASEG0002_TEMP WHERE COD_CIA=as_Cod_Cia AND COD_RAMO=SUBSTR(as_Num_Poliza,1,3) AND NUM_POLIZA=as_Num_Poliza AND NUM_SPTO=
 as_Num_Spto
 AND NUM_APLI=as_Num_Apli AND NUM_SPTO_APLI=as_Num_Spto_Apli AND COD_USR_REG=
 as_Cod_Usuario;
 ELSE
 vl_Nro_Movimiento:=as_Num_Movimiento;
 END IF;
 OPEN o_cursor FOR
 SELECT * FROM (
 SELECT NRO_MOVIMIENTO,
 NRO_FILA,
 OIM.PCK_GEST_ASEG.F_ValidarTipDocumento(NRO_FILA,TIPDOC) TIP_DOCUMEN,
 OIM.PCK_GEST_ASEG.F_ValidarNroDocumento(NRO_FILA,TIPDOC,NUMDOC) NRO_DOCUMEN,
 OIM.PCK_GEST_ASEG.F_ValidarNomCompleto(NRO_FILA,NOMBRECOMPLETO,NOMBRES,APEPAT,APEMAT) MOM_COMPLETO,
 OIM.PCK_GEST_ASEG.F_ValidarApellido(NRO_FILA,APEPAT,'PATERNO') APE_PATERNO,
 OIM.PCK_GEST_ASEG.F_ValidarApellido(NRO_FILA,APEMAT,'MATERNO') APE_MATERNO,
 OIM.PCK_GEST_ASEG.F_ValidarNombre(NRO_FILA,NOMBRES) NOMBRE,
 OIM.PCK_GEST_ASEG.F_ValidarFecNaci(NRO_FILA,FECNAC) FEC_NACIMIENTO,
 OIM.PCK_GEST_ASEG.F_ValidarSueldo(NRO_MOVIMIENTO,NRO_FILA,SUELDO) SUELDO,
 DECODE(SUBSTR(as_Num_Poliza,1,3),610,OIM.PCK_GEST_ASEG.F_ValidarOcupacion(NRO_FILA,OCUPACION),'')OCUPACION,
 OIM.PCK_GEST_ASEG.F_ValidarFilaRepetida(NRO_FILA,NRO_MOVIMIENTO,TIPDOC,NUMDOC) FILA_REPETIDA
 FROM OIM.RCEN_ASEG0004_TEMP
 WHERE NRO_MOVIMIENTO= vl_Nro_Movimiento
 ) T
 WHERE LENGTH(TIP_DOCUMEN)>0 OR LENGTH(NRO_DOCUMEN)>0 OR LENGTH(MOM_COMPLETO)>0 OR
 LENGTH(NOMBRE)>0 OR LENGTH(APE_PATERNO)>0 OR LENGTH(APE_MATERNO)>0 OR
 LENGTH(FEC_NACIMIENTO)>0 OR LENGTH(SUELDO)>0 OR LENGTH(OCUPACION)>0 OR LENGTH(FILA_REPETIDA)>0;
 EXCEPTION
 WHEN OTHERS THEN

 ROLLBACK;
 END PGEAS003;
/*==============================================================================
PROPOSITO: Registrar Movimiento
AUTOR: AALVARADO FECHA: 11/11/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
 - as_Num_Movimiento -> Numero de Movimiento
 - as_Cod_Cia -> Codigo de Compania
 - as_Num_Poliza -> Numero de Poliza
 - as_Num_Spto -> Numero de Suplemento
 - as_Num_Apli -> Numero de Aplicacion
 - as_Num_Spto_Apli -> Numero de Suplemento Aplicacion
 - as_Tip_Movimiento -> Tipo de Movimiento
 - as_Mca_Facturado -> Marca Facturado
 - as_Cod_Usuario -> Codigo de Usuario
 - as_Cod_Sistema -> Codigo de Sistema
 - p_nRetorno -> Indicador de Retorno
 - p_cMensaje -> Mensaje de Retorno
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
 - Registra un Movimiento en las tablas Reales.
==============================================================================*/
 PROCEDURE PGEAS004(
 as_Num_Movimiento IN VARCHAR2,--01
 as_Cod_Cia IN VARCHAR2,--02
 as_Num_Poliza IN VARCHAR2,--03
 as_Num_Spto IN VARCHAR2,--04
 as_Num_Apli IN VARCHAR2,--05
 as_Num_Spto_Apli IN VARCHAR2,--06
 as_Tip_Movimiento IN VARCHAR2,--07
 as_Mca_Facturado IN VARCHAR2,--08
 as_Cod_Usuario IN VARCHAR2,--09
 as_Cod_Sistema IN VARCHAR2,--10
 --Variables de Retorno
 p_nRetorno OUT NUMBER,--11
 p_cMensaje OUT VARCHAR2--12
 )
 IS
 EXCEPTION_ASEG EXCEPTION ;
 EXCEPTION_MOVI EXCEPTION;
 vl_Nro_Movimiento NUMBER;
 Nro_Movi_Vacio EXCEPTION;
 vl_cod_aseg number;

 vl_Cod_Cia NUMBER;
 vl_Num_Poliza VARCHAR2(13);
 vl_Num_Spto NUMBER;
 vl_Num_Apli NUMBER;
 vl_Num_Spto_Apli NUMBER;

 BEGIN
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','as_Num_Movimiento = ' || as_Num_Movimiento);
 IF as_Num_Movimiento IS NULL THEN
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','as_Num_Movimiento is nulo');
 BEGIN
 SELECT NRO_MOVIMIENTO INTO vl_Nro_Movimiento
 FROM OIM.RCEN_ASEG0002_TEMP WHERE COD_CIA=as_Cod_Cia AND COD_RAMO=SUBSTR(as_Num_Poliza,1,3) AND NUM_POLIZA=as_Num_Poliza AND NUM_SPTO=
 as_Num_Spto
 AND NUM_APLI=as_Num_Apli AND NUM_SPTO_APLI=as_Num_Spto_Apli AND COD_USR_REG=
 as_Cod_Usuario AND COD_SISTEMA=as_Cod_Sistema;
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Nro_Movimiento = ' || vl_Nro_Movimiento);
 EXCEPTION
 WHEN NO_DATA_FOUND THEN
 RAISE Nro_Movi_Vacio;
 END;
 ELSE
 vl_Nro_Movimiento:= as_Num_Movimiento;
 END IF;

 IF as_Cod_Cia IS NULL OR as_Num_Poliza IS NULL OR as_Num_Spto IS NULL OR as_Num_Apli IS NULL OR as_Num_Spto_Apli IS NULL THEN
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','as_Cod_Cia is nulo');
 SELECT COD_CIA,NUM_POLIZA,NUM_SPTO,NUM_APLI,NUM_SPTO_APLI
 INTO vl_Cod_Cia,vl_Num_Poliza,vl_Num_Spto,vl_Num_Apli,vl_Num_Spto_Apli
 FROM OIM.RCEN_ASEG0002_TEMP
 WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento;
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Cod_Cia = ' || vl_Cod_Cia);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Num_Poliza = ' || vl_Num_Poliza);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Num_Spto = ' || vl_Num_Spto);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Num_Apli = ' || vl_Num_Apli);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Num_Spto_Apli = ' || vl_Num_Spto_Apli);
 ELSE
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','as_Cod_Cia not is nulo');
 vl_Cod_Cia := as_Cod_Cia;
 vl_Num_Poliza := as_Num_Poliza;
 vl_Num_Spto := as_Num_Spto;
 vl_Num_Apli := as_Num_Apli;
 vl_Num_Spto_Apli := as_Num_Spto_Apli;
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Cod_Cia = ' || vl_Cod_Cia);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Num_Poliza = ' || vl_Num_Poliza);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Num_Spto = ' || vl_Num_Spto);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Num_Apli = ' || vl_Num_Apli);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_Num_Spto_Apli = ' || vl_Num_Spto_Apli);
 END IF;
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','INICIO INSERT RCEN_ASEG0001');
 INSERT INTO OIM.RCEN_ASEG0001
 (NRO_MOVIMIENTO,TIP_DOCUMENTO,NRO_DOCUMENTO,FEC_INI_VIG,FEC_FIN_VIG,
 TIPO_MOVIMIENTO,MCA_FACTURADO,MCA_BAJA,COD_USR_REG,FEC_REG,
 COD_USR_ACTU,FEC_ACTU)
 SELECT NRO_MOVIMIENTO,TIP_DOCUMENTO,NRO_DOCUMENTO,FEC_INI_VIG,FEC_FIN_VIG,
 as_Tip_Movimiento TIPO_MOVIMIENTO,as_Mca_Facturado MCA_FACTURADO,MCA_BAJA,COD_USR_REG,FEC_REG,
 COD_USR_ACTU,FEC_ACTU
 FROM OIM.RCEN_ASEG0001_TEMP WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento;
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','FIN INSERT RCEN_ASEG0001');

 IF as_Mca_Facturado='S' THEN
 ---> Para Actualizar algunos datos en caso no esten <---
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','INICIO OIM.pck_gest_aseg.PGEAS011');
 OIM.pck_gest_aseg.PGEAS011 (vl_Nro_Movimiento,vl_Cod_Cia,vl_Num_Poliza,vl_Num_Spto,vl_Num_Apli,vl_Num_Spto_Apli,as_Tip_Movimiento,as_Cod_Usuario);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','FIN pck_gest_aseg.PGEAS011');
 END IF;

 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','INICIO INSERT RCEN_ASEG0002');
 --> Registrar lo datos de la Poliza <--
 INSERT INTO OIM.RCEN_ASEG0002
 SELECT * FROM OIM.RCEN_ASEG0002_TEMP WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento;
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','FIN INSERT RCEN_ASEG0002');

 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','INICIO INSERT RCEN_ASEG0003');
 --> Registrar los datos de los Riesgos <--
 INSERT INTO OIM.RCEN_ASEG0003(NRO_MOVIMIENTO,COD_CIA,COD_RAMO,NUM_RIESGO,RIESGO,CANT_TRAB,IMPOR_PLANILLA ,TASA,SUB_TOTAL,PRIMA_NETA,FACTOR,COD_USR_REG,FEC_REG,COD_USR_ACTU ,FEC_ACTU,PRIMA_TOTAL,NUM_POLIZA,NUM_SPTO,NUM_APLI,NUM_SPTO_APLI)
 SELECT NRO_MOVIMIENTO,COD_CIA,COD_RAMO,NUM_RIESGO,RIESGO,CANT_TRAB,IMPOR_PLANILLA ,TASA,SUB_TOTAL,PRIMA_NETA,FACTOR,COD_USR_REG,FEC_REG,COD_USR_ACTU ,FEC_ACTU,PRIMA_TOTAL,NUM_POLIZA,NUM_SPTO,NUM_APLI,NUM_SPTO_APLI FROM OIM.RCEN_ASEG0003_TEMP WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento;
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','FIN INSERT RCEN_ASEG0003');


 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','INICIO CURSOR');
 --> Cargamos el cursor de la planilla <--
 DECLARE CURSOR c_Planilla IS
 SELECT
 --(SELECT X.COD_ASEG FROM OIM.RCEN_ASEGURADOS X WHERE X.TIPO_DOC=A.TIPDOC AND X.NRO_DOCUMENTO=A.NUMDOC AND ROWNUM=1) COD_ASEG,
 A.NRO_MOVIMIENTO,B.COD_CIA,B.COD_RAMO,B.NUM_POLIZA,
 B.NUM_SPTO,B.NUM_APLI,B.NUM_SPTO_APLI,
 (SELECT X.FEC_INI_VIG FROM OIM.RCEN_ASEG0001 X WHERE X.NRO_MOVIMIENTO=A.NRO_MOVIMIENTO)FEC_INI_VIG,
 (SELECT X.FEC_FIN_VIG FROM OIM.RCEN_ASEG0001 X WHERE X.NRO_MOVIMIENTO=A.NRO_MOVIMIENTO)FEC_FIN_VIG,
 A.OCUPACION,
 (SELECT X.MCA_BAJA FROM OIM.RCEN_ASEG0001 X WHERE X.NRO_MOVIMIENTO=A.NRO_MOVIMIENTO)MCA_BAJA,TO_NUMBER(A.SUELDO) SUELDO,
 A.COD_USR_REG,A.FEC_REG,A.COD_USR_ACTU,A.FEC_ACTU,
 A.TIPDOC, A.NUMDOC,A.APEPAT,A.APEMAT,A.NOMBRES,A.NOMBRECOMPLETO,A.FECNAC,A.NUM_RIESGO
 FROM OIM.RCEN_ASEG0004_TEMP A
 INNER JOIN OIM.RCEN_ASEG0002_TEMP B ON A.NRO_MOVIMIENTO=B.NRO_MOVIMIENTO
 WHERE A.NRO_MOVIMIENTO=vl_Nro_Movimiento;
 --> Registrar lo datos de la Planilla <--
 BEGIN
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','INICIO BEGIN CURSOR');
 FOR reg_Planilla IN c_Planilla LOOP
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','INICIO OIM.OIM_K_RCEN.INSERTAR_ASEGURADO');
 --> Insertar o Actualizar Asegurado.
 OIM.OIM_K_RCEN.INSERTAR_ASEGURADO(reg_Planilla.NOMBRES,reg_Planilla.NOMBRECOMPLETO, reg_Planilla.APEPAT, reg_Planilla.APEMAT,
 reg_Planilla.FECNAC, reg_Planilla.NUMDOC, reg_Planilla.TIPDOC, reg_Planilla.COD_USR_REG, 0,
 p_nRetorno, p_cMensaje);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','FIN OIM.OIM_K_RCEN.INSERTAR_ASEGURADO');
 IF p_nRetorno = -1 THEN
 p_cMensaje:=p_cMensaje||reg_Planilla.NUMDOC||'-'|| reg_Planilla.TIPDOC;
 RAISE EXCEPTION_ASEG ;
 END IF;
 --commit;
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','FIN OIM.OIM_K_RCEN.INSERTAR_MOVIMIENTO_OIM');
 --> Insertar Movimiento RCEN_MOVIMIENTOS.
 OIM.PCK_GEST_ASEG.INSERTAR_MOVIMIENTO_OIM( reg_Planilla.NUMDOC,
 reg_Planilla.TIPDOC,
 reg_Planilla.COD_USR_REG,
 reg_Planilla.NRO_MOVIMIENTO,
 reg_Planilla.OCUPACION,
 p_nRetorno,
 p_cMensaje);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','FIN OIM.OIM_K_RCEN.INSERTAR_MOVIMIENTO_OIM');

 IF p_nRetorno = -1 THEN
 p_cMensaje:=p_cMensaje||reg_Planilla.NUMDOC||'-'|| reg_Planilla.TIPDOC;
 RAISE EXCEPTION_MOVI;
 END IF;
 --> Optenemos el codigo de asegurado
 SELECT X.COD_ASEG INTO vl_cod_aseg FROM OIM.RCEN_ASEGURADOS X WHERE X.TIPO_DOC=reg_Planilla.TIPDOC AND X.NRO_DOCUMENTO=reg_Planilla.NUMDOC AND ROWNUM=1;
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_cod_aseg='||vl_cod_aseg);

 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','INICIO INSERT RCEN_ASEG0004');
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','*****************************************************************');
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','vl_cod_aseg='||vl_cod_aseg);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.NRO_MOVIMIENTO='||reg_Planilla.NRO_MOVIMIENTO);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.COD_CIA='||reg_Planilla.COD_CIA);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.COD_RAMO='||reg_Planilla.COD_RAMO);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.NUM_POLIZA='||reg_Planilla.NUM_POLIZA);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.NUM_SPTO='||reg_Planilla.NUM_SPTO);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.NUM_APLI='||reg_Planilla.NUM_APLI);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.NUM_SPTO_APLI='||reg_Planilla.NUM_SPTO_APLI);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.FEC_INI_VIG='||reg_Planilla.FEC_INI_VIG);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.FEC_FIN_VIG='||reg_Planilla.FEC_FIN_VIG);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.MCA_BAJA='||reg_Planilla.MCA_BAJA);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.SUELDO='||reg_Planilla.SUELDO);
 tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.OCUPACION='||reg_Planilla.OCUPACION);
                        tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.COD_USR_REG='||reg_Planilla.COD_USR_REG);
                        tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.FEC_REG='||reg_Planilla.FEC_REG);
                        tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.COD_USR_ACTU='||reg_Planilla.COD_USR_ACTU);
                        tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.FEC_ACTU='||reg_Planilla.FEC_ACTU);
                         tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','reg_Planilla.NUM_RIESGO='||reg_Planilla.NUM_RIESGO);
                INSERT INTO OIM.RCEN_ASEG0004--Trabajadores
                  (COD_ASEG,NRO_MOVIMIENTO,COD_CIA,COD_RAMO,NUM_POLIZA,
                    NUM_SPTO,NUM_APLI,NUM_SPTO_APLI,FEC_INI_VIG,FEC_FIN_VIG,
                    MCA_BAJA,SUELDO,OCUPACION,COD_USR_REG,FEC_REG,COD_USR_ACTU,
                    FEC_ACTU,NUM_RIESGO)VALUES
                    (vl_cod_aseg,reg_Planilla.NRO_MOVIMIENTO,reg_Planilla.COD_CIA,reg_Planilla.COD_RAMO,reg_Planilla.NUM_POLIZA,
                    reg_Planilla.NUM_SPTO,reg_Planilla.NUM_APLI,reg_Planilla.NUM_SPTO_APLI,reg_Planilla.FEC_INI_VIG,reg_Planilla.FEC_FIN_VIG,
                    reg_Planilla.MCA_BAJA,reg_Planilla.SUELDO,reg_Planilla.OCUPACION,reg_Planilla.COD_USR_REG,reg_Planilla.FEC_REG,reg_Planilla.COD_USR_ACTU,
                    reg_Planilla.FEC_ACTU,reg_Planilla.NUM_RIESGO
                    );
                        tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','FIN INSERT  RCEN_ASEG0004');
                        tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','*****************************************************************');
            END LOOP;
          END;

--          IF as_Tip_Movimiento='DE' OR as_Tip_Movimiento='IN' THEN
--            --BORRAMOS LA TRAMA DE TEMPORALES
--            DELETE FROM OIM.RCEN_ASEG0004_TEMP WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento;
--            DELETE FROM OIM.RCEN_ASEG0003_TEMP WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento;
--            DELETE FROM OIM.RCEN_ASEG0002_TEMP WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento;
--            DELETE FROM OIM.RCEN_ASEG0001_TEMP WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento;
--          END IF;
                        tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','FIN PROCEDIMIENTO');
          p_nRetorno := 1;
          p_cMensaje := 'OK';
  EXCEPTION
        WHEN EXCEPTION_MOVI THEN
        p_nRetorno := -1;
        p_cMensaje :='MOVMIENTO:'||p_cMensaje;
        ROLLBACK;
        WHEN EXCEPTION_ASEG THEN
        p_nRetorno := -1;
        p_cMensaje :='ASEGURADO:'||p_cMensaje;
        ROLLBACK;
        WHEN Nro_Movi_Vacio  THEN
        p_nRetorno := -1;
        p_cMensaje := 'ER:NUMERO DE MOVIMIENTO NO ENCONTRADO.' ;
        ROLLBACK;
        WHEN OTHERS THEN
        p_nRetorno := -1;
        p_cMensaje := 'ER:'||SQLERRM;
        ROLLBACK;
  END PGEAS004;
/*==============================================================================
PROPOSITO: Lista Riesgo
AUTOR: AALVARADO                                                 FECHA: 11/11/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
    - p_numero_recibo -> Numero de Movimiento
    - o_cursor -> Cursor de Retorno
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
   - Lista los datos de riesgo del recibo
==============================================================================*/
PROCEDURE PGEAS005 (
      p_numero_recibo in number,
      o_cursor OUT   t_cursor
   )
   IS
   ln_cod_cia NUMBER;
   ln_cod_ramo NUMBER;
   ln_num_poliza NUMBER;
   ln_num_spto NUMBER;
   ln_num_apli NUMBER;
   ln_num_spto_apli NUMBER;
   ln_existe NUMBER;
   ls_tip_emi_apli VARCHAR2(20);

   CURSOR c_tip_emi_apli IS
   SELECT OIM.oim_k_sctr.f_recupera_dv_apli(cod_cia,num_poliza,num_spto,num_apli,num_spto_apli,1,'TIP_EMI_APLI',to_number(substr(num_poliza,1,3)),'VAL')
   from a2990700@tron
   where num_recibo = p_numero_recibo;

   CURSOR cur_recibos IS
            SELECT 1
                   FROM OIM.RCEN_ASEG0003--auto_riesgos
             WHERE COD_CIA||COD_RAMO||NUM_POLIZA||NUM_SPTO||NUM_APLI||NUM_SPTO_APLI = (
                SELECT COD_CIA||SUBSTR(NUM_POLIZA,1,3)||NUM_POLIZA||NUM_SPTO||NUM_APLI||NUM_SPTO_APLI
                FROM A2990700@TRON
                WHERE NUM_RECIBO=p_numero_recibo
             );

   BEGIN
        OPEN cur_recibos;
        FETCH cur_recibos INTO ln_existe;

        IF cur_recibos%FOUND THEN
            SELECT COD_CIA,SUBSTR(NUM_POLIZA,1,3),NUM_POLIZA,NUM_SPTO,NUM_APLI,NUM_SPTO_APLI
            INTO ln_cod_cia,ln_cod_ramo,ln_num_poliza,ln_num_spto,ln_num_apli,ln_num_spto_apli
                FROM A2990700@TRON
                WHERE NUM_RECIBO=p_numero_recibo;

          OPEN o_cursor FOR
            SELECT riesgo nom_riesgo,
                   cant_trab cantidad_planilla,
                   impor_planilla importe_planilla,
                   tasa,
                   prima_neta prima
                   FROM OIM.RCEN_ASEG0003
             WHERE COD_CIA=ln_cod_cia
             AND COD_RAMO=ln_cod_ramo
             AND NUM_POLIZA=ln_num_poliza
             AND NUM_SPTO=ln_num_spto
             AND NUM_APLI=ln_num_apli
             AND NUM_SPTO_APLI = ln_num_spto_apli
             AND impor_planilla > 0;
        ELSE
           OPEN c_tip_emi_apli;
           FETCH c_tip_emi_apli INTO ls_tip_emi_apli;

           IF TRIM(ls_tip_emi_apli) = 'DEC' THEN
                OPEN o_cursor FOR
                     select c.nom_riesgo,
                       to_number (nvl(trim(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                      (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,r.num_spto_apli,
                         c.num_riesgo,1,'NUM_ASEGURADOS',to_number(substr(r.num_poliza,1,3)),'VAL')),'0')) cantidad_planilla,
                       nvl(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                        (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,case when r.num_spto_apli = 1 then 0 else r.num_spto_apli end,
                         c.num_riesgo,1,'IMP_PLANILLA',to_number(substr(r.num_poliza,1,3)),'VAL'),'0') importe_planilla,
                       to_number(nvl(trim (sf_recupera_dv@tron (r.cod_cia,r.num_poliza,r.num_spto,c.num_riesgo,1,
                                        'VAL_TASA_RIESGO',to_number(substr(r.num_poliza,1,3)),'VAL')
                                                     ) ,'0'),'999999999.0000' ) tasa,
                       to_number(nvl(trim(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                        (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,case when r.num_spto_apli = 1 then 0 else r.num_spto_apli end,
                         c.num_riesgo,1,'IMP_PLANILLA',to_number(substr(r.num_poliza,1,3)),'VAL')),'0'),'999999999.0000') *
                       to_number(nvl(trim (sf_recupera_dv@tron (r.cod_cia,r.num_poliza,r.num_spto,c.num_riesgo,1,
                                        'VAL_TASA_RIESGO',to_number(substr(r.num_poliza,1,3)),'VAL')
                                                     ) ,'0'),'999999999.0000' )/100 prima
                    from a2990700@tron r, a2000031@tron c
                    where num_recibo = p_numero_recibo
                     and r.cod_cia = c.cod_cia
                     and r.num_poliza = c.num_poliza
                     and r.num_spto = c.num_spto
                     and r.num_apli = c.num_apli
                     and r.num_spto_apli = c.num_spto_apli
                     order by c.num_riesgo;

           ELSE
                OPEN o_cursor FOR
                     SELECT c.nom_riesgo,
                       TO_NUMBER (NVL(TRIM(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                      (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,r.num_spto_apli,
                         c.num_riesgo,1,'NUM_ASEGURADOS_INCLU',TO_NUMBER(SUBSTR(r.num_poliza,1,3)),'VAL')),'0')) cantidad_planilla,
                       NVL(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                        (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,r.num_spto_apli,
                         c.num_riesgo,1,'IMP_PLANILLA_INCLU',TO_NUMBER(SUBSTR(r.num_poliza,1,3)),'VAL'),'0') importe_planilla,
                       TO_NUMBER(NVL(TRIM (sf_recupera_dv@tron (r.cod_cia,r.num_poliza,r.num_spto,c.num_riesgo,1,
                                        'VAL_TASA_RIESGO',TO_NUMBER(SUBSTR(r.num_poliza,1,3)),'VAL')
                                                     ) ,'0'),'999999999.0000' ) tasa,
                       TO_NUMBER(NVL(TRIM(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                        (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,r.num_spto_apli,
                         c.num_riesgo,1,'IMP_PLANILLA_INCLU',TO_NUMBER(SUBSTR(r.num_poliza,1,3)),'VAL')),'0'),'999999999.0000') *
                       TO_NUMBER(NVL(TRIM (sf_recupera_dv@tron (r.cod_cia,r.num_poliza,r.num_spto,c.num_riesgo,1,
                                        'VAL_TASA_RIESGO',TO_NUMBER(SUBSTR(r.num_poliza,1,3)),'VAL')
                                                     ) ,'0'),'999999999.0000' )/100 prima
                    FROM a2990700@tron r, a2000031@tron c
                    WHERE num_recibo = p_numero_recibo
                     AND r.cod_cia = c.cod_cia
                     AND r.num_poliza = c.num_poliza
                     AND r.num_spto = c.num_spto
                     AND r.num_apli = c.num_apli
                     AND r.num_spto_apli = c.num_spto_apli
                     ORDER BY c.num_riesgo;
            END IF;
        END IF;

   EXCEPTION
      WHEN OTHERS THEN
        NULL;
   END PGEAS005;
/*==============================================================================
PROPOSITO: Registra una Constancia
AUTOR: AALVARADO                                                 FECHA: 01/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
    - as_Num_Movimiento   -> Numero de Movimiento
    - as_Cod_Cia     -> Codigo de Compania
    - as_Num_Poliza   -> Numero de Poliza
    - as_Num_Spto   -> Numero de Suplemento
    - as_Num_Apli     -> Numero de Aplicacion
    - as_Num_Spto_Apli  -> Numero de Suplemento Aplicacion
    - as_Ubicacion  -> Ubicacion
    - as_Cod_Usuario  -> Codigo de Usuario
    - as_Cod_Sistema  -> Codigo de Sistema
    - p_nRetorno    -> Parametro de Retorno
    - p_cMensaje    -> Parametro de Retorno
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
   - Registra una constanacia en Tablas RCEN_ASEG0005 y RCEN_ASEG0006
==============================================================================*/
PROCEDURE PGEAS006 (as_Num_Movimiento   IN     VARCHAR2,                  --01
                    as_Cod_Cia          IN     VARCHAR2,                  --02
                    as_Num_Poliza       IN     VARCHAR2,                  --03
                    as_Num_Spto         IN     VARCHAR2,                  --04
                    as_Num_Apli         IN     VARCHAR2,                  --05
                    as_Num_Spto_Apli    IN     VARCHAR2,                  --06
                    as_Ubicacion        IN     VARCHAR2,                  --07
                    as_Cod_Usuario      IN     VARCHAR2,                  --08
                    as_Cod_Sistema      IN     VARCHAR2,                  --09
                    --Variables de Retorno
                    p_nRetorno             OUT NUMBER,                    --10
                    p_cMensaje             OUT VARCHAR                    --11
                                                      )
IS
   nSec                NUMBER;
   ln_Nro_Movimiento   NUMBER;
   Nro_Movi_Vacio      EXCEPTION;
   exits_001           number := 0;
   exits_002           number := 0;

BEGIN
   IF as_Num_Movimiento IS NULL
   THEN
      BEGIN
         SELECT NRO_MOVIMIENTO
           INTO ln_Nro_Movimiento
           FROM OIM.RCEN_ASEG0002_TEMP
          WHERE     COD_CIA = as_Cod_Cia
                AND COD_RAMO = SUBSTR (as_Num_Poliza, 1, 3)
                AND NUM_POLIZA = as_Num_Poliza
                AND NUM_SPTO = as_Num_Spto
                AND NUM_APLI = as_Num_Apli
                AND NUM_SPTO_APLI = as_Num_Spto_Apli
                AND COD_USR_REG = as_Cod_Usuario;
      EXCEPTION
         WHEN NO_DATA_FOUND
         THEN
            RAISE Nro_Movi_Vacio;
      END;
   ELSE
      ln_Nro_Movimiento := as_Num_Movimiento;
   END IF;

   SELECT sctr.seq_sctr_constancia_id_file.NEXTVAL INTO nSec FROM DUAL;

   INSERT INTO OIM.RCEN_ASEG0005 (NRO_DOCUMENTO,
                                  MCA_BAJA,
                                  NRO_MOVIMIENTO,
                                  UBICACION,
                                  COD_USR_REG,
                                  FEC_REG,
                                  PREFIJO,
                                  ANIO)
        VALUES (nSec,
                'N',
                ln_Nro_Movimiento,
                as_Ubicacion,
                as_Cod_Usuario,
                SYSDATE,
                'MP',
                TO_CHAR(SYSDATE,'YYYY'));

   INSERT INTO OIM.RCEN_ASEG0006 (NRO_DOCUMENTO,NRO_MOVIMIENTO,TIPDOC,NUMDOC,APEPAT,
                                  APEMAT,NOMBRES,NOMBRECOMPLETO,FECNAC,SUELDO,
                                  OCUPACION,NRO_MOVIMIENTO_REF,MCA_BAJA,COD_USR_REG,FEC_REG)
                                  SELECT nSec,NRO_MOVIMIENTO,TIPDOC,NUMDOC,APEPAT,
                                            APEMAT,NOMBRES,NOMBRECOMPLETO,FECNAC,SUELDO,
                                            OCUPACION,NRO_MOVIMIENTO_REG,'N',as_Cod_Usuario,SYSDATE
                                    FROM OIM.RCEN_ASEG0004_TEMP A
                                   WHERE A.NRO_MOVIMIENTO = ln_Nro_Movimiento;
       -- Si en caso no existe en la tabla 001
       select count(1) into exits_001
       from OIM.RCEN_ASEG0001
       where NRO_MOVIMIENTO = ln_Nro_Movimiento;

       -- Si en caso no existe en la tabla 002
       select count(1) into exits_002
       from OIM.RCEN_ASEG0002
       where NRO_MOVIMIENTO = ln_Nro_Movimiento;

       if exits_001 = 0 then
          INSERT INTO OIM.RCEN_ASEG0001
          (NRO_MOVIMIENTO,TIP_DOCUMENTO,NRO_DOCUMENTO,FEC_INI_VIG,FEC_FIN_VIG,
          TIPO_MOVIMIENTO,MCA_FACTURADO,MCA_BAJA,COD_USR_REG,FEC_REG,
          COD_USR_ACTU,FEC_ACTU)
          SELECT NRO_MOVIMIENTO,TIP_DOCUMENTO,NRO_DOCUMENTO,FEC_INI_VIG,FEC_FIN_VIG,
          'DO' TIPO_MOVIMIENTO,'N' MCA_FACTURADO,MCA_BAJA,COD_USR_REG,FEC_REG,
          COD_USR_ACTU,FEC_ACTU
          FROM OIM.RCEN_ASEG0001_TEMP WHERE NRO_MOVIMIENTO=ln_Nro_Movimiento;
       end if;

       if exits_002 = 0 then
          INSERT INTO OIM.RCEN_ASEG0002
          SELECT * FROM OIM.RCEN_ASEG0002_TEMP WHERE NRO_MOVIMIENTO=ln_Nro_Movimiento;
       end if;
       ---> FIN: FTELLO

   --BORRAMOS LA TRAMA DE TEMPORALES
   DELETE FROM OIM.RCEN_ASEG0004_TEMP
         WHERE NRO_MOVIMIENTO = ln_Nro_Movimiento;

   DELETE FROM OIM.RCEN_ASEG0003_TEMP
         WHERE NRO_MOVIMIENTO = ln_Nro_Movimiento;

   DELETE FROM OIM.RCEN_ASEG0002_TEMP
         WHERE NRO_MOVIMIENTO = ln_Nro_Movimiento;

   DELETE FROM OIM.RCEN_ASEG0001_TEMP
         WHERE NRO_MOVIMIENTO = ln_Nro_Movimiento;

   COMMIT;
   p_nRetorno := nSec;
   p_cMensaje := '';
EXCEPTION
   WHEN Nro_Movi_Vacio
   THEN
      p_nRetorno := -1;
      p_cMensaje := 'ER:NUMERO DE MOVIMIENTO NO ENCONTRADO.';
   WHEN OTHERS
   THEN
      p_nRetorno := -1;
      p_cMensaje := SQLERRM;
      ROLLBACK;
END PGEAS006;
/*==============================================================================
PROPOSITO: Recupera los datos de la Constancia
AUTOR: AALVARADO                                                 FECHA: 02/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
    - as_nro_constancia   -> Numero de Constancia
    - o_cursor     -> Cursor de Retorno
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
   - Trae los datos de una constancia
==============================================================================*/

PROCEDURE PGEAS007 (as_nro_constancia IN VARCHAR2, o_cursor OUT t_cursor)
IS
   existe_usu   NUMBER;
BEGIN
   --ls_id_file := to_number(substr(as_nro_constancia,9,length(as_nro_constancia)) );

   --VERFICA QUE USUARIO EXISTA EN LA TABLA DE USUARIOS MAPFRE
   SELECT COUNT (1)
     INTO existe_usu
     FROM OIM.RCEN_ASEG0005 A
    WHERE A.NRO_DOCUMENTO = as_nro_constancia
          AND EXISTS
                 (SELECT 1
                    FROM OIM.OIM00001 B
                   WHERE B.COD_USR = A.COD_USR_REG);

   OPEN o_cursor FOR
      SELECT A.NRO_DOCUMENTO ID_CONSTANCIA,
             B.NUM_POLIZA POLPEN,
             f_conviertecadena (
                f_nom_contratante (
                   (CASE WHEN C.COD_RAMO = '702' THEN 3 ELSE 2 END),
                   'RUC',
                   D.NRO_DOCUMENTO))
                NOMBRE,
             (CASE
                 WHEN D.FEC_INI_VIG IS NOT NULL
                 THEN
                    TO_CHAR (D.FEC_INI_VIG, 'dd/mm/yyyy')
                 ELSE
                    (SELECT TO_CHAR (X.FEC_EFEC_SPTO, 'dd/mm/yyyy')
                       FROM A2000030@TRON X
                      WHERE X.NUM_POLIZA =
                               (CASE
                                   WHEN B.NUM_POLIZA <> '0' THEN B.NUM_POLIZA
                                   ELSE C.NUM_POLIZA
                                END)
                            AND X.NUM_SPTO = B.NUM_SPTO
                            AND X.NUM_APLI = B.NUM_APLI
                            AND X.NUM_SPTO_APLI = B.NUM_SPTO_APLI)
              END)
                FECINI,
             (CASE
                 WHEN D.FEC_FIN_VIG IS NOT NULL
                 THEN
                    TO_CHAR (D.FEC_FIN_VIG, 'dd/mm/yyyy')
                 ELSE
                    (SELECT TO_CHAR (X.FEC_VCTO_SPTO, 'dd/mm/yyyy')
                       FROM A2000030@TRON X
                      WHERE X.NUM_POLIZA =
                               (CASE
                                   WHEN B.NUM_POLIZA <> '0' THEN B.NUM_POLIZA
                                   ELSE C.NUM_POLIZA
                                END)
                            AND X.NUM_SPTO = B.NUM_SPTO
                            AND X.NUM_APLI = B.NUM_APLI
                            AND X.NUM_SPTO_APLI = B.NUM_SPTO_APLI)
              END)
                FECHAS,
             C.NUM_POLIZA POLSAL,
             E.NUM_POLIZA POLVL,
             A.UBICACION,
             DECODE(E.COD_RAMO,610,'URT-VLEY-RC-','MP/') || TO_CHAR (A.FEC_REG, 'YYYY') || '/' || A.NRO_DOCUMENTO
                NUMERO,
             TO_CHAR (A.FEC_ACTU,'dd/mm/yyyy') FEC_MOV,
             (CASE
                 WHEN existe_usu > 0
                 THEN
                    (SELECT    TRIM (X.APE_PAT_USR || ' ' || X.APE_MAT_USR)
                            || ', '
                            || X.NOM_USR
                       FROM OIM.OIM00001 X
                      WHERE X.COD_USR = A.COD_USR_REG)
                 ELSE
                    (SELECT    X.APE_PATERNO
                            || ' '
                            || X.APE_MATERNO
                            || ', '
                            || X.PRIMER_NOMBRE
                            || ' '
                            || X.SEGUNDO_NOMBRE
                       FROM OIM.OIM00022 X
                      WHERE X.NRO_DOC = A.COD_USR_REG)
              END)
                NOMBRE_USUARIO
        FROM OIM.RCEN_ASEG0005 A
             --UNION TABLA POLIZA PENSION
             LEFT JOIN OIM.RCEN_ASEG0002 B
                ON     B.NRO_MOVIMIENTO = A.NRO_MOVIMIENTO
                   AND B.COD_CIA = 2
                   AND B.COD_RAMO = 701
             --UNION TABLA POLIZA SALUD
             LEFT JOIN OIM.RCEN_ASEG0002 C
                ON     C.NRO_MOVIMIENTO = A.NRO_MOVIMIENTO
                   AND C.COD_CIA = 3
                   AND C.COD_RAMO = 702
             --UNION TABLA POLIZA VIDA LEY
             LEFT JOIN OIM.RCEN_ASEG0002 E
                ON     E.NRO_MOVIMIENTO = A.NRO_MOVIMIENTO
                   AND E.COD_CIA = 2
                   AND E.COD_RAMO = 610
             --UNION TABLA MOVIMIENTO
             INNER JOIN OIM.RCEN_ASEG0001 D
                ON D.NRO_MOVIMIENTO = A.NRO_MOVIMIENTO
       WHERE A.NRO_DOCUMENTO = as_nro_constancia AND A.MCA_BAJA = 'N';
END PGEAS007;
/*==============================================================================
PROPOSITO: Recupera los datos de los trabajadores de la Constancia
AUTOR: AALVARADO                                                 FECHA: 02/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
    - as_nro_constancia   -> Numero de Constancia
    - o_cursor     -> Cursor de Retorno
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
   - Recupera los datos de los Trabajadores de la Constacia
==============================================================================*/
PROCEDURE PGEAS008 (as_nro_constancia IN VARCHAR2, o_cursor OUT t_cursor)
IS
--ls_id_file NUMBER;
BEGIN
   --ls_id_file := TO_NUMBER(SUBSTR(as_nro_constancia,9,LENGTH(as_nro_constancia)));
   OPEN o_cursor FOR
        SELECT A.APEPAT,
               A.APEMAT,
               A.NOMBRES,
               DECODE (
                  A.APEPAT,
                  NULL, A.NOMBRECOMPLETO,
                     A.APEPAT
                  || ' '
                  || A.APEMAT
                  || ', '
                  || A.NOMBRES)
                  NOMBRE_COMPLETO,
               A.TIPDOC TIP_DOC,
               A.NUMDOC NUM_DOC,
               A.FECNAC FECNAC,
               A.SUELDO SUELDO,
               A.OCUPACION
          FROM    OIM.RCEN_ASEG0006 A
         WHERE A.NRO_DOCUMENTO = as_nro_constancia AND A.MCA_BAJA='N'
      ORDER BY NOMBRE_COMPLETO ASC;
EXCEPTION
   WHEN OTHERS
   THEN
      NULL;
END PGEAS008;
/*==============================================================================
PROPOSITO: Inserta Movimiento
AUTOR: AALVARADO                                                 FECHA: 02/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
    - as_NRO_DOCUMENTO   -> Numero de Documento
    - as_TIPO_DOCUMENTO  -> Tipo Documento
    - as_CODIGO_USUARIO  -> Codigo de Usuario
    - an_NUM_MOVIMIENTO  -> Codigo de Movimiento GEST_ASEG
    - an_Retorno    -> Retorno
    - as_Mensaje    -> Mensaje de Retorno
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
   - Inserta Movimiento en la Tabla RCEN_MOVIMIENTOS
==============================================================================*/

PROCEDURE INSERTAR_MOVIMIENTO_OIM (as_NRO_DOCUMENTO    IN     VARCHAR2,
                                   as_TIPO_DOCUMENTO   IN     VARCHAR2,
                                   as_CODIGO_USUARIO   IN     VARCHAR2,
                                   an_NUM_MOVIMIENTO   IN     NUMBER,
                                   as_ocupacion        in varchar2,
                                   an_Retorno             OUT NUMBER,
                                   as_Mensaje             OUT VARCHAR2)
IS
   nDocumento_Movs   NUMBER := 0;
   cDoc_Movs_Sal     VARCHAR (20);
   cDoc_Movs_Pen     VARCHAR (20);
   nCodMovs          NUMBER;
   NOM_COMPLETO      VARCHAR2 (200 BYTE);
   nCodAseg          NUMBER;
   cRUC              VARCHAR2 (11);
BEGIN

   -- Buscamos el codigo de asegurado porque ya existe
   SELECT COD_ASEG
     INTO nCodAseg
     FROM OIM.RCEN_ASEGURADOS
    WHERE     NRO_DOCUMENTO = as_NRO_DOCUMENTO
          AND TIPO_DOC = as_TIPO_DOCUMENTO
          AND ESTADO = 'A';

   -- Se Optiene un numero correlativo de movimiento
   SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

   -- Para insertar un movimiento en la tabla centralizada de movimeintos.
   INSERT INTO OIM.RCEN_MOVIMIENTOS (COD_ASEG,
                                           COD_MOVIM,
                                           TIP_DOCUM,
                                           COD_DOCUM,
                                           COD_CIA,
                                           COD_RAMO,
                                           NUM_POLIZA,
                                           NUM_SPTO,
                                           NUM_APLI,
                                           NUM_SPTO_APLI,
                                           FEC_INI_VIG,
                                           FEC_FIN_VIG,
                                           SIST_ORIG,
                                           FEC_ALTA,
                                           COD_USUARIO,
                                           FEC_CREACION,
                                           OCUP_ASEG,
                                           COD_MOVIM_SC)
                                           SELECT nCodAseg COD_ASEG,
                                           nCodMovs COD_MOVIM,
                                           (select b.TIP_DOCUMENTO from OIM.RCEN_ASEG0001 b where b.NRO_MOVIMIENTO= an_num_movimiento) TIP_DOCUM,
                                           (select b.NRO_DOCUMENTO from OIM.RCEN_ASEG0001 b where b.NRO_MOVIMIENTO= an_num_movimiento) COD_DOCUM,
                                           cod_cia,
                                           cod_ramo,
                                           num_poliza,
                                           num_spto,
                                           num_apli,
                                           num_spto_apli,
                                           (select b.FEC_INI_VIG from OIM.RCEN_ASEG0001 b where b.NRO_MOVIMIENTO= an_num_movimiento)  FEC_INI_VIG,
                                           (select b.FEC_FIN_VIG from OIM.RCEN_ASEG0001 b where b.NRO_MOVIMIENTO= an_num_movimiento)  FEC_FIN_VIG,
                                           'GESTASEG' SIST_ORIG,
                                           sysdate FEC_ALTA,
                                            as_CODIGO_USUARIO COD_USUARIO,
                                           sysdate FEC_CREACION,
                                           as_ocupacion OCUP_ASEG,
                                           an_num_movimiento COD_MOVIM_SC
                                           FROM OIM.RCEN_ASEG0002 WHERE NRO_MOVIMIENTO = an_num_movimiento;


    /*
      SELECT C.NUM_POLIZA POLSAL, B.NUM_POLIZA POLPEN, NRO_DOCUMENTO RUC
        INTO cDoc_Movs_Sal, cDoc_Movs_Pen, cRUC
        --TABLA MOVIMIENTO
        FROM OIM.RCEN_ASEG0001 A
             --UNION TABLA POLIZA PENSION
             LEFT JOIN OIM.RCEN_ASEG0002 B
                ON     B.NRO_MOVIMIENTO = A.NRO_MOVIMIENTO
                   AND B.COD_CIA = 2
                   AND B.COD_RAMO = 701
             --UNION TABLA POLIZA SALUD
             LEFT JOIN OIM.RCEN_ASEG0002 C
                ON     C.NRO_MOVIMIENTO = A.NRO_MOVIMIENTO
                   AND C.COD_CIA = 3
                   AND C.COD_RAMO = 702
       WHERE A.NRO_MOVIMIENTO = an_NUM_MOVIMIENTO;

      IF cDoc_Movs_Sal IS NULL
      THEN
         cDoc_Movs_Sal := '0';
      END IF;

      IF cDoc_Movs_Pen IS NULL
      THEN
         cDoc_Movs_Pen := '0';
      END IF;
   EXCEPTION
      WHEN NO_DATA_FOUND
      THEN
         cDoc_Movs_Sal := '0';
         cDoc_Movs_Pen := '0';
   END;

   -- Si tiene poliza de SALUD verficamos si esta en la tabla de movimientos
   IF SUBSTR (cDoc_Movs_Sal, 0, 3) = '702'
   THEN
      BEGIN
         SELECT 1
           INTO nDocumento_Movs
           FROM DUAL
          WHERE EXISTS
                   (SELECT 1
                      FROM OIM.RCEN_ASEG0001 A,
                           OIM.RCEN_ASEG0002 B,
                           OIM.RCEN_MOVIMIENTOS C
                     WHERE C.NUM_POLIZA = B.NUM_POLIZA
                           AND C.NUM_SPTO = B.NUM_SPTO_APLI
                           AND C.NUM_APLI =
                                  DECODE (B.NUM_APLI, 0, 1, B.NUM_APLI)
                           AND A.NRO_DOCUMENTO = cRUC
                           AND C.COD_ASEG = nCodAseg
                           AND A.NRO_MOVIMIENTO = an_NUM_MOVIMIENTO
                           AND B.COD_CIA = 3
                           AND B.COD_RAMO = 702);
      EXCEPTION
         WHEN NO_DATA_FOUND
         THEN
            nDocumento_Movs := 0;
      END;

      -- Si no esta en la tabla movimientos insertamos la poliza de salud
      IF nDocumento_Movs = 0
      THEN
         SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

         INSERT INTO OIM.RCEN_MOVIMIENTOS (COD_ASEG,
                                           COD_MOVIM,
                                           TIP_DOCUM,
                                           COD_DOCUM,
                                           COD_CIA,
                                           COD_RAMO,
                                           NUM_POLIZA,
                                           NUM_SPTO,
                                           NUM_APLI,
                                           NUM_SPTO_APLI,
                                           FEC_INI_VIG,
                                           FEC_FIN_VIG,
                                           SIST_ORIG,
                                           FEC_ALTA,
                                           COD_USUARIO,
                                           FEC_CREACION,
                                           OCUP_ASEG)
            SELECT nCodAseg, nCodMovs, t.*
              FROM (SELECT 'RUC',
                           A.NRO_DOCUMENTO,
                           b.COD_CIA,
                           SUBSTR (B.NUM_POLIZA, 0, 3),
                           B.NUM_POLIZA,
                           b.NUM_SPTO,
                           DECODE (b.NUM_APLI, 0, 1, b.NUM_APLI),
                           DECODE (b.NUM_SPTO_APLI, 0, 1, b.NUM_SPTO_APLI),
                           TO_DATE (A.fec_ini_vig, 'DD/MM/YYYY'),
                           TO_DATE (A.fec_fin_vig, 'DD/MM/YYYY'),
                           'OIM',
                           SYSDATE a,
                           NVL (as_CODIGO_USUARIO, USER),
                           SYSDATE,
                           ''
                      FROM    OIM.RCEN_ASEG0001 A
                           INNER JOIN
                              OIM.RCEN_ASEG0002 B
                           ON A.NRO_MOVIMIENTO = B.NRO_MOVIMIENTO
                     WHERE     A.NRO_MOVIMIENTO = an_NUM_MOVIMIENTO
                           AND B.COD_CIA = 3
                           AND B.COD_RAMO = 702
                           AND A.NRO_DOCUMENTO = cRUC) T;
      END IF;
   END IF;

   -- Si tiene poliza de PENSION verficamos si esta en la tabla de movimientos
   IF SUBSTR (cDoc_Movs_Pen, 0, 3) = '701'
   THEN
      BEGIN
         SELECT 1
           INTO nDocumento_Movs
           FROM DUAL
          WHERE EXISTS
                   (SELECT 1
                      FROM OIM.RCEN_ASEG0001 A,
                           OIM.RCEN_ASEG0002 B,
                           OIM.RCEN_MOVIMIENTOS C
                     WHERE C.NUM_POLIZA = B.NUM_POLIZA
                           AND C.NUM_SPTO = B.NUM_SPTO
                           AND C.NUM_APLI =
                                  DECODE (B.NUM_APLI, 0, 1, B.NUM_APLI)
                           AND A.NRO_DOCUMENTO = cRUC
                           AND C.COD_ASEG = nCodAseg
                           AND A.NRO_MOVIMIENTO = an_NUM_MOVIMIENTO
                           AND B.COD_CIA = 2
                           AND B.COD_RAMO = 701);
      EXCEPTION
         WHEN NO_DATA_FOUND
         THEN
            nDocumento_Movs := 0;
      END;

      -- Si no esta en la tabla movimientos insertamos la poliza de pension
      IF nDocumento_Movs = 0
      THEN
         SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

         INSERT INTO OIM.RCEN_MOVIMIENTOS (COD_ASEG,
                                           COD_MOVIM,
                                           TIP_DOCUM,
                                           COD_DOCUM,
                                           COD_CIA,
                                           COD_RAMO,
                                           NUM_POLIZA,
                                           NUM_SPTO,
                                           NUM_APLI,
                                           NUM_SPTO_APLI,
                                           FEC_INI_VIG,
                                           FEC_FIN_VIG,
                                           SIST_ORIG,
                                           FEC_ALTA,
                                           COD_USUARIO,
                                           FEC_CREACION,
                                           OCUP_ASEG)
            SELECT nCodAseg, nCodMovs, t.*
              FROM (SELECT 'RUC',
                           A.NRO_DOCUMENTO,
                           B.COD_CIA,
                           SUBSTR (B.NUM_POLIZA, 0, 3),
                           B.NUM_POLIZA,
                           B.NUM_SPTO,
                           DECODE (B.NUM_APLI, 0, 1, B.NUM_APLI),
                           DECODE (B.NUM_SPTO_APLI, 0, 1, B.NUM_SPTO_APLI),
                           --p.fec_efec_spto, p.fec_vcto_spto,
                           TO_DATE (A.FEC_INI_VIG, 'DD/MM/YYYY'),
                           TO_DATE (A.FEC_FIN_VIG, 'DD/MM/YYYY'),
                           'OIM',
                           SYSDATE a,
                           NVL (as_CODIGO_USUARIO, USER),
                           SYSDATE,
                           ''
                      FROM    OIM.RCEN_ASEG0001 A
                           INNER JOIN
                              OIM.RCEN_ASEG0002 B
                           ON A.NRO_MOVIMIENTO = B.NRO_MOVIMIENTO
                     WHERE     A.NRO_MOVIMIENTO = an_NUM_MOVIMIENTO
                           AND B.COD_CIA = 3
                           AND B.COD_RAMO = 702
                           AND A.NRO_DOCUMENTO = cRUC) T;
      END IF;
   END IF;
   */
   an_Retorno := 1;
EXCEPTION
   WHEN OTHERS
   THEN
      an_Retorno := -1;
      as_Mensaje := SQLERRM;
END INSERTAR_MOVIMIENTO_OIM;

/*==============================================================================
PROPOSITO: Obtiene Datos del Ceriticado
AUTOR: AALVARADO                                                 FECHA: 01/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
    - as_Num_Movimiento   -> Numero de Movimiento
    - as_Cod_Cia     -> Codigo de Compania
    - as_Num_Poliza   -> Numero de Poliza
    - as_Num_Spto   -> Numero de Suplemento
    - as_Num_Apli     -> Numero de Aplicacion
    - as_Num_Spto_Apli  -> Numero de Suplemento Aplicacion
    - as_Cod_Usuario  -> Codigo de Usuario
    - as_Cod_Sistema  -> Codigo de Sistema
    - as_Tip_Certificado  -> Tipo Certificado
    - o_cursor          -> Cursor de Salida
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
   - Obtiene Datos del Certificado, Carta, Cargo.
==============================================================================*/
PROCEDURE PGEAS009 (
    as_Num_Movimiento   IN     VARCHAR2,--01
    as_Cod_Cia          IN     VARCHAR2,--02
    as_Num_Poliza       IN     VARCHAR2,--03
    as_Num_Spto         IN     VARCHAR2,--04
    as_Num_Apli         IN     VARCHAR2,--05
    as_Num_Spto_Apli    IN     VARCHAR2,--06
    as_Cod_Usuario      IN     VARCHAR2,--07
    as_Cod_Sistema      IN     VARCHAR2,--08
    --as_Tip_Certificado      IN VARCHAR2,--09
    --Variables de Retorno
    o_cursor OUT t_cursor--10
)
IS
    vl_Nro_Movimiento NUMBER;
BEGIN
    IF as_Num_Movimiento IS NULL THEN
    SELECT NRO_MOVIMIENTO INTO vl_Nro_Movimiento
        FROM OIM.RCEN_ASEG0002_TEMP
        WHERE COD_CIA=as_Cod_Cia
        AND NUM_POLIZA=as_Num_Poliza
        AND NUM_SPTO=as_Num_Spto
        AND NUM_APLI=as_Num_Apli
        AND NUM_SPTO_APLI=as_Num_Spto_Apli
        AND COD_USR_REG=as_Cod_Usuario
        AND COD_SISTEMA=as_Cod_Sistema;
    ELSE
        vl_Nro_Movimiento:=as_Num_Movimiento;
    END IF;
    /*
    SELECT
    */
    OPEN o_cursor FOR
        SELECT A.NUM_POLIZA,
        A.NUM_SPTO,
        A.NUM_APLI,
        A.NUM_SPTO_APLI,
        TO_CHAR(B.FEC_EMISION,'DD/MM/YYYY') FEC_EMISION,
        TO_CHAR(B.FEC_EFEC_SPTO,'DD/MM/YYYY') FEC_INI_VIG,
        TO_CHAR(B.FEC_VCTO_SPTO,'DD/MM/YYYY') FEC_FIN_VIG,
        TRON2000.SF_RECUPERA_NOMBRE@TRON(B.COD_CIA, B.TIP_DOCUM, B.COD_DOCUM) CONTRATANTE,
        TO_CHAR(SYSDATE,'DD/MM/YYYY')FEC_TRANSFERENCIA,
         B.TIP_DOCUM  TIP_DOCUM_CONT,
        B.COD_DOCUM COD_DOCUM_CONT,
        (
        SELECT NVL(X.NOM_DOMICILIO1||' '||X.NOM_DOMICILIO2,'')
         FROM A1001331@TRON X WHERE X.TIP_DOCUM =B.TIP_DOCUM AND X.COD_DOCUM = B.COD_DOCUM AND X.COD_CIA=B.COD_CIA AND ROWNUM=1
        ) DIRECCION_CONT,
         (
        SELECT NVL(X.TLF_NUMERO,'')
         FROM A1001331@TRON X WHERE X.TIP_DOCUM =B.TIP_DOCUM AND X.COD_DOCUM = B.COD_DOCUM AND X.COD_CIA=B.COD_CIA AND ROWNUM=1
        ) TELEFONO_CONT,
        DECODE(C.COD_CIA,1,'MAPFRE PERU COMPA¿IA DE SEGUROS Y REASEGUROS',2,'MAPFRE PERU VIDA COMPA¿IA DE SEGUROS',3,'MAPFRE PERU S.A. EPS')NOM_RAZON_SOCIAL_CIA,
        C.NOM_RAZON_SOCIAL NOM_RAZON_SOCIAL_CIA_2,C.TIP_DOCUM_CIA,C.COD_DOCUM_CIA,'Av. 28 de Julio N¿. 873, Miraflores, Lima, Per¿' DIRECCION_CIA,TLF_NUMERO TLF_NUMERO_CIA,FAX_NUMERO FAX_NUMERO_CIA
        FROM OIM.RCEN_ASEG0002 A
        INNER JOIN TRON2000.A2000030@TRON B ON B.COD_CIA=A.COD_CIA
        INNER JOIN TRON2000.a1000900@TRON C ON C.COD_CIA=A.COD_CIA
        AND B.NUM_POLIZA=A.NUM_POLIZA
        AND B.NUM_SPTO=A.NUM_SPTO
        AND B.NUM_APLI=A.NUM_APLI
        AND B.NUM_SPTO_APLI=A.NUM_SPTO_APLI
        WHERE NRO_MOVIMIENTO=vl_Nro_Movimiento;
END PGEAS009;
/*==============================================================================
PROPOSITO: Recupera los datos de los trabajadores de la Constancia
AUTOR: AALVARADO                                                 FECHA: 02/12/2014
------------------------------------------------------------------------------
DATOS RELEVANTES
    - as_nro_constancia   -> Numero de Constancia
    - o_cursor     -> Cursor de Retorno
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
   - Recupera los datos de los Trabajadores de la Constacia
==============================================================================*/
PROCEDURE PGEAS010 (
    as_nro_movi IN VARCHAR2,
    o_cursor OUT t_cursor
)
IS
BEGIN
   OPEN o_cursor FOR
        SELECT DECODE (
                  B.APE_PATERNO,
                  NULL, B.NOMBRE_COMPLETO,
                     B.APE_PATERNO
                  || ' '
                  || B.APE_MATERNO
                  || ', '
                  || B.PRIMER_NOMBRE
                  || ' '
                  || B.SEGUNDO_NOMBRE)
                  NOMBRE_COMPLETO,
               B.TIPO_DOC TIP_DOC,
               B.NRO_DOCUMENTO NUM_DOC,
               TO_CHAR(B.FEC_NAC,'DD/MM/YYYY') FECNAC,
               A.SUELDO SUELDO,
               A.OCUPACION
          FROM    OIM.RCEN_ASEG0004 A
               INNER JOIN
                  OIM.RCEN_ASEGURADOS B
               ON A.COD_ASEG = B.COD_ASEG
         WHERE A.NRO_MOVIMIENTO = as_nro_movi
      ORDER BY NOMBRE_COMPLETO ASC;
EXCEPTION
   WHEN OTHERS
   THEN
      NULL;
END PGEAS010;

/*==============================================================================
PROPOSITO: Recupera los datos de los trabajadores de la Constancia
AUTOR: FTELLO                                                 FECHA: 23/01/2015
------------------------------------------------------------------------------
DATOS RELEVANTES
  - as_Num_Movimiento   -> Numero de Movimiento
  - as_Cod_Cia   --> Cod_cia
  - as_Num_Poliza  --> Numero de Poliza
  - as_Num_Spto --> Numero de Suplemento
  - as_Num_Apli ---> Numero de Aplicacion
  - as_Num_Spto_Apli  ---> Numero de Suplemento de Aplicacion
  - as_Tip_Movimiento  ---> Tipo de Movimiento
  - as_Cod_Usuario  ---> Codigo de Usuario
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
   - Recupera los datos de los Trabajadores de la Constacia
==============================================================================*/
PROCEDURE PGEAS011 (
    as_Num_Movimiento IN VARCHAR2,--01
    as_Cod_Cia  IN VARCHAR2,--02
    as_Num_Poliza   IN VARCHAR2,--03
    as_Num_Spto IN VARCHAR2,--04
    as_Num_Apli IN VARCHAR2,--05
    as_Num_Spto_Apli    IN VARCHAR2,--06
    as_Tip_Movimiento   IN VARCHAR2,--07
    as_Cod_Usuario  IN VARCHAR2
)
IS
vn_existe_recibo number;
vn_existe number := 0;
l_numero_recibo number;
BEGIN
tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','PGEAS011 inicio');
        select num_recibo into  l_numero_recibo
        from a2990700@tron
        where cod_cia = as_Cod_Cia
        and num_poliza = as_Num_Poliza
        and num_spto = as_Num_Spto
        and num_apli = as_Num_Apli
        and num_spto_apli= as_Num_Spto_Apli
        and rownum = 1;
tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','PGEAS011 l_numero_recibo:'||l_numero_recibo);
     ---> Si no existe el numero de recibo en la tabla RCEN_ASEG0002_TEMP
     BEGIN
         SELECT NVL(NUM_RECIBO,0) INTO vn_existe_recibo
         FROM OIM.RCEN_ASEG0002_TEMP
        WHERE NRO_MOVIMIENTO=as_Num_Movimiento;
       EXCEPTION
       WHEN OTHERS
       THEN
          vn_existe_recibo:= 0;
     end;
tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','PGEAS011 vn_existe_recibo:'||vn_existe_recibo);
     IF vn_existe_recibo = 0 then
        UPDATE OIM.RCEN_ASEG0002_TEMP set  num_recibo = l_numero_recibo
        WHERE NRO_MOVIMIENTO=as_Num_Movimiento;
     END IF;

tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','PGEAS011 vn_existe:'||vn_existe);

     ---> Si no existe registros en la tabla de Riesgos los actualizamos RCEN_ASEG0003_TEMP---
    SELECT COUNT(1) INTO vn_existe
     FROM OIM.RCEN_ASEG0003_TEMP
    WHERE NRO_MOVIMIENTO=as_Num_Movimiento;

     IF vn_existe  = 0 then

                if (as_Tip_Movimiento = 'DE') then ----------------------------En el caso de Declaraciones ----------------------

                       tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','PGEAS011 as_Tip_Movimiento:'||as_Tip_Movimiento);
                       tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','PGEAS011 as_Num_Movimiento:'||as_Num_Movimiento);
                       tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','PGEAS011 as_Num_Movimiento:'||as_Num_Movimiento);
                       INSERT INTO oim.RCEN_ASEG0003_TEMP(NRO_MOVIMIENTO,COD_CIA,COD_RAMO,NUM_RIESGO,RIESGO,CANT_TRAB,
                       IMPOR_PLANILLA ,TASA,PRIMA_NETA,COD_USR_REG,FEC_REG,NUM_POLIZA,NUM_SPTO,NUM_APLI,NUM_SPTO_APLI)
                       SELECT
                       as_Num_Movimiento,
                       r.cod_cia,
                       substr(r.num_poliza,1,3),
                       c.num_riesgo,
                       c.nom_riesgo,
                       to_number (nvl(trim(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                      (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,r.num_spto_apli,
                         c.num_riesgo,1,'NUM_ASEGURADOS',to_number(substr(r.num_poliza,1,3)),'VAL')),'0')) cantidad_planilla,
                       nvl(TRIM(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                        (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,case when r.num_spto_apli = 1 then 0 else r.num_spto_apli end,
                         c.num_riesgo,1,'IMP_PLANILLA',to_number(substr(r.num_poliza,1,3)),'VAL')),'0') importe_planilla,
                       to_number(nvl(trim (sf_recupera_dv@tron (r.cod_cia,r.num_poliza,r.num_spto,c.num_riesgo,1,
                                        'VAL_TASA_RIESGO',to_number(substr(r.num_poliza,1,3)),'VAL')
                                                     ) ,'0'),'999999999.0000' ) tasa,
                       to_number(nvl(trim(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                        (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,case when r.num_spto_apli = 1 then 0 else r.num_spto_apli end,
                         c.num_riesgo,1,'IMP_PLANILLA',to_number(substr(r.num_poliza,1,3)),'VAL')),'0'),'999999999.0000') *
                       to_number(nvl(trim (sf_recupera_dv@tron (r.cod_cia,r.num_poliza,r.num_spto,c.num_riesgo,1,
                                        'VAL_TASA_RIESGO',to_number(substr(r.num_poliza,1,3)),'VAL')
                                                     ) ,'0'),'999999999.0000' )/100 prima,
                       as_Cod_Usuario,
                       sysdate,
                       r.num_poliza,
                       r.num_spto,
                       r.num_apli,
                       r.num_spto_apli
                    from a2990700@tron r, a2000031@tron c
                    where num_recibo = l_numero_recibo
                     and r.cod_cia = c.cod_cia
                     and r.num_poliza = c.num_poliza
                     and r.num_spto = c.num_spto
                     and r.num_apli = c.num_apli
                     and r.num_spto_apli = c.num_spto_apli
                     order by c.num_riesgo;
                       tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','PGEAS011 fin insert RCEN_ASEG0003_TEMP');

                elsif (as_Tip_Movimiento = 'IN') Then ---------------------- En el caso de Inclusiones ----------------------------

                    tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','PGEAS011 fin insert inclusion as_Tip_Movimiento:'||as_Tip_Movimiento);
                    INSERT INTO oim.RCEN_ASEG0003_TEMP(NRO_MOVIMIENTO,COD_CIA,COD_RAMO,NUM_RIESGO,RIESGO,CANT_TRAB,
                       IMPOR_PLANILLA ,TASA,PRIMA_NETA,COD_USR_REG,FEC_REG,NUM_POLIZA,NUM_SPTO,NUM_APLI,NUM_SPTO_APLI)
                  select
                        as_Num_Movimiento,
                       r.cod_cia,
                       substr(r.num_poliza,1,3),
                       c.num_riesgo,
                        c.nom_riesgo,
                       to_number (nvl(trim(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                      (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,r.num_spto_apli,
                         c.num_riesgo,1,'NUM_ASEGURADOS_INCLU',to_number(substr(r.num_poliza,1,3)),'VAL')),'0')) cantidad_planilla,
                       nvl(trim(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                        (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,r.num_spto_apli,
                         c.num_riesgo,1,'IMP_PLANILLA_INCLU',to_number(substr(r.num_poliza,1,3)),'VAL')),'0') importe_planilla,
                       to_number(nvl(trim (sf_recupera_dv@tron (r.cod_cia,r.num_poliza,r.num_spto,c.num_riesgo,1,
                                        'VAL_TASA_RIESGO',to_number(substr(r.num_poliza,1,3)),'VAL')
                                                     ) ,'0'),'999999999.0000' ) tasa,
                       to_number(nvl(trim(tron2000.sf_recupera_dv_spto_apli_mpe@tron
                        (r.cod_cia,r.num_poliza,r.num_spto,r.num_apli,r.num_spto_apli,
                         c.num_riesgo,1,'IMP_PLANILLA_INCLU',to_number(substr(r.num_poliza,1,3)),'VAL')),'0'),'999999999.0000') *
                       to_number(nvl(trim (sf_recupera_dv@tron (r.cod_cia,r.num_poliza,r.num_spto,c.num_riesgo,1,
                                        'VAL_TASA_RIESGO',to_number(substr(r.num_poliza,1,3)),'VAL')
                                                     ) ,'0'),'999999999.0000' )/100 prima,
                       as_Cod_Usuario,
                       sysdate,
                       r.num_poliza,
                       r.num_spto,
                       r.num_apli,
                       r.num_spto_apli
                    from a2990700@tron r, a2000031@tron c
                    where

                     num_recibo = l_numero_recibo
                     and r.cod_cia = c.cod_cia
                     and r.num_poliza = c.num_poliza
                     and r.num_spto = c.num_spto
                     and r.num_apli = c.num_apli
                     and r.num_spto_apli = c.num_spto_apli
                     order by c.num_riesgo;

                     tron2000.mpe_p_traza4@tron('aalvarado_gest_aseg','a','PGEAS011 fin insert inclusion RCEN_ASEG0003_TEMP');
                end if;
     END IF;


END PGEAS011;
/*==============================================================================
PROPOSITO: Recupera los datos del recibo
AUTOR: AALVARADO                                                 FECHA: 01/02/2015
------------------------------------------------------------------------------
DATOS RELEVANTES
   - p_numero_recibo   -> Numero de Recibo
   - o_cursor  ---> Cursor de Resultados
------------------------------------------------------------------------------
DESCRIPCION FUNCIONAL
   - Recupera los datos del RECIBO
==============================================================================*/
procedure PGEAS012(
        p_numero_recibo IN  NUMBER,
        o_cursor OUT t_cursor)
   is
   ln_cia       number;
   ls_poliza    varchar2(20);
   ln_spto      number;
   ln_apli      number;
   ln_sptoapli  number;

   ls_docum     varchar2(20);
   ld_fechaefec date;
   ld_fechavcto date;

   begin

        select cod_cia, num_poliza, num_spto, num_apli, num_spto_apli
            into ln_cia, ls_poliza, ln_spto, ln_apli, ln_sptoapli
              from a2990700@tron
              where num_recibo = p_numero_recibo;

        select cod_docum, fec_efec_spto, fec_vcto_spto
            into ls_docum, ld_fechaefec, ld_fechavcto
              from a2000030@tron
              where cod_cia = ln_cia
                and num_poliza = ls_poliza
                and num_spto = ln_spto
                and num_apli = ln_apli
                and num_spto_apli = ln_sptoapli;

        open o_cursor for
         select
            r.num_poliza numero_poliza,
            r.num_apli numero_aplicacion,
            ls_docum codigo_documento,
            r.num_recibo numero_recibo,
            f_nom_contratante
                (ln_cia,'RUC',ls_docum) cliente,
            tron2000.sf_recupera_direccion@tron (ln_cia, 'RUC', ls_docum) direccion,
            f_act_economica
            (r.cod_cia,r.num_poliza) actividad_economica,
            f_nom_colectivo
            (r.cod_cia,r.num_poliza) colectivo,
            (select fec_efec_poliza from a2000030@tron pol
             where pol.cod_cia = ln_cia
              and pol.num_poliza = ls_poliza
              and pol.num_spto = ln_spto
              and pol.num_apli = 0
              and pol.num_spto_apli = 0
            ) fecha_efecto_poliza,
            (select fec_vcto_poliza from a2000030@tron pol
             where pol.cod_cia = ln_cia
              and pol.num_poliza = ls_poliza
              and pol.num_spto = ln_spto
              and pol.num_apli = 0
              and pol.num_spto_apli = 0
            ) fecha_vcto_poliza,
            ld_fechaefec fecha_efecto_aplicacion,
            ld_fechavcto fecha_vcto_aplicacion,
            f_forma_pago
            (r.cod_cia,r.num_poliza) forma_pago,
            f_nom_moneda
            (r.cod_mon) moneda,
            r.fec_actu fecha_emision_poliza,
            r.imp_boni + r.imp_neta prima_neta,
            r.imp_recargo importe_recargo,
            r.imp_interes importe_interes,
            r.imp_recibo prima_total,
            (ld_fechaefec+10) fecha_vencimiento,
            r.imp_imptos + r.imp_imptos_interes importe_igv
            from a2990700@tron r
            where r.num_recibo = p_numero_recibo;

   end PGEAS012;

--==============================================================================
--PROPOSITO: Eliminar los datos de la tablas RCEN_ASEG0001_TEMP, RCEN_ASEG0002_TEMP, RCEN_ASEG0003_TEMP, RCEN_ASEG0004_TEMP
-- en el caso de que se envie la MCA_RESETEO = 'S'
-- filtrando por la llave de la poliza y el codigo de usuario y el codigo del sistema

-- AUTOR: JRAFFO
-- FECHA: 27/08/2015
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- p_numero_recibo   -> Numero de Recibo
--o_cursor  ---> Cursor de Resultados
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Eliminar los datos de la tablas RCEN_ASEG0001_TEMP, RCEN_ASEG0002_TEMP, RCEN_ASEG0003_TEMP, RCEN_ASEG0004_TEMP
-- en el caso de que se envie la MCA_RESETEO = 'S'
-- filtrando por la llave de la poliza y el codigo de usuario y el codigo del sistema
--==============================================================================
PROCEDURE PGEAS013 (
    as_Cod_Cia                       IN     VARCHAR2,--01
    as_Num_Poliza                  IN     VARCHAR2,--02
    as_Num_Spto         IN     VARCHAR2,--03
    as_Num_Apli         IN     VARCHAR2,--04
    as_Num_Spto_Apli    IN     VARCHAR2,--05
    as_Cod_Usuario      IN     VARCHAR2,--06
    as_Cod_Sistema      IN     VARCHAR2,--07
    p_cMensaje             OUT VARCHAR
)
IS

BEGIN

FOR REG IN (select NRO_MOVIMIENTO from RCEN_ASEG0002_TEMP
where COD_CIA = as_Cod_Cia and
num_poliza = as_Num_Poliza and
num_spto = as_Num_Spto and
num_apli = as_Num_Apli and
num_spto_apli = as_Num_Spto_Apli and
COD_USR_REG = as_Cod_Usuario and
COD_SISTEMA = as_Cod_Sistema)
    LOOP

        delete from RCEN_ASEG0004_TEMP
        where
        NRO_MOVIMIENTO = reg.NRO_MOVIMIENTO;

        delete from RCEN_ASEG0003_TEMP
        where
        NRO_MOVIMIENTO = reg.NRO_MOVIMIENTO;

        delete from RCEN_ASEG0002_TEMP
        where
        NRO_MOVIMIENTO = reg.NRO_MOVIMIENTO;

        delete from RCEN_ASEG0001_TEMP
        where
        NRO_MOVIMIENTO = reg.NRO_MOVIMIENTO;

    END LOOP;

p_cMensaje := 'OK';

  EXCEPTION
        WHEN OTHERS THEN
        p_cMensaje := 'ER:'||SQLERRM;
        ROLLBACK;

END PGEAS013;

    --==============================================================================
--PROPOSITO: Grabar la poliza de enlace del movimiento

-- AUTOR: JRAFFO
-- FECHA: 27/08/2015
--------------------------------------------------------------------------------
--DATOS RELEVANTES
-- p_numero_recibo   -> Numero de Recibo
--o_cursor  ---> Cursor de Resultados
--------------------------------------------------------------------------------
--DESCRIPCION FUNCIONAL
--Grabar la poliza de enlace del movimiento
--==============================================================================
PROCEDURE PGEAS014 (
    as_Num_Movimiento IN VARCHAR2,--01
    as_Cod_Cia  IN VARCHAR2,--02
    as_Num_Poliza   IN VARCHAR2,--03
    as_Num_Spto IN VARCHAR2,--04
    as_Num_Apli IN VARCHAR2,--05
    as_Num_Spto_Apli    IN VARCHAR2,--06
    as_Cod_Usuario      IN     VARCHAR2,--06
    as_Cod_Sistema      IN     VARCHAR2,--07
    p_cMensaje             OUT VARCHAR
)
IS

BEGIN

  INSERT INTO OIM.RCEN_ASEG0002_TEMP
          (NRO_MOVIMIENTO,COD_CIA,COD_RAMO,NUM_POLIZA,NUM_SPTO,
           NUM_APLI,NUM_SPTO_APLI,COD_SISTEMA,COD_USR_REG,FEC_REG) VALUES
          (as_Num_Movimiento,3,SUBSTR(as_Num_Poliza,1,3),as_Num_Poliza,as_Num_Spto,
           as_Num_Apli,as_Num_Spto_Apli,as_Cod_Sistema,as_Cod_Usuario,SYSDATE);

   p_cMensaje := 'OK';

  EXCEPTION
        WHEN OTHERS THEN
        p_cMensaje := 'ER:'||SQLERRM;
        ROLLBACK;

END PGEAS014;

END;
/

