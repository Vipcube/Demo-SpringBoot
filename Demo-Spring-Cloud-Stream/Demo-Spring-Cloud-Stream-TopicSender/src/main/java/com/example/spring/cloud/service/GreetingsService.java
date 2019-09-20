package com.example.spring.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.example.spring.cloud.bean.Greetings;
import com.example.spring.cloud.stream.IGreetingsStreams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GreetingsService {
	@Autowired
	private IGreetingsStreams greetingsStreams;
	
	public void sendGreeting( Greetings greetings ) {
		log.info("Sending greetings {}", greetings );
		MessageChannel messageChannel = greetingsStreams.outputs();
		messageChannel.send( 
				MessageBuilder
					.withPayload( greetings )
	                .setHeader( MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build() );
	}
}
