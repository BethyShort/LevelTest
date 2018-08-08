package com.movileseller.movileapp.layer.persistence.dao.jpa.impl;

import org.springframework.stereotype.Repository;

import com.movileseller.movileapp.layer.data.entities.jpa.Customer;
import com.movileseller.movileapp.layer.persistence.dao.jpa.interfaces.CustomerDAO;

@Repository (value="customerJpaDAO")
public class CustomerJpaDAO extends AbstractSimpleEntityJpaDAO<Customer> implements CustomerDAO{

    public CustomerJpaDAO(){
        setClazz(Customer.class );
     }
}
