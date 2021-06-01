package com.example.spring.cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding( Source.class )
@SpringBootApplication
public class BindingSourceApplication {
	public static void main( String[] args ) {
		SpringApplication.run( BindingSourceApplication.class, args);
	}
}
