package proyecto.dao;

import java.util.Date;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import proyecto.constants.SqlConstants;
import proyecto.util.ConexionBD;

@Repository
public class SeguridadDAO {
	private ConexionBD dt;

	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	public SeguridadDAO() {
		dt = new ConexionBD();
	}
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public String generaClave(String strUsuario, Integer intIdSistema, Integer intIdUsuario) {
		String clave		= String.valueOf(new Date().getTime());
		StringBuffer sqlb	= new StringBuffer(SqlConstants.insertLogin);
		sqlb.append("('");
		sqlb.append(clave);
		sqlb.append("', ");
		sqlb.append("'");
		sqlb.append(strUsuario);
		sqlb.append("', ");
		sqlb.append(intIdSistema.toString());
		sqlb.append(", ");
		sqlb.append(intIdUsuario.toString());
		sqlb.append(", ");
		sqlb.append("current_timestamp ");
		sqlb.append(") ");
//		sqlb.append("('"", :strUsuario, :intIdSistema, :dteFecha)");
		int rs			= this.jdbcTemplate.update(sqlb.toString());
		sqlb			= new StringBuffer();
		sqlb.append("select md5('"+clave+"')");

//		Object idLogin	= this.jdbcTemplate.queryForObject(sqlb.toString(), String.class);
		
//		sqlb			= new StringBuffer();
//		sqlb.append("select clave from sernanp.login where idclave = " + idLogin);
		Object objClave	= this.jdbcTemplate.queryForObject(sqlb.toString(), String.class);
		return objClave.toString();
	}
}
