package proyecto.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class ConexionBD {
	
	 
	public  Connection obtenerConexion() throws SQLException {
	
		/*
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");			
		} catch (ClassNotFoundException e) {
			System.out.println("ConexionBD: obtenerConexion(): " + e.getMessage());
			throw new SQLException(e);
		} 	
		con = DriverManager.getConnection("jdbc:mysql://localhost/dde", "root", "");
		return con;
		*/
			Connection con = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource datasource = (DataSource) envContext
					.lookup("jdbc/ds_proyecto");
			con = datasource.getConnection();
			
		} catch (NamingException ex) {
			throw new SQLException("No se pudo encontrar el DataSource.");
		} catch (SQLException ex) {
			throw new SQLException("No se pudo obtener una conexion.");
		}
		return con;
		
	}
	
	
	public  void cerrarConexion(Connection cn) {
		try {
			if (!cn.isClosed()) {
				cn.close();
			}
			if (cn != null) {
				cn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public  void cerrarConexion(Connection cn, ResultSet rs, PreparedStatement cs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (cs != null) {
			try {
				cs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (cn != null) {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		rs = null;
		cs = null;
		cn = null;
	}
}
