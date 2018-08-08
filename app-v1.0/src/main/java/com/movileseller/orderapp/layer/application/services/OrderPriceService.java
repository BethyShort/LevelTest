package com.movileseller.orderapp.layer.application.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movileseller.orderapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.orderapp.layer.business.manager.OrderBusinessManager;

/**
 * Endpoint to manage customer price order
 *
 */
@RestController
public class OrderPriceService {

	@Autowired
	private OrderBusinessManager orderBusinessMgr;

	@RequestMapping(value = "/orderPrice", method = {
			RequestMethod.GET }, consumes = "application/json", produces = "application/json")
	public ResponseEntity<BigDecimal> getOrderPrice(OrderDTO order) {
		BigDecimal orderPrice = orderBusinessMgr.getOrderPrice(order);

		if (orderPrice.compareTo(BigDecimal.ZERO) >= 0) {
			order.setOrderPrice(orderPrice);
			return ResponseEntity.status(HttpStatus.OK).body(orderPrice);
		} else
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(orderPrice);

	}
}