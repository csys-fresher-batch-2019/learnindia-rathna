package com.educator.LearnFast;
import java.util.Scanner;

import com.educator.LearnFast.Enrollments.EnrollmentDAOImplementation;
import com.educator.LearnFast.Enrollments.EnrollmentInfo;

public class TestFetchEnrollment {

	public static void main(String[] args) throws Exception {
		EnrollmentDAOImplementation fetch = new EnrollmentDAOImplementation();
		EnrollmentInfo res = new EnrollmentInfo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Enrollment Id:");
		int id = sc.nextInt();
		res = fetch.fetchEnrollment(id);
		//System.out.println(res.enrollmentId);
		//System.out.println(res.courseId);
		System.out.println(res.getEnrolledDate());
		System.out.println(res.getEndingDate());
		System.out.println(res.getStatus());
		
	}

}
