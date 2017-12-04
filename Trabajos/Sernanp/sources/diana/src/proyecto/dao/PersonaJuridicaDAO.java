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
import proyecto.vo.Personajuridica;

@Repository
public class PersonaJuridicaDAO  {


	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void actualizar(Personajuridica personajuridica ){
		StringBuffer sqlb = new StringBuffer("update sernanp.personajuridica set idpersonajuridica=idpersonajuridica ");
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombrepersonajuridica",personajuridica.getNombrepersonajuridica());
		parametros.put("razonsocial",personajuridica.getRazonsocial());
		parametros.put("siglas",personajuridica.getSiglas());
		
		if(personajuridica.getNombrepersonajuridica()!=null){
			sqlb.append(", nombrepersonajuridica=:nombrepersonajuridica");
		}
		if(personajuridica.getRazonsocial()!=null){
			sqlb.append(", razonsocial=:razonsocial");
		}
		if(personajuridica.getSiglas()!=null){
			sqlb.append(", siglas=:siglas");
		}
		sqlb.append(" where idpersonajuridica=");
		sqlb.append(personajuridica.getIdpersonajuridica());
		String sql =sqlb.toString();
		simpleJdbcTemplate.update(sql, parametros);
	}
   
	
	public int insertarNoDuplicado(Personajuridica personajuridica) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombre",personajuridica.getNombrepersonajuridica() );
		parametros.put("razonsocial",personajuridica.getRazonsocial() );
		parametros.put("siglas",personajuridica.getSiglas() );
		parametros.put("ruc",personajuridica.getRuc() );
		parametros.put("direccion",personajuridica.getDireccion());
		parametros.put("telefono",personajuridica.getTelefono() );
		parametros.put("correopersonal",personajuridica.getCorreopersonal() );
		parametros.put("correoinstitucional",personajuridica.getCorreoinstitucional() );
		if(personajuridica.getPais().getIdpais()!=0){
			parametros.put("idpais",personajuridica.getPais().getIdpais() );
		}else{
			parametros.put("idpais",null );
		}
		if(personajuridica.getUbigeo().getIdubigeo()!=0){
			parametros.put("idubigeo",personajuridica.getUbigeo().getIdubigeo() );
		}else{
			parametros.put("idubigeo",null );
		}
		return  simpleJdbcTemplate.queryForInt(SqlConstants.insertaNoDuplicadoPersonaJuridica, parametros);
	}
   
    public List<Personajuridica> listarPersonaJuridica(int idpersonaj){
    	StringBuffer sqlb = new StringBuffer(SqlConstants.listaPersonaJuridica);
    	if(idpersonaj!=0 ){
 			sqlb.append(" and pj.idpersonajuridica=" );
 			sqlb.append(idpersonaj);
 		}
		String sql =sqlb.toString();
		
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.PersonaJuridicaMapper());
    }
	
}
