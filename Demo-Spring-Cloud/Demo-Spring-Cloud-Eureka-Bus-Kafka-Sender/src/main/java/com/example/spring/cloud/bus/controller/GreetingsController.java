package com.example.spring.cloud.bus.controller;

import com.example.spring.cloud.bus.bean.Greetings;
import com.example.spring.cloud.bus.service.GreetingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller of greetings.
 *
 * @author Brad Chen
 *
 */
@Slf4j
@RestController
public class GreetingsController {
	private GreetingsService service;

	@Autowired
	public GreetingsController( GreetingsService service ){
		this.service = service;
	}

	/**
	 * Send the greetings.
	 *
	 * @param message
	 */
	@GetMapping("/send-greetings")
	public void sendGreetings( @RequestParam("message") String message ){
		Greetings greetings = Greetings.builder()
				.message( message )
				.timestamp( System.currentTimeMillis() )
				.build();
		log.info( "Greeting Sender send greetings: {}", greetings );
		this.service.sendGreeting( greetings );
	}
}
