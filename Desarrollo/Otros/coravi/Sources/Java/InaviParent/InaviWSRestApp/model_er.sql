
/* Drop Tables */

DROP TABLE IF EXISTS inavi.venta_item;
DROP TABLE IF EXISTS inavi.documento_venta;
DROP TABLE IF EXISTS inavi.serie_numero_doc;
DROP TABLE IF EXISTS general.moneda_cambio;
DROP TABLE IF EXISTS inavi.cuenta_amortizacion;
DROP TABLE IF EXISTS inavi.guia_saldo;
DROP TABLE IF EXISTS general.moneda;
DROP TABLE IF EXISTS general.persona_tipo;
DROP TABLE IF EXISTS inavi.cuenta_x_cobrar;
DROP TABLE IF EXISTS inavi.guia_peso;
DROP TABLE IF EXISTS inavi.guia;
DROP TABLE IF EXISTS general.persona;
DROP TABLE IF EXISTS inavi.jornada;




/* Create Tables */

CREATE TABLE inavi.documento_venta
(
	id_documento_venta serial NOT NULL,
	id_tipo_documento_venta int,
	fecha_emision date,
	fecha_cancelado date,
	serie_docu_venta varchar(10),
	num_docu_venta varchar(50),
	id_cliente int NOT NULL,
	nombres_cliente varchar(500),
	direccion_cliente varchar(500),
	id_tipo_docu_cliente int,
	num_docu_cliente varchar(50),
	id_guia_remision int,
	num_guia_remision varchar(50),
	sub_total_venta decimal(10,2),
	valor_igv_venta decimal(10,2),
	importe_total decimal(10,2),
	flag_percepcion int,
	percentage_percepcion decimal(10,4),
	monto_percepcion decimal(10,2),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_documento_venta)
) WITHOUT OIDS;


CREATE TABLE inavi.serie_numero_doc
(
	id_serie_numero_doc serial NOT NULL,
	serie varchar(50),
	numero_doc int,
	id_tipo_documento int,
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_serie_numero_doc)
) WITHOUT OIDS;


CREATE TABLE inavi.venta_item
(
	id_venta_item serial NOT NULL,
	id_documento_venta int NOT NULL,
	unidad_medida varchar(50),
	codigo_articulo varchar(50),
	nombre_articulo varchar(500),
	cantidad_articulo int,
	peso_articulo decimal(10,2),
	precio_unitario decimal(10,2),
	importe_total decimal(10,2),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_venta_item)
) WITHOUT OIDS;


CREATE TABLE general.moneda
(
	id_moneda serial NOT NULL,
	descripcion varchar(150),
	simbolo varchar(10),
	id_tipo_origen int,
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_moneda)
) WITHOUT OIDS;


CREATE TABLE general.moneda_cambio
(
	id_moneda_local int NOT NULL,
	id_moneda_foranea int NOT NULL,
	id_tipo_operador int,
	precio_cambio_moneda decimal(10,2),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_moneda_local, id_moneda_foranea)
) WITHOUT OIDS;


CREATE TABLE general.persona
(
	id_persona serial NOT NULL,
	nombres varchar(500),
	ape_pater varchar(500),
	ape_mater varchar(500),
	razon_social varchar(1000),
	id_tipo_doc int,
	num_tipo_doc varchar(50),
	fecha_nacimiento date,
	email varchar(100),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_persona)
) WITHOUT OIDS;


CREATE TABLE general.persona_tipo
(
	id_persona int NOT NULL,
	id_tipo_persona int NOT NULL,
	id_sub_tipo_persona int NOT NULL,
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_persona, id_tipo_persona, id_sub_tipo_persona)
) WITHOUT OIDS;


CREATE TABLE inavi.cuenta_amortizacion
(
	id_cuenta_amortizacion serial NOT NULL,
	id_cuenta_x_cobrar int NOT NULL,
	id_moneda int NOT NULL,
	monto_amortizado decimal(10,2),
	fecha_saldo date,
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_cuenta_amortizacion)
) WITHOUT OIDS;


CREATE TABLE inavi.cuenta_x_cobrar
(
	id_cuenta_x_cobrar serial NOT NULL,
	id_cliente int NOT NULL,
	descrip_glosa varchar(1000),
	monto_deuda decimal(10,2),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_cuenta_x_cobrar)
) WITHOUT OIDS;


CREATE TABLE inavi.guia
(
	id_guia serial NOT NULL,
	id_guia_referencia int,
	num_dia int NOT NULL,
	num_mes int NOT NULL,
	num_anio int NOT NULL,
	id_proveedor int,
	id_cliente int,
	id_tipo_guia int,
	id_tipo_mvto_guia int,
	id_tipo_producto int,
	total_peso_bruto decimal(10,2),
	total_peso_tara decimal(10,2),
	total_peso_devolucion decimal(10,2),
	total_peso_neto decimal(10,2),
	precio_aplicado decimal(10,4),
	total_importe decimal(10,2),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_guia)
) WITHOUT OIDS;


CREATE TABLE inavi.guia_peso
(
	id_guia_peso serial NOT NULL,
	id_guia int NOT NULL,
	id_tipo_peso int,
	flag_devolucion int DEFAULT 2,
	num_jabas int DEFAULT 0,
	num_aves int DEFAULT 0,
	peso_obtenido decimal(10,2),
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_guia_peso)
) WITHOUT OIDS;


CREATE TABLE inavi.guia_saldo
(
	id_cuenta_amortizacion serial NOT NULL,
	id_guia int NOT NULL,
	id_moneda int,
	monto_amortizado decimal(10,2),
	fecha_saldo date,
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_cuenta_amortizacion)
) WITHOUT OIDS;


CREATE TABLE inavi.jornada
(
	num_dia int NOT NULL,
	num_mes int NOT NULL,
	num_anio int NOT NULL,
	fecha_jornada date,
	id_estado int DEFAULT 1,
	id_usuario_reg int,
	fecha_registro timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	id_usuario_mod int,
	fecha_modificacion timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (num_dia, num_mes, num_anio)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE inavi.venta_item
	ADD FOREIGN KEY (id_documento_venta)
	REFERENCES inavi.documento_venta (id_documento_venta)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE general.moneda_cambio
	ADD FOREIGN KEY (id_moneda_local)
	REFERENCES general.moneda (id_moneda)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE general.moneda_cambio
	ADD FOREIGN KEY (id_moneda_foranea)
	REFERENCES general.moneda (id_moneda)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.cuenta_amortizacion
	ADD FOREIGN KEY (id_moneda)
	REFERENCES general.moneda (id_moneda)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.guia_saldo
	ADD FOREIGN KEY (id_moneda)
	REFERENCES general.moneda (id_moneda)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.documento_venta
	ADD FOREIGN KEY (id_cliente)
	REFERENCES general.persona (id_persona)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE general.persona_tipo
	ADD FOREIGN KEY (id_persona)
	REFERENCES general.persona (id_persona)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.cuenta_x_cobrar
	ADD FOREIGN KEY (id_cliente)
	REFERENCES general.persona (id_persona)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.guia
	ADD FOREIGN KEY (id_cliente)
	REFERENCES general.persona (id_persona)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.guia
	ADD FOREIGN KEY (id_proveedor)
	REFERENCES general.persona (id_persona)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.cuenta_amortizacion
	ADD FOREIGN KEY (id_cuenta_x_cobrar)
	REFERENCES inavi.cuenta_x_cobrar (id_cuenta_x_cobrar)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.documento_venta
	ADD FOREIGN KEY (id_guia_remision)
	REFERENCES inavi.guia (id_guia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.guia
	ADD FOREIGN KEY (id_guia_referencia)
	REFERENCES inavi.guia (id_guia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.guia_peso
	ADD FOREIGN KEY (id_guia)
	REFERENCES inavi.guia (id_guia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.guia_saldo
	ADD FOREIGN KEY (id_guia)
	REFERENCES inavi.guia (id_guia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE inavi.guia
	ADD FOREIGN KEY (num_dia, num_mes, num_anio)
	REFERENCES inavi.jornada (num_dia, num_mes, num_anio)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



