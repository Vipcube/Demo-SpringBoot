package org.example.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class RootConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer loadProperties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setFileEncoding( "UTF-8" );
		configurer.setIgnoreUnresolvablePlaceholders( true );
		return configurer;
	}
}
