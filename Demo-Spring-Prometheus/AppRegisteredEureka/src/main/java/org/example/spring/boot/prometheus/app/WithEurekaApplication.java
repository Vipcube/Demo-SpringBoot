package org.example.spring.boot.prometheus.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WithEurekaApplication {
	public static void main( String[] args ){
		SpringApplication.run(WithEurekaApplication.class, args );
	}
}
