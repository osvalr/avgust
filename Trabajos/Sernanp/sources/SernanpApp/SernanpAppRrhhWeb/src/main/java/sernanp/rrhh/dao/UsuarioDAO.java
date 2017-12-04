package sernanp.rrhh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import sernanp.rrhh.constants.RowMappersConstants;
import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.vo.Usuario;

@Repository
public class UsuarioDAO {

	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired 
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public UsuarioDAO(){}	
	
	public List<Usuario> listarUsuarioArea(Usuario usuario){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaUsuarioArea);
		if(usuario.getIdUsuario()!=0 ){
			sqlb.append(" and u.idusuario=" );
			sqlb.append(usuario.getIdUsuario());
		}
		
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.UsuarioMapper());
		 	
	}	
	
	public boolean loginUsuario(Usuario usuario){
		int resultado=0;
		boolean res=false;
		StringBuffer sqlb = new StringBuffer(" select count(*) from sernanp.usuario u where usuario='");
			sqlb.append(usuario.getUsername()+"'");
		sqlb.append(" and clave=md5('");
		sqlb.append(usuario.getClave()+"')");
		sqlb.append(" and u.estado=" );
		sqlb.append(usuario.getEstado());
		String sql =sqlb.toString();
		//System.out.println(sql);
		resultado= this.simpleJdbcTemplate.queryForInt(sql);
		if(resultado==1){
			res=true;
		}
		return res;
    }


	public List<Usuario> listar(Usuario usuario){
		
		StringBuffer sqlb = new StringBuffer(SqlConstants.listaUsuario);
		if(usuario.getIdUsuario()!=0 ){
			sqlb.append(" and u.idusuario=" );
			sqlb.append(usuario.getIdUsuario());
		}
		if(usuario.getUsername()!=null ){
			sqlb.append(" and u.usuario='" );
			sqlb.append(usuario.getUsername()+"'");
		}
		if(usuario.getClave()!=null ){
			sqlb.append(" and u.clave=md5('" );
			sqlb.append(usuario.getClave()+"')");
		}
		if(usuario.getEstado()!=0 ){
			if(usuario.getEstado() == ValueConstants.VALOR_CERO){				
				sqlb.append(" and u.estado=0" );
			}else{
				sqlb.append(" and u.estado=" );
				sqlb.append(usuario.getEstado());
			}
			
		}
		 String sql =sqlb.toString();
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.UsuarioMapper());
		 	
	}    
    
	public int contarUnico(Usuario usuario) {
		 StringBuffer sqlb = new StringBuffer(SqlConstants.contarUsuarioUnico);
		 if(usuario.getUsername()!=null){			 
			 sqlb.append(" and usuario='");
			 sqlb.append(usuario.getUsername());
			 sqlb.append("'");
		 }
		 String sql =sqlb.toString();
		return  this.jdbcTemplate.queryForInt(sql);
	}
    
	public int insertar(Usuario usuario){
   	    Map<String, Object> parametros = new HashMap<String, Object>();
   	    parametros.put("usuario", usuario.getUsername());
   	    parametros.put("clave", usuario.getClave());
   	    parametros.put("estado", usuario.getEstado());
 		if(usuario.getAreaorganica().getIdarea()!=0){
 			parametros.put("idarea", usuario.getAreaorganica().getIdarea());
 		}
 		else{
 			parametros.put("idarea",null);
 		}
 		
 		if(usuario.getRol().getIdrol()!=0){
 			parametros.put("idrol", usuario.getRol().getIdrol());
 		}else{
 			parametros.put("idrol", null);
 		}
 		
 		if(usuario.getPersonal().getIdpersonal()!=0){
 			parametros.put("idpersonal",usuario.getPersonal().getIdpersonal() );
 		}
 		else{
 			parametros.put("idpersonal", null);
 		}
        return this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaUsuario,parametros);
          
	}
}