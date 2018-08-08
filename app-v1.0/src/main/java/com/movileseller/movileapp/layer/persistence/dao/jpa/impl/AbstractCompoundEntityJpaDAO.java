package com.movileseller.movileapp.layer.persistence.dao.jpa.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import com.movileseller.movileapp.layer.persistence.dao.interfaces.CompoundDataAccessObject;

public abstract class AbstractCompoundEntityJpaDAO<T extends Serializable> extends AbstractSimpleEntityJpaDAO<T> implements CompoundDataAccessObject<T>{

    public abstract List<T> findByFilter(Serializable entity);

    protected HashMap<String, Object> getFields(Serializable entity) {
        HashMap<String, Object> filter = new HashMap<String, Object>();
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean hayError = false;
            String name = "";
            Object value = null;
            try {
                name = field.getName().toUpperCase();
                value = field.get(entity);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!hayError)
                filter.put(name, value);
        }
        return filter;
    }

}
