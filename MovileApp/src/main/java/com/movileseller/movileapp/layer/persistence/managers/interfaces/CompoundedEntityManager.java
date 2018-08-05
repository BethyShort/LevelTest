package com.movileseller.movileapp.layer.persistence.managers.interfaces;

import java.util.List;

import com.movileseller.movileapp.layer.business.dto.interfaces.DataTransferObject;

public interface CompoundedEntityManager <T extends DataTransferObject>{


    public List<T> findAll();
    
    public List<T> findByFilter(T dto);

    public void create(T dto);

    public void update(T dto);

    public void delete(T dto);

    public void deleteByFilter(T dto);

}
