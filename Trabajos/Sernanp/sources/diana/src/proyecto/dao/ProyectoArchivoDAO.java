package proyecto.dao;

 



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Proyecto;
import proyecto.vo.ProyectoArchivo;

@Repository 
public class ProyectoArchivoDAO  {

	private ConexionBD dt;

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	  
	public ProyectoArchivoDAO(){
			dt = new ConexionBD();		
	}
	
	
	
	
	
	public void insertar(ProyectoArchivo proyectoArchivo){
		//int codigo=0;
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertaProyectoArchivo);
		String sql =sqlb.toString();
		//BeanPropertySqlParameterSource namedParameters=new BeanPropertySqlParameterSource(archivo);
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idproyecto",proyectoArchivo.getProyecto().getIdproyecto() );
		parametros.put("idarchivo", proyectoArchivo.getArchivo().getIdarchivo());
		
		simpleJdbcTemplate.update(sql, parametros);
		//codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
		//return codigo;	
	}
	
	
  public List<ProyectoArchivo> listar(Proyecto proyecto){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaProyectoArchivo);
		if(proyecto.getIdproyecto()!=0 ){
			sqlb.append(" and ap.idproyecto=" );
			sqlb.append(proyecto.getIdproyecto());
		}
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.ProyectoArchivoMapper());
		 	
	}
	
	
  public void eliminarDiferencia(List<ProyectoArchivo> lista,Proyecto proyecto){
  	Connection cn = null;
		PreparedStatement st = null;
		
		StringBuffer sql = new StringBuffer("delete  from archivoproyecto where idproyecto=");
		//sql.append(lista.get(0).getProyecto().getIdproyecto());
		sql.append(proyecto.getIdproyecto());
		
		if(lista.size()!=0){
			sql.append(" and idarchivo in  (  select idarchivo  from   (select * from archivoproyecto where idproyecto=");
			//sql.append(lista.get(0).getProyecto().getIdproyecto());
			sql.append(proyecto.getIdproyecto());
			sql.append(")as tab where   idarchivo not in(");
			for(ProyectoArchivo pa:lista){
				sql.append(pa.getArchivo().getIdarchivo());
				sql.append(",");
			}
			sql.delete(sql.length()-1, sql.length());
			sql.append("))");
			
		}
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
	
	
	
	
	
}
