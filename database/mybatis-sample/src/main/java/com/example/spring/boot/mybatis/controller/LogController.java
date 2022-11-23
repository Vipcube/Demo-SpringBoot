package com.example.spring.boot.mybatis.controller;

import com.example.spring.boot.mybatis.service.ILogService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/logs" )
public class LogController {
	private final ILogService service;

	public LogController( ILogService service ){
		this.service = service;
	}

	@GetMapping( value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> selectById( @PathVariable long id ){
		return ResponseEntity.ok( this.service.selectById( id ) );
	}
}
