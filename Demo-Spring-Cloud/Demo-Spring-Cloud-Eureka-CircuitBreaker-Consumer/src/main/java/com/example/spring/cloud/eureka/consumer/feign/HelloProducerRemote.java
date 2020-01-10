package com.example.spring.cloud.eureka.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The feign client of key: spring-cloud-producer to call hello and second api with remote.
 * If key: spring-cloud-producer of hello and second api is down, will call the fallback method.
 *
 * @author Brad Chen
 *
 */
@FeignClient( name= "spring-cloud-producer" )
public interface HelloProducerRemote {

	@RequestMapping(value = "/hello")
	public String hello( @RequestParam( value = "name" ) String name );
}
