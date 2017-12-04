package pe.com.acme.ankermu.ws.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.acme.ankermu.ws.bean.OperationBean;
import pe.com.acme.muanker.business.service.AutenticacionService;

@Controller
@RequestMapping("/Autenticacion")
public class AutenticacionController {

    private static Logger log = Logger.getLogger(AutenticacionController.class);

	@Autowired
	private AutenticacionService autenticacionService;
	
	@RequestMapping(value="/logIn")
	public @ResponseBody OperationBean logIn(@RequestParam String AccountID, @RequestParam String password, HttpSession session) {
		
		OperationBean operationBean;
		operationBean = new OperationBean();
		
		try{
			
			boolean login = autenticacionService.logIn(AccountID, password);
			
			if(login){
				operationBean.setStatusLogin(true);
				session.setAttribute("AccountID",AccountID);
			}else{
				operationBean.setMessage("AccountID Or Password incorrect.");
			}

			return operationBean;
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            operationBean.setSuccess(false);
            operationBean.setMessage(e.getMessage());
            return operationBean;
		}
	}
	
	@RequestMapping(value="/logOut")
	public @ResponseBody String logOut(HttpSession session) {
		try{
			
			session.setAttribute("AccountID",null);
			
			return "{success:"+ true +"}";
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return "{success:false}";
		}
	}
	
}
