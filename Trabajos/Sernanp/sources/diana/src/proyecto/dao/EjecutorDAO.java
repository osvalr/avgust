package proyecto.dao;

 



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.SqlConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Ejecutor;

@Repository 
public class EjecutorDAO  {


	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	
	
    @Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	
	public int insertar(Ejecutor ejecutor){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer(SqlConstants.insertaEjecutor); 
		String cad =sql.toString();
		//System.out.println(cad);
		int i;
		int idpersona=0;
		try{
			 cn=dt.obtenerConexion();
			 st=cn.prepareStatement(cad);
			 i=1;
			 
			 st.setInt(i++, ejecutor.getPersonajuridica().getIdpersonajuridica());
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
	
	
	public List<Ejecutor> listar(Ejecutor ejecutor) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaEjecutor);
		
		if(ejecutor.getIdejecutor()!=0){
			sqlb.append(" and e.idejecutor=" );
			sqlb.append(ejecutor.getIdejecutor());
		}
		
		if(ejecutor.getPersonajuridica().getNombrepersonajuridica()!=null)
		{
		sqlb.append("  and pj.nombrepersonajuridica like '%" );
		sqlb.append(ejecutor.getPersonajuridica().getNombrepersonajuridica() );
		sqlb.append("%' " );
		}
		if(ejecutor.getPersonajuridica().getSiglas()!=null)
		{
		sqlb.append("  and pj.siglas like '%" );
		sqlb.append(ejecutor.getPersonajuridica().getSiglas() );
		sqlb.append("%' " );
		}
		sqlb.append(" order by pj.siglas " );
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
	
	
}
