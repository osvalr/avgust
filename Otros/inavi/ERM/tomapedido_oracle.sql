
/* Drop Triggers */

DROP TRIGGER TRI_tb_zone_zoneId;



/* Drop Tables */

DROP TABLE tb_zone CASCADE CONSTRAINTS;
DROP TABLE tb_zone_stage CASCADE CONSTRAINTS;
DROP TABLE tb_zone_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_batch_process_info CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_batch_process_user CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_batch_process CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_condition_sale CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_condition_sale_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_condition_sale_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_currency CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_currency_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_currency_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_customer CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_customer_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_customer_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_ddl_info CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_delivery_address CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_delivery_address_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_delivery_address_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_price_list CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_price_list_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_price_list_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product_price CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product_price_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product_price_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product_stage CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_product_ud CASCADE CONSTRAINTS;
DROP TABLE tambos.tb_user_info CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_tb_batch_process_batchProcessId;
DROP SEQUENCE SEQ_tb_condition_sale_conditionSaleId;
DROP SEQUENCE SEQ_tb_customer_customerId;
DROP SEQUENCE SEQ_tb_delivery_address_deliveryAddressId;
DROP SEQUENCE SEQ_tb_exchange_currencyId;
DROP SEQUENCE SEQ_tb_price_list_priceListId;
DROP SEQUENCE SEQ_tb_product_price_productPriceId;
DROP SEQUENCE SEQ_tb_product_productId;
DROP SEQUENCE SEQ_tb_zone_zoneId;




/* Create Sequences */

CREATE SEQUENCE SEQ_tb_batch_process_batchProcessId INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_tb_condition_sale_conditionSaleId INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_tb_customer_customerId INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_tb_delivery_address_deliveryAddressId INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_tb_exchange_currencyId INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_tb_price_list_priceListId INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_tb_product_price_productPriceId INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_tb_product_productId INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_tb_zone_zoneId INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE tb_zone
(
	zoneId number(10,0) NOT NULL,
	zoneCode varchar2(500),
	zoneName varchar2(500),
	visitDay number(10,0),
	sellerCode varchar2(500),
	rowSerial varchar2(1000),
	modificationDate timestamp with local time zone,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (zoneId)
);


CREATE TABLE tb_zone_stage
(
	zoneCode varchar2(500),
	zoneName varchar2(500),
	visitDay number(10,0),
	sellerCode varchar2(500),
	rowSerial varchar2(1000)
);


CREATE TABLE tb_zone_ud
(
	zoneId number(10,0) NOT NULL,
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	zoneCode varchar2(500),
	rowSerial varchar2(1000),
	newEntry number(2,0) NOT NULL,
	updatedRecord number(2,0) NOT NULL,
	removedRecord number(2,0) NOT NULL,
	modificationDate timestamp with local time zone,
	PRIMARY KEY (zoneId, userName, deviceId)
);


CREATE TABLE tambos.tb_batch_process
(
	batchProcessId number(10,0) NOT NULL,
	batchProcessDate timestamp with local time zone,
	status number(10,0),
	userManaged varchar2(100),
	machineName varchar2(100),
	removeTables number(2,0),
	PRIMARY KEY (batchProcessId)
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


CREATE TABLE tambos.tb_batch_process_user
(
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	batchProcessId number(10,0) NOT NULL,
	recordDate timestamp with local time zone,
	status number(10,0),
	PRIMARY KEY (userName, deviceId, batchProcessId)
);


CREATE TABLE tambos.tb_condition_sale
(
	conditionSaleId number(10,0) NOT NULL,
	conditionSaleCode varchar2(500),
	conditionSaleName varchar2(500),
	rowSerial varchar2(1000),
	modificationDate timestamp with local time zone,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (conditionSaleId)
);


CREATE TABLE tambos.tb_condition_sale_stage
(
	conditionSaleCode varchar2(500),
	conditionSaleName varchar2(500),
	rowSerial varchar2(1000)
);


CREATE TABLE tambos.tb_condition_sale_ud
(
	conditionSaleId number(10,0) NOT NULL,
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	conditionSaleCode varchar2(500),
	rowSerial varchar2(1000),
	newEntry number(2,0) NOT NULL,
	updatedRecord number(2,0) NOT NULL,
	removedRecord number(2,0) NOT NULL,
	modificationDate timestamp with local time zone,
	PRIMARY KEY (conditionSaleId, userName, deviceId)
);


CREATE TABLE tambos.tb_currency
(
	currencyId number(10,0) NOT NULL,
	currencyCode varchar2(500),
	currencyName varchar2(500),
	currencySymbol varchar2(500),
	rowSerial varchar2(1000),
	modificationDate timestamp with local time zone,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (currencyId)
);


CREATE TABLE tambos.tb_currency_stage
(
	currencyCode varchar2(500),
	currencyName varchar2(500),
	currencySymbol varchar2(500),
	rowSerial varchar2(1000)
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
	modificationDate timestamp with local time zone,
	PRIMARY KEY (currencyId, userName, deviceId)
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
	modificationDate timestamp with local time zone,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (customerId)
);


CREATE TABLE tambos.tb_customer_stage
(
	customerCode varchar2(500),
	businessName varchar2(500),
	customerDocument varchar2(500),
	customerRuc varchar2(500),
	customerAddress varchar2(500),
	numOrder number(10,0),
	rowSerial varchar2(1000)
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
	modificationDate timestamp with local time zone,
	PRIMARY KEY (customerId, userName, deviceId)
);


CREATE TABLE tambos.tb_ddl_info
(
	id_ddl_info number(10,0) NOT NULL,
	sql_ddl clob,
	userManaged varchar2(100),
	modificationDate timestamp with local time zone,
	PRIMARY KEY (id_ddl_info)
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
	modificationDate timestamp with local time zone,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (deliveryAddressId)
);


CREATE TABLE tambos.tb_delivery_address_stage
(
	customerCode varchar2(500),
	zoneCode varchar2(500),
	addressCode varchar2(500),
	address varchar2(500),
	addressDefault varchar2(500),
	rowSerial varchar2(1000)
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
	modificationDate timestamp with local time zone,
	PRIMARY KEY (deliveryAddressId, userName, deviceId)
);


CREATE TABLE tambos.tb_price_list
(
	priceListId number(10,0) NOT NULL,
	priceListCode varchar2(500),
	description varchar2(500),
	rowSerial varchar2(1000),
	modificationDate timestamp with local time zone,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (priceListId)
);


CREATE TABLE tambos.tb_price_list_stage
(
	priceListCode varchar2(500),
	description varchar2(500),
	rowSerial varchar2(1000)
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
	modificationDate timestamp with local time zone,
	PRIMARY KEY (priceListId, userName, deviceId)
);


CREATE TABLE tambos.tb_product
(
	productId number(10,0) NOT NULL,
	productCode varchar2(500),
	productName varchar2(500),
	unitMaintenance varchar2(500),
	unitPresentation number(10,0),
	rowSerial varchar2(1000),
	modificationDate timestamp with local time zone,
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
	modificationDate timestamp with local time zone,
	userManaged varchar2(100),
	machineName varchar2(100),
	PRIMARY KEY (productPriceId)
);


CREATE TABLE tambos.tb_product_price_stage
(
	productCode varchar2(500),
	priceListCode varchar2(500),
	price number(10,4),
	rowSerial varchar2(1000)
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
	modificationDate timestamp with local time zone,
	PRIMARY KEY (productPriceId, userName, deviceId)
);


CREATE TABLE tambos.tb_product_stage
(
	productCode varchar2(500),
	productName varchar2(500),
	unitMaintenance varchar2(500),
	unitPresentation number(10,0),
	rowSerial varchar2(1000)
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
	modificationDate timestamp with local time zone,
	PRIMARY KEY (productId, userName, deviceId)
);


CREATE TABLE tambos.tb_user_info
(
	userName varchar2(500) NOT NULL,
	deviceId varchar2(500) NOT NULL,
	deviceName varchar2(1000),
	dateSync timestamp with local time zone,
	appVersion number(10,0),
	PRIMARY KEY (userName, deviceId)
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


ALTER TABLE tb_zone_ud
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;


ALTER TABLE tambos.tb_batch_process_user
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;


ALTER TABLE tambos.tb_condition_sale_ud
	ADD FOREIGN KEY (userName, deviceId)
	REFERENCES tambos.tb_user_info (userName, deviceId)
;


ALTER TABLE tambos.tb_currency_ud
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



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_tb_zone_zoneId BEFORE INSERT ON tb_zone
FOR EACH ROW
BEGIN
	SELECT SEQ_tb_zone_zoneId.nextval
	INTO :new.zoneId
	FROM dual;
END;

/




