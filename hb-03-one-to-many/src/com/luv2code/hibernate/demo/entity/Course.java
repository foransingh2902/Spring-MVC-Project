package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
// ensure that all imports are from javax.persistence

@Entity
@Table(name="entity")
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
