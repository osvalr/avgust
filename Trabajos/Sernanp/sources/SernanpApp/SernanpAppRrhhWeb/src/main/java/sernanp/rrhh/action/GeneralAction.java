package sernanp.rrhh.action;


import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

 

public class GeneralAction extends ActionSupport{

	  
	private static final long serialVersionUID = 1L;
    private Map<String,Object> datos;
   
    public GeneralAction(){
    	datos=new HashMap<String, Object>();
    	
    }
 
}