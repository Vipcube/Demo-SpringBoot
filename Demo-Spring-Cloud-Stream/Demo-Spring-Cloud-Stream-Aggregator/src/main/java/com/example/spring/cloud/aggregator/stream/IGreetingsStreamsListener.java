package com.example.spring.cloud.aggregator.stream;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface IGreetingsStreamsListener {
	String INPUT = "greetings-in";

	@Input( INPUT ) KStream<?, ?> inputs();
}
