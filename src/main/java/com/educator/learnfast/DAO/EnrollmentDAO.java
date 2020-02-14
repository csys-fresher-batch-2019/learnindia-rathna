package com.educator.learnfast.DAO;

import com.educator.learnfast.models.EnrollmentInfo;

public interface EnrollmentDAO {
	
	boolean saveEnrollment(int userId,int courseId) throws Exception;
	
	boolean removeEnrollment(int CourseId,int UserId) throws Exception;
	
	EnrollmentInfo fetchEnrollment(int EnrollmentId) throws Exception;
	

}
