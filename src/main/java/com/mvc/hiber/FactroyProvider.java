package com.mvc.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactroyProvider 
{
	private FactroyProvider()
	{
		
	}
	
	static SessionFactory sessionFactory=null;
	public static SessionFactory getFactory()
	{
	 
		if(sessionFactory==null)
		{
		Configuration configuration=new Configuration();
		configuration.configure("com/mvc/hiber/hibernate.cfg.xml");
		sessionFactory=configuration.buildSessionFactory();
		return sessionFactory;
		}
		
		return sessionFactory;
		
	}
	
}
