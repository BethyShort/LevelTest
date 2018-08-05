package com.movileseller.movileapp.layer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movileseller.movileapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.movileapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.movileapp.layer.business.manager.PhoneCatalogBusinessManager;

@RestController
@RequestMapping ("/order")
public class PhoneCatalogService {

    @Autowired
    private PhoneCatalogBusinessManager phoneBusinessMgr;
    
    @RequestMapping (method=RequestMethod.GET)
    public List<PhoneDTO> getPhoneCatalog(OrderDTO order) {
        return phoneBusinessMgr.getPhoneCatalog();
    }
}
