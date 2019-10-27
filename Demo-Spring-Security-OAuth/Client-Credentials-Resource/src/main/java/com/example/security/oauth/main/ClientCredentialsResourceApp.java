package com.example.security.oauth.main;

import com.example.security.oauth.main.config.AuthResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import( {
		AuthResourceConfig.class
} )
@SpringBootApplication
public class ClientCredentialsResourceApp {
	public static void main( String[] args ) {
		SpringApplication.run( ClientCredentialsResourceApp.class, args );
	}
}
