package com.example.spring.cloud.ui.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The zk page controller.
 *
 * @author Brad Chen
 *
 */
@Controller
public class ZKController {
	@RequestMapping( value = "/index", method = RequestMethod.GET )
	public String root() {
		return "index";
	}
}
