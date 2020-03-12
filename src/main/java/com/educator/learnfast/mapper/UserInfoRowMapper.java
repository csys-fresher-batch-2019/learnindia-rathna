package com.educator.learnfast.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educator.learnfast.models.UserInfo;

public class UserInfoRowMapper implements RowMapper<UserInfo> {

	public UserInfo mapRow(ResultSet rs, int row) throws SQLException {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(rs.getInt("user_id"));
		userInfo.setUserName(rs.getString("username"));
		userInfo.setUserPassword(rs.getString("user_password"));
		userInfo.setEmailId(rs.getString("email_id"));
		userInfo.setNoOfCoursesEnrolled(rs.getInt("no_of_courses_enrolled"));
		return userInfo;
	}
}
