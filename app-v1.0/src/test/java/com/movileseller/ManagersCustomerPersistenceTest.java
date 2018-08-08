package com.movileseller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.movileseller.orderapp.layer.business.dto.impl.CustomerDTO;
import com.movileseller.orderapp.layer.persistence.managers.interfaces.SimpleEntityManager;
import com.movileseller.orderapp.layer.resources.cfg.AppConfig;

/**
 * Test intended to prove the CustomerPersistenceManager
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {AppConfig.class})
public class ManagersCustomerPersistenceTest {

	@Autowired
	@Qualifier("customerPersistenceManager")
	private SimpleEntityManager<CustomerDTO> customerPersistenceManager;

	@Mock
	private CustomerDTO customer;
	
	@Test
	public void testInjection() {
		Assert.assertNotNull("Error injectando la dependencia", customerPersistenceManager);
	}

	@Test
	public void testFindOne() {
		if (customerPersistenceManager != null) {
			Assert.assertNotNull(customerPersistenceManager.findOne(customer));
		}else
			Assert.fail("No se pudieron inyectar las dependencias");
	}

	@Test
	public void testFindAll() {
		if (customerPersistenceManager != null) {
			Assert.assertNotNull(customerPersistenceManager.findAll());
		}else
			Assert.fail("No se pudieron inyectar las dependencias");		
	}

	@Test
	public void testCreate() {
		if (customerPersistenceManager != null) {
			customerPersistenceManager.delete(customer);
			customerPersistenceManager.create(customer);
			Assert.assertNotNull(customerPersistenceManager.findOne(customer));
		}else
			Assert.fail("No se pudieron inyectar las dependencias");
	}

	@Test
	public void testUpdate() {
		if (customerPersistenceManager != null) {
			String oldName;
			customerPersistenceManager.findOne(customer);
			oldName = customer.getName();
			customer.setName(oldName + "Test");
			customerPersistenceManager.create(customer);
			customer = customerPersistenceManager.findOne(customer);
			Assert.assertTrue("Los nombres no coinciden, el cliente se actualizó mal",
					oldName.equalsIgnoreCase(customer.getName()));
		}else
			Assert.fail("No se pudieron inyectar las dependencias");
	}

	@Test
	public void testDelete() {
		if (customerPersistenceManager != null) {
			CustomerDTO deletedCustomer;
			customer = customerPersistenceManager.findOne(customer);
			customerPersistenceManager.delete(customer);
			deletedCustomer = customerPersistenceManager.findOne(customer);
			Assert.assertNull("El método de borrado no funciona correctamente", deletedCustomer);
		}else
			Assert.fail("No se pudieron inyectar las dependencias");
	}
}
