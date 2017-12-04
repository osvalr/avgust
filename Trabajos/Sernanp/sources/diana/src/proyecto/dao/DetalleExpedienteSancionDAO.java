package proyecto.dao;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.DetalleExpedienteSancion;

@Repository
public class DetalleExpedienteSancionDAO {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate         = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate               = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@SuppressWarnings("unchecked")
	public List<DetalleExpedienteSancion>listarDetalleExpedienteSancion(int idexpediente){
		String strSql = SqlConstants.listarDetalleExpedienteSancion;		
		strSql += "" + idexpediente + "";
		return this.jdbcTemplate.query(strSql, new RowMappersConstants.DetalleExpedienteSancionMapper());
	}

}