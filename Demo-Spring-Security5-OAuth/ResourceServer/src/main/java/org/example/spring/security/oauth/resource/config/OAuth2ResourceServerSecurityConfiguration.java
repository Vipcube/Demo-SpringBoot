package org.example.spring.security.oauth.resource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class OAuth2ResourceServerSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
	private String jwkSetUri;

	@Override
	protected void configure( HttpSecurity http ) throws Exception {
		http
				.authorizeRequests( requests ->
						requests
								.antMatchers("/actuator/**")
								.permitAll()
						//.antMatchers( HttpMethod.GET, "/examples/**").hasAuthority( "SCOPE_profile" )
						//.antMatchers( HttpMethod.POST, "/examples" ).hasAuthority( "SCOPE_profile" )
						.anyRequest()
						.authenticated()
				)
				.oauth2ResourceServer( OAuth2ResourceServerConfigurer::jwt );
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder
				.withJwkSetUri( this.jwkSetUri )
				.build();
	}
}
