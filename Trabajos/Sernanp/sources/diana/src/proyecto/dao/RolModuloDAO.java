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
import proyecto.vo.RolModulo;

@Repository 
public class RolModuloDAO  {

	private ConexionBD dt;

	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	  
	public RolModuloDAO(){
			dt = new ConexionBD();		
	}
	
	
	
	
   public List<RolModulo> listar(RolModulo rolModulo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaRolModulo);
		if(rolModulo.getRol().getIdrol()!=0 ){
			sqlb.append(" and rm.idrol=" );
			sqlb.append(rolModulo.getRol().getIdrol());
		}
		if(rolModulo.getModulo().getIdmodulo()!=0 ){
			sqlb.append(" and rm.idmodulo=" );
			sqlb.append(rolModulo.getModulo().getIdmodulo());
		}
		
		String sql =sqlb.toString();
		
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.RolModuloMapper());
		 	
	}
	
   
	
	
	
	
	
}
