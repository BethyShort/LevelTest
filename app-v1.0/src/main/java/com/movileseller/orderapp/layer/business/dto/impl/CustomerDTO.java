package com.movileseller.orderapp.layer.business.dto.impl;

import java.io.Serializable;

import com.movileseller.orderapp.layer.business.dto.interfaces.DataTransferObject;

/**
 * 
 *  Data Transfer object to represent Customers in the Business layer
 * 
 */
public class CustomerDTO implements Serializable, DataTransferObject{

	private static final long serialVersionUID = -6914416228335975018L;
	
	private int customerId = -1;
	private String name="";
	private String surname="";
	private String email="";
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
