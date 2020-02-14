package com.educator.learnfast.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.educator.learnfast.DAO.UserDAO;
import com.educator.learnfast.models.CourseHistory;
import com.educator.learnfast.models.UserInfo;
import com.educator.learnfast.util.Logger;
import com.educator.learnfast.util.TestConnection;

public class UserDAOImplementation implements UserDAO{
Logger logger = Logger.getInstance();
	
	public boolean addUser(UserInfo user) throws Exception {
		int row = 0;
		String sqlinsert = "insert into user_info(user_id,username,email_id,user_password) "
				+ "values(user_id_seq.nextval,'"+user.getUserName()+"','"+user.getEmailId()+"','"+user.getUserPassword()+"')";
		Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();
			row = stmt.executeUpdate(sqlinsert);
				logger.info("Account Created");
		if(row ==1)
			return true;
		else
			return false;
	}
	
	public boolean deleteUser(int userId) throws Exception {
		int row = 0,row1 = 0;
		String sql1 = "delete from enrollment_info where user_id = "+userId+"";
		try(Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();){
			row = stmt.executeUpdate(sql1);
		System.out.println(row);
		String sqldelete = "delete from user_info where user_id = "+userId+"";
		try (Connection con1 = TestConnection.getConnection();
			Statement stmt1 = con1.createStatement();){
				row1 = stmt1.executeUpdate(sqldelete);
		}} catch ( Exception e) {
				System.out.println("Cannot Delete User Details");
			}
		System.out.println(row1);
		logger.info("Account Deleted");
		if(row >= 1 && row1 ==1) {
			return true;
		}
		else
			return false;
	}
	
	public int getNoOfCourses(int userId) {
		String sqlNoOfCourses = "select no_of_courses_enrolled from user_info where user_id = "+userId+"";
		int val = 0;
		try (Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();){
			try(ResultSet rs = stmt.executeQuery(sqlNoOfCourses);){
			if(rs.next());
			val = rs.getInt(1);
			con.close();
			stmt.close();
		}} catch (Exception e) {
			System.out.println("Cannot fetch no.of.enrollments");
		}
		return val;
	}
	
	public  ArrayList<CourseHistory> getCourseHistory(int userId,int status){
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
		try (Connection con = TestConnection.getConnection();
			Statement stmt =  con.createStatement();){
			try(ResultSet rs = stmt.executeQuery(query);){
			while(rs.next()) {
				CourseHistory ch = new CourseHistory();
				ch.setCourseName(rs.getString("course_name"));
				ch.setCourseId(rs.getInt("course_id"));
				ch.setInstructorName(rs.getString("instructor_name"));
				ch.setEnrolled_date(rs.getDate("enrolled_date").toLocalDate());
				ch.setEnding_date(rs.getDate("ending_date").toLocalDate());
				chrs.add(ch);
			}
		} }catch (Exception e) {
			System.out.println("Cannot Fetch Course History");
		}
		return chrs;
	}
	
	public UserInfo UserLogin(String email, String pass) {
		String sql ="select *from user_info where email_id= ?";
		String passData;
		UserInfo obj = new UserInfo();
		try(Connection con = TestConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1,email);
			try(ResultSet rs = ps.executeQuery();){
			if(rs.next())
			{
			passData = rs.getString("user_password");
			if(passData.equals(pass)) {
				obj.setUserId(rs.getInt("user_id"));
				obj.setUserName(rs.getString("username"));
				obj.setUserPassword(rs.getString("user_password"));
				obj.setEmailId(rs.getString("email_id"));
				obj.setNoOfCoursesEnrolled(rs.getInt("no_of_courses_enrolled"));
				logger.info(obj.getUserName());
				logger.info(obj.getEmailId());
				logger.info(obj.getUserPassword());
				}
			else
				logger.info("Invalid username or passowrd");
		}
			else
				logger.info("Invalid UserName or Password");
			}}catch(Exception e) {
				logger.info("cannot check username and password");
			}

		return obj;
	}
}

