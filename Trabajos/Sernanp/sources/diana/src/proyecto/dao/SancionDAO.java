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
import proyecto.vo.ExpedienteSancion;
import proyecto.vo.Infraccion;
import proyecto.vo.Sancion;

@Repository
public class SancionDAO {

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

	
	//listar sanciones
	
	@SuppressWarnings("unchecked")
	public List<Sancion> listar(){
		String sql = SqlConstants.listaSancion;
		return this.jdbcTemplate.query(sql,new RowMappersConstants.SancionMapper());
	}
	
	
	//LISTA LAS INFRACCIONES POR EL CODIGO DE EXPEDIENTE
	@SuppressWarnings("unchecked")
	public List<Sancion>listarXExpediente(int codExpediente){
		String sql = SqlConstants.listaSancionesXExpediente;

		sql+=""+codExpediente+"";
		
		return this.jdbcTemplate.query(sql,new RowMappersConstants.SancionMapper());
	}
	
	/*// Lista los detalles de las Sanciones X Expediente
	@SuppressWarnings("unchecked")
	public List<DetalleExpedienteSancion>listarDetalleExpedienteSancion(int idExpediente){
		String sql = SqlConstants.listaSancionesXExpediente;
		sql += "" + idExpediente + "";		
		return this.jdbcTemplate.query(sql,new RowMappersConstants.SancionMapper());
	}
	*/
	@SuppressWarnings("unchecked")
	public List<ExpedienteSancion>listarExpedienteSancion(int codExpediente){
		String sql = SqlConstants.listaSancionesXExpediente;

		sql+=""+codExpediente+"";
		
		return this.jdbcTemplate.query(sql,new RowMappersConstants.ExpedienteSancionMapper());
	}
	
	
}
