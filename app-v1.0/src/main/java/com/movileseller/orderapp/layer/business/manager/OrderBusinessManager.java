package com.movileseller.orderapp.layer.business.manager;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.movileseller.orderapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.orderapp.layer.business.dto.impl.PhoneDTO;

/**
 * 
 * The component to deal with Order Business requirements
 *
 */
@Component
public class OrderBusinessManager {

	@Value("${phoneCatalogEndpoint}")
	String catalogEndpoint;

	/**
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal getOrderPrice(OrderDTO order) {
		BigDecimal orderPrice = calculateOrderPrice(order.getCustomerBuyedPhones());
		
		if (orderPrice.compareTo(BigDecimal.ZERO) >= 0)
			printOrder(order);

		return orderPrice;
	}

	private BigDecimal calculateOrderPrice(List<PhoneDTO> phones) {
		BigDecimal price = BigDecimal.ZERO;

		for (PhoneDTO phone : phones) {
			if (validateModelAndPrice(phone))
				price.add(phone.getPrice());
			else
				return BigDecimal.ONE.negate();
		}
		return price;
	}

	private boolean validateModelAndPrice(PhoneDTO phone) {
		RestTemplate plantilla = new RestTemplate();
		PhoneDTO resultado = plantilla.getForObject(catalogEndpoint, PhoneDTO.class, phone);
		return phone.getPrice().compareTo(resultado.getPrice()) == 0;
	}

	private void printOrder(OrderDTO order) {
		System.out.println("****************************");
		System.out.println("Order number: " + order.getIdOrder());
		System.out.println("\tCustomer Data: " + order.getIdOrder());
		System.out.println("\t-------------");
		System.out.println("\t\t: Name: " + order.getCustomer().getName());
		System.out.println("\t\t: Surname: " + order.getCustomer().getSurname());
		System.out.println("\t\t: Id: " + order.getCustomer().getCustomerId());
		System.out.println("\t\t: Email: " + order.getCustomer().getEmail());
		System.out.println("\t\t: " + order.getCustomer().getCustomerId());
		System.out.println();
		System.out.println("\t\t: Order:");
		List<PhoneDTO> phonesList = order.getCustomerBuyedPhones();
		for (PhoneDTO phone : phonesList) {
			System.out.println("\tPhone Id: " + phone.getPhoneId());
		}
		System.out.println("****************************");
	}
}
