package com.employee.repositories.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entities.Employee;
import com.employee.repositories.EmployeeRepository;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public EmployeeRepositoryImpl(SessionFactory sessionFactory)
	{
		this.session=sessionFactory.openSession();
		transaction=session.getTransaction();
	}
	public void persistEmployee(Employee employee) 
	{
		transaction.begin();
		session.persist(employee);
		transaction.commit();
	}
	public List<Employee> getEmployeeList(String status) 
	{
		Query<Employee> query=session.createQuery("from Employee where status=:arg",Employee.class);
		query.setParameter("arg",status);
		return query.list();
	}
	public void updateStatus(String status,int eid) 
	{
		Employee employee=session.get(Employee.class,eid);
		transaction.begin();
		employee.setStatus(status);
		transaction.commit();
	}
	@Override
	public List<Employee> getList() {
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		return query.list();
	}
}
