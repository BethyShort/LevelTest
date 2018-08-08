package com.movileseller.movileapp.layer.persistence.dao.jpa.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.movileseller.movileapp.layer.data.entities.jpa.Customer;


@Repository(value="customerJpaDAO")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomerJpaDAO extends AbstractSimpleEntityJpaDAO<Customer>{

    public CustomerJpaDAO(){
        setClazz(Customer.class );
     }
}
