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
import proyecto.vo.Infraccion;
import proyecto.vo.Infractor;

@Repository
public class InfraccionDAO {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	//GENERADOR DE CODIGO;
	
	public int generaCodigo(){
		String sql = SqlConstants.generaCodigoInfraccion;
		
		System.out.println("El codigo generado es : " +sql);
		
		return  this.jdbcTemplate.queryForInt(sql);
		
	}
	
	//VERIFICA DE REINCIDENCIA
	@SuppressWarnings("unchecked")
	public List<Infractor> verificaReincidencia(int dni){
		String sql = SqlConstants.verificaReincidencia;
		sql+="'"+dni+"%'";
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.InfractorMapper());
		
				
	}
	
	//inserta
//	public int insertar(Infraccion	infraccion){
//		int codigo=0;
//
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("numeroexpediente",infraccion.getNumeroinfraccion());
//		
//		parametros.put("fechainfraccion",infraccion.getFecha());
//		
//		parametros.put("idinfractor",infraccion.getInfractor().getIdinfractor());
//		parametros.put("descripcion",infraccion.getDescripcion());
//		
//		parametros.put("fecharesolucion",infraccion.getResolucion().getFecha());
//		
//		parametros.put("numeroresolucion",infraccion.getResolucion().getNumeroresolucion());
//		parametros.put("sancioninfraccion",infraccion.getSancioninfraccion());
//		parametros.put("multainfraccion", Double.valueOf(infraccion.getMultainfraccion()));
//		parametros.put("estadomulta",infraccion.getEstadomulta());
//		parametros.put("nombreinicialarchivo", infraccion.getArchivo().getNombrenicialarchivo());
//		parametros.put("nombregeneradoarchivo", infraccion.getArchivo().getNombregeneradoarchivo());
//		parametros.put("mimearchivo", infraccion.getArchivo().getMime());
//
//		return this.simpleJdbcTemplate.queryForInt(SqlConstants.insertarInfraccion,parametros);
//		
//	}
	
	
	//lista todas las infracciones
	@SuppressWarnings("unchecked")
	public List<Infraccion>listar(){
		String sql = SqlConstants.listaInfracciones;
		return this.jdbcTemplate.query(sql,new RowMappersConstants.InfraccionMapper());
	}
	
	
	
	//LISTA LAS INFRACCIONES POR EL CODIGO DE EXPEDIENTE
	@SuppressWarnings("unchecked")
	public List<Infraccion>listarXExpediente(int codExpediente){
		String sql = SqlConstants.listaInfraccionesXExpediente;

		sql+=""+codExpediente+"";
		// System.out.println("InfraccionDAO List<Infraccion>listarXExpediente : " + sql);
		return this.jdbcTemplate.query(sql,new RowMappersConstants.InfraccionExpedienteMapper());
	}
	
	// JCEV 04-10-2012 Para las reicidencias en el Listado de Infracciones
	@SuppressWarnings("unchecked")
	public List<Infraccion> cuentaReincidenciaXExpedienteInfraccion(int idInfractor, int idInfraccion){
		String strSql = SqlConstants.cuentaReincidenciaXExpedienteInfraccion;
		strSql += " exp.idinfractor  = " + idInfractor + " and " + 
				  " ein.idinfraccion = " + idInfraccion + 				 
				  " GROUP BY ein.idinfraccion " +
				  " HAVING Count(ein.idinfraccion) > 1";
		// System.out.println("sql : " + strSql);
		return this.jdbcTemplate.query(strSql, 
				                       new RowMappersConstants.InfraccionXExpedienteInfractorMapper());
	}


}
