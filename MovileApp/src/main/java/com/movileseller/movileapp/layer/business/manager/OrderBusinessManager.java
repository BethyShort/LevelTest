package com.movileseller.movileapp.layer.business.manager;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movileseller.movileapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.movileapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.movileapp.layer.persistence.PersistenceFacade;

@Component
public class OrderBusinessManager {

    @Autowired
    private PersistenceFacade facade;
    
    public BigDecimal getOrderPrice(OrderDTO order) {
        BigDecimal orderPrice=calculateOrderPrice(order.getCustomerBuyedPhones());
        order.setOrderPrice(orderPrice);
        printOrder(order);
        
        return orderPrice;
    }
    
    private BigDecimal calculateOrderPrice(List<Integer> phones) {
        BigDecimal price=BigDecimal.ZERO;
        
        for (Integer phoneId: phones) {
            PhoneDTO dto=new PhoneDTO();
            dto.setPhoneId(phoneId);
            dto=facade.getPhonePersistenceManager().findOne(dto);
            price.add(dto.getPrice());
        }
        return price;
    }
    
    private void printOrder(OrderDTO order) {
        System.out.println("****************************");
        System.out.println("Order number: "+order.getIdOrder());
        System.out.println("\tCustomer Data: "+order.getIdOrder());
        System.out.println("\t-------------");
        System.out.println("\t\t: Name: "+order.getCustomer().getName());
        System.out.println("\t\t: Surname: "+order.getCustomer().getSurname());        
        System.out.println("\t\t: Id: "+order.getCustomer().getCustomerId());
        System.out.println("\t\t: Email: "+order.getCustomer().getEmail());
        System.out.println("\t\t: "+order.getCustomer().getCustomerId());
        System.out.println();
        System.out.println("\t\t: Order:");
        List<Integer> phonesList=order.getCustomerBuyedPhones();
        for (Integer phoneId: phonesList) {
            System.out.println("\tPhone Id: "+phoneId);
        }
        System.out.println("****************************");
    }
}
