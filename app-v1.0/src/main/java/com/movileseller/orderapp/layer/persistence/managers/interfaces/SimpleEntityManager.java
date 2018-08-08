package com.movileseller.orderapp.layer.persistence.managers.interfaces;

import java.util.List;

import com.movileseller.orderapp.layer.business.dto.interfaces.DataTransferObject;

/**
 * Facade interface for simple entities' manger
 * 
 */
public interface SimpleEntityManager <T extends DataTransferObject> {

	/**
	 * 
	 * @param dto
	 * @return
	 */
    public T findOne(T dto);

    /**
     * 
     * @return
     */
    public List<T> findAll();

    /**
     * 
     * @param dto
     */
    public void create(T dto);

    /**
     * 
     * @param dto
     */
    public void update(T dto);

    /**
     * 
     * @param dto
     */
    public void delete(T dto);
}
