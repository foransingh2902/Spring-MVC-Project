package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
// run this class to test the working of inserting data into database
public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create a session
		Session session=factory.getCurrentSession();
try {
	int studentId=1;
	
	// my new code
	// find out the student's id: primary key
	System.out.println("saved student, Generated id "+studentId);
	
	// now get a new session and start transaction
	session=factory.getCurrentSession();
	session.beginTransaction();
	
	// retrieve student based on the id : primary key
	System.out.println("\n getting student with id : "+studentId);
	Student myStudent=session.get(Student.class, studentId);
	System.out.println("Updating student....");
	myStudent.setFirstName("Scooby");
	// commit the transaction
	session.getTransaction().commit();
	
	
	
	// bulk update
	// new code
	session=factory.getCurrentSession();
	session.beginTransaction();
	
	// update email for all students
	session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
	
	// commit the transaction
	session.getTransaction().commit();
	
	System.out.println("Done!!!!!!!!");
	
}
finally {
	
}
	}

}
