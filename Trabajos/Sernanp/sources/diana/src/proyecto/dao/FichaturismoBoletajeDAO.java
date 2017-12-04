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
import proyecto.vo.Fichaturismo;
import proyecto.vo.FichaturismoBoletaje;
import proyecto.vo.Visitante;
import proyecto.vo.VisitanteConceptoexoneracionpago;

@Repository 
public class FichaturismoBoletajeDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
	 
	 public void insertar(FichaturismoBoletaje fichaBoletaje){
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaFichaturismoBoletaje);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idfichaturismo",fichaBoletaje.getIdfichaturismo());
			parametros.put("idboletaje", fichaBoletaje.getBoletaje().getIdboletaje());
			parametros.put("cantidad", fichaBoletaje.getCantidad());
			simpleJdbcTemplate.update(sql, parametros);
	}
	
	
	 
	
}
