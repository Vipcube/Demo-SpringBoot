package com.example.security.oauth.main;

import com.example.security.oauth.config.AuthResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import( {
		AuthResourceConfig.class
} )
@SpringBootApplication
public class PasswordCredentialsResourceApp {
	public static void main( String[] args ) {
		SpringApplication.run( PasswordCredentialsResourceApp.class, args );
	}
}
