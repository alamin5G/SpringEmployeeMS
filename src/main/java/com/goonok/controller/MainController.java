package com.goonok.controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.goonok.dao.Dao;
import com.goonok.dao.UserDao;
import com.goonok.entity.Employee;
import com.goonok.entity.User;

@Controller
public class MainController {

	@Autowired
	Dao dao;

	@Autowired
	UserDao userDao;

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
		session.setAttribute("msgs", "user " + id + " deleted successfully!");
		return "redirect:/homepage";
	}

	@RequestMapping("/registration")
	public String registerAnAccount() {

		return "register";
	}

	@RequestMapping(path = "/registration-process", method = RequestMethod.POST)
	public String registrationProcess(@ModelAttribute User user, HttpSession session) {
		userDao.registerUser(user);
		session.setAttribute("msg", "Registration is success!");
		return "redirect:/login";
	}

	@RequestMapping("/login")
	public String loginAccount() {

		return "login";
	}

	@RequestMapping(path = "login-process", method = RequestMethod.POST)
	public String loginProcess(@RequestParam("email") String eml, @RequestParam("password") String pass,
			HttpSession session) {
		User user = userDao.loginUser(eml, pass);
		if (user != null) {
			session.setAttribute("loginUser", user);
			return "redirect:/userProfile";
		} else {
			session.setAttribute("msg", "Email or Password is incorrect!");
			return "redirect:/login";
		}

	}
	
	@RequestMapping("/userProfile")
	public String userProfile() {
		
		return "user-profile";
	}
	
	@RequestMapping("/logout")
	public String userLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		session.setAttribute("msg", "Successfully Logout");
		return "redirect:/login";
	}

}
