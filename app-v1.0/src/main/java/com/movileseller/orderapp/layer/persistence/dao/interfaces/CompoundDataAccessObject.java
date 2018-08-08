package com.movileseller.orderapp.layer.persistence.dao.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Interface to represent Database Access Object operations in compounded entities.
 *
 */
public interface CompoundDataAccessObject<T extends Serializable> extends SimpleDataAccessObject<T> {
	
	/**
	 * Let search by partial key.
	 *  
	 * @param entity
	 * @return
	 */
    public List<T> findByFilter(Serializable entity);
}

