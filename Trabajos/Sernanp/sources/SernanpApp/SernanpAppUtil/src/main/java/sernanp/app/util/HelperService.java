package sernanp.app.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class HelperService  implements IHelperService,ApplicationContextAware {

	private static Logger log = Logger.getLogger(HelperService.class);
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) {
		SpringContextUtil.setCtx(arg0);		
	}
	
	private ApplicationContext getApplicationContext(){
		return SpringContextUtil.getCtx();
	}
	
	private SqlSession getSqlSession(){
		return (SqlSession) getApplicationContext().getBean("sqlSession");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void eliminarPorPk(Class mapperClass,Object pk) throws BusinessException {
		invokeCRUDOperation(mapperClass, pk, "deleteByPrimaryKey");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void insertar(Class mapperClass,Object record) throws BusinessException {
		invokeCRUDOperation(mapperClass, record, "insert");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void insertarSelectivo(Class mapperClass,Object record) throws BusinessException {
		invokeCRUDOperation(mapperClass, record, "insertSelective");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> List<T> selectAll(Class mapperClass) throws BusinessException {
		
		String operation = "selectByExample";
		List<T> list = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperClass.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperClass);			
					Object example = null;			
					try {
						
						list =  (List<T>) method.invoke(mapper,example);
												
						
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("IllegalAccessException", e.getMessage());
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("InvocationTargetException", e.getMessage());
					} catch (Exception e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("Exception", e.getMessage());
					}
					break;
				}
			}
		}
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> T selectByPrimaryKey(Class mapperClass,Object pk) throws BusinessException{
				
		String operation = "selectByPrimaryKey";
		Object rObj = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperClass.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperClass);			
					Object parameters[] =  { pk };
								
					try {
						
						rObj = method.invoke(mapper, parameters);

						
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("IllegalAccessException", e.getMessage());
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("InvocationTargetException", e.getMessage());
					}
					break;
				}
			}
		}
		return (T) rObj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void actualizarPorPkSelectivo(Class mapperClass,Object record) throws BusinessException {
		invokeCRUDOperation(mapperClass, record, "updateByPrimaryKeySelective");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void actualizarPorPk(Class mapperClass,Object record) throws BusinessException {
		invokeCRUDOperation(mapperClass, record, "updateByPrimaryKey");
	}
	
//	@SuppressWarnings("rawtypes")
//	private Class findMapperClass(Object obj) throws BusinessException {
//		Class c = null;
//		try {
//			
//			String className = obj.getClass().getName();
//			className = className.replaceFirst("domain", "mapper") + "Mapper";
//			className = className.replaceFirst("Key", "");
//			c = Class.forName(className);
//		} catch (ClassNotFoundException e) {
//			log.error(e.getMessage(),e.getCause());
//			throw new BusinessException("ClassNotFoundException", e.getMessage());
//		}
//		return c;
//	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void invokeCRUDOperation(Class mapperClass, Object obj,String operation) throws BusinessException {
		if (this.getSqlSession() != null) {
			for (Method method : mapperClass.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperClass);			
					Object parameters[] = { obj } ;
									
					try {
						method.invoke(mapper, parameters);
						
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("IllegalAccessException", e.getMessage());
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("InvocationTargetException", e.getMessage());
					}
					break;
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> List<T> selectByExample(Class mapperClass, Object example) throws BusinessException {
		String operation = "selectByExample";
		List<T> list = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperClass.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperClass);			
					Object parameters[] =  { example };
					
					try {
						
						list =  (List<T>) method.invoke(mapper,parameters);
												
						
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("IllegalAccessException", e.getMessage());
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("InvocationTargetException", e.getMessage());
					} catch (Exception e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("Exception", e.getMessage());
					}
					
					break;
				}
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> List<T> selectByCriteria(Class mapperCriteria, Object criteria)throws BusinessException {
		
		String operation = "getListQuery";
		List<T> list = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperCriteria.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperCriteria);			
					Object parameters[] =  { criteria };
								
					try {
						
						list = (List<T>) method.invoke(mapper, parameters);
																		
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("IllegalAccessException", e.getMessage());
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e.getCause());
						throw new BusinessException("InvocationTargetException", e.getMessage());
					}
					break;
				}
			}
		}
		return list;
	}
}
