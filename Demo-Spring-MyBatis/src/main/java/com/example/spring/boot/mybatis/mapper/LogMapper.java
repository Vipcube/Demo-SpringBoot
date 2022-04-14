package com.example.spring.boot.mybatis.mapper;

import com.example.spring.boot.mybatis.entity.Log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
	Log selectById( long id );
}
