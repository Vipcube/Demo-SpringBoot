package com.example.spring.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * The main program.
 *
 * @author Brad Chen
 *
 */
@EnableWebSecurity
@EnableAdminServer
@SpringBootApplication
public class AdminServerApplication {
	public static void main( String[] args ) {
		SpringApplication.run( AdminServerApplication.class, args );
	}
}
