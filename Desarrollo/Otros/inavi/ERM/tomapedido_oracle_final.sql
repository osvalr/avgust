
/* Drop Tables */


DROP public SYNONYM tb_batch_process;
DROP public SYNONYM SEQ_tb_batch_process_info;
DROP public SYNONYM tb_batch_process_user;
DROP public  SYNONYM tb_user_info;
DROP public  SYNONYM tb_customer;
DROP public  SYNONYM tb_delivery_address;
DROP public  SYNONYM tb_condition_sale;
DROP public  SYNONYM tb_currency;
DROP public  SYNONYM tb_product_price;
DROP public  SYNONYM tb_price_list;
DROP public  SYNONYM tb_product;
DROP public  SYNONYM tb_condition_sale_ud;
DROP public  SYNONYM tb_customer_ud;
DROP public  SYNONYM tb_delivery_address_ud;
DROP public  SYNONYM tb_currency_ud;
DROP public  SYNONYM tb_price_list_ud;
DROP public  SYNONYM tb_product_price_ud;
DROP public  SYNONYM tb_product_ud;

DROP public  SYNONYM tb_zone;
DROP public  SYNONYM tb_zone_stage;
DROP public  SYNONYM tb_zone_ud;
DROP public  SYNONYM tb_ddl_info;


DROP public SYNONYM SEQ_tb_batch_process;
DROP public SYNONYM SEQ_tb_condition_sale;
DROP public SYNONYM SEQ_tb_customer;
DROP public SYNONYM SEQ_tb_delivery_address;
DROP public SYNONYM SEQ_tb_currency;
DROP public SYNONYM SEQ_tb_price_list;
DROP public SYNONYM SEQ_tb_product_price;
DROP public SYNONYM SEQ_tb_product;
DROP public SYNONYM SEQ_tb_zone;




DROP TABLE tambos.tb_batch_process CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_user_info CASCADE CONSTRAINTS;

DROP TABLE tambos.tb_customer CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_delivery_address CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_condition_sale CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_currency CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product_price CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_price_list CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_batch_process_info CASCADE CONSTRAINTS;

DROP TABLE tambos.tb_condition_sale_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_customer_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_delivery_address_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_currency_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_price_list_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product_price_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_batch_process_user CASCADE CONSTRAINTS;

DROP TABLE tambos.tb_condition_sale_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_customer_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_delivery_address_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_currency_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_price_list_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product_price_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product_stage CASCADE CONSTRAINTS;

DROP TABLE tambos.tb_zone CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_zone_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_zone_ud CASCADE CONSTRAINTS;

/* Drop Sequences */

DROP SEQUENCE tambos.SEQ_tb_batch_process;
DROP SEQUENCE tambos.SEQ_tb_batch_process_info;
DROP SEQUENCE tambos.SEQ_tb_condition_sale;
DROP SEQUENCE tambos.SEQ_tb_customer;
DROP SEQUENCE tambos.SEQ_tb_delivery_address;
DROP SEQUENCE tambos.SEQ_tb_currency;
DROP SEQUENCE tambos.SEQ_tb_price_list;
DROP SEQUENCE tambos.SEQ_tb_product_price;
DROP SEQUENCE tambos.SEQ_tb_product;
DROP SEQUENCE SEQ_tb_zone;

/* Create Sequences */

CREATE SEQUENCE tambos.SEQ_tb_batch_process INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE tambos.SEQ_tb_batch_process_info INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE tambos.SEQ_tb_condition_sale INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE tambos.SEQ_tb_customer INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE tambos.SEQ_tb_delivery_address INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE tambos.SEQ_tb_currency INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE tambos.SEQ_tb_price_list INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE tambos.SEQ_tb_product_price INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE tambos.SEQ_tb_product INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_tb_zone INCREMENT BY 1 START WITH 1;

/*Temporales */

CREATE GLOBAL TEMPORARY TABLE tambos.tb_condition_sale_stage
(
	conditionSaleCode varchar2(500),
	conditionSaleName varchar2(500),
	rowSerial varchar2(1000)
);

CREATE GLOBAL TEMPORARY TABLE tambos.tb_customer_stage
(
	customerCode varchar2(500),
	businessName varchar2(500),
	customerDocument varchar2(500),
	customerRuc varchar2(500),
	customerAddress varchar2(500),
	numOrder number(10,0),
	rowSerial varchar2(1000)
);

CREATE GLOBAL TEMPORARY TABLE tambos.tb_delivery_address_stage
(
	customerCode varchar2(500),
	zoneCode varchar2(500),
	addressCode varchar2(500),
	address varchar2(500),
	addressDefault varchar2(500),
	rowSerial varchar2(1000)
);

CREATE GLOBAL TEMPORARY TABLE tambos.tb_currency_stage
(
	currencyCode varchar2(500),
	currencyName varchar2(500),
	currencySymbol varchar2(500),
	rowSerial varchar2(1000)
);

CREATE GLOBAL TEMPORARY TABLE tambos.tb_price_list_stage
(
	priceListCode varchar2(500),
	description varchar2(500),
	rowSerial varchar2(1000)
);

CREATE GLOBAL TEMPORARY TABLE tambos.tb_product_price_stage
(
	productCode varchar2(500),
	priceListCode varchar2(500),
	price number(10,4),
	rowSerial varchar2(1000)
);

CREATE GLOBAL TEMPORARY TABLE tambos.tb_product_stage
(
	productCode varchar2(500),
	productName varchar2(500),
	unitMaintenance varchar2(500),
	unitPresentation number(10,0),
	productType varchar2(10),
	rowSerial varchar2(1000)
);

CREATE GLOBAL TEMPORARY TABLE tambos.tb_zone_stage
(
	zoneCode varchar2(500),
	zoneName varchar2(500),
	visitDay number(10,0),
	sellerCode varchar2(500),
	rowSerial varchar2(1000)
);

/*Fin Temporales */

/* Tablas de usuarios */

CREATE TABLE tambos.tb_user_info
(
	userName varchar2(500),
	deviceId varchar2(500),
	deviceName varchar2(1000),
	dateSync date,
	appVersion number(10,0),
	PRIMARY KEY (userName, deviceId)
);

CREATE TABLE tambos.tb_condition_sale_ud
(
	conditionSaleId number(10,0) NOT NULL,
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	rowSerial varchar2(1000),
	conditionSaleCode varchar2(500),
	newEntry number(2,0) NOT NULL,
	updatedRecord number(2,0) NOT NULL,
	removedRecord number(2,0) NOT NULL,
	modificationDate date,
	PRIMARY KEY (conditionSaleId, userName, deviceId)
);


CREATE TABLE tambos.tb_customer_ud
(
	customerId number(10,0) NOT NULL,
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	customerCode varchar2(500),
	rowSerial varchar2(1000),
	newEntry number(2,0) NOT NULL,
	updatedRecord number(2,0) NOT NULL,
	removedRecord number(2,0) NOT NULL,
	modificationDate date,
	PRIMARY KEY (customerId, userName, deviceId)
);

CREATE TABLE tambos.tb_delivery_address_ud
(
	deliveryAddressId number(10,0) NOT NULL,
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	customerCode varchar2(500),
	zoneCode varchar2(500),
	addressCode varchar2(500),
	rowSerial varchar2(1000),
	newEntry number(2,0) NOT NULL,
	updatedRecord number(2,0) NOT NULL,
	removedRecord number(2,0) NOT NULL,
	modificationDate date,
	PRIMARY KEY (deliveryAddressId, userName, deviceId)
);


CREATE TABLE tambos.tb_currency_ud
(
	currencyId number(10,0) NOT NULL,
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	currencyCode varchar2(500),
	rowSerial varchar2(1000),
	newEntry number(2,0) NOT NULL,
	updatedRecord number(2,0) NOT NULL,
	removedRecord number(2,0) NOT NULL,
	modificationDate date,
	PRIMARY KEY (currencyId, userName, deviceId)
);

CREATE TABLE tambos.tb_price_list_ud
(
	priceListId number(10,0) NOT NULL,
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	priceListCode varchar2(500),
	rowSerial varchar2(1000),
	newEntry number(2,0) NOT NULL,
	updatedRecord number(2,0) NOT NULL,
	removedRecord number(2,0) NOT NULL,
	modificationDate date,
	PRIMARY KEY (priceListId, userName, deviceId)
);

CREATE TABLE tambos.tb_product_price_ud
(
	productPriceId number(10,0) NOT NULL,
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	productCode varchar2(500),
	priceListCode varchar2(500),
	rowSerial varchar2(1000),
	newEntry number(2,0) NOT NULL,
	updatedRecord number(2,0) NOT NULL,
	removedRecord number(2,0) NOT NULL,
	modificationDate date,
	PRIMARY KEY (productPriceId, userName, deviceId)
);


CREATE TABLE tambos.tb_product_ud
(
	productId number(10,0) NOT NULL,
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	productCode varchar2(500),
	rowSerial varchar2(1000),
	newEntry number(2,0) NOT NULL,
	updatedRecord number(2,0) NOT NULL,
	removedRecord number(2,0) NOT NULL,
	modificationDate date,
	PRIMARY KEY (productId, userName, deviceId)
);

CREATE TABLE tambos.tb_zone_ud
(
	zoneId number(10,0) NOT NULL,
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	zoneCode varchar2(500),
	rowSerial varchar2(1000),
	newEntry number(2,0) NOT NULL,
	updatedRecord number(2,0) NOT NULL,
	removedRecord number(2,0) NOT NULL,
	modificationDate date,
	PRIMARY KEY (zoneId, userName, deviceId)
);

CREATE TABLE tambos.tb_batch_process_user
(
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	batchProcessId number(10,0) NOT NULL,
	recordDate date,
	status number(10,0),
	PRIMARY KEY (userName, deviceId, batchProcessId)
);

/* fin Tablas de usuarios */

/* Principales */

CREATE TABLE tambos.tb_batch_process
(
	batchProcessId number(10,0) NOT NULL,
	batchProcessDate date,
	status number(10,0),
	userManaged varchar2(100),
	machineName varchar2(100),
	removeTables number(10,0),
	PRIMARY KEY (batchProcessId)
);


CREATE TABLE tambos.tb_condition_sale
(
	conditionSaleId number(10,0) NOT NULL,
	conditionSaleCode varchar2(500),
	conditionSaleName varchar2(500),
	rowSerial varchar2(1000),
	modificationDate date,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (conditionSaleId)
);


CREATE TABLE tambos.tb_customer
(
	customerId number(10,0) NOT NULL,
	customerCode varchar2(500),
	businessName varchar2(500),
	customerDocument varchar2(500),
	customerRuc varchar2(500),
	customerAddress varchar2(500),
	numOrder number(10,0),
	rowSerial varchar2(1000),
	modificationDate date,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (customerId)
);

CREATE TABLE tambos.tb_delivery_address
(
	deliveryAddressId number(10,0) NOT NULL,
	customerCode varchar2(500),
	zoneCode varchar2(500),
	addressCode varchar2(500),
	address varchar2(500),
	addressDefault varchar2(500),
	rowSerial varchar2(1000),
	modificationDate date,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (deliveryAddressId)
);

CREATE TABLE tambos.tb_currency
(
	currencyId number(10,0) NOT NULL,
	currencyCode varchar2(500),
	currencyName varchar2(500),
	currencySymbol varchar2(500),
	rowSerial varchar2(1000),
	modificationDate date,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (currencyId)
);

CREATE TABLE tambos.tb_price_list
(
	priceListId number(10,0) NOT NULL,
	priceListCode varchar2(500),
	description varchar2(500),
	rowSerial varchar2(1000),
	modificationDate date,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (priceListId)
);

CREATE TABLE tambos.tb_product
(
	productId number(10,0) NOT NULL,
	productCode varchar2(500),
	productName varchar2(500),
	unitMaintenance varchar2(500),
	unitPresentation number(10,0),
	productType varchar2(10),
	rowSerial varchar2(1000),
	modificationDate date,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (productId)
);


CREATE TABLE tambos.tb_product_price
(
	productPriceId number(10,0) NOT NULL,
	productCode varchar2(500),
	priceListCode varchar2(500),
	price number(10,4),
	rowSerial varchar2(1000),
	modificationDate date,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (productPriceId)
);

CREATE TABLE tambos.tb_zone
(
	zoneId number(10,0) NOT NULL,
	zoneCode varchar2(500),
	zoneName varchar2(500),
	visitDay number(10,0),
	sellerCode varchar2(500),
	rowSerial varchar2(1000),
	modificationDate date,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (zoneId)
);

CREATE TABLE tambos.tb_batch_process_info
(
	batchProcessInfoId number(10,0) NOT NULL,
	batchProcessId number(10,0) NOT NULL,
	tableName varchar2(500),
	tableNameAlter varchar2(500),
	insertedRows number(10,0),
	updatedRows number(10,0),
	deletedRows number(10,0),
	PRIMARY KEY (batchProcessInfoId)
);

CREATE TABLE tambos.tb_ddl_info
(
	id_ddl_info number(10,0) NOT NULL,
	sql_ddl clob,
	userManaged varchar2(100),
	modificationDate date,
	PRIMARY KEY (id_ddl_info)
);

/* Create Foreign Keys */

ALTER TABLE tambos.tb_batch_process_info
	ADD FOREIGN KEY (batchProcessId)
	REFERENCES tambos.tb_batch_process (batchProcessId)
;


ALTER TABLE tambos.tb_batch_process_user
	ADD FOREIGN KEY (batchProcessId)
	REFERENCES tambos.tb_batch_process (batchProcessId)
;


ALTER TABLE tambos.tb_batch_process_user
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;


ALTER TABLE tambos.tb_condition_sale_ud
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;


ALTER TABLE tambos.tb_customer_ud
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;


ALTER TABLE tambos.tb_delivery_address_ud
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;


ALTER TABLE tambos.tb_currency_ud
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;


ALTER TABLE tambos.tb_price_list_ud
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;


ALTER TABLE tambos.tb_product_price_ud
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;


ALTER TABLE tambos.tb_product_ud
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;

CREATE public SYNONYM tb_batch_process FOR tambos.tb_batch_process;
CREATE public SYNONYM tb_batch_process_info FOR tambos.tb_batch_process_info;
CREATE public SYNONYM tb_batch_process_user FOR tambos.tb_batch_process_user;
CREATE public SYNONYM tb_condition_sale FOR tambos.tb_condition_sale;
CREATE public SYNONYM tb_condition_sale_ud FOR tambos.tb_condition_sale_ud;
CREATE public SYNONYM tb_customer FOR tambos.tb_customer;
CREATE public SYNONYM tb_customer_ud FOR tambos.tb_customer_ud;
CREATE public SYNONYM tb_delivery_address FOR tambos.tb_delivery_address;
CREATE public SYNONYM tb_delivery_address_ud FOR tambos.tb_delivery_address_ud;
CREATE public SYNONYM tb_currency FOR tambos.tb_currency;
CREATE public SYNONYM tb_currency_ud FOR tambos.tb_currency_ud;
CREATE public SYNONYM tb_price_list FOR tambos.tb_price_list;
CREATE public SYNONYM tb_price_list_ud FOR tambos.tb_price_list_ud;
CREATE public SYNONYM tb_product FOR tambos.tb_product;
CREATE public SYNONYM tb_product_price FOR tambos.tb_product_price;
CREATE public SYNONYM tb_product_price_ud FOR tambos.tb_product_price_ud;
CREATE public SYNONYM tb_product_ud FOR tambos.tb_product_ud;
CREATE public SYNONYM tb_user_info FOR tambos.tb_user_info;

CREATE public SYNONYM tb_zone FOR tambos.tb_zone;
CREATE public SYNONYM tb_zone_stage FOR tambos.tb_zone_stage;
CREATE public SYNONYM tb_zone_ud FOR tambos.tb_zone_ud;
CREATE public SYNONYM tb_ddl_info FOR tambos.tb_ddl_info;

CREATE public SYNONYM SEQ_tb_batch_process FOR tambos.SEQ_tb_batch_process;
CREATE public SYNONYM SEQ_tb_condition_sale FOR tambos.SEQ_tb_condition_sale;
CREATE public SYNONYM SEQ_tb_customer FOR tambos.SEQ_tb_customer;
CREATE public SYNONYM SEQ_tb_delivery_address FOR tambos.SEQ_tb_delivery_address;
CREATE public SYNONYM SEQ_tb_currency FOR tambos.SEQ_tb_currency;
CREATE public SYNONYM SEQ_tb_price_list FOR tambos.SEQ_tb_price_list;
CREATE public SYNONYM SEQ_tb_product_price FOR tambos.SEQ_tb_product_price;
CREATE public SYNONYM SEQ_tb_product FOR tambos.SEQ_tb_product;
CREATE public SYNONYM SEQ_tb_zone FOR tambos.SEQ_tb_zone;







