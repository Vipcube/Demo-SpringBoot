package com.example.spring.boot.mybatis.service;

import com.example.spring.boot.mybatis.entity.User;

public interface IUserService {
	User selectById( long id );
}
