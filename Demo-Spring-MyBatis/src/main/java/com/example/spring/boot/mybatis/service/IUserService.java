package com.example.spring.boot.mybatis.service;

import com.example.spring.boot.mybatis.entity.User;
import com.example.spring.boot.mybatis.entity.UserWithLogs;

public interface IUserService {
	User selectById( long id );
	UserWithLogs selectLeftJoinLogs( long id );
}
