package com.educator.LearnFast.Enrollments;

public class EnrollmentDetails {
	@Override
	public String toString() {
		return "EnrollmentDetails [courseName=" + courseName + ", duration=" + duration + ", noOfEnrollments="
				+ noOfEnrollments + ", rating=" + rating + "]";
	}
	public String courseName;
	public int duration;
	public int noOfEnrollments;
	public int rating;
	
}
