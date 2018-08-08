package com.movileseller;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.movileseller.orderapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.orderapp.layer.persistence.managers.interfaces.SimpleEntityManager;
import com.movileseller.orderapp.layer.resources.cfg.AppConfig;

/**
 * Test intended to prove the PhonePersistenceManager
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {AppConfig.class})
public class ManagersPhonePersistenceTest {

	@Autowired
	@Qualifier("phonePersistenceManager")
	private SimpleEntityManager<PhoneDTO> phonePersistenceManager;

	private PhoneDTO phone;

	@Before
	public void setUp() throws Exception {
		phone = new PhoneDTO();
		phone.setPhoneId(1);
		phone.setDescription("phone description");
		phone.setPrice(BigDecimal.TEN);
		phone.setName("phone model");
	}

	@After
	public void tearDown() throws Exception {
		phone = null;
	}

	@Test
	public void testInjection() {
		Assert.assertNotNull("Error injectando la dependencia", phonePersistenceManager);
	}

	@Test
	public void testFindOne() {
		if (phonePersistenceManager != null) {
			Assert.assertNotNull(phonePersistenceManager.findOne(phone));
		}else
			Assert.fail("No se pudieron inyectar las dependencias");
	}

	@Test
	public void testFindAll() {
		if (phonePersistenceManager != null) {
			Assert.assertNotNull(phonePersistenceManager.findAll());
		}else
			Assert.fail("No se pudieron inyectar las dependencias");		
	}

	@Test
	public void testCreate() {
		if (phonePersistenceManager != null) {
			phonePersistenceManager.delete(phone);
			phonePersistenceManager.create(phone);
			Assert.assertNotNull(phonePersistenceManager.findOne(phone));
		}else
			Assert.fail("No se pudieron inyectar las dependencias");
	}

	@Test
	public void testUpdate() {
		if (phonePersistenceManager != null) {
			String oldName;
			phonePersistenceManager.findOne(phone);
			oldName = phone.getName();
			phone.setName(oldName + "Test");
			phonePersistenceManager.create(phone);
			phone = phonePersistenceManager.findOne(phone);
			Assert.assertTrue("Los nombres no coinciden, el cliente se actualizó mal",
					oldName.equalsIgnoreCase(phone.getName()));
		}else
			Assert.fail("No se pudieron inyectar las dependencias");
	}

	@Test
	public void testDelete() {
		if (phonePersistenceManager != null) {
			PhoneDTO deletedPhone;
			phone = phonePersistenceManager.findOne(phone);
			phonePersistenceManager.delete(phone);
			deletedPhone = phonePersistenceManager.findOne(phone);
			Assert.assertNull("El método de borrado no funciona correctamente", deletedPhone);
		}else
			Assert.fail("No se pudieron inyectar las dependencias");
	}
}
