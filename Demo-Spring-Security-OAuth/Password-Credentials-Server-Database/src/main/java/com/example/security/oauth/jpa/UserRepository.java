package com.example.security.oauth.jpa;

import com.example.security.oauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Data JPA of user entity.
 *
 * @author Brad Chen
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * Find by username.
	 *
	 * @param username
	 * @return
	 */
	public User findByUsername( String username );
}
