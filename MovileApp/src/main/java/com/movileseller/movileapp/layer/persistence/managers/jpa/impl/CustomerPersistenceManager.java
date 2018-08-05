package com.movileseller.movileapp.layer.persistence.managers.jpa.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.movileseller.movileapp.layer.business.dto.impl.CustomerDTO;
import com.movileseller.movileapp.layer.data.entities.jpa.Customer;
import com.movileseller.movileapp.layer.persistence.dao.interfaces.SimleDataAccessObject;
import com.movileseller.movileapp.layer.persistence.managers.interfaces.SimpleEntityManager;

@Component (value="customerPersistenceManager")
public class CustomerPersistenceManager implements SimpleEntityManager<CustomerDTO> {

    @Autowired
    @Qualifier("customerJpaDAO")
    private SimleDataAccessObject<Customer> customerDao; 
    
    public CustomerDTO findOne(CustomerDTO dto) {
        Customer entity= dtoToEntity(dto);
        entity=customerDao.findOne(entity.getIdcustomer());
        return entityToDto(entity);
    }

    public List<CustomerDTO> findAll() {
        List <CustomerDTO> resultList=new ArrayList<CustomerDTO>();
        List<Customer> list=customerDao.findAll();
        for (Customer customer: list) {
            resultList.add(entityToDto(customer));
        }
        return resultList;
    }

    public void create(CustomerDTO dto) {
        Customer entity= dtoToEntity(dto);
        customerDao.create(entity);
    }

    public void update(CustomerDTO dto) {
        Customer entity= dtoToEntity(dto);
        customerDao.update(entity);
    }

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
