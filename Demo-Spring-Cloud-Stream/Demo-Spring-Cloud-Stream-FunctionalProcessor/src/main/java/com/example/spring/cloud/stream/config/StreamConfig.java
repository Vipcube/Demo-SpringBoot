package com.example.spring.cloud.stream.config;

import com.example.spring.cloud.bean.Combine;
import com.example.spring.cloud.bean.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class StreamConfig {
	@Bean
	public Function<Greetings, Combine> process(){
		return greetings -> Combine.builder()
				.greetings1( greetings )
				.greetings2( Greetings.builder()
						.message( greetings.getMessage() + " Processed" )
						.timestamp( System.currentTimeMillis() )
						.build() )
				.build();
	}
}
