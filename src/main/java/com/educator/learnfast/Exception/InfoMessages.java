package com.educator.learnfast.exception;

public class InfoMessages {

	private InfoMessages() {
		throw new IllegalStateException("Utility class");
	}

	public static final String NOOFENROLLMENT 	= "Unable to get no.of.enrollment information for this course id";
	public static final String FINDCOURSES	  	= "Unable to find courses";
	public static final String GETCOURSECONTENT = "Unable to get course content";
	public static final String INVALIDLOGIN = "Invalid Email or Password";
	
	

	public static final String CONNECTION = "Unable to Establish Connection 'SERVER ERROR'";
	public static final String ADDCOURSE = "Unable to Add Course";
	public static final String DELETECOURSE = "Unable to Delete Course";
	// public static final String GETCOURSES = "Unable to Get No.Of.Course
	// Enrolled";
	public static final String SEARCHCOURSE = "Unable to Perform Search";
	public static final String ENROLLMENTRATING = "Unable to add Rating in Enrollment_Info";
	public static final String COURSERATING = "Unable to Add Average Rating to the Course";
	public static final String GETENROLLMENT = "Unable to get No.Of.Courses Enrolled";
	public static final String SAVEENROLLMENT = "Unable to Save Enrollment";
	public static final String COURSECONTENT = "Unable to fetch Course Content";
}
