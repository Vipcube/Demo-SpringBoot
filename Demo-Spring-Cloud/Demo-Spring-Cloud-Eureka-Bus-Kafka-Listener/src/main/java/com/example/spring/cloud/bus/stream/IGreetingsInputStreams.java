package com.example.spring.cloud.bus.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * The greetings stream interface.
 *
 * @author Brad Chen
 *
 */
public interface IGreetingsInputStreams {
	public static final String INPUT = "greetings-in";

	/**
	 * Receive message from message channel.
	 *
	 * @return
	 */
	@Input( INPUT )
	public SubscribableChannel fromMessageChannel();
}
