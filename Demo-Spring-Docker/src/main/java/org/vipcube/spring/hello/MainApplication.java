package org.vipcube.spring.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan( basePackages = {
	"com.example.demo.spring.docker"
})
@SpringBootApplication
public class MainApplication {

	public static void main( String[] args ) {
		SpringApplication.run( MainApplication.class, args);
	}

}
