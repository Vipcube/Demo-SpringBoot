package com.example.spring.boot.mybatis.service.impl;

import com.example.spring.boot.mybatis.entity.User;
import com.example.spring.boot.mybatis.entity.UserWithLogs;
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
	public long addUser( User user ) {
		this.mapper.addUser( user );
		return user.getId();
	}

	@Override
	public long updateUserById( User user ) {
		this.mapper.updateUserById( user );
		return user.getId();
	}

	@Override
	public long deleteUserById( long id ) {
		this.mapper.deleteUserById( id );
		return id;
	}

	@Override
	public User selectById( long id ) {
		return this.mapper.selectById( id );
	}

	@Override
	public UserWithLogs selectLeftJoinLogs( long id ) {
		return this.mapper.selectLeftJoinLogs( id );
	}
}
