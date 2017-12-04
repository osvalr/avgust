package proyecto.action;

import java.net.URL;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import proyecto.service.SeguridadService;
import proyecto.util.Funciones;
import proyecto.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SeguridadAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private URL redirectUrl;
	
	@Autowired   
	private SeguridadService seguridadService;
	
	private int idmodulo;
	
	public String generaClave() {
		return "";
	}
	
	public void seguridadSgmvemi() {
		//HttpServletRequest request		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response	= (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		Map<String, Object> session		= ActionContext.getContext().getSession();
		try {
			Usuario usuario				= (Usuario)session.get("USUARIO_ACTUAL");
			
//			String strUsuario		= usuario.getUsername();
			Integer intIdSistema	= 1;
			String clave	= seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
			response.sendRedirect("/sgmvemi/seguridad.action?claveDinamica=" + clave);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Funciones para el módulo SAD
	public void seguridadSad() {		
				
		//HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		Map<String, Object> session = ActionContext.getContext().getSession();
		try {
		Usuario usuario = (Usuario)session.get("USUARIO_ACTUAL");
		Integer intIdSistema = 2;
		String clave = seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
		response.sendRedirect("/sad/autenticar.action?claveDinamica=" + clave);
		} catch(Exception ex) {
		ex.printStackTrace();
		}
	}
	
	//Funcion par el módulo de visitantes
	public void seguridadVisit() {
		//HttpServletRequest request		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response	= (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		Map<String, Object> session		= ActionContext.getContext().getSession();
		
		try {
		Usuario usuario = (Usuario)session.get("USUARIO_ACTUAL");
		Integer intIdSistema = 3;
		String clave = seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
		response.sendRedirect("/visitantes/autenticar.action?claveDinamica=" + clave + "&idmodulo=" + idmodulo);
		} catch(Exception ex) {
		ex.printStackTrace();
		}
	}
	
	
	//Funcion para el módulo de Convocatorias Caminos Inca
	public void seguridadConvoc() {
		//HttpServletRequest request		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response	= (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		Map<String, Object> session		= ActionContext.getContext().getSession();
		
		try {
		Usuario usuario = (Usuario)session.get("USUARIO_ACTUAL");
		Integer intIdSistema = 4;
		String clave = seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
		response.sendRedirect("/serviciotur/autenticar.action?claveDinamica=" + clave + "&idmodulo=" + idmodulo);
		} catch(Exception ex) {
		ex.printStackTrace();
		}
	}
		
	//Funcion par el módulo seguimiento de investigaciones
	public void seguridadSeguimientoI() {
		//HttpServletRequest request		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response	= (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		Map<String, Object> session		= ActionContext.getContext().getSession();
		
		try {
		Usuario usuario = (Usuario)session.get("USUARIO_ACTUAL");
		Integer intIdSistema = 5;
		String clave = seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
		response.sendRedirect("/seguimiento/autenticar.action?claveDinamica=" + clave + "&idmodulo=" + idmodulo);
		} catch(Exception ex) {
		ex.printStackTrace();
		}
	}
	
	//Funcion para el módulo seguimiento de capacitacion
		public void seguridadCapacitacion() {
			//HttpServletRequest request		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			HttpServletResponse response	= (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			Map<String, Object> session		= ActionContext.getContext().getSession();
			
			try {
			Usuario usuario = (Usuario)session.get("USUARIO_ACTUAL");
			Integer intIdSistema = 6;
			String clave = seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
			response.sendRedirect("/capacitacion/autenticar.action?claveDinamica=" + clave + "&idmodulo=" + idmodulo);
			} catch(Exception ex) {
			ex.printStackTrace();
			}
		}

//Funcion para el módulo de Personal
	public void seguridadRRHH() {
		//HttpServletRequest request		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response	= (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		Map<String, Object> session		= ActionContext.getContext().getSession();
		
		try {
		Usuario usuario = (Usuario)session.get("USUARIO_ACTUAL");
		Integer intIdSistema = 7;
		String clave = seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
		response.sendRedirect("/personal/autenticar.action?claveDinamica=" + clave + "&idmodulo=" + idmodulo);
		} catch(Exception ex) {
		ex.printStackTrace();
		}
				}
	
	//Funcion para el módulo de Estadistica Turismo
		public void seguridadRecaudaVisitas() {
			//HttpServletRequest request		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			HttpServletResponse response	= (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			Map<String, Object> session		= ActionContext.getContext().getSession();
			
			try {
			Usuario usuario = (Usuario)session.get("USUARIO_ACTUAL");
			Integer intIdSistema = 8;
			String clave = seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
			response.sendRedirect("/recvisitantes/autenticar.action?claveDinamica=" + clave + "&idmodulo=" + idmodulo);
			} catch(Exception ex) {
			ex.printStackTrace();
			}
					}
				

		//Funcion para el módulo de Gestión de Información - Minería Aurifera
		public void seguridadPlataformaVirtual() {
			//HttpServletRequest request		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			HttpServletResponse response	= (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			Map<String, Object> session		= ActionContext.getContext().getSession();
			
			try {
			Usuario usuario = (Usuario)session.get("USUARIO_ACTUAL");
			Integer intIdSistema = 9;
			String clave = seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
			response.sendRedirect("/pvirtual/autenticar.action?claveDinamica=" + clave + "&idmodulo=" + idmodulo);
			} catch(Exception ex) {
			ex.printStackTrace();
			}
					}
		
		//Funcion para el módulo de Gestión de Manejos de Recursos
		public void seguridadManejoRecursos() {
			//HttpServletRequest request		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			HttpServletResponse response	= (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			Map<String, Object> session		= ActionContext.getContext().getSession();
			
			try {
			Usuario usuario = (Usuario)session.get("USUARIO_ACTUAL");
			Integer intIdSistema = 10;
			String clave = seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
			response.sendRedirect("/mmrsernanp/autenticar.action?claveDinamica=" + clave + "&idmodulo=" + idmodulo);
			} catch(Exception ex) {
			ex.printStackTrace();
			}
		}

		
		
		// 31-03-2015 DAVID
		// Funcion para el módulo de VIATICOS 

		public void seguridadViaticos() {
			//HttpServletRequest request		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			HttpServletResponse response	= (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			Map<String, Object> session		= ActionContext.getContext().getSession();
			
			try {
			Usuario usuario = (Usuario)session.get("USUARIO_ACTUAL");
			Integer intIdSistema = 11;
			String clave = seguridadService.generaClave(usuario.getUsername(), intIdSistema, usuario.getIdUsuario());
			response.sendRedirect("/viaticos/autenticar.action?claveDinamica=" + clave + "&idmodulo=" + idmodulo);
			} catch(Exception ex) {
			ex.printStackTrace();
			}
		}		
		
		
	public URL getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(URL redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public int getIdmodulo() {
		return idmodulo;
	}

	public void setIdmodulo(int idmodulo) {
		this.idmodulo = idmodulo;
	}
	
	
}