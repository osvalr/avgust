CREATE TABLE TRON2000.TA_VU_CARTA_PROPERTY
(
  NRO_PROPERTY    NUMBER(10)                    NOT NULL,
  INDEX_PROPERTY  NUMBER(10),
  NAME_PROPERTY   VARCHAR2(500),
  TYPE_PROPERTY   NUMBER(1),
  DATA_TYPE       NUMBER(1),
  FORMAT_DATE     VARCHAR2(100),
  COD_USR         VARCHAR2(500),
  FEC_ACTU        DATE
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
NOMONITORING;


ALTER TABLE TRON2000.TA_VU_CARTA_PROPERTY ADD (
  CONSTRAINT TA_VU_CARTA_PROPERTY_PK
 PRIMARY KEY
 (NRO_PROPERTY));
 
 CREATE SEQUENCE TRON2000.SEQ_VU_CARTA_PROPERTY
  START WITH 1
  MAXVALUE 9999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  NOCACHE
  NOORDER;
  
  GRANT SELECT, INSERT, UPDATE, DELETE ON TA_VU_CARTA_PROPERTY TO TRON2000;
  
CREATE TABLE TRON2000.TA_VU_CARTA_TEXT_LABEL
(
  NRO_TEXT_LABEL  NUMBER(10)                    NOT NULL,
  TEXT_LABEL      VARCHAR2(4000),
  COD_USR         VARCHAR2(500),
  FEC_ACTU        DATE
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
NOMONITORING;


ALTER TABLE TRON2000.TA_VU_CARTA_TEXT_LABEL ADD (
  CONSTRAINT TA_VU_CARTA_TEXT_LABEL_PK
 PRIMARY KEY
 (NRO_TEXT_LABEL));
 
CREATE SEQUENCE TRON2000.SEQ_VU_CARTA_TEXT_LABEL
  START WITH 1
  MAXVALUE 9999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  NOCACHE
  NOORDER;

  GRANT SELECT, INSERT, UPDATE, DELETE ON TA_VU_CARTA_TEXT_LABEL TO TRON2000;
 
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,0,'fechaFinaliza',1,4,'dd/MM/yyyy','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,1,'numeroPoliza',1,3,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,2,'fechaDesde',1,4,'dd/MM/yyyy','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,3,'fechaHasta',1,4,'dd/MM/yyyy','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,4,'fechaEfectiva',1,4,'dd/MM/yyyy','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,5,'beneficioMuerteBasico1',1,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,6,'beneficioMuerteBasico2',1,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,7,'asegurado',1,3,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,8,'agente',1,3,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,9,'valorEfectivoAcumulado1',1,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,10,'valorEfectivoAcumulado2',1,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,11,'balancePrestamo1',1,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,12,'balancePrestamo2',1,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,13,'cargosRescate1',1,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,14,'cargosRescate2',1,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,15,'valorEfectivoCorriente1',1,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,16,'valorEfectivoCorriente2',1,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,0,'fechaAnterior',2,4,'dd/MM/yyyy','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,1,'primaIngresada',2,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,2,'cargoAdministrativo',2,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,3,'costoSeguro',2,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,4,'interesMonto',2,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,5,'interesPorcentaje',2,2,NULL,'TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_PROPERTY(NRO_PROPERTY,INDEX_PROPERTY,NAME_PROPERTY,TYPE_PROPERTY,DATA_TYPE,FORMAT_DATE,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_PROPERTY.nextval,6,'rescateParcialPrestamo',2,2,NULL,'TRON2000',CURRENT_DATE);

insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'Reporte anual de a[n]o/aniversario que finaliza el :','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'N[u]mero de Poliza :','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'Desde:','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'Hasta:','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'Beneficio de Muerte B[a]sico :','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'Fecha Efectiva :','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'Asegurado :','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'Agente :','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'Valor Efectivo Acumulado :','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'( Menos ) Balance de Pr[e]stamo :','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'( Menos ) Cargos por Rescate :','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'Valor Efectivo Corriente :','TRON2000',CURRENT_DATE);
insert into TRON2000.TA_VU_CARTA_TEXT_LABEL(NRO_TEXT_LABEL,TEXT_LABEL,COD_USR,FEC_ACTU) values (TRON2000.SEQ_VU_CARTA_TEXT_LABEL.nextval,'Resumen de Actividades de A[n]o-Aniversario que finaliza el','TRON2000',CURRENT_DATE);

commit;