package com.educator.learnfast.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educator.learnfast.models.CourseHistory;

public class CourseHistoryRowMapper implements RowMapper<CourseHistory> {

	public CourseHistory mapRow(ResultSet rs, int row) throws SQLException {
		CourseHistory ch = new CourseHistory();
		ch.setCourseName(rs.getString("course_name"));
		ch.setCourseId(rs.getInt("course_id"));
		ch.setInstructorName(rs.getString("instructor_name"));
		ch.setEnrolledDate(rs.getDate("enrolled_date").toLocalDate());
		ch.setEndingDate(rs.getDate("ending_date").toLocalDate());
		ch.setEnrollmentId(rs.getInt("enrollment_id"));
		return ch;
	}
}
