#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.io.Serializable;
import java.util.List;

public interface IHibernateRepositoryHelper<T, K extends Serializable> {
		
	void create(T record) throws Exception;
	
	void createAll(List<T> list) throws Exception;

	T get(K id) throws Exception;

	List<T> getAll() throws Exception;

	void update(T record) throws Exception;
	
	void updateAll(List<T> list) throws Exception;
	
	void delete(T record) throws Exception;
	
	void deleteAll(List<T> list) throws Exception;
	
}
