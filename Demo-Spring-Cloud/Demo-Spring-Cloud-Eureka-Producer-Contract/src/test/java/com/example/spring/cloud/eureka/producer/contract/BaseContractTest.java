package com.example.spring.cloud.eureka.producer.contract;

import com.example.spring.cloud.eureka.producer.controller.CustomerController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

/**
 * The contract base class.
 *
 * @author Brad Chen
 *
 */
public abstract class BaseContractTest {
	@Before
	public void setup(){
		RestAssuredMockMvc.standaloneSetup( new CustomerController() );
	}
}
