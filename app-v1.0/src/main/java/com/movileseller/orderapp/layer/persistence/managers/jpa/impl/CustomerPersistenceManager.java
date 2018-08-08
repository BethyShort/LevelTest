package com.movileseller.orderapp.layer.persistence.managers.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.movileseller.orderapp.layer.business.dto.impl.CustomerDTO;
import com.movileseller.orderapp.layer.persistence.dao.interfaces.SimpleDataAccessObject;
import com.movileseller.orderapp.layer.persistence.entities.jpa.Customer;
import com.movileseller.orderapp.layer.persistence.managers.interfaces.SimpleEntityManager;

/**
 * Customer Data Access Objects manager. 
 * 
 */
@Component (value="customerPersistenceManager")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomerPersistenceManager implements SimpleEntityManager<CustomerDTO> {

    @Autowired
    @Qualifier("customerJpaDAO")
    private SimpleDataAccessObject<Customer> customerDao; 
    
	@Override
    public CustomerDTO findOne(CustomerDTO dto) {
        Customer entity= dtoToEntity(dto);
        entity=customerDao.findOne(entity.getIdcustomer());
        return entityToDto(entity);
    }

	@Override
    public List<CustomerDTO> findAll() {
        List <CustomerDTO> resultList=new ArrayList<CustomerDTO>();
        List<Customer> list=customerDao.findAll();
        for (Customer customer: list) {
            resultList.add(entityToDto(customer));
        }
        return resultList;
    }

	@Override
    public void create(CustomerDTO dto) {
        Customer entity= dtoToEntity(dto);
        customerDao.create(entity);
    }

	@Override
    public void update(CustomerDTO dto) {
        Customer entity= dtoToEntity(dto);
        customerDao.update(entity);
    }

	@Override
    public void delete(CustomerDTO dto) {
        Customer entity= dtoToEntity(dto);
        customerDao.delete(entity);
    }

    private Customer dtoToEntity(CustomerDTO dto) {
        Customer entity=new Customer();
        entity.setEmail(dto.getEmail());
        entity.setIdcustomer(dto.getCustomerId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        return entity;
    }
    
    private CustomerDTO entityToDto(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setEmail(entity.getEmail());
        dto.setCustomerId(entity.getIdcustomer());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        return dto;
    }
}
