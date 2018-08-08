package com.movileseller.movileapp.layer.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movileseller.movileapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.movileapp.layer.business.manager.OrderBusinessManager;

@RestController
@RequestMapping ("/prices")
public class PriceService {

    @Autowired
    private OrderBusinessManager orderBusinessMgr;
    
    @RequestMapping (method=RequestMethod.GET)
    public BigDecimal getOrderPrice(OrderDTO order) {
        return orderBusinessMgr.getOrderPrice(order);
    }
}