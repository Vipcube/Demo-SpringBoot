package com.example.spring.boot.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Log {
	private long id;
	private long userId;
	private String action;
	private OffsetDateTime createTime;
}
