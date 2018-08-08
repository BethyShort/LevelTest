package com.movileseller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movileseller.movileapp.layer.business.dto.impl.CustomerDTO;
import com.movileseller.movileapp.layer.persistence.managers.interfaces.SimpleEntityManager;
import com.movileseller.movileapp.resources.cfg.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CustomerPersistenceManagerTest {
//
//	@Autowired
//	@Qualifier("customerPersistenceManager")
//	private SimpleEntityManager<CustomerDTO> customerPersistenceManager;
//
//	private CustomerDTO customer;
//
//	@Before
//	public void setUp() throws Exception {
//		customer = new CustomerDTO();
//		customer.setCustomerId(1);
//		customer.setEmail("customer@mail.com");
//		customer.setName("CustomerName");
//		customer.setSurname("CustomerSurname");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		customer = null;
//	}
//
//	@Test
//	public void testInjection() {
//		Assert.assertNotNull("Error injectando la dependencia", customerPersistenceManager);
//	}
//
//	@Test
//	public void testFindOne() {
//		if (customerPersistenceManager != null) {
//			Assert.assertNotNull(customerPersistenceManager.findOne(customer));
//		}else
//			Assert.fail("No se pudieron inyectar las dependencias");
//	}
//
//	@Test
//	public void testFindAll() {
//		if (customerPersistenceManager != null) {
//			Assert.assertNotNull(customerPersistenceManager.findAll());
//		}else
//			Assert.fail("No se pudieron inyectar las dependencias");		
//	}
//
//	@Test
//	public void testCreate() {
//		if (customerPersistenceManager != null) {
//			customerPersistenceManager.delete(customer);
//			customerPersistenceManager.create(customer);
//			Assert.assertNotNull(customerPersistenceManager.findOne(customer));
//		}else
//			Assert.fail("No se pudieron inyectar las dependencias");
//	}
//
//	@Test
//	public void testUpdate() {
//		if (customerPersistenceManager != null) {
//			String oldName;
//			customerPersistenceManager.findOne(customer);
//			oldName = customer.getName();
//			customer.setName(oldName + "Test");
//			customerPersistenceManager.create(customer);
//			customer = customerPersistenceManager.findOne(customer);
//			Assert.assertTrue("Los nombres no coinciden, el cliente se actualizó mal",
//					oldName.equalsIgnoreCase(customer.getName()));
//		}else
//			Assert.fail("No se pudieron inyectar las dependencias");
//	}
//
//	@Test
//	public void testDelete() {
//		if (customerPersistenceManager != null) {
//			CustomerDTO deletedCustomer;
//			customer = customerPersistenceManager.findOne(customer);
//			customerPersistenceManager.delete(customer);
//			deletedCustomer = customerPersistenceManager.findOne(customer);
//			Assert.assertNull("El método de borrado no funciona correctamente", deletedCustomer);
//		}else
//			Assert.fail("No se pudieron inyectar las dependencias");
//	}
}
