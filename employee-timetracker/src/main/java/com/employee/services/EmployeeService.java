package com.employee.services;

import java.util.List;

import com.employee.entities.Employee;

public interface EmployeeService 
{
	void addEmployee(Employee employee);
	List<Employee> getList(String status);
//	List<Employee> getList();
}
