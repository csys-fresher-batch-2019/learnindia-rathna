package com.educator.learnfast.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.educator.learnfast.models.CourseHistory;
import com.educator.learnfast.models.UserInfo;

public interface UserDAO {
	boolean addUser(UserInfo user) throws Exception;
	
	boolean deleteUser(int userId) throws Exception;
	
	int getNoOfCourses(int userid) throws Exception;
	
	ArrayList<CourseHistory> getCourseHistory(int userId,int status) throws Exception;
	
	UserInfo UserLogin(String email,String pass) throws Exception;
	
	boolean Emailidcheck(String email) throws Exception;
}
