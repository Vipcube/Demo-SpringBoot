package com.example.spring.cloud.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.example.spring.cloud.bean.Greetings;
import com.example.spring.cloud.stream.IGreetingsStreams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GreetingsService {

	@StreamListener( IGreetingsStreams.INPUT)
	public void greetingListener( @Payload Greetings greetings ) {
		log.info("Received greetings: {}", greetings );
	}
}
