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
import proyecto.vo.Directorioarchivo;
import proyecto.vo.DirectorioarchivoModulo;

@Repository 
public class DirectorioArchivoModuloDAO  {



	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	  
	
	
	
	
	
	
public List<Directorioarchivo> listarDirectorio(DirectorioarchivoModulo directorioarchivoModulo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaDirectorioArchivoModulo);
		if(directorioarchivoModulo.getModulo().getIdmodulo()!=0 ){
			sqlb.append(" and da.idmodulo=" );
			sqlb.append(directorioarchivoModulo.getModulo().getIdmodulo());
		}
		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.DirectorioArchivoMapper());
		 	
}
	

public List<DirectorioarchivoModulo> listarDirectorioModulo(int idMod){
	
	StringBuffer sqlb = new StringBuffer(SqlConstants.listaDirectorioArchivoModulo);
	if(idMod !=0 ){
		sqlb.append(" and da.idmodulo=" );
		sqlb.append(idMod);
	}
	
	 String sql =sqlb.toString();
	 	 	 
	 return  this.jdbcTemplate.query(sql, new RowMappersConstants.DirectorioArchivoModuloMapper());
	 	
}
	
	
	
	
	
	
	
	
	
	
	
}
