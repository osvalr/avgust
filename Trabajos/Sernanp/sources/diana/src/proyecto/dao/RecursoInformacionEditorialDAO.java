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
import proyecto.vo.RecursoInformacionEditorial;

@Repository 
public class RecursoInformacionEditorialDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
		
		
	 
	 
	 
	 public int insertar(RecursoInformacionEditorial recursoInformacionEditorial){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaRecursoInformacionEditorial);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idrecursoinformacion",recursoInformacionEditorial.getIdrecursoinformacion() );
			parametros.put("ideditorial",recursoInformacionEditorial.getEditorial().getIdeditorial() );
			simpleJdbcTemplate.update(sql, parametros);
			codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
			return codigo;	
		}
	
		public List<RecursoInformacionEditorial> listar(RecursoInformacionEditorial recursoInformacionEditorial){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaRecursoInformacionEditorial);
			if(recursoInformacionEditorial.getIdrecursoinformacion()!=0 ){
				sqlb.append(" and rie.idrecursoinformacion=" );
				sqlb.append(recursoInformacionEditorial.getIdrecursoinformacion());
			}
			if(recursoInformacionEditorial.getEditorial().getIdeditorial()!=0 ){
				sqlb.append(" and rie.ideditorial=" );
				sqlb.append(recursoInformacionEditorial.getEditorial().getIdeditorial());
			}
			 String sql =sqlb.toString();
			 System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.RecursoInformacionEditorialMapper());
			 	
		}
		
		
		public void eliminarDiferencia(List<RecursoInformacionEditorial> lista,int idrecursoinformacion){
			StringBuffer sqlb = new StringBuffer("delete from recursoinformacioneditorial where ");
			if(lista.size()==0){
				sqlb.append(" idrecursoinformacion=");
				sqlb.append(idrecursoinformacion);
			}
			else{
				sqlb.append("idrecursoinformacioneditorial in( select tab.idrecursoinformacioneditorial from (");
				sqlb.append("select idrecursoinformacioneditorial from recursoinformacioneditorial where idrecursoinformacion=");
				sqlb.append(idrecursoinformacion);
				sqlb.append(") as tab  where tab.idrecursoinformacioneditorial not in(");
				for(RecursoInformacionEditorial re:lista){
					sqlb.append(re.getIdrecursoinformacioneditorial());
					sqlb.append(",");
				}
				sqlb.delete(sqlb.length()-1, sqlb.length());
				sqlb.append("))");
			}
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);			
		}
	
	 
		public void insertarNoDuplicado(List<RecursoInformacionEditorial> lista){
			StringBuffer sqlb = new StringBuffer("insert into recursoinformacioneditorial(" +
					"idrecursoinformacioneditorial, idrecursoinformacion,ideditorial) values ");
			for(RecursoInformacionEditorial re:lista){
				sqlb.append("(");
				sqlb.append(re.getIdrecursoinformacioneditorial());
				sqlb.append(",");
				sqlb.append(re.getIdrecursoinformacion());
				sqlb.append(",");
				sqlb.append(re.getEditorial().getIdeditorial());
				sqlb.append("),");
			}
			sqlb.delete(sqlb.length()-1, sqlb.length());
			sqlb.append(" on duplicate key update" +
					" idrecursoinformacioneditorial=values(idrecursoinformacioneditorial); ");
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);		
		}
	 
	
}
