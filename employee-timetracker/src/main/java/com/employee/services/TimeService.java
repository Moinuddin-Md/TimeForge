package com.employee.services;

import java.time.LocalDate;
import java.util.List;

import com.employee.entities.TimeInfo;

public interface TimeService 
{
	void saveOutTime(TimeInfo timeInfo);
	void updateInTime(int eid);
	List<TimeInfo> getDatewiseListOfGivenDate(LocalDate date);
	List<TimeInfo> getDatewiseListOfGivenDates(LocalDate date1, LocalDate date2);
	List<TimeInfo> getEmpwiseListOfGivenDate(LocalDate now, int eid);
}
