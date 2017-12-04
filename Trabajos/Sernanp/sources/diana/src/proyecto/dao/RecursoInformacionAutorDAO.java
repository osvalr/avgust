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
import proyecto.vo.RecursoInformacionAutor;

@Repository 
public class RecursoInformacionAutorDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
		
		
	 
	 
	 
	 public int insertar(RecursoInformacionAutor recursoInformacionAutor){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaRecursoInformacionAutor);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idrecursoinformacion",recursoInformacionAutor.getIdrecursoinformacion() );
			parametros.put("idautor",recursoInformacionAutor.getAutor().getIdautor() );
			simpleJdbcTemplate.update(sql, parametros);
			codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
			return codigo;	
		}
	
	 
	 
	 public List<RecursoInformacionAutor> listar(RecursoInformacionAutor recursoInformacionAutor){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaRecursoInformacionAutor);
			if(recursoInformacionAutor.getIdrecursoinformacion()!=0 ){
				sqlb.append(" and ria.idrecursoinformacion=" );
				sqlb.append(recursoInformacionAutor.getIdrecursoinformacion());
			}
			if(recursoInformacionAutor.getAutor().getIdautor()!=0 ){
				sqlb.append(" and ria.idautor=" );
				sqlb.append(recursoInformacionAutor.getAutor().getIdautor());
			}
			 String sql =sqlb.toString();
			 System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.RecursoInformacionAutorMapper());
			 	
		}
	 
	 
	 public void eliminarDiferencia(List<RecursoInformacionAutor> lista,int idrecursoinformacion){
			StringBuffer sqlb = new StringBuffer("delete from recursoinformacionautor where ");
			if(lista.size()==0){
				sqlb.append(" idrecursoinformacion=");
				sqlb.append(idrecursoinformacion);
			}
			else{
				sqlb.append("idrecursoinformacionautor in( select tab.idrecursoinformacionautor from (");
				sqlb.append("select idrecursoinformacionautor from recursoinformacionautor where idrecursoinformacion=");
				sqlb.append(idrecursoinformacion);
				sqlb.append(") as tab  where tab.idrecursoinformacionautor not in(");
				for(RecursoInformacionAutor ra:lista){
					sqlb.append(ra.getIdrecursoinformacionautor());
					sqlb.append(",");
				}
				sqlb.delete(sqlb.length()-1, sqlb.length());
				sqlb.append("))");
			}
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);			
		}
	 
	 
	 public void insertarNoDuplicado(List<RecursoInformacionAutor> lista){
			StringBuffer sqlb = new StringBuffer("insert into recursoinformacionautor(" +
					"idrecursoinformacionautor, idrecursoinformacion,idautor) values ");
			for(RecursoInformacionAutor ra:lista){
				sqlb.append("(");
				sqlb.append(ra.getIdrecursoinformacionautor());
				sqlb.append(",");
				sqlb.append(ra.getIdrecursoinformacion());
				sqlb.append(",");
				sqlb.append(ra.getAutor().getIdautor());
				sqlb.append("),");
			}
			sqlb.delete(sqlb.length()-1, sqlb.length());
			sqlb.append(" on duplicate key update" +
					" idrecursoinformacionautor=values(idrecursoinformacionautor); ");
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);		
		}
	 
	
}
