package com.educator.learnfast.exception;

public class InfoMessages {

	private InfoMessages() {
		throw new IllegalStateException("Utility class");
	}

	public static final String NOOFENROLLMENT = "Unable to get no.of.enrollment information for this course id";
	public static final String FINDCOURSES = "Unable to find courses";
	public static final String GETCOURSECONTENT = "Unable to get course content";
	public static final String INVALIDLOGIN = "Invalid Email or Password";

}
