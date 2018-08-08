package com.movileseller.orderapp.layer.persistence.dao.jpa.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.movileseller.orderapp.layer.persistence.dao.interfaces.SimpleDataAccessObject;
import com.movileseller.orderapp.layer.persistence.entities.jpa.Customer;

/**
 * 
 * Data Access Object for Customer entities
 *
 */
@Repository(value="customerJpaDAO")
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class CustomerJpaDAO extends AbstractSimpleEntityJpaDAO<Customer>  implements SimpleDataAccessObject<Customer>{

    public CustomerJpaDAO(){
        setClazz(Customer.class );
     }
}
