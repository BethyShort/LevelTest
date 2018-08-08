package com.movileseller.movileapp.layer.data.entities.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order database table.
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