package proyecto.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.Querys;
import proyecto.vo.AdministracionAreanatural;

@Repository 
public class AdministracionAreanaturalDAO implements Querys {  
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}   
        
	public List<AdministracionAreanatural> listar() {
		return simpleJdbcTemplate.query(    
				ADMINISTRACIONLIST, 
				ParameterizedBeanPropertyRowMapper.newInstance(AdministracionAreanatural.class));
	} 

	
} 
