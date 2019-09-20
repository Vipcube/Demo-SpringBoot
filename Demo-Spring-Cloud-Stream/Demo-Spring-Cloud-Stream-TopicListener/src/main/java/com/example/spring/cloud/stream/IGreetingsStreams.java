package com.example.spring.cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface IGreetingsStreams {
	public static final String INPUT = "greetings-in";

	@Input( INPUT )
	public SubscribableChannel inputs();
}
