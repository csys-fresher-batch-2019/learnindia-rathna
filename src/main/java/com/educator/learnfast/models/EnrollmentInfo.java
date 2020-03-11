package com.educator.learnfast.models;

import java.time.LocalDate;

public class EnrollmentInfo {
	@Override
	public String toString() {
		return "EnrollmentInfo [enrollmentId=" + enrollmentId + ", courseId=" + courseId + ", userId=" + userId
				+ ", enrolledDate=" + enrolledDate + ", endingDate=" + endingDate + ", status=" + status + "]";
	}

	private int enrollmentId;
	private int courseId;
	private int userId;
	private LocalDate enrolledDate;
	private LocalDate endingDate;
	private EnrollmentStatusEnum status;

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getEnrolledDate() {
		return enrolledDate;
	}

	public void setEnrolledDate(LocalDate enrolledDate) {
		this.enrolledDate = enrolledDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + ((endingDate == null) ? 0 : endingDate.hashCode());
		result = prime * result + ((enrolledDate == null) ? 0 : enrolledDate.hashCode());
		result = prime * result + enrollmentId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + userId;
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
		EnrollmentInfo other = (EnrollmentInfo) obj;
		if (courseId != other.courseId)
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
		if (status != other.status)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}

	public EnrollmentStatusEnum getStatus() {
		return status;
	}

	public void setStatus(EnrollmentStatusEnum status) {
		this.status = status;
	}

	/*
	 * EnrollmentInfo() { // TODO Auto-generated constructor stub }
	 */
}
