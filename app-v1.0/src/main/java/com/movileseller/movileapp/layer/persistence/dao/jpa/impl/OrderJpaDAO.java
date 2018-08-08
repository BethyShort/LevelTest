package com.movileseller.movileapp.layer.persistence.dao.jpa.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.movileseller.movileapp.layer.data.entities.jpa.Order;

/**
 * 
 * @author EXCC0100
 *
 */
@Repository(value = "orderJpaDAO")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderJpaDAO extends AbstractCompoundEntityJpaDAO<Order> {

	/**
	 * Asigna a la clase por defecto el tipo de DAO con el que debe trabajar
	 */
    public OrderJpaDAO() {
        setClazz(Order.class);
    }

    @Override
    public List<Order> findByFilter(Serializable order) {
        List<Order> result;
        HashMap<String, Object> fields = getFields(order);
        Object idOrder = fields.get("idOrder");
        StringBuilder query = new StringBuilder("SELECT c FROM Order o WHERE ");
        query.append("o.idOrder LIKE : idOrder");

        result = entityManager.createQuery(query.toString()).setParameter("idOrder", idOrder).getResultList();

        return result;
    }

}
