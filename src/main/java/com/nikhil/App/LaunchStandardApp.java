package com.nikhil.App;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.Courses;
import com.nikhil.model.Students;

public class LaunchStandardApp {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		Courses c1=new Courses();
		c1.setId(1);
		c1.setCourseName("Java");
		c1.setCoursePrice(1999);
		
		Courses c2=new Courses();
		c2.setId(2);
		c2.setCourseName("Hibernate");
		c2.setCoursePrice(499);
		
		Courses c3=new Courses();
		c3.setId(3);
		c3.setCourseName("SpringBoot");
		c3.setCoursePrice(999);
		
		Set<Courses> set1=new HashSet<Courses>();
		set1.add(c1);
		set1.add(c2);
		set1.add(c3);
		
		Set<Courses> set2=new HashSet<Courses>();
		set2.add(c1);
		set2.add(c2);
		
		Students s1=new Students();
		s1.setId(1);
		s1.setName("Rishi");
		s1.setCity("Raipur");
		s1.setCourses(set1);
		
		Students s2=new Students();
		s2.setId(2);
		s2.setName("Nitu");
		s2.setCity("Raipur");
		s2.setCourses(set2);
		
		Students s3=new Students();
		s3.setId(3);
		s3.setName("Rishika");
		s3.setCity("Raipur");
		s3.setCourses(set1);
		
		
		try
		{
			transaction=session.beginTransaction();
			
			session.persist(s1);
			session.persist(s2);
			session.persist(s3);
			
			flag=true;
			
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
			if(flag==true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
		}


	}

}
