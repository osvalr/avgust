package pe.com.jrtotem.app.generator.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.com.jrtotem.app.generator.dto.PropertyDto;

public class ConnectionDatabase {

	public static boolean test(String jdbcDriver, String dbUrl, String user, String pass, String queryTest) {
		Connection conn = null;
		Statement stmt = null;
		boolean testSuccess = false;
		try {

			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(dbUrl, user, pass);
			stmt = conn.createStatement();
			String sql;
			sql = queryTest;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				testSuccess = true;
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException se) {
			ConstanUtil.showExceptionDialog(se);
		} catch (Exception e) {
			ConstanUtil.showExceptionDialog(e);
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				ConstanUtil.showExceptionDialog(se2);
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				ConstanUtil.showExceptionDialog(se);
			}

		}
		return testSuccess;
	}

	public static boolean test(String jdbcDriver, String dbUrl, String queryTest) {
		Connection conn = null;
		Statement stmt = null;
		boolean testSuccess = false;
		try {

			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(dbUrl);
			stmt = conn.createStatement();
			String sql;
			sql = queryTest;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				testSuccess = true;
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException se) {
			ConstanUtil.showExceptionDialog(se);
		} catch (Exception e) {
			ConstanUtil.showExceptionDialog(e);
		}
		return testSuccess;
	}

	public static List<PropertyDto> loadParams(String jdbcDriver, String dbUrl, String user, String pass,
			String queryTest) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		Object[][] rows = null;
		String[] columns = null;

		List<PropertyDto> listProperties = new ArrayList<>();

		Class.forName(jdbcDriver);

		conn = DriverManager.getConnection(dbUrl, user, pass);

		stmt = conn.createStatement();
		String sql;
		sql = queryTest;
		ResultSet rs = stmt.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();
		int columCount = rsmd.getColumnCount();
		int rowCount = 0;

		while (rs.next()) {
			rowCount++;
		}

		rs = stmt.executeQuery(sql);

		rows = new Object[rowCount][columCount];
		columns = new String[columCount];

		for (int i = 0; i < columCount; i++) {
			columns[i] = rsmd.getColumnName((i + 1));
			PropertyDto p = new PropertyDto();
			p.setNewEntry(true);
			p.setName(rsmd.getColumnName((i + 1)));

			p.setName(p.getName().toLowerCase());

			p.setType(ConstanUtil.OUT);
			int tipoDato = rsmd.getColumnType((i + 1));
			if (tipoDato == ConstanUtil.DB_INTEGER) {
				p.setData_type(ConstanUtil.INTEGER);
			} else if (tipoDato == ConstanUtil.DB_SMALLINT) {
				p.setData_type(ConstanUtil.INTEGER);
			} else if (tipoDato == ConstanUtil.DB_TINYINT) {
				p.setData_type(ConstanUtil.INTEGER);
			} else if (tipoDato == ConstanUtil.DB_DOUBLE) {
				p.setData_type(ConstanUtil.BIG_DECIMAL);
			} else if (tipoDato == ConstanUtil.DB_DECIMAL) {
				p.setData_type(ConstanUtil.BIG_DECIMAL);
			} else if (tipoDato == ConstanUtil.DB_FLOAT) {
				p.setData_type(ConstanUtil.BIG_DECIMAL);
			} else if (tipoDato == ConstanUtil.DB_NUMERIC) {
				p.setData_type(ConstanUtil.BIG_DECIMAL);
			} else if (tipoDato == ConstanUtil.DB_VARCHAR) {
				p.setData_type(ConstanUtil.STRING);
			} else if (tipoDato == ConstanUtil.DB_BYTE) {
				p.setData_type(ConstanUtil.BYTE);
			} else if (tipoDato == ConstanUtil.DB_DATE) {
				p.setData_type(ConstanUtil.DATE);
			} else if (tipoDato == ConstanUtil.DB_TIME) {
				p.setData_type(ConstanUtil.DATE);
			} else if (tipoDato == ConstanUtil.DB_TIMESTAMP) {
				p.setData_type(ConstanUtil.DATE);
			} else if (tipoDato == ConstanUtil.DB_NULL) {
				p.setData_type(ConstanUtil.STRING);
			} else if (tipoDato == ConstanUtil.DB_BIG_INTEGER) {
				p.setData_type(ConstanUtil.BIG_INTEGER);
			} else {

				p.setData_type(ConstanUtil.STRING);
			}
			listProperties.add(p);
		}

		// STEP 5: Extract data from result set
		int index = 0;
		while (rs.next()) {
			for (int i = 0; i < columCount; i++) {
				rows[index][i] = rs.getObject((i + 1));
			}
			index++;
		}

		rs.close();
		stmt.close();
		conn.close();

		if (stmt != null)
			stmt.close();

		if (conn != null)
			conn.close();

		return listProperties;
	}

	public static List<PropertyDto> loadParams(String jdbcDriver, String dbUrl, String queryTest)
			throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		Object[][] rows = null;
		String[] columns = null;

		List<PropertyDto> listProperties = new ArrayList<>();

		Class.forName(jdbcDriver);

		conn = DriverManager.getConnection(dbUrl);

		stmt = conn.createStatement();
		String sql;
		sql = queryTest;
		ResultSet rs = stmt.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();
		int columCount = rsmd.getColumnCount();
		int rowCount = 0;

		while (rs.next()) {
			rowCount++;
		}

		rs = stmt.executeQuery(sql);

		rows = new Object[rowCount][columCount];
		columns = new String[columCount];

		for (int i = 0; i < columCount; i++) {
			columns[i] = rsmd.getColumnName((i + 1));
			PropertyDto p = new PropertyDto();
			p.setNewEntry(true);
			p.setName(rsmd.getColumnName((i + 1)));

			p.setName(p.getName().toLowerCase());

			p.setType(ConstanUtil.OUT);
			int tipoDato = rsmd.getColumnType((i + 1));
			if (tipoDato == ConstanUtil.DB_INTEGER) {
				p.setData_type(ConstanUtil.INTEGER);
			} else if (tipoDato == ConstanUtil.DB_SMALLINT) {
				p.setData_type(ConstanUtil.INTEGER);
			} else if (tipoDato == ConstanUtil.DB_TINYINT) {
				p.setData_type(ConstanUtil.INTEGER);
			} else if (tipoDato == ConstanUtil.DB_DOUBLE) {
				p.setData_type(ConstanUtil.BIG_DECIMAL);
			} else if (tipoDato == ConstanUtil.DB_DECIMAL) {
				p.setData_type(ConstanUtil.BIG_DECIMAL);
			} else if (tipoDato == ConstanUtil.DB_FLOAT) {
				p.setData_type(ConstanUtil.BIG_DECIMAL);
			} else if (tipoDato == ConstanUtil.DB_NUMERIC) {
				p.setData_type(ConstanUtil.BIG_DECIMAL);
			} else if (tipoDato == ConstanUtil.DB_VARCHAR) {
				p.setData_type(ConstanUtil.STRING);
			} else if (tipoDato == ConstanUtil.DB_BYTE) {
				p.setData_type(ConstanUtil.BYTE);
			} else if (tipoDato == ConstanUtil.DB_DATE) {
				p.setData_type(ConstanUtil.DATE);
			} else if (tipoDato == ConstanUtil.DB_TIME) {
				p.setData_type(ConstanUtil.DATE);
			} else if (tipoDato == ConstanUtil.DB_TIMESTAMP) {
				p.setData_type(ConstanUtil.DATE);
			} else if (tipoDato == ConstanUtil.DB_NULL) {
				p.setData_type(ConstanUtil.STRING);
			} else if (tipoDato == ConstanUtil.DB_BIG_INTEGER) {
				p.setData_type(ConstanUtil.BIG_INTEGER);
			} else {

				p.setData_type(ConstanUtil.STRING);
			}
			listProperties.add(p);
		}

		// STEP 5: Extract data from result set
		int index = 0;
		while (rs.next()) {
			for (int i = 0; i < columCount; i++) {
				rows[index][i] = rs.getObject((i + 1));
			}
			index++;
		}

		rs.close();
		stmt.close();
		conn.close();

		return listProperties;
	}
}
