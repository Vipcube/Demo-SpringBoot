package org.example.spring;

import org.example.spring.config.RootConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppBootInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup( ServletContext servletContext ) throws ServletException {
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register( RootConfig.class );
		ac.refresh();

		DispatcherServlet servlet = new DispatcherServlet( ac );
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet );
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}
}
