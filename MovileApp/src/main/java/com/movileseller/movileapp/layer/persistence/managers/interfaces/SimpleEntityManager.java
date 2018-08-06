package com.movileseller.movileapp.layer.persistence.managers.interfaces;

import java.util.List;

import com.movileseller.movileapp.layer.business.dto.interfaces.DataTransferObject;

/**
 * 
 * @author EXCC0100
 *
 * @param <T>
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
