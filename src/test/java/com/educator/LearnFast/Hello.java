package com.educator.LearnFast;

import java.util.Scanner;

import com.educator.LearnFast.Users.UserDAOImplementation;
import com.educator.LearnFast.Users.UserInfo;

public class Hello {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("Hello Word");
		UserDAOImplementation add1 = new UserDAOImplementation();
		UserInfo user1 = new UserInfo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user name");
		user1.userName = sc.nextLine();
		System.out.println("Enter emailId");
		user1.emailId = sc.nextLine();
		System.out.println("Enter password");
		user1.userPassword = sc.nextLine();
		add1.addUser(user1);
	}

}
