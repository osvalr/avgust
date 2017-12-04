package proyecto.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository 
public class BaseDAO {

	protected SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) { 
		this.setSimpleJdbcTemplate(new SimpleJdbcTemplate(dataSource));
	}
	
	public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}
	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}   
       
	
}
