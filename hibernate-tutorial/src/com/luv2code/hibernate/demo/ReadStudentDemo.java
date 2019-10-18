package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
// run this class to test the working of inserting data into database
public class ReadStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create a session
		Session session=factory.getCurrentSession();
try {
	// use the session object to save java object
	
	// create a student object
	System.out.println("Create new Student Object....");
	Student tempStudent=new Student("daffy","duck","daffyduck@gmail.com");
	// start a transaction
	session.beginTransaction();
	
	// save the object
	System.out.println("Saving the student....");
	// this will call toString()
	System.out.println(tempStudent);
	session.save(tempStudent);
	
	// commit transaction
	session.getTransaction().commit();
	
	System.out.println("Done");
	
	// my new code
	// find out the student's id: primary key
	System.out.println("saved student, Generated id "+tempStudent.getId());
	
	// now get a new session and start transaction
	session=factory.getCurrentSession();
	session.beginTransaction();
	
	// retrieve student based on the id : primary key
	System.out.println("\n getting student with id : "+tempStudent.getId());
	Student myStudent=session.get(Student.class, tempStudent.getId());
	System.out.println("Get Complete :"+myStudent);
	// commit the transaction
	session.getTransaction().commit();
	
	System.out.println("Done");
	
}
finally {
	
}
	}

}
