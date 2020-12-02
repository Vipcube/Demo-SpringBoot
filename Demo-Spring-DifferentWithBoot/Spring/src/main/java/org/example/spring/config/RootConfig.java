package org.example.spring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * The root configuration.
 *
 * @author Brad Chen
 *
 */
@Import( {
		ViewConfig.class
} )
@ComponentScan({
		"org.example.spring.controller"
})
@Configuration
public class RootConfig {
	/**
	 * The bean of PropertySourcesPlaceholderConfigurer.
	 *
	 * @return PropertySourcesPlaceholderConfigurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer loadProperties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setFileEncoding( "UTF-8" );
		configurer.setIgnoreUnresolvablePlaceholders( true );
		return configurer;
	}

	/**
	 * The json mapper.
	 *
	 * @return json mapper
	 */
	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}
}
