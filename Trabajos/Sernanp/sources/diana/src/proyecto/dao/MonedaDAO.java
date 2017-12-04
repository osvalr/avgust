package proyecto.dao;

 



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.constants.SqlConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Moneda;


public class MonedaDAO  {


	private ConexionBD dt;
	
    public MonedaDAO(){
    	dt=new ConexionBD();
    }
	
	
    public List<Moneda> listarTipoMoneda(Moneda moneda) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoMoneda);
		
		String sql =sqlb.toString();
		//System.out.println(sql);
		List<Moneda> lista=new ArrayList<Moneda>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 Moneda m=new Moneda();
				 m.setIdmoneda(rs.getInt("idmoneda"));
				 m.setNombremoneda(rs.getString("nombremoneda"));
				 m.setSimbolomoneda(rs.getString("simbolomoneda"));
				 lista.add(m);
			 }
				
			 dt.cerrarConexion(cn,rs,st);
					
					
		}catch(SQLException e){
					e.printStackTrace();
		}
	    catch(Exception e){
					e.printStackTrace();
		}		
				
	return lista;
}
	
	

   
	
	
}
