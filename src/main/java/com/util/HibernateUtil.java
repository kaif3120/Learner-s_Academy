package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.entity.Classes;
import com.entity.Student;
import com.entity.Subject;
import com.entity.Teacher;

public class HibernateUtil {
	static SessionFactory sessionFactory = null;

	public static SessionFactory buildSessionFactory() {
		
		if(sessionFactory != null) {
			return sessionFactory;
		}
		
		 Configuration config = new Configuration().configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Classes.class).addAnnotatedClass(Teacher.class)
				 .addAnnotatedClass(Student.class).addAnnotatedClass(Subject.class);
		 
		  
		  ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		 sessionFactory = config.buildSessionFactory(reg);
	   
		return sessionFactory;
	}
}
