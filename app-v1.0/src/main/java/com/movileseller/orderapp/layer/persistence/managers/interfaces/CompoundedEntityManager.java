package com.movileseller.orderapp.layer.persistence.managers.interfaces;

import java.util.List;

import com.movileseller.orderapp.layer.business.dto.interfaces.DataTransferObject;

/**
 * Facade interface for compounded entities' manger
 * 
 */
public interface CompoundedEntityManager <T extends DataTransferObject>{

	/**
	 * 
	 * @return
	 */
    public List<T> findAll();
    
    /**
     * 
     * @param dto
     * @return
     */
    public List<T> findByFilter(T dto);

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

    /**
     * 
     * @param dto
     */
    public void deleteByFilter(T dto);

}
