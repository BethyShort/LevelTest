package com.movileseller.movileapp.layer.persistence.managers.interfaces;

import java.util.List;

import com.movileseller.movileapp.layer.business.dto.interfaces.DataTransferObject;

/**
 * 
 * @author EXCC0100
 *
 * @param <T>
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
