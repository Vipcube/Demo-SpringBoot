package com.example.security.oauth.controller;

import com.example.security.oauth.entity.User;
import com.example.security.oauth.service.UserRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The user controller.
 *
 * @author Brad Chen
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRegistryService userRegistryService;

	@RequestMapping(value = "/registry", method = RequestMethod.POST)
	public User createUser(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		return userRegistryService.create(username,password);
	}
}
