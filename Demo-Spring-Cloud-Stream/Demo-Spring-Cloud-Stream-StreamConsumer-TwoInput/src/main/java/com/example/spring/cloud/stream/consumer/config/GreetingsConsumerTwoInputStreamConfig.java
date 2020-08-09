package com.example.spring.cloud.stream.consumer.config;

import com.example.spring.cloud.bean.Greetings;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import java.util.function.BiConsumer;

/**
 * The binging two input consumer pattern by functional style pattern.
 *
 * @author Brad Chen
 *
 */
@EnableBinding
public class GreetingsConsumerTwoInputStreamConfig {
	/**
	 * The binding the bi consumer pattern with functional style. <br/>
	 *
	 * @return lambda function of consumer
	 */
	@Bean
	public BiConsumer<KStream<?, Greetings>, KStream<?, Greetings>> process() {
		return (greetings1, greetings2) -> {
			greetings1.foreach((key, value) ->
					System.out.println("Key: " + key + " Value: " + value)
			);

			greetings2.foreach((key, value) ->
					System.out.println("Key: " + key + " Value: " + value)
			);
		};
	}
}
