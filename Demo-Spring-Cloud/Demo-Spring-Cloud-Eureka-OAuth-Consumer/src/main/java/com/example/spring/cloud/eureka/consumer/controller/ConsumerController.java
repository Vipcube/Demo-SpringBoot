package com.example.spring.cloud.eureka.consumer.controller;

import com.example.spring.cloud.eureka.consumer.fegin.OrderRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller used to call feign order api.
 *
 * @author Brad Chen
 *
 */
@RestController
public class ConsumerController {
	public OrderRemote orderRemote;

	@Autowired
	public ConsumerController( OrderRemote orderRemote ){
		this.orderRemote = orderRemote;
	}

	@RequestMapping("/order")
	public String index() {
		return this.orderRemote.order();
	}
}
