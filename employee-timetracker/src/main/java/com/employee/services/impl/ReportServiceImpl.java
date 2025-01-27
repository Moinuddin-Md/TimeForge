package com.employee.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.Employee;
import com.employee.entities.TimeInfo;
import com.employee.repositories.TimeRepository;
import com.employee.services.ReportService;

@Service
public class ReportServiceImpl implements ReportService 
{
	@Autowired private TimeRepository timeRepository;

	public List<TimeInfo> getGivenDateReport(LocalDate date) 
	{
		return timeRepository.getSpecificDateList(date);
	}

	
}
