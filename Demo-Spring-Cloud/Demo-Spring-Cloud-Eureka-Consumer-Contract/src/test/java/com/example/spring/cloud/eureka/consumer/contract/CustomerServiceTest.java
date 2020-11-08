package com.example.spring.cloud.eureka.consumer.contract;

import com.example.spring.cloud.eureka.consumer.TestConsumerContractApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * The traditional junit 4 spring boot test with stub runner.
 *
 * @author Brad Chen
 *
 */
@RunWith( SpringRunner.class)
@SpringBootTest(
		classes = TestConsumerContractApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureStubRunner
public class CustomerServiceTest {
	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void test(){
		ResponseEntity<String> response = this.restTemplate.exchange( "http://localhost:9001/api/customer", HttpMethod.GET, null, String.class );
		System.out.println( response.getBody() );
	}
}
