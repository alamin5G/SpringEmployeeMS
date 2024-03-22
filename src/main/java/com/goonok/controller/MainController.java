package com.goonok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping("/homepage")
	public String homePage() {
		
		return "home";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee() {
		return "add-employee";
	}
}