package proyecto.action;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import proyecto.vo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

 

public class GeneralAction extends ActionSupport{

	  
	private static final long serialVersionUID = 1L;
    private Map<String,Object> datos;
   
    public GeneralAction(){
    	datos=new HashMap<String, Object>();
    	
    }
    
    public String execute(){
    	return SUCCESS;
    }
 
}