package com.example.spring.cloud.eureka.consumer.fegin;

import com.example.spring.cloud.eureka.consumer.config.FeginConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The feign client of key: spring-cloud-oauth-resource to call order api with remote oauth..
 *
 * @author Brad Chen
 *
 */
@FeignClient( name= "spring-cloud-oauth-resource" )
public interface OrderRemote {

	@RequestMapping(value = "/order")
	public String order();
}
