package com.movileseller.orderapp.layer.business.dto.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.movileseller.orderapp.layer.business.dto.interfaces.DataTransferObject;

/**
 * 
 *  Data Transfer object to represent Orders in the Business layer
 * 
 */
public class OrderDTO implements Serializable, DataTransferObject {

    private static final long serialVersionUID = 7279804835250005394L;

    private int            idOrder;
    private CustomerDTO    customer;
    private List<PhoneDTO>  customerBuyedPhones;
    private BigDecimal     orderPrice; 

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<PhoneDTO> getCustomerBuyedPhones() {
        return customerBuyedPhones;
    }

    public void setCustomerBuyedPhones(List<PhoneDTO> customerBuyedPhones) {
        this.customerBuyedPhones = customerBuyedPhones;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
