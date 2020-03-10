package com.educator.learnfast.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educator.learnfast.models.UserInfo;

public class UserInfoRowMapper implements RowMapper<UserInfo>{

	public UserInfo mapRow(ResultSet rs, int row) throws SQLException {
		UserInfo ui = new UserInfo();
		ui.setUserId(rs.getInt("user_id"));
		ui.setUserName(rs.getString("username"));
		ui.setUserPassword(rs.getString("user_password"));
		ui.setEmailId(rs.getString("email_id"));
		ui.setNoOfCoursesEnrolled(rs.getInt("no_of_courses_enrolled"));
		return ui;
	}
}
