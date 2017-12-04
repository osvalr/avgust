package proyecto.action;

import org.springframework.beans.factory.annotation.Autowired;

import proyecto.service.AdministracionAreanaturalService;
import proyecto.service.HistoricoAreanaturalService;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;

public class AnpAction extends ActionSupport {
	/**
	 *     
	 */    
	private static final long serialVersionUID = 1L;
	@Autowired   
	private HistoricoAreanaturalService historicoAreanaturalService;
	@Autowired
	private AdministracionAreanaturalService administracionAreanaturalService;
	private String json,list;   
	
	public String listar(){           
		list = (JSONArray.fromObject(                   
				administracionAreanaturalService.listar()        
					).toString());                    
		System.out.println("Administracion TOTAL:" + getList());  
		/*
		 */  
		json = (JSONArray.fromObject(   
				historicoAreanaturalService.listar()        
					).toString());   
		System.out.println("HISTORICO TOTAL:" + json);     
		//System.out.println("HISTORICO RAW"+ historicoAreanaturalService.listar().g  );
		return SUCCESS;  
		  
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getJson() {
		return json;
	}
	public void setList(String list) {
		this.list = list;
	}
	public String getList() {
		return list;
	}
}
