package sernanp.rrhh.interceptor;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import sernanp.rrhh.service.PersonalLicenciasService;
import sernanp.rrhh.service.PersonalPapeletaService;
import sernanp.rrhh.service.PersonalService;
import sernanp.rrhh.service.PersonalVacacionesService;
import sernanp.rrhh.util.Funciones;
import sernanp.rrhh.vo.PersonalLicenciasVO;
import sernanp.rrhh.vo.PersonalVacacionesGoceVO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("unused")
public class PersonalLicenciasVacacionesInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub		
	}

	private PersonalVacacionesService personalVacacionesService;
	private PersonalLicenciasService personalLicenciasService;
	private PersonalPapeletaService personalPapeletaService;
//	private List<PersonalLicenciasVO> personalLicencias;
//	private List<PersonalVacacionesGoceVO> personalVacacionesGoce;
	private PersonalService personalService;


	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request 	= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		int idP						= 0;
		int cantLicVac				= 0;
		int anioDescuentofi			= 0;
		int mesDescuentofi			= 0;		
		int anioDescuentoff 		= 0;
		int mesDescuentoff			= 0;	
		int descCerrado				= 0;
		String  [] strExplode		= null;
		Date fechInicioLV			= null;
		Date fechFinLV				= null;
		String strReturn			= null;	
		String strvaloridP			= null;
		
		try {
			
			if(request.getAttribute("personalLicencias.dte_fec_inicio_lic") != null){
//				System.out.println("Interceptor - Vista Licencias ");					
				fechInicioLV	= (Date) request.getAttribute("personalLicencias.dte_fec_inicio_lic");
				fechFinLV		= (Date) request.getAttribute("personalLicencias.dte_fec_fin_lic");
				idP				= Integer.valueOf(request.getAttribute("personalLicencias.idPersonallicencia").toString());
			
				strExplode 		= Funciones.explodeString(fechInicioLV.toString(), "-");					
				anioDescuentofi 	= Integer.valueOf(strExplode[0]);
				mesDescuentofi	= Integer.valueOf(strExplode[1]);					
				
				strExplode 		= Funciones.explodeString(fechFinLV.toString(), "-");					
				anioDescuentoff 	= Integer.valueOf(strExplode[0]);
				mesDescuentoff	= Integer.valueOf(strExplode[1]);	
				
				if(mesDescuentofi == mesDescuentoff && anioDescuentofi == anioDescuentoff){
					descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentofi, mesDescuentofi, -1, 0,0);
				}else if(mesDescuentofi != mesDescuentoff){
					descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentofi, mesDescuentofi, -1, 0,0);
					if(descCerrado == 0){
						descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentoff, mesDescuentoff, -1, 0,0);
					}
				}	
				
				if(descCerrado > 0){
					ServletActionContext.getRequest().setAttribute("msg","Rango de fechas seleccionado, está un periodo de Descuentos Cerrado.");
					strReturn = "existeLicenciaVacaciones";
					return strReturn;
				}					
					
				
				cantLicVac 		= personalVacacionesService.vacacionesRangoFechas(idP, fechInicioLV, fechFinLV);					

				if(cantLicVac > 0){
					ServletActionContext.getRequest().setAttribute("msg","Personal tiene Vacaciones en el rango de fechas seleccionado.");
					strReturn = "existeLicenciaVacaciones";
					return strReturn;
				}else{
			
					cantLicVac 		= personalLicenciasService.licenciasRangoFechas(idP, fechInicioLV, fechFinLV);
					if(cantLicVac > 0){

							ServletActionContext.getRequest().setAttribute("msg","Personal tiene Licencia(s) en el rango de fechas seleccionado.");
							strReturn = "existeLicenciaVacaciones";
							return strReturn;						
					}else{
						cantLicVac = personalPapeletaService.cantPapeletaxidPersonalFecha(idP, fechInicioLV, fechFinLV);
						if(cantLicVac > 0){
							ServletActionContext.getRequest().setAttribute("msg","Personal tiene Papeleta por día en el rango de fechas seleccionado.");
							strReturn = "existeLicenciaVacaciones";
							return strReturn;							
						}
					}

				}

			}else if(request.getAttribute("personalVacacionesGoce.dte_fec_inicio_goc_vac") != null ){//&& request.getParameter("idPersonal") != null){
	
				fechInicioLV 	= (Date) request.getAttribute("personalVacacionesGoce.dte_fec_inicio_goc_vac");
				fechFinLV		= (Date) request.getAttribute("personalVacacionesGoce.dte_fec_fin_goc_vac");
				idP				= Integer.parseInt(request.getParameter("idPersonal"));
				
				
				
				strExplode 		= Funciones.explodeString(fechInicioLV.toString(), "-");					
				anioDescuentofi = Integer.valueOf(strExplode[0]);
				mesDescuentofi	= Integer.valueOf(strExplode[1]);					
				
				strExplode 		= Funciones.explodeString(fechFinLV.toString(), "-");					
				anioDescuentoff 	= Integer.valueOf(strExplode[0]);
				mesDescuentoff	= Integer.valueOf(strExplode[1]);	
				
				if(mesDescuentofi == mesDescuentoff && anioDescuentofi == anioDescuentoff){
					descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentofi, mesDescuentofi, -1, 0,0);
				}else if(mesDescuentofi != mesDescuentoff){
					descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentofi, mesDescuentofi, -1, 0,0);
					if(descCerrado == 0){
						descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentoff, mesDescuentoff, -1, 0,0);
					}
				}			
			
				
				if(descCerrado > 0){
					ServletActionContext.getRequest().setAttribute("msg","Rango de fechas seleccionado, está un periodo de Descuentos Cerrado.");
					strReturn = "existeLicenciaVacaciones";
					return strReturn;
				}
				
				
				cantLicVac 		= personalLicenciasService.licenciasRangoFechas(idP, fechInicioLV, fechFinLV);				
				
				if(cantLicVac > 0){
					ServletActionContext.getRequest().setAttribute("msg","Personal tiene Licencia(s) en el rango de fechas seleccionado.");
					strReturn = "existeLicenciaVacaciones";					
					return strReturn;
				}else{
					cantLicVac 		= personalVacacionesService.vacacionesRangoFechas(idP, fechInicioLV, fechFinLV);
					if(cantLicVac > 0){
						ServletActionContext.getRequest().setAttribute("msg","Personal tiene Vacaciones en el rango de fechas seleccionado.");
						strReturn = "existeLicenciaVacaciones";
						return strReturn;						
					}else{
						cantLicVac = personalPapeletaService.cantPapeletaxidPersonalFecha(idP, fechInicioLV, fechFinLV);
						if(cantLicVac > 0 ) {
							ServletActionContext.getRequest().setAttribute("msg","Personal tiene Papeleta por día en el rango de fechas seleccionado.");
							strReturn = "existeLicenciaVacaciones";
							return strReturn;				
						}
						
					}
				}				

			//}else if(request.getParameter("idVacaciones") != null && request.getParameter("idVacacionesGoce") != null){
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arg0.invoke();	
		
	}
	


//	public List<PersonalVacacionesGoceVO> getPersonalVacacionesGoce() {
//		return personalVacacionesGoce;
//	}
//
//	public void setPersonalVacacionesGoce(
//			List<PersonalVacacionesGoceVO> personalVacacionesGoce) {
//		this.personalVacacionesGoce = personalVacacionesGoce;
//	}

	public void setPersonalService(PersonalService personalService) {
		this.personalService = personalService;
	}

//	public List<PersonalLicenciasVO> getPersonalLicencias() {
//		return personalLicencias;
//	}
//
//	public void setPersonalLicencias(List<PersonalLicenciasVO> personalLicencias) {
//		this.personalLicencias = personalLicencias;
//	}

	public void setPersonalVacacionesService(
			PersonalVacacionesService personalVacacionesService) {
		this.personalVacacionesService = personalVacacionesService;
	}
	
	public void setPersonalLicenciasService(
			PersonalLicenciasService personalLicenciasService) {
		this.personalLicenciasService = personalLicenciasService;
	}

	public void setPersonalPapeletaService(
			PersonalPapeletaService personalPapeletaService) {
		this.personalPapeletaService = personalPapeletaService;
	}
	
	

}
