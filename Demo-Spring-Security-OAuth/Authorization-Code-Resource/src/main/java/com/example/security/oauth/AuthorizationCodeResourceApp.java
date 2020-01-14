package com.example.security.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * The main program.
 *
 * @author Brad Chen
 *
 */
@EnableOAuth2Sso
@SpringBootApplication
public class AuthorizationCodeResourceApp {
	public static void main( String[] args ) {
		SpringApplication.run( AuthorizationCodeResourceApp.class, args );
	}
}
