package com.example.spring.cloud.stream.controller;

import com.example.spring.cloud.bean.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StreamController {
	private final Source source;

	@Autowired
	public StreamController( Source source ){
		this.source = source;
	}

	@GetMapping("/send/{name}")
	public void delegateToSource( @PathVariable String name ){
		Greetings greetings = Greetings.builder()
				.message( name )
				.timestamp( System.currentTimeMillis() )
				.build();

		log.info("Source: Sending greetings {}", greetings );
		source.output()
				.send( MessageBuilder
						.withPayload( greetings )
						.setHeader( MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON )
						.build()
				);
	}
}
