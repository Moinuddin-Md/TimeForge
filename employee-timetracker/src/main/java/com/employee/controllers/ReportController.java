package com.employee.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.employee.entities.Employee;
import com.employee.entities.TimeInfo;
import com.employee.repositories.EmployeeRepository;
import com.employee.services.EmployeeService;
import com.employee.services.ReportService;
import com.employee.services.TimeService;
import com.employee.util.TimeDateUtility;

@Controller
public class ReportController 
{
	@Autowired private ReportService reportService;
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private TimeService timeService;
	
	@RequestMapping("reports/datewise/choose")
	public String getDateView()
	{
		return "reports/datewise/choose-date";
	}
	@RequestMapping("reports/datewise/curdate")
	public ModelAndView getCurrentDateReportView()
	{
		List<TimeInfo> list=reportService.getGivenDateReport(LocalDate.now());
		ModelAndView model=new ModelAndView("reports/datewise/current-date");
		model.addObject("tlist",list);
		return model;
	}
	@RequestMapping("reports/datewise/anydate")
	public ModelAndView getAnyDateReportView(String date)
	{
		LocalDate ldate=LocalDate.parse(date);
		List<TimeInfo> list=reportService.getGivenDateReport(ldate);
		ModelAndView model=new ModelAndView("reports/datewise/any-date");
		model.addObject("tlist",list);
		model.addObject("date",date);
		return model;
	}
	@RequestMapping("reports/datewise/date-between")
	public String getDatewiseReportOfBetweenDate(Model model,String date1,String date2)
	{
		List<TimeInfo> list=timeService.getDatewiseListOfGivenDates(LocalDate.parse(date1),LocalDate.parse(date2));
		model.addAttribute("clist",list);
		model.addAttribute("date1",date1);
		model.addAttribute("date2",date2);
		return "reports/datewise/date-between";
	}
	@RequestMapping("time/empwise/report/choose-employee")
	public String getEmployeeList(Model model)
	{
		List<Employee> employeeList=employeeRepository.getList();
		model.addAttribute("elist",employeeList);
		return "reports/empwise/employee-list";
	}
	@RequestMapping("time/empwise/report/choose-date")
	public String getEmpwiseOptionView(Model model,String name)
	{
		model.addAttribute("cdate",LocalDate.now());
		model.addAttribute("name",name);
		model.addAttribute("eid",TimeDateUtility.getEid(name));
		return "reports/empwise/choose-date";
	}
	@RequestMapping("time/empwise/report/curdate")
	public String getEmpwiseReportOfCurrentDate(Model model,int eid)
	{
		List<TimeInfo> list=timeService.getEmpwiseListOfGivenDate(LocalDate.now(),eid);
		model.addAttribute("clist",list);
		model.addAttribute("eid",eid);
		return "reports/empwise/current-date";
	}
	@RequestMapping("time/empwise/report/anydate")
	public ModelAndView getEmpwiseAnyDateReportView(String date)
	{
		LocalDate ldate=LocalDate.parse(date);
		List<TimeInfo> list=reportService.getGivenDateReport(ldate);
		ModelAndView model=new ModelAndView("reports/empwise/any-date");
		model.addObject("tlist",list);
		model.addObject("date",date);
		return model;
	}
	@RequestMapping("time/empwise/report/date-between")
	public String getEmpwiseReportOfBetweenDate(Model model,String date1,String date2)
	{
		List<TimeInfo> list=timeService.getDatewiseListOfGivenDates(LocalDate.parse(date1),LocalDate.parse(date2));
		model.addAttribute("clist",list);
		model.addAttribute("date1",date1);
		model.addAttribute("date2",date2);
		return "reports/empwise/date-between";
	}
}
