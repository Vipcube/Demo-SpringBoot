package com.example.spring.cloud.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Combine {
	private Greetings greetings1;
	private Greetings greetings2;
}
