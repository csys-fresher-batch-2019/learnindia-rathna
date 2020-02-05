package com.educator.LearnFast.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.educator.LearnFast.TestUser.TestCourseHistory;

import com.educator.LearnFast.TestUser.*;


import com.educator.LearnFast.TestRemoveEnrollmentNew;

import com.educator.LearnFast.Courses.CourseHistory;
import com.educator.LearnFast.Enrollments.EnrollmentDAOImplementation;

public class UserDAOImplementation implements UserDAO{
	/**
	 * @throws Exception 
	 *  
	 * 
	 */
	
	public int addUser(UserInfo user) throws Exception {
		String sqlinsert = "insert into user_info(user_id,username,email_id,user_password) "
				+ "values(user_id_seq.nextval,'"+user.userName+"','"+user.emailId+"','"+user.userPassword+"')";
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		int row = stmt.executeUpdate(sqlinsert);
		//System.out.println(row);
		//System.out.println(sqlinsert);
		System.out.println("Account Created");
		con.close();
		return 1;
	}
	
	public void deleteUser(int userId) throws Exception {
		Connection con = TestConnection.getConnection();
		String sql1 = "delete from enrollment_info where user_id = "+userId+"";
		Statement stmt1 = con.createStatement();
		int row1 = stmt1.executeUpdate(sql1);
		String sqldelete = "delete from user_info where user_id = "+userId+"";
		//System.out.println(sqldelete);
		Statement stmt = con.createStatement();
		int row = stmt.executeUpdate(sqldelete);
		//System.out.println(row);
		//System.out.println(sqldelete);
		System.out.println("Account Deleted");
	}
	
	public int getNoOfCourses(int userId) throws Exception {
		String sqlNoOfCourses = "select no_of_courses_enrolled from user_info where user_id = "+userId+"";
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlNoOfCourses);
		rs.next();
		int val = rs.getInt(1);
		con.close();
		//System.out.println(val);
		//System.out.println(sqlNoOfCourses);
		return val;
	}
	
	public  ArrayList<CourseHistory> getCourseHistory(int userId,int status) throws Exception{
		String query;
		switch(status) {
		case 0:
			query = "select c.course_name,c.course_id,c.instructor_name,e.enrolled_date,e.ending_date "
					+ "from course_info c,enrollment_info e where c.course_id = e.course_id and e.user_id = "+userId+" and e.status = 'COMPLETED'";
			break;
		case 1:
			query = "select c.course_name,c.course_id,c.instructor_name,e.enrolled_date,e.ending_date "
					+ "from course_info c,enrollment_info e where c.course_id = e.course_id and e.user_id = "+userId+" and e.status = 'ONGOING'";
			break;
		default:
			query = "select c.course_name,c.course_id,c.instructor_name,e.enrolled_date,e.ending_date "
					+ "from course_info c,enrollment_info e where c.course_id = e.course_id and e.user_id = "+userId+"";
			break;		
		}
		ArrayList<CourseHistory> chrs = new ArrayList<CourseHistory>();
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		//CourseHistory ch = new CourseHistory();
		while(rs.next()) {
			CourseHistory ch = new CourseHistory();
			ch.courseName = rs.getString("course_name");
			ch.courseId = rs.getInt("course_id");
			ch.instructorName = rs.getString("instructor_name");
			ch.enrolled_date = rs.getDate("enrolled_date");
			ch.ending_date = rs.getDate("ending_date");
			chrs.add(ch);
		}
		con.close();
		return chrs;
	}
	
	public boolean UserLogin(String email, String pass) throws Exception {
		Scanner  sc = new Scanner(System.in);
		String sql ="select user_password,user_id from user_info where email_id= '"+email+"'";
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		String passData = null;
		int id = 0;
		rs = stmt.executeQuery(sql);
		if(rs.next())
		{
		passData = rs.getString("user_password");
		id = rs.getInt("user_id");
		}
		else
			System.out.println("Invaild Email or Password please try again");
		//System.out.println(id);
		if(id!=0) {
			return true;
		/*if(passData.equalsIgnoreCase(pass)) {
			System.out.println("Login Succesful");
			int entry =1,key = 0;
			while(entry ==1)
			{
			System.out.println("Enter 1 to Enroll course");
			System.out.println("Enter 2 to withdraw a course");
			System.out.println("Enter 3 to search courses");
			System.out.println("Enter 4 to leave account");
			System.out.println("Enter 5 to see course history");
			System.out.println("Enter 6 to Add Course Rating");
			System.out.println("Enter 7 to logout");
			String sql2 = "select user_id from user_info where email_id = ?";
			Connection con2 = TestConnection.getConnection();
			PreparedStatement ps2 = con2.prepareStatement(sql2);
			ps2.setString(1, email);
			ResultSet rs2 = ps2.executeQuery();
			if(rs2.next()) {
				userId = rs2.getInt(1);
			}
			key = sc.nextInt();
			switch(key) {
			case 0:
				System.out.println("perform any operation");
				break;
			case 1:
				TestSaveEnrollment.main(id);
				break;
			case 2:
				System.out.println("Your Course List");
				TestCourseHistoryNew.main(id, 1);
				int courseId = sc.nextInt();
				EnrollmentDAOImplementation met = new EnrollmentDAOImplementation();
				met.removeEnrollment(courseId, id);
				break;
			case 3:
				TestDisplayCourse.main();
				break;
			case 4:
				TestDeleteUser.main(id);
				entry = 0;
				break;
			case 5:
				TestCourseHistory.main(id);
				break;
			case 6:
				TestCourseRating.main(id);
				break;
			case 7:
				System.out.println("Logged Out Successfully");
				entry =0;
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
			key = 0;
			}
		}*/
		}
		else
		return false;
	}
	
	
}

