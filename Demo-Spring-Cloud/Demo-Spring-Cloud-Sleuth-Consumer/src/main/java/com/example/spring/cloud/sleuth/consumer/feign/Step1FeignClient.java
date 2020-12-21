package com.example.spring.cloud.sleuth.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The step 1 service feign client.
 *
 * @author Brad Chen
 *
 */
@FeignClient( name= "spring-cloud-sleuth-producer1" )
public interface Step1FeignClient {
	/**
	 * Call step 1 api
	 *
	 * @param name name
	 * @return step 1 message
	 */
	@RequestMapping( value = "/step1")
	String step( @RequestParam(value = "name") String name );
}
