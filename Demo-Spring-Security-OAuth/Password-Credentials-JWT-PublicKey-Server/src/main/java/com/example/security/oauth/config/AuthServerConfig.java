package com.example.security.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * The auth server config.
 *
 * @author Brad Chen
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
	private static final String DEMO_RESOURCE_ID = "order";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;

	@Override
	public void configure( AuthorizationServerSecurityConfigurer oauthServer ) throws Exception {
		oauthServer
				.tokenKeyAccess( "isAuthenticated()" );
	}

	/**
	 * The OAuth client: id, secret, scope, resources, grant type.
	 *
	 * @param clients
	 * @throws Exception
	 */
	@Override
	public void configure( ClientDetailsServiceConfigurer clients ) throws Exception {
		clients.inMemory()
				.withClient( "webclient" )
				.secret( this.passwordEncoder.encode( "webclient12345678" ) )
				.scopes( "account", "message", "email" )
				.resourceIds( "resource" )
				.authorizedGrantTypes( "password", "refresh_token" );
	}

	@Override
	public void configure( AuthorizationServerEndpointsConfigurer endpoints ) {
		endpoints.accessTokenConverter( accessTokenConverter )
				.authenticationManager( authenticationManager );
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		KeyStoreKeyFactory keyStoreKeyFactory =
				new KeyStoreKeyFactory( new ClassPathResource("mytest.jks"), "mypass".toCharArray());
		converter.setKeyPair( keyStoreKeyFactory.getKeyPair("mytest") );
		return converter;
	}
}
