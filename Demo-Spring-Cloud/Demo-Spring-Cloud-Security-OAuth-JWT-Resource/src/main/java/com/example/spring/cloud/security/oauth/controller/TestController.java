package com.example.spring.cloud.security.oauth.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The test controller.
 *
 * @author Brad Chen
 *
 */
@RestController
public class TestController {
	@GetMapping( value = "/order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<String> getOrder() {
		return ResponseEntity.ok( "{ \"hello\": \"world\"}" );
	}
}
