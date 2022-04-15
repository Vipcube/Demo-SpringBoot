package com.example.spring.boot.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserWithLogs {
	private long id;
	private String name;
	private Integer age;
	private List<Log> logs;
}
