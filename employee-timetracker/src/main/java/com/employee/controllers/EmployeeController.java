package com.employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.entities.Employee;
import com.employee.services.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("employee/add")
	public String getAddEmployeeView()
	{
		return "employee/add-employee";
	}
	@PostMapping("employee/save-record")
	public String saveEmployee(Employee employee)
	{
		employeeService.addEmployee(employee);
		return "employee/save-success";
	}
}
