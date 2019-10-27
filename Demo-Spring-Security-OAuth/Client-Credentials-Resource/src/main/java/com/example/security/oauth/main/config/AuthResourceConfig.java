package com.example.security.oauth.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class AuthResourceConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure( ResourceServerSecurityConfigurer resources) {
		resources.resourceId( "resource" ).stateless( true );
	}

	@Override
	public void configure( HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/order/**")
				.access("#oauth2.hasAnyScope('account')");
	}
}
