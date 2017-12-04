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
import proyecto.constants.ValueConstants;
import proyecto.vo.PagoFichaturismo;

@Repository 
public class PagoFichaTurismoDAO  {


	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	public List<PagoFichaturismo> listar(PagoFichaturismo pagoFichaturismo){
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaPagoFichaTurismo);
		if(pagoFichaturismo.getIdfichaturismo()!=0 ){
			sqlb.append(" and pft.idfichaturismo=" );
			sqlb.append(pagoFichaturismo.getIdfichaturismo());
		}
		if(pagoFichaturismo.getIdpagofichaturismo()!=0 ){
			sqlb.append(" and pft.idpagofichaturismo=" );
			sqlb.append(pagoFichaturismo.getIdpagofichaturismo());
		}
		String sql =sqlb.toString();
		return  this.jdbcTemplate.query(sql, new RowMappersConstants.PagoFichaTurismoMapper());		 	
	}
		
	
	
	public int insertar(PagoFichaturismo pagoFichaturismo){
   	    Map<String, Object> parametros = new HashMap<String, Object>();
   	    parametros.put("idfichaturismo", pagoFichaturismo.getIdfichaturismo());
   	    parametros.put("numvoucher", pagoFichaturismo.getNumvoucher());
   	    parametros.put("monto", pagoFichaturismo.getMonto());
   	    if(pagoFichaturismo.getModalidadpago().getIdtipo()==0){
   		 parametros.put("idmodalidadpago", null);
	    }else{
	    	 parametros.put("idmodalidadpago", pagoFichaturismo.getModalidadpago().getIdtipo());
	    }
   	    if(pagoFichaturismo.getPagobanco().getIdpagobanco()==0){
   	    	parametros.put("idpagobanco", null);
   	    }else{
   	    	parametros.put("idpagobanco", pagoFichaturismo.getPagobanco().getIdpagobanco());
   	    }
        return this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaPagoFichaTurismo,parametros);
	}
	
	
	
	public void actualizar(PagoFichaturismo pagoFichaturismo){
		StringBuffer sqlb = new StringBuffer("update sernanp.pagofichaturismo set idpagofichaturismo=idpagofichaturismo ");
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("monto", pagoFichaturismo.getMonto());
		if(pagoFichaturismo.getMonto()!=0){
			if(pagoFichaturismo.getMonto()==ValueConstants.VALOR_CERO){
				sqlb.append(", monto=0");	
			}
			else{
				sqlb.append(", monto=:monto");
			}
		}
		sqlb.append(" where idpagofichaturismo=");
		sqlb.append(pagoFichaturismo.getIdpagofichaturismo());
		String sql =sqlb.toString();
		//System.out.println(sql);
		simpleJdbcTemplate.update(sql, parametros);
	}
	



	
	
}
