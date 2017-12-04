package proyecto.dao;

 



import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import proyecto.vo.AprobacionRecursoInformacion;

@Repository 
public class AprobacionRecursoInformacionDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
		
		
	
	 
	 
	 public int insertar(AprobacionRecursoInformacion aprobacionRecursoInformacion){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaAprobacionRecursoInformacion);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idrecursoinformacion",aprobacionRecursoInformacion.getIdrecursoinformacion());
			parametros.put("idpersonal",aprobacionRecursoInformacion.getPersonal().getIdpersonal() );
			parametros.put("idarea", aprobacionRecursoInformacion.getAreaorganica().getIdarea());
			parametros.put("fechaaprobacion", aprobacionRecursoInformacion.getFechaaprobacion());
			simpleJdbcTemplate.update(sql, parametros);
			codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
			return codigo;	
		}
	
	  
	 
	 public List<AprobacionRecursoInformacion> listar(AprobacionRecursoInformacion aprobacionRecursoInformacion){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaAprobacionRecursoInformacion);
			if(aprobacionRecursoInformacion.getIdrecursoinformacion()!=0 ){
				sqlb.append(" and apri.idrecursoinformacion=" );
				sqlb.append(aprobacionRecursoInformacion.getIdrecursoinformacion());
			}
			
			 String sql =sqlb.toString();
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.AprobacionRecursoInformacionMapper());
			 	
		}
	 
	 
	 
	 public void eliminar(AprobacionRecursoInformacion aprobacionRecursoInformacion){
			StringBuffer sqlb = new StringBuffer(SqlConstants.eliminaAprobacionRecursoInformacion);
			String sql =sqlb.toString();
			System.out.println(sql);
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idrecursoinformacion",aprobacionRecursoInformacion.getIdrecursoinformacion());
			simpleJdbcTemplate.update(sql, parametros);
		}
	 
	 
	
	 
	 
	 
	 
	 
	 
	 public void actualizar(AprobacionRecursoInformacion aprobacionrecursoinformacion){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer("update aprobacionrecursoinformacion set idaprobacionrecursoinformacion=idaprobacionrecursoinformacion ");
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			Map<String, Object> parametros = new HashMap<String, Object>();
			//parametros.put("fechaaprobacion", aprobacionrecursoinformacion.getFechaaprobacion());
			parametros.put("idpersonal", aprobacionrecursoinformacion.getPersonal().getIdpersonal());
			parametros.put("idarea", aprobacionrecursoinformacion.getAreaorganica().getIdarea());
			if(aprobacionrecursoinformacion.getFechaaprobacion()!=null){
				parametros.put("fechaaprobacion", new java.sql.Date( aprobacionrecursoinformacion.getFechaaprobacion().getTime())) ;
				
			}
			else{
				parametros.put("fechaaprobacion",null);
				//sqlb.append(", fechaaprobacion=null");
			}
			
			if(aprobacionrecursoinformacion.getPersonal().getIdpersonal()!=0){
				sqlb.append(", idpersonal=:idpersonal");
			}
			if(aprobacionrecursoinformacion.getAreaorganica().getIdarea()!=0){
				sqlb.append(", idarea=:idarea");
			}
			if(aprobacionrecursoinformacion.getFechaaprobacion()!=null){
				sqlb.append(", fechaaprobacion=:fechaaprobacion");
			}
			
			sqlb.append(" where idaprobacionrecursoinformacion=");
			sqlb.append(aprobacionrecursoinformacion.getIdaprobacionrecursoinformacion());
			String sql =sqlb.toString();
			System.out.println(sql);
			simpleJdbcTemplate.update(sql, parametros);
	}
	 
	 
	 
	 
	 
	 
	 
	 
}
