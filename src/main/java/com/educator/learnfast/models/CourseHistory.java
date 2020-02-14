package com.educator.learnfast.models;

import java.time.LocalDate;

public class CourseHistory {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((ending_date == null) ? 0 : ending_date.hashCode());
		result = prime * result + ((enrolled_date == null) ? 0 : enrolled_date.hashCode());
		result = prime * result + ((instructorName == null) ? 0 : instructorName.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseHistory other = (CourseHistory) obj;
		if (courseId != other.courseId)
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (ending_date == null) {
			if (other.ending_date != null)
				return false;
		} else if (!ending_date.equals(other.ending_date))
			return false;
		if (enrolled_date == null) {
			if (other.enrolled_date != null)
				return false;
		} else if (!enrolled_date.equals(other.enrolled_date))
			return false;
		if (instructorName == null) {
			if (other.instructorName != null)
				return false;
		} else if (!instructorName.equals(other.instructorName))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CourseHistory [courseName=" + courseName + ", courseId=" + courseId + ", instructorName="
				+ instructorName + ", enrolled_date=" + enrolled_date + ", ending_date=" + ending_date + ", status="
				+ status + "]";
	}
	private String courseName;
	private int courseId;
	private String instructorName;
	private LocalDate enrolled_date;
	private LocalDate ending_date;
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
	public LocalDate getEnrolled_date() {
		return enrolled_date;
	}
	public void setEnrolled_date(LocalDate enrolled_date) {
		this.enrolled_date = enrolled_date;
	}
	public LocalDate getEnding_date() {
		return ending_date;
	}
	public void setEnding_date(LocalDate ending_date) {
		this.ending_date = ending_date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
