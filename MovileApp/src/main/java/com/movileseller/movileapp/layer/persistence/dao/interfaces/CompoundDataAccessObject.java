package com.movileseller.movileapp.layer.persistence.dao.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author EXCC0100
 *
 * @param <T>
 */
public interface CompoundDataAccessObject<T extends Serializable> extends SimpleDataAccessObject<T> {
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
    public List<T> findByFilter(Serializable entity);
}

