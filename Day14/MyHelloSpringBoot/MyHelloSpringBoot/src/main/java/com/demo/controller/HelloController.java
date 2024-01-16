package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
	@GetMapping("/test")
	public String sayHello(Model m) {
		m.addAttribute("msg","Welcome to spring boot");
		return "hello";
	}

}
