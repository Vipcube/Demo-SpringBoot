package org.example.spring.security.oauth.resource.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Example {
	private long id;
	private String name;
}
