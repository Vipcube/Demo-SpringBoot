package com.example.spring.cloud.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * The main program.
 *
 * @author Brad Chen
 *
 */
@EnableResourceServer
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaOAuthConsumerApplication {
	public static void main( String[] args ){
		SpringApplication.run( EurekaOAuthConsumerApplication.class, args );
	}
}
