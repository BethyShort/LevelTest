package com.movileseller.orderapp.layer.persistence.dao.jpa.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * Base class for Data Access Objects
 *
 */
public abstract class AbstractSimpleEntityJpaDAO<T extends Serializable>{

	private Class<T> clazz;

	@PersistenceContext
	EntityManager entityManager;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(Object id) {
		return entityManager.find(clazz, id);
	}
	
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	public void create(T entity) {
		entityManager.persist(entity);
	}

	public T update(T entity) {
		return entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void deleteById(Object entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
}