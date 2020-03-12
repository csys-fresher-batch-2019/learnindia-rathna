package com.educator.learnfast.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educator.learnfast.models.CourseHistory;

public class CourseHistoryRowMapper implements RowMapper<CourseHistory> {

	public CourseHistory mapRow(ResultSet rs, int row) throws SQLException {
		CourseHistory courseHistory = new CourseHistory();
		courseHistory.setCourseName(rs.getString("course_name"));
		courseHistory.setCourseId(rs.getInt("course_id"));
		courseHistory.setInstructorName(rs.getString("instructor_name"));
		courseHistory.setEnrolledDate(rs.getDate("enrolled_date").toLocalDate());
		courseHistory.setEndingDate(rs.getDate("ending_date").toLocalDate());
		courseHistory.setEnrollmentId(rs.getInt("enrollment_id"));
		return courseHistory;
	}
}
