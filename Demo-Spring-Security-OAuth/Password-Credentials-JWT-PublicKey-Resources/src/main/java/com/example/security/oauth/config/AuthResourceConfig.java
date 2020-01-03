package com.example.security.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
