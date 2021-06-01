package com.example.spring.cloud.stream.service;

import com.example.spring.cloud.bean.Combine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {
	@StreamListener( Sink.INPUT )
	public void greetingListener( @Payload Combine combine ) {
		log.info( "Stream Consumer: Receive the message with processor: {}.", combine );
	}
}
