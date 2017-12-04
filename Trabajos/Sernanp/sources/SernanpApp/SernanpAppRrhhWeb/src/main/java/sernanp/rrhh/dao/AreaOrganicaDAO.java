package sernanp.rrhh.dao;
 

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.vo.Areaorganica;
  
@Repository 
public class AreaOrganicaDAO  {

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	  
	public AreaOrganicaDAO(){}
	
	public List<Areaorganica> listar(Areaorganica areaorganica){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreaOrganica);
		if(areaorganica.getIdarea()!=0 ){
			sqlb.append(" and ao.idarea=" );
			sqlb.append(areaorganica.getIdarea());
		}
		
		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.AreaorganicaMapper());
		 	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
