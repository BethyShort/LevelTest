package com.movileseller.orderapp.layer.persistence.entities.jpa;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity representation form Customers.
 * 
 */
@Entity
@Table(name="customer")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcustomer;

	private String email;

	private String name;

	private String surname;

	public Customer() {
	}

	public Integer getIdcustomer() {
		return this.idcustomer;
	}

	public void setIdcustomer(Integer idcustomer) {
		this.idcustomer = idcustomer;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}