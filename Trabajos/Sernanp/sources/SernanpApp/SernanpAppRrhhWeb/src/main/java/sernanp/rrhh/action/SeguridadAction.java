package sernanp.rrhh.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import sernanp.rrhh.service.AreaNaturalService;
import sernanp.rrhh.service.LoginService;
import sernanp.rrhh.service.UsuarioService;
import sernanp.rrhh.vo.LoginVO;
import sernanp.rrhh.vo.Modulo;
import sernanp.rrhh.vo.RolModulo;
import sernanp.rrhh.vo.Usuario;

public class SeguridadAction extends ActionSupport {
	 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private LoginService loginService;	 
	@Autowired 
	private AreaNaturalService areaNaturalService;
	
	private String claveDinamica;
	private int idmodulo;
		
	public String autenticar() {

		try {
			Usuario u = null;
			
			if(claveDinamica != null && !claveDinamica.equals("")) {
				LoginVO loginVO		= new LoginVO();
				loginVO.setStrClaveMD5(claveDinamica);
				List<LoginVO> list		= loginService.buscarClave(loginVO);
				if(list.size() >  0) {
					loginVO		= list.get(0);
					u	= new Usuario();
					u.setIdUsuario(loginVO.getIntIdUsuario());
					//u=usuarioService.consultarUsuario(u);
					u=usuarioService.consultarUsuarioxId(u.getIdUsuario());
					
					usuarioService.consultarModulosxUsuario(u);					
				}
			} 			
			
			if(u != null) {				
				addUserSession(u);
			} 
//			session.put("homeMenuActive", "1");
		} catch(Exception ex) {
			ex.printStackTrace();
			return "error";
		}
		
		return SUCCESS;
	}
	
	
	public void addUserSession(Usuario usuario){
		HttpSession session =ServletActionContext.getRequest().getSession();
		
		Date factual=new Date();
		
		session.setAttribute("USUARIO_ACTUAL", usuario);
		session.setAttribute("area",  areaNaturalService.consultarAreasNaturalxId(usuario.getAreaorganica().getSede().getAreanatural().getIdareanatural()) );
		//session.setAttribute("idmoduloactual", 0);
		//session.setAttribute("listaMenuActual", listaMenuActual);
		session.setAttribute("fechaActual", factual);
				

		session.setAttribute("noMuestraMenu", 0);
		//int idmodulopadre = mod.getIdmodulo();
		int idmodulopadre = idmodulo;
		session.setAttribute("idmoduloactual", idmodulopadre);
		session.setAttribute("idtiporol", usuario.getRol().getMapModuloTipoRol().get(idmodulopadre));
		
		List<Modulo> listaMenuActual=new ArrayList<Modulo>();
		System.out.println("idmodulopadre --> " + idmodulopadre);
			for(RolModulo rm:usuario.getRol().getListaRolModulo()){
//				System.out.println("rm.getModulo().getNiveldependemodulo() --> " + rm.getModulo().getNiveldependemodulo());
				
				System.out.println("Módulo : " + rm.getModulo().getNombremodulo());
				if(rm.getModulo().getNiveldependemodulo()==idmodulopadre){
//				if(rm.getModulo().getNiveldependemodulo() != 0){
					for(RolModulo rm1:usuario.getRol().getListaRolModulo()){
						
//						System.out.println("rm.getModulo().getIdmodulo() --> " + rm.getModulo().getIdmodulo());
						
						if (rm.getModulo().getIdmodulo()  == rm1.getModulo().getNiveldependemodulo() ){
							Modulo smod=new Modulo();
							smod=rm1.getModulo();
							listaMenuActual.add(smod);							
						}

					}
					
					
					Modulo smod=new Modulo();
					smod=rm.getModulo();
					listaMenuActual.add(smod);
					
				}
				
			}
			
		if(listaMenuActual.size()!=0){				
			
			int ii = 0;
			System.out.println("N°  IDMODULO    NOMBREMODULO          NIVEL MODULO");
			for(Modulo x : listaMenuActual){				
				ii++;
				System.out.println(ii + ".- " + x.getIdmodulo() + " --> " + x.getNombremodulo() + " --> " + x.getNiveldependemodulo());
			}
			session.setAttribute("listaMenuActual", listaMenuActual);
		}
		
	}


 
	

	public String getClaveDinamica() {
		return claveDinamica;
	}


	public void setClaveDinamica(String claveDinamica) {
		this.claveDinamica = claveDinamica;
	}


	public int getIdmodulo() {
		return idmodulo;
	}


	public void setIdmodulo(int idmodulo) {
		this.idmodulo = idmodulo;
	}


	
	
}