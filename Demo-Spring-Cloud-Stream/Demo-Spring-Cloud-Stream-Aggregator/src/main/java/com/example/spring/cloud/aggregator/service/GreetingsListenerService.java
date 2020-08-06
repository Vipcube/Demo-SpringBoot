package com.example.spring.cloud.aggregator.service;

import com.example.spring.cloud.aggregator.stream.IGreetingsStreamsListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@Service
public class GreetingsListenerService {
	@Bean
	@StreamListener( IGreetingsStreamsListener.INPUT )
	public Consumer<KStream<Object, String>> greetingListenerProcess() {
		return input ->
				input.foreach((key, value) ->
						log.info( "key: {}, value: {}", key, value )
				);
	}
}
