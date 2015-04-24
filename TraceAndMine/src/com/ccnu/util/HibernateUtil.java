package com.ccnu.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

@SuppressWarnings("deprecation")
public class HibernateUtil
{
	public static final SessionFactory sessionFactory;
	
	static
	{
		try {
				Configuration configuration = new AnnotationConfiguration();
				sessionFactory = configuration.configure().buildSessionFactory();
		} catch (HibernateException e) {
				System.err.println("ERROR From HibernateUtil Initial SessionFactory creation failed." );
				throw new ExceptionInInitializerError(e);
		}	
	}
	
	public static final ThreadLocal<Session> session
		= new ThreadLocal<Session>();
	
	public static Session currentSession()
		throws HibernateException
	{
		Session s = session.get();
		if (s == null)
		{
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}
	
	public static void closeSession()
		throws HibernateException 
	{
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
	
	
	
}