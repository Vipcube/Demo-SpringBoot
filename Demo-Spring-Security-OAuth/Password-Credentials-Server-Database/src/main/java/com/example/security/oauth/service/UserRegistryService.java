package com.example.security.oauth.service;

/**
 * The service is used to registry user.
 *
 * @author Brad Chen
 *
 */

import com.example.security.oauth.entity.User;
import com.example.security.oauth.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistryService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Create the user.
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public User create(String username, String password) {
		String hash = passwordEncoder.encode(password);

		User user = new User();
		user.setUsername(username);
		user.setPassword(hash);
		return userRepository.save(user);
	}
}
