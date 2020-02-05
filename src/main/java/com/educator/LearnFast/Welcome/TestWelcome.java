package com.educator.LearnFast.Welcome;

import java.util.Scanner;

import com.educator.LearnFast.TestInstructor.TestInstructorLogin;
import com.educator.LearnFast.TestUser.TestUserLogin;

public class TestWelcome {

	public static void main(String[] args) throws Exception {
		System.out.println("**********************************************WELCOME TO LEARN INDIA**************************************************");
		System.out.println("Enter 1 for UserLogin");
		System.out.println("Enter 2 for InstructorLogin");
		System.out.println("Enter 3 to CreateAccount");
		System.out.println("Enter 4 to Register as Instructor");
		int key;
		Scanner sc = new Scanner(System.in);
		key = sc.nextInt();
		switch(key) {
		case 1:
			TestUserLogin.main();
			break;
		case 2:
			TestInstructorLogin.main();
			break;
		case 3:
			TestAddUser.main();
			break;
		case 4:
			TestSaveInstructor.main();
			break;
		default:
			System.out.println("Invalid Operation");
		}
	}

}
