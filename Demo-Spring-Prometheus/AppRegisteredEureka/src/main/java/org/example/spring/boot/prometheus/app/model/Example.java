package org.example.spring.boot.prometheus.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Example {
	private long id;
	private String name;
}
