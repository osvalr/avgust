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
import proyecto.util.ConexionBD;
import proyecto.vo.Archivo;
import proyecto.vo.ProyectoArchivo;

@Repository 
public class ArchivoDAOold  {

	private ConexionBD dt;

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	  
	public ArchivoDAOold(){
			dt = new ConexionBD();		
	}
	
	public List<Archivo> listar(Archivo archivo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaArchivo);
		if(archivo.getIdarchivo()!=0 ){
			sqlb.append(" and a.idarchivo=" );
			sqlb.append(archivo.getIdarchivo());
		}
		if(archivo.getIdarchivoPadre()!=0 ){
			sqlb.append(" and a.idarchivopadre=" );
			sqlb.append(archivo.getIdarchivoPadre());
		}
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.ArchivoMapper());
		 	
	}
	
	
	
	public int insertar(Archivo archivo){
		int codigo=0;
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertaArchivo);
		String sql =sqlb.toString();
		//BeanPropertySqlParameterSource namedParameters=new BeanPropertySqlParameterSource(archivo);
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombreinicial",archivo.getNombreInicial() );
		parametros.put("nombregenerado", archivo.getNombreGenerado());
		parametros.put("fechaupload", archivo.getFechaUpload());
		parametros.put("descripcion", archivo.getDescripcion());
		parametros.put("idUsuario", archivo.getUsuario().getIdUsuario());
		if(archivo.getIdarchivoPadre()!=0){
			parametros.put("idarchivopadre",archivo.getIdarchivoPadre() );
		}
		else
			if(archivo.getIdarchivoPadre()==0){
			parametros.put("idarchivopadre",null );
		}
		simpleJdbcTemplate.update(sql, parametros);
		codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
		return codigo;	
	}
	public void actualizar(Archivo archivo){
		
		StringBuffer sqlb = new StringBuffer("update archivo set idarchivo=idarchivo ");
		if(archivo.getNombreInicial()!=null){
			sqlb.append(",  nombreinicialarchivo='");
			sqlb.append(archivo.getNombreInicial());
			sqlb.append("' ");
		}
		if(archivo.getNombreGenerado()!=null){
			sqlb.append(",  nombregeneradoarchivo='");
			sqlb.append(archivo.getNombreGenerado());
			sqlb.append("' ");
		}
		
		if(archivo.getFechaUpload()!=null){
			sqlb.append(",  fechauploadarchivo='");
			sqlb.append(new java.sql.Date(archivo.getFechaUpload().getTime()));
			sqlb.append("' ");
			
		}
		if(archivo.getDescripcion()!=null){
			sqlb.append(",  descripcionarchivo='");
			sqlb.append(archivo.getDescripcion());
			sqlb.append("' ");
		}
		if(archivo.getUsuario().getIdUsuario()!=0){
			sqlb.append(",  idUsuario=");
			sqlb.append(archivo.getUsuario().getIdUsuario());
			
		}
		if(archivo.getIdarchivoPadre()!=0){
			sqlb.append(",  idarchivopadre=");
			sqlb.append(archivo.getIdarchivo());
			
		}
		else
			if(archivo.getIdarchivoPadre()==0){
				sqlb.append(",  idarchivopadre=null");
				
				
			} 
		sqlb.append(" where idarchivo=");
		sqlb.append(archivo.getIdarchivo());
		String sql =sqlb.toString();
		//BeanPropertySqlParameterSource namedParameters=new BeanPropertySqlParameterSource(archivo);
		
		simpleJdbcTemplate.update(sql);
		
	
	}
	  
public void eliminarDiferencia(List<Archivo> lista, int idarchivopadre){
		
		StringBuffer sqlb = new StringBuffer("delete  from archivo where idarchivopadre=");
		sqlb.append(idarchivopadre);
		    if(lista.size()!=0){
		    	sqlb.append("  and idarchivo in (  select idarchivo  from   (select * from archivo where idarchivopadre=");
				sqlb.append(idarchivopadre);
				sqlb.append(")as tab where   idarchivo not in(");
				for(Archivo a:lista){
					sqlb.append(a.getIdarchivo());
					sqlb.append(",");
				}
				sqlb.delete(sqlb.length()-1, sqlb.length());
				sqlb.append("))");
		    }
			
			
		
		String sql =sqlb.toString();
		
		//BeanPropertySqlParameterSource namedParameters=new BeanPropertySqlParameterSource(archivo);
		
		simpleJdbcTemplate.update(sql);
		
	
	}
   /*
	public int insertarNoDuplicado(Archivo archivo){
		int codigo=0;
		StringBuffer sqlb = new StringBuffer(SqlConstants.insertaNoDuplicadoArchivo);
		
		if(archivo.getIdarchivo()!=0){
			sqlb.append("("+archivo.getIdarchivo()+",");
		}
		if(archivo.getNombreInicial()!=null){
			sqlb.append("('"+archivo.getNombreInicial()+"',");
		}
		if(archivo.getNombreGenerado()!=null){
			sqlb.append("('"+archivo.getNombreGenerado()+"',");
		}
		if(archivo.getFechaUpload()!=null){
			sqlb.append("("+new java.sql.Date(archivo.getFechaUpload().getTime()) +",");
		}
		if(archivo.getUsuario().getIdUsuario()!=0){
			sqlb.append("("+archivo.getUsuario().getIdUsuario()+",");
		}
		if(archivo.getUsuario().getIdUsuario()!=0){
			sqlb.append("("+archivo.getUsuario().getIdUsuario()+",");
		}
		if(archivo.getIdarchivoPadre()!=0){
			sqlb.append("("+archivo.getIdarchivoPadre()+",");
		}
		else
			if(archivo.getIdarchivoPadre()==0){
				sqlb.append("(null,");
		}
		sqlb.delete(sqlb.length()-1, sqlb.length());
		sqlb.append(" on duplicate key update " +
				"idarchivo=LAST_INSERT_ID(idarchivo)," +
				" descripcionarchivo=values(descripcionarchivo), " +
				"  idUsuario=values(idUsuario);" );
		String sql =sqlb.toString();
		simpleJdbcTemplate.update(sql);
		
		codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
		if(codigo==0){
			codigo= jdbcTemplate.queryForInt("SELECT MAX(idarchivo)FROM archivo");
		}
		return codigo;	
	}
	
	*/
	
	
	
	
	
	
}
