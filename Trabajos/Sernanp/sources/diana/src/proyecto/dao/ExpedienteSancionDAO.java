package proyecto.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Expediente;
import proyecto.vo.ExpedienteSancion;

@Repository
public class ExpedienteSancionDAO {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate         = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate               = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	// JCEV 16-09-2012 Antigua Version
	public int insertar(int idExpediente, int idSancion, int estado){
		String strSql                 = SqlConstants.insertarExpedienteSancion;
		Map<String,Object> parametros = new HashMap<String, Object>();
		parametros.put("idExpediente",idExpediente);
		parametros.put("idSancion", idSancion);
		parametros.put("estado", estado);
		return this.simpleJdbcTemplate.queryForInt(strSql,parametros);
	}
	
	// JCEV 16-09-2012 Nueva Version
	public int insertarExpedienteSancion(int idExpediente, int idSancion, int estado){
		String strSql                 = SqlConstants.insertarExpedienteSancion;
		Map<String,Object> parametros = new HashMap<String, Object>();
		parametros.put("idExpediente",idExpediente);
		parametros.put("idSancion", idSancion);
		parametros.put("estado", estado);
		return this.simpleJdbcTemplate.queryForInt(strSql,parametros);
	}

	// JCEV 17-09-2012 Creando el Detalle del ExpedienteSancion
	public int insertarDetalleExpedienteSancion(int idExpediente, int idSancion, int estado, String strDato,
			                                    String strObserv, int idExpsancion){
		String strSql                 = SqlConstants.insertarDetalleExpedienteSancion;
		Map<String,Object> parametros = new HashMap<String, Object>();
		parametros.put("idExpediente",idExpediente);
		parametros.put("idSancion", idSancion);
		parametros.put("estado", estado);
		parametros.put("datovariado", strDato);
		parametros.put("observacion", strObserv);
		parametros.put("idexpsancion", idExpsancion);
		return this.simpleJdbcTemplate.queryForInt(strSql,parametros);
	}
	
	public int eliminar(Expediente exp){
		String strSql = "delete from sernanp.expedientesancion  where idexpediente = " + exp.getIdexpediente();
		return this.jdbcTemplate.update(strSql);
	}
	
	@SuppressWarnings("unchecked")
	public List<Expediente> listarXNumDoc(Expediente expediente){
		String sql = SqlConstants.listarExpedientes;
		sql        += " and pn.numerodoc='" + expediente.getInfractor().getNumerodocumento() + "'";
		if(expediente.getIdareanatural()!=0){
			sql += " and exp.idareanatural= " + expediente.getIdareanatural();
		}		
		return this.jdbcTemplate.query(sql,new RowMappersConstants.ExpedienteMapper());
	}
	
	public List<ExpedienteSancion> listarExpedienteSancion(int idExp){
		
		String strSql = SqlConstants.listarExpedienteSancion;		
		strSql += "" + idExp + "";
		
		return this.jdbcTemplate.query(strSql, new RowMappersConstants.ExpedienteSancionMapper());
	}

	// JCEV 05-10-2012 Verifica Morosidad para el Listado de Infracciones
	public String listarMorosidad(int idExpediente){
		String strSql = null;
		String strRet = null;
	  	int nRet      = 0;
		try {			
			strRet = "No";
			//nRet   = this.extraeFlagMorocidad(idExpediente);			
			
			//if(nRet == 1){
			   strSql = SqlConstants.verificarMorosidadExpediente;		
			   strSql += "" + idExpediente + "";
			   
			   nRet   = this.jdbcTemplate.queryForInt(strSql);
			   //System.out.println("strSql : " + strSql + " nRet. : " + nRet);
			   if(nRet < 0){
				  strRet = "Si";
			   }
			//}
			
			//System.out.println(strSql);
		} catch (EmptyResultDataAccessException e) {
			//strRet = "No";
			strRet = "--";
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("ListaMorosidad : " + strRet);
		return strRet;
	}	

	// JCEV 05-10-2012 Verifica Morosidad para el Listado de Infracciones
	public String xlistarMorosidad(int idExpediente){
		String strSql = null;
		String strRet = null;
	  	int nRet      = 0;
		try {			
			strSql = SqlConstants.verificarMorosidadExpediente;		
			strSql += "" + idExpediente + "";
			strSql += " ORDER BY exp.idexpediente";
			nRet   = this.jdbcTemplate.queryForInt(strSql);			
			nRet   = this.extraeFlagMorocidad(idExpediente);			
			strRet = "NO";
			if(nRet > 0){
				strRet = "SI";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strRet;
	}	

	// JCEV 11-10-2012 Verifica el Flag de Morosidad para el Listado de Infracciones
	public int extraeFlagMorocidad(int idExpediente){
		String strSql = null;
	  	int nRet      = 0;
		try {			
			strSql = SqlConstants.verificarFlagMorosidadExpediente;		
			strSql += "" + idExpediente + "";
			nRet   = this.jdbcTemplate.queryForInt(strSql);
//			System.out.println("FlagMoroso : " + nRet);
		} catch (DataAccessException e) {
			//System.out.println("Administrador - Sistemas (extraeFlagMorocidad)");
			nRet = 0;
		}
		return nRet;
	}
	
}

/*
  	
	public void insertar(int idexpediente,int idsancion,String observacion){
		String sql = SqlConstants.insertarExpedienteSancion;
		
		Map<String,Object> parametros = new HashMap<String, Object>();
		parametros.put("idexpediente", idexpediente);
		parametros.put("idsancion", idsancion);
		parametros.put("observacion", observacion);
		
		int codigo= this.simpleJdbcTemplate.queryForInt(sql, parametros);
	}

	
	public int actualizar(Expediente exp){
		String sql = "update sernanp.multa set montomulta=" + exp.getMulta().getMontomulta() + 
				     ", estadomulta="+exp.getMulta().getEstadomulta() +
		             "where idmulta = "+exp.getMulta().getMontomulta();		
		return this.jdbcTemplate.update(sql);
	}


 
 */

/*
 //inserta expediente infraccion

public void insertar(int idexpediente, int idinfraccion){
	String sql = SqlConstants.insertarExpedienteInfraccion;
	
	Map<String,Object> parametros = new HashMap<String, Object>();
	parametros.put("idexpediente", idexpediente);
	parametros.put("idinfraccion", idinfraccion);
	
	int codigo= this.simpleJdbcTemplate.queryForInt(sql,parametros);
}
 */
