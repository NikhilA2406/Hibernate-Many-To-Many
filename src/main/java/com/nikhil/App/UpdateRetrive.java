package com.nikhil.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.nikhil.model.Students;



public class UpdateRetrive {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		Students stud1 = session.get(Students.class,1);
		
		System.out.println(stud1);
		
		System.out.println("***********************************");
		
		Students stud2 = session.get(Students.class,2);
		
		System.out.println(stud2);
		
		System.out.println("***********************************");
		
		Students stud3 = session.get(Students.class,3);
		
		System.out.println(stud3);
		
		System.out.println("***********************************");
		
		try
		{
			
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			
			
			session.close();
			sessionFactory.close();
		}


	}

}
