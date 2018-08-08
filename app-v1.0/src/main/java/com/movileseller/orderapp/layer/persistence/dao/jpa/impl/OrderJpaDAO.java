package com.movileseller.orderapp.layer.persistence.dao.jpa.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.movileseller.orderapp.layer.persistence.dao.interfaces.CompoundDataAccessObject;
import com.movileseller.orderapp.layer.persistence.entities.jpa.Order;

/**
 * 
 * Data Access Object for Order entities
 *
 */
@Repository(value = "orderJpaDAO")
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class OrderJpaDAO extends AbstractCompoundEntityJpaDAO<Order> implements CompoundDataAccessObject<Order>{

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
