package com.movileseller;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.movileseller.orderapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.orderapp.layer.persistence.managers.interfaces.CompoundedEntityManager;
import com.movileseller.orderapp.layer.resources.cfg.AppConfig;

/**
 * Test intended to prove the PhonePersistenceManager
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {AppConfig.class})
public class ManagersOrderPersistenceTest {

	@Autowired
	@Qualifier("orderPersistenceManager")
	private CompoundedEntityManager<OrderDTO> orderPersistenceManager;

	@Mock
	private OrderDTO phone;

	@Test
	public void testInjection() {
		Assert.assertNotNull("Error injectando la dependencia", orderPersistenceManager);
	}

	@Test
	public void testFilterFind() {
		if (orderPersistenceManager != null) {
			Assert.assertNotNull(orderPersistenceManager.findByFilter(phone));
		}else
			Assert.fail("No se pudieron inyectar las dependencias");
	}

	@Test
	public void testFindAll() {
		if (orderPersistenceManager != null) {
			Assert.assertNotNull(orderPersistenceManager.findAll());
		}else
			Assert.fail("No se pudieron inyectar las dependencias");		
	}

	@Test
	public void testCreate() {
		if (orderPersistenceManager != null) {
			orderPersistenceManager.delete(phone);
			orderPersistenceManager.create(phone);
			Assert.assertNotNull(orderPersistenceManager.findByFilter(phone));
		}else
			Assert.fail("No se pudieron inyectar las dependencias");
	}

	@Test
	public void testUpdate() {
		//do stuff
		fail("not implemented test");
	}

	@Test
	public void testDelete() {
		//do stuff
		fail("not implemented test");
	}
}
