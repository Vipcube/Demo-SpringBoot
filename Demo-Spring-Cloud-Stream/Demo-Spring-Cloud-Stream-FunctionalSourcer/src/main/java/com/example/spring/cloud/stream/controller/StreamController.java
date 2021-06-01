package com.example.spring.cloud.stream.controller;

import com.example.spring.cloud.bean.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StreamController {
	private final StreamBridge bridge;

	@Autowired
	public StreamController( StreamBridge bridge ){
		this.bridge = bridge;
	}

	@GetMapping("/send/{name}")
	public void delegateToSource( @PathVariable String name ){
		this.bridge.send( "source-out-0", Greetings.builder()
				.message( name )
				.timestamp( System.currentTimeMillis() )
				.build()
		);
	}
}
