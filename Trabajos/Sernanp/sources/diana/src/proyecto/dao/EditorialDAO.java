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
import proyecto.vo.Editorial;

@Repository 
public class EditorialDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
		
		
   public List<Editorial> listar(Editorial editorial){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaEditorial);
		if(editorial.getIdeditorial()!=0 ){
			sqlb.append(" and e.ideditorial=" );
			sqlb.append(editorial.getIdeditorial());
		}
		if(editorial.getNombrepersonajuridica()!=null ){
			sqlb.append("  and pj.nombrepersonajuridica like '%" );
			sqlb.append(editorial.getNombrepersonajuridica() );
			sqlb.append("%' " );
			
		}
		 String sql =sqlb.toString();
		 System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.EditorialMapper());
		 	
	}
	 
	 
	 public int insertar(Editorial editorial){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaEditorial);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idpersonajuridica",editorial.getIdpersonajuridica() );
			simpleJdbcTemplate.update(sql, parametros);
			codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
			return codigo;	
		}
	
	 
	 
	 
	 
	
}
