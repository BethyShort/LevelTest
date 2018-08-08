package com.movileseller.orderapp.layer.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.movileseller.orderapp.layer.business.dto.impl.CustomerDTO;
import com.movileseller.orderapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.orderapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.orderapp.layer.persistence.managers.interfaces.CompoundedEntityManager;
import com.movileseller.orderapp.layer.persistence.managers.interfaces.SimpleEntityManager;

/**
 * 
 * Facade to isolate database access from business layer
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

    public SimpleEntityManager<CustomerDTO> getCustomerPersistenceManager() {
        return customerPersistenceManager;
    }

    public SimpleEntityManager<PhoneDTO> getPhonePersistenceManager() {
        return phonePersistenceManager;
    }
}
