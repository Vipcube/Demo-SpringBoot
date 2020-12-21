package com.example.spring.cloud.sleuth.producer1.controller;

/**
 * The rest controller of step 1 api.
 *
 * @author Brad Chen
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Step1Controller {
	@RequestMapping( "/step1" )
	public String step( @RequestParam String name ) {
		return "Hey "+name+"，this is step1 message.";
	}
}
