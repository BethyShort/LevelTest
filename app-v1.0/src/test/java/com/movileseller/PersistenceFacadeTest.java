package com.movileseller;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.movileseller.orderapp.layer.persistence.PersistenceFacade;
import com.movileseller.orderapp.layer.resources.cfg.AppConfig;

/**
 * Test intended to prove the facade injection between service and DAO managers
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {AppConfig.class})
public class PersistenceFacadeTest {

	@Autowired
	private PersistenceFacade facade;

	@Test
	public void injectionTest() {
		Assert.assertNotNull("PersistenceFacade injection error", facade);
	}

	@Test
	public void testGetOrderPersistenceManager() {
		if (facade!=null)
			Assert.assertNotNull("OrderPersistenceManager injection error inside PersistenceFacade", facade.getOrderPersistenceManager());
		else
			fail("PersistenceFacade injection error");
	}

	@Test
	public void testGetCustomerPersistenceManager() {
		if (facade!=null)
			Assert.assertNotNull("CustomerPersistenceManager injection error inside PersistenceFacade", facade.getCustomerPersistenceManager());
		else
			fail("PersistenceFacade injection error");
	}

	@Test
	public void testGetPhonePersistenceManager() {
		if (facade!=null)
			Assert.assertNotNull("PhonePersistenceManager injection error inside PersistenceFacada", facade.getPhonePersistenceManager());
		else
			fail("PersistenceFacade injection error");
	}

}
