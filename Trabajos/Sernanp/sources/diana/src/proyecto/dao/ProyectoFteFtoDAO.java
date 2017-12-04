package proyecto.dao;

 



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.constants.SqlConstants;
import proyecto.constants.ValueConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Areanatural;
import proyecto.vo.Fuentefinanciamiento;
import proyecto.vo.Proyecto;
import proyecto.vo.ProyectoAreanatural;
import proyecto.vo.ProyectoFteFto;


public class ProyectoFteFtoDAO  {


	private ConexionBD dt;
	
    public ProyectoFteFtoDAO(){
    	dt=new ConexionBD();
    }
    
    
    
    
    
    
    
    
    public List<ProyectoFteFto> listarProyectoFuenteFtoxAreanatural(ProyectoAreanatural proyectoAreanatural,int orden ) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaFteFtoxAreanatural);
		
		if(proyectoAreanatural.getProyecto().getFlagProyecto()!=0){
			sqlb.append(" and tab.flagproyecto=");
			sqlb.append(proyectoAreanatural.getProyecto().getFlagProyecto())  ;
		}
		sqlb.append(" and tab.idproyecto in (");
		sqlb.append(" select distinct pa.idproyecto from areanaturalproyecto pa ");
		sqlb.append(" where 1=1 ");
         if(proyectoAreanatural.getAreanatural().getIdareanatural()!=0){
			sqlb.append(" and pa.idareaNatural=");
			sqlb.append(proyectoAreanatural.getAreanatural().getIdareanatural());
		  }
		sqlb.append(" )");
		sqlb.append(" group by pf.idftefto ");
		if(orden==ValueConstants.TOTAL){
			sqlb.append(" order by montototal desc");
		}
		else
			if(orden==ValueConstants.VIGENTES){
				sqlb.append(" order by montovigente desc");
			}
			else
           if(orden==ValueConstants.CONCLUIDOS){
        	   sqlb.append(" order by montovencido desc");
		    }		
				
		String sql =sqlb.toString();
		
		List<ProyectoFteFto> lista=new ArrayList<ProyectoFteFto>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 ProyectoFteFto pf=new ProyectoFteFto();
				 pf.getFteFto().setIdftefto(rs.getInt("idftefto")); 
				 pf.getFteFto().getPersonajuridica().setIdpersonajuridica(rs.getInt("idpersonajuridica"));
				 pf.getFteFto().getPersonajuridica().setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
				 pf.getFteFto().getPersonajuridica().setSiglas(rs.getString("siglas"));
				 pf.getFteFto().getPersonajuridica().setRuc(rs.getString("ruc"));
				 pf.setMonto(rs.getDouble("montototal"));
				 lista.add(pf);
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
    
    
    
    
    public List<Fuentefinanciamiento> listarFuenteFtoxAreanatural(Areanatural areanatural ) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaFteFtoxAreanatural1);
		if(areanatural.getIdareanatural()!=0){
			sqlb.append(" and idareanatural=" );
			sqlb.append(areanatural.getIdareanatural());
		}
		else
			{
			if(areanatural.getCategoriaanp().getIdcategoriaanp()!=0){
				sqlb.append(" and idcategoriaanp=" );
				sqlb.append(areanatural.getCategoriaanp().getIdcategoriaanp());
			}
			}
		sqlb.append(" ))  " +
				"  group by pf.idftefto " );
		String sql =sqlb.toString();
		//System.out.println(sql);
		List<Fuentefinanciamiento> lista=new ArrayList<Fuentefinanciamiento>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 Fuentefinanciamiento f=new Fuentefinanciamiento();
				 f.setIdftefto(rs.getInt("idftefto")); 
				 f.getPersonajuridica().setIdpersonajuridica(rs.getInt("idpersonajuridica"));
				 f.getPersonajuridica().setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
				 f.getPersonajuridica().setSiglas(rs.getString("siglas"));
				 f.getPersonajuridica().setRuc(rs.getString("ruc"));
				 lista.add(f);
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
	
	
    
    public List<ProyectoFteFto> listar(ProyectoFteFto proyectoFteFto ) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaFteFtoxProyecto);
		if(proyectoFteFto.getProyecto().getIdproyecto()!=0){
			sqlb.append(" and pf.idproyecto=" );
			sqlb.append(proyectoFteFto.getProyecto().getIdproyecto());
		}
		
		String sql =sqlb.toString();
		//System.out.println(sql);
		List<ProyectoFteFto> lista=new ArrayList<ProyectoFteFto>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 ProyectoFteFto pf=new ProyectoFteFto();
				 pf.getFteFto().setIdftefto(rs.getInt("idftefto"));
				 pf.getFteFto().getPersonajuridica().setIdpersonajuridica(rs.getInt("idpersonajuridica"));
				 pf.getFteFto().getPersonajuridica().setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
				 pf.getFteFto().getPersonajuridica().setSiglas(rs.getString("siglas"));
				 pf.getFteFto().getPersonajuridica().setRuc(rs.getString("ruc"));
				 pf.setMonto(rs.getDouble("monto"));
				 pf.getMoneda().setIdmoneda(rs.getInt("idmoneda"));
				 pf.getMoneda().setNombremoneda(rs.getString("nombremoneda"));
				 pf.getTipocambio().setIdtipocambio(rs.getInt("idtipocambio"));
				 lista.add(pf);
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
    
    
    
    public List<Fuentefinanciamiento> listar(Proyecto proyecto ) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaFteFtoxProyecto);
		if(proyecto.getIdproyecto()!=0){
			sqlb.append(" and pf.idproyecto=" );
			sqlb.append(proyecto.getIdproyecto());
		}
		
		String sql =sqlb.toString();
		//System.out.println(sql);
		List<Fuentefinanciamiento> lista=new ArrayList<Fuentefinanciamiento>();
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(sql);
			 rs=st.executeQuery();
			 
			 while(rs.next()){
				 Fuentefinanciamiento f=new Fuentefinanciamiento();
				 f.setIdftefto(rs.getInt("idftefto"));
				 f.getPersonajuridica().setIdpersonajuridica(rs.getInt("idpersonajuridica"));
				 f.getPersonajuridica().setNombrepersonajuridica(rs.getString("nombrepersonajuridica"));
				 f.getPersonajuridica().setSiglas(rs.getString("siglas"));
				 f.getPersonajuridica().setRuc(rs.getString("ruc"));
				 lista.add(f);
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
	
    public void insertar(ProyectoFteFto proyectoFteFto){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer(SqlConstants.insertaProyectoFteFto); 
		String cad =sql.toString();
		//System.out.println(cad);
		int i;
		
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 i=1;
			 st.setInt(i++, proyectoFteFto.getProyecto().getIdproyecto());
			 st.setInt(i++, proyectoFteFto.getFteFto().getIdftefto());
			 st.setDouble(i++, proyectoFteFto.getMonto());
			 st.setInt(i++, proyectoFteFto.getMoneda().getIdmoneda());
			 if(proyectoFteFto.getTipocambio().getIdtipocambio()!=0){
				 st.setInt(i++, proyectoFteFto.getTipocambio().getIdtipocambio()); 
			 }
			 else{
				 st.setObject(i++, null);
			 }
			 
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

    public void insertarNoDuplicado(ProyectoFteFto proyectoFteFto ){
    	Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("insert into " +
				"proyectoftefto(idproyecto," +
				"idftefto,monto,idmoneda,idtipocambio) " +
				"values ");
		
			sql.append("(");
			sql.append(proyectoFteFto.getProyecto().getIdproyecto());
			sql.append(",");
			sql.append(proyectoFteFto.getFteFto().getIdftefto());
			sql.append(",");
			sql.append(proyectoFteFto.getMonto());
			sql.append(",");
			sql.append(proyectoFteFto.getMoneda().getIdmoneda());
			sql.append(",");
			if(proyectoFteFto.getTipocambio().getIdtipocambio()!=0){
				sql.append(proyectoFteFto.getTipocambio().getIdtipocambio());
			}else{
				sql.append("null");
			}
			sql.append(")");
		
		
		sql.append(" on duplicate key update" +
				" idftefto=values(idftefto), " +
				" idmoneda=values(idmoneda), " +
				" idtipocambio=values(idtipocambio), " +
				"  monto=values(monto);" );
				//" idftefto=values(idftefto)" +
				//" idftefto=idftefto ," +		
		//" monto= ");
		
				//" monto=monto ;");
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
    
    public void insertarNoDuplicado(List<ProyectoFteFto> lista){
    	Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("insert into " +
				"proyectoftefto(idproyecto," +
				"idftefto,monto,idmoneda,idtipocambio) " +
				"values ");
		for(ProyectoFteFto pf:lista){
			sql.append("(");
			sql.append(pf.getProyecto().getIdproyecto());
			sql.append(",");
			sql.append(pf.getFteFto().getIdftefto());
			sql.append(",");
			sql.append(pf.getMonto());
			sql.append(",");
			sql.append(pf.getMoneda().getIdmoneda());
			sql.append(",");
			
			if(pf.getTipocambio().getIdtipocambio()!=0){
				sql.append(pf.getTipocambio().getIdtipocambio());
			}else{
				sql.append("null");
			}
			
			sql.append("),");
		}
		sql.delete(sql.length()-1, sql.length());
		sql.append(" on duplicate key update" +
				" idftefto=values(idftefto), " +
				" idmoneda=values(idmoneda), " +
				" idtipocambio=values(idtipocambio), " +
				"  monto=values(monto);" );
				//" idftefto=values(idftefto)" +
				//" idftefto=idftefto ," +		
		//" monto= ");
		
				//" monto=monto ;");
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
    
    public void eliminarDiferencia(List<ProyectoFteFto> lista,Proyecto proyecto){
    	Connection cn = null;
		PreparedStatement st = null;
		
		StringBuffer sql = new StringBuffer("delete  from proyectoftefto where idproyecto=");
		sql.append(proyecto.getIdproyecto());
		
		
		if(lista.size()!=0){
		sql.append(" and idftefto in  (  select idftefto  from   (select * from proyectoftefto where idproyecto=");
		sql.append(proyecto.getIdproyecto());
		sql.append(")as tab where   idftefto not in(");
		for(ProyectoFteFto pf:lista){
			sql.append(pf.getFteFto().getIdftefto());
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
