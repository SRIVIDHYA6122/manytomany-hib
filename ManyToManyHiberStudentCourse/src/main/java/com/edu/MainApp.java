package com.edu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp {

	public static void main(String[] args) {
		Configuration con= new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);
		 ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		 SessionFactory factory= con.buildSessionFactory(reg);
		 Session session= factory.openSession();
		 Transaction t= session.beginTransaction();
		 
		 Course c1=new Course(5, "DAA", 7000.00);
		 		 session.save(c1);
		 Course c2=new Course(6, "CN", 8000.00);
				 session.save(c2);
		// Course c3=new Course(3, "java", 30000.00);
			//	 session.save(c3);
		// Course c4=new Course(4, "C", 1500.00);
			//	 session.save(c4);
		 
		
		 Set<Course>courses=new HashSet<Course>(Arrays.asList(c1,c2));
		 Student s1=new Student(13, "ramesh", "9629665242");
		
		 s1.setCourselist(courses);
		 Set<Course>courses1=new HashSet<Course>(Arrays.asList(c1));
		 Student s2=new Student(14, "bablu", "636937507");
		 s2.setCourselist(courses1);
		 session.save(s1);
		 session.save(s2);
		 t.commit();
		 session.close();

	}

}

