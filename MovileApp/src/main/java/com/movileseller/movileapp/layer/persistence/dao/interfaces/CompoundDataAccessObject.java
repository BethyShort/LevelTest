package com.movileseller.movileapp.layer.persistence.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface CompoundDataAccessObject<T extends Serializable> extends SimleDataAccessObject<T> {
    public List<T> findByFilter(Serializable entity);
}
