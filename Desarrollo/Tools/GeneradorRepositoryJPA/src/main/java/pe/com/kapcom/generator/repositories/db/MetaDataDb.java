package pe.com.kapcom.generator.repositories.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.CaseFormat;

import pe.com.kapcom.generator.repositories.bean.ColumnBean;
import pe.com.kapcom.generator.repositories.util.PropUtil;

public class MetaDataDb {

	private String driverClassName = PropUtil.getInstance().getPropVal("database.properties", "jdbc.driverClassName");
	private String url = PropUtil.getInstance().getPropVal("database.properties", "jdbc.url");
	private String username = PropUtil.getInstance().getPropVal("database.properties", "jdbc.username");
	private String password = PropUtil.getInstance().getPropVal("database.properties", "jdbc.password");
	private String schema = PropUtil.getInstance().getPropVal("config.properties", "schema");
	private String tables = PropUtil.getInstance().getPropVal("config.properties", "tables");

	public List<String> getTables() throws SQLException, ClassNotFoundException, IOException {

		if (!tables.equals("*")) {
			return Arrays.asList(tables.split(","));
		} else {

			List<String> tables = new ArrayList<>();

			String tables_query_pg = new String(Files.readAllBytes(Paths.get("query/tables_query_pg.sql")));

			Class.forName(driverClassName);

			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = tables_query_pg;

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, schema);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				tables.add(result.getString("table_name"));
			}

			preparedStatement.close();
			result.close();
			conn.close();
			
			return tables;
		}

	}

	public List<ColumnBean> getColumnsForTable(String tableName)
			throws SQLException, ClassNotFoundException, IOException {

		List<String> pks = getColumnsPk(tableName);
		
		List<ColumnBean> columns = new ArrayList<>();

		String columns_query_pg = new String(Files.readAllBytes(Paths.get("query/columns_query_pg.sql")));

		Class.forName(driverClassName);

		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = columns_query_pg;

		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, schema);
		preparedStatement.setString(2, tableName);

		ResultSet result = preparedStatement.executeQuery();

		if(isPkComposed(pks)){
			
			ColumnBean columnBean = new ColumnBean();
			String nameClass = getFinalName(tableName);
			nameClass = nameClass.replace("_", "");
			nameClass = nameClass+"Pk";
			
			columnBean.setDataTypeJava(nameClass);
			columnBean.setNameColumn(getNombrePropiedad(nameClass));
			
			columnBean.setAnnotations("	@EmbeddedId");
			
			columns.add(columnBean);
		}
		
		while (result.next()) {

			String annotations = "";

			ColumnBean columnBean = new ColumnBean();
			columnBean.setNameColumn(result.getString("column_name"));
			columnBean.setDataType(result.getString("data_type"));
			columnBean.setCharacter_maximum_length(result.getInt("character_maximum_length"));
			columnBean.setNumeric_precision(result.getInt("numeric_precision"));
			columnBean.setNumeric_scale(result.getInt("numeric_scale"));
			columnBean.setIs_nullable(result.getString("is_nullable"));
			
			if(isColumnPk(pks, columnBean.getNameColumn())){
				
				if(isPkComposed(pks)){
					columnBean.setColumnPk(true);	
					if(isFirstColumnPk(pks, columnBean.getNameColumn())){
						annotations = annotations + "\n	@GeneratedValue(strategy = GenerationType.IDENTITY)";
					}
				}else{
					columnBean.setColumnPk(false);
					annotations = annotations + "	@Id";
					annotations = annotations + "\n	@GeneratedValue(strategy = GenerationType.IDENTITY)";
				}
			}

			if (columnBean.getIs_nullable().equals("NO")) {
				
				if(isColumnPk(pks, columnBean.getNameColumn())){
					
				}else{
					annotations = annotations + "\n	@NotNull";
				}
				
			}

			if (columnBean.getDataType().equals("bigint")) {
				columnBean.setDataTypeJava("java.math.BigInteger");
			}
			
			if (columnBean.getDataType().equals("integer")) {
				columnBean.setDataTypeJava("Integer");
			}

			if (columnBean.getDataType().equals("numeric")) {
				annotations = annotations + "\n	@Column(precision = " + columnBean.getNumeric_precision() + ", scale = "+ columnBean.getNumeric_scale() + ")";
				columnBean.setDataTypeJava("java.math.BigDecimal");
			}

			if (columnBean.getDataType().equals("character varying")) {
				annotations = annotations + "\n	@Size(max = " + columnBean.getCharacter_maximum_length() + ")";
				columnBean.setDataTypeJava("String");
			}
			
			if (columnBean.getDataType().equals("text")) {
				columnBean.setDataTypeJava("String");
			}

			if (columnBean.getDataType().contains("timestamp")) {
				annotations = "\n	@Temporal(TemporalType.TIMESTAMP)";
				columnBean.setDataTypeJava("java.util.Date");
			}
			
			if (columnBean.getDataType().contains("date")) {
				annotations = "\n	@Temporal(TemporalType.TIMESTAMP)";
				columnBean.setDataTypeJava("java.util.Date");
			}

			if (!annotations.equals("")) {
				columnBean.setAnnotations(annotations);
			}else{
				columnBean.setAnnotations("");
			}

			columns.add(columnBean);

		}
		
		preparedStatement.close();
		result.close();
		conn.close();
		
		return columns;

	}

	public List<String> getColumnsPk(String table_name) throws SQLException, ClassNotFoundException, IOException {

		List<String> columnsPk = new ArrayList<>();

		String pk_query_pg = new String(Files.readAllBytes(Paths.get("query/pk_query_pg.sql")));

		Class.forName(driverClassName);

		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = pk_query_pg;

		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, schema);
		preparedStatement.setString(2, table_name);

		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			columnsPk.add(result.getString("column_name"));
		}
		
		preparedStatement.close();
		result.close();
		conn.close();

		return columnsPk;

	}
	
	public List<String> getUniqueColumns(String table_name) throws SQLException, ClassNotFoundException, IOException {

		List<String> columns = new ArrayList<>();

		String constraint_query_pg = new String(Files.readAllBytes(Paths.get("query/constraint_query_pg.sql")));

		Class.forName(driverClassName);

		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = constraint_query_pg;

		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, schema);
		preparedStatement.setString(2, table_name);

		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			columns.add(result.getString("column_name"));
		}

		preparedStatement.close();
		result.close();
		conn.close();
		
		return columns;

	}

	public boolean isColumnPk(List<String> columnsPk,String column_name){
		for(String s : columnsPk){
			if(s.equals(column_name)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isFirstColumnPk(List<String> columnsPk,String column_name){
		if(columnsPk.size()>1){
			String pk = columnsPk.get(0);
			if(pk.equals(column_name)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isPkComposed(List<String> columnsPk){
		if(columnsPk.size()>1){
			return true;
		}
		return false;
	}
	
	public static String getFinalName(String val) {
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, val);
	}
	public static String getNombreMetodo(String nombreMetodo){
		return nombreMetodo.substring(0, 1).toUpperCase() + nombreMetodo.substring(1, nombreMetodo.length());
	}
	public static String getNombrePropiedad(String nombreMetodo){
		return nombreMetodo.substring(0, 1).toLowerCase() + nombreMetodo.substring(1, nombreMetodo.length());
	}
}
