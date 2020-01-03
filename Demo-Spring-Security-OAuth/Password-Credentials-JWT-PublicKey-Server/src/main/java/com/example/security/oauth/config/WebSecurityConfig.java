package com.example.security.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The security config.
 *
 * @author Brad Chen
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure( HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
				.anyRequest().authenticated();
	}

	/**
	 * The username and password for GrantTypes PasswordCredentials.
	 *
	 * @param builder
	 * @throws Exception
	 */
	@Override
	protected void configure( AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication()
				.passwordEncoder( this.passwordEncoder )
				.withUser("caterpillar")
				.password( this.passwordEncoder.encode("12345678"))
				.roles( "MEMBER" );
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
