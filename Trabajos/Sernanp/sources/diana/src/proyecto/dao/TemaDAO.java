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
import proyecto.vo.Tema;

@Repository 
public class TemaDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Tema> listar(Tema tema){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTema);
		if(tema.getIdtema()!=0 ){
			sqlb.append(" and t.idtema=" );
			sqlb.append(tema.getIdtema());
		}
		if(tema.getNombretema()!=null ){
			sqlb.append("  and t.nombretema like '%" );
			sqlb.append(tema.getNombretema() );
			sqlb.append("%' " );
		}
		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TemaMapper());
		 	
	}
	
	
	
	public int insertar(Tema tema){
		int codigo=0;
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertaTema);
		String sql =sqlb.toString();
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombretema",tema.getNombretema() );
		simpleJdbcTemplate.update(sql, parametros);
		codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
		return codigo;	
	}
	

}
