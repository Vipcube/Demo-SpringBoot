package com.example.spring.cloud.stream.config;

import com.example.spring.cloud.bean.Greetings;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

/**
 * The binging consumer pattern by functional style pattern.
 *
 * @author Brad Chen
 *
 */
@EnableBinding
public class GreetingsConsumerStreamConfig {
	/**
	 * The binding the consumer pattern with functional style. <br/>
	 * Binding topic will be same as method name, it's will be add '-in-0' to input.
	 *
	 * @return lambda function of processor
	 */
	@Bean
	public Consumer<KStream<?, Greetings>> process() {
		return input ->
				input.foreach((key, value) ->
					System.out.println("Key: " + key + " Value: " + value)
				);
	}
}
