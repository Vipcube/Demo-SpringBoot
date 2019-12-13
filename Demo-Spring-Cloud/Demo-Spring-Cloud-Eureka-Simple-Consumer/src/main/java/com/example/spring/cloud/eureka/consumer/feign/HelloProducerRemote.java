package com.example.spring.cloud.eureka.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The feign client of key: spring-cloud-producer to call hello and second api with remote.
 * If key: spring-cloud-producer of hello and second api is down, will call the fallback class.
 *
 * @author Brad Chen
 *
 */
@FeignClient( name= "spring-cloud-producer", fallback = HelloProducerRemoteHystrix.class )
public interface HelloProducerRemote {

	@RequestMapping(value = "/hello")
	public String hello( @RequestParam(value = "name") String name );

	@RequestMapping(value = "/second")
	public String second( @RequestParam(value = "name") String name );
}
