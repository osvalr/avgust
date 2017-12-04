package proyecto.interceptor;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import proyecto.service.FichaRegistroService;
import proyecto.util.Funciones;
import proyecto.vo.FichaRegistro;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ActualizacionAprobacionFormInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FichaRegistroService ficharegistroService;
	private FichaRegistro ficharegistro;
	
	public void setFicharegistroService(FichaRegistroService ficharegistroService) {
		this.ficharegistroService = ficharegistroService;
	}	

	public void destroy() {
		//System.out.println("destroy()");
	}

	public void init() { 
		
		//System.out.println("init()");
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ctx = ActionContext.getContext();

		int idficharegistro = Integer.valueOf(request.getParameter("ficharegistro.idficharegistro"));
		
		ficharegistro =	ficharegistroService.muestraFichaFormulario(idficharegistro);
		
		String fechafr = request.getParameter("ficharegistro.fechacreacion");
						
		Timestamp ts = Funciones.fechaStringtoTimeStamp(fechafr);
						
		if(ficharegistro.getIdestadoficha() == 0){
			ServletActionContext.getRequest().setAttribute("MSGERROR", "Lo Sentimos, este formulario no puede ser aprobado debido a que fue anulado");
			return "error";
		}else if(ficharegistro.getIdestadoficha() == 2){
			ServletActionContext.getRequest().setAttribute("MSGERROR", "Lo Sentimos, este formulario ya se encuentra aprobado");
			return "error";
		}else if(ficharegistro.getFechacreacion().compareTo(ts) != 0){
			ServletActionContext.getRequest().setAttribute("MSGERROR", "Se advierte que este formulario ha sufrido una actualización, por favor vuelva a intentarlo");
			return "error";
		}		
		
		
		return arg0.invoke();

	}	
	
	public FichaRegistro getFicharegistro() {
		return ficharegistro;
	}

	public void setFicharegistro(FichaRegistro ficharegistro) {
		this.ficharegistro = ficharegistro;
	}
}
