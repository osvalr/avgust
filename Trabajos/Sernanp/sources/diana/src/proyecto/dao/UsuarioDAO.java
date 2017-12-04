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
import proyecto.param.FichaTurismoParam;
import proyecto.util.ConexionBD;
import proyecto.vo.Usuario;

@Repository
public class UsuarioDAO {

	private ConexionBD dt;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired 
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	public UsuarioDAO(){
		dt = new ConexionBD();		
    }
	
	/*
	 * public Usuario verificar(String usuario, String clave) {
	 *     
	 * 
	 * 
	 * return this.simpleJdbcTemplate.queryForObject(
	 * "select * from usuario where usuario=? and clave=? ",
	 * ParameterizedBeanPropertyRowMapper.newInstance(Usuario.class), new
	 * Object[] {usuario,clave});
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	
	
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
			if(usuario.getEstado()==ValueConstants.VALOR_CERO){
				sqlb.append(" and u.estado=0" );
			}else{
				sqlb.append(" and u.estado=" );
				sqlb.append(usuario.getEstado());
			}
			
		}
		 String sql =sqlb.toString();
		 
		 		 
		 return  this.jdbcTemplate.query(sql, new RowMappersConstants.UsuarioMapper());
		 	
	}
	
    
    
    public void actualizar(Usuario usuario){
		StringBuffer sqlb = new StringBuffer("update sernanp.usuario set idusuario=idusuario ");
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("clave",usuario.getClave() );
		parametros.put("loginfirst",usuario.getLoginfirst());
		if(usuario.getClave()!=null){
			sqlb.append(",  clave=md5(:clave)");
		}
		if(usuario.getLoginfirst()!=0){
			if(usuario.getLoginfirst()==ValueConstants.VALOR_CERO){
				sqlb.append(", loginfirst=0");	
			}
			else{
				sqlb.append(", loginfirst=:loginfirst");
			}
		}
		sqlb.append(" where idusuario=");
		sqlb.append(usuario.getIdUsuario());
		String sql =sqlb.toString();
		//System.out.println(sql);
		simpleJdbcTemplate.update(sql, parametros);
   }
    
    
//    public int insertarNoDuplicado(Usuario usuario){
//   	    Map<String, Object> parametros = new HashMap<String, Object>();
//   	    parametros.put("usuario", usuario.getUsername());
//   	    parametros.put("clave", usuario.getClave());
//   	    parametros.put("estado", usuario.getEstado());
//   	    parametros.put("idarea", usuario.getAreaorganica().getIdarea());
//   	    parametros.put("idrol", usuario.getRol().getIdrol());
//   	    parametros.put("idpersonal",usuario.getPersonal().getIdpersonal() );
//        return this.simpleJdbcTemplate.queryForInt(SqlConstants.insertaNoDuplicadoUsuario,parametros);
//          
//	}
    
    
    
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
    
    
    
    /*
	public Usuario login(String usuario, String clave) {

		List Ulist = simpleJdbcTemplate.query(
				"select * from sernanp.usuario where usuario=? and clave=md5(?) ",
				ParameterizedBeanPropertyRowMapper.newInstance(Usuario.class),
				new Object[] { usuario, clave });

		if (Ulist.size() == 0) {
			System.out.println(Ulist.size());
			return null;

		} else {

			Usuario vo = (Usuario) Ulist.get(0);
			List UlistModulos = simpleJdbcTemplate
					.queryForList(
							"select * from  sernanp.rol R  left  JOIN  sernanp.rolmodulo RM ON RM.idrol=R.idrol Right  join  sernanp.modulo   M on M.idmodulo=RM.idmodulo  where    flagmodulo='1' and   R.idrol=? ",
							vo.getRol().getIdrol());

			vo.setModulos(UlistModulos);
			
			
			
			System.out.println(JSONArray.fromObject((Usuario) Ulist.get(0)).toString());
			return vo;
		}

	}
    */
    /*
	public Usuario obtenerPorIdUsuario(String idUsuario) {
		return new Usuario();
	}
	*/

}
