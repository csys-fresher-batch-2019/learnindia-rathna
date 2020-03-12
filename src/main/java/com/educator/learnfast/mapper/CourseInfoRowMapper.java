package com.educator.learnfast.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educator.learnfast.models.CourseInfo;

public class CourseInfoRowMapper implements RowMapper<CourseInfo> {

	public CourseInfo mapRow(ResultSet rs, int row) throws SQLException {
		CourseInfo courseInfo = new CourseInfo();
		courseInfo.setCourseId(rs.getInt("course_id"));
		courseInfo.setCourseName(rs.getString("course_name"));
		courseInfo.setDurationOfCourse(rs.getInt("duration_of_course"));
		courseInfo.setInstructorName(rs.getString("instructor_name"));
		courseInfo.setCourseCategory(rs.getString("course_category"));
		courseInfo.setPrice(rs.getInt("price"));
		courseInfo.setRating(rs.getInt("rating"));
		return courseInfo;
	}

}
