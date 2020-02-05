package com.educator.LearnFast.Courses;
import java.sql.Date;

public class CourseHistory {
	@Override
	public String toString() {
		return "CourseHistory [courseName=" + courseName + ", courseId=" + courseId + ", instructorName="
				+ instructorName + ", enrolled_date=" + enrolled_date + ", ending_date=" + ending_date + ", status="
				+ status + "]";
	}
	public String courseName;
	public int courseId;
	public String instructorName;
	public Date enrolled_date;
	public Date ending_date;
	public boolean status;

}
