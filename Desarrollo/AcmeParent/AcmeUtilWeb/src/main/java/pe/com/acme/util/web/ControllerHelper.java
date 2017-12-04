package pe.com.acme.util.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import pe.com.acme.util.AbstractModel;
import pe.com.acme.util.DtoUtil;
import pe.com.acme.util.SortExtJs;

public abstract class ControllerHelper {
	
	@Autowired
	DtoUtil dto;
	
	public Map<String, Object> getParamMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("order_column", "1");
		map.put("order_direction", "ASC");
		return map;
	}
	
	public Map<String, Object> loadParamMap(HttpServletRequest request) {
		
		Map<String, Object> map = this.getParamMap();

		for (Entry<String, String[]> entry : request.getParameterMap().entrySet())
		{
			
        	if(entry.getKey().equals("sort")){
        		Gson gson = new Gson();
        		List<SortExtJs> listSortExtjs = gson.fromJson(entry.getValue()[0], new TypeToken<List<SortExtJs>>() {}.getType());
        		SortExtJs sortExtjs = listSortExtjs.get(0);
        		map.put("order_column", sortExtjs.getProperty());
        		map.put("order_direction", sortExtjs.getDirection());
        	}else{
        		map.put(entry.getKey(), (entry.getValue()[0].equals("") ? null : entry.getValue()[0]));
        	}
						  
		}

		return map;
	}
	
	@SuppressWarnings("rawtypes")
	public <T> T loadCriteria(HttpServletRequest request, Class classEnt){
		Map<String, Object> mapInput = this.loadParamMap(request);
		return dto.copyBean(mapInput, classEnt);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getValue(String val){
		if(this.isInteger(val)){
			return (T) new Integer(Integer.parseInt(val));
		}else if(this.isDouble(val)){
			return (T) new Double(Double.parseDouble(val));
		}else{
			return (T) val;
		}
	}
	
	public boolean isInteger(String val){
		try {
			Integer.parseInt(val);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isDouble(String val){
		try {
			Double.parseDouble(val);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Integer getIdRandom(){
		return ((int)(100 * Math.random()) * (int)(100 * Math.random()));
	}
	
	public Integer getNegativeIdRandom(){
		return (((int)(100 * Math.random()) * (int)(100 * Math.random())) * -1);
	}
	
	public List<? extends AbstractModel> getSubList(List<? extends AbstractModel> list, int start, int limit){
		
		List<AbstractModel> subList = null;
		List<AbstractModel> listWithoutRemoved = new ArrayList<>();
		
		for (AbstractModel abstractModel : list) {
			if(!abstractModel.isRemovedRecord()){
				listWithoutRemoved.add(abstractModel);	
			}
		}
		
		try {
			subList = listWithoutRemoved.subList(start, (start + limit));
		} catch (IndexOutOfBoundsException e) {
			subList = listWithoutRemoved.subList(start, listWithoutRemoved.size());
		}
		return subList;
	}
	
	public <T> List<T> getSimpleSubList(List<T> list, int start, int limit){
		
		List<T> subList = null;
		List<T> listWithoutRemoved = new ArrayList<T>();
		
		for (T t : list) {
				listWithoutRemoved.add(t);
		}
		
		try {
			subList = listWithoutRemoved.subList(start, (start + limit));
		} catch (IndexOutOfBoundsException e) {
			subList = listWithoutRemoved.subList(start, listWithoutRemoved.size());
		}
		return subList;
	}
	
	public AbstractModel find(List<? extends AbstractModel> list, AbstractModel model){
		for (AbstractModel abstractModel : list) {
			if(abstractModel.getRownum().intValue() ==  model.getRownum().intValue()){
				return abstractModel;
			}
		}
		return null;
	}
	public void setRandomId(List<? extends AbstractModel> list){
		for (AbstractModel abstractModel : list) {
			abstractModel.setRownum(this.getIdRandom());
		}
	}
}
