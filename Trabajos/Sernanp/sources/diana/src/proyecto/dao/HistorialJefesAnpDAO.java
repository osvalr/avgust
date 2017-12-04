package proyecto.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Areanatural;
import proyecto.vo.HistorialJefesAnp;

public class HistorialJefesAnpDAO {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

public List<HistorialJefesAnp> listarActualJefe(Areanatural an){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listarJefesAnp);
		sqlb.append("WHERE hja.idareanatural = ");
		sqlb.append(an.getIdareanatural());
		sqlb.append(" ORDER BY hja.fechadesigna DESC LIMIT 1");
		
		String sql =sqlb.toString();
				
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.JefesAnpMapper());
		
	}
	
	//listarActualJefe
}
