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
import proyecto.vo.TipoturismoFichaturismo;

@Repository 
public class TipoturismoFichaturismoDAO  {
	
	
	
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	
	 
	 public void insertar(TipoturismoFichaturismo tipoturismoFichaturismo){
			StringBuffer sqlb = new StringBuffer(SqlConstants.insertaTipoturismoFichaturismo);
			String sql =sqlb.toString();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idtipoturismo",tipoturismoFichaturismo.getTipoturismo().getIdtipoturismo());
			parametros.put("idfichaturismo", tipoturismoFichaturismo.getFichaturismo().getIdfichaturismo());
			simpleJdbcTemplate.update(sql, parametros);
			
		}
	
	    
	 
	 public List<TipoturismoFichaturismo> listar(TipoturismoFichaturismo tipoturismoFichaturismo){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaTipoturismoFichaTurismo);
			if(tipoturismoFichaturismo.getFichaturismo().getIdfichaturismo()!=0 ){
				sqlb.append(" and tipft.idfichaturismo=" );
				sqlb.append(tipoturismoFichaturismo.getFichaturismo().getIdfichaturismo());
			}
			if(tipoturismoFichaturismo.getTipoturismo().getIdtipoturismo()!=0 ){
				sqlb.append(" and tipft.idtipoturismo=" );
				sqlb.append(tipoturismoFichaturismo.getTipoturismo().getIdtipoturismo());
			}
			 String sql =sqlb.toString();
			 //System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.TipoturismoFichaturismoMapper());
			 	
	}
	 
	 public void insertarNoDuplicado(TipoturismoFichaturismo tipoturismoFichaturismo){
	    	Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idtipoturismo",tipoturismoFichaturismo.getTipoturismo().getIdtipoturismo());
			parametros.put("idfichaturismo",tipoturismoFichaturismo.getFichaturismo().getIdfichaturismo() );
			this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaNoDuplicadoTipoTurismoFichaTurismo,parametros);
	 }
	 
	 public void eliminarDiferencia(List<TipoturismoFichaturismo> lista,long idfichaturismo){
			StringBuffer sqlb = new StringBuffer("delete from sernanp.tipoturismofichaturismo where ");
			if(lista.size()==0){
				sqlb.append(" idfichaturismo=");
				sqlb.append(idfichaturismo);
			}
			else{
				sqlb.append("idtipoturismo in( select tab.idtipoturismo from (");
				sqlb.append("select * from sernanp.tipoturismofichaturismo where idfichaturismo=");
				sqlb.append(idfichaturismo);
				sqlb.append(") as tab  where tab.idtipoturismo not in(");
				for(TipoturismoFichaturismo tft:lista){
					sqlb.append(tft.getTipoturismo().getIdtipoturismo());
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
