package com.example.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.cloud.bean.Greetings;
import com.example.spring.cloud.service.GreetingsService;

@RestController
public class GreetingsController {
	private final GreetingsService greetingsService;

	@Autowired
	public GreetingsController( GreetingsService greetingsService ){
		this.greetingsService = greetingsService;
	}
	
	@GetMapping("/greetings")
	public void greetings( @RequestParam("message") String message) {
        Greetings greetings = Greetings.builder()
                .message( message )
                .timestamp( System.currentTimeMillis() )
                .build();
        greetingsService.sendGreeting( greetings );
    }
}
