package com.educator.learnfast.dao.implemenation;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.educator.learnfast.dao.EnrollmentDAO;
import com.educator.learnfast.util.ConnectionUtil;
import com.educator.learnfast.util.Logger;

public class EnrollmentDAOImplementation implements EnrollmentDAO {
	Logger logger = Logger.getInstance();
	DriverManagerDataSource dataSource = ConnectionUtil.getDataSource();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	public boolean saveEnrollment(int userId, int courseId) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_INSERT_ENROLLMENT")
				.declareParameters(new SqlParameter("I_user_id", Types.INTEGER),
						new SqlParameter("I_course_id", Types.INTEGER),
						new SqlOutParameter("I_error_message", Types.VARCHAR));
		SqlParameterSource in = new MapSqlParameterSource().addValue("I_user_id", userId).addValue("I_course_id",
				courseId);
		String errorMsg = call.executeObject(String.class, in);
		if (errorMsg == null)
			return true;
		else
			return false;
	}

	public boolean deleteEnrollment(int CourseId, int UserId) {
		String sql1 = "delete from enrollment_info where course_id = ? and user_id = ?";
		int row = jdbcTemplate.update(sql1, CourseId, UserId);
		if (row == 1)
			return true;
		else
			return false;
	}

	public boolean saveEnrollmentRating(int courseId, int userId, int rating) {
		String sql = "update enrollment_info set rating = ? where course_id = ? and user_id = ? and rating is null";
		int row = jdbcTemplate.update(sql, rating, courseId, userId);
		if (row == 1)
			return true;
		else
			return false;
	}

}
