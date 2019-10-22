package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// ensure that all imports are from javax.persistence

@Entity
@Table(name="course")
public class Course {
// define our fields
	// define constructors
	// define getters setters
	// define toString
	// annotate fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	// course has a many to one relation with instructor
	// "instructor_id" is the name of column in 'course' table
	// that points back to the 'instructor' table
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name ="instructor_id" )
	private Instructor instructor;
	
	// as Review has a one to one uni relation with the course, therefore
	// CascadeType.ALL because when any course is deleted all its
	// reviews must also be deleted
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
// add a convenience method
	public void addReview(Review theReview)
	{
		if(reviews==null) {
			reviews=new ArrayList<Review>();
		}
		reviews.add(theReview);
	}
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	// can only initialize for title, as id is auto generated
	// Instructor will be set by instructor class later
	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}

	
}
