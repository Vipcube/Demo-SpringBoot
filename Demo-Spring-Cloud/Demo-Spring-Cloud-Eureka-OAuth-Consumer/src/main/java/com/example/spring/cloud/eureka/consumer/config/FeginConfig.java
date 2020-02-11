package com.example.spring.cloud.eureka.consumer.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Configuration
public class FeginConfig {
	private final String AUTHORIZATION_HEADER = "Authorization";

	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {
		return requestTemplate -> {
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			Optional<String> opt = Optional.ofNullable( request.getHeader(AUTHORIZATION_HEADER) );
			opt.ifPresent( authorization -> requestTemplate.header( AUTHORIZATION_HEADER, authorization) );
		};
	}
}
