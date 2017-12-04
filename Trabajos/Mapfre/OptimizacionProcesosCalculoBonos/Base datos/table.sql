CREATE TABLE TRON2000.MP_GENBDPB_2015_MPE
(
  NP                 VARCHAR2(13 BYTE)          NOT NULL,
  MOD                VARCHAR2(3 BYTE),
  COD_MONEDA         NUMBER(2),
  INT_TECNICO        NUMBER,
  EXCESO_IT          NUMBER,
  SEXO               VARCHAR2(1 BYTE),
  FEFECTO            VARCHAR2(8 BYTE),
  TARADO             VARCHAR2(1 BYTE),
  PORSOBRE           NUMBER,
  SOBREENF           NUMBER,
  SOBREPRO           NUMBER,
  X                  NUMBER(3),
  M                  NUMBER(2),
  FP                 NUMBER(1),
  T                  NUMBER(3)                  NOT NULL,
  C                  NUMBER,
  CM                 NUMBER,
  RES_BAL_PO         NUMBER,
  RESBONO            NUMBER,
  PESOTESO           NUMBER,
  RENT_TOTAL         NUMBER,
  PU_X_MIL           NUMBER,
  BONO_ANUAL         NUMBER,
  BONO_ACUM          NUMBER,
  NUM_SILVIA         VARCHAR2(8 BYTE),
  MCA_CAMBIO_FP      VARCHAR2(1 BYTE),
  NOM_TABLA_MORT_H1  VARCHAR2(20 BYTE),
  NOM_TABLA_MORT_H2  VARCHAR2(20 BYTE),
  NOM_TABLA_MORT_H3  VARCHAR2(20 BYTE),
  NOM_TABLA_MORT_M1  VARCHAR2(20 BYTE),
  NOM_TABLA_MORT_M2  VARCHAR2(20 BYTE),
  NOM_TABLA_MORT_M3  VARCHAR2(20 BYTE),
  PCT_GASTOS_INT     NUMBER,
  PCT_GASTOS_EXT     NUMBER,
  ANIO               NUMBER,
  MCA_SALD           VARCHAR2(1 BYTE),
  FEC_SALD           DATE,
  MCA_PRES           VARCHAR2(1 BYTE),
  SAL_PRES           NUMBER(10,2),
  FEC_PRES           DATE,
  PCOM               VARCHAR2(13 BYTE)
)
TABLESPACE DATOS
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE TRON2000.MP_GENBDPB_2015_MPE ADD (
  PRIMARY KEY
 (NP, T)
    USING INDEX 
    TABLESPACE DATOS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                FREELISTS        1
                FREELIST GROUPS  1
               ));

GRANT SELECT ON TRON2000.MP_GENBDPB_2015_MPE TO NEWSILVIA;
