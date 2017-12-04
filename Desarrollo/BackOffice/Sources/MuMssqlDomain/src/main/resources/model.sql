
/* Drop Tables */

IF ObJECt_ID('[character_clazz]') IS NOT NULL DROP TABLE [character_clazz];
IF ObJECt_ID('[map_info]') IS NOT NULL DROP TABLE [map_info];
IF ObJECt_ID('[MEMB_INFO_EXT]') IS NOT NULL DROP TABLE [MEMB_INFO_EXT];
IF ObJECt_ID('[MEMB_INFO_REFERIDO]') IS NOT NULL DROP TABLE [MEMB_INFO_REFERIDO];
IF ObJECt_ID('[reset_historico]') IS NOT NULL DROP TABLE [reset_historico];




/* Create Tables */

CREATE TABLE [character_clazz]
(
	[cod_clazz] int NOT NULL,
	[descrip_clazz] varchar(500),
	PRIMARY KEY ([cod_clazz])
);


CREATE TABLE [map_info]
(
	[cod_map] int NOT NULL,
	[descrip_map] varchar(500),
	PRIMARY KEY ([cod_map])
);


CREATE TABLE [MEMB_INFO_EXT]
(
	[memb_guid] int NOT NULL,
	[nombres] varchar(150),
	[ape_pater] varchar(150),
	[ape_mater] varchar(150),
	[fecha_nacimiento] date,
	[fecha_registro] datetime,
	PRIMARY KEY ([memb_guid])
);


CREATE TABLE [MEMB_INFO_REFERIDO]
(
	[id_referido] int NOT NULL IDENTITY ,
	[memb___id_referido] varchar(500) NOT NULL,
	[memb___id] varchar(500) NOT NULL,
	[fecha_registro] datetime DEFAULT GETDATE() NOT NULL,
	PRIMARY KEY ([id_referido])
);


CREATE TABLE [reset_historico]
(
	[id_reset_historico] int NOT NULL IDENTITY ,
	[AccountID] varchar(150) NOT NULL,
	[NameCharacter] varchar(150) NOT NULL,
	[fecha_registro] datetime NOT NULL,
	PRIMARY KEY ([id_reset_historico])
);



