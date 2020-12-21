package com.example.spring.cloud.eureka.consumer.contract;

import com.example.spring.cloud.eureka.consumer.TestConsumerContractApplication;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The spring boot test context runner with stub runner.
 *
 * @author Brad Chen
 *
 */
public class CustomerServiceTest2 {
	private ApplicationContextRunner runner;

	@Before
	public void setUp(){
		this.runner = new ApplicationContextRunner()
				.withInitializer( new ConfigFileApplicationContextInitializer() )
				.withConfiguration( AutoConfigurations.of( TestConsumerContractApplication.class, StubConfig.class ) );
	}

	@Test
	public void test(){
		this.runner.run( context -> {
			assertThat( context )
					.getBean( RestTemplate.class )
					.extracting( restTemplate -> restTemplate.exchange( "http://localhost:9001/api/customer", HttpMethod.GET, null, String.class ).getBody() )
					.returns( true, body -> {
						System.out.println( body );
						return true;
					} );
		} );
	}

	@Configuration
	@AutoConfigureStubRunner
	public static class StubConfig {

	}
}
