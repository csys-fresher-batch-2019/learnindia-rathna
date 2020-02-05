package com.educator.LearnFast.TestUser;
import java.util.Scanner;

import com.educator.LearnFast.Users.UserDAOImplementation;

public class TestDeleteUser {
	
	public static void main(int useId) throws Exception
	{
		UserDAOImplementation userd = new UserDAOImplementation();
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter UserId");
		//int userId = sc.nextInt();
		userd.deleteUser(useId);
	}

}
