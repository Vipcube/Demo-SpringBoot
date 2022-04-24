package com.example.demo.spring.docker.service.impl;

import com.example.demo.spring.docker.dto.Hello;
import com.example.demo.spring.docker.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloServiceImpl implements IHelloService {
	@Override
	public Hello hello( String name ) {
		log.info( "THelloService: log with {}.", name );
		return Hello.builder()
				.name( name )
				.build();
	}
}
