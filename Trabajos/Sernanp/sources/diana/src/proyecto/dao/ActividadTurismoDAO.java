package proyecto.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Actividadturismo;

@Repository 
public class ActividadTurismoDAO{
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	} 
	public List<Actividadturismo> listar(  ) {
		return simpleJdbcTemplate.query(
				"SELECT a.idactividadeturismo, a.nombreactividadturismo from sernanp.actividadturismo a", 
				ParameterizedBeanPropertyRowMapper.newInstance(Actividadturismo.class));      
	}
	
	public List<Actividadturismo> listar( int idarea ) {
		return simpleJdbcTemplate.query( 
				"SELECT at.idactividadeturismo, at.nombreactividadturismo FROM sernanp.actividadturismo at " +   
				"INNER JOIN sernanp.turismoactividadturismo ta ON ta.idactividadeturismo = at.idactividadeturismo " +  
				"INNER JOIN sernanp.turismo t ON t.idturismo = ta.idturismo  " + 
				"INNER JOIN sernanp.areanatural a ON a.idareanatural =  t.idareanatural AND a.idareanatural = " + idarea, 
				ParameterizedBeanPropertyRowMapper.newInstance(Actividadturismo.class));  
	}
	
	
	
	public List<Actividadturismo> listar(Actividadturismo actividadturismo  ) {
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaActividadTurismo);
		if(actividadturismo.getIdactividadturismo()!=0 ){
			sqlb.append(" and at.idactividadturismo=" );
			sqlb.append(actividadturismo.getIdactividadturismo());
		}
		if(actividadturismo.getTipoturismo().getIdtipoturismo()!=0 ){
			sqlb.append(" and at.idtipoturismo=" );
			sqlb.append(actividadturismo.getTipoturismo().getIdtipoturismo());
		}
		String sql =sqlb.toString();
		//System.out.println(sql);
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.ActividadTurismoMapper());	
	}
	
	
	
	 
}
