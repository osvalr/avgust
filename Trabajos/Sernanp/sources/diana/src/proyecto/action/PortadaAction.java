package proyecto.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import proyecto.vo.Usuario;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PortadaAction extends ActionSupport{

	private String log;
	private int idmodulo;
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute()  {
		setLog(JSONArray.fromObject(ServletActionContext.getRequest().getSession()).toString());
    	
    	
    	ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		
 		//session.put("Depende","0");
		//session.put("Nivel", "1") ;
    	  
        return SUCCESS;  
    }

	
	
	public String ingresarModulo(){
		
		
		
		
		return "inicioturismo";
	}
	
	public void setLog(String log) {
		this.log = log;
	}

	public String getLog() {
		return log;
	}



	public int getIdmodulo() {
		return idmodulo;
	}



	public void setIdmodulo(int idmodulo) {
		this.idmodulo = idmodulo;
	}
	
	
	
	
	
}
