package sernanp.rrhh.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.vo.PersonalActividadVO;

public class PersonalActividadDAO {

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);	
	}
	
	public List<PersonalActividadVO> listMotivoMarcacionJustificaInasistenciaCGH(){
		
		StringBuffer sqlb 	= new StringBuffer(SqlConstants.listMotivoMarcacionJustificaInasistenciaCGH);
		String sql 			= sqlb.toString();	 
//		System.out.println(sql);
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.listMotivoMarcacion());
	}
	
	
	
	public List<PersonalActividadVO> listMotivoMarcacionJustificaInasistenciaCGH_SGH(){
		
		StringBuffer sqlb 	= new StringBuffer(SqlConstants.listMotivoMarcacionJustificaInasistenciaCGH_SGH);
		String sql 			= sqlb.toString();	 
//		System.out.println("Actividades : " + sql);
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.listMotivoMarcacion());
	}
	
	
	
	public List<PersonalActividadVO> listMotivoPapeleta(){
		
		StringBuffer sqlb	= new StringBuffer(SqlConstants.listMotivoPapeleta);
		String sql			= sqlb.toString();
		
		return this.jdbcTemplate.query(sql, new RowMappersConstants.listMotivoMarcacion());
		
	}
	
}
