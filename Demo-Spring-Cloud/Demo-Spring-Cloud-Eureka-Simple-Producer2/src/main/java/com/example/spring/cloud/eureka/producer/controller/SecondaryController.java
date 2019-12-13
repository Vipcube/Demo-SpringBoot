package com.example.spring.cloud.eureka.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller of secondary api.
 *
 * @author Brad Chen
 *
 */
@RestController
public class SecondaryController {
	@RequestMapping("/second")
	public String index( @RequestParam String name ) {
		return "Secondary "+name+"，this is producer 2 message.";
	}
}
