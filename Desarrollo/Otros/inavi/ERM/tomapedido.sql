
/* Drop Tables */

DROP TABLE [conditionSale];
DROP TABLE [currency];
DROP TABLE [customer];
DROP TABLE [deliveryAddress];
DROP TABLE [priceList];
DROP TABLE [product];
DROP TABLE [productPrice];
DROP TABLE [userInfo];
DROP TABLE [zone];




/* Create Tables */

CREATE TABLE [conditionSale]
(
	[conditionSaleCode] text,
	[conditionSaleName] text,
	[userName] text,
	[deviceId] text
);


CREATE TABLE [currency]
(
	[currencyCode] text,
	[currencyName] text,
	[currencySymbol] text,
	[userName] text,
	[deviceId] text
);


CREATE TABLE [customer]
(
	[customerCode] text,
	[businessName] text,
	[customerDocument] text,
	[customerRuc] text,
	[customerAddress] text,
	[numOrder] integer,
	[userName] text,
	[deviceId] text
);


CREATE TABLE [deliveryAddress]
(
	[customerCode] text,
	[zoneCode] text,
	[addressCode] text,
	[address] text,
	[addressDefault] text,
	[userName] text,
	[deviceId] text
);


CREATE TABLE [priceList]
(
	[priceListCode] text,
	[description] text,
	[userName] text,
	[deviceId] text
);


CREATE TABLE [product]
(
	[productCode] text,
	[productName] text,
	[unitMaintenance] text,
	[unitPresentation] integer,
	[userName] text,
	[deviceId] text
);


CREATE TABLE [productPrice]
(
	[productCode] text,
	[priceListCode] text,
	[price] numeric,
	[userName] text,
	[deviceId] text
);


CREATE TABLE [userInfo]
(
	[userName] text NOT NULL,
	[deviceId] text NOT NULL,
	[dateSync] none,
	[appVersion] integer,
	PRIMARY KEY ([userName], [deviceId])
);


CREATE TABLE [zone]
(
	[zoneCode] text,
	[zoneName] text,
	[visitDay] integer,
	[sellerCode] text
);



