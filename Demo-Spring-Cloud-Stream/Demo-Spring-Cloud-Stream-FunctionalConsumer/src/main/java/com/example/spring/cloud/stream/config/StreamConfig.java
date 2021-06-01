package com.example.spring.cloud.stream.config;

import com.example.spring.cloud.bean.Combine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class StreamConfig {
	@Bean
	public Consumer<Combine> consumer(){
		return vo -> log.info( "Stream Consumer: Receive the message with processor: {}.", vo );
	}
}
