package com.example.demo.spring.docker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class TestBean {
	@Value("${max.routes:10}")
	private int maxRoutes;
}
