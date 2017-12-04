package sernanp.rrhh.interceptor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class GeneralInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
		//System.out.println("destroy()");
	}

	public void init() { 
		
		//System.out.println("init()");
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ctx = ActionContext.getContext();
		addUrlApplication();
//		System.out.println("GeneralInterceptor : intercept");
		return arg0.invoke();

	}
	
	
	public void addUrlApplication(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Map<String,Object> mapApp =ServletActionContext.getContext().getApplication();
		try {
			URL u = new URL(request.getRequestURL().toString());
			String url=u.getProtocol()+"://"+request.getHeader("Host")+request.getContextPath()+"/";
//	        System.out.println("url:"+url);  
			mapApp.put("url",url );
			//System.out.println( "BROWSER: "+  request.getHeader("User-Agent") );
	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}
	
}
