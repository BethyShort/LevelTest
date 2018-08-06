package com.movileseller.movileapp.layer.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.movileseller.movileapp.layer.business.dto.impl.CustomerDTO;
import com.movileseller.movileapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.movileapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.movileapp.layer.persistence.managers.interfaces.CompoundedEntityManager;
import com.movileseller.movileapp.layer.persistence.managers.interfaces.SimpleEntityManager;

/**
 * 
 * @author EXCC0100
 *
 */
@Component
public class PersistenceFacade {

    @Autowired
    @Qualifier("orderPersistenceManager")
    private CompoundedEntityManager<OrderDTO> orderPersistenceManager;

    @Autowired
    @Qualifier("customerPersistenceManager")
    private SimpleEntityManager<CustomerDTO> customerPersistenceManager;

    @Autowired
    @Qualifier("phonePersistenceManager")
    private SimpleEntityManager<PhoneDTO> phonePersistenceManager;

    public CompoundedEntityManager<OrderDTO> getOrderPersistenceManager() {
        return orderPersistenceManager;
    }

    public void setOrderPersistenceManager(CompoundedEntityManager<OrderDTO> orderPersistenceManager) {
        this.orderPersistenceManager = orderPersistenceManager;
    }

    public SimpleEntityManager<CustomerDTO> getCustomerPersistenceManager() {
        return customerPersistenceManager;
    }

    public void setCustomerPersistenceManager(SimpleEntityManager<CustomerDTO> customerPersistenceManager) {
        this.customerPersistenceManager = customerPersistenceManager;
    }

    public SimpleEntityManager<PhoneDTO> getPhonePersistenceManager() {
        return phonePersistenceManager;
    }

    public void setPhonePersistenceManager(SimpleEntityManager<PhoneDTO> phonePersistenceManager) {
        this.phonePersistenceManager = phonePersistenceManager;
    }
    
}
