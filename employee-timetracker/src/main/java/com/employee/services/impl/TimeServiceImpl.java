package com.employee.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.TimeInfo;
import com.employee.repositories.EmployeeRepository;
import com.employee.repositories.TimeRepository;
import com.employee.services.TimeService;
import com.employee.util.TimeDateUtility;

@Service
public class TimeServiceImpl implements TimeService 
{
	@Autowired private TimeRepository timeRepository;
	@Autowired private EmployeeRepository employeeRepository;

	public void saveOutTime(TimeInfo timeInfo) 
	{
		//Saving TimeInfo of employee that went out
		timeInfo.setOuttime(TimeDateUtility.getCurrentTime());
		timeInfo.setDate(LocalDate.now());
		timeRepository.recordTime(timeInfo);
		//Updating status of that employee
		employeeRepository.updateStatus("out",timeInfo.getEid());
	}
	public void updateInTime(int eid) 
	{
		//Getting object of TimeInfo class of employee
		TimeInfo timeInfo=timeRepository.getTimeInfo(eid);
		String outtime=timeInfo.getOuttime();
		String intime=TimeDateUtility.getCurrentTime();
		String totaltime=TimeDateUtility.getTotalTime(intime,outtime);
		//Updating TimeInfo
		timeRepository.update(timeInfo,intime,totaltime);
		//Updating status of that employee
		employeeRepository.updateStatus("in",eid);
	}
	@Override
	public List<TimeInfo> getDatewiseListOfGivenDate(LocalDate date) {
		return timeRepository.findDatewiseListOfGivenDate(date);
	}
	@Override
	public List<TimeInfo> getDatewiseListOfGivenDates(LocalDate date1, LocalDate date2) {
		return timeRepository.findDatewiseListOfGivenDates(date1,date2);
	}
	@Override
	public List<TimeInfo> getEmpwiseListOfGivenDate(LocalDate date, int eid) {
		return timeRepository.findEmpwiseListOfGivenDate(date,eid);
	}
	
}
