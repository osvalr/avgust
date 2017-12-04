package sernanp.rrhh.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import sernanp.rrhh.vo.Modulo;
import sernanp.rrhh.vo.RolModulo;
import sernanp.rrhh.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UsuarioLogeadoInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
		//System.out.println("UsuarioLogeadoInterceptor: destroy()");
	}

	public void init() {
		
		//System.out.println("UsuarioLogeadoInterceptor: init()");
	}
	
	
	
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		//HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> session = ActionContext.getContext().getSession();
//		HttpServletResponse response = (HttpServletResponse) ActionContext
//		.getContext().get(ServletActionContext.HTTP_RESPONSE);
//		response.setHeader("Pragma", "No-cache"); 
//		response.setHeader("Cache-Control", "no-cache"); 
//		response.setDateHeader("Expires", 1); 
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String resultado="";
		//tipo usuario interno
		
			Usuario vo = (Usuario) session.get("USUARIO_ACTUAL");
			if (vo == null) {
				   
				resultado= "Login";        
			} else {
				
				//session.put("noMuestraMenu", 0);
				
								
				if(request.getParameter("idmodulo")!=null){
					session.put("noMuestraMenu", 0);
					int idmodulopadre=Integer.parseInt(request.getParameter("idmodulo").toString());
					session.put("idmoduloactual", idmodulopadre);
					session.put("idtiporol", vo.getRol().getMapModuloTipoRol().get(idmodulopadre));
					//session.put("hrefanterior", value);
					//
					
					
					
					//
					List<Modulo> listaMenuActual=new ArrayList<Modulo>();
					for(RolModulo rm:vo.getRol().getListaRolModulo()){
						if(rm.getModulo().getNiveldependemodulo()==idmodulopadre){
							Modulo mod=new Modulo();
							mod=rm.getModulo();
							listaMenuActual.add(mod);
							
						}
						
					}
					
					if(listaMenuActual.size()!=0){
						session.put("listaMenuActual", listaMenuActual);
					}
					
					
				}	
				
//				System.out.println("UsuarioLogeadoInterceptor : intercept");
				resultado= actionInvocation.invoke();
				
			
				
			}
		return resultado;
	}
	
	

//	public String intercept(ActionInvocation arg0) throws Exception {
//		//HttpServletRequest request = ServletActionContext.getRequest();
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
//		String resultado="";
//		//tipo usuario interno
//		if(session.get("tipoUsuarioLogin")==null){
//			Usuario vo = (Usuario) session.get("USUARIO_ACTUAL");
//			System.out.println("usuario interno intercep");
//			//herencia, corregir esta en hard
//			String action = request.getRequestURI().substring(7);
//			//System.out.println("UsuarioLogeadoInterceptor: intercept");
//			//System.out.println("action e"+request.getRequestURI());
//			//System.out.println("action int:"+action);
//			//request.getAttribute(arg0)
//			if (vo == null) {
//				session.put("lastAction",action);   
//				resultado= "Login";        
//			} else {
//	            List<Map<String, Object>> arm = vo.getModulos();
//	            int i = 0;
//				int idmodulopadre=0;
//				if(request.getParameter("idmodulo")!=null){
//				    idmodulopadre=Integer.parseInt(request.getParameter("idmodulo").toString());
//					System.out.println("idmod intercep"+idmodulopadre);
//				}
//				List<RolModulo> lista=vo.getRol().getListaRolModulo();
//				List<Modulo> listaMenuActual=new ArrayList<Modulo>();
//				for(RolModulo rm:lista){
//					if(rm.getModulo().getNiveldependemodulo()==idmodulopadre){
//						Modulo mod=new Modulo();
//						mod=rm.getModulo();
//						System.out.println("nombre mod"+rm.getModulo().getNombremodulo());
//						listaMenuActual.add(mod);
//					}
//					
//				}
//				System.out.println("tam listamenuact"+listaMenuActual.size());
//				if(listaMenuActual.size()!=0){
//					session.put("listaMenuActual", listaMenuActual);
//				}
//				resultado= arg0.invoke();
//			}
//			
//			
//			
//		}
//		//otros tipos de usuario
//		else{
//			int tipousuario=Integer.parseInt(session.get("tipoUsuarioLogin").toString());	
//			System.out.println("usuario operador intercept");
//			//usuario operador turistico
//			if(tipousuario==ValueConstants.TIPO_USUARIO_OPERADOR_TURISTICO){
//				Operadorturismo operadorturismo = (Operadorturismo) session.get("usuarioOperador");
//				if (operadorturismo == null) {
//					resultado= "loginOperador";        
//				} else {	
//					resultado= arg0.invoke();
//				}
//			}
//			
//		}
//		return resultado;
//	}
//	
	
}

/*
System.out.println("uri"+request.getRequestURI());
System.out.println("url"+request.getRemoteHost());


System.out.println(request.getRequestURI().substring(7));
System.out.println("ARM:" + JSONArray.fromObject(arm).toString() );              
 */
