package com.movileseller.movileapp.layer.persistence.dao.jpa.impl;

import org.springframework.stereotype.Repository;

import com.movileseller.movileapp.layer.data.entities.jpa.Phone;
import com.movileseller.movileapp.layer.persistence.dao.jpa.interfaces.PhoneDAO;

@Repository(value="phoneJpaDAO")
public class PhoneJpaDAO extends AbstractSimpleEntityJpaDAO<Phone> implements PhoneDAO{
    
    public PhoneJpaDAO() {
        setClazz(Phone.class);
    }
}
