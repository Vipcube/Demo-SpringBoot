package com.example.spring.cloud.eureka.producer.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The value object of customer.
 *
 * @author Brad Chen
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private Long id;
	private String name;
}
