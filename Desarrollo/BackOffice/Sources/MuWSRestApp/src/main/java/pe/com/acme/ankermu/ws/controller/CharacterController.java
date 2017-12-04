package pe.com.acme.ankermu.ws.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.acme.ankermu.ws.bean.OperationBean;
import pe.com.acme.muanker.business.service.CharacterService;
import pe.com.acme.query.mybatis.model.CharacterQuery;
import pe.com.acme.util.JsonReturnUtil;

@Controller
@RequestMapping("/Character")
public class CharacterController {

	private static Logger log = Logger.getLogger(CharacterController.class);
	
	@Autowired
	private CharacterService characterService;
	
	@RequestMapping(value="list")
	public @ResponseBody Map<String,? extends Object> list(HttpSession session) {
		
		try{
			String AccountID = (String) session.getAttribute("AccountID");
            List<CharacterQuery> list = characterService.charactersByAccountId(AccountID);
			return JsonReturnUtil.success(list,list.size());
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="/reset")
	public @ResponseBody OperationBean reset(@RequestParam String NameCharacter, HttpSession session) {
		
		OperationBean operationBean;
		operationBean = new OperationBean();
		try{

			String AccountID = (String) session.getAttribute("AccountID");
			characterService.resetCharacter(AccountID, NameCharacter);
			
			return operationBean;
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            
            operationBean.setSuccess(false);
            operationBean.setMessage(e.getMessage());
            return operationBean;
		}
	}
	
	@RequestMapping(value="/addPoints")
	public @ResponseBody OperationBean addPoints(@RequestParam String name, @RequestParam Integer str, @RequestParam Integer vit,  @RequestParam Integer ene,  @RequestParam Integer dex, HttpSession session) {
		
		OperationBean operationBean;
		operationBean = new OperationBean();
		try{

			String AccountID = (String) session.getAttribute("AccountID");
			characterService.addPoints(AccountID, name, str, vit, ene, dex);
			
			return operationBean;
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            
            operationBean.setSuccess(false);
            operationBean.setMessage(e.getMessage());
            return operationBean;
		}
	}
	
	@RequestMapping(value="/pkClear")
	public @ResponseBody OperationBean pkClear(@RequestParam String NameCharacter, HttpSession session) {
		
		OperationBean operationBean;
		operationBean = new OperationBean();
		try{

			String AccountID = (String) session.getAttribute("AccountID");
			characterService.pkClear(AccountID, NameCharacter);
			
			return operationBean;
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            
            operationBean.setSuccess(false);
            operationBean.setMessage(e.getMessage());
            return operationBean;
		}
	}
}
