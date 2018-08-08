package com.movileseller.orderapp.layer.business.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movileseller.orderapp.layer.business.dto.impl.PhoneDTO;
import com.movileseller.orderapp.layer.persistence.PersistenceFacade;

/**
 * 
 * The component to deal with Phone Catalog Business requirements and publish
 * result in Rest service
 *
 */
@RestController
public class PhoneCatalogBusinessManager {

	@Autowired
	private PersistenceFacade facade;

	@RequestMapping(value = "/phoneCatalog", method = {
			RequestMethod.GET }, consumes = "application/json", produces = "application/json")
	public List<PhoneDTO> getPhoneCatalog() {
		return facade.getPhonePersistenceManager().findAll();
	}
}
