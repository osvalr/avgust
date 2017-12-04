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
import proyecto.vo.HistFichaturismoAccion;

@Repository 
public class HistFichaturismoAccionDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
	 
	 public int insertar(HistFichaturismoAccion histFichaturismoAccion){
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaHistFichaturismoAccion);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idfichaturismo", histFichaturismoAccion.getIdfichaturismo());
			parametros.put("idtipoaccionficha", histFichaturismoAccion.getTipoaccionficha().getIdtipo());
			parametros.put("fecha", histFichaturismoAccion.getFecha());
			parametros.put("idusuario", histFichaturismoAccion.getUsuario().getIdUsuario());
			return simpleJdbcTemplate.queryForInt(sql, parametros);
	}
	 
	
	 public List<HistFichaturismoAccion> listar(HistFichaturismoAccion histFichaturismoAccion){
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaHistorialFichaTurismoAccion);
			if(histFichaturismoAccion.getIdfichaturismo()!=0){
				sqlb.append(" and idfichaturismo=");
				sqlb.append(histFichaturismoAccion.getIdfichaturismo());
			} 
			String sql =sqlb.toString();
			//System.out.println(sql);
			return  this.jdbcTemplate.query(sql, new RowMappersConstants.HistFichaturismoAccionMapper());		 	
	}
	
	
	

	 
}
