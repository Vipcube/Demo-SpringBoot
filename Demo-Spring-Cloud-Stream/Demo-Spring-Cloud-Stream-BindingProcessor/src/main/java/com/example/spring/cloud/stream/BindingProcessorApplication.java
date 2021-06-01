package com.example.spring.cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

@EnableBinding( Processor.class )
@SpringBootApplication
public class BindingProcessorApplication {
	public static void main( String[] args ) {
		SpringApplication.run( BindingProcessorApplication.class, args);
	}
}
