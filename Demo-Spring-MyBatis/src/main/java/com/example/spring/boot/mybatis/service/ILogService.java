package com.example.spring.boot.mybatis.service;

import com.example.spring.boot.mybatis.entity.Log;

public interface ILogService {
	Log selectById( long id );
}
