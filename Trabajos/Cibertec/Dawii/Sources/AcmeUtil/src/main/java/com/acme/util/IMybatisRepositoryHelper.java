package com.acme.util;

import java.util.List;
import java.util.Map;

public interface IMybatisRepositoryHelper {

    <T> List<T> selectByExample(Class mapperClass, Object example) throws  Exception;
    <T> T selectOneByExample(Class mapperClass, Object example) throws  Exception;
	<T> List<T> selectByExample(Class mapperClass, Object example, Integer start, Integer limit) throws  Exception;
    <T> T selectOneByExample(Class mapperClass, Object example, Integer start, Integer limit) throws  Exception;
    <T> List<T> selectAll(Class mapperClass) throws  Exception;
    <T> List<T> selectAll(Class mapperClass, Integer start, Integer limit) throws  Exception;
	<T> T selectByPrimaryKey(Class mapperClass, Object pk) throws  Exception;

	<T> List<T> selectByQuery(Class mapperCriteria, DataCriteria criteria, boolean pagination) throws  Exception;
    <T> List<T> selectByQuery(Class mapperCriteria, DataCriteria criteria) throws  Exception;
	<T> List<T> selectByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws  Exception;
	<T> List<T> selectByQuery(Class mapperCriteria, DataCriteria criteria, Integer start, Integer limit) throws  Exception;
	<T> List<T> selectByQuery(Class mapperCriteria, Map<String, Object> paramMap, Integer start, Integer limit) throws  Exception;

	Integer selectCountByQuery(Class mapperCriteria, DataCriteria criteria) throws Exception;
	Integer selectCountByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws Exception;

    <T> T selectOneByQuery(Class mapperCriteria, DataCriteria criteria, boolean pagination) throws  Exception;
    <T> T selectOneByQuery(Class mapperCriteria, DataCriteria criteria) throws  Exception;
    <T> T selectOneByQuery(Class mapperCriteria, Map<String, Object> paramMap) throws  Exception;
    <T> T selectOneByQuery(Class mapperCriteria, DataCriteria criteria, Integer start, Integer limit) throws  Exception;

}
