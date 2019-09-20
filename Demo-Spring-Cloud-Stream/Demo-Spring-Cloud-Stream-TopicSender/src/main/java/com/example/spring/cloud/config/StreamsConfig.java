package com.example.spring.cloud.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.example.spring.cloud.stream.IGreetingsStreams;

@EnableBinding( IGreetingsStreams.class )
public class StreamsConfig {

}
