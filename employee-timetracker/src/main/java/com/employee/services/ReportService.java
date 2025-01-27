package com.employee.services;

import java.time.LocalDate;
import java.util.List;

import com.employee.entities.Employee;
import com.employee.entities.TimeInfo;

public interface ReportService 
{
	List<TimeInfo> getGivenDateReport(LocalDate date);

}
