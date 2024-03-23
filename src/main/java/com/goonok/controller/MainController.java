package com.goonok.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goonok.dao.Dao;
import com.goonok.entity.Employee;

@Controller
public class MainController {

	@Autowired
	Dao dao;
	
	@RequestMapping("/homepage")
	public String homePage() {
		
		return "home";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee() {
		return "add-employee";
	}
	
	@RequestMapping(path = "/addingEmployee", method = RequestMethod.POST)
	private String createEmployee(@ModelAttribute Employee employee, HttpSession session) {

		int i = dao.register(employee);
		System.out.println(i + " registere success!");
		session.setAttribute("msg", "Employee Information added Successfully!");
		return "redirect:/addEmployee";
	}
}
