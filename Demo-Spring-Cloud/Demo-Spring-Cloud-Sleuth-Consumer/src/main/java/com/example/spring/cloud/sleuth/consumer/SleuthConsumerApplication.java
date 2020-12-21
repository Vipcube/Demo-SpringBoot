package com.example.spring.cloud.sleuth.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The main program.
 *
 * @author Brad Chen
 *
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SleuthConsumerApplication {
	public static void main( String[] args ){
		SpringApplication.run( SleuthConsumerApplication.class, args );
	}
}
