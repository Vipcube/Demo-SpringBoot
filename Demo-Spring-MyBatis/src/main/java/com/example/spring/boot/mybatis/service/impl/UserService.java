package com.example.spring.boot.mybatis.service.impl;

import com.example.spring.boot.mybatis.entity.User;
import com.example.spring.boot.mybatis.mapper.UserMapper;
import com.example.spring.boot.mybatis.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	private final UserMapper mapper;

	public UserService( UserMapper mapper ){
		this.mapper = mapper;
	}

	@Override
	public User selectById( long id ) {
		return this.mapper.selectById( id );
	}
}
