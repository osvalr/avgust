package proyecto.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionContext;

public final class ProjectUtils {
	
	public static String explode(List<?> list){
		return list.toString().replaceAll("(\\[)(.+)(\\])", "$2").replace(" ", "");
	}
	
	public static HashMap<String,Object> parseActionRequest(ActionContext actionContext){
		
		Map<String,Object> parameters = actionContext.getParameters();
		HashMap<String,Object> map =new HashMap<String,Object>();
		
	    //more elegant way
        for (Entry<String, Object> entry : parameters.entrySet()) {
        	
        	String [] value = ((String[])entry.getValue() );
        	map.put(entry.getKey(), ( value.length == 1)? value[0]: value );  
        }  
         
		return map; 
	}
}
