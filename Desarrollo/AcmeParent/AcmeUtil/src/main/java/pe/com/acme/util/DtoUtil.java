package pe.com.acme.util;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class DtoUtil {

	private static Logger log = Logger.getLogger(DtoUtil.class);
	
	public DtoUtil getInstance(){
		return new DtoUtil();
	}
	
	static{
		DateTimeConverter dtConverter = new DateConverter();
		dtConverter.setPattern("dd/MM/yyyy");
		ConvertUtils.register(dtConverter, Date.class);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  <T> List<T> copyBean(List list,Class classDest,boolean upperCase){
		List<T> rlist = new ArrayList<T>();
		for(Object obj : list){
			rlist.add((T) copyBean(obj, classDest,upperCase));
		}
		return rlist;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  <T> List<T> copyBean(List list,Class classDest){
		List<T> rlist = new ArrayList<T>();
		for(Object obj : list){
			rlist.add((T) copyBean(obj, classDest,false));
		}
		return rlist;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  <T> List<T> copyBean(List list,Object objOutput,boolean upperCase){
		List<T> rlist = new ArrayList<T>();
		for(Object obj : list){
			rlist.add((T) copyBean(obj, objOutput,upperCase));
		}
		return rlist;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  <T> List<T> copyBean(List list,Object objOutput){
		List<T> rlist = new ArrayList<T>();
		for(Object obj : list){
			rlist.add((T) copyBean(obj, objOutput,false));
		}
		return rlist;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  <T> T copyBean(Object objInput,Class classDest){
		return (T) copyBean(objInput, classDest,false);
	}
	
	@SuppressWarnings({ "unchecked" })
	public  <T> T copyBean(Object objInput,Object objOutput){
		return (T) copyBean(objInput, objOutput,false);
	}
	
	@SuppressWarnings({ "unchecked" })
	private  <T> T copyBean(Object objOrig,Object objDest,boolean upperCase){


			try {
				
				this.tuneUp(objOrig, upperCase);

				/////
				Map<String, Object> mapProperties = PropertyUtils.describe(objOrig);
				Map<String, Object> mapPropertiesTarget = PropertyUtils.describe(objDest);
				
				for (Map.Entry<String, Object> entry : mapProperties.entrySet())
				{

					String nameProperty = entry.getKey();
					String namePropertyInitial = nameProperty;

					nameProperty = nameProperty.replace("_","");
					nameProperty = nameProperty.toLowerCase();
					
					if(!nameProperty.equals("class")){
						
						Object valueProperty = null;

						if(entry.getValue() != null){

							valueProperty = entry.getValue();

							for (Map.Entry<String, Object> entryTarget : mapPropertiesTarget.entrySet())
							{
								String namePropertyTarget = entryTarget.getKey();
								String namePropertyTargetInitial = namePropertyTarget;
								namePropertyTarget = namePropertyTarget.replace("_","");
								namePropertyTarget = namePropertyTarget.toLowerCase();

								if(nameProperty.equals(namePropertyTarget)){
									try {
										PropertyUtils.setProperty(objDest, namePropertyInitial, valueProperty);
									}catch (Exception e){
										PropertyUtils.setProperty(objDest, namePropertyTargetInitial, valueProperty);
										//log.error(e.getMessage(),e);
									}
								}
							}

						}
						
					}
					
				}
				/////
				//BeanUtils.copyProperties(objDest, objOrig);
				
				return (T) objDest;
				
			} catch (IllegalAccessException e) {
				log.error(e.getMessage(),e);
			} catch (InvocationTargetException e) {
				log.error(e.getMessage(),e);
			} catch (NoSuchMethodException e) {
				log.error(e.getMessage(),e);
				e.printStackTrace();
			}


		return null;
	}
	
	@SuppressWarnings({ "unchecked" })
	private  <T> T copyBean(Map<String,Object> mapInput,Object objDest,boolean upperCase){


			try {
				
				this.tuneUp(mapInput, upperCase);

				/////
				Map<String, Object> mapProperties = mapInput;
				Map<String, Object> mapPropertiesTarget = PropertyUtils.describe(objDest);

				for (Map.Entry<String, Object> entry : mapProperties.entrySet())
				{

					String nameProperty = entry.getKey();
					String namePropertyInitial = nameProperty;
					nameProperty = nameProperty.replace("_","");
					nameProperty = nameProperty.toLowerCase();
					
					if(!nameProperty.equals("class")){
						
						Object valueProperty = null;

						if(entry.getValue() != null){

							valueProperty = entry.getValue();

							for (Map.Entry<String, Object> entryTarget : mapPropertiesTarget.entrySet())
							{
								String namePropertyTarget = entryTarget.getKey();
								String namePropertyTargetInitial = namePropertyTarget;
								namePropertyTarget = namePropertyTarget.replace("_","");
								namePropertyTarget = namePropertyTarget.toLowerCase();

								if(nameProperty.equals(namePropertyTarget)){

									try {
										PropertyUtils.setProperty(objDest, namePropertyInitial, valueProperty);
									}catch (Exception e){
										PropertyUtils.setProperty(objDest, namePropertyTargetInitial, valueProperty);
										//log.error(e.getMessage(),e);
									}

								}
							}

						}
						
					}
					
				}
				/////

				//BeanUtils.copyProperties(objDest, mapInput);
				
				return (T) objDest;
				
			} catch (IllegalAccessException e) {
				log.error(e.getMessage(),e);
			} catch (InvocationTargetException e) {
				log.error(e.getMessage(),e);
			} catch (NoSuchMethodException e) {
				log.error(e.getMessage(),e);
			}


		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private  <T> T copyBean(Object objOrig,Class classDest,boolean upperCase){
		
		try {
			
			T objDest = null;
			Constructor ctor;
			
			ctor = classDest.getConstructor();
			objDest = (T) ctor.newInstance();
			
			objDest = this.copyBean(objOrig, objDest, upperCase);
			
			return objDest;
			
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage(),e);
		} catch (SecurityException e) {
			log.error(e.getMessage(),e);
		} catch (InstantiationException e) {
			log.error(e.getMessage(),e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(),e);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(),e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(),e);
		}
		
		
		return null;
		
	}
	
	@SuppressWarnings("rawtypes")
	public  <T> T copyBean(Map<String,Object> mapInput,Class classDest){
		return this.copyBean(mapInput, classDest,false);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private  <T> T copyBean(Map<String,Object> mapInput,Class classDest, boolean upperCase){
		try {
			
			T objDest = null;
			Constructor ctor;
			
			ctor = classDest.getConstructor();
			objDest = (T) ctor.newInstance();
			
			objDest = this.copyBean(mapInput, objDest, upperCase);
			
			return objDest;
			
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage(),e);
		} catch (SecurityException e) {
			log.error(e.getMessage(),e);
		} catch (InstantiationException e) {
			log.error(e.getMessage(),e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(),e);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(),e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(),e);
		}
		
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public void tuneUp(Object objOrig, boolean upperCase){
		try {
		
			Map<String, Object> mapProperties = PropertyUtils.describe(objOrig);
	
			for (Map.Entry<String, Object> entry : mapProperties.entrySet())
			{
	
				String nameProperty = entry.getKey();
			    String valueProperty = null;
			    			    
				Class clazz = PropertyUtils.getPropertyType(objOrig, nameProperty);
				    
				if(clazz == String.class){
					
				    if(entry.getValue() != null){
				    	
				    	valueProperty = entry.getValue().toString().trim();
				    	
				    	if(!valueProperty.equals("")){
				    		if(upperCase){
					    		valueProperty = valueProperty.toUpperCase();
					    	}
				    	}else{
				    		valueProperty = null;
				    	}
				    	
				    }
					
					PropertyUtils.setProperty(objOrig, nameProperty, valueProperty);
				}
		    
			}
		
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(),e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(),e);
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public void tuneUp(Map<String,Object> mapInput, boolean upperCase){
		
		for (Map.Entry<String, Object> entry : mapInput.entrySet()) {

			String nameProperty = entry.getKey();
			String valueProperty = null;
			
			if(entry.getValue() != null){
				if (entry.getValue().getClass() == String.class) {
					
					if (entry.getValue() != null) {

						valueProperty = entry.getValue().toString().trim();

						if (!valueProperty.equals("")) {
							if (upperCase) {
								valueProperty = valueProperty.toUpperCase();
							}
						} else {
							valueProperty = null;
						}

					}
					
					mapInput.put(nameProperty, valueProperty);
				}
			}

		}
		
	}

	public String capitalize(String str){
		String result = WordUtils.capitalizeFully(str, new char[]{'_'}).replaceAll("_", "");
		result = result.substring(0, 1).toLowerCase() + result.substring(1);
		return result;
	}
}
