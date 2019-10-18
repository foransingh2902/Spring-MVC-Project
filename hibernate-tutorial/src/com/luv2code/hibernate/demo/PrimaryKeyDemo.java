package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create a session
		Session session=factory.getCurrentSession();
try {
	// use the session object to save java object
	
	// create 3 student object
	System.out.println("Create 3 Student Object....");
	Student tempStudent1=new Student("foran1","singh1","foran1.singh2902@gmail.com");
	Student tempStudent2=new Student("foran2","singh2","foran2.singh2902@gmail.com");
	Student tempStudent3=new Student("foran3","singh3","foran3.singh2902@gmail.com");
	// start a transaction
	session.beginTransaction();
	
	// save the object
	System.out.println("Saving the student....");
	session.save(tempStudent1);
	session.save(tempStudent2);
	session.save(tempStudent3);
	
	// commit transaction
	session.getTransaction().commit();
	
	System.out.println("Done");
}
finally {
	
}
	}

}
