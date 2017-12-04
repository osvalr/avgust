package proyecto.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.SqlConstants;
import proyecto.vo.Expediente;

@Repository
public class ResolucionDAO {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate         = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate               = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	// Insertar, devuelve el id de la resolucion insertada
	// JCEV, se ha actualizada e incluido el Procedimiento Almacenado del SqlConstants.insertarResolucion
	// Actualizado 12:25 pm 17-09-2012
	public int insertar(Expediente ex) throws Exception {
		String sql                = null;
		Map<String, Object> param = null;
		sql   = SqlConstants.insertarResolucion_sf;
		param = new HashMap<String, Object>();
		if(ex.getResolucion().getArchivo() != null){
			sql = SqlConstants.insertarResolucion;
			param.put("nombreinicialarchivo",  ex.getResolucion().getArchivo().getNombreinicial());  // 1
			param.put("nombregeneradoarchivo", ex.getResolucion().getArchivo().getNombregenerado()); // 2
			param.put("mimearchivo",           ex.getResolucion().getArchivo().getMimearchivo());    // 3
			param.put("iddirectorioarchivo",   ex.getResolucion().getArchivo().getDirectorioarchivo().getIddirectorioarchivo()); // 7
		}
		param.put("fecharesolucion",  ex.getResolucion().getFecharesolucion());  // 4
		param.put("numeroresolucion", ex.getResolucion().getNumeroresolucion());  // 5
		
		// JCEV 13-09-2012 Se agrego la Fecha de notificacion
		param.put("fechanotificacion", ex.getResolucion().getFechanotificacion()); // 6
		
		
		// JCEV 18-10-2012 Se agrego el año de la resolucion
		param.put("annoresolucion", ex.getResolucion().getAnnoresolucion()); // 7
		
		return this.simpleJdbcTemplate.queryForInt(sql, param);		
	}
	
	public void actualizar(Expediente ex){		
		String sql    = "";
		int idarchivo = this.idArchivoUpdate(ex);
		if(idarchivo != 0){		
		    sql = "update sernanp.resolucion set fecharesolucion = to_date(:fecharesolucion, 'DD-MM-YYYY'), " +
		          "numeroresolucion = :numeroresolucion, idarchivo = " + idarchivo + " ";
		}else{
			sql = "update sernanp.resolucion set fecharesolucion = to_date(:fecharesolucion, 'DD-MM-YYYY'), " +
		          "numeroresolucion = :numeroresolucion ";
		}
		sql += "fechanotificacion = to_date(:fechanotificacion, 'DD-MM-YYYY') where idresolucion = :idresolucion";
		Map<String, Object> parametros = new HashMap<String, Object>();					
		parametros.put("fecharesolucion", ex.getResolucion().getFecha());
		parametros.put("numeroresolucion",ex.getResolucion().getNumeroresolucion());
		parametros.put("fechanotificacion", ex.getResolucion().getFechanotificacion());
		parametros.put("idresolucion",ex.getResolucion().getIdresolucion());
		simpleJdbcTemplate.update(sql, parametros);
	}
	
	public int idArchivoUpdate(Expediente ex){
		if(ex.getResolucion().getArchivo() != null){
			Map<String, Object> parametros = new HashMap<String, Object>();			
			parametros.put("nombreinicialarchivo", ex.getResolucion().getArchivo().getNombreinicial());
			parametros.put("nombregeneradoarchivo",ex.getResolucion().getArchivo().getNombregenerado());
			parametros.put("mimearchivo", ex.getResolucion().getArchivo().getMimearchivo());
			parametros.put("iddirectorioarchivo",ex.getResolucion().getArchivo().getDirectorioarchivo().getIddirectorioarchivo());
			String strSql = SqlConstants.insertarArchivo;
			return simpleJdbcTemplate.queryForInt(strSql, parametros);
		}
		return 0;
	}

}