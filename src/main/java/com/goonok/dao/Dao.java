package com.goonok.dao;

import java.util.List;


import com.goonok.entity.Employee;


public interface Dao {

	public int register(Employee employee);
	
	public void update(Employee employee);
	
	public Employee getEmployeeById(int id);
	
	public List<Employee> getAllEmployeeInfo();
	
	public void deleteById(int id);
	
}
