package com.educator.LearnFast.TestUser;

import java.util.Scanner;

import com.educator.LearnFast.Users.UserDAOImplementation;

public class TestUserLogin {

public static void main() throws Exception {
		Scanner sc = new Scanner(System.in);
		UserDAOImplementation imp = new UserDAOImplementation();
		System.out.println("Enter Email Id:");
		String email = sc.next();
		System.out.println("Enter password:");
		String pass = sc.next();
		imp.UserLogin(email, pass);
	}

}
