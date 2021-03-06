package com.educator.learnfast.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.educator.learnfast.dao.UserDAO;
import com.educator.learnfast.mapper.CourseHistoryRowMapper;
import com.educator.learnfast.mapper.UserInfoRowMapper;
import com.educator.learnfast.model.CourseHistory;
import com.educator.learnfast.model.UserInfo;
import com.educator.learnfast.util.ConnectionUtil;
import com.educator.learnfast.util.Logger;

public class UserDAOImplementation implements UserDAO {

	Logger logger = Logger.getInstance();
	private DriverManagerDataSource dataSource = ConnectionUtil.getDataSource();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	public boolean saveUser(UserInfo user) {
		String sql = "insert into user_info(user_id,username,email_id,user_password) "
				+ "values(user_id_seq.nextval,?,?,?)";
		int row = jdbcTemplate.update(sql, user.getUserName(), user.getEmailId(), user.getUserPassword());
		if (row == 1)
			return true;
		else
			return false;
	}

	public boolean deleteUser(int userId) {
		String sqldelete = "delete from user_info where user_id = ?";
		int row = jdbcTemplate.update(sqldelete, userId);
		if (row == 1)
			return true;
		else
			return false;
	}

	public int countNoOfEnrollment(int userId) {
		String sql = "select count(enrollment_id) from enrollment_info where status='ONGOING' and user_id = ?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, userId);
		return count;
	}

	public List<CourseHistory> getCourseHistory(int userId, String status) {
		String sql = "select c.course_name,c.course_id,c.instructor_name,e.enrolled_date,e.ending_date,e.enrollment_id "
				+ "from course_info c,enrollment_info e where c.course_id = e.course_id and e.user_id = ? and e.status = ?";
		List<CourseHistory> chrs = new ArrayList<>();
		CourseHistoryRowMapper rowMapper = new CourseHistoryRowMapper();
		chrs = (ArrayList<CourseHistory>) jdbcTemplate.query(sql, rowMapper, userId, status);
		logger.info(chrs);
		return chrs;
	}

	public UserInfo userLogin(String email, String pass) {
		UserInfo ui = new UserInfo();
		String sql = "select *from user_info where email_id= ? and user_password = ?";
		UserInfoRowMapper rowMapper = new UserInfoRowMapper();
		try {
			ui = jdbcTemplate.queryForObject(sql, rowMapper, email, pass);
		} catch (EmptyResultDataAccessException e) {
			logger.info("No data found");
			logger.debug(e);
		}
		return ui;
	}

	public boolean updateNoOfCoursesEnrolled(int userId) {
		String sql = "update user_info set no_of_courses_enrolled = (no_of_courses_enrolled-1) where user_id = ?";
		int row = jdbcTemplate.update(sql, userId);
		if (row == 1)
			return true;
		else
			return false;
	}

	public boolean findByUserEmail(String email) {
		String sql = "select count(email_id) from user_info where email_id = ?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, email);
		if (count == 0)
			return true;
		else
			return false;
	}
}
