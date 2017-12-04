#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class HibernateRepositoryHelper <T, K extends Serializable> implements IHibernateRepositoryHelper<T, K>{

	@PersistenceContext
	private EntityManager em;

	private Class<T> entityClass;

    public HibernateRepositoryHelper() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    protected EntityManager getEntityManager() {
        return this.em;
    }

	@Override
	public void create(T record) throws Exception {
		em.persist(record);
	}
	
	@Override
	public void createAll(List<T> list) throws Exception {
		for(T record : list ){
			em.persist(record);
		}
	}

	@Override
	public T get(K id) throws Exception {
		return this.em.find(entityClass, id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> getAll() throws Exception {
		CriteriaQuery cq = this.em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
        return this.em.createQuery(cq).getResultList();
	}

	@Override
	public void update(T record) throws Exception {
		this.em.merge(record);
	}
	
	@Override
	public void updateAll(List<T> list) throws Exception {
		for(T record : list ){
			this.em.merge(record);
		}
	}
	
	@Override
	public void delete(T record) throws Exception {
		this.em.remove(this.em.merge(record));
	}
	
	@Override
	public void deleteAll(List<T> list) throws Exception {
		for(T record : list ){
			this.em.remove(record);
		}
	}
	
}
