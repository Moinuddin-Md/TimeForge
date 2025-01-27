package com.employee.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.Employee;
import com.employee.repositories.EmployeeRepository;
import com.employee.services.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired private EmployeeRepository employeeRepository;
	private Session session;

	public void addEmployee(Employee employee) 
	{
		employeeRepository.persistEmployee(employee);
	}

	public List<Employee> getList(String status) 
	{
		return employeeRepository.getEmployeeList(status);
	}

//	@Override
//	public List<Employee> getList() {
//		
//		Query<Employee> query=session.createQuery("from Employee",Employee.class);
//		return query.list();
//	}
}
