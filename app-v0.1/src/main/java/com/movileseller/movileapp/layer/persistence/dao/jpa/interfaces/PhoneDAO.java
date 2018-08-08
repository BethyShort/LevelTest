package com.movileseller.movileapp.layer.persistence.dao.jpa.interfaces;

import java.util.List;

import com.movileseller.movileapp.layer.data.entities.jpa.Phone;

public interface PhoneDAO {

    public Phone findOne(Object id);

    public List<Phone> findAll();

    public void create(Phone entity);

    public Phone update(Phone entity);

    public void delete(Phone entity);

    public void deleteById(Object Id);
}
