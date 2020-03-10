package com.educator.learnfast.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.educator.learnfast.models.EnrollmentDetails;
import com.educator.learnfast.models.InstructorInfo;
import com.educator.learnfast.util.ConnectionUtil;

public interface InstructorDAO {

	public boolean saveInstructor(InstructorInfo in);

	InstructorInfo instructorLogin(String email, String pass);

	public boolean getEmail(String email);
}
