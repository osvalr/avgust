package proyecto.dao;

 



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.constants.SqlConstants;
import proyecto.param.ProyectoParam;
import proyecto.util.ConexionBD;
import proyecto.vo.Ejecutor;
import proyecto.vo.Proyecto;
import proyecto.vo.ProyectoEjecutor;


public class ProyectoEjecutorDAO  {


	private ConexionBD dt;
	
    public ProyectoEjecutorDAO(){
    	dt=new ConexionBD();
    }
	
	
    public List<Ejecutor> listarEjecutorxAreanatural(ProyectoParam proyectoParam ) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaEjecutorxAreanatural);
		if(proyectoParam.getAreanatural().getIdareanatural()!=0){
			sqlb.append(" and idareanatural=" );
			sqlb.append(proyectoParam.getAreanatural().getIdareanatural());
		}
		else
			{
			if(proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
				sqlb.append(" and idcategoriaanp=" );
				sqlb.append(proyectoParam.getAreanatural().getCategoriaanp().getIdcategoriaanp());
			}
			}
		sqlb.append(" ))" );
		if(proyectoParam.getProyectoEjecutor().getTipoejecutor().getIdtipo()!=0){
			sqlb.append(" and pe.idtipoejecutor=" );
			sqlb.append(proyectoParam.getProyectoEjecutor().getTipoejecutor().getIdtipo());
		}
		String sql =sqlb.toString();
		//System.out.println(sql);
		List<Ejecutor> lista=new ArrayList<Ejecutor>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 Ejecutor e=new Ejecutor();
				 e.setIdejecutor(rs.getInt("idejecutor"));
				 e.getPersonajuridica().setIdpersonajuridica(rs.getInt("idpersonajuridica"));
				 e.getPersonajuridica().setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
				 e.getPersonajuridica().setSiglas(rs.getString("siglas"));
				 e.getPersonajuridica().setRuc(rs.getString("ruc"));
				 lista.add(e);
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
    
    
    public List<ProyectoEjecutor> listar(ProyectoEjecutor proyectoEjecutor ) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaEjecutorxProyecto);
		if(proyectoEjecutor.getProyecto().getIdproyecto()!=0){
			sqlb.append(" and pe.idproyecto=" );
			sqlb.append(proyectoEjecutor.getProyecto().getIdproyecto());
		}
		if(proyectoEjecutor.getTipoejecutor().getIdtipo()!=0){
			sqlb.append(" and pe.idtipoejecutor=" );
			sqlb.append(proyectoEjecutor.getTipoejecutor().getIdtipo());
		}
		String sql =sqlb.toString();
		//System.out.println(sql);
		List<ProyectoEjecutor> lista=new ArrayList<ProyectoEjecutor>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 ProyectoEjecutor pe=new ProyectoEjecutor();
				 pe.setIdproyectoejecutor(rs.getInt("idproyectoejecutor"));
				 pe.getEjecutor().setIdejecutor(rs.getInt("idejecutor"));
				 pe.getEjecutor().getPersonajuridica().setIdpersonajuridica(rs.getInt("idpersonajuridica"));
				 pe.getEjecutor().getPersonajuridica().setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
				 pe.getEjecutor().getPersonajuridica().setSiglas(rs.getString("siglas"));
				 pe.getEjecutor().getPersonajuridica().setRuc(rs.getString("ruc"));
				 pe.getTipoejecutor().setIdtipo(rs.getInt("idtipoejecutor"));
				 pe.getTipoejecutor().setNombretipo(rs.getString("nombretipoejecutor"));
				 lista.add(pe);

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
    
	
    public void insertar(ProyectoEjecutor proyectoEjecutor){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer(SqlConstants.insertaProyectoEjecutor); 
		String cad =sql.toString();
		//System.out.println(cad);
		int i;
		
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 i=1;
			 st.setInt(i++, proyectoEjecutor.getProyecto().getIdproyecto());
			 st.setInt(i++, proyectoEjecutor.getEjecutor().getIdejecutor());
			 st.setInt(i++, proyectoEjecutor.getTipoejecutor().getIdtipo());
			 st.execute();
            
			dt.cerrarConexion(cn,rs,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		//return idproyecto;
		
	}    
   
    
    public void insertarNoDuplicado(List<ProyectoEjecutor> lista){
    	Connection cn = null;
		PreparedStatement st = null;
		StringBuffer sql = new StringBuffer("insert into " +
				"proyectoejecutor(idproyectoejecutor,idproyecto," +
				"idejecutor,idtipoejecutor) " +
				"values ");
		for(ProyectoEjecutor pe:lista){
			sql.append("(");
			sql.append(pe.getIdproyectoejecutor());
			sql.append(",");
			sql.append(pe.getProyecto().getIdproyecto());
			sql.append(",");
			sql.append(pe.getEjecutor().getIdejecutor());
			sql.append(",");
			sql.append(pe.getTipoejecutor().getIdtipo());
			sql.append("),");
		}
		sql.delete(sql.length()-1, sql.length());
		sql.append(" on duplicate key update" +
				" idproyectoejecutor=values(idproyectoejecutor);");
		String cad =sql.toString();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 st.executeUpdate();
			
			dt.cerrarConexion(cn,null,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}				
	}   
    
    
    
    
    
    public void eliminarDiferencia(List<ProyectoEjecutor> lista,Proyecto proyecto){
    	Connection cn = null;
		PreparedStatement st = null;
		
		StringBuffer sql = new StringBuffer("delete  from proyectoejecutor where idproyecto=");
		//sql.append(lista.get(0).getProyecto().getIdproyecto());
		sql.append(proyecto.getIdproyecto());
		
		if(lista.size()!=0){
			sql.append(" and idproyectoejecutor in  (  select idproyectoejecutor  from   (select * from proyectoejecutor where idproyecto=");
			//sql.append(lista.get(0).getProyecto().getIdproyecto());
			sql.append(proyecto.getIdproyecto());
			sql.append(")as tab where   idproyectoejecutor not in(");
			
			//sql.append("select idejecutor from proyectoejecutor where ");
			
			for(ProyectoEjecutor pe:lista){
				sql.append(pe.getIdproyectoejecutor());
				sql.append(",");
			}
			
			
			sql.delete(sql.length()-1, sql.length());
			sql.append("))");
			
		}
		
		
		
		
		
		String cad =sql.toString();
		//System.out.println(cad);
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
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
