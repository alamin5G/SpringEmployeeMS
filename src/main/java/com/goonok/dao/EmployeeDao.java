package com.goonok.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goonok.entity.Employee;

@Component
public class EmployeeDao implements Dao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional //we use @Transactional annotation for write purpose only. by default it is in write mode
	@Override
	public int register(Employee employee) {
		int i = (int) hibernateTemplate.save(employee);
		return i;
	}

	@Transactional
	@Override
	public void update(Employee employee) {
		hibernateTemplate.update(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = hibernateTemplate.get(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployeeInfo() {
		List<Employee> list = hibernateTemplate.loadAll(Employee.class);
		return list;
	}

	@Transactional 
	@Override
	public void deleteById(int id) {
		Employee employee = hibernateTemplate.get(Employee.class, id);
		hibernateTemplate.delete(employee);
	}

}
