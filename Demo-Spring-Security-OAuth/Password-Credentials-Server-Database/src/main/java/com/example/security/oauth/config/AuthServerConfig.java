package com.example.security.oauth.config;

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
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

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

	@Autowired
	private DataSource dataSource;

	@Override
	public void configure( AuthorizationServerSecurityConfigurer oauthServer ) throws Exception {
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
		//clients.jdbc( this.dataSource )
		//		.withClient( "webclient" )
		//		.secret( this.passwordEncoder.encode( "webclient12345678" ) )
		//		.scopes( "account", "message", "email" )
		//		.resourceIds( "resource" )
		//		.authorizedGrantTypes( "password", "refresh_token" )
		//		.and()
		//		.withClient( "webclient2" )
		//		.secret( this.passwordEncoder.encode( "webclient12345678" ) )
		//		.scopes( "service")
		//		.resourceIds( "service" )
		//		.authorizedGrantTypes( "password", "client_credentials" )
		//		.and()
		//		.build();
		clients.jdbc( this.dataSource )
				.passwordEncoder( this.passwordEncoder );
	}

	@Override
	public void configure( AuthorizationServerEndpointsConfigurer endpoints ) {
		endpoints
				.tokenStore( tokenStore() )
				.authenticationManager( authenticationManager );
	}

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore( this.dataSource );
	}
}
