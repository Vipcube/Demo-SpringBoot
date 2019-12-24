package com.example.spring.cloud.bus;

import com.example.spring.cloud.bus.stream.IGreetingsStreams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * The main program.
 *
 * @author Brad Chen
 *
 */
@EnableBinding( IGreetingsStreams.class )
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaBusKafkaSenderApplication {
	public static void main( String[] args ) {
		SpringApplication.run( EurekaBusKafkaSenderApplication.class, args);
	}
}
