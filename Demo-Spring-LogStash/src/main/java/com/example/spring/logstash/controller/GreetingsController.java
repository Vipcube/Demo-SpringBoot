package com.example.spring.logstash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GreetingsController {
	
	@GetMapping("/logs")
	public void log( @RequestParam("message") String message ) {
		log.info( "GreetingsController: log with {}.", message );
    }
}
