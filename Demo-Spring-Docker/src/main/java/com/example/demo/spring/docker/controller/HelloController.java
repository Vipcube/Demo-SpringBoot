package com.example.demo.spring.docker.controller;

import com.example.demo.spring.docker.service.IHelloService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
public class HelloController {
	private final IHelloService service;

	public HelloController( IHelloService service ){
		this.service = service;
	}

	@GetMapping( value = "/api/hellos/{name}" )
	public ResponseEntity<?> hello( @Validated @NotBlank @PathVariable("name") String name ) {
		return ResponseEntity.ok( this.service.hello( name ) );
    }
}
