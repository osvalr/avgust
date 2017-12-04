package proyecto.dao;

 



import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Documento;

@Repository 
public class DocumentoLogoAreaNaturalDAO  {



	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	  
	
	
	
	
	
	
    public List<Documento> listarDocumento(int idareanatural){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaDocumentoLogoAreaNatural);
		if(idareanatural!=0 ){
			sqlb.append(" and dla.idareanatural=" );
			sqlb.append(idareanatural);
		}
		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.DocumentoMapper());
		 	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
