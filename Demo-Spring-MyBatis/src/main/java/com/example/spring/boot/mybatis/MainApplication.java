package com.example.spring.boot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan( {
		"com.example.spring.boot.mybatis.mapper"
} )
@SpringBootApplication
public class MainApplication {
	public static void main( String[] args ){
		SpringApplication.run( MainApplication.class, args );
	}
}
