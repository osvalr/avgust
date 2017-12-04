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
import proyecto.dao.procedure.GuiaProcedure;
import proyecto.vo.Parametro;

@Repository 
public class ParametroDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private GuiaProcedure guiaProcedure;
 
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		this.guiaProcedure=new GuiaProcedure(dataSource);
	}

	
     
    public List<Parametro> listar(Parametro parametro){
    	 StringBuffer sqlb = new StringBuffer(SqlConstants.listaParametro);
		 if(parametro.getNombreparametro()!=null){
			 sqlb.append(" and nombreparametro='");
			 sqlb.append(parametro.getNombreparametro()+"'");
		 }
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.ParametroMapper() );	
    } 
    
    
    public Map<String, String> obtenerMap(Parametro parametro){
		Map<String, String> map=new HashMap<String, String>();
		List<Parametro> lista= listar(parametro);
		for(Parametro p: lista){
			map.put(p.getNombreparametro(), p.getValorparametro());
		}
		return map;
	}
	
     
    
     
}
