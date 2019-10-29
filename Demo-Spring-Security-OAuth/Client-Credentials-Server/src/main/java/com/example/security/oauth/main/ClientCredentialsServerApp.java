package com.example.security.oauth.main;

import com.example.security.oauth.config.AuthServerConfig;
import com.example.security.oauth.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import( {
		AuthServerConfig.class,
		WebSecurityConfig.class
} )
@SpringBootApplication
public class ClientCredentialsServerApp {
	public static void main( String[] args ) {
		SpringApplication.run( ClientCredentialsServerApp.class, args );
	}
}
