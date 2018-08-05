package com.movileseller.movileapp.layer.persistence.managers.interfaces;

import java.util.List;

import com.movileseller.movileapp.layer.business.dto.interfaces.DataTransferObject;

public interface SimpleEntityManager <T extends DataTransferObject> {

    public T findOne(T dto);

    public List<T> findAll();

    public void create(T dto);

    public void update(T dto);

    public void delete(T dto);
}
