package proyecto.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import proyecto.constants.RowMappersConstants;
import proyecto.constants.SqlConstants;
import proyecto.vo.Conceptoexoneracionpago;

@Repository 
public class ConceptoExoneracionPagoDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;  
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) { 
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);

	}

	
	
	 public List<Conceptoexoneracionpago> listar(Conceptoexoneracionpago conceptoexoneracionpago){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaConceptoExoneracionPago);	
			if(conceptoexoneracionpago.getIdconceptoexoneracionpago()!=0){
				sqlb.append(" and cexp.idconceptoexoneracionpago=");
				sqlb.append(conceptoexoneracionpago.getIdconceptoexoneracionpago());
			}
			 String sql =sqlb.toString();
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.ConceptoExoneracionPagoMapper());
	}
	 
	
	 
	
	 
	
	
	
}
