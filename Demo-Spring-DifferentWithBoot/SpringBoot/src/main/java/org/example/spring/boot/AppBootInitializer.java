package org.example.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main program.
 *
 * @author Brad Chen
 *
 */
@SpringBootApplication
public class AppBootInitializer {
	public static void main( String[] args ){
		SpringApplication.run( AppBootInitializer.class, args );
	}
}
