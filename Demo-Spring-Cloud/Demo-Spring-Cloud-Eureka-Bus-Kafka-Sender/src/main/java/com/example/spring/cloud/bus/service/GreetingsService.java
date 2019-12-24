package com.example.spring.cloud.bus.service;

import com.example.spring.cloud.bus.bean.Greetings;
import com.example.spring.cloud.bus.stream.IGreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * The service user to send greetings to message channel.
 *
 * @author Brad Chen
 *
 */
@Slf4j
@Service
public class GreetingsService {
	private IGreetingsStreams greetingsStreams;

	@Autowired
	public GreetingsService( IGreetingsStreams greetingsStreams ){
		this.greetingsStreams = greetingsStreams;
	}

	/**
	 * The send greetings to message channel.
	 *
	 * @param greetings
	 */
	public void sendGreeting( Greetings greetings ) {
		log.info("Sending greetings {}", greetings );
		MessageChannel messageChannel = greetingsStreams.outputToMessageChannel();
		messageChannel.send(
				MessageBuilder
						.withPayload( greetings )
						.setHeader( MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON )
						.build() );
	}
}
