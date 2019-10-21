package com.luv2code.springdemo.mvc.validation;
import java.util.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

import javax.validation.Constraint;
// helper class that contains business rules/ validation logic.
import javax.validation.Payload;
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
// define default course code
	public String value() default "LUV";
	// define default error message
	public String message() default "must start with LUV";
	// define default groups- can group related constraints
	public Class<?>[] groups() default{};
	// define default payloads - provide custom details about validation failure
	// like- severity level, error code etc
	public List<String> l=new ArrayList<String>();
	public Class<? extends Payload>[] payload() default{};
}
/*
 * Method should not have any throws clauses
Method should return one of the following: primitive data types, String, Class, enum or array of these data types.
Method should not have any parameter.
We should attach @ just before interface keyword to define annotation.
It may assign a default value to the method.
 
 * */
 