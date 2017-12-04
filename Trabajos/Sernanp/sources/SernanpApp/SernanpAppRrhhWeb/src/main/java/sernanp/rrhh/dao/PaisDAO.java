package sernanp.rrhh.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.vo.Pais;

@Repository 
public class PaisDAO {
	private SimpleJdbcTemplate simpleJdbcTemplate;
	 private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	 public List<Pais> listar(Pais pais){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaPais);
			sqlb.append("order by p.nompais ");
			 String sql =sqlb.toString();
			 //System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new RowMappersConstants.PaisMapper());
			 	
	}
	 /*
	 public List<Pais> listarEncontradosxANP(int idAnp){
			
			StringBuffer sqlb = new StringBuffer(SqlConstants.listaPaisEncontrados);			
			sqlb.append(" group by p.idpais, p.nompais order by p.nompais ");
			 String sql =sqlb.toString();
			 //System.out.println(sql);
			 return  this.jdbcTemplate.query(sql, new Object[]{idAnp}, new RowMappersConstants.PaisMapper());
			 	
		} */
	 
	
}
