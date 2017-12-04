package sernanp.rrhh.web.action.helper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.SortExtJs;


public abstract class ActionHelperExtjs extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	BeanUtil beanUtil;
	
	public static final String JSON = "json";
	public static final String PDF = "pdf";
	public static final String EMPTY = "";

	protected ExtJsStrutsUtil extjsReturn = new ExtJsStrutsUtil();
	
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
	
	public HttpServletRequest getHttpRequest(){
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}
	
	public Integer getIntegerParameter(String nameParam){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer val = null;
		try {
			val = Integer.parseInt(request.getParameter(nameParam));
		} catch (NullPointerException e) {
			
		}catch (NumberFormatException e) {
			
		}
		return val;
	}
	
	public String getParameter(String nameParam){
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getParameter(nameParam);
	}
	
	public Map<String, Object> getParamMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderColumn", "1");
		map.put("orderDirecction", "ASC");
		return map;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> loadParamMap(HttpServletRequest request) {
		
		Map<String, Object> map = this.getParamMap();

		Map<String, String[]> mapRequest = request.getParameterMap();
		Set set = mapRequest.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
        	
        	Map.Entry<String, String[]> entry = (Entry<String, String[]>) it.next();
        	String paramName = entry.getKey();
        	String[] paramValues = entry.getValue();
        	        	
        	paramValues[0] = this.replaceChataracter(paramValues[0]);
        	
     
        	if(paramName.equals("sort")){
        		Gson gson = new Gson();
        		List<SortExtJs> listSortExtjs = gson.fromJson(paramValues[0], new TypeToken<List<SortExtJs>>() {}.getType());
        		SortExtJs sortExtjs = listSortExtjs.get(0);
        		map.put("orderColumn", sortExtjs.getProperty());
        		map.put("orderDirecction", sortExtjs.getDirection());
        	}
        	
			map.put(paramName, (paramValues[0].equals("") ? null : paramValues[0]));
        	
        }
	
		return map;
	}
	
	@SuppressWarnings("rawtypes")
	public <T> T loadCriteria(HttpServletRequest request, Class classEnt){
		Map<String, Object> mapInput = this.loadParamMap(request);
		return beanUtil.copyBean(mapInput, classEnt);
	}
	
	public <T> void success(List<T> list, int size){
		
		extjsReturn.setTotal(size);
		extjsReturn.setData(list);
		extjsReturn.setSuccess(true);

	}
	
	public <T> void success(){
		
		extjsReturn.setSuccess(true);

	}
	
	@SuppressWarnings("unchecked")
	public <T> void success(T obj, String msg){
				
		extjsReturn.setTotal(1);
		extjsReturn.getData().add(obj);
		extjsReturn.setMessage(msg);
		extjsReturn.setSuccess(true);
		
	}
	
	public void exception(String msg){

		extjsReturn.setMessage(msg);
		extjsReturn.setSuccess(false);

	}
	
	public Integer getIdRandom(){
		return ((int)(100 * Math.random()) * (int)(100 * Math.random()));
	}
	
	public Integer getNegativeIdRandom(){
		return (((int)(100 * Math.random()) * (int)(100 * Math.random())) * -1);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> List<T> getSubList(List list, int start, int limit){
		
		List<T> subList = null;
		
		try {
			subList = list.subList(start, (start + limit));
		} catch (IndexOutOfBoundsException e) {
			subList = list.subList(start, list.size());
		}
		return subList;
	}
	
	public String replaceChataracter(String entrada) {

		if (entrada.contains("Ã©"))
			entrada = entrada.replaceAll("Ã©", "é");
		else if (entrada.contains("Ã³"))
			entrada = entrada.replaceAll("Ã³", "ó");
		else if (entrada.contains("Ãº"))
			entrada = entrada.replaceAll("Ãº", "ú");
		else if (entrada.contains("Ã¡"))
			entrada = entrada.replaceAll("Ã¡", "á");
		else if (entrada.contains("Ã±"))
			entrada = entrada.replaceAll("Ã±", "ñ");
		else if (entrada.contains("Ã"))
			entrada = entrada.replaceAll("Ã", "í");

		return entrada;
	}

	public abstract ExtJsStrutsUtil getExtjsReturn();

}