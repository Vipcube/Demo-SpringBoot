package com.example.spring.cloud.eureka.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller of hello api.
 *
 * @author Brad Chen
 *
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String index( @RequestParam String name ) {
		return "hello "+name+"，this is producer 2 message.";
	}
}
