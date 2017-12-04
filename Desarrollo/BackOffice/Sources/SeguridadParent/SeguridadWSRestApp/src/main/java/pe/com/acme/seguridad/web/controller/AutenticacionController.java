package pe.com.acme.seguridad.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.acme.seguridad.business.dto.SessionStatusDto;
import pe.com.acme.seguridad.business.service.AutenticacionService;

@Controller
@RequestMapping("/Autenticacion")
public class AutenticacionController {

    private static Logger log = Logger.getLogger(AutenticacionController.class);

	@Autowired
	private AutenticacionService autenticacionService;
	
	@RequestMapping(value="/logIn")
	public @ResponseBody SessionStatusDto logIn(@RequestParam String nombre_usuario, @RequestParam String clave_usuario, HttpServletRequest request) {
		
		SessionStatusDto sessionStatusDto;
		
		try{
			
			String userAgent = request.getHeader("User-Agent");
			String ipAddress = request.getHeader("X-FORWARDED-FOR");  
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			
			sessionStatusDto = autenticacionService.logIn(nombre_usuario, clave_usuario, userAgent, ipAddress);

			return sessionStatusDto;
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            sessionStatusDto = new SessionStatusDto();
            return sessionStatusDto;
		}
	}
	
	@RequestMapping(value="/logOut")
	public @ResponseBody String logOut(@RequestParam String id_session, HttpServletRequest request) {
		try{
			
			String userAgent = request.getHeader("User-Agent");
			String ipAddress = request.getHeader("X-FORWARDED-FOR");  
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			
			boolean status = autenticacionService.logOut(id_session, userAgent, ipAddress);
			
			return "{success:"+ status +"}";
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return "{success:false}";
		}
	}
	
	@RequestMapping(value="/setData")
	public @ResponseBody String setData(@RequestParam String id_session,@RequestParam Integer id_aplicacion, @RequestParam Integer id_rol, HttpServletRequest request) {
		try{
			
			String userAgent = request.getHeader("User-Agent");
			String ipAddress = request.getHeader("X-FORWARDED-FOR");  
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			
			boolean status = autenticacionService.setData(id_session, userAgent, ipAddress, id_aplicacion, id_rol);
			
			return "{success:"+ status +"}";
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            return "{success:false}";
		}
	}
	
	@RequestMapping(value="/checkLogIn")
	public @ResponseBody String checkLogIn(@RequestParam String id_session, HttpServletRequest request) {
		try{
			
			String userAgent = request.getHeader("User-Agent");
			String ipAddress = request.getHeader("X-FORWARDED-FOR");  
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			
			boolean status = autenticacionService.checkLogIn(id_session, userAgent, ipAddress);
						
			return "{success:"+ status +"}";
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            return "{success:false}";
		}
	}
	
}
