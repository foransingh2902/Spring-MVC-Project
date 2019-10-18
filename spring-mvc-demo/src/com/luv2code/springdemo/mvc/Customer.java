package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {
private String firstName;
// adding validation rule
@NotNull(message="is required")
@Size(min=1, message="is required") // minimum size required
private String lastName;

@NotNull(message="is required")
@Min(value = 0,message = "must be greater than or equal to zero")
@Max(value = 10,message = "must be less than or equal to 10")
private Integer freePasses;
// Refactor field: change to "integer", because in our controller
// we have put an initBinder which will trim our string to null if left blank
// so instead of String we use out Integer class.


@Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 chars/digits")
private String postalCode;

@CourseCode(value = "TOPS", message = "must start woth TOPS") // we are not passing value and message as we already provided default values
private String courseCode;

public String getCourseCode() {
	return courseCode;
}
public void setCourseCode(String courseCode) {
	this.courseCode = courseCode;
}
public String getPostalCode() {
	return postalCode;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
public Integer getFreePasses() {
	return freePasses;
}
public void setFreePasses(Integer freePasses) {
	this.freePasses = freePasses;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

}
