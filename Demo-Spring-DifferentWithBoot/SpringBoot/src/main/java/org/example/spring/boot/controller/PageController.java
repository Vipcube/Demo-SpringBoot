package org.example.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The page controller the return view.
 *
 * @author Brad Chen
 *
 */
@Controller
public class PageController {
	/**
	 * The root mapping of index.
	 *
	 * @param model view model
	 * @return index
	 */
	@GetMapping("/")
	public String index( Model model ){
		model.addAttribute( "name", "Brad" );
		return "index";
	}
}
