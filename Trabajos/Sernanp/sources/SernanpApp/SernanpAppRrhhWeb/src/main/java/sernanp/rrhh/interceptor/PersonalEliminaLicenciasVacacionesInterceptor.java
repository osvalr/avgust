package sernanp.rrhh.interceptor;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import sernanp.rrhh.service.PersonalService;
import sernanp.rrhh.util.Funciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PersonalEliminaLicenciasVacacionesInterceptor implements Interceptor{

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

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		HttpServletRequest request	= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		Date fechInicio				= null;
		Date fechFin				= null;
		int idP						= 0;	
		int anioDescuentofi			= 0;		
		int mesDescuentofi			= 0;
		int anioDescuentoff			= 0;
		int mesDescuentoff			= 0;
		int descCerrado				= 0;
		int regcontractual			= 0;
		int ubicacion				= 0;
		String  [] strExplode		= null;
		String strReturn			= null;
	
		
	
		
		try {
			
			if(request.getAttribute("f_inicioLic") != null && request.getAttribute("f_finLic") != null){
				
				fechInicio		= (Date) request.getAttribute("f_inicioLic");
				fechFin			= (Date) request.getAttribute("f_finLic");
				idP				= Integer.valueOf(request.getParameter("idPersonal"));
				regcontractual	= (Integer) request.getAttribute("idregimenContractual");
				ubicacion		= (Integer) request.getAttribute("ubicacionPersonal");
				
//				System.out.println("---------------------Interceptor Eliminar Licencias -------------------");
//				System.out.println("idP : " + idP + ", Fecha Inico : " + fechInicio+", Fecha Fin : " + fechFin);
				
				
				strExplode = Funciones.explodeString(fechInicio.toString(), "-");					
				anioDescuentofi 	= Integer.valueOf(strExplode[0]);
				mesDescuentofi	= Integer.valueOf(strExplode[1]);
				
				strExplode = Funciones.explodeString(fechFin.toString(), "-");					
				anioDescuentoff 	= Integer.valueOf(strExplode[0]);
				mesDescuentoff	= Integer.valueOf(strExplode[1]);
				
				if(mesDescuentofi == mesDescuentoff && anioDescuentofi == anioDescuentoff){
					descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentofi, mesDescuentofi, ubicacion, 0,regcontractual);
				}else if(mesDescuentofi != mesDescuentoff){
					descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentofi, mesDescuentofi, ubicacion,0, regcontractual);
					if(descCerrado == 0){
						descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentoff, mesDescuentoff, ubicacion,0, regcontractual);
					}
				}
				
				if(descCerrado > 0){
					ServletActionContext.getRequest().setAttribute("msg","Licencia (F. Inicio y/o F. Fín) está en un periodo de Descuentos Cerrado.");
					strReturn = "eliminarPeriodoDescuentoCerrado";
					return strReturn;
				}

				
			}else if(request.getAttribute("f_inicioVac") != null && request.getAttribute("f_finVac") != null){
				
				fechInicio		= (Date) request.getAttribute("f_inicioVac");
				fechFin			= (Date) request.getAttribute("f_finVac");
				idP				= Integer.valueOf(request.getParameter("idPersonal"));
				regcontractual	= (Integer) request.getAttribute("idregimenContractual");
				ubicacion		= (Integer) request.getAttribute("ubicacionPersonal");
				
//				System.out.println("---------------------Interceptor Eliminar Vacaciones -------------------");
//				System.out.println("idP : " + idP + ", Fecha Inico : " + fechInicio+", Fecha Fin : " + fechFin);
				
				
				strExplode = Funciones.explodeString(fechInicio.toString(), "-");					
				anioDescuentofi 	= Integer.valueOf(strExplode[0]);
				mesDescuentofi	= Integer.valueOf(strExplode[1]);
				
				strExplode = Funciones.explodeString(fechFin.toString(), "-");					
				anioDescuentoff 	= Integer.valueOf(strExplode[0]);
				mesDescuentoff	= Integer.valueOf(strExplode[1]);
				
				
				if(mesDescuentofi == mesDescuentoff && anioDescuentofi == anioDescuentoff){
					descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentofi, mesDescuentofi, ubicacion, 0,regcontractual);
				}else if(mesDescuentofi != mesDescuentoff){
					descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentofi, mesDescuentofi, ubicacion, 0,regcontractual);
					if(descCerrado == 0){
						descCerrado = personalService.contardescuentosvalidadosxperiodo(anioDescuentoff, mesDescuentoff, ubicacion, 0,regcontractual);
					}
				}
				
				if(descCerrado > 0){
					ServletActionContext.getRequest().setAttribute("msg","Vacaciones (F. Inicio y/o F. Fín) está en un periodo de Descuentos Cerrado.");
					strReturn = "eliminarPeriodoDescuentoCerrado";
					return strReturn;
				}
				
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return arg0.invoke();
	}


	public void setPersonalService(PersonalService personalService) {
		this.personalService = personalService;
	}
	
	
	

}
