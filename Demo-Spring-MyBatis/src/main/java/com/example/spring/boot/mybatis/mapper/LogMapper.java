package com.example.spring.boot.mybatis.mapper;

import com.example.spring.boot.mybatis.entity.Log;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {
	Log selectById( long id );
}
