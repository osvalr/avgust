package sernanp.rrhh.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.dao.RolModuloDAO;
import sernanp.rrhh.dao.UsuarioDAO;
import sernanp.rrhh.dao.UsuarioRolDAO;
import sernanp.rrhh.vo.RolModulo;
import sernanp.rrhh.vo.Usuario;
import sernanp.rrhh.vo.UsuarioRol;



@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private RolModuloDAO rolModuloDAO;
	@Autowired
	private UsuarioRolDAO usuarioRolDAO;
	
	public boolean verificarUsuario(Usuario usuario){
		usuario.setEstado(ValueConstants.FLAG_ACTIVO);
		return usuarioDAO.loginUsuario(usuario);
		
	}
	
	public boolean validarUsuarioUnico(Usuario usuario){
		boolean rpta=true;
		if(usuarioDAO.contarUnico(usuario)!=0){
		   rpta=false;
		}
		return rpta;
	}
	
	public int guardarUsuario(Usuario usuario){
		int idusuario=0;
		if(usuario.getIdUsuario()==0){
				idusuario=usuarioDAO.insertar(usuario);
			
		}else{
			idusuario=usuario.getIdUsuario();
			//actualizar
		}
		return idusuario;
		
	}	
	
	
	public Usuario consultarUsuarioxId(int idusuario){
		List<Usuario> lista=new ArrayList<Usuario>();
		lista=usuarioDAO.listar(new Usuario(idusuario));
		if(lista.size()==1){
			return lista.get(0);
		}
		else{
			return null;
		}
	}
	
	
	
	public Usuario consultarUsuario(Usuario usuario){
		List<Usuario> lista=new ArrayList<Usuario>();
		lista=usuarioDAO.listar(usuario);
		if(lista.size()==1){
			return lista.get(0);
		}
		else{
			return null;
		}
	}	
	
/*	
	public void consultarModulosxUsuario(Usuario usuario){
		List<RolModulo> lista=new ArrayList<RolModulo>();
		RolModulo rm=new RolModulo();
		//System.out.println(usuario.getRol().getIdrol());
		rm.getRol().setIdrol(usuario.getRol().getIdrol());
		lista=rolModuloDAO.listar(rm);
		usuario.getRol().setListaRolModulo(lista);
		Map map=new HashMap<Integer, Integer>();
		for(RolModulo rmo:lista){ 
			map.put(rmo.getModulo().getIdmodulo(), rmo.getPesorol());
		}
		usuario.getRol().setMapModuloTipoRol(map);
	}
*/	
	public void consultarModulosxUsuario(Usuario usuario) {
		List<RolModulo> lista			= new ArrayList<RolModulo>();
		List<UsuarioRol> listaUsuRol	= new ArrayList<UsuarioRol>();
		RolModulo rm=new RolModulo();
		//System.out.println(usuario.getRol().getIdrol());
		
		if(usuario.getRol().getIdrol() != 0){
			rm.getRol().setIdrol(usuario.getRol().getIdrol());
			lista=rolModuloDAO.listar(rm);
		}
		
		{
			UsuarioRol usuarioRol	= new UsuarioRol();
			usuarioRol.getUsuario().setIdUsuario(usuario.getIdUsuario());
			listaUsuRol=usuarioRolDAO.listar(usuarioRol);
			for(int i = 0;i < listaUsuRol.size();i++) {
				rm=new RolModulo();
				rm.getRol().setIdrol(listaUsuRol.get(i).getRol().getIdrol());
				List<RolModulo> listaTmp=rolModuloDAO.listar(rm);
				if(listaTmp.size()>0) {
					boolean existe=false;
					for(int j = 0;j < listaTmp.size();j++) {
						existe=false;
						for(int k = 0;k < lista.size();k++) {
							if(listaTmp.get(j).getModulo().getIdmodulo() == lista.get(k).getModulo().getIdmodulo()) {
								existe=true;
								break;
							}
						}
						if(!existe) {
							lista.add(listaTmp.get(j));
						}
					}
				}
			}
		}
		usuario.getRol().setListaRolModulo(lista);
		Map map=new HashMap<Integer, Integer>();
		for(RolModulo rmo:lista){ 
			map.put(rmo.getModulo().getIdmodulo(), rmo.getPesorol());
		}
		usuario.getRol().setMapModuloTipoRol(map);
	}
	
}