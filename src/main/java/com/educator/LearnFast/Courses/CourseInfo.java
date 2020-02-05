package com.educator.LearnFast.Courses;

public class CourseInfo {
	@Override
	public String toString() {
		return "CourseInfo [courseId=" + courseId + ", courseName=" + courseName + ", durationOfCourse="
				+ durationOfCourse + ", instructorName=" + instructorName + ", courseCategory=" + courseCategory
				+ ", price=" + price + ", rating=" + rating + ", instructorId=" + instructorId + "]";
	}
	public int courseId;
	public String courseName;
	public int durationOfCourse;
	public String instructorName;
	public String courseCategory;
	public int price;
	public int rating;
	public int instructorId;
	
}
