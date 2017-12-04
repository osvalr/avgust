package sernanp.rrhh.dao;

 



import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.vo.Persona;

@Repository 
public class PersonaDAO  {

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void actualizar(Persona persona ){
		StringBuffer sqlb = new StringBuffer("update sernanp.persona set idpersona=idpersona ");
		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("direccion",persona.getDireccion());
		parametros.put("telefono",persona.getTelefono());
		parametros.put("correopersonal",persona.getCorreopersonal());
		parametros.put("correoinstitucional",persona.getCorreoinstitucional());
//		parametros.put("ruc",persona.getRuc());
		parametros.put("idubigeo",persona.getUbigeo().getIdubigeo());
		parametros.put("idpais",persona.getPais().getIdpais());
//		if(persona.getDireccion()!=null){
//			sqlb.append(", direccion=:direccion");
//		}
		if(persona.getTelefono()!=null){
			sqlb.append(", telefono=:telefono");
		}
		if(persona.getCorreopersonal()!=null){
			sqlb.append(", correopersonal=:correopersonal");
		}
		if(persona.getCorreoinstitucional()!=null){
			sqlb.append(", correoinstitucional=:correoinstitucional");
		}
//		if(persona.getRuc()!=null){
//			sqlb.append(", ruc=:ruc");
//		}
		if(persona.getUbigeo().getIdubigeo()!=0){
			sqlb.append(", idubigeo=:idubigeo");
		}
		if(persona.getPais().getIdpais()!=0){
			sqlb.append(", idpais=:idpais ");
		}
		sqlb.append(" where idpersona=");
		sqlb.append(persona.getIdpersona());
		String sql =sqlb.toString();
		simpleJdbcTemplate.update(sql, parametros);
	}
  
	
    
    
	 public int contarUnico(Persona persona) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.contarRucUnicoPersona);
//		 if(persona.getRuc()!=null){
//			 sqlb.append(" and ruc='");
//			 sqlb.append(persona.getRuc());
//			 sqlb.append("'");
//		 }
		 if(persona.getIdpersona()!=0){
			 sqlb.append(" and idpersona!=");
			 sqlb.append(persona.getIdpersona()); 
		 }
		 
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		return  this.jdbcTemplate.queryForInt(sql);
	}
	
    
   

   
 
   
    
	
}
