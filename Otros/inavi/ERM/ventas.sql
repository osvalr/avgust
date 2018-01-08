
/* Drop Tables */

DROP TABLE IF EXISTS ventas.comprobante_item;
DROP TABLE IF EXISTS ventas.guia_remision_item;
DROP TABLE IF EXISTS general.articulo;
DROP TABLE IF EXISTS general.serie_numero_doc;
DROP TABLE IF EXISTS ventas.guia_remision;
DROP TABLE IF EXISTS ventas.comprobante_pago;




/* Create Tables */

CREATE TABLE general.articulo
(
	id_articulo serial NOT NULL,
	codigo_articulo varchar(100) NOT NULL UNIQUE,
	nombre_articulo varchar(500),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_articulo)
) WITHOUT OIDS;


CREATE TABLE general.serie_numero_doc
(
	id_serie_numero_doc serial NOT NULL,
	serie varchar(50),
	numero_doc int,
	id_tipo_documento int,
	longitud int,
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_serie_numero_doc)
) WITHOUT OIDS;


CREATE TABLE ventas.comprobante_item
(
	id_comprobante_item serial NOT NULL,
	id_comprobante_pago int NOT NULL,
	id_articulo int NOT NULL,
	cantidad_articulo int,
	id_unidad_medida int,
	peso_articulo decimal(10,2),
	precio_unitario decimal(10,2),
	importe_total decimal(10,2),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_comprobante_item)
) WITHOUT OIDS;


CREATE TABLE ventas.comprobante_pago
(
	id_comprobante_pago serial NOT NULL,
	id_tipo_comprobante_pago int,
	fecha_emision date,
	fecha_cancelado date,
	serie_docu_comprobante varchar(10),
	correlativo_docu_cdp varchar(50),
	num_docu_comprobante varchar(50),
	id_cliente int,
	sub_total_venta decimal(10,2),
	valor_igv_venta decimal(10,2),
	importe_total decimal(10,2),
	flag_percepcion int,
	porcentaje_percepcion decimal(10,4),
	monto_percepcion decimal(10,2),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_comprobante_pago)
) WITHOUT OIDS;


CREATE TABLE ventas.guia_remision
(
	id_guia_remision serial NOT NULL,
	id_comprobante_pago int NOT NULL,
	serie_docu_guia varchar(10),
	correlativo_docu_guia varchar(50),
	num_docu_guia varchar(50),
	fecha_inicio_traslado date,
	id_destinatario int,
	id_motivo_traslado int,
	direccion_partida varchar(1000),
	codigo_departamento_partida varchar(10),
	codigo_provincia_partida varchar(10),
	codigo_distrito_partida varchar(10),
	direccion_llegada varchar(1000),
	codigo_departamento_llegada varchar(10),
	codigo_provincia_llegada varchar(10),
	codigo_distrito_llegada varchar(10),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_guia_remision)
) WITHOUT OIDS;


CREATE TABLE ventas.guia_remision_item
(
	id_guia_remision_item serial NOT NULL,
	id_guia_remision int NOT NULL,
	id_articulo int NOT NULL,
	cantidad_articulo int,
	id_unidad_medida int,
	peso_total decimal(10,2),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_guia_remision_item)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE ventas.comprobante_item
	ADD FOREIGN KEY (id_articulo)
	REFERENCES general.articulo (id_articulo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ventas.guia_remision_item
	ADD FOREIGN KEY (id_articulo)
	REFERENCES general.articulo (id_articulo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ventas.comprobante_item
	ADD FOREIGN KEY (id_comprobante_pago)
	REFERENCES ventas.comprobante_pago (id_comprobante_pago)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ventas.guia_remision
	ADD FOREIGN KEY (id_comprobante_pago)
	REFERENCES ventas.comprobante_pago (id_comprobante_pago)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ventas.guia_remision_item
	ADD FOREIGN KEY (id_guia_remision)
	REFERENCES ventas.guia_remision (id_guia_remision)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



