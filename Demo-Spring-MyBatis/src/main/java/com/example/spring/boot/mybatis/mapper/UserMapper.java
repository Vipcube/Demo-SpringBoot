package com.example.spring.boot.mybatis.mapper;

import com.example.spring.boot.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	User selectById( long id );
}
