package com.example.spring.cloud.security.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

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

	/**
	 * Let resource server can decode token base on server.
	 *
	 * @param oauthServer
	 */
	@Override
	public void configure( AuthorizationServerSecurityConfigurer oauthServer ){
		oauthServer.checkTokenAccess( "isAuthenticated()" );
	}

	/**
	 * The OAuth client: id, secret, scope, resources, grant type.
	 *
	 * @param clients
	 * @throws Exception
	 */
	@Override
	public void configure( ClientDetailsServiceConfigurer clients ) throws Exception {
		//  Test with Password-Credentials & Client-Credentials
		clients.inMemory()
				.withClient( "webclient1" )
				.secret( this.passwordEncoder.encode( "webclient12345678" ) )
				.scopes( "account", "message", "email" )
				.resourceIds( "resource" )
				.authorizedGrantTypes( "password", "refresh_token" )
				.and()
				.withClient( "webclient2" )
				.secret( this.passwordEncoder.encode( "webclient12345678" ) )
				.scopes( "account", "message" )
				.resourceIds( "resource" )
				.authorizedGrantTypes( "client_credentials", "refresh_token" );
	}

	@Override
	public void configure( AuthorizationServerEndpointsConfigurer endpoints ) {
		endpoints.accessTokenConverter( accessTokenConverter )
				.authenticationManager( authenticationManager );
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey( "FEWS_KEY" );
		return converter;
	}
}
