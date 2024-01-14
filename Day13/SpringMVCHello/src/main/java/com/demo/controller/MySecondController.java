package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cust")
public class MySecondController {
	@GetMapping("/custmer1")
	public ModelAndView sayHello() {
		System.out.println("customer called");
		String s="Hello World from customer1!!";
		return new ModelAndView("myhello","msg",s);
		
	}
	
	@GetMapping("/customer2")
	public String method1(Model model) {
		model.addAttribute("msg", "welcome to customer");
		model.addAttribute("num1", 100);
		model.addAttribute("num2", 200);
		return "testaddition";
		
	}
}
