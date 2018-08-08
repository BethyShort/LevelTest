package com.movileseller.orderapp.layer.persistence.managers.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.movileseller.orderapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.orderapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.orderapp.layer.persistence.dao.interfaces.CompoundDataAccessObject;
import com.movileseller.orderapp.layer.persistence.entities.jpa.Order;
import com.movileseller.orderapp.layer.persistence.entities.jpa.OrderPK;
import com.movileseller.orderapp.layer.persistence.managers.interfaces.CompoundedEntityManager;

/**
 * Order Data Access Objects manager
 * 
 */
@Component(value="orderPersistenceManager")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderPersistenceManager implements CompoundedEntityManager<OrderDTO> {


    @Autowired
    @Qualifier("orderJpaDAO")
    private CompoundDataAccessObject<Order> orderDao; 
    
	@Override
    public List<OrderDTO> findByFilter(OrderDTO dto) {
        List <OrderDTO> resultList=new ArrayList<OrderDTO>();
        Order order=new Order();
        order.getId().setIdOrder(dto.getIdOrder());
        List<Order> list=orderDao.findByFilter(order);
        resultList.add(entityToDto(list));
        return resultList;
    }
    
	@Override
    public List<OrderDTO> findAll() {
        List <OrderDTO> resultList=new ArrayList<OrderDTO>();
        List<Order> list=orderDao.findAll();
        resultList.add(entityToDto(list));
        return resultList;
    }
    
	@Override
    public void create(OrderDTO dto) {
        List<Order> orderList= dtoToEntity(dto);
        
        for (Order order: orderList)
            orderDao.create(order);
    }

	@Override
    public void update(OrderDTO dto) {
        List<Order> orderList= dtoToEntity(dto);
        
        for (Order order: orderList)
            orderDao.update(order);
    }

	@Override
    public void delete(OrderDTO dto) {
        List<Order> orderList= dtoToEntity(dto);
        
        for (Order order: orderList)
            orderDao.delete(order);
    }

	@Override
    public void deleteByFilter(OrderDTO dto) {
        List<Order> orderList= dtoToEntity(dto);
        
        for (Order order: orderList)
            orderDao.delete(order);
    }
    
    private List<Order> dtoToEntity(OrderDTO dto) {
        List<Order> entities=new ArrayList<Order>();
        
        List<PhoneDTO> buyedPhones= dto.getCustomerBuyedPhones();
        for (PhoneDTO phone: buyedPhones) {
            Order order=new Order();
            OrderPK pk= new OrderPK();
            pk.setIdCustomer(dto.getCustomer().getCustomerId());
            pk.setIdOrder(dto.getIdOrder());
            pk.setIdPhone(phone.getPhoneId());
            order.setId(pk);
            entities.add(order);
        }
        
        return entities;
    }
    
    private OrderDTO entityToDto(List<Order> entity) {
        OrderDTO dto = new OrderDTO();
        List<PhoneDTO> buyedPhones=new ArrayList<PhoneDTO>();
        
        for (Order order: entity) {
            dto.getCustomer().setCustomerId(order.getId().getIdCustomer());
            dto.setIdOrder(order.getId().getIdOrder());
            PhoneDTO phone=new PhoneDTO();
            phone.setPhoneId(order.getId().getIdPhone());
            buyedPhones.add(phone);
        }
        
        dto.setCustomerBuyedPhones(buyedPhones);
        return dto;
    }
}
