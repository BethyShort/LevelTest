package com.movileseller.movileapp.layer.persistence.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface SimleDataAccessObject<T extends Serializable> {

    public T findOne(Object id);

    public List<T> findAll();

    public void create(T entity);

    public T update(T entity);

    public void delete(T entity);

    public void deleteById(Object entityId);
}
