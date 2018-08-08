package com.movileseller.movileapp.layer.persistence.dao.jpa.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.movileseller.movileapp.layer.data.entities.jpa.Phone;

@Repository(value="phoneJpaDAO")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PhoneJpaDAO extends AbstractSimpleEntityJpaDAO<Phone>{
    
    public PhoneJpaDAO() {
        setClazz(Phone.class);
    }
}
