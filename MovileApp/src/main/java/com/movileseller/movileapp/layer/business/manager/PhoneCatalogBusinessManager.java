package com.movileseller.movileapp.layer.business.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movileseller.movileapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.movileapp.layer.persistence.PersistenceFacade;

@Component
public class PhoneCatalogBusinessManager {

    @Autowired
    private PersistenceFacade facade;
    
    public List<PhoneDTO> getPhoneCatalog(){
        return facade.getPhonePersistenceManager().findAll();
    }
}
