package proyecto.interceptor;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import proyecto.service.PersonalRegistroService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ValidarExisteFichaRegistroInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonalRegistroService personalregistroService;
	
	

	public void setPersonalregistroService(
			PersonalRegistroService personalregistroService) {
		this.personalregistroService = personalregistroService;
	}

	public void destroy() {
		//System.out.println("destroy()");
	}

	public void init() { 
		
		//System.out.println("init()");
	}

	public String intercept(ActionInvocation arg0) throws Exception{
		
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			
			int idpr = Integer.valueOf(request.getParameter("idpersonalregistro"));
			
			int cont = 0;
			
			cont = personalregistroService.listarPersonalxID(idpr);
						
			
			if(cont > 0){
				ServletActionContext.getRequest().setAttribute("MSGERROR", "Lo Sentimos, no se pudo realizar la acción solcitada, puesto que dicho personal se encuentra relacionado a un formulario.");
				
				return "error";
			}
		
		}catch(Exception e){
			//e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("MSGERROR", "Problema inesperado, por favor vuelva a intentarlo.");
			return "error";
		}		
		
		return arg0.invoke();

	}
}
