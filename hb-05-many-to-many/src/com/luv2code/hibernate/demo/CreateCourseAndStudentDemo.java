package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
						session.beginTransaction();
						// create a course
						Course tempCourse=new Course("Pacman-how to score one million points");
						
						
						// save the course
						System.out.println("\n Saving the course...");
						session.save(tempCourse);
						System.out.println("Saved the course :"+tempCourse);
						
						
						// create the students
						Student tempStudent1=new Student("John","Doe","john@luv2code.com");
						Student tempStudent2=new Student("Mary", "Public", "mary@luv2code.com");
						
						// add students to the course
						tempCourse.addStudents(tempStudent1);
						tempCourse.addStudents(tempStudent2);
						
						// save the students
						System.out.println("\n Saving students...");
						session.save(tempStudent1);
						session.save(tempStudent2);
						System.out.println("saved students :"+tempCourse.getStudents());
						
						// commit transaction
						session.getTransaction().commit();
						
						System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





