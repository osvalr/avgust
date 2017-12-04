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
import proyecto.vo.GuiaFichaTurismo;

@Repository 
public class GuiaFichaturismoDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
	 
	 public void insertar(GuiaFichaTurismo guiafichaturismo){
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaGuiaFichaturismo);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idguia",guiafichaturismo.getGuia().getIdguia());
			parametros.put("idfichaturismo", guiafichaturismo.getFichaturismo().getIdfichaturismo());
			simpleJdbcTemplate.update(sql, parametros);
			
	}
	 
	
	 public List<GuiaFichaTurismo> listar(GuiaFichaTurismo guiaFichaTurismo){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaGuiaFichaTurismo);
			if(guiaFichaTurismo.getFichaturismo().getIdfichaturismo()!=0 ){
				sqlb.append(" and gft.idfichaturismo=" );
				sqlb.append(guiaFichaTurismo.getFichaturismo().getIdfichaturismo());
			}
			if(guiaFichaTurismo.getGuia().getIdguia()!=0 ){
				sqlb.append(" and gft.idguia=" );
				sqlb.append(guiaFichaTurismo.getGuia().getIdguia());
			}
			 String sql =sqlb.toString();
			 //System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.GuiaFichaturismoMapper());
			 	
	}
	
	    
	 public void insertarNoDuplicado(GuiaFichaTurismo guiaFichaTurismo){
	    	Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idguia",guiaFichaTurismo.getGuia().getIdguia());
			parametros.put("idfichaturismo",guiaFichaTurismo.getFichaturismo().getIdfichaturismo() );
			this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaNoDuplicadoGuiaFichaTurismo,parametros);
	 }
	 
	 
	 public void eliminarDiferencia(List<GuiaFichaTurismo> lista,long idfichaturismo){
		StringBuffer sqlb = new StringBuffer("delete from sernanp.guiafichaturismo where ");
		if(lista.size()==0){
			sqlb.append(" idfichaturismo=");
			sqlb.append(idfichaturismo);
		}
		else{
			sqlb.append("idguia in( select tab.idguia from (");
			sqlb.append("select * from sernanp.guiafichaturismo where idfichaturismo=");
			sqlb.append(idfichaturismo);
			sqlb.append(") as tab  where tab.idguia not in(");
			for(GuiaFichaTurismo gft:lista){
				sqlb.append(gft.getGuia().getIdguia());
				sqlb.append(",");
			}
			sqlb.delete(sqlb.length()-1, sqlb.length());
			sqlb.append("))");
		}
		String sql =sqlb.toString();
		//System.out.println(sql);
		simpleJdbcTemplate.update(sql);			
	}
	

	 
}
