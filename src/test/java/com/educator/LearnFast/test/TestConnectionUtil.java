package com.educator.LearnFast.test;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.educator.learnfast.util.ConnectionUtil;

public class TestConnectionUtil {

	public static void main(String[] args) throws Exception {
		DriverManagerDataSource ds = ConnectionUtil.getDataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		System.out.println(jdbcTemplate);

	}

}
