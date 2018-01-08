DROP TABLE IF EXISTS tb_condition_sale;
DROP TABLE IF EXISTS tb_currency;
DROP TABLE IF EXISTS tb_customer;
DROP TABLE IF EXISTS tb_delivery_address;
DROP TABLE IF EXISTS tb_price_list;
DROP TABLE IF EXISTS tb_product;
DROP TABLE IF EXISTS tb_product_price;
DROP TABLE IF EXISTS tb_zone;
CREATE TABLE tb_condition_sale(conditionSaleCode text,conditionSaleName text,userName text,deviceId text);
CREATE TABLE tb_currency(currencyCode text,currencyName text,currencySymbol text,userName text,deviceId text);
CREATE TABLE tb_customer(customerCode text,businessName text,customerDocument text,customerRuc text,customerAddress text,numOrder integer,userName text,deviceId text);
CREATE TABLE tb_delivery_address(customerCode text,zoneCode text,addressCode text,address text,addressDefault text,userName text,deviceId text);
CREATE TABLE tb_price_list(priceListCode text,description text,userName text,deviceId text);
CREATE TABLE tb_product(productCode text,productName text,unitMaintenance text,unitPresentation integer,productType text,userName text,deviceId text);
CREATE TABLE tb_product_price(productCode text,priceListCode text,price numeric,userName text,deviceId text);
CREATE TABLE tb_zone(zoneCode text,zoneName text,visitDay integer,sellerCode text,userName text,deviceId text);

