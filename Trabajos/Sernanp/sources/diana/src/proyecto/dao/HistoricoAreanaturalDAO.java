package proyecto.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.Querys;
import proyecto.vo.HistoricoAreanatural;
import proyecto.vo.Pais;

@Repository 
public class HistoricoAreanaturalDAO implements Querys {
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	} 
        
	public List<HistoricoAreanatural> listar() {
		return simpleJdbcTemplate.query(    
				HISTORICOLIST, 
				ParameterizedBeanPropertyRowMapper.newInstance(HistoricoAreanatural.class));
	}
	public List<Map<String, Object>> historico(){
		return simpleJdbcTemplate.queryForList(
				HISTORICOBYYEAR );
	}
	
} 
