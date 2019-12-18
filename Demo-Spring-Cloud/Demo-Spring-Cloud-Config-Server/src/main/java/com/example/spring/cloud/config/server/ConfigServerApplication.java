package com.example.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * The main program.
 *
 * @author Brad Chen
 *
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {
	public static void main( String[] args ) {
			SpringApplication.run( ConfigServerApplication.class, args );
	}
}
