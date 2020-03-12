package com.educator.learnfast.dao;

import com.educator.learnfast.models.InstructorInfo;

public interface InstructorDAO {

	public boolean saveInstructor(InstructorInfo in);

	InstructorInfo instructorLogin(String email, String pass);

	public boolean findByInstructorEmail(String email);
}
