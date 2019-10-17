package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("/showForm")
public String showForm(Model theModel)
{
		// create a student object
		Student theStudent=new Student();
		// add student object to the model
		theModel.addAttribute("student", theStudent);
return "student-form";	
}
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student")Student theStudent)
	{ // the "student" in @ModelAttribute must match with modelAttibute="student" in the form
		// log the input data
		System.out.println("the Student : "+theStudent.getFirstName());
		System.out.println("last name : "+theStudent.getLastName());
		//System.out.println("country :"+theStudent.getCountry());
		return "student-confirmation";
	}
}
