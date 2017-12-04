package sernanp.app.util;

import java.util.List;

public interface IHelperService {
	
    @SuppressWarnings("rawtypes")
	void eliminarPorPk(Class mapperClass,Object pk) throws BusinessException;
    @SuppressWarnings("rawtypes")
	void insertar(Class mapperClass,Object record) throws BusinessException;
    @SuppressWarnings("rawtypes")
	void insertarSelectivo(Class mapperClass,Object record) throws BusinessException;
    @SuppressWarnings("rawtypes")
    <T> List<T> selectByExample(Class mapperClass,Object example) throws  BusinessException;
    @SuppressWarnings("rawtypes")
    <T> List<T> selectAll(Class mapperClass) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	<T> T selectByPrimaryKey(Class mapperClass,Object pk) throws  BusinessException;
    @SuppressWarnings("rawtypes")
    <T> List<T> selectByCriteria(Class mapperCriteria, Object criteria) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	void actualizarPorPkSelectivo(Class mapperClass,Object record) throws  BusinessException;
    @SuppressWarnings("rawtypes")
	void actualizarPorPk(Class mapperClass,Object record) throws  BusinessException;

}
