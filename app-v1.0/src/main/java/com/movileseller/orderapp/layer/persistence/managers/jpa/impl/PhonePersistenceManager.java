package com.movileseller.orderapp.layer.persistence.managers.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.movileseller.orderapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.orderapp.layer.persistence.dao.interfaces.SimpleDataAccessObject;
import com.movileseller.orderapp.layer.persistence.entities.jpa.Phone;
import com.movileseller.orderapp.layer.persistence.managers.interfaces.SimpleEntityManager;

/**
 * Phone Data Access Objects manager
 * 
 */
@Component(value="phonePersistenceManager")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PhonePersistenceManager implements SimpleEntityManager<PhoneDTO> {

    @Autowired
    @Qualifier("phoneJpaDAO")
    private SimpleDataAccessObject<Phone> phoneDao; 
    
    @Override
    public PhoneDTO findOne(PhoneDTO dto) {
        Phone entity= dtoToEntity(dto);
        entity=phoneDao.findOne(entity.getIdphone());
        return entityToDto(entity);
    }
    
    @Override
    public List<PhoneDTO> findAll() {
        List <PhoneDTO> resultList=new ArrayList<PhoneDTO>();
        List<Phone> list=phoneDao.findAll();
        for (Phone customer: list) {
            resultList.add(entityToDto(customer));
        }
        return resultList;
    }

    @Override
    public void create(PhoneDTO dto) {
        Phone entity= dtoToEntity(dto);
        phoneDao.create(entity);
    }

    @Override
    public void update(PhoneDTO dto) {
        Phone entity= dtoToEntity(dto);
        phoneDao.update(entity);
    }

    @Override
    public void delete(PhoneDTO dto) {
        Phone entity= dtoToEntity(dto);
        phoneDao.delete(entity);
    }

    private Phone dtoToEntity(PhoneDTO dto) {
        Phone entity=new Phone();
        entity.setIdphone(dto.getPhoneId());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        return entity;
    }
    
    private PhoneDTO entityToDto(Phone entity) {
        PhoneDTO dto = new PhoneDTO();
        dto.setPhoneId(entity.getIdphone());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
