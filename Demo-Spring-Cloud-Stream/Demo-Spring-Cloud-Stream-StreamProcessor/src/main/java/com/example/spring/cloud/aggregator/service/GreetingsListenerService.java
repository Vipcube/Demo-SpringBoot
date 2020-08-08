package com.example.spring.cloud.aggregator.service;

import com.example.spring.cloud.bean.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.kafka.streams.annotations.KafkaStreamsProcessor;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding( { KafkaStreamsProcessor.class } )
public class GreetingsListenerService {

	@StreamListener( Processor.INPUT )
	@SendTo( Processor.OUTPUT )
	public KStream<?, Greetings> greetingProcess( KStream<?, Greetings> input ) {
		return input.map( (key, value) ->
				KeyValue.pair( null,
						Greetings.builder()
							.timestamp( value.getTimestamp() )
							.message( value.getMessage() + " Processed" )
							.build()
				)
		);
	}
}
