package com.example.spring.cloud.security.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * The resource server config.
 *
 * @author Brad Chen
 *
 */
@Configuration
@EnableResourceServer
public class AuthResourceConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure( ResourceServerSecurityConfigurer resources) {
		resources
				.resourceId( "resource" )
				.stateless( true );
	}
}
