package com.example.spring.cloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The main program.
 *
 * @author Brad Chen
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientSecurityApplication {
	public static void main( String[] args ){
		SpringApplication.run( EurekaClientSecurityApplication.class, args );
	}
}
