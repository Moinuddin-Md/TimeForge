package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.employee.entities.Employee;
import com.employee.entities.TimeInfo;
import com.employee.services.EmployeeService;
import com.employee.services.TimeService;

@Controller
public class TimeController 
{
	@Autowired private EmployeeService employeeService; 
	@Autowired private TimeService timeService;
	
	@GetMapping("time/out/employee-list")
	public String getEmployeeInList(Model model)
	{
		List<Employee> employeeList=employeeService.getList("in");
		model.addAttribute("elist",employeeList);
		return "time/out/employee-list";
	}
	@GetMapping("time/out/record-time")
	public String recordOutTime(TimeInfo timeInfo)
	{
		timeService.saveOutTime(timeInfo);
		return "time/out/record-outtime";
	}
	@GetMapping("time/in/employee-list")
	public String getEmployeeOutList(Model model)
	{
		List<Employee> employeeList=employeeService.getList("out");
		model.addAttribute("elist",employeeList);
		return "time/in/employee-list";
	}
	@GetMapping("time/in/update-intime")
	public String updateInTime(int eid)
	{
		timeService.updateInTime(eid);
		return "time/in/update-intime";
	}
}
