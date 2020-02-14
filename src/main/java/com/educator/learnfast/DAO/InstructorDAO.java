package com.educator.learnfast.DAO;

import java.util.ArrayList;

import com.educator.learnfast.models.EnrollmentDetails;
import com.educator.learnfast.models.InstructorInfo;

public interface InstructorDAO {
	boolean saveInstructor(InstructorInfo in) throws Exception;
	
	boolean removeInstructor(int instructorId) throws Exception;
	
	InstructorInfo instructorLogin(String email, String pass) throws Exception;
	
	ArrayList<EnrollmentDetails> getEnrollmentDetails(int id) throws Exception;
}
