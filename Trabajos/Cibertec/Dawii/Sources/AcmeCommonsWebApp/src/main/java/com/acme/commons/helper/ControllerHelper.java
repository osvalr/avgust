package com.acme.commons.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.acme.util.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;

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
			if(entry.getKey().equals("order_column")){
				if(!entry.getValue()[0].equals("")){
					map.put(entry.getKey(), entry.getValue()[0]);
				}	
			}else if(entry.getKey().equals("order_direction")){
				if(!entry.getValue()[0].equals("")){
					map.put(entry.getKey(), entry.getValue()[0]);
				}	
			}else{
//				map.put(entry.getKey(), (entry.getValue()[0].equals("") ? null : this.getValue(entry.getValue()[0])));
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
}
