package com.example.spring.cloud.stream.config;

import com.example.spring.cloud.bean.Greetings;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

/**
 * The binging processor pattern by functional style pattern.
 *
 * @author Brad Chen
 *
 */
@EnableBinding
public class GreetingsProcessStreamConfig {
	/**
	 * The binding the processor pattern with functional style. <br/>
	 * Binding topic will be same as method name, it's will be add '-in-0' to input and '-out-0' to output.
	 *
	 * @return lambda function of processor
	 */
	@Bean
	public Function<KStream<?, Greetings>, KStream<?, Greetings>> process() {
		return input -> input
				.map( (key, value) ->
					KeyValue.pair( null,
							Greetings.builder()
									.timestamp( value.getTimestamp() )
									.message( value.getMessage() + " Processed" )
									.build()
					)
		);
	}
}
