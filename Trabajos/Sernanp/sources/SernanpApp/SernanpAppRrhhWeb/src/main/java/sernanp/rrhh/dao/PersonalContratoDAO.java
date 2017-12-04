package sernanp.rrhh.dao;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.vo.PersonalContratoVO;

@Repository
public class PersonalContratoDAO {

	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);	
	}
	
	
	public boolean verificaDiferenciaFechaContrato(int idpersonal, Date fechaic) {
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.verificaultimafecha);				
		String sql =sqlb.toString();	

		int resultquery = this.jdbcTemplate.queryForInt(sql, new Object[]{idpersonal, fechaic});
		
		if(resultquery >  0){
//			System.out.println("PersonalContratoDAO - verificaDiferenciaFechaContrato - sql : "+sql+ " --> "+idpersonal +" --> "+fechaic);			
			return true;		
		}else{
			return false;
		}		
	}
	
	
	public List<PersonalContratoVO> listacontratoxidpersonal(int idPersonalContrato){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listacontratosxid);				
				
		String sql =sqlb.toString();	
		
		
		return this.jdbcTemplate.query(sql, new Object[]{idPersonalContrato}, new RowMappersConstants.listacontratosxid());

		 //return  this.jdbcTemplate.query(sql, new RowMappersConstants.listacontratosxid());
		 	
	}
	
}
