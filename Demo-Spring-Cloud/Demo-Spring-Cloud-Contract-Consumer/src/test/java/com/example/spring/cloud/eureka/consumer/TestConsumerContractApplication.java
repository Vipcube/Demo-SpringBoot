package com.example.spring.cloud.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * The test program.
 *
 * @author Brad Chen
 *
 */
@SpringBootApplication
public class TestConsumerContractApplication {
	public static void main( String[] args ){
		SpringApplication.run( TestConsumerContractApplication.class, args );
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
