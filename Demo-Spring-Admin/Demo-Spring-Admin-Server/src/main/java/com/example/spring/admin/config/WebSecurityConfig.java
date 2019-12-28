package com.example.spring.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final String adminContextPath;

	public WebSecurityConfig(AdminServerProperties adminServerProperties) {
		this.adminContextPath = adminServerProperties.getContextPath();
	}

	@Override
	protected void configure( HttpSecurity http ) throws Exception {
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter( "redirectTo" );
		successHandler.setDefaultTargetUrl( this.adminContextPath + "/" );

		http.authorizeRequests()
				.antMatchers( this.adminContextPath + "/login" )
				.permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage( this.adminContextPath + "/login" ).successHandler( successHandler )
				.and()
				.logout().logoutUrl( this.adminContextPath + "/logout" )
				.and()
				.httpBasic()
				.and()
				.csrf()
				.csrfTokenRepository( CookieCsrfTokenRepository.withHttpOnlyFalse() )
				.ignoringAntMatchers(
						this.adminContextPath + "/instances",
						this.adminContextPath + "/actuator/**"
				);
	}
}
