package com.sakerk.generador.definition;

public class Constantes {

	//Tipos de Datos
	public static final String INTEGER = "Integer";
	public static final String DOUBLE = "Double";
	public static final String STRING = "String";
	public static final String BYTE = "byte[]";
	public static final String DATE = "java.util.Date";
	
	//Db tipo de Datos
	public static final int DB_INTEGER = 4;
	public static final int DB_SMALLINT = 5;
	public static final int DB_TINYINT = -6;
	public static final int DB_DOUBLE = 8;
	public static final int DB_DECIMAL = 3;
	public static final int DB_FLOAT = 6;
	public static final int DB_NUMERIC = 2;
	public static final int DB_VARCHAR = 12;
	public static final int DB_BYTE = -2;
	public static final int DB_DATE = 91;	
	public static final int DB_TIME = 92;
	public static final int DB_TIMESTAMP = 93;
	public static final int DB_NULL = 0;
	
	//Tipo Ingreso / Salida
	public static final String OUT = "out";
	public static final String INPUT = "input";
	
	//Engine Db
	public static final int MYSQL = 1;
	public static final int POSTGRES = 2;
	public static final int ORACLE = 3;
	public static final int MSSQL = 4;
	
	//Driver class jdbc
	public static final String DRIVER_CLASS_MYSQL = "com.mysql.jdbc.Driver";
	public static final String DRIVER_CLASS_POSTGRES = "org.postgresql.Driver";
	public static final String DRIVER_CLASS_ORACLE = "oracle.jdbc.driver.OracleDriver";
	public static final String DRIVER_CLASS_MSSQL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	//url connecction
	public static final String URL_CONNECTION_MYSQL = "jdbc:mysql://localhost:3306/dbname";
	public static final String URL_CONNECTION_POSTGRES = "jdbc:postgresql://localhost:5432/dbname";
	public static final String URL_CONNECTION_ORACLE = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String URL_CONNECTION_MSSQL = "jdbc:sqlserver://localhost:1433;DatabaseName=dbname";
	
	//query test
	public static final String QUERY_TEST = "select 1 as val;";
	public static final String QUERY_TEST_ORACLE = "select 1 as val from dual;";
	
	//
	public static final int TIPO_QUERY_SIMPLE = 0;
	public static final int TIPO_QUERY_SPRINGMVCCRUD = 1;
	public static final int TIPO_QUERY_STRUTS2MVCCRUD = 2;
	
	
}
