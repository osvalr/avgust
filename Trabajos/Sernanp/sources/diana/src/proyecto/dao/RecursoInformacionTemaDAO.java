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
import proyecto.vo.RecursoInformacionTema;

@Repository 
public class RecursoInformacionTemaDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
		
		
	 
	 
	 
	 public int insertar(RecursoInformacionTema recursoInformacionTema){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaRecursoInformacionTema);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idrecursoinformacion",recursoInformacionTema.getIdrecursoinformacion() );
			parametros.put("idtema",recursoInformacionTema.getTema().getIdtema() );
			simpleJdbcTemplate.update(sql, parametros);
			codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
			return codigo;	
		}
	
	 
	 public List<RecursoInformacionTema> listar(RecursoInformacionTema recursoInformacionTema){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaRecursoInformacionTema);
			if(recursoInformacionTema.getIdrecursoinformacion()!=0 ){
				sqlb.append(" and rit.idrecursoinformacion=" );
				sqlb.append(recursoInformacionTema.getIdrecursoinformacion());
			}
			if(recursoInformacionTema.getTema().getIdtema()!=0 ){
				sqlb.append(" and rit.idtema=" );
				sqlb.append(recursoInformacionTema.getTema().getIdtema());
			}
			 String sql =sqlb.toString();
			 System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.RecursoInformacionTemaMapper());
			 	
		}
	 
	 
	 public void eliminarDiferencia(List<RecursoInformacionTema> lista,int idrecursoinformacion){
			StringBuffer sqlb = new StringBuffer("delete from temarecursoinformacion where ");
			if(lista.size()==0){
				sqlb.append(" idrecursoinformacion=");
				sqlb.append(idrecursoinformacion);
			}
			else{
				sqlb.append("idtemarecursoinformacion in( select tab.idtemarecursoinformacion from (");
				sqlb.append("select idtemarecursoinformacion from temarecursoinformacion where idrecursoinformacion=");
				sqlb.append(idrecursoinformacion);
				sqlb.append(") as tab  where tab.idtemarecursoinformacion not in(");
				for(RecursoInformacionTema rt:lista){
					sqlb.append(rt.getIdrecursoinformaciontema());
					sqlb.append(",");
				}
				sqlb.delete(sqlb.length()-1, sqlb.length());
				sqlb.append("))");
			}
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);			
		}
	 
	 
	 public void insertarNoDuplicado(List<RecursoInformacionTema> lista){
			StringBuffer sqlb = new StringBuffer("insert into temarecursoinformacion(" +
					"idtemarecursoinformacion, idrecursoinformacion,idtema) values ");
			for(RecursoInformacionTema rt:lista){
				sqlb.append("(");
				sqlb.append(rt.getIdrecursoinformaciontema());
				sqlb.append(",");
				sqlb.append(rt.getIdrecursoinformacion());
				sqlb.append(",");
				sqlb.append(rt.getTema().getIdtema());
				sqlb.append("),");
			}
			sqlb.delete(sqlb.length()-1, sqlb.length());
			sqlb.append(" on duplicate key update" +
					" idtemarecursoinformacion=values(idtemarecursoinformacion); ");
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);		
		}
	
}
