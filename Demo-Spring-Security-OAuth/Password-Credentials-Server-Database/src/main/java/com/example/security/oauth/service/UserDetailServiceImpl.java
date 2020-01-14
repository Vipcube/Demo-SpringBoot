package com.example.security.oauth.service;

import com.example.security.oauth.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The implements of UserDetailsService.
 *
 * @author Brad Chen
 *
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
		return this.userRepository.findByUsername( username );
	}
}
