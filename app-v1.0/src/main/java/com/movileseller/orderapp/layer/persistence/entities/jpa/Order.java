package com.movileseller.orderapp.layer.persistence.entities.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity representation form Orders.
 * 
 */
@Entity
@Table(name="order")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderPK id;

	public Order() {
	}

	public OrderPK getId() {
		return this.id;
	}

	public void setId(OrderPK id) {
		this.id = id;
	}

}