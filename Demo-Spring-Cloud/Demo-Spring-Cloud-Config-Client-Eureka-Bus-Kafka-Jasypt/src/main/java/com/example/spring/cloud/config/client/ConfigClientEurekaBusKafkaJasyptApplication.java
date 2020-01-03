package com.example.spring.cloud.config.client;

import com.ulisesbocchio.jasyptspringboot.environment.StandardEncryptableEnvironment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The main program.
 *
 * @author Brad Chen
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientEurekaBusKafkaJasyptApplication {
	public static void main( String[] args ) {
		// SpringApplication.run( ConfigClientEurekaBusKafkaJasyptApplication.class, args );
		/**
		 * If use SpringApplication.run, when the spring cloud bus refresh,
		 * the copy spring boot environment not contain the jasypt encryptor, so after refresh can't decrypt the properties.
		 *
		 * Need to used the custom environment with spring builder to avoid it.
		 */
		new SpringApplicationBuilder()
				.environment( new StandardEncryptableEnvironment() )
				.sources( ConfigClientEurekaBusKafkaJasyptApplication.class ).run(args);
	}
}
