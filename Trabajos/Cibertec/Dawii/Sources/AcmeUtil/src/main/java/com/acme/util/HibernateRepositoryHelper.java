package com.acme.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public abstract class HibernateRepositoryHelper <T, K extends Serializable> implements IHibernateRepositoryHelper<T, K>{

	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> entityClass;

	private T t;

    public HibernateRepositoryHelper() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.setEntityClass((Class<T>) genericSuperclass.getActualTypeArguments()[0]);
    }

	private T getT(){
		return t;
	}

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

	@Override
	public void create(T record) throws Exception {
		this.entityManager.persist(record);
	}
	
	@Override
	public void createAll(List<T> list) throws Exception {
		for(T record : list ){
			this.entityManager.persist(record);
		}
	}

	@Override
	public T get(K id) throws Exception {
		return this.entityManager.find(getEntityClass(), id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> getAll() throws Exception {
		CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(getEntityClass()));
        return this.entityManager.createQuery(cq).getResultList();
	}

	@Override
	public void update(T record) throws Exception {
		this.entityManager.merge(record);
	}
	
	@Override
	public void updateAll(List<T> list) throws Exception {
		for(T record : list ){
			this.entityManager.merge(record);
		}
	}
	
	@Override
	public void delete(T record) throws Exception {
		this.entityManager.remove(this.entityManager.merge(record));
	}

	@Override
	public void deleteAll(List<T> list) throws Exception {
		for(T record : list ){
			this.entityManager.remove(record);
		}
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
