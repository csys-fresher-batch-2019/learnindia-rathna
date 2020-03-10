package com.educator.learnfast.DAO.implementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.educator.learnfast.DAO.EnrollmentDAO;
import com.educator.learnfast.Exception.DbException;
import com.educator.learnfast.Exception.InfoMessages;
import com.educator.learnfast.models.EnrollmentInfo;
import com.educator.learnfast.models.EnrollmentStatusEnum;
import com.educator.learnfast.util.ConnectionUtil;
import com.educator.learnfast.util.Logger;
import com.educator.learnfast.util.TestConnection;

public class EnrollmentDAOImplementation implements EnrollmentDAO {
	Logger logger = Logger.getInstance();
	DriverManagerDataSource dataSource = ConnectionUtil.getDataSource();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	public boolean saveEnrollment(int userId, int courseId) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_INSERT_ENROLLMENT").declareParameters(
							  new SqlParameter("I_user_id", Types.INTEGER), new SqlParameter("I_course_id", Types.INTEGER), new SqlOutParameter("I_error_message", Types.VARCHAR));
		SqlParameterSource in = new MapSqlParameterSource().addValue("I_user_id",userId).addValue("I_course_id", courseId);
		String errorMsg = call.executeObject(String.class, in);
		if(errorMsg == null)
			return true;
		else
			return false;
		
		/*
		 * List<SqlParameter> parameter = Arrays.asList(new SqlParameter(Types.INTEGER),
		 * new SqlParameter(Types.INTEGER), new
		 * SqlOutParameter("I_error_message",Types.VARCHAR)); Map<String> msg =
		 * jdbcTemplate.call(new CallableStatementCreator() {
		 * 
		 * @Override public CallableStatement createCallableStatement(Connection con)
		 * throws SQLException { CallableStatement callableStatement =
		 * con.prepareCall("{call PR_INSERT_ENROLLMENT(?,?,?)}");
		 * callableStatement.setInt(1, userId); callableStatement.setInt(2, courseId);
		 * callableStatement.registerOutParameter("I_error_message", Types.VARCHAR);
		 * return callableStatement; } }, parameter); System.out.println("hello2");
		 * if(msg.get("I_error_message")==null) { System.out.println("hello"); return
		 * true;} else { System.out.println(msg); return false; } jdbcTemplate.ca
		 */
	}

	public boolean removeEnrollment(int CourseId, int UserId) {
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
