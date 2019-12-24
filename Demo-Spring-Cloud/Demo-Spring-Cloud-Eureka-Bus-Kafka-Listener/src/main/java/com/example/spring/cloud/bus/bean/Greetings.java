package com.example.spring.cloud.bus.bean;

import lombok.Builder;
import lombok.Data;

/**
 * The bean of greetings.
 *
 * @author Brad Chen
 *
 */
@Builder
@Data
public class Greetings {
	private long timestamp;
	private String message;

	public Greetings(long timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}
}
