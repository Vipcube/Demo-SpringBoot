package com.example.spring.cloud.eureka.producer.controller;

import com.example.spring.cloud.eureka.producer.vo.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller of customer.
 *
 * @author Brad Chen
 *
 */
@RestController
public class CustomerController {
	@RequestMapping(path = "/api/customer")
	public Customer getCustomer() {
		return Customer.builder()
				.id( 1L )
				.name( "Petter" )
				.build();
	}
}
