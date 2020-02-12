package com.educator.LearnFast.Courses;
import java.sql.Date;

public class CourseHistory {
	@Override
	public String toString() {
		return "CourseHistory [courseName=" + courseName + ", courseId=" + courseId + ", instructorName="
				+ instructorName + ", enrolled_date=" + enrolled_date + ", ending_date=" + ending_date + ", status="
				+ status + "]";
	}
	private String courseName;
	private int courseId;
	private String instructorName;
	private Date enrolled_date;
	private Date ending_date;
	private boolean status;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public Date getEnrolled_date() {
		return enrolled_date;
	}
	public void setEnrolled_date(Date enrolled_date) {
		this.enrolled_date = enrolled_date;
	}
	public Date getEnding_date() {
		return ending_date;
	}
	public void setEnding_date(Date ending_date) {
		this.ending_date = ending_date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
