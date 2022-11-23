package com.example.spring.boot.mybatis.service.impl;

import com.example.spring.boot.mybatis.entity.Log;
import com.example.spring.boot.mybatis.mapper.LogMapper;
import com.example.spring.boot.mybatis.service.ILogService;
import org.springframework.stereotype.Service;

@Service
public class LogService implements ILogService {
	private final LogMapper mapper;

	public LogService( LogMapper mapper ){
		this.mapper = mapper;
	}

	@Override
	public Log selectById( long id ) {
		return this.mapper.selectById( id );
	}
}
