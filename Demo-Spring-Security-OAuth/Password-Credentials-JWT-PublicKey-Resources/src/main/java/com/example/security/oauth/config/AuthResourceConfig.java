package com.example.security.oauth.config;

import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.io.IOException;

@Configuration
@EnableResourceServer
public class AuthResourceConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure( ResourceServerSecurityConfigurer resources) {
		resources
				.resourceId( "resource" )
				.stateless( true );
	}

	@Override
	public void configure( HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/order**")
				.access("#oauth2.hasAnyScope('account')");
	}
	
	//@Bean
	//public JwtAccessTokenConverter accessTokenConverter() {
	//	JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	//	Resource resource = new ClassPathResource("public.txt");
	//	String publicKey = null;
	//	try {
	//		publicKey = IOUtils.toString(resource.getInputStream());
	//	} catch (final IOException e) {
	//		throw new RuntimeException(e);
	//	}
	//	converter.setVerifierKey( publicKey );
	//	return converter;
	//}
	//
	//@Bean
	//public TokenStore tokenStore() {
	//	return new JwtTokenStore( accessTokenConverter() );
	//}
	//
	//@Bean
	//@Primary
	//public DefaultTokenServices tokenServices() {
	//	DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
	//	defaultTokenServices.setTokenStore( tokenStore() );
	//	return defaultTokenServices;
	//}
}
