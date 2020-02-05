package com.educator.LearnFast;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.educator.LearnFast.Enrollments.EnrollmentDAOImplementation;
import com.educator.LearnFast.Enrollments.EnrollmentInfo;
import com.educator.LearnFast.Users.TestConnection;

public class TestRemoveEnrollment {
	public static void main() throws Exception {
		EnrollmentDAOImplementation test = new EnrollmentDAOImplementation();
		//int courseId =0;
		//EnrollmentInfo ers = new EnrollmentInfo();
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter Enrollment Id:");
		//int id = sc.nextInt();
		System.out.println("Enter courseId:");
		int courseId = sc.nextInt();
		System.out.println("Enter userId:");
		int userId = sc.nextInt();
		test.removeEnrollment(courseId, userId);
	}

}
