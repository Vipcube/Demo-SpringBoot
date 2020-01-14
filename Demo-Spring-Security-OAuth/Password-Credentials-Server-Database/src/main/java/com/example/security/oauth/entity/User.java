package com.example.security.oauth.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * The user entity.
 *
 * @author Brad Chen
 *
 */
@Data
@ToString( exclude = { "authorities" } )
@EqualsAndHashCode( exclude = { "authorities" } )
@Entity
public class User implements UserDetails, Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column
	private String password;

	@ManyToMany(
			cascade = CascadeType.ALL, fetch = FetchType.EAGER
	)
	@JoinTable( name = "user_role",
			joinColumns = @JoinColumn( name = "user_id", referencedColumnName = "id" ),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id" )
	)
	private List<Role> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
