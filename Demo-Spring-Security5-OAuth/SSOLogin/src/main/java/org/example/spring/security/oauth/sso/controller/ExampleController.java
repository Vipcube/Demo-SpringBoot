package org.example.spring.security.oauth.sso.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(value = "/examples")
public class ExampleController {
	private final OAuth2AuthorizedClientService service;
	private final RestTemplate restTemplate;

	@Autowired
	public ExampleController( OAuth2AuthorizedClientService service ){
		this.service = service;
		this.restTemplate = new RestTemplate();
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) SecurityContextHolder
				.getContext()
				.getAuthentication();
		if ( Objects.nonNull( token ) ){
			log.info( "Has Token with RegistrationId: {}, Name: {}.", token.getAuthorizedClientRegistrationId(), token.getName() );
			OAuth2AuthorizedClient client = service.loadAuthorizedClient(
							token.getAuthorizedClientRegistrationId(),
							token.getName() );

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + client.getAccessToken().getTokenValue() );
			HttpEntity<?> entity = new HttpEntity<>( headers);
			return this.restTemplate.exchange( "http://localhost:10000/examples",  HttpMethod.GET, entity, String.class );
		} else {
			return ResponseEntity.status( 401 )
					.build();
		}
	}
}
