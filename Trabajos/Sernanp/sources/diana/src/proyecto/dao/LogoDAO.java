package proyecto.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Logo;

@Repository 
public class LogoDAO  {

	

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	  
	
	
	public List<Logo> listar(Logo logo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaLogo);
		if(logo.getIdlogo()!=0 ){
			sqlb.append(" and l.idlogo=" );
			sqlb.append(logo.getIdlogo());
		}
		if(logo.getAreanatural().getIdareanatural()!=0 ){
			sqlb.append(" and l.idareanatural=" );
			sqlb.append(logo.getAreanatural().getIdareanatural());
		}
		if(logo.getTipologo().getIdtipo()!=0 ){
			sqlb.append(" and l.idareanatural=" );
			sqlb.append(logo.getTipologo().getIdtipo());
		}
		if(logo.getTipologo().getCodigointtipo()!=0 ){
			sqlb.append(" and tip.codinttablatipo=" );
			sqlb.append(logo.getTipologo().getCodigointtipo());
		}
		if(logo.getTipologo().getIdtipo()!=0 ){
			sqlb.append(" and l.idtipologo=" );
			sqlb.append(logo.getTipologo().getIdtipo());
		}
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.LogoMapper());
		 	
	}
	
	
	
}
