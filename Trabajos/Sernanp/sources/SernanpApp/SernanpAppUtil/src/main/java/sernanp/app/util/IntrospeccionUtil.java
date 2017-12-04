package sernanp.app.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IntrospeccionUtil {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> tranferListBean(List list,Class c,boolean upperCase){
		List<T> rlist = new ArrayList<T>();
		for(Object obj : list){
			rlist.add((T) tranferBean(obj, c,upperCase));
		}
		return rlist;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> tranferListBeanDataType(List list,Class c){
		List<T> rlist = new ArrayList<T>();
		for(Object obj : list){
			rlist.add((T) tranferBeanEqualDataType(obj, c));
		}
		return rlist;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T tranferBean(Object objDto,Class c,boolean upperCase){
	    
		Class  classDto = objDto.getClass();
	    Class  classEnt = c;
		Method  methodsDto[] = classDto.getMethods();
		Method  methodsEnt[] = classEnt.getMethods();
		T objEnt = null;
		Constructor ctor;
		try {
			ctor = classEnt.getConstructor();
			objEnt = (T) ctor.newInstance();
			
			List<MethodInfoUtil> methodInfo = new ArrayList<MethodInfoUtil>();
			
			
			for(Method m : methodsDto){
						
				String tipoMetodo = m.getName().substring(0, 3);
				
				if(tipoMetodo.equals("get") && !m.getName().equals("getClass")){
					
					Class cArgs[] = m.getParameterTypes();
					Method mtd = classDto.getMethod(m.getName(),cArgs);
					Object val = mtd.invoke(objDto);
					
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
							
							if(upperCase){
								oParams[0] = (mf.getValueMethod()!=null) ? mf.getValueMethod().toString().trim().toUpperCase() : null;	
							}else{
								oParams[0] = (mf.getValueMethod()!=null) ? mf.getValueMethod().toString().trim() : null;
							}
							
							
						}
						
						if(cArgs[0].getName().equals(Date.class.getName())){
							
							SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
							Date date,dateReturn = null;
							
							if(mf.getValueMethod() != null){
								try {
									String dateString = mf.getValueMethod().toString().replaceAll("/", "-");
									if(!dateString.equals("")){
										date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
										String dateString2 = new SimpleDateFormat("yyyy-MM-dd").format(date);
										dateReturn = simpleFormat.parse(dateString2);
									}
									
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
							oParams[0] = (mf.getValueMethod()!=null) ? dateReturn : null;
							
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
	public static <T> T tranferBean(Object objDto,Object record,boolean upperCase){
	    
		Class  classDto = objDto.getClass();
	    Class  classEnt = record.getClass();
		Method  methodsDto[] = classDto.getMethods();
		Method  methodsEnt[] = classEnt.getMethods();
		T objEnt = (T) record;
//		Constructor ctor;
		try {
//			ctor = classEnt.getConstructor();
//			objEnt = (T) ctor.newInstance();
			
			List<MethodInfoUtil> methodInfo = new ArrayList<MethodInfoUtil>();
			
			
			for(Method m : methodsDto){
						
				String tipoMetodo = m.getName().substring(0, 3);
				
				if(tipoMetodo.equals("get") && !m.getName().equals("getClass")){
					
					Class cArgs[] = m.getParameterTypes();
					Method mtd = classDto.getMethod(m.getName(),cArgs);
					Object val = mtd.invoke(objDto);
					
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
							
							if(upperCase){
								oParams[0] = (mf.getValueMethod()!=null) ? mf.getValueMethod().toString().trim().toUpperCase() : null;	
							}else{
								oParams[0] = (mf.getValueMethod()!=null) ? mf.getValueMethod().toString().trim() : null;
							}
							
							
						}
						
						if(cArgs[0].getName().equals(Date.class.getName())){
							
							SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
							Date date,dateReturn = null;
							
							if(mf.getValueMethod() != null){
								try {
									String dateString = mf.getValueMethod().toString().replaceAll("/", "-");
									if(!dateString.equals("")){
										date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
										String dateString2 = new SimpleDateFormat("yyyy-MM-dd").format(date);
										dateReturn = simpleFormat.parse(dateString2);
									}
									
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
							oParams[0] = (mf.getValueMethod()!=null) ? dateReturn : null;
							
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
	public static <T> T tranferBeanEqualDataType(Object objDto,Class c){
	    
		Class  classDto = objDto.getClass();
	    Class  classEnt = c;
		Method  methodsDto[] = classDto.getMethods();
		Method  methodsEnt[] = classEnt.getMethods();
		T objEnt = null;
		Constructor ctor;
		try {
			ctor = classEnt.getConstructor();
			objEnt = (T) ctor.newInstance();
			
			List<MethodInfoUtil> methodInfo = new ArrayList<MethodInfoUtil>();
			
			
			for(Method m : methodsDto){
						
				String tipoMetodo = m.getName().substring(0, 3);
				
				if(tipoMetodo.equals("get") && !m.getName().equals("getClass")){
					
					Class cArgs[] = m.getParameterTypes();
					Method mtd = classDto.getMethod(m.getName(),cArgs);
					Object val = mtd.invoke(objDto);
					
					MethodInfoUtil mf = new MethodInfoUtil();
					mf.setNomMethod("set"+m.getName().substring(3, m.getName().length()));
					mf.setTypeDataMethod(m.getReturnType());
					mf.setValueMethod(val);
					
					methodInfo.add(mf);
					
				}

			}
			
			for(MethodInfoUtil mf : methodInfo){
				for(Method m : methodsEnt){
									
					if(mf.getNomMethod().equals(m.getName()) && mf.getTypeDataMethod() == m.getParameterTypes()[0]){
						
						Class cArgs[] = m.getParameterTypes();
						Object oParams[] = { mf.getValueMethod() };
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
	
}
