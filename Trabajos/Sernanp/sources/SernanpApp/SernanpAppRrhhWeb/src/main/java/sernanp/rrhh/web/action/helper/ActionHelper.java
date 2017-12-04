package sernanp.rrhh.web.action.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sernanp.app.util.TransaccionUtil;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;


public abstract class ActionHelper extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public static final String JSON = "json";
	public static final String PDF = "pdf";
	public static final String EMPTY = "";
	
	private SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
	public TransaccionUtil transaccionUtil = new TransaccionUtil();
	
	public HttpSession getSessionContext(boolean flag){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(flag);
		return session;
	}
	
	public HttpSession getSessionContext(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		return session;
	}
	
	public String toJson(Object obj){
		Gson json = new Gson();
		return json.toJson(obj);
	}
	
	public Date toDateFormat(String dateString) {
		
		Date dateReturn = null;
		
		if(dateString == null){
			return dateReturn;
		}
		
		try {
			
			if(dateString.equals("")){
				dateReturn=null;
			}else{
				dateString = dateString.replaceAll("/", "-");
				Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
				String dateString2 = new SimpleDateFormat("yyyy-MM-dd").format(date);
				dateReturn = simpleFormat.parse(dateString2);
			}
			
			return dateReturn;
			
		} catch (ParseException e) {
			
			return dateReturn;
			
		}

	}
	
	public String dateToString(Date date) {
		
		String dateReturn = null;
		
		if(date == null){
			return dateReturn;
		}
		
		dateReturn = new SimpleDateFormat("dd/MM/yyyy").format(date);
				
		return dateReturn;
			
	}
	
	public String formatSecuencia(String secuencia,Integer numeroCeros){
		
		String r = null;
		
		if(secuencia != null && !secuencia.equals("")){
			Formatter fmt = new Formatter();
			fmt.format("%0"+numeroCeros.toString()+"d",Integer.parseInt(secuencia));
			r = fmt.toString();
			fmt.close();
		}

		return r;
		
	}
	
	public Integer getIntegerParameter(String nameParam){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer val = null;
		try {
			val = Integer.parseInt(request.getParameter(nameParam));
		} catch (Exception e) {
		}
		return val;
	}
	
	public String getParameter(String nameParam){
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getParameter(nameParam);
	}
	
	public abstract TransaccionUtil getTransaccionUtil();		
}
