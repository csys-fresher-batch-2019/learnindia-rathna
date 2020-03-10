package com.educator.learnfast.util;

import java.sql.DriverManager;
import java.sql.Connection;

public class TestConnection{
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		System.out.println(connection);
		return connection;
	}

}
