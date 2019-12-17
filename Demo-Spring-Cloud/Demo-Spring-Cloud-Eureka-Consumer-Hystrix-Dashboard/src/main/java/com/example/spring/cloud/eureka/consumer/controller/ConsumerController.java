package com.example.spring.cloud.eureka.consumer.controller;

import com.example.spring.cloud.eureka.consumer.feign.HelloProducerRemote;
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

	@RequestMapping("/hello/{name}")
	public String index(@ PathVariable("name") String name ) {
		return this.helloProducerRemote.hello( name );
	}

	@RequestMapping("/second/{name}")
	public String second(@ PathVariable("name") String name ) {
		return this.helloProducerRemote.second( name );
	}
}
