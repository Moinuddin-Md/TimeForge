package com.employee.repositories;

import java.time.LocalDate;
import java.util.List;

import com.employee.entities.TimeInfo;

public interface TimeRepository 
{
	void recordTime(TimeInfo timeInfo);
	TimeInfo getTimeInfo(int eid);
	void update(TimeInfo timeInfo, String intime, String totaltime);
	List<TimeInfo> getSpecificDateList(LocalDate date);
	List<TimeInfo> findDatewiseListOfGivenDate(LocalDate date);
	List<TimeInfo> findDatewiseListOfGivenDates(LocalDate date1, LocalDate date2);
	List<TimeInfo> findEmpwiseListOfGivenDate(LocalDate date, int eid);
}
