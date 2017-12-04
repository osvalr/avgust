package proyecto.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import proyecto.service.UsuarioService;

import com.opensymphony.xwork2.ActionSupport;

public class UsuariosMantenerAction extends ActionSupport 
	implements SessionAware, ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Map session;

	public void setSession(Map m) {
		session = m;
	}

	Log log = LogFactory.getLog(getClass());
	
	private UsuarioService usuarioService;
	
	public void setUsuarioService(UsuarioService usuarioService){
		this.usuarioService = usuarioService;
	}
	
	private HttpServletRequest request;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/*
	public String buscar() {
		System.out.println("UsuariosMantenerAction: buscar(): nombres:"
				+ nombres);
		if (nombres != null) {
			try { 
				Collection<Usuario> c = usuarioService.buscarPorNombre(nombres);
				request.setAttribute("usuarios", c);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
		}
		return SUCCESS;
	}
	

	public String editar() {
		System.out.println("UsuariosMantenerAction: editar()");
		try {
			ServletActionContext.getRequest().setAttribute("usuario",
					usuarioService.obtenerPorIdUsuario(idUsuario));

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String actualizar() {
		System.out.println("UsuariosMantenerAction: actualizar()");
		Usuario vo = new Usuario();
		vo.setUsuario(idUsuario);
		vo.setClave(clave);
		/*
		vo.setNombre(nombres);
		vo.setApepat(paterno);
		vo.setApemat(materno);
		vo.setEmail(correo);
		vo.setDireccion(direccion);
		//vo.setTelefono(telefono); 
		vo.setEstado(estado);
		*/ 
	
	/*/
		try {
			usuarioService.actualizar(vo);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String nuevo() {
		return SUCCESS;
	}

	public String insertar() {
		System.out.println("UsuariosMantenerAction: insertar()");
		Usuario vo = new Usuario();
		vo.setUsuario(idUsuario);
		vo.setClave(clave);
		/*
		vo.set.setNombre(nombres);
		vo.setApepat(paterno);
		vo.setApemat(materno);
		vo.setEmail(correo);
		vo.setDireccion(direccion);
	//	vo.setTelefono(telefono);
		vo.setEstado(estado);
		*/
	
	/*
		try {
			usuarioService.insertar(vo);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
/*
	public String eliminar() {
		try {
			//usuarioService.eliminar(idUsuario);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
*/
	private String idUsuario;

	private String clave;

	private String nombres;

	private String paterno;

	private String materno;

	private String correo;

	private String direccion;

	private String telefono;

	private int estado;

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
