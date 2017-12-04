package sernanp.rrhh.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.vo.UsuarioRol;

@Repository 
public class UsuarioRolDAO  {
	
		
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate	= new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate		= new JdbcTemplate(dataSource);
	}
			
	public List<UsuarioRol> listar(UsuarioRol usuarioRol) {
		StringBuffer sqlb	= new StringBuffer(SqlConstants.listaUsuarioRol);
		if (usuarioRol.getRol().getIdrol() != 0) {
			sqlb.append(" and ur.idrol=");
			sqlb.append(usuarioRol.getRol().getIdrol());
		}
		if (usuarioRol.getUsuario().getIdUsuario() != 0) {
			sqlb.append(" and ur.idusuario=");
			sqlb.append(usuarioRol.getUsuario().getIdUsuario());
		}
		String sql	= sqlb.toString();
		return this.jdbcTemplate.query(sql, new RowMappersConstants.UsuarioRolMapper());
	}
}