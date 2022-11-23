package org.example.spring.security.oauth.resource.controller;

import org.example.spring.security.oauth.resource.model.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@PreAuthorize( "hasAuthority('SCOPE_profile')" )
@RestController
@RequestMapping(value = "/examples")
public class ExampleController {
	private final List<Example> examples = new ArrayList<>();

	public ExampleController(){
		this.examples.add( Example.builder().id( 1L ).name( "example 1" ).build() );
		this.examples.add( Example.builder().id( 2L ).name( "example 2" ).build() );
		this.examples.add( Example.builder().id( 3L ).name( "example 3" ).build() );
		this.examples.add( Example.builder().id( 4L ).name( "example 4" ).build() );
	}

	@GetMapping(value = "/{id}")
	public Example findOne( @PathVariable Long id ) {
		return this.examples.stream()
				.filter( example -> example.getId() == id )
				.findFirst()
				.orElse( Example.builder().id( 0L ).name( "not found example" ).build() );
	}

	@GetMapping
	public List<Example> findAll() {
		return this.examples;
	}
}
