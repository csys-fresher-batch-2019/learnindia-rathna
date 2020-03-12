package com.educator.learnfast.dao;

import java.util.ArrayList;

import com.educator.learnfast.model.CourseHistory;
import com.educator.learnfast.model.EnrollmentStatusEnum;
import com.educator.learnfast.model.UserInfo;

public interface UserDAO {
	boolean saveUser(UserInfo user);

	boolean deleteUser(int userId);

	ArrayList<CourseHistory> getCourseHistory(int userId, String status);

	UserInfo userLogin(String email, String pass);

	int countNoOfEnrollment(int userId);

	boolean updateNoOfCoursesEnrolled(int userId);

	boolean findByUserEmail(String email);

}
