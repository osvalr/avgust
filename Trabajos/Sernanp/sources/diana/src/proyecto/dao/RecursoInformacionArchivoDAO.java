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
import proyecto.vo.RecursoInformacionArchivo;

@Repository 
public class RecursoInformacionArchivoDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
	 
	 public int insertar(RecursoInformacionArchivo recursoinformacionarchivo){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaRecursoInformacionArchivo);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idrecursoinformacion",recursoinformacionarchivo.getRecursoinformacion().getIdrecursoinformacion());
			if(recursoinformacionarchivo.getArchivo()==null){
				parametros.put("idarchivo",null );
			}else{
				parametros.put("idarchivo",recursoinformacionarchivo.getArchivo().getIdarchivo() );
			}
			
			parametros.put("tipoarchivo", recursoinformacionarchivo.getTipoarchivo().getIdtipo());
			simpleJdbcTemplate.update(sql, parametros);
			codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
			return codigo;	
		}
	
	    
	 public void actualizar(RecursoInformacionArchivo recursoinformacionarchivo){
			StringBuffer sqlb = new StringBuffer("update recursoinformacionarchivo set idrecursoinformacionarchivo=idrecursoinformacionarchivo ");
			Map<String, Object> parametros = new HashMap<String, Object>();
			if(recursoinformacionarchivo.getArchivo()==null){
				parametros.put("idarchivo",null );
			}else{
				parametros.put("idarchivo",recursoinformacionarchivo.getArchivo().getIdarchivo() );
			}
			
				sqlb.append(", idarchivo=:idarchivo");
			
			sqlb.append(" where idrecursoinformacionarchivo=");
			sqlb.append(recursoinformacionarchivo.getIdrecursoinformacionarchivo());
			String sql =sqlb.toString();
			simpleJdbcTemplate.update(sql, parametros);
			
		}
	 
	
	 public List<RecursoInformacionArchivo> listar(RecursoInformacionArchivo recursoInformacionArchivo){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaRecursoInformacionArchivo);
			if(recursoInformacionArchivo.getRecursoinformacion().getIdrecursoinformacion()!=0 ){
				sqlb.append(" and riarch.idrecursoinformacion=" );
				sqlb.append(recursoInformacionArchivo.getRecursoinformacion().getIdrecursoinformacion());
			}
			sqlb.append(" order by riarch.tipoarchivo " );
			
			 String sql =sqlb.toString();
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.RecursoInformacionArchivoMapper());
			 	
		}
	 
	 
	 public void eliminarDiferencia(List<RecursoInformacionArchivo> lista,int idrecursoinformacion){
			StringBuffer sqlb = new StringBuffer("delete from recursoinformacionarchivo where ");
			if(lista.size()==0){
				sqlb.append(" idrecursoinformacion=");
				sqlb.append(idrecursoinformacion);
			}
			else{
				sqlb.append("idrecursoinformacionarchivo in( select tab.idrecursoinformacionarchivo from (");
				sqlb.append("select idrecursoinformacionarchivo from recursoinformacionarchivo where idrecursoinformacion=");
				sqlb.append(idrecursoinformacion);
				sqlb.append(") as tab  where tab.idrecursoinformacionarchivo not in(");
				for(RecursoInformacionArchivo rarch:lista){
					sqlb.append(rarch.getIdrecursoinformacionarchivo());
					sqlb.append(",");
				}
				sqlb.delete(sqlb.length()-1, sqlb.length());
				sqlb.append("))");
			}
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);			
		}
	 
	 public void insertarNoDuplicado(List<RecursoInformacionArchivo> lista){
			StringBuffer sqlb = new StringBuffer("insert into recursoinformacionarchivo(" +
					"idrecursoinformacionarchivo, idrecursoinformacion,idarchivo,tipoarchivo) values ");
			for(RecursoInformacionArchivo rarch:lista){
				sqlb.append("(");
				sqlb.append(rarch.getIdrecursoinformacionarchivo());
				sqlb.append(",");
				sqlb.append(rarch.getRecursoinformacion().getIdrecursoinformacion());
				sqlb.append(",");
				sqlb.append(rarch.getArchivo().getIdarchivo());
				sqlb.append(",");
				sqlb.append(rarch.getTipoarchivo().getIdtipo());
				sqlb.append("),");
			}
			sqlb.delete(sqlb.length()-1, sqlb.length());
			sqlb.append(" on duplicate key update" +
					" idrecursoinformacionarchivo=values(idrecursoinformacionarchivo); ");
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);		
		}
	 
	 
	 public void insertarNoDuplicado(RecursoInformacionArchivo rarch){
			StringBuffer sqlb = new StringBuffer("insert into recursoinformacionarchivo(" +
					"idrecursoinformacionarchivo, idrecursoinformacion,idarchivo,tipoarchivo) values ");
			
				sqlb.append("(");
				sqlb.append(rarch.getIdrecursoinformacionarchivo());
				sqlb.append(",");
				sqlb.append(rarch.getRecursoinformacion().getIdrecursoinformacion());
				sqlb.append(",");
				sqlb.append(rarch.getArchivo().getIdarchivo());
				sqlb.append(",");
				sqlb.append(rarch.getTipoarchivo().getIdtipo());
				sqlb.append(")");
			
			sqlb.append(" on duplicate key update" +
					" idarchivo=values(idarchivo); ");
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);		
		}
	 
	
}
