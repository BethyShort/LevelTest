package com.movileseller.movileapp.layer.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.movileseller.movileapp.layer.business.dto.impl.CustomerDTO;
import com.movileseller.movileapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.movileapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.movileapp.layer.persistence.managers.interfaces.CompoundedEntityManager;
import com.movileseller.movileapp.layer.persistence.managers.interfaces.SimpleEntityManager;

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
