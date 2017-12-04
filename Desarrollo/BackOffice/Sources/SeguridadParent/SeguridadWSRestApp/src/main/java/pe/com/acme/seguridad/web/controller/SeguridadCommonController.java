package pe.com.acme.seguridad.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.acme.domain.mybatis.mapper.AplicacionMapper;
import pe.com.acme.domain.mybatis.model.Aplicacion;
import pe.com.acme.query.mybatis.mapper.AplicacionPorNombreQueryMapper;
import pe.com.acme.query.mybatis.mapper.AplicacionPorPerfilQueryMapper;
import pe.com.acme.query.mybatis.mapper.AplicacionPorUsuarioQueryMapper;
import pe.com.acme.query.mybatis.mapper.FuncionalidadPorAppQueryMapper;
import pe.com.acme.query.mybatis.mapper.FuncionalidadPorIdSesionQueryMapper;
import pe.com.acme.query.mybatis.mapper.PerfilPorNombreQueryMapper;
import pe.com.acme.query.mybatis.mapper.RolPorAplicacionQueryMapper;
import pe.com.acme.query.mybatis.mapper.RolePorUsuarioAplicacionQueryMapper;
import pe.com.acme.query.mybatis.mapper.UsuarioPorNombreQueryMapper;
import pe.com.acme.query.mybatis.mapper.UsuarioPorPerfilQueryMapper;
import pe.com.acme.query.mybatis.model.AplicacionPorNombreQueryCriteria;
import pe.com.acme.query.mybatis.model.AplicacionPorPerfilQueryCriteria;
import pe.com.acme.query.mybatis.model.AplicacionPorUsuarioQueryCriteria;
import pe.com.acme.query.mybatis.model.FuncionalidadPorAppQueryCriteria;
import pe.com.acme.query.mybatis.model.FuncionalidadPorIdSesionQuery;
import pe.com.acme.query.mybatis.model.FuncionalidadPorIdSesionQueryCriteria;
import pe.com.acme.query.mybatis.model.PerfilPorNombreQueryCriteria;
import pe.com.acme.query.mybatis.model.RolPorAplicacionQueryCriteria;
import pe.com.acme.query.mybatis.model.RolePorUsuarioAplicacionQueryCriteria;
import pe.com.acme.query.mybatis.model.UsuarioPorNombreQueryCriteria;
import pe.com.acme.query.mybatis.model.UsuarioPorPerfilQueryCriteria;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.TreeDto;

@Controller
@RequestMapping("/seguridad")
public class SeguridadCommonController {

	@Autowired
	private AplicacionPorNombreQueryMapper aplicacionPorNombreQueryMapper;
	
	@Autowired
	private FuncionalidadPorAppQueryMapper funcionalidadPorAppQueryMapper;
	
	@Autowired
	private PerfilPorNombreQueryMapper perfilPorNombreQueryMapper;
	
	@Autowired
	private AplicacionPorPerfilQueryMapper aplicacionPorPerfilQueryMapper;
	
	@Autowired
	private RolPorAplicacionQueryMapper rolPorAplicacionQueryMapper;
	
	@Autowired
	private UsuarioPorPerfilQueryMapper usuarioPorPerfilQueryMapper;
	
	@Autowired
	private AplicacionPorUsuarioQueryMapper aplicacionPorUsuarioQueryMapper;
	
	@Autowired
	private UsuarioPorNombreQueryMapper usuarioPorNombreQueryMapper;
	
	@Autowired
	private FuncionalidadPorIdSesionQueryMapper funcionalidadPorIdSesionQueryMapper;
	
	@Autowired
	private RolePorUsuarioAplicacionQueryMapper rolePorUsuarioAplicacionQueryMapper;
	
	@Autowired
	private AplicacionMapper aplicacionMapper;
	
	@RequestMapping(value="/appPorNombre")
	public @ResponseBody Map<String,? extends Object> appPorNombre(String nombre_aplicacion){
		
		AplicacionPorNombreQueryCriteria criteria = new AplicacionPorNombreQueryCriteria();
		criteria.setNombre_aplicacion(nombre_aplicacion);
		return JsonReturnUtil.returnList(aplicacionPorNombreQueryMapper.getListQueryByCriteria(criteria));
		
	}
	
	@RequestMapping(value="/funcionalidadPorApp")
	public @ResponseBody Map<String,? extends Object> funcionalidadPorApp(Integer id_aplicacion, String nombre_funcionalidad){
		
		FuncionalidadPorAppQueryCriteria criteria = new FuncionalidadPorAppQueryCriteria();
		criteria.setId_aplicacion(id_aplicacion);
		criteria.setNombre_funcionalidad(nombre_funcionalidad);
		
		return JsonReturnUtil.returnList(funcionalidadPorAppQueryMapper.getListQueryByCriteria(criteria));
		
	}
	
	@RequestMapping(value="/perfilPorNombre")
	public @ResponseBody Map<String,? extends Object> perfilPorNombre(String nombre_perfil){
		
		PerfilPorNombreQueryCriteria criteria = new PerfilPorNombreQueryCriteria();
		criteria.setNombre_perfil(nombre_perfil);
		
		return JsonReturnUtil.returnList(perfilPorNombreQueryMapper.getListQueryByCriteria(criteria));
		
	}
	
	@RequestMapping(value="/aplicacionPorPerfil")
	public @ResponseBody Map<String,? extends Object> aplicacionPorPerfil(Integer id_perfil, String nombre_aplicacion){
		
		AplicacionPorPerfilQueryCriteria criteria = new AplicacionPorPerfilQueryCriteria();
		criteria.setId_perfil(id_perfil);
		criteria.setNombre_aplicacion(nombre_aplicacion);
		
		return JsonReturnUtil.returnList(aplicacionPorPerfilQueryMapper.getListQueryByCriteria(criteria));
		
	}
	
	@RequestMapping(value="/aplicacionPorUsuario")
	public @ResponseBody Map<String,? extends Object> aplicacionPorUsuario(Integer id_usuario, String nombre_aplicacion){
		
		AplicacionPorUsuarioQueryCriteria criteria = new AplicacionPorUsuarioQueryCriteria();
		criteria.setId_usuario(id_usuario);
		criteria.setNombre_aplicacion(nombre_aplicacion);
		
		return JsonReturnUtil.returnList(aplicacionPorUsuarioQueryMapper.getListQueryByCriteria(criteria));
		
	}
	
	@RequestMapping(value="/rolPorAplicacion")
	public @ResponseBody Map<String,? extends Object> rolPorAplicacion(Integer id_aplicacion, String nombre_rol){
		
		RolPorAplicacionQueryCriteria criteria = new RolPorAplicacionQueryCriteria();
		criteria.setId_aplicacion(id_aplicacion);
		criteria.setNombre_rol(nombre_rol);
		
		return JsonReturnUtil.returnList(rolPorAplicacionQueryMapper.getListQueryByCriteria(criteria));
		
	}
	
	@RequestMapping(value="/ususarioPorPerfil")
	public @ResponseBody Map<String,? extends Object> ususarioPorPerfil(Integer id_perfil, String nombre_usuario){
		
		UsuarioPorPerfilQueryCriteria criteria = new UsuarioPorPerfilQueryCriteria();
		criteria.setId_perfil(id_perfil);
		criteria.setNombre_usuario(nombre_usuario);
		
		return JsonReturnUtil.returnList(usuarioPorPerfilQueryMapper.getListQueryByCriteria(criteria));
		
	}
	
	@RequestMapping(value="/ususarioPorNombre")
	public @ResponseBody Map<String,? extends Object> ususarioPorNombre(String nombre_usuario){
		
		UsuarioPorNombreQueryCriteria criteria = new UsuarioPorNombreQueryCriteria();
		criteria.setNombre_usuario(nombre_usuario);
		
		return JsonReturnUtil.returnList(usuarioPorNombreQueryMapper.getListQueryByCriteria(criteria));
		
	}
	
	@RequestMapping(value="/rolPorUsuarioAplicacion")
	public @ResponseBody Map<String,? extends Object> rolPorUsuarioAplicacion(Integer id_aplicacion, Integer id_usuario, String nombre_rol){
		
		RolePorUsuarioAplicacionQueryCriteria criteria = new RolePorUsuarioAplicacionQueryCriteria();
		criteria.setId_aplicacion(id_aplicacion);
		criteria.setId_usuario(id_usuario);
		criteria.setNombre_rol(nombre_rol);
		
		return JsonReturnUtil.returnList(rolePorUsuarioAplicacionQueryMapper.getListQueryByCriteria(criteria));
		
	}
	
	@RequestMapping(value="/funcionalidadPorIdSession")
	public @ResponseBody TreeDto funcionalidadPorIdSession(String id_session){
		
		FuncionalidadPorIdSesionQueryCriteria criteria = new FuncionalidadPorIdSesionQueryCriteria();
		criteria.setId_session(id_session);
		
		List<FuncionalidadPorIdSesionQuery> list = funcionalidadPorIdSesionQueryMapper.getListQueryByCriteria(criteria);
		
		TreeDto treeDto = new TreeDto();
		treeDto.setText("Opciones Principales");
		treeDto.setCls("folder");
		
		for (FuncionalidadPorIdSesionQuery funcionalidadPorIdSesionQuery : list) {
			
			TreeDto child = new TreeDto();
			child.setText(funcionalidadPorIdSesionQuery.getNombre_funcionalidad());
			child.setAliasComponent(funcionalidadPorIdSesionQuery.getAlias_component());
			child.setControllerComponent(funcionalidadPorIdSesionQuery.getComponent_controllers());
			child.setLeaf(true);
			
			treeDto.getChildren().add(child);
		}
		
		return treeDto;
		
	}
	
	@RequestMapping(value="/aplicacionPorId")
	public @ResponseBody Map<String,? extends Object> aplicacionPorId(Integer id_aplicacion){
		
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.setId_aplicacion(id_aplicacion);
		
		return JsonReturnUtil.returnRecord(aplicacionMapper.selectByPrimaryKey(aplicacion));
		
	}
}
