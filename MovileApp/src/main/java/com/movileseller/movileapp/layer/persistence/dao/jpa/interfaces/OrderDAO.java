package com.movileseller.movileapp.layer.persistence.dao.jpa.interfaces;

import java.util.List;

import com.movileseller.movileapp.layer.data.entities.jpa.Order;

public interface OrderDAO {

    public Order findOne(Object id);

    public List<Order> findAll();

    public void create(Order entity);

    public Order update(Order entity);

    public void delete(Order entity);

    public void deleteById(Object Id);
}
