package com.example.spring.cloud.sleuth.producer1;

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
public class SleuthProducer1Application {
	public static void main( String[] args ){
		SpringApplication.run( SleuthProducer1Application.class, args );
	}
}
