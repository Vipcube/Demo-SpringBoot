package com.example.spring.cloud.eureka.consumer.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The hystrix fallback of hello producer remote.
 *
 * @author Brad Chen
 *
 */
@Component
public class HelloProducerRemoteHystrix implements HelloProducerRemote {
	@Override
	public String hello( @RequestParam(value = "name") String name ) {
		return "hello " +name+", this message send failed.";
	}

	@Override public String second( String name ) {
		return "secondary " +name+", this message send failed.";
	}
}
