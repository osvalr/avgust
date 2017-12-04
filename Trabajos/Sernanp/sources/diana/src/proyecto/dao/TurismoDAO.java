package proyecto.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Turismo;

@Repository 
public class TurismoDAO  {

	private ConexionBD dt;

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	  
	public TurismoDAO(){
			dt = new ConexionBD();		
	}
	
	public List<Turismo> listar(Turismo turismo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaTurismo);
		if(turismo.getIdturismo()!=0 ){
			sqlb.append(" and t.idturismo=" );
			sqlb.append(turismo.getIdturismo());
		}
		if(turismo.getIdareanatural()!=0 ){
			sqlb.append(" and an.idareanatural=" );
			sqlb.append(turismo.getIdareanatural());
		}
		if(turismo.getDesareanatural()!=null ){
			sqlb.append("  and  an.desareanatural like upper('%" );
			sqlb.append(turismo.getDesareanatural() );
			sqlb.append("%')" );
		}
		sqlb.append(" order by an.desareanatural" );
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TurismoMapper());
		 	
	}
	
	
	
}
