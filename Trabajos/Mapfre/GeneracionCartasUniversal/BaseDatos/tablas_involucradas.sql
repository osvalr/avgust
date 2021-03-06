CREATE TABLE TRON2000.TA_VU_CARTA_ANIV_CAB

(

  NRO_CARTA_VU              NUMBER(7)           NOT NULL,

  ANIO_CARTA_VU             NUMBER(4)           NOT NULL,

  NUM_POLIZA                NUMBER(13)          NOT NULL,

  NUM_POLIZA_PANAMA         VARCHAR2(15 BYTE),

  FEC_EFECTIVA_VU           DATE,

  FEC_EFECTIVA_EDT_VU       VARCHAR2(40 BYTE),

  NOM_ASEGURADO             VARCHAR2(100 BYTE),

  NOM_CONTRATANTE           VARCHAR2(100 BYTE),

  DIRECCION_CONTRATANTE     VARCHAR2(100 BYTE),

  LOCALIDAD_CONTRATANTE     VARCHAR2(100 BYTE),

  FEC_INI_ANIV_VU           DATE,

  FEC_FIN_ANIV_VU           DATE,

  BENEF_MUER_BAS_1_VU       NUMBER,

  BENEF_MUER_BAS_2_VU       NUMBER,

  VAL_EFEC_ACUM_1_VU        NUMBER,

  VAL_EFEC_ACUM_2_VU        NUMBER,

  VAL_BAL_PRESTAMO_1_VU     NUMBER,

  VAL_BAL_PRESTAMO_2_VU     NUMBER,

  VAL_CARGO_RESCATE_1_VU    NUMBER,

  VAL_CARGO_RESCATE_2_VU    NUMBER,

  VAL_EFECT_CTACTE_1_VU     NUMBER,

  VAL_EFECT_CTACTE_2_VU     NUMBER,

  FEC_SEG_GARAN_FIN_VU      DATE,

  FEC_SEG_GARAN_FIN_EDT_VU  VARCHAR2(40 BYTE),

  FEC_SEG_CORR_FIN_VU       DATE,

  FEC_SEG_CORR_FIN_EDT_VU   VARCHAR2(40 BYTE),

  FEC_ACTU                  DATE                NOT NULL,

  HORA_ACTU                 VARCHAR2(8 BYTE)    NOT NULL,

  MCA_INH                   VARCHAR2(1 BYTE)    NOT NULL,

  COD_USR                   VARCHAR2(8 BYTE)    NOT NULL,

  MCA_ESTADO_REG            VARCHAR2(1 BYTE)    NOT NULL

)

TABLESPACE DATOS_1

PCTUSED    0

PCTFREE    10

INITRANS   1

MAXTRANS   255

STORAGE    (

            INITIAL          64K

            NEXT             1M

            MINEXTENTS       1

            MAXEXTENTS       UNLIMITED

            PCTINCREASE      0

            BUFFER_POOL      DEFAULT

           )

LOGGING

NOCOMPRESS

NOCACHE

NOPARALLEL

MONITORING;

 

 

CREATE UNIQUE INDEX TRON2000.TA_VU_CARTA_ANIV_CAB ON TRON2000.TA_VU_CARTA_ANIV_CAB

(NRO_CARTA_VU)

LOGGING

TABLESPACE INDICES

PCTFREE    10

INITRANS   2

MAXTRANS   255

STORAGE    (

            INITIAL          64K

            NEXT             1M

            MINEXTENTS       1

            MAXEXTENTS       UNLIMITED

            PCTINCREASE      0

            BUFFER_POOL      DEFAULT

           )

NOPARALLEL;

 

 

DROP PUBLIC SYNONYM TA_VU_CARTA_ANIV_CAB;

 

CREATE PUBLIC SYNONYM TA_VU_CARTA_ANIV_CAB FOR TRON2000.TA_VU_CARTA_ANIV_CAB;

 

 

ALTER TABLE TRON2000.TA_VU_CARTA_ANIV_CAB ADD (

  CONSTRAINT PK_TA_VU_CARTA_ANIV_CAB

PRIMARY KEY

(NRO_CARTA_VU));

 

GRANT SELECT ON TRON2000.TA_VU_CARTA_ANIV_CAB TO PUBLIC WITH GRANT OPTION;

GRANT DELETE, INSERT, REFERENCES, UPDATE ON TRON2000.TA_VU_CARTA_ANIV_CAB TO PUBLIC;

 

-----

-----

 

CREATE TABLE TRON2000.TA_VU_CARTA_ANIV_DET

(

  NRO_CARTA_VU            NUMBER(7)             NOT NULL,

  NRO_CARTA_SEC_VU        NUMBER(2)             NOT NULL,

  FEC_DETALLE_VU          DATE,

  VAL_PRIMA_INGRESADA_VU  NUMBER,

  VAL_CARGO_ADM_VU        NUMBER,

  VAL_COSTO_SEGURO_VU     NUMBER,

  VAL_INTERES_VU          NUMBER,

  PCT_INTERES_VU          NUMBER,

  VAL_RESCATE_PARCIAL_VU  NUMBER

)

TABLESPACE DATOS_1

PCTUSED    0

PCTFREE    10

INITRANS   1

MAXTRANS   255

STORAGE    (

            INITIAL          64K

            NEXT             1M

            MINEXTENTS       1

            MAXEXTENTS       UNLIMITED

            PCTINCREASE      0

            BUFFER_POOL      DEFAULT

           )

LOGGING

NOCOMPRESS

NOCACHE

NOPARALLEL

MONITORING;

 

 

CREATE UNIQUE INDEX TRON2000.TA_VU_CARTA_ANIV_DET ON TRON2000.TA_VU_CARTA_ANIV_DET

(NRO_CARTA_VU, NRO_CARTA_SEC_VU)

LOGGING

TABLESPACE INDICES

PCTFREE    10

INITRANS   2

MAXTRANS   255

STORAGE    (

            INITIAL          64K

            NEXT             1M

            MINEXTENTS       1

            MAXEXTENTS       UNLIMITED

            PCTINCREASE      0

            BUFFER_POOL      DEFAULT

           )

NOPARALLEL;

 

 

DROP PUBLIC SYNONYM TA_VU_CARTA_ANIV_DET;

 

CREATE PUBLIC SYNONYM TA_VU_CARTA_ANIV_DET FOR TRON2000.TA_VU_CARTA_ANIV_DET;

 

 

ALTER TABLE TRON2000.TA_VU_CARTA_ANIV_DET ADD (

  CONSTRAINT PK_TA_VU_CARTA_ANIV_DET

PRIMARY KEY

(NRO_CARTA_VU, NRO_CARTA_SEC_VU));

 

GRANT SELECT ON TRON2000.TA_VU_CARTA_ANIV_DET TO PUBLIC WITH GRANT OPTION;

GRANT DELETE, INSERT, REFERENCES, UPDATE ON TRON2000.TA_VU_CARTA_ANIV_DET TO PUBLIC;

 