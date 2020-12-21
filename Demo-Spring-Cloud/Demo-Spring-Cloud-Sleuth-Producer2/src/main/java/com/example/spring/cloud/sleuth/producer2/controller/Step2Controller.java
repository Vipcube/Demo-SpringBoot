package com.example.spring.cloud.sleuth.producer2.controller;

/**
 * The rest controller of step 2 api.
 *
 * @author Brad Chen
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Step2Controller {
	@RequestMapping( "/step2" )
	public String step( @RequestParam String name ) {
		return "hello "+name+"，this is step2 message.";
	}
}
