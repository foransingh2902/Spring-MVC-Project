package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
	public Class<? extends Payload>[] payload() default{};
}
