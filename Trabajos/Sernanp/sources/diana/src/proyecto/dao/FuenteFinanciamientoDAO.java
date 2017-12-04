package proyecto.dao;

 



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.constants.SqlConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Fuentefinanciamiento;


public class FuenteFinanciamientoDAO  {


	private ConexionBD dt;
	public FuenteFinanciamientoDAO(){
		dt = new ConexionBD();		
    }
	
	
	
	public int insertar(Fuentefinanciamiento fuentefinanciamiento){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer(SqlConstants.insertaFuenteFinanciamiento); 
		String cad =sql.toString();
		//System.out.println(cad);
		int i;
		int idpersona=0;
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 i=1;
			 
			 st.setInt(i++, fuentefinanciamiento.getPersonajuridica().getIdpersonajuridica());
			 st.execute();
             rs=st.executeQuery("SELECT LAST_INSERT_ID()");
             if(rs.next())
               idpersona = rs.getInt(1);
			dt.cerrarConexion(cn,rs,st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		return idpersona;
		
	}
	
	public List<Fuentefinanciamiento> listar(Fuentefinanciamiento ftefto) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaFteFto);
		
		if(ftefto.getIdftefto()!=0){
			sqlb.append(" and f.idftefto= " );
			sqlb.append(ftefto.getIdftefto());
		}
		if(ftefto.getPersonajuridica().getNombrepersonajuridica()!=null)
		{
		sqlb.append("  and pj.nombrepersonajuridica like '%" );
		sqlb.append(ftefto.getPersonajuridica().getNombrepersonajuridica() );
		sqlb.append("%' " );
		}
		if(ftefto.getPersonajuridica().getSiglas()!=null)
		{
		sqlb.append("  and pj.siglas like '%" );
		sqlb.append(ftefto.getPersonajuridica().getSiglas() );
		sqlb.append("%' " );
		}
		sqlb.append(" order by pj.siglas " );
		
		String sql =sqlb.toString();
		
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
	
	
}
