package com.employee.repositories;

import java.util.List;

import com.employee.entities.Employee;

public interface EmployeeRepository 
{
	void persistEmployee(Employee employee);
	List<Employee> getEmployeeList(String status);
	void updateStatus(String status,int eid);
	List<Employee> getList();
}
