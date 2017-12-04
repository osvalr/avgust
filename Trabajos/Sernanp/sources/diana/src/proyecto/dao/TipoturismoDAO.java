package proyecto.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Rutaturismo;
import proyecto.vo.Tipoturismo;

@Repository 
public class TipoturismoDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;  
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) { 
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);

	}

	public List<Tipoturismo> listar() {
		return simpleJdbcTemplate.query( 
				"select idtipoturismo,nombretipoturismo from tipoturismo",
				ParameterizedBeanPropertyRowMapper.newInstance(Tipoturismo.class)); 
	} 

	public List<Tipoturismo> listar(int idarea) {
		return simpleJdbcTemplate.query(     
				"SELECT DISTINCT  tt.idtipoturismo, tt.nombretipoturismo FROM sernanp.tipoturismo tt " + 
				"INNER JOIN sernanp.rutaturismotipoturismo rt ON rt.idtipoturismo = tt.idtipoturismo " +
				"INNER JOIN sernanp.rutaturismo r ON r.idrutaturismo = rt.idrutaturismo " +
				"INNER JOIN sernanp.turismo t ON t.idturismo = r.idturismo " +
				"AND t.idareanatural  = " +   
				idarea,
				ParameterizedBeanPropertyRowMapper.newInstance(Tipoturismo.class));
	}
	public List<Tipoturismo> listarxRuta(int idrutaturismo){

		return simpleJdbcTemplate.query(     
				"SELECT DISTINCT  tt.idtipoturismo, tt.nombretipoturismo " +
				"FROM sernanp.tipoturismo tt " + 
				"INNER JOIN sernanp.rutaturismotipoturismo rt ON rt.idtipoturismo = tt.idtipoturismo " +
				"WHERE rt.idrutaturismo = " +   
				idrutaturismo, 
				ParameterizedBeanPropertyRowMapper.newInstance(Tipoturismo.class));
	}
	
	
	 public List<Tipoturismo> listarTipoturismo(Tipoturismo tipoturismo){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoTurismo);	
			if(tipoturismo.getIdtipoturismo()!=0){
				sqlb.append(" and t.idtipoturismo=");
				sqlb.append(tipoturismo.getIdtipoturismo());
			}
			 String sql =sqlb.toString();
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoturismoMapper());
	}
	 
	
	 
	 
	 public List<Tipoturismo> listarTipoturismoxRutaturismo(Rutaturismo rutaturismo){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoturismoxRutaturismo);	
			if(rutaturismo.getIdrutaturismo()!=0){
				sqlb.append(" and rttipotur.idrutaturismo=");
				sqlb.append(rutaturismo.getIdrutaturismo());
			}
			 String sql =sqlb.toString();
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoturismoMapper());
			 	
	} 
	 
	 
	
	
	
}
