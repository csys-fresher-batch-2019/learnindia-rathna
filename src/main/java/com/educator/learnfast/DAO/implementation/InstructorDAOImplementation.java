package com.educator.learnfast.DAO.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.educator.learnfast.DAO.InstructorDAO;
import com.educator.learnfast.mapper.InstructorInfoRowMapper;
import com.educator.learnfast.models.EnrollmentDetails;
import com.educator.learnfast.models.InstructorInfo;
import com.educator.learnfast.util.ConnectionUtil;
import com.educator.learnfast.util.TestConnection;
import javax.sql.DataSource;

public class InstructorDAOImplementation implements InstructorDAO {

	private DriverManagerDataSource dataSource = ConnectionUtil.getDataSource();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	public boolean saveInstructor(InstructorInfo in) {
		String sql = "insert into instructor_info(instructor_id,instructor_name,instructor_email,instructor_password,area_of_interest) values (instructor_id_seq.nextval,?,?,?,?)";
		int row = jdbcTemplate.update(sql, in.getInstructorName(), in.getInstructorEmail(), in.getInstructorPassword(),
				in.getAreaOfInterest());
		if (row == 1)
			return true;
		else
			return false;
	}

	public InstructorInfo instructorLogin(String email, String pass) {
		String sql = "select *from instructor_info where instructor_email = ? and instructor_password = ?";
		InstructorInfo insInfo = new InstructorInfo();
		InstructorInfoRowMapper rowMapper1 = new InstructorInfoRowMapper();
		insInfo = jdbcTemplate.queryForObject(sql, rowMapper1, email, pass);
		return insInfo;
	}

	public boolean getEmail(String email) {
		String sql = "select count(instructor_email) from instructor_info where instructor_email = ?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, email);
		if (count == 0)
			return true;
		else
			return false;
	}
}
