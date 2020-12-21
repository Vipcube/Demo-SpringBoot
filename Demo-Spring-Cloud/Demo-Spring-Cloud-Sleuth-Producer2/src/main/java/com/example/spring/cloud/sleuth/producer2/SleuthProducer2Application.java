package com.example.spring.cloud.sleuth.producer2;

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
public class SleuthProducer2Application {
	public static void main( String[] args ){
		SpringApplication.run( SleuthProducer2Application.class, args );
	}
}
