ALTER TABLE TRON2000.MP_GENBDPB_MPE ADD MCA_SALD varchar2(1);
ALTER TABLE TRON2000.MP_GENBDPB_MPE ADD FEC_SALD date;
ALTER TABLE TRON2000.MP_GENBDPB_MPE ADD MCA_PRES varchar2(1);
ALTER TABLE TRON2000.MP_GENBDPB_MPE ADD SAL_PRES number(10,2);
ALTER TABLE TRON2000.MP_GENBDPB_MPE ADD FEC_PRES date;
ALTER TABLE TRON2000.MP_GENBDPB_MPE ADD PCOM varchar2(13);

CREATE TABLE TRON2000.TA_HIST_POL_SALD
(

  NUM_POLIZA  VARCHAR2(100),
  FEC_SALD    DATE,
  FEC_CAL     DATE,
  BAL_CAL     NUMBER(10,2)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
NOMONITORING;

CREATE TABLE TRON2000.TA_MESES_RENT_PESO
(
  NUM_MES          NUMBER(10),
  MESES_RENTABLES  NUMBER(10,1),
  TOTAL_MESES      NUMBER(10)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
NOMONITORING;


ALTER TABLE TRON2000.TA_MESES_RENT_PESO ADD (
  CONSTRAINT TA_MESES_RENT_PESO_PK
 PRIMARY KEY
 (NUM_MES, MESES_RENTABLES));