package com.example.spring.cloud.sleuth.consumer.controller;

import com.example.spring.cloud.sleuth.consumer.feign.Step1FeignClient;
import com.example.spring.cloud.sleuth.consumer.feign.Step2FeignClient;
import com.example.spring.cloud.sleuth.consumer.vo.StepResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller used to call feign step api.
 *
 * @author Brad Chen
 *
 */
@RestController
public class ConsumerController {
	private final Step1FeignClient step1;
	private final Step2FeignClient step2;

	@Autowired
	public ConsumerController( Step1FeignClient step1, Step2FeignClient step2 ){
		this.step1 = step1;
		this.step2 = step2;
	}

	/**
	 * The step workflow.
	 *
	 * @param name name
	 * @return step result
	 */
	@RequestMapping("/step/{name}")
	public StepResult step(@ PathVariable("name") String name ) {
		return StepResult.builder()
				.step1( this.step1.step( name ) )
				.step2( this.step2.step( name ) )
				.build();
	}
}
