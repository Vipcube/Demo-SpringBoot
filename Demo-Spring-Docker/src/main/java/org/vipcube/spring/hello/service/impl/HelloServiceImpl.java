package org.vipcube.spring.hello.service.impl;

import org.vipcube.spring.hello.dto.Hello;
import org.vipcube.spring.hello.service.IHelloService;
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
