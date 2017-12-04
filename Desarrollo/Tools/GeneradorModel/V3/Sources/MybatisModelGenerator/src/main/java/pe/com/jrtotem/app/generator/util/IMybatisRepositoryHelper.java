package pe.com.jrtotem.app.generator.util;

import java.util.List;
import java.util.Map;

public interface IMybatisRepositoryHelper {

	@SuppressWarnings("rawtypes")
	void deleteByPrimaryKey(Class mapperClass,Object pk) throws Exception;
    @SuppressWarnings("rawtypes")
	void deleteByPrimaryKey(Class mapperClass,List list) throws Exception;
    @SuppressWarnings("rawtypes")
	void insert(Class mapperClass,Object record) throws Exception;
    @SuppressWarnings("rawtypes")
	void insert(Class mapperClass,List list) throws Exception;
    @SuppressWarnings("rawtypes")
	void insertSelective(Class mapperClass,Object record) throws Exception;
    @SuppressWarnings("rawtypes")
	void insertSelective(Class mapperClass,List list) throws Exception;
    @SuppressWarnings("rawtypes")
    <T> List<T> selectByExample(Class mapperClass,Object example) throws  Exception;
    @SuppressWarnings("rawtypes")
	<T> List<T> selectByExample(Class mapperClass,Object example, Integer start, Integer limit) throws  Exception;
    @SuppressWarnings("rawtypes")
    <T> List<T> selectAll(Class mapperClass) throws  Exception;
    @SuppressWarnings("rawtypes")
    <T> List<T> selectAll(Class mapperClass, Integer start, Integer limit) throws  Exception;
    @SuppressWarnings("rawtypes")
	<T> T selectByPrimaryKey(Class mapperClass,Object pk) throws  Exception;
    @SuppressWarnings("rawtypes")
	void updateByPrimaryKeySelective(Class mapperClass,Object record) throws  Exception;
    @SuppressWarnings("rawtypes")
	void updateByPrimaryKeySelective(Class mapperClass,List list) throws  Exception;
    @SuppressWarnings("rawtypes")
	void updateByPrimaryKey(Class mapperClass,Object record) throws  Exception;
    @SuppressWarnings("rawtypes")
	void updateByPrimaryKey(Class mapperClass,List list) throws  Exception;
	
	@SuppressWarnings("rawtypes")
	<T> List<T> selectByQuery(Class mapperCriteria, Object criteria, Integer start, Integer limit) throws  Exception;
	@SuppressWarnings("rawtypes")
    <T> List<T> selectByQuery(Class mapperCriteria, Object criteria) throws  Exception;
	
	@SuppressWarnings("rawtypes")
	<T> List<T> selectByQuery(Class mapperCriteria, Map<String, Object> paramMap, Integer start, Integer limit) throws  Exception;
		@SuppressWarnings("rawtypes")
	<T> List<T> selectByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws  Exception;

	@SuppressWarnings("rawtypes")
	Integer selectCountByQuery(Class mapperCriteria, Object criteria) throws Exception;
	@SuppressWarnings("rawtypes")
	Integer selectCountByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws Exception;

	@SuppressWarnings("rawtypes")
    <T> T selectOneByQuery(Class mapperCriteria, Object criteria) throws  Exception;
	@SuppressWarnings("rawtypes")
    <T> T selectOneByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws  Exception;

}
