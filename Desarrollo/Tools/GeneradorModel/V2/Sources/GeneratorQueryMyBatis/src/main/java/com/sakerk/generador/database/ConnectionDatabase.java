package com.sakerk.generador.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.sakerk.generador.bean.ModelBean;
import com.sakerk.generador.definition.Constantes;
import com.sakerk.generador.definition.ParametrosGenerador;

public class ConnectionDatabase {

	   public static boolean test(String jdbcDriver, String dbUrl,String user, String pass,String queryTest) {
	   Connection conn = null;
	   Statement stmt = null;
	   boolean testSuccess = false;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName(jdbcDriver);

	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(dbUrl,user,pass);

	      //STEP 4: Execute a query
	      stmt = conn.createStatement();
	      String sql;
	      sql = queryTest;
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	    	  testSuccess = true;
	      }
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   return testSuccess;
	}//end main
	   
	   public static DefaultTableModel executeSql(String jdbcDriver, String dbUrl,String user, String pass,String queryTest) throws ClassNotFoundException, SQLException {
	   Connection conn = null;
	   Statement stmt = null;
	   Object[][] rows = null;
	   String[] columns = null;
	   
	   DefaultTableModel defaultTableModel = null;
	   
	      //STEP 2: Register JDBC driver
	      Class.forName(jdbcDriver);

	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(dbUrl,user,pass);

	      //STEP 4: Execute a query
	      stmt = conn.createStatement();
	      String sql;
	      sql = queryTest;
	      ResultSet rs = stmt.executeQuery(sql);

	      ResultSetMetaData rsmd = rs.getMetaData();
	      int columCount = rsmd.getColumnCount();
	      int rowCount = 0;
	      
	      while(rs.next()){
	    	  rowCount++;
	      }
	      
	      rs = stmt.executeQuery(sql);
	      
	      rows = new Object[rowCount][columCount];
	      columns = new String[columCount];
	      
	      for(int i=0;i<columCount;i++){
	    	  columns[i]=rsmd.getColumnName((i+1));
	      }
	      
	      //STEP 5: Extract data from result set
	      int index = 0;
	      while(rs.next()){
	    	  for(int i=0;i<columCount;i++){
	    		  rows[index][i] = rs.getObject((i+1));
	    	  }
	    	  index++;
	      }
	      
	      defaultTableModel = new DefaultTableModel(rows,columns);
	      
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();

	         if(stmt!=null)
	            stmt.close();

	         if(conn!=null)
	            conn.close();

	   return defaultTableModel;
	}//end main
	   
	   
	   public static ModelBean loadParams(String jdbcDriver, String dbUrl,String user, String pass,String queryTest) throws SQLException, ClassNotFoundException {
	   Connection conn = null;
	   Statement stmt = null;
	   Object[][] rows = null;
	   String[] columns = null;
	   
	   DefaultTableModel defaultTableModel = null;
	   List<ParametrosGenerador> listParametrosGenerador = new ArrayList<ParametrosGenerador>();
	   
	   ModelBean modelBean = null;
	   
	      //STEP 2: Register JDBC driver
	      Class.forName(jdbcDriver);

	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(dbUrl,user,pass);

	      //STEP 4: Execute a query
	      stmt = conn.createStatement();
	      String sql;
	      sql = queryTest;
	      ResultSet rs = stmt.executeQuery(sql);

	      ResultSetMetaData rsmd = rs.getMetaData();
	      int columCount = rsmd.getColumnCount();
	      int rowCount = 0;
	      
	      while(rs.next()){
	    	  rowCount++;
	      }
	      
	      rs = stmt.executeQuery(sql);
	      
	      rows = new Object[rowCount][columCount];
	      columns = new String[columCount];
	      
	      for(int i=0;i<columCount;i++){
	    	  columns[i]=rsmd.getColumnName((i+1));
	    	  ParametrosGenerador p = new ParametrosGenerador();
	    	  p.setNombreParametro(rsmd.getColumnName((i+1)));
	    	  p.setTipoEntradaSalida(Constantes.OUT);
	    	  int tipoDato = rsmd.getColumnType((i+1));
	    	  if(tipoDato == Constantes.DB_INTEGER){
	    		  p.setTipoDato(Constantes.INTEGER);
	    	  }else if(tipoDato == Constantes.DB_SMALLINT){
	    		  p.setTipoDato(Constantes.INTEGER);
	    	  }else if(tipoDato == Constantes.DB_TINYINT){
	    		  p.setTipoDato(Constantes.INTEGER);
	    	  }else if(tipoDato == Constantes.DB_DOUBLE){
	    		  p.setTipoDato(Constantes.DOUBLE);
	    	  }else if(tipoDato == Constantes.DB_DECIMAL){
	    		  p.setTipoDato(Constantes.DOUBLE);
	    	  }else if(tipoDato == Constantes.DB_FLOAT){
	    		  p.setTipoDato(Constantes.INTEGER);
	    	  }else if(tipoDato == Constantes.DB_NUMERIC){
	    		  p.setTipoDato(Constantes.DOUBLE);
	    	  }else if(tipoDato == Constantes.DB_VARCHAR){
	    		  p.setTipoDato(Constantes.STRING);
	    	  }else if(tipoDato == Constantes.DB_BYTE){
	    		  p.setTipoDato(Constantes.BYTE);
	    	  }else if(tipoDato == Constantes.DB_DATE){
	    		  p.setTipoDato(Constantes.DATE);
	    	  }else if(tipoDato == Constantes.DB_TIME){
	    		  p.setTipoDato(Constantes.DATE);
	    	  }else if(tipoDato == Constantes.DB_TIMESTAMP){
	    		  p.setTipoDato(Constantes.DATE);
	    	  }else if(tipoDato == Constantes.DB_NULL){
	    		  p.setTipoDato(Constantes.STRING);
	    	  }else{
	    		  
	    		  p.setTipoDato(Constantes.STRING);
	    	  }
	    	  listParametrosGenerador.add(p);
	      }
	      
	      //STEP 5: Extract data from result set
	      int index = 0;
	      while(rs.next()){
	    	  for(int i=0;i<columCount;i++){
	    		  rows[index][i] = rs.getObject((i+1));
	    	  }
	    	  index++;
	      }
	      
	      defaultTableModel = new DefaultTableModel(rows,columns);
	      
	      modelBean = new ModelBean();
	      modelBean.setDefaultTableModel(defaultTableModel);
	      modelBean.setListParametrosGenerador(listParametrosGenerador);
	      
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	      
	      if(stmt!=null)
	        stmt.close();

	      if(conn!=null)
	        conn.close();

	   return modelBean;
	}//end main
}
