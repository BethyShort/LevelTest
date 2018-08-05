package com.movileseller.movileapp.layer.persistence.dao.jpa.interfaces;

import java.util.List;

import com.movileseller.movileapp.layer.data.entities.jpa.Customer;

public interface CustomerDAO {
    public Customer findOne(Object id);

    public List<Customer> findAll();

    public void create(Customer entity);

    public Customer update(Customer entity);

    public void delete(Customer entity);

    public void deleteById(Object id);
}
