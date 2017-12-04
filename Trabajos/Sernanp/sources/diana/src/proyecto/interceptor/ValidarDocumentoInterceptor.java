package proyecto.interceptor;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import proyecto.service.PersonalRegistroService;
import proyecto.vo.Operadorturismo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ValidarDocumentoInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonalRegistroService personalregistroService;
	private Operadorturismo operadorturismo;
	
	

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
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		operadorturismo = (Operadorturismo) session.get("operadorturismo");		
		
		int idtipo;
		String numdoc;
		try{
			idtipo = Integer.valueOf(request.getParameter("idtipodocumento"));		
			numdoc = request.getParameter("numerodocumento");		
		}catch(Exception e){
			idtipo = Integer.valueOf(request.getParameter("tipodocumento[0].idtipo"));
			numdoc = request.getParameter("personalregistro[0].numerodocumento");
		}
		
		int cont = 0;
		
		cont = personalregistroService.listarPersonalxTipoNumdoc(idtipo, numdoc, operadorturismo.getIdpersonajuridica());
		
		if(cont > 0){			
			ServletActionContext.getRequest().setAttribute("MSGERROR", "Lo Sentimos, el personal con tipo y número de documento<br /> ya se ecuentra registrado!!! ");
			return "error";
		}
			
		return arg0.invoke();

	}

	public Operadorturismo getOperadorturismo() {
		return operadorturismo;
	}

	public void setOperadorturismo(Operadorturismo operadorturismo) {
		this.operadorturismo = operadorturismo;
	}
	
	
}
