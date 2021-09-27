package org.example.spring.security.oauth.sso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * If you want to allow endpoints, use this class. otherwise, auto-config is enough.
 */
@Configuration
public class OAuth2SSOSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure( HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers( "/actuator/**" )
				.permitAll()
				.anyRequest().authenticated()
				.and()
				.oauth2Login();
	}
}
