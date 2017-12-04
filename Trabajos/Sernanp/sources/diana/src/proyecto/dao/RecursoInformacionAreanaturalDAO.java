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
import proyecto.vo.Areanatural;
import proyecto.vo.Categoriaanp;
import proyecto.vo.RecursoInformacionAreanatural;
import proyecto.vo.RecursoInformacionTema;

@Repository 
public class RecursoInformacionAreanaturalDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
	
	public List<Areanatural> listarAreasNaturalesxRecursoInformacion(RecursoInformacionAreanatural recursoInformacionAreanatural){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaAreaNaturalxRecursoInformacion);
		if(recursoInformacionAreanatural.getAreanatural().getCategoriaanp().getIdcategoriaanp()!=0){
			sqlb.append(" and a.idcategoriaanp= ");
			sqlb.append(recursoInformacionAreanatural.getAreanatural().getCategoriaanp().getIdcategoriaanp());
		}
	
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.AreanaturalMapper());
	}
		
	
	public List<Categoriaanp> listarCategoriaAnpxRecursoInformacion(RecursoInformacionAreanatural recursoInformacionAreanatural){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaCategoriaAnpxRecursoInformacion);
		
	
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.CategoriaAnpMapper());
	}
	 
	 
	 
	 public int insertar(RecursoInformacionAreanatural recursoInformacionAreanatural){
			int codigo=0;
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaRecursoInformacionAreaNatural);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idrecursoinformacion",recursoInformacionAreanatural.getRecursoinformacion().getIdrecursoinformacion() );
			parametros.put("idareanatural",recursoInformacionAreanatural.getAreanatural().getIdareanatural() );
			simpleJdbcTemplate.update(sql, parametros);
			codigo= jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()");
			return codigo;	
		}
	
	 
	  public List<RecursoInformacionAreanatural> listar(RecursoInformacionAreanatural recursoInformacionAreanatural){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaRecursoInformacionAreaNatural);
			if(recursoInformacionAreanatural.getRecursoinformacion().getIdrecursoinformacion()!=0 ){
				sqlb.append(" and rian.idrecursoinformacion=" );
				sqlb.append(recursoInformacionAreanatural.getRecursoinformacion().getIdrecursoinformacion());
			}
			
			 String sql =sqlb.toString();
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.RecursoInformacionAreaNaturalMapper());
			 	
		}
	 
	
	  public void eliminarDiferencia(List<RecursoInformacionAreanatural> lista,int idrecursoinformacion){
			StringBuffer sqlb = new StringBuffer("delete from recursoinformacionareanatural where ");
			if(lista.size()==0){
				sqlb.append(" idrecursoinformacion=");
				sqlb.append(idrecursoinformacion);
			}
			else{
				sqlb.append("idrecursoinformacionareanatural in( select tab.idrecursoinformacionareanatural from (");
				sqlb.append("select idrecursoinformacionareanatural from recursoinformacionareanatural where idrecursoinformacion=");
				sqlb.append(idrecursoinformacion);
				sqlb.append(") as tab  where tab.idrecursoinformacionareanatural not in(");
				for(RecursoInformacionAreanatural ran:lista){
					sqlb.append(ran.getIdrecursoinformacionareanatural());
					sqlb.append(",");
				}
				sqlb.delete(sqlb.length()-1, sqlb.length());
				sqlb.append("))");
			}
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);			
		}
	  
	  public void insertarNoDuplicado(List<RecursoInformacionAreanatural> lista){
			StringBuffer sqlb = new StringBuffer("insert into recursoinformacionareanatural(" +
					"idrecursoinformacionareanatural, idrecursoinformacion,idareanatural) values ");
			for(RecursoInformacionAreanatural ran:lista){
				sqlb.append("(");
				sqlb.append(ran.getIdrecursoinformacionareanatural());
				sqlb.append(",");
				sqlb.append(ran.getRecursoinformacion().getIdrecursoinformacion());
				sqlb.append(",");
				sqlb.append(ran.getAreanatural().getIdareanatural());
				sqlb.append("),");
			}
			sqlb.delete(sqlb.length()-1, sqlb.length());
			sqlb.append(" on duplicate key update" +
					" idrecursoinformacionareanatural=values(idrecursoinformacionareanatural); ");
			String sql =sqlb.toString();
			 System.out.println(sql);
			simpleJdbcTemplate.update(sql);		
		}
	 
	  
	  
	  
	
}
