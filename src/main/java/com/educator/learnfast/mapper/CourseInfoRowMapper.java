package com.educator.learnfast.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educator.learnfast.models.CourseInfo;

public class CourseInfoRowMapper implements RowMapper<CourseInfo>{
	
	public CourseInfo mapRow(ResultSet rs, int row) throws SQLException {
		CourseInfo ci = new CourseInfo();
		ci.setCourseId(rs.getInt("course_id"));
		ci.setCourseName(rs.getString("course_name"));
		ci.setDurationOfCourse(rs.getInt("duration_of_course"));
		ci.setInstructorName(rs.getString("instructor_name"));
		ci.setCourseCategory(rs.getString("course_category"));
		ci.setPrice(rs.getInt("price"));
		return ci;
	}

}
