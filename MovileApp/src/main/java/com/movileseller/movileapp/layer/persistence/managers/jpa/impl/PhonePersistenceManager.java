package com.movileseller.movileapp.layer.persistence.managers.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.movileseller.movileapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.movileapp.layer.data.entities.jpa.Phone;
import com.movileseller.movileapp.layer.persistence.dao.interfaces.SimleDataAccessObject;
import com.movileseller.movileapp.layer.persistence.managers.interfaces.SimpleEntityManager;

@Component(value="phonePersistenceManager")
public class PhonePersistenceManager implements SimpleEntityManager<PhoneDTO> {

    @Autowired
    @Qualifier("phoneJpaDAO")
    private SimleDataAccessObject<Phone> phoneDao; 
    
    public PhoneDTO findOne(PhoneDTO dto) {
        Phone entity= dtoToEntity(dto);
        entity=phoneDao.findOne(entity.getIdphone());
        return entityToDto(entity);
    }

    public List<PhoneDTO> findAll() {
        List <PhoneDTO> resultList=new ArrayList<PhoneDTO>();
        List<Phone> list=phoneDao.findAll();
        for (Phone customer: list) {
            resultList.add(entityToDto(customer));
        }
        return resultList;
    }

    public void create(PhoneDTO dto) {
        Phone entity= dtoToEntity(dto);
        phoneDao.create(entity);
    }

    public void update(PhoneDTO dto) {
        Phone entity= dtoToEntity(dto);
        phoneDao.update(entity);
    }

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
