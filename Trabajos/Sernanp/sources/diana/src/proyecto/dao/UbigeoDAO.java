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
import proyecto.vo.Tema;
import proyecto.vo.Ubigeo;

@Repository 
public class UbigeoDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Ubigeo> listar(Ubigeo ubigeo){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaUbigeo);
		if(ubigeo.getIdubigeo()!=0 ){
			sqlb.append(" and u.idubigeo=" );
			sqlb.append(ubigeo.getIdubigeo());
		}
		if(ubigeo.getCoddepartamento()!=null ){
			sqlb.append("  and u.coddpto='" );
			sqlb.append(ubigeo.getCoddepartamento()+"'" );
			
		}
		if(ubigeo.getCodprovincia()!=null ){
			sqlb.append("  and u.codprov='" );
			sqlb.append(ubigeo.getCodprovincia()+"'" );
			
		}
		if(ubigeo.getCoddistrito()!=null ){
			sqlb.append("  and u.coddist='" );
			sqlb.append(ubigeo.getCoddistrito()+"'" );
			
		}
		if(ubigeo.getIdubigeodepartamento()==ValueConstants.VALOR_CERO){
			sqlb.append("  and u.codprov!='00'" );			
		}
		if(ubigeo.getIdubigeoprovincia()==ValueConstants.VALOR_CERO){
			sqlb.append("  and u.coddist!='00'" );			
		}
		
		sqlb.append("  order by u.nombre" );
		 String sql =sqlb.toString();
		 //System.out.println(sql);
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.UbigeoMapper());
		 	
	}
	
	
	
	
	

}
