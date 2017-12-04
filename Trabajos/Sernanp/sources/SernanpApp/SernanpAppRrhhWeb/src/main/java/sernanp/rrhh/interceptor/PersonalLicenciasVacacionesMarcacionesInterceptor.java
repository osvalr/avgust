package sernanp.rrhh.interceptor;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import sernanp.rrhh.service.PersonalService;
import sernanp.rrhh.vo.Personanatural;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PersonalLicenciasVacacionesMarcacionesInterceptor implements Interceptor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	private PersonalService personalService;
	private Personanatural personanatural;
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request 	= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		int lic_vac				= 0;		
		int idP					= 0;
		String fechaAsistencia	= null;
		String nombreCompleto	= null;
		String strReturn		= null;
		
		Date fechInicio		= null;
		Date fechFin			= null;
		
		System.out.println("Hello : verificalicenciasvacacionesInsertMarcaciones");
		
		try {					
			if(request.getParameter("dte_fec_marc1") != null && request.getParameter("dte_fec_marc2") != null && request.getParameter("idpersonal") != null){	
				
				fechInicio	= (Date) request.getAttribute("personalLicencias.dte_fec_inicio_lic");
				fechFin		= (Date) request.getAttribute("personalLicencias.dte_fec_fin_lic");
				idP					= Integer.valueOf(request.getParameter("idpersonal"));	
				fechaAsistencia		= request.getParameter("dte_fec_marc");
				
				System.out.println("Interceptor - Fecha : " + fechaAsistencia);
				lic_vac = personalService.verificarLicenciasPersonal(idP, fechaAsistencia);
				if(lic_vac > 0){
					ServletActionContext.getRequest().setAttribute("msg","El personal seleccionado esta de Licencia.");	
					strReturn = "existeLicenciaVacacionesInsertMarcaciones";
				}else{
					lic_vac = personalService.verificarVacacionesPersonal(idP, request.getParameter("dte_fec_marc"));
					if(lic_vac > 0){						
						ServletActionContext.getRequest().setAttribute("msg","El personal seleccionado esta de Vacaciones.");
						strReturn = "existeLicenciaVacacionesInsertMarcaciones";
					}
				}	
			}
			
			if(lic_vac > 0){				
//				personanatural	= new Personanatural();
//				personanatural 	= personalService.listapersonalxID(idP);
//				nombreCompleto	= personanatural.getApepat() + " " + personanatural.getApemat() + ", " + personanatural.getNombre();
//				ServletActionContext.getRequest().setAttribute("dte_fec_marc",fechaAsistencia);
//				ServletActionContext.getRequest().setAttribute("nombreCompleto",nombreCompleto);
				
				return strReturn; 
			}			

			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return arg0.invoke();
	}



	public Personanatural getPersonanatural() {
		return personanatural;
	}

	public void setPersonanatural(Personanatural personanatural) {
		this.personanatural = personanatural;
	}

	public void setPersonalService(
			PersonalService personalService) {
		this.personalService = personalService;
	}
	
}
