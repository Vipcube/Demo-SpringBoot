package com.example.security.oauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The test user controller.
 *
 * @author Brad Chen
 *
 */
@RequestMapping("/user")
@RestController
public class UserController {
	@GetMapping("/getCurrentUser")
	public Object getCurrentUser( Authentication authentication ) {
		return authentication;
	}
}
