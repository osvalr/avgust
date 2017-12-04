package proyecto.quartz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class QuartzConexionBD {
	
	
	public static Connection obtenerConexion() throws SQLException {
		
		ResourceBundle rb = ResourceBundle.getBundle("proyecto.quartz.jdbcpostgres");
			
		
		Connection con = null;		
		String driver = rb.getString("jdbc.driverClassName");
		String connectString = rb.getString("jdbc.url");
		String user = rb.getString("jdbc.username");
		String password = rb.getString("jdbc.password");
		
		try { 
			 Class.forName(driver);
		 }catch(ClassNotFoundException e) { 
			 throw new SQLException(e); 
		 } 

		 con =  DriverManager.getConnection(connectString, user , password);
		 
		 return con;
		}
}