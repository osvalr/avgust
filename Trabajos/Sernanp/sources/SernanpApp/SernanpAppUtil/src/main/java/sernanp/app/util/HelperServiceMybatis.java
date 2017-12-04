package sernanp.app.util;

import java.util.List;
import java.util.Map;

public interface HelperServiceMybatis {
	
    @SuppressWarnings("rawtypes")
	void deleteByPrimaryKey(Class mapperClass,Object pk) throws BusinessException;
    @SuppressWarnings("rawtypes")
	void deleteByPrimaryKey(Class mapperClass,List list) throws BusinessException;
    @SuppressWarnings("rawtypes")
	void insert(Class mapperClass,Object record) throws BusinessException;
    @SuppressWarnings("rawtypes")
	void insert(Class mapperClass,List list) throws BusinessException;
    @SuppressWarnings("rawtypes")
	void insertSelective(Class mapperClass,Object record) throws BusinessException;
    @SuppressWarnings("rawtypes")
	void insertSelective(Class mapperClass,List list) throws BusinessException;
    @SuppressWarnings("rawtypes")
    <T> List<T> selectByExample(Class mapperClass,Object example) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	<T> List<T> selectByExample(Class mapperClass,Object example, Integer start, Integer limit) throws  BusinessException;
    @SuppressWarnings("rawtypes")
    <T> List<T> selectAll(Class mapperClass) throws  BusinessException;
    @SuppressWarnings("rawtypes")
    <T> List<T> selectAll(Class mapperClass, Integer start, Integer limit) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	<T> T selectByPrimaryKey(Class mapperClass,Object pk) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	void updateByPrimaryKeySelective(Class mapperClass,Object record) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	void updateByPrimaryKeySelective(Class mapperClass,List list) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	void updateByPrimaryKey(Class mapperClass,Object record) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	void updateByPrimaryKey(Class mapperClass,List list) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	<T> List<T> getListByQuery(Class mapperCriteria, Object criteria) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	<T> List<T> getListByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	<T> List<T> getListByQuery(Class mapperCriteria, Object criteria, Integer start, Integer limit) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	<T> List<T> getListByQuery(Class mapperCriteria, Map<String, Object> paramMap, Integer start, Integer limit) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	Integer getCountRowsByQuery(Class mapperCriteria, Object criteria) throws BusinessException;
    @SuppressWarnings("rawtypes")
	Integer getCountRowsByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws BusinessException;
    @SuppressWarnings("rawtypes")
    <T> T getRecordByQuery(Class mapperCriteria, Object criteria) throws  BusinessException;
    @SuppressWarnings("rawtypes")
    <T> T getRecordByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws  BusinessException;

}
