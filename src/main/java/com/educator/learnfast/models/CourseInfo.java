package com.educator.learnfast.models;

public class CourseInfo {
	@Override
	public String toString() {
		return "CourseInfo [courseId=" + courseId + ", courseName=" + courseName + ", durationOfCourse="
				+ durationOfCourse + ", instructorName=" + instructorName + ", courseCategory=" + courseCategory
				+ ", price=" + price + ", rating=" + rating + "]";
	}
	private int courseId;
	private String courseName;
	private int durationOfCourse;
	private String instructorName;
	private String courseCategory;
	private int price;
	private int rating;
	private int instructorId;
	private int noOfEnrollments;
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getCourseId() {
		return courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDurationOfCourse() {
		return durationOfCourse;
	}
	public void setDurationOfCourse(int durationOfCourse) {
		this.durationOfCourse = durationOfCourse;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public int getNoOfEnrollments() {
		return noOfEnrollments;
	}
	public void setNoOfEnrollments(int noOfEnrollments) {
		this.noOfEnrollments = noOfEnrollments;
	}
	
}
