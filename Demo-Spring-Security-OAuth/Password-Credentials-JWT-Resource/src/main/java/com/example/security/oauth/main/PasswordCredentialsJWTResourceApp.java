package com.example.security.oauth.main;

import com.example.security.oauth.config.AuthResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import( {
		AuthResourceConfig.class
} )
@ComponentScan( basePackages = { "com.example.security.oauth.controller" })
@SpringBootApplication
public class PasswordCredentialsJWTResourceApp {
	public static void main( String[] args ) {
		SpringApplication.run( PasswordCredentialsJWTResourceApp.class, args );
	}
}