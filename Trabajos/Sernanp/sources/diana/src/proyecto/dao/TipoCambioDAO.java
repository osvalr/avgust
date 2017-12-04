package proyecto.dao;

 



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.constants.SqlConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Tipocambio;


public class TipoCambioDAO  {


	private ConexionBD dt;
	
    public TipoCambioDAO(){
    	dt=new ConexionBD();
    }
	
    
    
    public List<Tipocambio> listar(Tipocambio tipocambio) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoCambio);
		if(tipocambio.getIdtipocambio()!=0){
			sqlb.append(" and tabtc.idtipocambio=");
			sqlb.append(tipocambio.getIdtipocambio());
		
		}
		if(tipocambio.getAnio()!=0){
			sqlb.append(" and tabtc.idanio=");
			sqlb.append(tipocambio.getAnio());
		
		}
		if(tipocambio.getMes()!=0){
			sqlb.append(" and tabtc.idmes=");
			sqlb.append(tipocambio.getMes());
		
		}
		if(tipocambio.getMonedaOrigen().getIdmoneda()!=0){
			sqlb.append(" and tabtc.idmoneda=");
			sqlb.append(tipocambio.getMonedaOrigen().getIdmoneda());
		
		}
		if(tipocambio.getMonedaDestino().getIdmoneda()!=0){
			sqlb.append(" and tabtc.idmoneda1=");
			sqlb.append(tipocambio.getMonedaDestino().getIdmoneda());
		
		}
		String sql =sqlb.toString();
		
		List<Tipocambio> lista=new ArrayList<Tipocambio>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 Tipocambio t=new Tipocambio();
				 t.setIdtipocambio(rs.getInt("idtipocambio"));
				 t.setValor(rs.getDouble("tipocambio"));
				 t.getMonedaOrigen().setIdmoneda(rs.getInt("idmoneda"));
				 t.getMonedaOrigen().setNombremoneda(rs.getString("nombremoneda"));
				 t.getMonedaDestino().setIdmoneda(rs.getInt("idmoneda1"));
				 t.getMonedaDestino().setNombremoneda(rs.getString("nombremoneda1"));
				 t.setFecha(rs.getDate("fecha"));
				 t.setAnio(rs.getInt("idanio"));
				 t.setMes(rs.getInt("idmes"));
				 
				 lista.add(t);
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
	
    
    public int insertar(Tipocambio tipocambio){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer(SqlConstants.insertaTipoCambio); 
		String cad =sql.toString();
		//System.out.println(cad);
		int i;
		int idproyecto=0;
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 i=1;
			 st.setDouble(i++, tipocambio.getValor());
			 if(tipocambio.getFecha()!=null){
				 st.setDate(i++, new java.sql.Date(tipocambio.getFecha().getTime())); 
			 }
			 else{
				 st.setDate(i++, null); 
			 }
			 st.setInt(i++, tipocambio.getMonedaOrigen().getIdmoneda());
			 st.setInt(i++, tipocambio.getMonedaDestino().getIdmoneda());
			 st.execute();
             rs=st.executeQuery("SELECT LAST_INSERT_ID()");
             if(rs.next())
               idproyecto = rs.getInt(1);
			dt.cerrarConexion(cn,rs,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		return idproyecto;
		
	}

   
    
    public int insertarNoDuplicado(Tipocambio tipocambio){
    	Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int idtipocambio=0;
		StringBuffer sql = new StringBuffer("insert into " +
				"tipocambio(idtipocambio,tipocambio,idmoneda," +
				"idmoneda1) " +
				"values ");
		
			sql.append("(");
			sql.append(tipocambio.getIdtipocambio());
			sql.append(",");
			sql.append(tipocambio.getValor());
			sql.append(",");
			sql.append(tipocambio.getMonedaOrigen().getIdmoneda());
			sql.append(",");
			sql.append(tipocambio.getMonedaDestino().getIdmoneda());
			sql.append(")");
		
		
		sql.append(" on duplicate key update" +
				" tipocambio=values(tipocambio), " +
				" idmoneda=values(idmoneda),"+
				" idmoneda1=values(idmoneda1)"   );
		String cad =sql.toString();
		//System.out.println(cad);
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 st.executeUpdate();
			 rs=st.executeQuery("SELECT LAST_INSERT_ID()");
             if(rs.next())
               idtipocambio = rs.getInt(1);
			dt.cerrarConexion(cn,null,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return idtipocambio;
	}   
    
    
    public void actualizar(Tipocambio tipocambio)
	{
		
		Connection cn = null;
		PreparedStatement st = null;
		StringBuffer sql = new StringBuffer("update tipocambio set idtipocambio=idtipocambio ");
		if(tipocambio.getValor()!=0){
			sql.append(",  tipocambio=");
			sql.append(tipocambio.getValor());
		}
		if(tipocambio.getMonedaOrigen().getIdmoneda()!=0){
			sql.append(",  idmoneda=");
			sql.append(tipocambio.getMonedaOrigen().getIdmoneda());
		}
		if(tipocambio.getMonedaDestino().getIdmoneda()!=0){
			sql.append(",  idmoneda1=");
			sql.append(tipocambio.getMonedaDestino().getIdmoneda());
		}
		sql.append(" where idtipocambio=");
		sql.append(tipocambio.getIdtipocambio());
		String cad =sql.toString();
		//System.out.println(cad);
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 int i=1;
			 st.executeUpdate();
			
			dt.cerrarConexion(cn,null,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
   
    
	
}
