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
import proyecto.constants.ValueConstants;
import proyecto.vo.Archivo;

@Repository 
public class ArchivoDAO  {



	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	  
	
	
	public List<Archivo> listar(Archivo archivo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaArchivo);
		if(archivo.getIdarchivo()!=0 ){
			sqlb.append(" and a.idarchivo=" );
			sqlb.append(archivo.getIdarchivo());
		}
		if(archivo.getDocumento().getIddocumento()!=0 ){
			sqlb.append(" and a.iddocumento=" );
			sqlb.append(archivo.getDocumento().getIddocumento());
		}
		if(archivo.getFlagarchivo()!=0){
			if(archivo.getFlagarchivo()==ValueConstants.VALOR_CERO){
				sqlb.append(" and a.flagarchivo=0" );
			}else{
				sqlb.append(" and a.flagarchivo=");
				sqlb.append(archivo.getFlagarchivo());
			}
		}
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.ArchivoMapper());
		 	
	}
	
	
	
	public int insertar(Archivo archivo){
		 Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("nombreinicialarchivo",archivo.getNombreinicial() );
			parametros.put("nombregeneradoarchivo",archivo.getNombregenerado() );
			parametros.put("flagarchivo",archivo.getFlagarchivo() );
			if(archivo.getUsuario().getIdUsuario()!=0){
				parametros.put("idusuario", archivo.getUsuario().getIdUsuario());
			}
			else{
				parametros.put("idusuario",null);
			}
			if(archivo.getDocumento().getIddocumento()!=0){
				parametros.put("iddocumento", archivo.getDocumento().getIddocumento());
			}
			else{
				parametros.put("iddocumento",null);
			}
			if(archivo.getDirectorioarchivo().getIddirectorioarchivo()!=0){
				parametros.put("idgrupoarchivo", archivo.getDirectorioarchivo().getIddirectorioarchivo());
			}
			else{
				parametros.put("idgrupoarchivo",null);
			}
			
			
			return this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaArchivo,parametros);
	}
	
	
	
	public void actualizarFlagActivo(List<Archivo> lista,int iddocumento,int flagarchivo){
		StringBuffer sqlb = new StringBuffer("update  sernanp.archivo set flagarchivo=");
		if(flagarchivo==ValueConstants.VALOR_CERO){
			sqlb.append("0");
		}else{
			sqlb.append(flagarchivo);
		}
		if(lista.size()==0){
			sqlb.append(" where iddocumento=");
			sqlb.append(iddocumento);
		}
		else{
			sqlb.append(" where idarchivo in( select tab.idarchivo from (");
			sqlb.append("select * from sernanp.archivo where iddocumento=");
			sqlb.append(iddocumento);
			sqlb.append(") as tab  where tab.idarchivo not in(");
			for(Archivo a:lista){
				sqlb.append(a.getIdarchivo());
				sqlb.append(",");
			}
			sqlb.delete(sqlb.length()-1, sqlb.length());
			sqlb.append("))");
		}
		String sql =sqlb.toString();
		//System.out.println(sql);
		simpleJdbcTemplate.update(sql);			
	}
	
	
	public void actualizaEstadoArchivo(int idarchivo){
		StringBuffer sqlb = new StringBuffer(SqlConstants.actualizaEstadoArchivo);
		sqlb.append(idarchivo);
		
		String sql =sqlb.toString();
		simpleJdbcTemplate.update(sql);
		
	}
	
	
	
	
	
}
