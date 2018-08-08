package com.movileseller.movileapp.layer.persistence.dao.jpa.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.movileseller.movileapp.layer.persistence.dao.interfaces.SimpleDataAccessObject;

/**
 * 
 * @author EXCC0100
 *
 * @param <T>
 */
public abstract class AbstractSimpleEntityJpaDAO<T extends Serializable> implements SimpleDataAccessObject<T>{

	private Class<T> clazz;

	@PersistenceContext
	EntityManager entityManager;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Override
	public T findOne(Object id) {
		return entityManager.find(clazz, id);
	}
	
	@Override
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	@Override
	public void create(T entity) {
		entityManager.persist(entity);
	}

	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public void deleteById(Object entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
}