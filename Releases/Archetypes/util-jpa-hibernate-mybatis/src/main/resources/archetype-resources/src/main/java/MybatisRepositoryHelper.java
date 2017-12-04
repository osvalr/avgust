#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Component
public abstract class MybatisRepositoryHelper implements IMybatisRepositoryHelper,ApplicationContextAware {

	private static Logger log = Logger.getLogger(MybatisRepositoryHelper.class);

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

	@Override
	public <T> List<T> selectAll(Class mapperClass) throws Exception {
		
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					} catch (Exception e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}

	@Override
	public <T> T selectByPrimaryKey(Class mapperClass,Object pk) throws Exception{
				
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return (T) rObj;
	}

	@Override
	public <T> List<T> selectByQuery(Class mapperCriteria, DataCriteria criteria, boolean pagination) throws Exception {
		if(pagination){
			return	this.selectByQuery(mapperCriteria,criteria, criteria.getStart(), criteria.getLimit());
		}else{
			return this.selectByQuery(mapperCriteria,criteria);
		}
	}

	private void invokeCRUDOperation(Class mapperClass, Object obj,String operation) throws Exception {
		if (this.getSqlSession() != null) {
			for (Method method : mapperClass.getMethods()) {
				if (method.getName().equals(operation)) {
					
					Object mapper = this.getSqlSession().getMapper(mapperClass);			
					Object parameters[] = { obj } ;
									
					try {
						method.invoke(mapper, parameters);
						
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					break;
				}
			}
		}
	}

	@Override
	public <T> List<T> selectByExample(Class mapperClass, Object example) throws Exception {
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					} catch (Exception e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					
					break;
				}
			}
		}
		return list;
	}

	@Override
	public <T> T selectOneByExample(Class mapperClass, Object example) throws Exception {
		List<T> list = this.selectByExample(mapperClass,example);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public <T> List<T> selectByExample(Class mapperClass, Object example,Integer start, Integer limit) throws Exception {
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					} catch (Exception e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					
					break;
				}
			}
		}
		return list;
	}

	@Override
	public <T> T selectOneByExample(Class mapperClass, Object example, Integer start, Integer limit) throws Exception {
		List<T> list = this.selectByExample(mapperClass,example,start,limit);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public <T> List<T> selectAll(Class mapperClass, Integer start, Integer limit) throws Exception {
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					} catch (Exception e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}

	@Override
	public <T> List<T> selectByQuery(Class mapperCriteria, DataCriteria criteria) throws Exception {
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}

	@Override
	public <T> List<T> selectByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws Exception {
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}

	@Override
	public <T> List<T> selectByQuery(Class mapperCriteria, DataCriteria criteria, Integer start, Integer limit) throws Exception {
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}

	@Override
	public <T> List<T> selectByQuery(Class mapperCriteria, Map<String, Object> paramMap, Integer start, Integer limit) throws Exception {
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return list;
	}

	@Override
	public Integer selectCountByQuery(Class mapperCriteria, DataCriteria criteria) throws Exception {
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return count;
	}

	@Override
	public Integer selectCountByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws Exception {
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
						throw new Exception(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
						throw new Exception(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return count;
	}

	@Override
	public <T> T selectOneByQuery(Class mapperCriteria, DataCriteria criteria, boolean pagination) throws Exception {
		if(pagination){
			return this.selectOneByQuery(mapperCriteria,criteria,criteria.getStart(),criteria.getLimit());
		}else{
			return this.selectOneByQuery(mapperCriteria,criteria);
		}
	}

	
	@Override
	public <T> T selectOneByQuery(Class mapperCriteria, DataCriteria criteria) throws Exception {
		List<T> list = null;
		list = this.selectByQuery(mapperCriteria, criteria);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public <T> T selectOneByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws Exception {
		List<T> list = null;
		list = this.selectByQuery(mapperCriteria, paramMap);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public <T> T selectOneByQuery(Class mapperCriteria, DataCriteria criteria, Integer start, Integer limit) throws Exception {
		List<T> list = null;
		list = this.selectByQuery(mapperCriteria, criteria,start,limit);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
}
