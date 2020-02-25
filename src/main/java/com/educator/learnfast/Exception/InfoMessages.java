package com.educator.learnfast.Exception;

public class InfoMessages {

	private InfoMessages() {
		throw new IllegalStateException("Utility class");
	}
	public static final String CONNECTION = "Unable to Establish Connection 'SERVER ERROR'";
	public static final String ADDCOURSE = "Unable to Add Course";
	public static final String DELETECOURSE = "Unable to Delete Course";
	public static final String GETCOURSES = "Unable to Get No.Of.Course Enrolled";
	public static final String SEARCHCOURSE = "Unable to Perform Search";
	public static final String ENROLLMENTRATING = "Unable to add Rating in Enrollment_Info";
	public static final String COURSERATING = "Unable to Add Average Rating to the Course";
	public static final String GETENROLLMENT = "Unable to get No.Of.Courses Enrolled";
	public static final String SAVEENROLLMENT = "Unable to Save Enrollment";
	public static final String COURSECONTENT = "Unable to fetch Course Content";
}
