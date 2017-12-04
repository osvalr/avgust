package sernanp.rrhh.dao;

 



import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.vo.PersonalContratoVO;
import sernanp.rrhh.vo.Personanatural;

@Repository 
public class PersonaNaturalDAO  {


	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);	
	}
		
	
	public List<Personanatural> listarPersonal(){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listarpersonal);				
				
		String sql =sqlb.toString();

		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.Personal());
		 	
	}

	
}
