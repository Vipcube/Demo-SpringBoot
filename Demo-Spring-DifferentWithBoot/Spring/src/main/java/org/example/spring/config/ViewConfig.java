package org.example.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * The view template setting for web mvc.
 *
 * @author Brad Chen
 *
 */
@Configuration
@EnableWebMvc
public class ViewConfig implements WebMvcConfigurer {
	private final ApplicationContext applicationContext;

	@Autowired
	public ViewConfig( ApplicationContext applicationContext ){
		this.applicationContext = applicationContext;
	}

	/**
	 * Template resolver.
	 *
	 * @return template resolver
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext( this.applicationContext );
		templateResolver.setPrefix( "classpath:/webapp/templates/" );
		templateResolver.setSuffix( ".html" );
		return templateResolver;
	}

	/**
	 * Template engine.
	 *
	 * @return template engine
	 */
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver( templateResolver() );
		templateEngine.setEnableSpringELCompiler (true );
		return templateEngine;
	}

	/**
	 * Template registry.
	 *
	 * @param registry template registry
	 */
	@Override
	public void configureViewResolvers( ViewResolverRegistry registry) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine( templateEngine() );
		registry.viewResolver( resolver );
	}
}
