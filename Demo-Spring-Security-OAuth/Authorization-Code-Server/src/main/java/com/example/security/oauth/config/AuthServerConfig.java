package com.example.security.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * The auth server config.
 *
 * @author Brad Chen
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.authenticationManager( authenticationManager );
	}

	@Override
	public void configure( AuthorizationServerSecurityConfigurer security ) {
		security.checkTokenAccess( "isAuthenticated()" );
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
				.accessTokenValiditySeconds( 3600 )
				.redirectUris( "http://localhost:8081/login" )
				.scopes( "account", "message", "email" )
				.resourceIds( "resource" )
				.authorizedGrantTypes( "authorization_code", "refresh_token", "password" );
	}
}
