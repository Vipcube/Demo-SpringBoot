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
	public void configure( AuthorizationServerSecurityConfigurer oauthServer ) throws Exception {
		oauthServer.checkTokenAccess( "isAuthenticated()" );
		//oauthServer
		//		.tokenKeyAccess( "isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')" ) // Expose the URL: /oauth/token_key (used by Resource Servers to decode access tokens)
		//		.checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')"); // Expose the URL: /oauth/check_token (exposes public key for token verification if using JWT tokens)
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
		endpoints.authenticationManager( authenticationManager );
	}
}
