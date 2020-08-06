package com.example.spring.cloud.aggregator.config;

import com.example.spring.cloud.aggregator.stream.IGreetingsStreamsListener;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding( IGreetingsStreamsListener.class )
public class KafkaStreamConfig {
}
