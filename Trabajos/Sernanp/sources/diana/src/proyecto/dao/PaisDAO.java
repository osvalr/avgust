package proyecto.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Autor;
import proyecto.vo.Pais;

@Repository 
public class PaisDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	 private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	
	/*
	public List<Pais> listar() {
		return simpleJdbcTemplate.query(
				"SELECT * FROM sernanp.pais",
				ParameterizedBeanPropertyRowMapper.newInstance(Pais.class));
	}
	*/
	
	 public List<Pais> listar(Pais pais){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaPais);
			sqlb.append(" order by p.nompais ");
			 String sql =sqlb.toString();
			 //System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.PaisMapper());
			 	
		}
	
}
