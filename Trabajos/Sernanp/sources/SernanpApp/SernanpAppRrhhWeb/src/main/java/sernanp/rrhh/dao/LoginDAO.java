package sernanp.rrhh.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.vo.LoginVO;

public class LoginDAO {

	@SuppressWarnings("unused")
	private SimpleJdbcTemplate simpleJdbcTemplate;
    private JdbcTemplate jdbcTemplate;	
    @SuppressWarnings("unused")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	@SuppressWarnings("unchecked")
	public List<LoginVO> buscarClave(LoginVO loginVO) throws Exception {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select idlogin, clave, md5(clave) as clavemd5, usuario, idsistema, idusuario, fecha ");
		sql.append("from sernanp.login tab ");
		sql.append("where md5(clave) = '" + loginVO.getStrClaveMD5() + "' ");		
		
		return this.jdbcTemplate.query(sql.toString(), new RowMappersConstants.LoginMapper());
	}
}
