package com.educator.LearnFast;
import java.sql.SQLException;
import java.util.Scanner;

import com.educator.LearnFast.Users.UserDAOImplementation;

public class TestgetNoOfCourses {
	public static void main(String[] args) throws Exception {
		UserDAOImplementation usergd = new UserDAOImplementation();
		System.out.println("Enter user ID:");
		Scanner sc = new Scanner(System.in);
		int userId = sc.nextInt();
		usergd.getNoOfCourses(userId);
	}

}
