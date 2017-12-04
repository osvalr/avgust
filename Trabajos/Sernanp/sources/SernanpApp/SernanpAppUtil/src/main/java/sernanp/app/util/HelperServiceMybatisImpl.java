package sernanp.app.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class HelperServiceMybatisImpl  implements HelperServiceMybatis,ApplicationContextAware {

	private static Logger log = Logger.getLogger(HelperServiceMybatisImpl.class);
	
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
	public void deleteByPrimaryKey(Class mapperClass,Object pk) throws BusinessException {
		invokeCRUDOperation(mapperClass, pk, "deleteByPrimaryKey");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void insert(Class mapperClass,Object record) throws BusinessException {
		invokeCRUDOperation(mapperClass, record, "insert");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void insertSelective(Class mapperClass,Object record) throws BusinessException {
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
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (Exception e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
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
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return (T) rObj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void updateByPrimaryKeySelective(Class mapperClass,Object record) throws BusinessException {
		invokeCRUDOperation(mapperClass, record, "updateByPrimaryKeySelective");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void updateByPrimaryKey(Class mapperClass,Object record) throws BusinessException {
		invokeCRUDOperation(mapperClass, record, "updateByPrimaryKey");
	}
	
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
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
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
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (Exception e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					}
					
					break;
				}
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> List<T> selectByExample(Class mapperClass, Object example,Integer start, Integer limit) throws BusinessException {
		String operation = "selectByExampleWithRowbounds";
		List<T> list = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperClass.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperClass);	
					RowBounds rb = new RowBounds(start,limit);
					Object parameters[] =  { example,rb };
					
					try {
						
						
						list =  (List<T>) method.invoke(mapper,parameters);
												
						
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (Exception e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					}
					
					break;
				}
			}
		}
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> List<T> selectAll(Class mapperClass, Integer start, Integer limit) throws BusinessException {
		String operation = "selectByExampleWithRowbounds";
		List<T> list = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperClass.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperClass);
					RowBounds rb = new RowBounds(start,limit);
					Object parameters[] =  { null,rb };	
					try {

						list =  (List<T>) method.invoke(mapper,parameters);
												
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (Exception e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteByPrimaryKey(Class mapperClass, List list) throws BusinessException {
		for (Object object : list) {
			this.deleteByPrimaryKey(mapperClass, object);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void insert(Class mapperClass, List list) throws BusinessException {
		for (Object object : list) {
			this.insert(mapperClass, object);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void insertSelective(Class mapperClass, List list) throws BusinessException {
		for (Object object : list) {
			this.insertSelective(mapperClass, object);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void updateByPrimaryKeySelective(Class mapperClass, List list) throws BusinessException {
		for (Object object : list) {
			this.updateByPrimaryKeySelective(mapperClass, object);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void updateByPrimaryKey(Class mapperClass, List list) throws BusinessException {
		for (Object object : list) {
			this.updateByPrimaryKey(mapperClass, object);
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public <T> List<T> getListByQuery(Class mapperCriteria, Object criteria) throws BusinessException {
		String operation = "getListQueryByCriteria";
		List<T> list = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperCriteria.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperCriteria);			
					Object parameters[] =  { criteria };
								
					try {
						
						list = (List<T>) method.invoke(mapper, parameters);
																		
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> List<T> getListByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws BusinessException {
		String operation = "getListQueryByMap";
		List<T> list = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperCriteria.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperCriteria);			
					Object parameters[] =  { paramMap };
								
					try {
						
						list = (List<T>) method.invoke(mapper, parameters);
																		
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> List<T> getListByQuery(Class mapperCriteria, Object criteria, Integer start, Integer limit) throws BusinessException {
		String operation = "getListQueryPaginationByCriteria";
		List<T> list = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperCriteria.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperCriteria);		
					RowBounds rb = new RowBounds(start,limit);
					Object parameters[] =  { criteria,rb };
								
					try {
						
						list = (List<T>) method.invoke(mapper, parameters);
																		
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> List<T> getListByQuery(Class mapperCriteria, Map<String, Object> paramMap, Integer start, Integer limit) throws BusinessException {
		String operation = "getListQueryPaginationByMap";
		List<T> list = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperCriteria.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperCriteria);		
					RowBounds rb = new RowBounds(start,limit);
					Object parameters[] =  { paramMap,rb };
								
					try {
						
						list = (List<T>) method.invoke(mapper, parameters);
																		
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Integer getCountRowsByQuery(Class mapperCriteria, Object criteria) throws BusinessException {
		String operation = "getCountRowsByCriteria";
		Integer count = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperCriteria.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperCriteria);		
					Object parameters[] =  { criteria };
								
					try {
						
						count =  (Integer) method.invoke(mapper, parameters);
																		
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return count;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Integer getCountRowsByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws BusinessException {
		String operation = "getCountRowsByMap";
		Integer count = null;
		
		if (this.getSqlSession() != null) {
			for (Method method : mapperCriteria.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperCriteria);		
					Object parameters[] =  { paramMap };
								
					try {
						
						count =  (Integer) method.invoke(mapper, parameters);
																		
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new BusinessException(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return count;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public <T> T getRecordByQuery(Class mapperCriteria, Object criteria) throws BusinessException {
		List<T> list = null;
		list = this.getListByQuery(mapperCriteria, criteria);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public <T> T getRecordByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws BusinessException {
		List<T> list = null;
		list = this.getListByQuery(mapperCriteria, paramMap);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
}
