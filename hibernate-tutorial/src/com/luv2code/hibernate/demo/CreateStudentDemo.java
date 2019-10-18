package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
// run this class to test the working of inserting data into database
public class CreateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create a session
		Session session=factory.getCurrentSession();
try {
	// use the session object to save java object
	
	// create a student object
	System.out.println("Create new Student Object....");
	Student tempStudent=new Student("foran","singh","foran.singh2902@gmail.com");
	// start a transaction
	session.beginTransaction();
	
	// save the object
	System.out.println("Saving the student....");
	session.save(tempStudent);
	
	// commit transaction
	session.getTransaction().commit();
	
	System.out.println("Done");
}
finally {
	
}
	}

}
