package com.example.demo.spring.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/logs")
	public void log( @RequestParam("message") String message ) {
		this.testService.show( message );
    }
}
