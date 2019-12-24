package com.example.spring.cloud.bus.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * The greetings stream interface.
 *
 * @author Brad Chen
 *
 */
public interface IGreetingsStreams {
	public static final String OUTPUT = "greetings-out";

	/**
	 * Output message to message channel.
	 *
	 * @return
	 */
	@Output( OUTPUT )
	public MessageChannel outputToMessageChannel();
}
