package com.example.vipcube.spring.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * The main process
 *
 * @author Brad Chen
 */
@SpringBootApplication( exclude = { DataSourceAutoConfiguration.class } )
public class BatchSampleApplication {
	public static void main( String[] args ) {
		SpringApplication.run( BatchSampleApplication.class, args );
	}
}
