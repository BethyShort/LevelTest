package com.movileseller.movileapp.layer.persistence.dao.jpa.interfaces;

import java.util.List;

import com.movileseller.movileapp.layer.data.entities.jpa.Customer;

/**
 * 
 * @author EXCC0100
 *
 */
public interface CustomerDAO {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Customer findOne(Object id);

	/**
	 * 
	 * @return
	 */
	public List<Customer> findAll();

	/**
	 * 
	 * @param entity
	 */
	public void create(Customer entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public Customer update(Customer entity);

	/**
	 * 
	 * @param entity
	 */
	public void delete(Customer entity);

	/**
	 * 
	 * @param id
	 */
	public void deleteById(Object id);
}
