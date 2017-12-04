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
import proyecto.vo.Autor;

@Repository 
public class AutorDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
		
		
   public List<Autor> listar(Autor autor){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAutor);
		if(autor.getIdautor()!=0 ){
			sqlb.append(" and a.idautor=" );
			sqlb.append(autor.getIdautor());
		}
		if(autor.getNombre()!=null ){
			sqlb.append("  and pnat.nombre like '%" );
			sqlb.append(autor.getNombre() );
			sqlb.append("%' " );
		}
		if(autor.getApepat()!=null ){
			sqlb.append("  and pnat.apepat like '%" );
			sqlb.append(autor.getApepat() );
			sqlb.append("%' " );
		}
		if(autor.getApemat()!=null ){
			sqlb.append("  and pnat.apemat like '%" );
			sqlb.append(autor.getApemat() );
			sqlb.append("%' " );
		}
		 String sql =sqlb.toString();
		 System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.AutorMapper());
		 	
	}
	 
   
   
   
   
   
   
   public List<Autor> listarUnico(Autor autor){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAutorUnico);
		if(autor.getIdautor()!=0 ){
			sqlb.append(" and a.idautor=" );
			sqlb.append(autor.getIdautor());
		}
		if(autor.getApepat()!=null || autor.getApemat()!=null || autor.getNombre()!=null){
			sqlb.append("  and  ( pnat.apepat like '%" );
			sqlb.append(autor.getApepat() );
			sqlb.append("%' " );
			sqlb.append("  or pnat.apemat like '%" );
			sqlb.append(autor.getApemat() );
			sqlb.append("%' " );
			sqlb.append("  or pnat.nombre like '%" );
			sqlb.append(autor.getNombre() );
			sqlb.append("%' )" );
			
		}
		
		
		 String sql =sqlb.toString();
		 System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.AutorMapper());
		 	
	}
   
   
   
   
   
   
	 
	 public int insertar(Autor autor){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaAutor);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idpersonanatural",autor.getIdpersonanatural() );
			simpleJdbcTemplate.update(sql, parametros);
			codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
			return codigo;	
		}
	
	 
	 
	 
	 
	
}
