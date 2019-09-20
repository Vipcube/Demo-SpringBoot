package com.example.demo.spring.docker;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestService {
	
	@Autowired
	private TestBean testBean;
	
	@PostConstruct
	private void init() {
		System.out.println( testBean.getMaxRoutes() );
	}
	
	public void show( String message ) {
		log.info( "TestController: log with {}, {}.", message, testBean.getMaxRoutes() );
	}
}
