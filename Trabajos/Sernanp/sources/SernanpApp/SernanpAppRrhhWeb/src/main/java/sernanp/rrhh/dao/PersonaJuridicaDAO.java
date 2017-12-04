package sernanp.rrhh.dao;

 



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.vo.Personajuridica;

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
	
   
	
}
