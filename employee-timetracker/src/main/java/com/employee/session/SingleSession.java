package com.employee.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Component;

@Component
public class SingleSession 
{
	private Session session;
	public SingleSession(SessionFactory factory)
	{
		session=factory.openSession();
	}
	public Session getSession()
	{
		return session;
	}
}
