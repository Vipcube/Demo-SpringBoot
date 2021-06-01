package com.example.spring.cloud.stream.service;

import com.example.spring.cloud.bean.Combine;
import com.example.spring.cloud.bean.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessorService {
	@StreamListener( Processor.INPUT )
	@SendTo( Processor.OUTPUT )
	public Combine process( Greetings greetings ){
		return Combine.builder()
				.greetings1( greetings )
				.greetings2( Greetings.builder()
						.message( greetings.getMessage() + " Processed" )
						.timestamp( System.currentTimeMillis() )
						.build() )
				.build();
	}
}
