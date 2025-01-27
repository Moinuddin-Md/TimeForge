package com.employee.repositories.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.employee.entities.TimeInfo;
import com.employee.repositories.TimeRepository;
import com.employee.session.SingleSession;

@Repository
public class TimeRepositoryImpl implements TimeRepository 
{
	private Session session;
	private Transaction transaction;
	public TimeRepositoryImpl(SingleSession singleSession)
	{
		this.session=singleSession.getSession();
		transaction=session.getTransaction();
	}
	public void recordTime(TimeInfo timeInfo) 
	{
		transaction.begin();
		session.save(timeInfo);
		transaction.commit();
	}
	public TimeInfo getTimeInfo(int eid) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where eid=:arg1 and intime=:arg2",TimeInfo.class);
		query.setParameter("arg1",eid);
		query.setParameter("arg2","Not in yet");
		TimeInfo timeInfo=query.uniqueResult();
		return timeInfo;
	}
	public void update(TimeInfo timeInfo, String intime, String totaltime) 
	{
		transaction.begin();
		timeInfo.setIntime(intime);
		timeInfo.setTotaltime(totaltime);
		transaction.commit();
	}
	public List<TimeInfo> getSpecificDateList(LocalDate date) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where date=:arg",TimeInfo.class);
		query.setParameter("arg",date);
		return query.list();
	}
	@Override
	public List<TimeInfo> findDatewiseListOfGivenDate(LocalDate date) {
		Query<TimeInfo> query=session.createQuery("from TimeInfo where date=:arg",TimeInfo.class); 
		query.setParameter("arg",date);
		return query.list();
	}
	@Override
	public List<TimeInfo> findDatewiseListOfGivenDates(LocalDate date1, LocalDate date2) {
		Query<TimeInfo> query=session.createQuery("from TimeInfo where date between :arg1 and :arg2",TimeInfo.class); 
		query.setParameter("arg1",date1);
		query.setParameter("arg2",date2);
		return query.list();
	}
	@Override
	public List<TimeInfo> findEmpwiseListOfGivenDate(LocalDate date, int eid) {
		Query<TimeInfo> query=session.createQuery("from TimeInfo where date=:arg1 and eid=:arg2",TimeInfo.class); 
		query.setParameter("arg1",date);
		query.setParameter("arg2",eid);
		return query.list();
	}
}
