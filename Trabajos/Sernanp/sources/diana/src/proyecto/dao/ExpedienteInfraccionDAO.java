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
import proyecto.vo.Expediente;

@Repository
public class ExpedienteInfraccionDAO {

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

	// JCEV 16-09-2012 Version Antigua, Version Nueva: insertaExpedienteInfraccion
	// Inserta expediente infraccion
	public void insertar(int idexpediente, int idinfraccion, int reincidencia){
		String strSql                 = SqlConstants.insertarExpedienteInfraccion;		
		Map<String,Object> parametros = new HashMap<String, Object>();
		parametros.put("idexpediente", idexpediente);
		parametros.put("idinfraccion", idinfraccion);
		parametros.put("reincidencia", reincidencia);		
		int codigo= this.simpleJdbcTemplate.queryForInt(strSql,parametros);
	}
	
	// Inserta expediente infraccion
	// JCEV 16-09-2012
	public void insertaExpedienteInfraccion(int idExpediente, int idInfraccion, int reincidencia) throws Exception {
		String strSql                 = null;		
		Map<String,Object> parametros = null;
		int codigo                    = -1;
		try {
			strSql     = SqlConstants.insertarExpedienteInfraccion;		
			parametros = new HashMap<String, Object>();
			parametros.put("idexpediente", idExpediente);
			parametros.put("idinfraccion", idInfraccion);
			parametros.put("reincidencia", reincidencia);		
			codigo     = this.simpleJdbcTemplate.queryForInt(strSql,parametros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Lista los infracciones;
	@SuppressWarnings("unchecked")
	public List<ExpedienteInfraccionDAO> listarXIDExpediente(Expediente expediente){
		String sql = SqlConstants.listaInfraccionesXExpediente;
		sql        += "" + expediente.getIdexpediente() + "";
		return this.jdbcTemplate.query(sql,new RowMappersConstants.InfraccionMapper());
	}
	
	public int eliminar(Expediente exp){
		String sql = "delete  from sernanp.expedienteinfraccion  where idexpediente=" + exp.getIdexpediente();
		return this.jdbcTemplate.update(sql);
	}
	
}