package com.educator.learnfast.model;

import java.time.LocalDate;

public class CourseHistory {

	private String courseName;
	private int courseId;
	private String instructorName;
	private LocalDate enrolledDate;
	private LocalDate endingDate;
	private boolean status;
	private int enrollmentId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((endingDate == null) ? 0 : endingDate.hashCode());
		result = prime * result + ((enrolledDate == null) ? 0 : enrolledDate.hashCode());
		result = prime * result + enrollmentId;
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
		if (endingDate == null) {
			if (other.endingDate != null)
				return false;
		} else if (!endingDate.equals(other.endingDate))
			return false;
		if (enrolledDate == null) {
			if (other.enrolledDate != null)
				return false;
		} else if (!enrolledDate.equals(other.enrolledDate))
			return false;
		if (enrollmentId != other.enrollmentId)
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
				+ instructorName + ", enrolledDate=" + enrolledDate + ", endingDate=" + endingDate + ", status="
				+ status + ", enrollmentId=" + enrollmentId + "]";
	}

	public LocalDate getEnrolledDate() {
		return enrolledDate;
	}

	public void setEnrolledDate(LocalDate enrolledDate) {
		this.enrolledDate = enrolledDate;
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
