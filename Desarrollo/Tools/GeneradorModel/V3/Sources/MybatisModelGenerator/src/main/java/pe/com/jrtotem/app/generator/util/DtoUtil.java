package pe.com.jrtotem.app.generator.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Component
public class DtoUtil {

	private String formatSend;
	private String FORMAT_DEFAULT = "dd-MM-yyyy";
	
	public DtoUtil getInstance(){
		return new DtoUtil();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  <T> List<T> copyBean(List list,Class classEnt,boolean upperCase){
		List<T> rlist = new ArrayList<T>();
		for(Object obj : list){
			rlist.add((T) copyBean(obj, classEnt, null,upperCase));
		}
		return rlist;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  <T> List<T> copyBean(List list,Class classEnt){
		List<T> rlist = new ArrayList<T>();
		for(Object obj : list){
			rlist.add((T) copyBean(obj, classEnt, null,false));
		}
		return rlist;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  <T> List<T> copyBean(List list,Object objOutput,boolean upperCase){
		List<T> rlist = new ArrayList<T>();
		for(Object obj : list){
			rlist.add((T) copyBean(obj, null, objOutput,upperCase));
		}
		return rlist;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  <T> List<T> copyBean(List list,Object objOutput){
		List<T> rlist = new ArrayList<T>();
		for(Object obj : list){
			rlist.add((T) copyBean(obj, null, objOutput,false));
		}
		return rlist;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  <T> T copyBean(Object objInput,Class classEnt){
		return (T) copyBean(objInput, classEnt, null,false);
	}
	
	@SuppressWarnings({ "unchecked" })
	public  <T> T copyBean(Object objInput,Object objOutput){
		return (T) copyBean(objInput, null, objOutput,false);
	}
	
	@SuppressWarnings({ "unchecked" })
	public  <T> T copyBean(Object objInput,Object objOutput,boolean upperCase){
		return (T) copyBean(objInput, null, objOutput,upperCase);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private  <T> T copyBean(Object objInput,Class classEnt, Object objOutput,boolean upperCase){
	    
		Class  classDto = objInput.getClass();
		Method  methodsDto[] = classDto.getMethods();
		Method  methodsEnt[] = null;
		T objEnt = null;
		Constructor ctor;
		try {
			
			if(objOutput == null){
				ctor = classEnt.getConstructor();
				objEnt = (T) ctor.newInstance();
			}else{
				classEnt = objOutput.getClass();
				objEnt = (T) objOutput;
			}
				
			methodsEnt = classEnt.getMethods();
			
			List<MethodInfoUtil> methodInfo = new ArrayList<MethodInfoUtil>();
			
			for(Method m : methodsDto){
						
				String tipoMetodo = m.getName().substring(0, 3);
				
				if(tipoMetodo.equals("get") && !m.getName().equals("getClass")){
					
					Class cArgs[] = m.getParameterTypes();
					Method mtd = classDto.getMethod(m.getName(),cArgs);
					Object val = mtd.invoke(objInput);
					
					MethodInfoUtil mf = new MethodInfoUtil();
					mf.setNomMethod("set"+m.getName().substring(3, m.getName().length()));
					mf.setTypeDataMethod(m.getReturnType());
					mf.setValueMethod(val);
					
					methodInfo.add(mf);
				}

			}
			
			for(MethodInfoUtil mf : methodInfo){
				for(Method m : methodsEnt){
									
					if(mf.getNomMethod().equals(m.getName())){
						
						Class cArgs[] = m.getParameterTypes();
						Object oParams[] = new Object[1];
												
						if(cArgs[0].getName().equals(Integer.class.getName()) || cArgs[0].getName().equals("int")){
							
							Object val = (mf.getValueMethod()!=null) ? Integer.parseInt((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Double.class.getName()) || cArgs[0].getName().equals("double")){
							
							Object val = (mf.getValueMethod()!=null) ? Double.parseDouble((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(BigDecimal.class.getName())){
							
							Object val = (mf.getValueMethod()!=null) ? new BigDecimal(Double.parseDouble((mf.getValueMethod()).toString())) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(BigInteger.class.getName())){
							
							Object val = (mf.getValueMethod()!=null) ? new BigInteger((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Long.class.getName()) || cArgs[0].getName().equals("long")){
							
							Object val = (mf.getValueMethod()!=null) ? Long.parseLong((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Short.class.getName()) || cArgs[0].getName().equals("short")){
							
							Object val = (mf.getValueMethod()!=null) ? Short.parseShort((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Byte.class.getName()) || cArgs[0].getName().equals("byte")){
							
							Object val = (mf.getValueMethod()!=null) ? Byte.parseByte((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Float.class.getName()) || cArgs[0].getName().equals("float")){
							
							Object val = (mf.getValueMethod()!=null) ? Float.parseFloat((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Boolean.class.getName()) || cArgs[0].getName().equals("boolean")){
							
							Object val = (mf.getValueMethod()!=null) ? Boolean.parseBoolean((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(String.class.getName())){
							
							String v = null;
							if(this.formatSend == null){
								this.formatSend = this.FORMAT_DEFAULT;
							}
							if(mf.getValueMethod() != null){
								Object val = mf.getValueMethod();
								if(val instanceof Date){
									Date d = (Date) val;
									v = this.dateToString(d);
								} else  if(val instanceof Timestamp){
									Timestamp ts = (Timestamp) val;
									v = this.timeStamptoString(ts);
								}else{
									v = val.toString();
								}
							}
							
							if(upperCase){
								oParams[0] = (v!=null) ? v.toString().trim().toUpperCase() : null;	
							}else{
								oParams[0] = (v!=null) ? v.toString().trim() : null;
							}
						}
						
						if(cArgs[0].getName().equals(Date.class.getName())){
						
							Date date=null;
							if(this.formatSend == null){
								this.formatSend = this.FORMAT_DEFAULT;
							}

							if(mf.getValueMethod() != null){
									Object val = mf.getValueMethod();
									date = this.stringToDate(val.toString());
							}
							
							oParams[0] = (mf.getValueMethod()!=null) ? date : null;
							
						}
						
						if(cArgs[0].getName().equals(Timestamp.class.getName())){
							
							Timestamp ts=null;
							if(this.formatSend == null){
								this.formatSend = this.FORMAT_DEFAULT;
							}
							if(mf.getValueMethod() != null){
								 ts = this.stringToTimeStamp(mf.getValueMethod().toString());
							}
							
							oParams[0] = (mf.getValueMethod()!=null) ? ts : null;
							
						}
						
						Method mtd = classEnt.getMethod(m.getName(),cArgs);
						mtd.invoke(objEnt,oParams);
						
					}

				}
			}
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return objEnt;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  <T> T copyBean(Map<String,Object> mapInput,Class classEnt){
	    
		Method  methodsEnt[] = null;
		T objEnt = null;
		Constructor ctor;
		try {
			
			ctor = classEnt.getConstructor();
			objEnt = (T) ctor.newInstance();

				
			methodsEnt = classEnt.getMethods();
			
			List<MethodInfoUtil> methodInfo = new ArrayList<MethodInfoUtil>();
			
			for (Entry<String, Object> entry : mapInput.entrySet()){
					
					MethodInfoUtil mf = new MethodInfoUtil();
					mf.setNomMethod("set"+entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1, entry.getKey().length()));
					mf.setValueMethod(entry.getValue());
					
					methodInfo.add(mf);

			}
			
			for(MethodInfoUtil mf : methodInfo){
				for(Method m : methodsEnt){
									
					if(mf.getNomMethod().equals(m.getName())){
						
						Class cArgs[] = m.getParameterTypes();
						Object oParams[] = new Object[1];
												
						if(cArgs[0].getName().equals(Integer.class.getName()) || cArgs[0].getName().equals("int")){
							
							Object val = (mf.getValueMethod()!=null) ? Integer.parseInt((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Double.class.getName()) || cArgs[0].getName().equals("double")){
							
							Object val = (mf.getValueMethod()!=null) ? Double.parseDouble((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(BigDecimal.class.getName())){
							
							Object val = (mf.getValueMethod()!=null) ? new BigDecimal(Double.parseDouble((mf.getValueMethod()).toString())) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(BigInteger.class.getName())){
							
							Object val = (mf.getValueMethod()!=null) ? new BigInteger((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Long.class.getName()) || cArgs[0].getName().equals("long")){
							
							Object val = (mf.getValueMethod()!=null) ? Long.parseLong((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Short.class.getName()) || cArgs[0].getName().equals("short")){
							
							Object val = (mf.getValueMethod()!=null) ? Short.parseShort((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Byte.class.getName()) || cArgs[0].getName().equals("byte")){
							
							Object val = (mf.getValueMethod()!=null) ? Byte.parseByte((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Float.class.getName()) || cArgs[0].getName().equals("float")){
							
							Object val = (mf.getValueMethod()!=null) ? Float.parseFloat((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(Boolean.class.getName()) || cArgs[0].getName().equals("boolean")){
							
							Object val = (mf.getValueMethod()!=null) ? Boolean.parseBoolean((mf.getValueMethod()).toString()) : null;
							oParams[0] = val;
							
						}
						
						if(cArgs[0].getName().equals(String.class.getName())){
							
							String v = null;
							if(this.formatSend == null){
								this.formatSend = this.FORMAT_DEFAULT;
							}
							if(mf.getValueMethod() != null){
								Object val = mf.getValueMethod();
								if(val instanceof Date){
									Date d = (Date) val;
									v = this.dateToString(d);
								} else  if(val instanceof Timestamp){
									Timestamp ts = (Timestamp) val;
									v = this.timeStamptoString(ts);
								}else{
									v = val.toString();
								}
							}
							

							oParams[0] = (v!=null) ? v.toString().trim() : null;
							
						}
						
						if(cArgs[0].getName().equals(Date.class.getName())){
						
							Date date=null;
							if(this.formatSend == null){
								this.formatSend = this.FORMAT_DEFAULT;
							}

							if(mf.getValueMethod() != null){
									Object val = mf.getValueMethod();
									date = this.stringToDate(val.toString());
							}
							
							oParams[0] = (mf.getValueMethod()!=null) ? date : null;
							
						}
						
						if(cArgs[0].getName().equals(Timestamp.class.getName())){
							
							Timestamp ts=null;
							if(this.formatSend == null){
								this.formatSend = this.FORMAT_DEFAULT;
							}
							if(mf.getValueMethod() != null){
								 ts = this.stringToTimeStamp(mf.getValueMethod().toString());
							}
							
							oParams[0] = (mf.getValueMethod()!=null) ? ts : null;
							
						}
						
						Method mtd = classEnt.getMethod(m.getName(),cArgs);
						mtd.invoke(objEnt,oParams);
						
					}

				}
			}
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return objEnt;
	}

	
	public String getFormatSend() {
		return formatSend;
	}

	public void setFormatSend(String formatSend) {
		this.formatSend = formatSend;
	}
	
	public String dateToString(Date date){
		String dateString = new SimpleDateFormat(this.formatSend).format(date);
		dateString = dateString.replaceAll("-", "/");
		return dateString;
	}
	
	public Date stringToDate(String val){
		
		Date date = null;
		
		try {
			
			val = val.replaceAll("/", "-");
			if(!val.equals("")){
				date = new SimpleDateFormat(this.formatSend).parse(val);
			}
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public Timestamp stringToTimeStamp(String val){
		
		Date date = null;
		Timestamp ts = null;
		try {
			
			val = val.replaceAll("/", "-");
			if(!val.equals("")){
				date = new SimpleDateFormat(this.formatSend).parse(val);
				ts = new Timestamp(date.getTime());
			}
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ts;
	}
	
	public String timeStamptoString(Timestamp ts){
		Date date = new Date(ts.getTime());
		String dateString = new SimpleDateFormat(this.formatSend).format(date);
		dateString = dateString.replaceAll("-", "/");
		return dateString;
	}
	
}
