package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
// run this class to test the working of inserting data into database
public class QueryStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create a session
		Session session=factory.getCurrentSession();
try {

	// start a transaction
	session.beginTransaction();
	// query students
	List<Student> theStudents=session.createQuery("from Student").list();
	
	// display the students
	displayStudents(theStudents);
	// query students: lastName='duck'
	theStudents=session.createQuery("from Student s where s.lastName='duck' ").list();
	
	// display the students
	System.out.println("\n students who have last name of 'duck'");
	displayStudents(theStudents);
	
	System.out.println("\n students who have last name of 'duck' and first name 'foran1'");
	// query students : lastName='duck' or firstName='foran1'
	theStudents=session.createQuery("from Student s where"+" s.lastName='duck' OR s.firstName='foran1'").list();
	// be sure to add whitespace here " s.lastName
	displayStudents(theStudents);
	
	System.out.println("\n students who's email ends with '@gmail.com'");
	// email ends with @gmail.com-- where eamil LIKE '%@gmail.com'
	theStudents=session.createQuery("from Student s where"+" s.email LIKE '%@gmail.com'").list();
	displayStudents(theStudents);
	
	// commit transaction
	session.getTransaction().commit();
	
	System.out.println("Done");
}
finally {
	factory.close();
}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
