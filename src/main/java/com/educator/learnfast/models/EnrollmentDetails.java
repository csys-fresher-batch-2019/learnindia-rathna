package com.educator.learnfast.models;

public class EnrollmentDetails {
	@Override
	public String toString() {
		return "EnrollmentDetails [courseName=" + getCourseName() + ", duration=" + duration + ", noOfEnrollments="
				+ noOfEnrollments + ", rating=" + rating + "]";
	}
	private String courseName;
	private int duration;
	private int noOfEnrollments;
	private int rating;
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getNoOfEnrollments() {
		return noOfEnrollments;
	}
	public void setNoOfEnrollments(int noOfEnrollments) {
		this.noOfEnrollments = noOfEnrollments;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
