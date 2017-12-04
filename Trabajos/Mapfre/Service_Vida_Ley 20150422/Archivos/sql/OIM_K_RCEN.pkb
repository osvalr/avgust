CREATE OR REPLACE PACKAGE BODY OIM.oim_k_rcen
IS

/*==========================================================================
  PROPOSITO: Insertar Asegurado en Repositorio centralizado.
  AUTOR: AROSALES                                          FECHA: 11/10/2013
  --------------------------------------------------------------------------
  DATOS RELEVANTES:

  --------------------------------------------------------------------------
  DESCRIPCION FUNCIONAL:
  Insertar Asegurado en Repositorio centralizado, cuando no exista.
  ========================================================================*/
  PROCEDURE INSERTAR_ASEGURADO (
    p_cNOMS             IN   VARCHAR2,
    p_cNOM_COMPLETO     IN   VARCHAR2,
    p_cAPELLIDO_PAT     IN   VARCHAR2,
    p_cAPELLIDO_MAT     IN   VARCHAR2,
    p_dFECHA_NAC        IN   VARCHAR2,
    p_cNRO_DOCUMENTO    IN   VARCHAR2,
    p_cTIPO_DOCUMENTO   IN   VARCHAR2,
    p_cCODIGO_USUARIO   IN   VARCHAR2,
    p_cID_ARCH_ORIGEN   IN   NUMBER,
    p_nRetorno          OUT  NUMBER,
    p_cMensaje          OUT  VARCHAR2
  )
  IS

    nAsegExist          NUMBER := 0;
    nCodAseg            NUMBER;
    cIndReniec          VARCHAR(1);

    PRIMER_NOM          VARCHAR2 (50 BYTE);
    SEGUNDO_NOM         VARCHAR2 (50 BYTE);
    DATOS_RENIEC        NUMBER := 0;
    SEX                 CHAR (1 BYTE);
    FECHA_NACIMIENTO    DATE;

    DIAMES              NUMBER;
    APELLIDOPATERNO     VARCHAR2 (50 BYTE);
    APELLIDOMATERNO     VARCHAR2 (50 BYTE);
    NOMBRESS            VARCHAR2 (100 BYTE);
    NOMBRECOMPLETO      VARCHAR2 (200 BYTE);

  BEGIN

    -- Validar si Asegurado existe en 'RCEN_ASEGURADOS'
    BEGIN
        SELECT 1
        INTO   nAsegExist
        FROM   DUAL
        WHERE  EXISTS (SELECT 1 FROM OIM.RCEN_ASEGURADOS
                       WHERE  NRO_DOCUMENTO = p_cNRO_DOCUMENTO AND TIPO_DOC = p_cTIPO_DOCUMENTO AND ESTADO = 'A');
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            nAsegExist := 0;
    END;


    -- Buscamos en la tabla de la RENIEC
    IF (p_cTIPO_DOCUMENTO = 'DNI') THEN
        BEGIN
            SELECT APTRNO, AMTRNO, NMBRS, FNCMNTO, DECODE (SEXO, 1, 'M', 2, 'F', 'M'),
                   APTRNO || ' ' || AMTRNO || ' ' || NMBRS, 1
            INTO   APELLIDOPATERNO, APELLIDOMATERNO, NOMBRESS, FECHA_NACIMIENTO, SEX,
                   NOMBRECOMPLETO, DATOS_RENIEC
            FROM   SGA.EPSAR00@EPS
            WHERE  NDIDNTDD = p_cNRO_DOCUMENTO;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                DATOS_RENIEC := 0;
      END;
    END IF;

    -- Reniec
    IF DATOS_RENIEC = 1 THEN cIndReniec := 'S'; ELSE cIndReniec := 'N'; END IF;


    -- SI LO DATOS NO LOS ENCONTRAMOS EN LA TABLA DE LA RENIEC INSERTAMOS LOS DATOS INGRESADOS POR EL USUARIO
    IF DATOS_RENIEC = 0 THEN

        IF LENGTH (TRIM (p_cAPELLIDO_PAT)) > 0 THEN
            -- Si el nombre completo no esta lleno significa que los datos estan en los otros campos
            APELLIDOPATERNO := p_cAPELLIDO_PAT;
            APELLIDOMATERNO := p_cAPELLIDO_MAT;
            NOMBRESS        := p_cNOMS;
            NOMBRECOMPLETO  := p_cAPELLIDO_PAT || ' ' || p_cAPELLIDO_MAT || ' ' || p_cNOMS;
        ELSE
            -- Si el nombre completo esta lleno significa que tenemos que separar los datos
            APELLIDOPATERNO := SUBSTR (p_cNOM_COMPLETO, 0, INSTR (p_cNOM_COMPLETO, ' ') - 1);
            APELLIDOMATERNO := SUBSTR (p_cNOM_COMPLETO, INSTR (p_cNOM_COMPLETO, ' ', 1, 1) + 1, INSTR (p_cNOM_COMPLETO, ' ', 1, 2) - 1 - INSTR (p_cNOM_COMPLETO, ' ', 1, 1));
            NOMBRESS        := SUBSTR (p_cNOM_COMPLETO, INSTR (p_cNOM_COMPLETO, ' ', 1, 2) + 1);
            NOMBRECOMPLETO  := p_cNOM_COMPLETO;
        END IF;

        -- Solo se consideran las fechas que vienen con '/'
        IF INSTR (p_dFECHA_NAC, '/') <> 0 THEN
            -- Posible error si la fecha viene mal (mm/dd/yyyy)
            DIAMES := TO_NUMBER (SUBSTR (p_dFECHA_NAC, INSTR (p_dFECHA_NAC, '/', 1, 1) + 1,
                                 INSTR (p_dFECHA_NAC, '/', 1, 2) - 1 - INSTR (p_dFECHA_NAC, '/', 1, 1)));

            IF DIAMES < 13 THEN
                -- POSIBLE ERROR SI LA FECHA VIENE MAL (YYYY/MM/DD)
                DIAMES := TO_NUMBER (SUBSTR (p_dFECHA_NAC, 0, INSTR (p_dFECHA_NAC, '/') - 1));
                IF DIAMES < 32 THEN
                    FECHA_NACIMIENTO := TO_DATE (p_dFECHA_NAC, 'dd/mm/yyyy');
                ELSE
                    FECHA_NACIMIENTO := TO_DATE ('01/01/1980', 'dd/mm/yyyy');
                END IF;
            ELSE
                --PODRIA CONSIDERAR FECHA_NAC := NVL(TO_DATE(FECHA_NAC, 'mm/dd/yyyy'),'');
                FECHA_NACIMIENTO := TO_DATE ('01/01/1980', 'dd/mm/yyyy');
            END IF;

        ELSE
            --SI EL CAMPO FECHA NO TIENE NINGUN "/"
            FECHA_NACIMIENTO := TO_DATE ('01/01/1980', 'dd/mm/yyyy');
        END IF;
        -- FIN DE LLENAR FECHA DE NACIMIENTO

        SEX := 'M';

    END IF; --FIN DE LLENAR LA DATA CON INFORMACION DEL USUARIO


    -- DIVIDIMOS EL NOMBRE
    IF INSTR (p_cNOMS, ' ') <> 0 THEN
        PRIMER_NOM  := SUBSTR (NOMBRESS, 0, INSTR (NOMBRESS, ' ') - 1);
        SEGUNDO_NOM := SUBSTR (NOMBRESS, INSTR (NOMBRESS, ' ') + 1);
    ELSE
        PRIMER_NOM  := NOMBRESS;
        SEGUNDO_NOM := '';
    END IF;


    -- 'S' : Reniec
    -- 'N' : No Reniec

    IF nAsegExist = 0 THEN
        -- Asegurado NO existe.

        SELECT OIM.SEQ_INDICE_ASEGURADO.NEXTVAL INTO nCodAseg FROM DUAL;

        INSERT INTO OIM.RCEN_ASEGURADOS(
                    COD_ASEG, APE_PATERNO, APE_MATERNO, PRIMER_NOMBRE, SEGUNDO_NOMBRE,
                    NOMBRE_COMPLETO, TIPO_DOC, NRO_DOCUMENTO, SEXO, FEC_NAC,
                    COD_USUARIO, FEC_CREACION, IND_RENIEC)
        VALUES     (nCodAseg, APELLIDOPATERNO, APELLIDOMATERNO, PRIMER_NOM, SEGUNDO_NOM,
                    NOMBRECOMPLETO, p_cTIPO_DOCUMENTO, p_cNRO_DOCUMENTO, SEX, FECHA_NACIMIENTO,
                    NVL (p_cCODIGO_USUARIO, USER), SYSDATE, cIndReniec);

    ELSE
      -- Actualizar

        UPDATE OIM.RCEN_ASEGURADOS
        SET    APE_PATERNO      = APELLIDOPATERNO,
               APE_MATERNO      = APELLIDOMATERNO,
               PRIMER_NOMBRE    = PRIMER_NOM,
               SEGUNDO_NOMBRE   = SEGUNDO_NOM,
               NOMBRE_COMPLETO  = NOMBRECOMPLETO,
               TIPO_DOC         = p_cTIPO_DOCUMENTO,
               SEXO             = SEX,
               FEC_NAC          = FECHA_NACIMIENTO,
               COD_USR_MOD  = NVL (p_cCODIGO_USUARIO, USER),
               FEC_MOD          = SYSDATE,
               IND_RENIEC       = cIndReniec
        WHERE  NRO_DOCUMENTO    = p_cNRO_DOCUMENTO
        AND    TIPO_DOC         = p_cTIPO_DOCUMENTO;
    END IF;


    p_nRetorno := 1;

  EXCEPTION
    WHEN OTHERS THEN
        p_nRetorno := -1;
        p_cMensaje := SQLERRM;
        --tron2000.MPE_P_TRAZA4@tron('ftelloba_nfire','a','INSERTAR_ASEGURADO: p_cMensajeError: '|| to_char(p_cMensaje));

  END INSERTAR_ASEGURADO;


/*==========================================================================
  PROPOSITO: Insertar Movimiento SCTR.
  AUTOR: AROSALES                                          FECHA: 14/10/2013
  --------------------------------------------------------------------------
  DATOS RELEVANTES:

  --------------------------------------------------------------------------
  DESCRIPCION FUNCIONAL:

  ========================================================================*/
  PROCEDURE INSERTAR_MOVIMIENTO_SCTR (
    p_cNRO_DOCUMENTO   IN   VARCHAR2,
    p_cTIPO_DOCUMENTO  IN   VARCHAR2,
    p_cCODIGO_USUARIO  IN   VARCHAR2,
    p_cCODIGO          IN   NUMBER,
    p_nRetorno         OUT  NUMBER,
    p_cMensaje         OUT  VARCHAR2
  )
  IS

    nDocumento_Movs     NUMBER := 0;
    cDoc_Movs_Sal       VARCHAR (20);
    cDoc_Movs_Pen       VARCHAR (20);
    nCodMovs            NUMBER;
    NOM_COMPLETO        VARCHAR2 (200 BYTE);
    nCodAseg            NUMBER;

    nEsReserva          NUMBER (1) := 0;
    cRuc                VARCHAR(100);
    dFecIniVig          DATE;
    dFecFinVig          DATE;
    cProceso            VARCHAR(10);

  BEGIN

    -- Comprobar que tenga poliza de SALUD y PENSION
    BEGIN
        SELECT POLSAL, POLPEN, RUC, to_date(FEC_INI_VIG, 'DD/MM/YYYY'), to_date(FEC_FIN_VIG, 'DD/MM/YYYY')
        INTO   cDoc_Movs_Sal, cDoc_Movs_Pen, cRuc, dFecIniVig, dFecFinVig
        FROM   SCTR.SCTR_CONSTANCIA
        WHERE  ID_FILE = p_cCODIGO;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            cDoc_Movs_Sal := '0';
            cDoc_Movs_Pen := '0';
            cRuc := '';
            dFecIniVig := null;
            dFecFinVig := null;
    END;

    -- Buscar codigo de Asegurado
    SELECT COD_ASEG INTO nCodAseg
    FROM   OIM.RCEN_ASEGURADOS
    WHERE  NRO_DOCUMENTO = p_cNRO_DOCUMENTO
    AND    TIPO_DOC      = p_cTIPO_DOCUMENTO
    AND    ESTADO        = 'A';

    -- Verificar Poliza de Reserva
    BEGIN
        SELECT 1
        INTO   nEsReserva
        FROM   rsva_pol_manual_sctr@tron A
        WHERE (A.num_poliza_pen = cDoc_Movs_Pen OR A.num_poliza_sal = cDoc_Movs_Sal)
        AND    A.TIP_DOCUM      = 'RUC'
        AND    A.COD_DOCUM      = cRuc
        AND    A.FEC_INI_VIG    = dFecIniVig
        AND    A.FEC_FIN_VIG    = dFecFinVig
        AND    NOT EXISTS (SELECT 1 FROM a2000030@tron p
                           WHERE  p.cod_cia = 2 and p.num_poliza = cDoc_Movs_Pen and p.num_spto = 0 and p.num_apli=0 and p.num_spto_apli=0)
        AND    NOT EXISTS (SELECT 1 FROM a2000030@tron p
                           WHERE  p.cod_cia = 3 and p.num_poliza = cDoc_Movs_Sal and p.num_spto = 0 and p.num_apli=0 and p.num_spto_apli=0)
        AND    ROWNUM <= 1;
    EXCEPTION
        WHEN OTHERS THEN
            nEsReserva := 0;
    END;

    -- Validar si viene de RESERVA.
    IF nEsReserva = 1 THEN cProceso := 'RESERVA'; ELSE cProceso := 'TRONWEB'; END IF;



    -- Poliza SALUD
    IF SUBSTR (cDoc_Movs_Sal, 0, 3) = '702' THEN

        BEGIN
            SELECT 1
            INTO   nDocumento_Movs
            FROM   DUAL
            WHERE  EXISTS (SELECT 1
                           FROM   SCTR.SCTR_CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                           WHERE  b.NUM_POLIZA = a.POLSAL
                           AND    b.NUM_SPTO   = a.NUM_SPTO_SAL
                           AND    b.NUM_APLI   = DECODE(a.NUM_APLI_SAL,0,1,a.NUM_APLI_SAL)
                           AND    a.ID_FILE    = p_cCODIGO
                           AND    a.RUC        = cRUC
                           AND    b.COD_ASEG   = nCodAseg
                           AND    b.ESTADO     = 'A');
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                nDocumento_Movs := 0;
        END;

        -- Si no esta en la tabla movimientos insertamos la poliza de salud
        IF nDocumento_Movs = 0 THEN

            SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

            IF cProceso = 'RESERVA' THEN
                INSERT INTO OIM.RCEN_MOVIMIENTOS(COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA, COD_RAMO,
                                                 NUM_POLIZA, NUM_SPTO, NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG,
                                                 FEC_FIN_VIG, SIST_ORIG, FEC_ALTA, COD_USUARIO, FEC_CREACION, OCUP_ASEG)
                SELECT nCodAseg, nCodMovs, t.*
                FROM  (SELECT 'RUC', b.RUC, 3, SUBSTR (POLSAL, 0, 3), b.POLSAL,
                              b.NUM_SPTO_SAL, DECODE(b.NUM_APLI_SAL,0,1,b.NUM_APLI_SAL), DECODE(b.NUM_SPTO_APLI_SAL,0,1,b.NUM_SPTO_APLI_SAL),
                              p.fec_ini_vig, p.fec_fin_vig,
                              cProceso, SYSDATE a, NVL (p_cCODIGO_USUARIO, USER), SYSDATE, '' --El usuario es el que se registra en el reserva
                       FROM   SCTR.SCTR_CONSTANCIA b, rsva_pol_manual_sctr@tron p
                       WHERE  b.id_file = p_cCODIGO
                       AND    b.RUC     = cRUC
                       AND    b.polsal = p.num_poliza_sal) t;
            /* FTELLO 20140829
            ELSIF cProceso = 'TRONWEB' THEN

                INSERT INTO OIM.RCEN_MOVIMIENTOS(COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA, COD_RAMO,
                                                 NUM_POLIZA, NUM_SPTO, NUM_APLI, NUM_SPTO_APLI,
                                                 FEC_INI_VIG, FEC_FIN_VIG,
                                                 SIST_ORIG, FEC_ALTA, COD_USUARIO, FEC_CREACION, OCUP_ASEG)
                SELECT nCodAseg, nCodMovs, t.*
                FROM  (SELECT 'RUC', b.RUC, b.COD_CIA_SAL, SUBSTR (POLSAL, 0, 3), b.POLSAL,
                              b.NUM_SPTO_SAL, DECODE(b.NUM_APLI_SAL,0,1,b.NUM_APLI_SAL), DECODE(b.NUM_SPTO_APLI_SAL,0,1,b.NUM_SPTO_APLI_SAL),
                              TO_DATE(b.fec_ini_vig, 'DD/MM/YYYY'), TO_DATE(b.fec_fin_vig, 'DD/MM/YYYY'),
                              cProceso, SYSDATE a, NVL(OBTENER_USUARIO_TRON(3,b.polsal,b.num_spto_sal,DECODE(b.NUM_APLI_SAL,0,1,b.NUM_APLI_SAL), DECODE(b.NUM_SPTO_APLI_SAL,0,1,b.NUM_SPTO_APLI_SAL)),NVL (p_cCODIGO_USUARIO, USER)), SYSDATE,''
                       FROM   SCTR.SCTR_CONSTANCIA b
                       WHERE  b.id_file = p_cCODIGO
                         AND  b.RUC = cRUC) t;
                */
            END IF;



        END IF;

    END IF;





    -- Si tiene poliza de PENSION verficamos si esta en la tabla de movimientos
    IF SUBSTR (cDoc_Movs_Pen, 0, 3) = '701' THEN

        BEGIN
            SELECT 1
            INTO   nDocumento_Movs
            FROM   DUAL
            WHERE  EXISTS (SELECT 1
                           FROM   SCTR.SCTR_CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                           WHERE  b.NUM_POLIZA = a.POLPEN
                           AND    b.NUM_SPTO   = a.NUM_SPTO_PEN
                           AND    b.NUM_APLI   = DECODE(a.NUM_APLI_PEN,0,1,a.NUM_APLI_PEN)
                           AND    a.ID_FILE    = p_cCODIGO
                           AND    a.RUC        = cRUC
                           AND    b.COD_ASEG   = nCodAseg
                           AND    b.ESTADO        = 'A');
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                nDocumento_Movs := 0;
        END;


        -- Si no esta en la tabla movimientos insertamos la poliza de pension
        IF nDocumento_Movs = 0 THEN

            SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

            IF cProceso = 'RESERVA' THEN
                INSERT INTO OIM.RCEN_MOVIMIENTOS(COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA,
                                                 COD_RAMO, NUM_POLIZA, NUM_SPTO, NUM_APLI, NUM_SPTO_APLI,
                                                 FEC_INI_VIG, FEC_FIN_VIG, SIST_ORIG, FEC_ALTA,
                                                 COD_USUARIO, FEC_CREACION, OCUP_ASEG)
                SELECT nCodAseg, nCodMovs, t.*
                FROM  (SELECT 'RUC', b.RUC, 2, SUBSTR (POLPEN, 0, 3), b.POLPEN,
                              b.NUM_SPTO_PEN, DECODE(b.NUM_APLI_PEN,0,1,b.NUM_APLI_PEN), DECODE(b.NUM_SPTO_APLI_PEN,0,1,b.NUM_SPTO_APLI_PEN),
                              p.fec_ini_vig, p.fec_fin_vig,
                              cProceso, SYSDATE a, NVL (p_cCODIGO_USUARIO, USER), SYSDATE, ''
                       FROM   sctr.SCTR_CONSTANCIA b, rsva_pol_manual_sctr@tron p
                       WHERE  b.id_file = p_cCODIGO
                         AND  b.RUC    = cRUC
                       --AND    b.cod_cia_pen = p.cod_cia
                       AND    b.polpen = p.num_poliza_pen) t;

            /*  FTELLO 20140829
            ELSIF cProceso = 'TRONWEB' THEN

                INSERT INTO OIM.RCEN_MOVIMIENTOS(COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA,
                                                 COD_RAMO, NUM_POLIZA, NUM_SPTO, NUM_APLI, NUM_SPTO_APLI,
                                                 FEC_INI_VIG, FEC_FIN_VIG, SIST_ORIG, FEC_ALTA,
                                                 COD_USUARIO, FEC_CREACION, OCUP_ASEG)
                SELECT nCodAseg, nCodMovs, t.*
                FROM  (SELECT 'RUC', b.RUC, b.COD_CIA_PEN, SUBSTR (POLPEN, 0, 3), b.POLPEN,
                              b.NUM_SPTO_PEN, DECODE(b.NUM_APLI_PEN,0,1,b.NUM_APLI_PEN), DECODE(b.NUM_SPTO_APLI_PEN,0,1,b.NUM_SPTO_APLI_PEN),
                              TO_DATE(b.fec_ini_vig, 'DD/MM/YYYY'), TO_DATE(b.fec_fin_vig, 'DD/MM/YYYY'),
                              cProceso, SYSDATE a, NVL(OBTENER_USUARIO_TRON(2,b.polpen,b.num_spto_pen,DECODE(b.NUM_APLI_PEN,0,1,b.NUM_APLI_PEN), DECODE(b.NUM_SPTO_APLI_PEN,0,1,b.NUM_SPTO_APLI_PEN)),NVL (p_cCODIGO_USUARIO, USER)), SYSDATE, ''
                       FROM   sctr.SCTR_CONSTANCIA b
                       WHERE  b.id_file = p_cCODIGO
                         AND  b.RUC     = cRUC) t;
                 */
            END IF;


        END IF;

    END IF;

    p_nRetorno := 1;

  EXCEPTION
    WHEN OTHERS THEN
        p_nRetorno := -1;
        p_cMensaje := SQLERRM;

  END INSERTAR_MOVIMIENTO_SCTR;



/*==========================================================================
  PROPOSITO: Insertar Movimiento OIM.
  AUTOR: AROSALES                                          FECHA: 14/10/2013
  --------------------------------------------------------------------------
  DATOS RELEVANTES:

  --------------------------------------------------------------------------
  DESCRIPCION FUNCIONAL:

  ========================================================================*/
  PROCEDURE INSERTAR_MOVIMIENTO_OIM (
    p_cNRO_DOCUMENTO   IN   VARCHAR2,
    p_cTIPO_DOCUMENTO  IN   VARCHAR2,
    p_cCODIGO_USUARIO  IN   VARCHAR2,
    p_cCODIGO          IN   NUMBER,
    p_nRetorno         OUT  NUMBER,
    p_cMensaje         OUT  VARCHAR2
  )
  IS

    nDocumento_Movs     NUMBER := 0;
    cDoc_Movs_Sal       VARCHAR (20);
    cDoc_Movs_Pen       VARCHAR (20);
    nCodMovs            NUMBER;
    NOM_COMPLETO        VARCHAR2 (200 BYTE);
    nCodAseg            NUMBER;
    cRUC                VARCHAR2(11);

  BEGIN

    -- Comprobar que tenga poliza de SALUD y PENSION
    BEGIN
        SELECT POLSAL, POLPEN, RUC
        INTO   cDoc_Movs_Sal, cDoc_Movs_Pen, cRUC
        FROM   OIM.SCTR_CONSTANCIA
        WHERE  ID_FILE = p_cCODIGO;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            cDoc_Movs_Sal := '0';
            cDoc_Movs_Pen := '0';
    END;

    -- Buscamos el codigo de asegurado porque ya existe
    SELECT COD_ASEG
    INTO   nCodAseg
    FROM   OIM.RCEN_ASEGURADOS
    WHERE  NRO_DOCUMENTO = p_cNRO_DOCUMENTO
    AND    TIPO_DOC      = p_cTIPO_DOCUMENTO
    AND    ESTADO        = 'A';


    -- Si tiene poliza de SALUD verficamos si esta en la tabla de movimientos
    IF SUBSTR (cDoc_Movs_Sal, 0, 3) = '702' THEN

        BEGIN
            SELECT 1
            INTO   nDocumento_Movs
            FROM   DUAL
            WHERE  EXISTS (SELECT 1
                           FROM   OIM.SCTR_CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                           WHERE  b.NUM_POLIZA  = a.POLSAL
                           AND    b.NUM_SPTO    = a.NUM_SPTO_SAL
                           AND    b.NUM_APLI    = DECODE(a.NUM_APLI_SAL,0,1,a.NUM_APLI_SAL)
                           AND    a.ID_FILE     = p_cCODIGO
                           AND    a.RUC         = cRUC
                           AND    b.COD_ASEG    = nCodAseg
                           AND    b.ESTADO      = 'A');
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                nDocumento_Movs := 0;
        END;

        -- Si no esta en la tabla movimientos insertamos la poliza de salud
        IF nDocumento_Movs = 0 THEN

            SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

            INSERT INTO OIM.RCEN_MOVIMIENTOS (COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA, COD_RAMO, NUM_POLIZA,
                                              NUM_SPTO, NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG, FEC_FIN_VIG, SIST_ORIG,
                                              FEC_ALTA, COD_USUARIO, FEC_CREACION, OCUP_ASEG)
            SELECT nCodAseg, nCodMovs, t.*
            FROM  (SELECT 'RUC', b.RUC, b.COD_CIA_SAL, SUBSTR (POLSAL, 0, 3), b.POLSAL,
                          b.NUM_SPTO_SAL, DECODE(b.NUM_APLI_SAL,0,1,b.NUM_APLI_SAL), DECODE(b.NUM_SPTO_APLI_SAL,0,1,b.NUM_SPTO_APLI_SAL),
                          TO_DATE(b.fec_ini_vig, 'DD/MM/YYYY'), TO_DATE(b.fec_fin_vig, 'DD/MM/YYYY'),
                          'OIM', SYSDATE a, NVL (p_cCODIGO_USUARIO, USER), SYSDATE, ''
                   FROM   OIM.SCTR_CONSTANCIA b
                   WHERE  b.id_file      = p_cCODIGO
                     AND  b.RUC          = cRUC) t;


        END IF;

    END IF;





    -- Si tiene poliza de PENSION verficamos si esta en la tabla de movimientos
    IF SUBSTR (cDoc_Movs_Pen, 0, 3) = '701' THEN

        BEGIN
            SELECT 1
            INTO   nDocumento_Movs
            FROM   DUAL
            WHERE  EXISTS (SELECT 1
                           FROM   SCTR.SCTR_CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                           WHERE  b.NUM_POLIZA = a.POLPEN
                           AND    b.NUM_SPTO   = a.NUM_SPTO_PEN
                           AND    b.NUM_APLI   = DECODE(a.NUM_APLI_PEN,0,1,a.NUM_APLI_PEN)
                           AND    a.ID_FILE    = p_cCODIGO
                           AND    a.RUC        = cRUC
                           AND    b.COD_ASEG   = nCodAseg
                           AND    b.ESTADO     = 'A');
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                nDocumento_Movs := 0;
        END;


        -- Si no esta en la tabla movimientos insertamos la poliza de pension
        IF nDocumento_Movs = 0 THEN

            SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

            INSERT INTO OIM.RCEN_MOVIMIENTOS
                        (COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA, COD_RAMO, NUM_POLIZA,
                         NUM_SPTO, NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG, FEC_FIN_VIG, SIST_ORIG,
                         FEC_ALTA, COD_USUARIO, FEC_CREACION, OCUP_ASEG)
            SELECT nCodAseg, nCodMovs, t.*
            FROM  (SELECT 'RUC', b.RUC, b.COD_CIA_PEN, SUBSTR (POLPEN, 0, 3), b.POLPEN,
                          b.NUM_SPTO_PEN, DECODE(b.NUM_APLI_PEN,0,1,b.NUM_APLI_PEN), DECODE(b.NUM_SPTO_APLI_PEN,0,1,b.NUM_SPTO_APLI_PEN),
                          --p.fec_efec_spto, p.fec_vcto_spto,
                          TO_DATE(b.fec_ini_vig, 'DD/MM/YYYY'), TO_DATE(b.fec_fin_vig, 'DD/MM/YYYY'),
                          'OIM', SYSDATE a, NVL (p_cCODIGO_USUARIO, USER), SYSDATE, ''
                   FROM   OIM.SCTR_CONSTANCIA b
                   WHERE  b.id_file      = p_cCODIGO
                     AND  b.RUC          = cRUC) t;



        END IF;

    END IF;

    p_nRetorno := 1;

  EXCEPTION
    WHEN OTHERS THEN
        p_nRetorno := -1;
        p_cMensaje := SQLERRM;

  END INSERTAR_MOVIMIENTO_OIM;






/*==========================================================================
  PROPOSITO: Insertar Movimiento SCTR - Planilla.
  AUTOR: AROSALES                                          FECHA: 14/10/2013
  --------------------------------------------------------------------------
  DATOS RELEVANTES:

  --------------------------------------------------------------------------
  DESCRIPCION FUNCIONAL:

  ========================================================================*/
  PROCEDURE INSERTAR_MOVIMIENTO_SCTR_PLA (
    p_cNRO_DOCUMENTO        IN   VARCHAR2,
    p_cTIPO_DOCUMENTO       IN   VARCHAR2,
    p_cCODIGO_USUARIO       IN   VARCHAR2,
    --p_cCODIGO               IN   NUMBER,
    p_cPLARUC               IN   VARCHAR2,
    p_cFEC_ALTA             IN   VARCHAR2,
    p_cPOLSAL               IN   VARCHAR2,
    p_cPOLPEN               IN   VARCHAR2,
    p_cNUM_SPTO_SAL         IN   VARCHAR2,
    p_cNUM_APLI_SAL         IN   VARCHAR2,
    p_cNUM_SPTO_APLI_SAL    IN   VARCHAR2,
    p_cNUM_SPTO_PEN         IN   VARCHAR2,
    p_cNUM_APLI_PEN         IN   VARCHAR2,
    p_cNUM_SPTO_APLI_PEN    IN   VARCHAR2,
    p_nRetorno              OUT  NUMBER,
    p_cMensaje              OUT  VARCHAR2
  )
  IS

    nDocumento_Movs     NUMBER := 0;
    cDoc_Movs_Sal       VARCHAR (20);
    cDoc_Movs_Pen       VARCHAR (20);
    nCodMovs            NUMBER;
    NOM_COMPLETO        VARCHAR2 (200 BYTE);
    nCodAseg            NUMBER;

    dFec_efec_spto      DATE;
    dFec_vcto_spto      DATE;
    cCod_Usr            VARCHAR2(15);
    nEsReserva          NUMBER (1) := 0;
    cProceso            VARCHAR(10);

  BEGIN

    -- Poliza de SALUD y PENSION
    BEGIN
        cDoc_Movs_Sal := p_cPOLSAL;
        cDoc_Movs_Pen := p_cPOLPEN;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            cDoc_Movs_Sal := '0';
            cDoc_Movs_Pen := '0';
    END;

    BEGIN
        SELECT 1
        INTO   nEsReserva
        FROM   rsva_pol_manual_sctr@tron A
        WHERE (A.num_poliza_pen = cDoc_Movs_Pen OR A.num_poliza_sal = cDoc_Movs_Sal)
        AND    A.TIP_DOCUM      = 'RUC'
        AND    A.COD_DOCUM      = p_cPLARUC
        --AND    A.FEC_INI_VIG    = TO_DATE (dFecIniVig, 'DD/MM/YYYY')
        --AND    A.FEC_FIN_VIG    = TO_DATE (dFecFinVig, 'DD/MM/YYYY')
        AND    NOT EXISTS (SELECT 1 FROM a2000030@tron p WHERE  p.cod_cia = 2 and p.num_poliza = cDoc_Movs_Pen and p.num_spto = 0 and p.num_apli=0 and p.num_spto_apli=0)
        AND    NOT EXISTS (SELECT 1 FROM a2000030@tron p WHERE  p.cod_cia = 3 and p.num_poliza = cDoc_Movs_Sal and p.num_spto = 0 and p.num_apli=0 and p.num_spto_apli=0)
        AND    ROWNUM <=1;
    EXCEPTION
        WHEN OTHERS THEN
            nEsReserva := 0;
    END;

    -- Validar si viene de RESERVA.
    IF nEsReserva = 1 THEN cProceso := 'RESERVA'; ELSE cProceso := 'TRONWEB'; END IF;

    -- Codigo de Asegurado
    SELECT COD_ASEG INTO nCodAseg
    FROM   OIM.RCEN_ASEGURADOS
    WHERE  NRO_DOCUMENTO = p_cNRO_DOCUMENTO
    AND    TIPO_DOC      = p_cTIPO_DOCUMENTO
    AND    ESTADO        = 'A';


    -- Si tiene poliza de SALUD verficamos si esta en la tabla de movimientos
    IF SUBSTR (cDoc_Movs_Sal, 0, 3) = '702' THEN

        BEGIN
            SELECT 1 INTO nDocumento_Movs
            FROM   DUAL
            WHERE  EXISTS ( SELECT 1
                            FROM   OIM.RCEN_MOVIMIENTOS
                            WHERE  NUM_POLIZA = p_cPOLSAL
                            AND    NUM_SPTO   = p_cNUM_SPTO_SAL
                            AND    NUM_APLI   = DECODE(p_cNUM_APLI_SAL,0,1,p_cNUM_APLI_SAL)
                            AND    COD_ASEG   = nCodAseg
                            AND    ESTADO     = 'A');
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                nDocumento_Movs := 0;
        END;

        -- Si no esta en la tabla movimientos insertamos la poliza de salud
        IF nDocumento_Movs = 0 THEN

            SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

            IF cProceso = 'RESERVA' THEN
            -- Fecha Inicio, Fin de Vigencia
              SELECT fec_efec_spto, fec_vcto_spto, Cod_Usr
                INTO   dFec_efec_spto, dFec_vcto_spto, cCod_Usr
                FROM   TRON2000.A2000030@TRON
               WHERE  cod_cia       = 3
                 AND    num_poliza    = p_cPOLSAL
                 AND    num_spto      = p_cNUM_SPTO_SAL
                 AND    num_apli      = p_cNUM_APLI_SAL
               --AND    num_spto_apli = p_cNUM_SPTO_APLI_SAL
                AND    rownum = 1;
            ELSE
             --ini: ftello 20140826
             BEGIN
             SELECT fec_efec_spto, fec_vcto_spto, Cod_Usr
                        INTO   dFec_efec_spto, dFec_vcto_spto, cCod_Usr
                        FROM   TRON2000.A2000030@TRON
                       WHERE  cod_cia       = 3
                         AND    num_poliza    = p_cPOLSAL
                         AND    num_spto      = p_cNUM_SPTO_SAL
                         AND    num_apli      = p_cNUM_APLI_SAL
                      --AND    num_spto_apli = p_cNUM_SPTO_APLI_SAL
                        AND    rownum = 1;

             EXCEPTION
             WHEN OTHERS THEN
             --fin: ftello 20140826
              BEGIN
              SELECT a.fec_efec_spto, a.fec_vcto_spto, a.Cod_Usr
                INTO   dFec_efec_spto, dFec_vcto_spto, cCod_Usr
                FROM   TRON2000.A2000030@TRON a
               WHERE  a.cod_cia       = 3
                 AND    a.num_poliza    = p_cPOLSAL
                 AND    a.num_spto      = p_cNUM_SPTO_SAL
                 AND    a.num_apli      = (select max(b.num_apli) from TRON2000.A2000030@TRON b
                                        where b.cod_cia = 3 and b.num_poliza = p_cPOLSAL and b.num_spto = p_cNUM_SPTO_SAL
                                         and b.num_spto_apli != 0 and b.mca_poliza_anulada != 'S')
                 AND    a.num_spto_apli !=0
                 AND    rownum = 1;
               EXCEPTION
               WHEN OTHERS THEN

                  BEGIN
                  SELECT a.fec_efec_spto, a.fec_vcto_spto, a.Cod_Usr
                    INTO   dFec_efec_spto, dFec_vcto_spto, cCod_Usr
                    FROM   TRON2000.A2000030@TRON a
                   WHERE  a.cod_cia       = 3
                     AND    a.num_poliza    = p_cPOLSAL
                     AND    a.num_spto      = p_cNUM_SPTO_SAL
                     AND    a.num_apli      IN (select max(b.num_apli) from TRON2000.A2000030@TRON b
                                        where b.cod_cia = 3 and b.num_poliza = p_cPOLSAL and b.num_spto = p_cNUM_SPTO_SAL
                                         and b.num_spto_apli = 0 and b.mca_poliza_anulada != 'S')
                     AND    a.num_spto_apli =0
                     AND    rownum = 1;
                    EXCEPTION
                    WHEN OTHERS THEN
                      SELECT fec_efec_spto, fec_vcto_spto, 'NFIRE' --Cod_Usr
                        INTO   dFec_efec_spto, dFec_vcto_spto, cCod_Usr
                        FROM   TRON2000.A2000030@TRON
                       WHERE  cod_cia       = 3
                         AND    num_poliza    = p_cPOLSAL
                         AND    num_spto      = p_cNUM_SPTO_SAL
                         AND    num_apli      = p_cNUM_APLI_SAL
                      --AND    num_spto_apli = p_cNUM_SPTO_APLI_SAL
                        AND    rownum = 1;
                   END;
               END;


               END;
            END IF;
            INSERT INTO OIM.RCEN_MOVIMIENTOS
                       (COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA, COD_RAMO, NUM_POLIZA,
                        NUM_SPTO, NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG, FEC_FIN_VIG, SIST_ORIG,
                        FEC_ALTA, COD_USUARIO, FEC_CREACION, OCUP_ASEG)
            VALUES     (nCodAseg, nCodMovs, 'RUC', p_cPLARUC, 3, SUBSTR (p_cPOLSAL, 0, 3), p_cPOLSAL,
                        p_cNUM_SPTO_SAL, DECODE(p_cNUM_APLI_SAL,0,1,p_cNUM_APLI_SAL), DECODE(p_cNUM_SPTO_APLI_SAL,0,1,p_cNUM_SPTO_APLI_SAL),
                        dFec_efec_spto, dFec_vcto_spto, cProceso,
                        SYSDATE, NVL(cCod_Usr,NVL (p_cCODIGO_USUARIO, USER)), SYSDATE, '');

        END IF;

    END IF; -- Fin Salud





    -- Si tiene poliza de PENSION verficamos si esta en la tabla de movimientos
    IF SUBSTR (cDoc_Movs_Pen, 0, 3) = '701' THEN

        BEGIN
            SELECT 1
            INTO   nDocumento_Movs
            FROM   DUAL
            WHERE  EXISTS ( SELECT 1
                            FROM   OIM.RCEN_MOVIMIENTOS
                            WHERE  NUM_POLIZA = p_cPOLPEN
                            AND    NUM_SPTO   = p_cNUM_SPTO_PEN
                            AND    NUM_APLI   = DECODE(p_cNUM_APLI_PEN,0,1,p_cNUM_APLI_PEN)
                            AND    COD_ASEG   = nCodAseg
                            AND    ESTADO     = 'A');
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                nDocumento_Movs := 0;
        END;


        -- Si no esta en la tabla movimientos insertamos la poliza de pension
        IF nDocumento_Movs = 0 THEN

            SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

            -- Fecha Inicio, Fin de Vigencia
            SELECT fec_efec_spto, fec_vcto_spto, cod_usr
            INTO   dFec_efec_spto, dFec_vcto_spto, cCod_Usr
            FROM   TRON2000.A2000030@TRON
            WHERE  cod_cia       = 2
            AND    num_poliza    = p_cPOLPEN
            AND    num_spto      = p_cNUM_SPTO_PEN
            AND    num_apli      = p_cNUM_APLI_PEN
            AND    rownum = 1;

            INSERT INTO OIM.RCEN_MOVIMIENTOS
                       (COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA, COD_RAMO, NUM_POLIZA,
                        NUM_SPTO, NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG, FEC_FIN_VIG, SIST_ORIG,
                        FEC_ALTA, COD_USUARIO, FEC_CREACION, OCUP_ASEG)
            VALUES     (nCodAseg, nCodMovs, 'RUC', p_cPLARUC, 2, SUBSTR (p_cPOLPEN, 0, 3), p_cPOLPEN,
                        p_cNUM_SPTO_PEN, DECODE(p_cNUM_APLI_PEN,0,1,p_cNUM_APLI_PEN), DECODE(p_cNUM_SPTO_APLI_PEN,0,1,p_cNUM_SPTO_APLI_PEN),
                        dFec_efec_spto, dFec_vcto_spto, cProceso,
                        SYSDATE, NVL(cCod_Usr,NVL (p_cCODIGO_USUARIO, USER)), SYSDATE, '');

        END IF;

    END IF; -- Fin Pension

    p_nRetorno := 1;

  EXCEPTION
    WHEN OTHERS THEN
        p_nRetorno := -1;
        p_cMensaje := SQLERRM;

  END INSERTAR_MOVIMIENTO_SCTR_PLA;










/*==========================================================================
  PROPOSITO: Insertar Movimiento SCTR - MINERIA.
  AUTOR: AROSALES                                          FECHA: 14/10/2013
  --------------------------------------------------------------------------
  DATOS RELEVANTES:

  --------------------------------------------------------------------------
  DESCRIPCION FUNCIONAL:

  ========================================================================*/
  PROCEDURE INSERTAR_MOVIMIENTO_SCTR_MIN (
    p_cNRO_DOCUMENTO   IN   VARCHAR2,
    p_cTIPO_DOCUMENTO  IN   VARCHAR2,
    p_cCODIGO_USUARIO  IN   VARCHAR2,
    p_cCODIGO          IN   NUMBER,
    p_nRetorno         OUT  NUMBER,
    p_cMensaje         OUT  VARCHAR2
  )
  IS

    nDocumento_Movs     NUMBER := 0;
    cDoc_Movs_Sal       VARCHAR (20);
    cDoc_Movs_Pen       VARCHAR (20);
    nCodMovs            NUMBER;
    NOM_COMPLETO        VARCHAR2 (200 BYTE);
    nCodAseg            NUMBER;

  BEGIN

    -- Comprobar que tenga poliza de SALUD y PENSION
    BEGIN
        SELECT POLSAL, POLPEN
        INTO   cDoc_Movs_Sal, cDoc_Movs_Pen
        FROM   SCTRMINERIA.CONSTANCIA
        WHERE  COD_FILE = p_cCODIGO;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            cDoc_Movs_Sal := '0';
            cDoc_Movs_Pen := '0';
    END;

    -- Buscamos el codigo de asegurado porque ya existe
    SELECT COD_ASEG
    INTO   nCodAseg
    FROM   OIM.RCEN_ASEGURADOS
    WHERE  NRO_DOCUMENTO = p_cNRO_DOCUMENTO
    AND    TIPO_DOC      = p_cTIPO_DOCUMENTO
    AND    ESTADO        = 'A';


    -- Si tiene poliza de SALUD verficamos si esta en la tabla de movimientos
    IF SUBSTR (cDoc_Movs_Sal, 0, 3) = '702' THEN

        BEGIN
            SELECT 1
            INTO   nDocumento_Movs
            FROM   DUAL
            WHERE  EXISTS (
                   SELECT 1
                   FROM   SCTRMINERIA.CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                   WHERE  b.NUM_POLIZA = a.POLSAL
                   AND    b.NUM_SPTO   = a.NUM_SPTO_SAL
                   AND    b.NUM_APLI   = DECODE(a.NUM_APLI_SAL,0,1,a.NUM_APLI_SAL)
                   AND    a.COD_FILE   = p_cCODIGO
                   AND    b.COD_ASEG   = nCodAseg
                   AND    b.ESTADO     = 'A');
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                nDocumento_Movs := 0;
        END;

        -- Si no esta en la tabla movimientos insertamos la poliza de salud
        IF nDocumento_Movs = 0 THEN

            SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

            INSERT INTO OIM.RCEN_MOVIMIENTOS
                        (COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA, COD_RAMO, NUM_POLIZA,
                         NUM_SPTO, NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG, FEC_FIN_VIG, SIST_ORIG,
                         FEC_ALTA, COD_USUARIO, FEC_CREACION, OCUP_ASEG)
            SELECT nCodAseg, nCodMovs, t.*
            FROM  (SELECT 'RUC', b.RUC, p.COD_CIA, SUBSTR (POLSAL, 0, 3), b.POLSAL,
                          b.NUM_SPTO_SAL, DECODE(b.NUM_APLI_SAL,0,1,b.NUM_APLI_SAL), DECODE(b.NUM_SPTO_APLI_SAL,0,1,b.NUM_SPTO_APLI_SAL),
                          p.fec_efec_spto, p.fec_vcto_spto, 'MINERIA',
                          SYSDATE a, NVL (p_cCODIGO_USUARIO, USER), SYSDATE, ''
                   FROM   SCTRMINERIA.CONSTANCIA b, tron2000.a2000030@tron p
                   WHERE  b.COD_FILE     = p_cCODIGO
                   --AND    b.cod_cia_SAL  = p.cod_cia
                   AND    b.num_spto_SAL = p.num_spto
                   AND    b.num_apli_sal = p.num_apli
                   AND    p.cod_cia = 3
                   --AND    b.num_spto_apli_sal = p.num_spto_apli
                   AND    b.polsal       = p.num_poliza) t;

        END IF;

    END IF; -- Fin Salud





    -- Si tiene poliza de PENSION verficamos si esta en la tabla de movimientos
    IF SUBSTR (cDoc_Movs_Pen, 0, 3) = '701' THEN

        BEGIN
            SELECT 1
            INTO   nDocumento_Movs
            FROM   DUAL
            WHERE  EXISTS (
                   SELECT 1
                   FROM   SCTRMINERIA.CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                   WHERE  b.NUM_POLIZA = a.POLPEN
                   AND    b.NUM_SPTO   = a.NUM_SPTO_PEN
                   AND    b.NUM_APLI   = DECODE(a.NUM_APLI_PEN,0,1,a.NUM_APLI_PEN)
                   AND    a.COD_FILE   = p_cCODIGO
                   AND    b.COD_ASEG   = nCodAseg
                   AND    b.ESTADO     = 'A');
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                nDocumento_Movs := 0;
        END;


        -- Si no esta en la tabla movimientos insertamos la poliza de pension
        IF nDocumento_Movs = 0 THEN

            SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;

            INSERT INTO OIM.RCEN_MOVIMIENTOS
                        (COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA, COD_RAMO, NUM_POLIZA,
                        NUM_SPTO, NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG, FEC_FIN_VIG, SIST_ORIG,
                        FEC_ALTA, COD_USUARIO, FEC_CREACION, OCUP_ASEG)
            SELECT      nCodAseg, nCodMovs, t.*
            FROM  (SELECT 'RUC', b.RUC, p.COD_CIA, SUBSTR (POLPEN, 0, 3), b.POLPEN,
                          b.NUM_SPTO_PEN, DECODE(b.NUM_APLI_PEN,0,1,b.NUM_APLI_PEN), DECODE(b.NUM_SPTO_APLI_PEN,0,1,b.NUM_SPTO_APLI_PEN),
                          p.fec_efec_spto, p.fec_vcto_spto, 'MINERIA',
                          SYSDATE a, NVL (p_cCODIGO_USUARIO, USER), SYSDATE, ''
                   FROM   SCTRMINERIA.CONSTANCIA b, tron2000.a2000030@tron p
                   WHERE  b.COD_FILE     = p_cCODIGO
                   --AND    b.cod_cia_pen  = p.cod_cia
                   AND    b.num_spto_pen = p.num_spto
                   AND    b.num_apli_pen = p.num_apli
                   --AND    b.num_spto_apli_pen = p.num_spto_apli
                   AND    p.cod_cia = 2
                   AND    b.polpen       = p.num_poliza) t;

        END IF;

    END IF; -- Fin Pension

    p_nRetorno := 1;

  EXCEPTION
    WHEN OTHERS THEN
        p_nRetorno := -1;
        p_cMensaje := SQLERRM;

  END INSERTAR_MOVIMIENTO_SCTR_MIN;






/*==========================================================================
  PROPOSITO: Insertar Movimiento SCTR.
  AUTOR: AROSALES                                          FECHA: 14/10/2013
  --------------------------------------------------------------------------
  DATOS RELEVANTES:

  --------------------------------------------------------------------------
  DESCRIPCION FUNCIONAL:

  ========================================================================*/
  PROCEDURE INSERTAR_MOVIMIENTO_VIDALEY (
    p_cNRO_DOCUMENTO   IN   VARCHAR2,
    p_cTIPO_DOCUMENTO  IN   VARCHAR2,
    p_cCODIGO_USUARIO  IN   VARCHAR2,
    p_nSEQ_VE          IN      NUMBER,
    p_nSEQ_GA          IN      NUMBER,
    p_cOCUPACION     IN    VARCHAR2,
    p_cSueldo            IN      NUMBER, --> FTELLO 18/03/2015
    p_nRetorno         OUT    NUMBER,
    p_cMensaje         OUT   VARCHAR2
  )
  IS

    nDocumento_Movs      NUMBER := 0;
    cDoc_Movs_Sal           VARCHAR (20);
    cDoc_Movs_Pen           VARCHAR (20);
    nCodMovs                NUMBER;
    NOM_COMPLETO         VARCHAR2 (200 BYTE);
    nCodAseg            NUMBER;
    nNro_Mov            NUMBER; --> FTELLO 16/03/2015
    nSec                   NUMBER;
    id_error               NUMBER;
    --INCIO: FTELLO 16/03/2015
    CURSOR cursordatos IS
    SELECT c.TIP_DOCUM, c.COD_DOCUM, b.COD_CIA, b.COD_RAMO, b.NUM_POLIZA,
                       b.NUM_SPTO, DECODE(b.NUM_APLI,0,1,b.NUM_APLI) NUM_APLI, DECODE(b.NUM_SPTO_APLI,0,1,b.NUM_SPTO_APLI) NUM_SPTO_APLI,
                       p.fec_efec_spto, p.fec_vcto_spto
                       ,(SELECT NUM_RECIBO
                       FROM A2990700@TRON R
                       WHERE R.COD_CIA=2
                       AND R.NUM_POLIZA=B.NUM_POLIZA
                       AND R.NUM_SPTO= b.NUM_SPTO
                       AND R.NUM_APLI =  DECODE(b.NUM_APLI,0,1,b.NUM_APLI)
                       AND R.NUM_SPTO_APLI= DECODE(b.NUM_SPTO_APLI,0,1,b.NUM_SPTO_APLI)) NUM_RECIBO
                FROM   SCTR.GESTASEG_DET b,
                       SCTR.GESTASEG_CAB c,
                       SCTR.GESTASEG_RPT_CAB d,
                       TRON2000.A2000030@TRON p
                WHERE  b.SEQ_GA        = p_nSEQ_GA
                AND    c.SEQ_GA        = p_nSEQ_GA
                AND    d.SEQ_GA        = p_nSEQ_GA
                AND    d.SEQ_VE        = p_nSEQ_VE
                --AND    b.id_file = d.SEQ_VE
                AND    c.tip_docum = p.tip_docum
                AND    c.cod_docum = p.cod_docum
                AND    b.cod_cia = p.cod_cia
                AND    b.cod_ramo = p.cod_ramo
                AND    b.num_poliza    = p.num_poliza
                AND    b.num_spto      = p.num_spto
                AND    b.num_apli      = p.num_apli
                AND    b.num_spto_apli = p.num_spto_apli;

       l_cursordatos cursordatos%ROWTYPE;
    --FIN: FTELLO 16/03/2015
  BEGIN

    -- Buscamos el codigo de asegurado porque ya existe
    SELECT COD_ASEG
    INTO   nCodAseg
    FROM   OIM.RCEN_ASEGURADOS
    WHERE  NRO_DOCUMENTO = p_cNRO_DOCUMENTO
    AND    TIPO_DOC      = p_cTIPO_DOCUMENTO
    AND    ESTADO        = 'A';


    BEGIN
        SELECT 1
        INTO   nDocumento_Movs
        FROM   DUAL
        WHERE  EXISTS ( SELECT 1
                        FROM   SCTR.GESTASEG_DET a, OIM.RCEN_MOVIMIENTOS b
                        WHERE  b.NUM_POLIZA = a.NUM_POLIZA
                        AND    b.NUM_SPTO   = a.NUM_SPTO
                        AND    b.NUM_APLI   = DECODE(a.NUM_APLI,0,1,a.NUM_APLI)
                        AND    a.SEQ_GA     = p_nSEQ_GA
                        AND    b.COD_ASEG   = nCodAseg
                        AND    b.ESTADO     = 'A');
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            nDocumento_Movs := 0;
    END;


    -- Si no esta en la tabla MOVIMIENTOS, insertamos la poliza
    IF nDocumento_Movs = 0 THEN

        --INI: FTELLO 16/03/2015
         /*
         select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 1','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        */
        --COMMIT;

        OPEN cursordatos;
        FETCH cursordatos INTO l_cursordatos;

        BEGIN

         /*
         select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 2','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        --COMMIT;*/

            select NRO_MOVIMIENTO INTO nNro_Mov
            from oim.rcen_aseg0002
            where cod_cia=2
            and cod_ramo= '610'
            and num_poliza = l_cursordatos.NUM_POLIZA
            and num_spto = l_cursordatos.NUM_SPTO
            and num_apli = l_cursordatos.NUM_APLI;
        EXCEPTION
        WHEN NO_DATA_FOUND THEN

         /*   select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 3','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        --COMMIT;*/

            SELECT OIM.SEQ_RCEN_ASEG0001.NEXTVAL INTO nNro_Mov FROM dual;

        /*select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 4','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        --COMMIT;*/
            -- INSERTAR EN LA TABLA DE RCEN_ASEG0001 -- CABECERA DE MOVIMEINTOS
            --select * from oim.rcen_aseg0001
            insert into oim.rcen_aseg0001(
            NRO_MOVIMIENTO,
            TIP_DOCUMENTO,
            NRO_DOCUMENTO,
            FEC_INI_VIG,
            FEC_FIN_VIG,
            TIPO_MOVIMIENTO,
            MCA_FACTURADO,
            MCA_BAJA,
            COD_USR_REG,
            FEC_REG)
            VALUES
            (nNro_Mov
            ,l_cursordatos.TIP_DOCUM
            ,l_cursordatos.COD_DOCUM
            ,l_cursordatos.fec_efec_spto
            ,l_cursordatos.fec_vcto_spto
            ,'DE'
            ,'S'
            ,'N'
            ,NVL (p_cCODIGO_USUARIO, USER)
            ,SYSDATE);

            -- INSERTAR EN LA TABLA DE RCEN_ASEG0002 -- DETALLE DE MOVIMEINTOS
            --SELECT * FROM oim.rcen_aseg0002

        /*   select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 5','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        --COMMIT;*/

            INSERT INTO  oim.rcen_aseg0002
            (NRO_MOVIMIENTO,
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
            VALUES
            (nNro_Mov
            ,2
            ,610
            ,l_cursordatos.NUM_POLIZA
            ,l_cursordatos.NUM_SPTO
            ,l_cursordatos.NUM_APLI
            ,l_cursordatos.NUM_SPTO_APLI
            ,l_cursordatos.NUM_RECIBO
            ,'TRONWEB'
            ,NVL (p_cCODIGO_USUARIO, USER)
            ,SYSDATE);

        END;

        --INSERTAR TRABAJADORES POR VIGENCIA
        --select * from oim.rcen_aseg0004
        /*  select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 6','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        --COMMIT;*/

        INSERT INTO oim.rcen_aseg0004(
        COD_ASEG,
        NRO_MOVIMIENTO,
        COD_CIA,
        COD_RAMO,
        NUM_POLIZA,
        NUM_SPTO,
        NUM_APLI,
        NUM_SPTO_APLI,
        FEC_INI_VIG,
        FEC_FIN_VIG,
        MCA_BAJA,
        SUELDO,
        OCUPACION,
        COD_USR_REG,
        FEC_REG)
        VALUES
        (nCodAseg
        ,nNro_Mov
        ,2
        ,610
        ,l_cursordatos.NUM_POLIZA
        ,l_cursordatos.NUM_SPTO
        ,l_cursordatos.NUM_APLI
        ,l_cursordatos.NUM_SPTO_APLI
        ,l_cursordatos.fec_efec_spto
        ,l_cursordatos.fec_vcto_spto
        ,'N'
        ,p_cSueldo
        ,p_cOCUPACION
        ,NVL (p_cCODIGO_USUARIO, USER)
        ,SYSDATE);

        /*
        select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 7','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        --COMMIT;*/

         BEGIN

        /* select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 8','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        --COMMIT;*/

            select NRO_DOCUMENTO into nSec
            from oim.rcen_aseg0005
            where NRO_MOVIMIENTO = nNro_Mov;
        EXCEPTION
        WHEN NO_DATA_FOUND THEN

            ---INSERTAR EN LA TABLA CABECERA DE CONSTANCIAS
            --select * from oim.rcen_aseg0005

            SELECT sctr.seq_sctr_constancia_id_file.NEXTVAL INTO nSec FROM DUAL;

        /*select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 9','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        --COMMIT;*/

            INSERT INTO oim.rcen_aseg0005
            (NRO_DOCUMENTO,
            NRO_MOVIMIENTO,
            PREFIJO,
            ANIO,
            MCA_BAJA,
            COD_USR_REG,
            FEC_REG)
            VALUES
            (nSec
            ,nNro_Mov
            ,'MP'
            ,to_char (sysdate, 'YYYY')
            ,'N'
            ,NVL (p_cCODIGO_USUARIO, USER)
            ,SYSDATE);

        END;
        --Insertar en la tabla detalle documentos
        --select * from oim.rcen_aseg0006
        /* select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 10','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        --COMMIT;*/

        insert into oim.rcen_aseg0006(
        NRO_DOCUMENTO
        ,NRO_MOVIMIENTO
        ,TIPDOC
        ,NUMDOC
        ,APEPAT
        ,APEMAT
        ,NOMBRES
        ,NOMBRECOMPLETO
        ,FECNAC
        ,SUELDO
        ,OCUPACION
        ,NRO_MOVIMIENTO_REF
        ,MCA_BAJA
        ,COD_USR_REG
        ,FEC_REG
        )
        select nSec,nNro_Mov,
        a.TIPO_DOC,
        a.NRO_DOCUMENTO,
        a.APE_PATERNO,
        a.APE_MATERNO,
        a.PRIMER_NOMBRE,
        a.NOMBRE_COMPLETO,
        to_date(a.FEC_NAC,'dd/mm/yyyy'),
        p_cSueldo,
        p_cOCUPACION,
        nNro_Mov
        ,'N'
        ,NVL (p_cCODIGO_USUARIO, USER)
        ,SYSDATE
        from oim.rcen_asegurados a
        where cod_aseg = nCodAseg;

        --FIN: FTELLO 16/03/2015
        SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL INTO nCodMovs FROM DUAL;


         /*select max(id_error) + 1 into  id_error
         from sctrmineria.log_error;

        insert into sctrmineria.log_error(ID_ERROR,DESCRIPCION,REFERENCIA,COD_APLIC,COD_USUARIO_CREADOR,FEC_CREACION)
        values(id_error,'PASO 11','RCEN_MOVIEMINTOS',1,'FTELLO',SYSDATE);
        --COMMIT;*/

        INSERT INTO OIM.RCEN_MOVIMIENTOS
                   (COD_ASEG, COD_MOVIM, TIP_DOCUM, COD_DOCUM, COD_CIA, COD_RAMO, NUM_POLIZA,
                    NUM_SPTO, NUM_APLI, NUM_SPTO_APLI, FEC_INI_VIG, FEC_FIN_VIG, SIST_ORIG,
                    FEC_ALTA, COD_USUARIO, FEC_CREACION, OCUP_ASEG, COD_MOVIM_SC)
        SELECT  nCodAseg, nCodMovs, t.*
        FROM   (SELECT c.TIP_DOCUM, c.COD_DOCUM, b.COD_CIA, b.COD_RAMO, b.NUM_POLIZA,
                       b.NUM_SPTO, DECODE(b.NUM_APLI,0,1,b.NUM_APLI), DECODE(b.NUM_SPTO_APLI,0,1,b.NUM_SPTO_APLI),
                       p.fec_efec_spto, p.fec_vcto_spto,
                       'TRONWEB', SYSDATE a, NVL (p_cCODIGO_USUARIO, USER),
                       SYSDATE, p_cOCUPACION,nNro_Mov COD_MOVIM_SC
                FROM   SCTR.GESTASEG_DET b,
                       SCTR.GESTASEG_CAB c,
                       SCTR.GESTASEG_RPT_CAB d,
                       TRON2000.A2000030@TRON p
                WHERE  b.SEQ_GA        = p_nSEQ_GA
                AND    c.SEQ_GA        = p_nSEQ_GA
                AND    d.SEQ_GA        = p_nSEQ_GA
                AND    d.SEQ_VE        = p_nSEQ_VE
                --AND    b.id_file = d.SEQ_VE
                AND    c.tip_docum = p.tip_docum
                AND    c.cod_docum = p.cod_docum
                AND    b.cod_cia = p.cod_cia
                AND    b.cod_ramo = p.cod_ramo
                AND    b.num_poliza    = p.num_poliza
                AND    b.num_spto      = p.num_spto
                AND    b.num_apli      = p.num_apli
                AND    b.num_spto_apli = p.num_spto_apli) t;
    END IF;

    p_nRetorno := 1;

  EXCEPTION
    WHEN NO_DATA_FOUND THEN
        p_nRetorno := -1;
        p_cMensaje := SQLERRM;

  END INSERTAR_MOVIMIENTO_VIDALEY;

/*==========================================================================
  PROPOSITO: Cambiar estado
  AUTOR: AROSALES                                          FECHA: 11/10/2013
  --------------------------------------------------------------------------
  DATOS RELEVANTES:

  --------------------------------------------------------------------------
  DESCRIPCION FUNCIONAL:

  ========================================================================*/
  PROCEDURE ESTADO_MOVIMIENTO (
    NUMERO_DOCUMENTO   IN   VARCHAR2,
    TIPO_DOCUMENTO     IN   VARCHAR2,
    CODIGO_USUARIO     IN   VARCHAR2,
    CODIGO             IN   NUMBER,
    EST_MOV            IN   CHAR,
    PROCESO            IN   VARCHAR,
    ACT_SAL            IN   NUMBER,
    ACT_PEN            IN   NUMBER
  )
  IS
    DOCUMENTO_MOVS   NUMBER  := 0;
    DOC_MOVS_SAL     VARCHAR (20);
    DOC_MOVS_PEN     VARCHAR (20);
    CODMOVS          NUMBER;
    NOM_COMPLETO     VARCHAR2 (200 BYTE);
    CODASEG          NUMBER;
    NRO_RUC          VARCHAR2(11);

  BEGIN

    SELECT COD_ASEG
    INTO   CODASEG
    FROM   OIM.RCEN_ASEGURADOS
    WHERE  NRO_DOCUMENTO = NUMERO_DOCUMENTO
    AND    TIPO_DOC = TIPO_DOCUMENTO
    AND    ESTADO = 'A';

    -- COMPROBAMOS QUE TENGA POLIZA DE SALUD Y PENSION
    BEGIN

        IF PROCESO = 'OIM' THEN
            SELECT POLSAL, POLPEN, RUC
            INTO   DOC_MOVS_SAL, DOC_MOVS_PEN, NRO_RUC
            FROM   OIM.SCTR_CONSTANCIA
            WHERE  ID_FILE = CODIGO;
        END IF;

        IF PROCESO = 'SCTR' THEN
            SELECT POLSAL, POLPEN, RUC
            INTO   DOC_MOVS_SAL, DOC_MOVS_PEN, NRO_RUC
            FROM   SCTR.SCTR_CONSTANCIA
            WHERE  ID_FILE = CODIGO;
        END IF;

        IF PROCESO = 'SCTRMIN' THEN
            SELECT POLSAL, POLPEN, RUC
            INTO   DOC_MOVS_SAL, DOC_MOVS_PEN, NRO_RUC
            FROM   SCTRMINERIA.CONSTANCIA
            WHERE  COD_FILE = CODIGO;
        END IF;

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DOC_MOVS_SAL := '0';
            DOC_MOVS_PEN := '0';
    END;


    -- SI TIENE POLIZA DE SALUD VERFICAMOS SI ESTA EN LA TABLA DE MOVIMIENTOS
    IF ACT_SAL = 1 THEN

        IF SUBSTR (DOC_MOVS_SAL, 0, 3) = '702' THEN

            BEGIN
                IF PROCESO = 'OIM' THEN
                    SELECT 1 INTO DOCUMENTO_MOVS
                    FROM   DUAL
                    WHERE  EXISTS ( SELECT 1
                                    FROM   OIM.SCTR_CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                                    WHERE  b.NUM_POLIZA    = a.POLSAL
                                    AND    b.NUM_SPTO      = a.NUM_SPTO_SAL
                                    AND    b.NUM_APLI      = DECODE(a.NUM_APLI_SAL,0,1,a.NUM_APLI_SAL)
                                    AND    b.NUM_SPTO_APLI = DECODE(a.NUM_SPTO_APLI_SAL,0,1,a.NUM_SPTO_APLI_SAL)
                                    AND    a.ID_FILE       = CODIGO
                                    AND    a.RUC           = NRO_RUC
                                    AND    b.COD_ASEG      = CODASEG);
                END IF;

                IF PROCESO = 'SCTR' THEN
                    SELECT 1 INTO DOCUMENTO_MOVS
                    FROM   DUAL
                    WHERE  EXISTS ( SELECT 1
                                    FROM   SCTR.SCTR_CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                                    WHERE  b.NUM_POLIZA    = a.POLSAL
                                    AND    b.NUM_SPTO      = a.NUM_SPTO_SAL
                                    AND    b.NUM_APLI      = DECODE(a.NUM_APLI_SAL,0,1,a.NUM_APLI_SAL)
                                    AND    b.NUM_SPTO_APLI = DECODE(a.NUM_SPTO_APLI_SAL,0,1,a.NUM_SPTO_APLI_SAL)
                                    AND    a.ID_FILE       = CODIGO
                                    AND    a.RUC           = NRO_RUC
                                    AND    b.COD_ASEG      = CODASEG);
                END IF;

                IF PROCESO = 'SCTRMIN' THEN
                    SELECT 1 INTO DOCUMENTO_MOVS
                    FROM   DUAL
                    WHERE  EXISTS ( SELECT 1
                                    FROM   SCTRMINERIA.CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                                    WHERE  b.NUM_POLIZA    = a.POLSAL
                                    AND    b.NUM_SPTO      = a.NUM_SPTO_SAL
                                    AND    b.NUM_APLI      = DECODE(a.NUM_APLI_SAL,0,1,a.NUM_APLI_SAL)
                                    AND    b.NUM_SPTO_APLI = DECODE(a.NUM_SPTO_APLI_SAL,0,1,a.NUM_SPTO_APLI_SAL)
                                    AND    a.COD_FILE      = CODIGO
                                    AND    a.RUC           = NRO_RUC
                                    AND    b.COD_ASEG      = CODASEG);
                END IF;

            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    DOCUMENTO_MOVS := 0;
            END;

        END IF; -- Fin Salud



        --SI EXISTE EL MOVIMIENTO LO PASAMOS A UN ESTADO DE INACTIVO
        IF DOCUMENTO_MOVS = 1 THEN

            SELECT COD_ASEG INTO CODASEG
            FROM   OIM.RCEN_ASEGURADOS
            WHERE  NRO_DOCUMENTO = NUMERO_DOCUMENTO
            AND    TIPO_DOC = TIPO_DOCUMENTO
            AND    ESTADO = 'A';

            BEGIN
                IF PROCESO = 'OIM' THEN
                    UPDATE OIM.RCEN_MOVIMIENTOS x
                    SET    x.ESTADO    = EST_MOV,
                           x.FEC_BAJA  = SYSDATE
                    WHERE  x.COD_ASEG = CODASEG
                      AND  x.COD_MOVIM IN (SELECT COD_MOVIM
                                        FROM   OIM.RCEN_MOVIMIENTOS a, OIM.SCTR_CONSTANCIA b
                                        WHERE  b.ID_FILE       = CODIGO
                                        AND    b.RUC           = NRO_RUC
                                        AND    a.NUM_POLIZA    = b.POLSAL
                                        AND    a.NUM_SPTO      = b.NUM_SPTO_SAL
                                        AND    a.NUM_APLI      = DECODE(b.NUM_APLI_SAL,0,1,b.NUM_APLI_SAL)
                                        AND    a.NUM_SPTO_APLI = DECODE(b.NUM_SPTO_APLI_SAL,0,1,b.NUM_SPTO_APLI_SAL)
                                        AND    a.COD_ASEG      = CODASEG
                                        AND    a.ESTADO        = 'A');
                END IF;

                IF PROCESO = 'SCTR' THEN
                    UPDATE OIM.RCEN_MOVIMIENTOS x
                    SET    x.ESTADO    = EST_MOV,
                           x.FEC_BAJA  = SYSDATE
                    WHERE  x.COD_ASEG = CODASEG
                      AND  x.COD_MOVIM IN (SELECT COD_MOVIM
                                        FROM   OIM.RCEN_MOVIMIENTOS a, SCTR.SCTR_CONSTANCIA b
                                        WHERE  b.ID_FILE       = CODIGO
                                        AND    b.RUC           = NRO_RUC
                                        AND    a.NUM_POLIZA    = b.POLSAL
                                        AND    a.NUM_SPTO      = b.NUM_SPTO_SAL
                                        AND    a.NUM_APLI      = DECODE(b.NUM_APLI_SAL,0,1,b.NUM_APLI_SAL)
                                        AND    a.NUM_SPTO_APLI = DECODE(b.NUM_SPTO_APLI_SAL,0,1,b.NUM_SPTO_APLI_SAL)
                                        AND    a.COD_ASEG      = CODASEG
                                        AND    a.ESTADO        = 'A');
                END IF;

                IF PROCESO = 'SCTRMIN' THEN
                    UPDATE OIM.RCEN_MOVIMIENTOS x
                    SET    x.ESTADO    = EST_MOV,
                           x.FEC_BAJA  = SYSDATE
                    WHERE  x.COD_ASEG = CODASEG
                      AND x.COD_MOVIM IN (SELECT COD_MOVIM
                                        FROM   OIM.RCEN_MOVIMIENTOS a, SCTRMINERIA.CONSTANCIA b
                                        WHERE  b.COD_FILE      = CODIGO
                                        AND    b.RUC           = NRO_RUC
                                        AND    a.NUM_POLIZA    = b.POLSAL
                                        AND    a.NUM_SPTO      = b.NUM_SPTO_SAL
                                        AND    a.NUM_APLI      = DECODE(b.NUM_APLI_SAL,0,1,b.NUM_APLI_SAL)
                                        AND    a.NUM_SPTO_APLI = DECODE(b.NUM_SPTO_APLI_SAL,0,1,b.NUM_SPTO_APLI_SAL)
                                        AND    a.COD_ASEG      = CODASEG
                                        AND    a.ESTADO        = 'A');
                END IF;

            EXCEPTION
              WHEN OTHERS THEN NULL;
                --GRABAMOS EL ERROR EN LA MISMA TABLA DE ASEGURADO (TEMPORAL)
                --REGISTRAR_ERROR (CODASEG, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SQLERRM,
                --                 'ESTADO_MOVIMIENTO1', PROCESO);
            END;

          END IF;

    END IF; -- Fin ACT_SAL



    IF ACT_PEN = 1 THEN
      --SI TIENE POLIZA DE PENSION VERFICAMOS SI ESTA EN LA TABLA DE MOVIMIENTOS

        IF SUBSTR (DOC_MOVS_PEN, 0, 3) = '701' THEN

            BEGIN

                IF PROCESO = 'OIM' THEN
                    SELECT 1 INTO DOCUMENTO_MOVS
                    FROM   DUAL
                    WHERE  EXISTS ( SELECT 1
                                    FROM   OIM.SCTR_CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                                    WHERE  b.NUM_POLIZA    = a.POLPEN
                                    AND    b.NUM_SPTO      = a.NUM_SPTO_PEN
                                    AND    b.NUM_APLI      = DECODE(a.NUM_APLI_PEN,0,1,a.NUM_APLI_PEN)
                                    AND    b.NUM_SPTO_APLI = DECODE(a.NUM_SPTO_APLI_PEN,0,1,a.NUM_SPTO_APLI_PEN)
                                    AND    a.ID_FILE       = CODIGO
                                    AND    a.RUC           = NRO_RUC
                                    AND    b.COD_ASEG      = CODASEG );
                END IF;

                IF PROCESO = 'SCTR' THEN
                    SELECT 1 INTO DOCUMENTO_MOVS
                    FROM   DUAL
                    WHERE  EXISTS ( SELECT 1
                                    FROM   SCTR.SCTR_CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                                    WHERE  b.NUM_POLIZA    = a.POLPEN
                                    AND    b.NUM_SPTO      = a.NUM_SPTO_PEN
                                    AND    b.NUM_APLI      = DECODE(a.NUM_APLI_PEN,0,1,a.NUM_APLI_PEN)
                                    AND    b.NUM_SPTO_APLI = DECODE(a.NUM_SPTO_APLI_PEN,0,1,a.NUM_SPTO_APLI_PEN)
                                    AND    a.ID_FILE       = CODIGO
                                    AND    a.RUC           = NRO_RUC
                                    AND    b.COD_ASEG      = CODASEG );
                END IF;

                IF PROCESO = 'SCTRMIN' THEN
                    SELECT 1 INTO DOCUMENTO_MOVS
                    FROM   DUAL
                    WHERE  EXISTS ( SELECT 1
                            FROM   SCTRMINERIA.CONSTANCIA a, OIM.RCEN_MOVIMIENTOS b
                            WHERE  b.NUM_POLIZA    = a.POLPEN
                            AND    b.NUM_SPTO      = a.NUM_SPTO_PEN
                            AND    b.NUM_APLI      = DECODE(a.NUM_APLI_PEN,0,1,a.NUM_APLI_PEN)
                            AND    b.NUM_SPTO_APLI = DECODE(a.NUM_SPTO_APLI_PEN,0,1,a.NUM_SPTO_APLI_PEN)
                            AND    a.COD_FILE      = CODIGO
                            AND    a.RUC           = NRO_RUC
                            AND    b.COD_ASEG      = CODASEG );
                END IF;

            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    DOCUMENTO_MOVS := 0;
            END;

        END IF;  -- Fin Pension


        --SI EL MOVIMIENTO EXISTE EN LA TABLA
        IF DOCUMENTO_MOVS = 1 THEN

        --ACTUALIZAMOS EL MOVIMIENTO Y LO PASAMOS A UN ESTADO DE INACTIVO

            SELECT COD_ASEG INTO CODASEG
            FROM   OIM.RCEN_ASEGURADOS
            WHERE  NRO_DOCUMENTO = NUMERO_DOCUMENTO
            AND    TIPO_DOC = TIPO_DOCUMENTO
            AND    ESTADO = 'A';

            BEGIN

                IF PROCESO = 'OIM' THEN
                    UPDATE OIM.RCEN_MOVIMIENTOS x
                    SET    x.ESTADO    = EST_MOV,
                           x.FEC_BAJA  = SYSDATE
                    WHERE  x.COD_ASEG = CODASEG
                      AND  x.COD_MOVIM IN  (SELECT COD_MOVIM
                                        FROM   OIM.RCEN_MOVIMIENTOS a, OIM.SCTR_CONSTANCIA b
                                        WHERE  b.ID_FILE       = CODIGO
                                        AND    a.NUM_POLIZA    = b.POLPEN
                                        AND    a.NUM_SPTO      = b.NUM_SPTO_PEN
                                        AND    a.NUM_APLI      = DECODE(b.NUM_APLI_PEN,0,1,b.NUM_APLI_PEN)
                                        AND    a.NUM_SPTO_APLI = DECODE(b.NUM_SPTO_APLI_PEN,0,1,b.NUM_SPTO_APLI_PEN)
                                        AND    a.COD_ASEG      = CODASEG
                                        AND    a.ESTADO        = 'A');
                END IF;

                IF PROCESO = 'SCTR' THEN
                    UPDATE OIM.RCEN_MOVIMIENTOS x
                    SET    x.ESTADO    = EST_MOV,
                           x.FEC_BAJA  = SYSDATE
                    WHERE  x.COD_ASEG = CODASEG
                      AND  x.COD_MOVIM IN  (SELECT COD_MOVIM
                                        FROM   OIM.RCEN_MOVIMIENTOS a, SCTR.SCTR_CONSTANCIA b
                                        WHERE  b.ID_FILE       = CODIGO
                                        AND    a.NUM_POLIZA    = b.POLPEN
                                        AND    a.NUM_SPTO      = b.NUM_SPTO_PEN
                                        AND    a.NUM_APLI      = DECODE(b.NUM_APLI_PEN,0,1,b.NUM_APLI_PEN)
                                        AND    a.NUM_SPTO_APLI = DECODE(b.NUM_SPTO_APLI_PEN,0,1,b.NUM_SPTO_APLI_PEN)
                                        AND    a.COD_ASEG      = CODASEG
                                        AND    a.ESTADO        = 'A');
                END IF;

                IF PROCESO = 'SCTRMIN' THEN
                    UPDATE OIM.RCEN_MOVIMIENTOS x
                    SET    x.ESTADO    = EST_MOV,
                           x.FEC_BAJA  = SYSDATE
                    WHERE  x.COD_ASEG = CODASEG
                      AND  x.COD_MOVIM IN (SELECT COD_MOVIM
                                        FROM   OIM.RCEN_MOVIMIENTOS a, SCTRMINERIA.CONSTANCIA b
                                        WHERE  b.COD_FILE      = CODIGO
                                        AND    a.NUM_POLIZA    = b.POLPEN
                                        AND    a.NUM_SPTO      = b.NUM_SPTO_PEN
                                        AND    a.NUM_APLI      = DECODE(b.NUM_APLI_PEN,0,1,b.NUM_APLI_PEN)
                                        AND    a.NUM_SPTO_APLI = DECODE(b.NUM_SPTO_APLI_PEN,0,1,b.NUM_SPTO_APLI_PEN)
                                        AND    a.COD_ASEG      = CODASEG
                                        AND    a.ESTADO        = 'A');
                END IF;

            EXCEPTION
                WHEN OTHERS THEN null;
                --REGISTRAR_ERROR (CODASEG, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SQLERRM,
                --                 'ESTADO_MOVIMIENTO2', PROCESO);
            END;

        END IF;  -- Fin DOCUMENTO_MOVS Pension

    END IF;  -- Fin ACT_PEN




    IF PROCESO = 'VIDALEY' THEN
        BEGIN
            SELECT 1
            INTO   DOCUMENTO_MOVS
            FROM   DUAL
            WHERE  EXISTS ( SELECT 1
                            FROM   SCTR.GESTASEG_DET a, OIM.RCEN_MOVIMIENTOS b
                            WHERE  b.NUM_POLIZA    = a.NUM_POLIZA
                            AND    b.NUM_SPTO      = a.NUM_SPTO
                            AND    b.NUM_APLI      = DECODE(a.NUM_APLI,0,1,a.NUM_APLI)
                            AND    b.NUM_SPTO_APLI = DECODE(a.NUM_SPTO_APLI,0,1,a.NUM_SPTO_APLI)
                            AND    a.SEQ_GA        = CODIGO
                            AND    b.COD_ASEG      = CODASEG);
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                DOCUMENTO_MOVS := 0;
        END;

        BEGIN
            UPDATE OIM.RCEN_MOVIMIENTOS x
            SET    x.ESTADO    = EST_MOV,
                   x.FEC_BAJA  = SYSDATE
            WHERE  x.COD_ASEG = CODASEG
              AND  x.COD_MOVIM IN  (SELECT COD_MOVIM
                                FROM   OIM.RCEN_MOVIMIENTOS a, SCTR.GESTASEG_DET b
                                WHERE  b.SEQ_GA        = CODIGO
                                AND    a.NUM_POLIZA    = b.NUM_POLIZA
                                AND    a.NUM_SPTO      = b.NUM_SPTO
                                AND    a.NUM_APLI      = DECODE(b.NUM_APLI,0,1,b.NUM_APLI)
                                AND    a.NUM_SPTO_APLI = DECODE(b.NUM_SPTO_APLI,0,1,b.NUM_SPTO_APLI)
                                AND    a.COD_ASEG      = CODASEG
                                AND    a.ESTADO        = 'A');
        EXCEPTION
            WHEN OTHERS THEN NULL;
            --REGISTRAR_ERROR (CODASEG, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SQLERRM,
            --                'ESTADO_MOVIMIENTO2', PROCESO);
        END;

    END IF; -- Fin Vida Ley




  EXCEPTION
        WHEN OTHERS THEN NULL;

  END ESTADO_MOVIMIENTO;

 FUNCTION F_DEVUELVE_SEC
  RETURN NUMBER IS
  ln_nro_mov NUMBER;
 BEGIN
   SELECT OIM.SEQ_INDICE_MOVIMIENTO.NEXTVAL
            INTO ln_nro_mov
            FROM DUAL;
    RETURN ln_nro_mov;
   EXCEPTION
        WHEN OTHERS THEN
          RETURN 0;
 END;

 FUNCTION OBTENER_USUARIO_TRON (
   P_COD_CIA       IN NUMBER,
   P_NUM_POLIZA    IN VARCHAR2,
   P_NUM_SPTO      IN NUMBER,
   P_NUM_APLI      IN NUMBER,
   P_NUM_SPTO_APLI IN NUMBER)
 RETURN VARCHAR2 IS
  cCod_Usr  VARCHAR2(15);
 BEGIN
   SELECT COD_USR INTO cCod_Usr
     FROM tron2000.a2000030@tron
    WHERE COD_CIA    = P_COD_CIA
      AND NUM_POLIZA = P_NUM_POLIZA
      AND NUM_SPTO = P_NUM_SPTO
      AND NUM_APLI = P_NUM_APLI
      AND NUM_SPTO_APLI = P_NUM_SPTO_APLI;

   EXCEPTION
        WHEN OTHERS THEN
          RETURN NULL;
 END;


 /*==========================================================================
  PROPOSITO: Dar de baja a un movimiento de un Asegurado, cuando se anula un movieminto desdes TronWeb
  AUTOR: FTELLO                                          FECHA: 10/09/2014
  --------------------------------------------------------------------------
  DATOS RELEVANTES:

  --------------------------------------------------------------------------
  DESCRIPCION FUNCIONAL:

  ========================================================================*/
  PROCEDURE BAJA_MOVIMIENTO_TRON (
      p_cod_cia         IN       NUMBER,
      p_cod_usr         IN       VARCHAR,
      p_ruc             IN       VARCHAR2,
      p_num_poliza      IN       VARCHAR2,
      p_num_spto        IN       NUMBER,
      p_num_apli        IN       NUMBER,
      p_mum_spto_apli   IN       NUMBER,
      p_tip_emision     IN       VARCHAR2,
      p_cod_spto        IN       NUMBER,
      p_sub_cod_spto      IN     NUMBER,
      p_num_spto_anulado  IN     NUMBER)
      IS
      ln_num_spto NUMBER;
   BEGIN


       IF   SUBSTR(p_num_poliza,1,3) = '701'  OR  SUBSTR(p_num_poliza,1,3) = '702' THEN

        IF p_tip_emision = 'S' AND p_cod_spto = 999 AND p_sub_cod_spto = 1 THEN --> Cuando se va hacer una anulacion de Toda una Contrata.

           /* select max(num_spto) into ln_num_spto
            from a2000030@tron
            where cod_cia = p_cod_cia
            and cod_ramo =  SUBSTR (p_num_poliza, 1, 3)
            and num_poliza= p_num_poliza
            and num_spto < p_num_spto
            and num_apli=0
            and mca_poliza_anulada = 'N'
            and mca_spto_anulado = 'N'
            and mca_provisional = 'N';*/

            update oim.rcen_movimientos
            set estado='I' , fec_baja = sysdate ,cod_usr_baja = p_cod_usr
            where cod_cia =  p_cod_cia
                and cod_ramo = SUBSTR(p_num_poliza,1,3)
                and cod_docum = p_ruc --> ftello 18/02/2015
                and num_poliza =  p_num_poliza
               -- and num_spto =    ln_num_spto
                and ESTADO = 'A';
                --and num_apli =   p_num_apli
                --and num_spto_apli =   p_mum_spto_apli;

        ELSIF p_tip_emision IN ('A', 'U') AND p_cod_spto = 999 AND p_sub_cod_spto = 1 THEN--> Cuanto se hacer una anulacion de Toda una Vigencia coimpleta o Apliccaion.

            update oim.rcen_movimientos set estado='I' , fec_baja = sysdate ,cod_usr_baja = p_cod_usr
              where cod_cia =  p_cod_cia
                and cod_ramo = SUBSTR(p_num_poliza,1,3)
                and cod_docum = p_ruc --> ftello 18/02/2015
                and num_poliza =  p_num_poliza
                and num_spto =  p_num_spto
                and num_apli = p_num_apli
                and ESTADO = 'A';
                --and num_spto_apli =   p_mum_spto_apli;

        ELSIF p_tip_emision IN ('A', 'U') AND p_cod_spto = 999 AND p_sub_cod_spto = 6 THEN--> Cuando se hace una anulacion de de un Movimiento

            update oim.rcen_movimientos set estado='I' , fec_baja = sysdate ,cod_usr_baja = p_cod_usr
              where cod_cia =  p_cod_cia
                and cod_ramo = SUBSTR(p_num_poliza,1,3)
                and cod_docum = p_ruc --> ftello 18/02/2015
                and num_poliza =  p_num_poliza
                and num_spto =    p_num_spto
                and num_apli =   p_num_apli
                and num_spto_apli =  p_num_spto_anulado
                and ESTADO = 'A';

        END IF;
        END IF;

  END BAJA_MOVIMIENTO_TRON;

END;
/

