package proyecto.action;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import proyecto.util.Funciones;
import proyecto.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SigAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String clave;
	private String variable;
	private URL redirectUrl;
	
	public String execute() throws MalformedURLException,UnsupportedEncodingException{
		
		 //HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		 Map<String, Object> session = ActionContext.getContext().getSession();
		 Usuario u=(Usuario) session.get("USUARIO_ACTUAL");
		 		 
		 //username = Funciones.MD5(u.getUsername());
		 //clave = u.getClave();
		 //variable = Funciones.MD5("d");
		 
		 String param = Funciones.MD5(u.getUsername())+"^"+u.getClave()+"^"+Funciones.MD5("d");
		 
		 String url = "http://geo.sernanp.gob.pe/index.php?acces="+param;
		 
		 //String encodedUrl = URLEncoder.encode(url,"UTF-8");
		 
		redirectUrl = new URL(url);		
		 
		//setRedirectUrl(redirectUrl);
		
		return SUCCESS;
	}	
		
	public void setUsername(String username) {
		this.username = username;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}

	public URL getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(URL redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	
}
