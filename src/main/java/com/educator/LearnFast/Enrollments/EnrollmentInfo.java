package com.educator.LearnFast.Enrollments;


import java.sql.Date;

public class EnrollmentInfo {
	@Override
	public String toString() {
		return "EnrollmentInfo [enrollmentId=" + enrollmentId + ", courseId=" + courseId + ", userId=" + userId
				+ ", enrolledDate=" + enrolledDate + ", endingDate=" + endingDate + ", status=" + status + "]";
	}
	public int enrollmentId;
	public int courseId;
	public int userId;
	public Date enrolledDate;
	public Date endingDate;
	public EnrollmentStatusEnum status;
	
	/* EnrollmentInfo() {
		// TODO Auto-generated constructor stub
	}*/
}
