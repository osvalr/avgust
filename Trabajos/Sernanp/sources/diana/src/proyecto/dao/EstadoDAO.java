package proyecto.dao;

 



import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.util.ConexionBD;
import proyecto.vo.Estado;


public class EstadoDAO  {


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
	
    public EstadoDAO(){
    	dt=new ConexionBD();
    }
	
	
    
    
   public List<Estado> listarEstadoProyecto(Estado estado){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaEstadoProyecto);
		if(estado.getIdestado()!=0 ){
			sqlb.append(" and ep.idestadoproyecto=" );
			sqlb.append(estado.getIdestado());
		}
		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql,  new RowMappersConstants.EstadoProyectoMapper() );
		 	
	}
    
   
    
   
	
	
}
