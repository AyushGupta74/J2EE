package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class HelloController {
	
	//@RequestMapping(value="/hello",method=RequestMethod.POST)
	//@RequestMapping("/hello")
	@GetMapping("/hello")
	public ModelAndView sayHello() {
		System.out.println("sayhello called");
		String s="Hello World from controller!!";
		return new ModelAndView("myhello","msg",s);
		
	}
	
	@GetMapping("/test")
	public String method1(Model model) {
		model.addAttribute("msg", "welcome");
		model.addAttribute("num1", 10);
		model.addAttribute("num2", 20);
		return "testaddition";
		
	}
	@GetMapping("/test2")
	public String method2() {
		
		return "testpage";
		
	}

}
