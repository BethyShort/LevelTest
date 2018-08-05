package com.movileseller.movileapp.layer.persistence.dao.jpa.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.movileseller.movileapp.layer.data.entities.jpa.Order;
import com.movileseller.movileapp.layer.persistence.dao.jpa.interfaces.OrderDAO;

@Repository(value = "orderJpaDAO")
public class OrderJpaDAO extends AbstractCompoundEntityJpaDAO<Order> implements OrderDAO {

    public OrderJpaDAO() {
        setClazz(Order.class);
    }

    @Override
    public List<Order> findByFilter(Serializable order) {
        List<Order> result = new ArrayList<Order>();
        HashMap<String, Object> fields = getFields(order);
        Object idOrder = fields.get("idOrder");
        StringBuilder query = new StringBuilder("SELECT c FROM Order o WHERE ");
        query.append("o.idOrder LIKE : idOrder");

        result = entityManager.createQuery(query.toString()).setParameter("idOrder", idOrder).getResultList();

        return result;
    }

}
