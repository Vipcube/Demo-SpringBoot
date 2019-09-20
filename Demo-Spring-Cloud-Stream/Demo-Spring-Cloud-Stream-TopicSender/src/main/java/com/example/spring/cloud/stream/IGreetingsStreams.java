package com.example.spring.cloud.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface IGreetingsStreams {
	public static final String OUTPUT = "greetings-out";

	@Output( OUTPUT )
	public MessageChannel outputs();
}
