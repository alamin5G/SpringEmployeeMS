package com.goonok.controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goonok.dao.Dao;
import com.goonok.entity.Employee;

@Controller
public class MainController {

	@Autowired
	Dao dao;

	@RequestMapping("/homepage")
	public String homePage(Model model) {

		List<Employee> list = dao.getAllEmployeeInfo();
		model.addAttribute("employeeList", list);
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

	@RequestMapping(path = "/editingEmployee/{id}")
	private String editingEmployee(@PathVariable int id, Model model) {

		Employee employee = dao.getEmployeeById(id);
		model.addAttribute("employee", employee);

		return "edit-employee";
	}

	@RequestMapping(path = "/editEmployee", method = RequestMethod.POST)
	public String editEmployee(@ModelAttribute Employee employee, HttpSession session, Model model) {
		dao.update(employee);
		session.setAttribute("msg", "Employee information updated successfully!");

		/*
		 * //show the home data List<Employee> list = dao.getAllEmployeeInfo();
		 * model.addAttribute("employeeList", list);
		 */
		return "redirect:/homepage";
	}

	@RequestMapping("/deleteingEmployee/{id}")
	public String deleteEmployee(@PathVariable int id, HttpSession session) {
		
		dao.deleteById(id);
		session.setAttribute("msgs", "user " + id  + " deleted successfully!");
		return "redirect:/homepage";
	}

}
