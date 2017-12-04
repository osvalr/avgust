package sernanp.rrhh.interceptor;

import java.sql.Date;
import java.sql.Time;
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
public class PersonalPapeletaInterceptor implements Interceptor{

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
	private List<PersonalLicenciasVO> personalLicencias;
	private List<PersonalVacacionesGoceVO> personalVacacionesGoce;
	private PersonalService personalService;
	private PersonalPapeletaService personalPapeletaService;


	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request 	= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		int idP						= 0;
		int cantPapeletas			= 0;
		int anioDescuento			= 0;
		int mesDescuento			= 0;
		int descCerrado				= 0;
		String  [] strExplode		= null;
		Date fechInicioPap			= null;
		Date fechFinPap				= null;
		String strReturn			= null;	
		String strvaloridP			= null;
		Time horInicioPap			= null;
		Time horFinPap				= null;
		
		try {
			/*  Interceptor para ELMINIAR cuando la fecha de marcación no este en una fecha de un periodo de Descuentos CERRADO          */
			if(request.getAttribute("isajax") != null) {
//				System.out.println("Eliminar Marcación");
				fechInicioPap 	= Funciones.convertString2SqldateFormat(request.getAttribute("dte_fec_marc").toString(), "dd/MM/yyyy");
				strExplode 		= Funciones.explodeString(fechInicioPap.toString(), "-");					
				anioDescuento 	= Integer.valueOf(strExplode[0]);
				mesDescuento	= Integer.valueOf(strExplode[1]);				
				
				descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuento, mesDescuento, -1, 0,0);
				
//				System.out.println("Anio y Mes Descuento Cerrado - Eliminar: " + anioDescuento + " / " + mesDescuento);
//				System.out.println("Descuentos cerrado - Eliminar : " + descCerrado);
				
				if(descCerrado > 0){
					ServletActionContext.getRequest().setAttribute("msg","La fecha de Asistencia está en un periodo de Descuentos Cerrado, ");
					strReturn = "periodoCerrado";
					return strReturn;
				}
				
			}else{
//				System.out.println("Insertar Marcación");
				/*  Interceptor para INSERTAR cuando la fecha de marcación no este en una fecha de un periodo de Descuentos CERRADO          */
			
	//			System.out.println("Llamando el interceptor");
				
				idP				= Integer.valueOf(request.getAttribute("personalMarcacion.personal.idpersonal").toString());			
				
	//			System.out.println("Interceptor - Papeleta ");				
				if(request.getAttribute("timePermiso") != null && Integer.parseInt(request.getAttribute("timePermiso").toString()) == 0){	
					
	//				System.out.println("Papeleta por Día ......");
					
					fechInicioPap	= (Date) request.getAttribute("personalMarcacion.dte_fec_marc1");
					fechFinPap		= (Date) request.getAttribute("personalMarcacion.dte_fec_marc2");
					
					if(fechInicioPap == null || fechFinPap == null){
						ServletActionContext.getRequest().setAttribute("msg","Fecha Inicio y Fín son datos obligatorios.");
						strReturn = "periodoCerrado";
						return strReturn;
					}
					
					strExplode 		= Funciones.explodeString(fechInicioPap.toString(), "-");					
					anioDescuento 	= Integer.valueOf(strExplode[0]);
					mesDescuento	= Integer.valueOf(strExplode[1]);					
					
					descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuento, mesDescuento, -1, 0,0);	
					
						if(descCerrado > 0){
							ServletActionContext.getRequest().setAttribute("msg","El rango de fechas que ha seleccionado, está un periodo de Descuentos Cerrado.");
							strReturn = "periodoCerrado";
							return strReturn;
						}else{
							cantPapeletas = personalPapeletaService.cantPapeletaxidPersonalFecha(idP, fechInicioPap, fechFinPap);
							if(cantPapeletas > 0){
								ServletActionContext.getRequest().setAttribute("msg","El rango de fechas que ha seleccionado, está registrado en una papeleta.");
								strReturn = "periodoCerrado";
								return strReturn;								
							}else{
								cantPapeletas 		= personalVacacionesService.vacacionesRangoFechas(idP, fechInicioPap, fechFinPap);
								if(cantPapeletas > 0 ){
									ServletActionContext.getRequest().setAttribute("msg","El rango de fechas que ha seleccionado, está registrado en Vacaciones programadas.");
									strReturn = "periodoCerrado";
									return strReturn;
								}else{
									cantPapeletas 		= personalLicenciasService.licenciasRangoFechas(idP, fechInicioPap, fechFinPap);
									if(cantPapeletas > 0 ){
										ServletActionContext.getRequest().setAttribute("msg","El rango de fechas seleccionado, está registrado en Licencias.");
										strReturn = "periodoCerrado";
										return strReturn;
									}else{
										cantPapeletas	= personalPapeletaService.cantPermisosxidPersonalFecha(idP, fechInicioPap, fechFinPap);
										if(cantPapeletas > 0){
											ServletActionContext.getRequest().setAttribute("msg","El rango de fechas seleccionado, está registrado en un Permiso.");
											strReturn = "periodoCerrado";
											return strReturn;										
										}
									}
									
								}
								
							}
						
						}
				}else if(request.getAttribute("timePermiso") != null && Integer.parseInt(request.getAttribute("timePermiso").toString()) == 1){
					
	//				System.out.println("Papeleta por Horas ......");
					
					horInicioPap	= (Time) request.getAttribute("personalMarcacion.hor_hor_marc");
					horFinPap		= (Time) request.getAttribute("personalMarcacion.hor_hor_marc1");
		
					if(horInicioPap == null && horFinPap == null){
						ServletActionContext.getRequest().setAttribute("msg","Ingrese Hora Inicio u Hora Fín, de no ser necesario las dos.");
						strReturn = "periodoCerrado";
						return strReturn;
					}
					
					fechInicioPap	= (Date) request.getAttribute("personalMarcacion.dte_fec_marc");
					strExplode 		= Funciones.explodeString(fechInicioPap.toString(), "-");					
					anioDescuento 	= Integer.valueOf(strExplode[0]);
					mesDescuento	= Integer.valueOf(strExplode[1]);				
					
					
					
					descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuento, mesDescuento, -1, 0,0);
					
	//				System.out.println("Anio y Mes Descuento Cerrado : " + anioDescuento + " / " + mesDescuento);
	//				System.out.println("Descuentos cerrado : " + descCerrado);
					
					if(descCerrado > 0){
						ServletActionContext.getRequest().setAttribute("msg","La fecha de Asistencia está en un periodo de Descuentos Cerrado, ");
						strReturn = "periodoCerrado";
						return strReturn;
					}else{
						cantPapeletas = personalPapeletaService.cantPapeletaxidPersonalFecha(idP, fechInicioPap, fechInicioPap);
						if(cantPapeletas > 0){
							ServletActionContext.getRequest().setAttribute("msg","La fecha de Asistencia está registrado en una papeleta por día(s).");
							strReturn = "periodoCerrado";
							return strReturn;								
						}else{
							cantPapeletas 		= personalVacacionesService.vacacionesRangoFechas(idP, fechInicioPap, fechInicioPap);
							if(cantPapeletas > 0 ){
								ServletActionContext.getRequest().setAttribute("msg","La fecha de Asistencia está registrada en Vacaciones programadas.");
								strReturn = "periodoCerrado";
								return strReturn;
							}else{
								cantPapeletas 		= personalLicenciasService.licenciasRangoFechas(idP, fechInicioPap, fechInicioPap);
								if(cantPapeletas > 0 ){
									ServletActionContext.getRequest().setAttribute("msg","La fecha de Asistencia está registrada en Licencias.");
									strReturn = "periodoCerrado";
									return strReturn;
	//							}else{
	//								cantPapeletas	= personalPapeletaService.cantPermisosxidPersonalFecha(idP, fechInicioPap, fechFinPap);
	//								if(cantPapeletas > 0){
	//									ServletActionContext.getRequest().setAttribute("msg","El rango de fechas seleccionado, está registrado en un Permiso.");
	//									strReturn = "periodoCerrado";
	//									return strReturn;										
	//								}
								}
								
							}
							
						}
					
					}
					
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arg0.invoke();	
		
	}
	


	public List<PersonalVacacionesGoceVO> getPersonalVacacionesGoce() {
		return personalVacacionesGoce;
	}

	public void setPersonalVacacionesGoce(
			List<PersonalVacacionesGoceVO> personalVacacionesGoce) {
		this.personalVacacionesGoce = personalVacacionesGoce;
	}

	public void setPersonalService(PersonalService personalService) {
		this.personalService = personalService;
	}

	public List<PersonalLicenciasVO> getPersonalLicencias() {
		return personalLicencias;
	}

	public void setPersonalLicencias(List<PersonalLicenciasVO> personalLicencias) {
		this.personalLicencias = personalLicencias;
	}

	public void setPersonalVacacionesService(
			PersonalVacacionesService personalVacacionesService) {
		this.personalVacacionesService = personalVacacionesService;
	}
	
	public void setPersonalLicenciasService(
			PersonalLicenciasService personalLicenciasService) {
		this.personalLicenciasService = personalLicenciasService;
	}

	public PersonalPapeletaService getPersonalPapeletaService() {
		return personalPapeletaService;
	}

	public void setPersonalPapeletaService(
			PersonalPapeletaService personalPapeletaService) {
		this.personalPapeletaService = personalPapeletaService;
	}
	
	
	
	

}
