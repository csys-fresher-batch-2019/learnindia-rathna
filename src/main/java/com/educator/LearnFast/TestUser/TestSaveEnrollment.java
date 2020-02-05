package com.educator.LearnFast.TestUser;
import java.util.Scanner;

import com.educator.LearnFast.Enrollments.EnrollmentDAOImplementation;
import com.educator.LearnFast.Enrollments.EnrollmentInfo;

public class TestSaveEnrollment {

	public static void main(int id) throws Exception {
		EnrollmentInfo enInfo = new EnrollmentInfo();
		EnrollmentDAOImplementation enS = new EnrollmentDAOImplementation();
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter user id:");
		//enInfo.userId = sc.nextInt();
		enInfo.userId = id;
		System.out.println("Enter course id:");
		enInfo.courseId = sc.nextInt();
		enS.saveEnrollment(enInfo);
	}

}
