package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
private String coursePrefix;
	@Override
	public void initialize(CourseCode theCourseCode) {
		// assign the value from passed in from our annotation
		coursePrefix=theCourseCode.value();
	}
	
	//isValid(...) will be called by spring MVC
	@Override// theCode is the value entered in HTML form data entered by the user.
	public boolean isValid(String theCode, ConstraintValidatorContext theconstraintValidatorContext) {
		// we can place additional error messages in theconstraintValidatorContext
		// will provide our business logic
		boolean result;
		if(theCode!=null) {
		result=theCode.startsWith(coursePrefix);
		}
		else
		{
			result=true;
		}
		return result;
	}

}
