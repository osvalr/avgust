package proyecto.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SalirAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute(){
		//HttpServletRequest request = ServletActionContext.getRequest();
		//HttpSession session = request.getSession();
		//session.setAttribute("tipoUsuarioLogin", null);		
		//session.invalidate();
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		session.remove("tipoUsuarioLogin");
		session.remove("USUARIO_ACTUAL");		
		
		return SUCCESS;
	}
}
