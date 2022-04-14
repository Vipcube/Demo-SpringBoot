package com.example.spring.boot.mybatis.mapper;

import com.example.spring.boot.mybatis.entity.User;
import com.example.spring.boot.mybatis.entity.UserWithLogs;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	int addUser( User user );
	int updateUserById( User user );
	int deleteUserById( long id );
	User selectById( long id );
	UserWithLogs selectLeftJoinLogs( long id );
}
