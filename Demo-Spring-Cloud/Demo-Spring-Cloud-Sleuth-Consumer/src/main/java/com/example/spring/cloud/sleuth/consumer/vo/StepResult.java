package com.example.spring.cloud.sleuth.consumer.vo;

import lombok.Builder;
import lombok.Data;

/**
 * The value object of step result.
 *
 * @author Brad Chen
 *
 */
@Data
@Builder
public class StepResult {
	private String step1;
	private String step2;
}
