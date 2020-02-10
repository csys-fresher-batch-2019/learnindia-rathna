package com.educator.LearnFast.Users;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {
	int addUser(UserInfo user) throws Exception;
	
	void deleteUser(int userId) throws Exception;
	
	int getNoOfCourses(int userid) throws Exception;
	
	ArrayList getCourseHistory(int userId,int status) throws Exception;
	
	int UserLogin(String email,String pass) throws Exception;
	
	
}
