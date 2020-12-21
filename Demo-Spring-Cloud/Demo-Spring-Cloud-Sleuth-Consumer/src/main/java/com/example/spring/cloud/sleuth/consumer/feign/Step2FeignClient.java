package com.example.spring.cloud.sleuth.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The step 2 service feign client.
 *
 * @author Brad Chen
 *
 */
@FeignClient( name= "spring-cloud-sleuth-producer2" )
public interface Step2FeignClient {
	/**
	 * Call step 2 api
	 *
	 * @param name name
	 * @return step 2 message
	 */
	@RequestMapping( value = "/step2")
	String step( @RequestParam(value = "name") String name );
}
