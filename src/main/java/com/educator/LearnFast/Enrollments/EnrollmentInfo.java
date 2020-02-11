package com.educator.LearnFast.Enrollments;


import java.sql.Date;

public class EnrollmentInfo {
	@Override
	public String toString() {
		return "EnrollmentInfo [enrollmentId=" + enrollmentId + ", courseId=" + courseId + ", userId=" + userId
				+ ", enrolledDate=" + enrolledDate + ", endingDate=" + endingDate + ", status=" + status + "]";
	}
	private int enrollmentId;
	private int courseId;
	private int userId;
	private Date enrolledDate;
	private Date endingDate;
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
	public Date getEnrolledDate() {
		return enrolledDate;
	}
	public void setEnrolledDate(Date enrolledDate) {
		this.enrolledDate = enrolledDate;
	}
	public Date getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	public EnrollmentStatusEnum getStatus() {
		return status;
	}
	public void setStatus(EnrollmentStatusEnum status) {
		this.status = status;
	}
	
	/* EnrollmentInfo() {
		// TODO Auto-generated constructor stub
	}*/
}
