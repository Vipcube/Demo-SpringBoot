package com.example.spring.cloud.service;

import com.example.spring.cloud.bean.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Slf4j
@Service
@EnableBinding( Source.class )
public class GreetingsService {
	private final Source source;

	@Autowired
	public GreetingsService( Source source ){
		this.source = source;
	}

	public void sendGreeting( Greetings greetings ) {
		log.info("Greeting2: Sending greetings {}", greetings );
		source.output().send(
				MessageBuilder
					.withPayload( greetings )
	                .setHeader( MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build() );
	}
}
