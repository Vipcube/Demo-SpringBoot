package org.example.spring.boot.controller;

import org.example.spring.boot.vo.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller.
 *
 * @author Brad Chen
 *
 */
@RestController
public class RestExampleController {
	/**
	 * Get example.
	 *
	 * @param name name
	 * @return example
	 */
	@GetMapping( "/example/{name}" )
	public Example getExample( @PathVariable String name ){
		return Example.builder()
				.name( name )
				.build();
	}
}
