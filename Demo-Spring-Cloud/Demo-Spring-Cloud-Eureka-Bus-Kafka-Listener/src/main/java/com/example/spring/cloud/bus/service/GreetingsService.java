package com.example.spring.cloud.bus.service;

import com.example.spring.cloud.bus.bean.Greetings;
import com.example.spring.cloud.bus.stream.IGreetingsInputStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * The service use to receive greetings message from message channel.
 *
 * @author Brad Chen
 *
 */
@Slf4j
@Service
public class GreetingsService {
	/**
	 * Listen the greetings message from the message channel.
	 *
	 * @param greetings
	 */
	@StreamListener( IGreetingsInputStreams.INPUT )
	public void greetingListener( @Payload Greetings greetings ) {
		log.info( "Greeting Listener Received greetings: {}", greetings );
	}
}
