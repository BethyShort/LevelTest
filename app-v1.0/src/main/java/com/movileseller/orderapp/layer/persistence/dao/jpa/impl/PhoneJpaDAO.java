package com.movileseller.orderapp.layer.persistence.dao.jpa.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.movileseller.orderapp.layer.persistence.dao.interfaces.SimpleDataAccessObject;
import com.movileseller.orderapp.layer.persistence.entities.jpa.Phone;

/**
 * 
 * Data Access Object for Phone entities
 *
 */
@Repository(value="phoneJpaDAO")
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class PhoneJpaDAO extends AbstractSimpleEntityJpaDAO<Phone> implements SimpleDataAccessObject<Phone>{
    
    public PhoneJpaDAO() {
        setClazz(Phone.class);
    }
}
