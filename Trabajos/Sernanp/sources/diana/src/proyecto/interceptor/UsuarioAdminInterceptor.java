package proyecto.interceptor;

import java.util.Map;

import proyecto.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UsuarioAdminInterceptor implements Interceptor {
	      
	/**
	 *          
	 */            
	private static final long serialVersionUID = 1L;
   
	public void destroy() {
		//System.out.println("UsuarioAdminInterceptor: destroy()");
	}

	public void init() {
		//System.out.println("UsuarioAdminInterceptor: init()");
	}
	
	public String intercept(ActionInvocation arg0) throws Exception {
		//System.out.println("UsuarioAdminInterceptor: intercept");
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		Usuario vo = (Usuario) session.get("USUARIO_ACTUAL");
		if (vo == null) {
			//System.out.println("Usuario no logeado");
			return "Login";
		}
		if ( ! vo.getUsuario().equals("drodriguez")) {
			//System.out.println("Usuario no es Admin");
			return "Login";
		} else {			
			return arg0.invoke();
		}
	}
}
