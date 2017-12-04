package proyecto.dao;

 

  

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Areaorganica;
  
@Repository 
public class AreaOrganicaDAO  {

	private ConexionBD dt;

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	  
	public AreaOrganicaDAO(){
			dt = new ConexionBD();		
	}
	
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
