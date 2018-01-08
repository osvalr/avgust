DROP TABLE IF EXISTS tb_log_in;
DROP TABLE IF EXISTS tb_user_info;
DROP TABLE IF EXISTS tb_order_pending;
CREATE TABLE IF NOT EXISTS tb_log_in (tuserName text, deviceId text, logInDate text, visitDay integer,logInActive integer);
CREATE TABLE IF NOT EXISTS tb_user_info (userName text NOT NULL, deviceId text NOT NULL, dateEntry text, isSynchronized integer, PRIMARY KEY (userName, deviceId));
CREATE TABLE IF NOT EXISTS tb_order_pending (id integer AUTOINCREMENT NOT NULL, order_json text NOT NULL, PRIMARY KEY (id));