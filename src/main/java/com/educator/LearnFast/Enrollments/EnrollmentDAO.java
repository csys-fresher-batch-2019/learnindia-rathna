package com.educator.LearnFast.Enrollments;

public interface EnrollmentDAO {
	
	void saveEnrollment(EnrollmentInfo enrollment) throws Exception;
	
	void removeEnrollment(int CourseId,int UserId) throws Exception;
	
	EnrollmentInfo fetchEnrollment(int EnrollmentId) throws Exception;
	

}
