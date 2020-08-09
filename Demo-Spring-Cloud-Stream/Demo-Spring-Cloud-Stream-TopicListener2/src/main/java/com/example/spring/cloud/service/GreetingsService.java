package com.example.spring.cloud.service;

import com.example.spring.cloud.bean.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding( Sink.class )
public class GreetingsService {

	@StreamListener( Sink.INPUT )
	public void greetingListener( @Payload Greetings greetings ) {
		log.info("TopicListener2: Received greetings: {}", greetings );
	}
}
