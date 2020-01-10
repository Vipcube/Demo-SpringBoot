package com.example.spring.cloud.eureka.consumer.controller;

import com.example.spring.cloud.eureka.consumer.feign.HelloProducerRemote;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller used to call feign hello api.
 *
 * @author Brad Chen
 *
 */
@RestController
public class ConsumerController {
	public HelloProducerRemote helloProducerRemote;

	@Autowired
	public ConsumerController( HelloProducerRemote helloProducerRemote ){
		this.helloProducerRemote = helloProducerRemote;
	}

	@CircuitBreaker( name = "spring-cloud-producer", fallbackMethod = "helloFailed" )
	@RequestMapping("/hello/{name}")
	public String index(@ PathVariable("name") String name ) {
		return this.helloProducerRemote.hello( name );
	}

	public String helloFailed( String name, Throwable throwable ) {
		return "hello" + name + " this message send failed.";
	}
}
