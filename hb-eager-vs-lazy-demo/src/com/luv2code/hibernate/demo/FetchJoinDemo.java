package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			// option 2: Hibernate query with HQL
			
			// get the instructor from db
			int theId = 1;
			// when executed, will load instructor and courses all at once
			// be sure to add org.hibernate.query.Query
			 Query<Instructor> query= session.createQuery("select i from Instructor i "+
			"JOIN FETCH i.courses "
			+"where i.id=:theInstructorId", Instructor.class);	
			// :theInstructorId is a parameter set below.
			 
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			// .getSingleResult will Load instructor and courses all at once.
			Instructor tempInstructor=query.getSingleResult();
			
			System.out.println("luv2code: Instructor: "+tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("luv2code: The session is now closed!\n");
			
			// get courses for the instructor
			System.out.println("luv2code: Courses: "+tempInstructor.getCourses());
			System.out.println("luv2code: Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





