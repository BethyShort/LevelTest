package com.movileseller.orderapp.layer.persistence.dao.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Interface to represent Database Access Object operations simple entities.
 *
 */
public interface SimpleDataAccessObject<T extends Serializable> {

	/**
	 * 
	 * @param id
	 * @return
	 */
    public T findOne(Object id);

    /**
     * 
     * @return
     */
    public List<T> findAll();

    /**
     * 
     * @param entity
     */
    public void create(T entity);

    /**
     * 
     * @param entity
     * @return
     */
    public T update(T entity);

    /**
     * 
     * @param entity
     */
    public void delete(T entity);

    /**
     * 
     * @param entityId
     */
    public void deleteById(Object entityId);
}
