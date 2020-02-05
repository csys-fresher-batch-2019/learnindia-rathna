package com.educator.LearnFast.Welcome;

import java.util.Scanner;

import com.educator.LearnFast.Users.UserDAOImplementation;
import com.educator.LearnFast.Users.UserInfo;

public class TestAddUser {
	
	public static void main() throws Exception {
		String pass1,pass2;
		UserDAOImplementation add1 = new UserDAOImplementation();
		UserInfo user1 = new UserInfo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name");
		user1.userName = sc.nextLine();
		System.out.println("Enter EmailId");
		user1.emailId = sc.nextLine();
		System.out.println("Enter Password (*password must contain minimum 8 characters)");
		pass1 = sc.next();
		System.out.println("Confirm Password");
		pass2 = sc.next();
		if(pass1.equalsIgnoreCase(pass2))
			user1.userPassword = pass1;
		else
			System.out.println("Password and Confirm Password must be same");
		add1.addUser(user1);
	}
}
