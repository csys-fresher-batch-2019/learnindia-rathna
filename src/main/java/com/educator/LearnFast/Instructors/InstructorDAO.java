package com.educator.LearnFast.Instructors;

import java.sql.SQLException;
import java.util.ArrayList;

import com.educator.LearnFast.Enrollments.EnrollmentDetails;

public interface InstructorDAO {
	void saveInstructor(InstructorInfo in) throws Exception;
	
	void removeInstructor(int instructorId) throws Exception;
	
	void updateRecentWorks(String update,int instructorId) throws Exception;
	
	void instructorLogin(String email, String pass) throws Exception;
	
	ArrayList<EnrollmentDetails> getEnrollmentDetails(int id) throws Exception;
}
