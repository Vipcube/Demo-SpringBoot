package com.example.vipcube.spring.batch.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
	private String brand;
	private String assetNo;
	private String category;
}
