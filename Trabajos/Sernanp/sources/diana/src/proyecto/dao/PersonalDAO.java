package proyecto.dao;

 



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
import proyecto.vo.Archivo;
import proyecto.vo.Personal;
import proyecto.vo.ProyectoArchivo;
import proyecto.vo.Telefono;

@Repository 
public class PersonalDAO  {

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
	  
	public PersonalDAO(){
			dt = new ConexionBD();		
	}
	
	public List<Personal> listar(Personal personal){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonal);
		if(personal.getIdpersonal()!=0 ){
			sqlb.append(" and p.idpersonal=" );
			sqlb.append(personal.getIdpersonal());
		}
		/*
		if(personal.getApepat()!=null ){
			sqlb.append(" and pnat.apepat=" );
			sqlb.append(personal.getApepat());
		}
		if(personal.getApemat()!=null ){
			sqlb.append(" and pnat.apemat=" );
			sqlb.append(personal.getApemat());
		}
		if(personal.getNombre()!=null ){
			sqlb.append(" and pnat.nombre=" );
			sqlb.append(personal.getNombre());
		}
		*/
		if(personal.getIdpersonanatural()!=0 ){
			sqlb.append(" and p.idpersonanatural=" );
			sqlb.append(personal.getIdpersonanatural());
		}
		if(personal.getAreaorganica().getIdarea()!=0 ){
			sqlb.append(" and p.idarea=" );
			sqlb.append(personal.getAreaorganica().getIdarea());
		}
		if(personal.getCargo().getIdcargo()!=0 ){
			sqlb.append(" and p.idcargo=" );
			sqlb.append(personal.getCargo().getIdcargo());
		}
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.PersonalMapper());
		 	
	}
	
	
	
	

	
	
	
	
	
	
	
public List<Personal> listarUnico(Personal personal){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonalUnico);
		if(personal.getIdpersonal()!=0 ){
			sqlb.append(" and p.idpersonal=" );
			sqlb.append(personal.getIdpersonal());
		}
		
		
		if(personal.getApepat()!=null || personal.getApemat()!=null || personal.getNombre()!=null){
			sqlb.append("  and  ( pnat.apepat like '%" );
			sqlb.append(personal.getApepat() );
			sqlb.append("%' " );
			sqlb.append("  or pnat.apemat like '%" );
			sqlb.append(personal.getApemat() );
			sqlb.append("%' " );
			sqlb.append("  or pnat.nombre like '%" );
			sqlb.append(personal.getNombre() );
			sqlb.append("%' )" );
			
		}
		
		if(personal.getIdpersonanatural()!=0 ){
			sqlb.append(" and p.idpersonanatural=" );
			sqlb.append(personal.getIdpersonanatural());
		}
		if(personal.getAreaorganica().getIdarea()!=0 ){
			sqlb.append(" and p.idarea=" );
			sqlb.append(personal.getAreaorganica().getIdarea());
		}
		if(personal.getCargo().getIdcargo()!=0 ){
			sqlb.append(" and p.idcargo=" );
			sqlb.append(personal.getCargo().getIdcargo());
		}
		 String sql =sqlb.toString();
		 System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.PersonalMapper());
		 	
	}
	
	
	
	
	
	
	
	
	public int insertar(Personal personal){
		int codigo=0;
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertaPersonal);
		String sql =sqlb.toString();
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idpersonanatural",personal.getIdpersonanatural());
		parametros.put("idarea", personal.getAreaorganica().getIdarea());
		parametros.put("idcargo", personal.getCargo().getIdcargo());
		parametros.put("mailpersonal", personal.getMailpersonal());
		
		simpleJdbcTemplate.update(sql, parametros);
		codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
		return codigo;	
	}
	
	
	/*
	public void actualizar(Archivo archivo){
		
		StringBuffer sqlb = new StringBuffer("update archivo set idarchivo=idarchivo ");
		if(archivo.getNombreInicial()!=null){
			sqlb.append(",  nombreinicialarchivo='");
			sqlb.append(archivo.getNombreInicial());
			sqlb.append("' ");
		}
		if(archivo.getNombreGenerado()!=null){
			sqlb.append(",  nombregeneradoarchivo='");
			sqlb.append(archivo.getNombreGenerado());
			sqlb.append("' ");
		}
		
		if(archivo.getFechaUpload()!=null){
			sqlb.append(",  fechauploadarchivo='");
			sqlb.append(new java.sql.Date(archivo.getFechaUpload().getTime()));
			sqlb.append("' ");
			
		}
		if(archivo.getDescripcion()!=null){
			sqlb.append(",  descripcionarchivo='");
			sqlb.append(archivo.getDescripcion());
			sqlb.append("' ");
		}
		if(archivo.getUsuario().getIdUsuario()!=0){
			sqlb.append(",  idUsuario=");
			sqlb.append(archivo.getUsuario().getIdUsuario());
			
		}
		if(archivo.getIdarchivoPadre()!=0){
			sqlb.append(",  idarchivo1=");
			sqlb.append(archivo.getIdarchivo());
			
		}
		else
			if(archivo.getIdarchivoPadre()==0){
				sqlb.append(",  idarchivo1=null");
				
				
			} 
		sqlb.append(" where idarchivo=");
		sqlb.append(archivo.getIdarchivo());
		String sql =sqlb.toString();
		//BeanPropertySqlParameterSource namedParameters=new BeanPropertySqlParameterSource(archivo);
		
		simpleJdbcTemplate.update(sql);
		
	
	}
	*/

	
	
	
	
	
}
