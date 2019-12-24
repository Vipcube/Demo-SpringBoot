package com.example.spring.cloud.bus.config;

import com.example.spring.cloud.bus.stream.IGreetingsInputStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * The config of Streams.
 *
 * @author Brad Chen
 *
 */
@EnableBinding( IGreetingsInputStreams.class )
public class StreamsConfig {
}
