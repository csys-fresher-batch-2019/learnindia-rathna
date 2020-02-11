package com.educator.LearnFast.Courses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import com.educator.LearnFast.Exception.ConnectionException;
import com.educator.LearnFast.Exception.DBException;
import com.educator.LearnFast.Users.TestConnection;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CoursesDAOImplementation implements CoursesDAO {
	public boolean saveCourse(CourseInfo course) {
		String sqlsave = null;
		 sqlsave = "insert into course_info(course_id,course_name,duration_of_course,instructor_name,instructor_id,course_category,price) "
				+ "values(course_id_seq.nextval,'"+course.getCourseName()+"',"+course.getDurationOfCourse()+",'"+course.getInstructorName()+"',"+course.getInstructorId()+",'"+course.getCourseCategory()+"',"+course.getPrice()+")";
		 int row = 0;
		 try(Connection con = TestConnection.getConnection();
					Statement stmt = con.createStatement();){
						 row = stmt.executeUpdate(sqlsave);
					 }
					 catch( Exception ex) {
						 System.out.println("Error Importing the Course:course  may be already exists or some important course details not available");
					 }
		 if(row == 1)
			 return true;
		 else 
			 return false;
	}

		
		public int removeCourse(int courseId) {
			String sqlremove = "delete course_info where course_id = '"+courseId+"'";
			int row = 0;
			try(Connection con = TestConnection.getConnection();
				Statement stmt = con.createStatement();){
					row = stmt.executeUpdate(sqlremove);
					}catch ( Exception e) {
					System.out.println("There is no such course");
				}
			return row;
		}
		
		public int getNoOfEnrollment(int courseId) {
			String sqlenrollment = "select count(enrollment_id) from enrollment_info where status=1 and course_id="+courseId+"";
			int row = 0;
			try (Connection con = TestConnection.getConnection();
				Statement stmt = con.createStatement();){
				try(ResultSet rs = stmt.executeQuery(sqlenrollment);){
					if(rs.next());
					 row = rs.getInt(1);
				}} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("There is no such course");
				}
			return row;
		}
		
		public ArrayList<CourseInfo> displayCourses(CourseInfo course) {
			int key=0;
			String sql=null;
			if(course.getCourseName().length()!=0) {
				if(course.getInstructorName().length()!=0)
					key = 2;
				else if(course.getPrice()==0)
					key = 3;
				else
					key = 1;
			}
			else if(course.getCourseCategory().length()!=0)
				key = 4;
			else if(course.getPrice() ==0)
				key =5;
			else if(course.getCourseCategory().length()!=0 && course.getInstructorName().length()!=0)
				key =6;
			else if(course.getInstructorName().length()!=0)
				key = 9;
			switch(key) {
			case 0:
				sql = "select *from course_info";
				break;
			case 1:
				sql = "select *from course_info where course_name = '"+course.getCourseName()+"'";
				System.out.println(sql);
				break;
			case 2:
				sql = "select *from course_info where course_name = '"+course.getCourseName()+"' "
						+ "and instructor_name = '"+course.getInstructorName()+"'";
				break;
			case 3:
				sql = "select *from course_info where course_name = '"+course.getCourseName()+"' and price = 0";
				break;
			case 4:
				sql = "select *from course_info where course_category = '"+course.getCourseCategory()+"'";
				break;
			case 5:
				sql = "select *from course_info where price = 0";
				break;
			case 6:
				sql = "select *from course_info where course_category = '"+course.getCourseCategory()+"' "
						+ "and instructor_name = '"+course.getInstructorName()+"'";
				break;
			default:
				System.out.println("Invalid Operation");
				break;
			}
			ArrayList<CourseInfo> out = new ArrayList<CourseInfo>();
			 try(Connection con = TestConnection.getConnection();
					Statement stmt = con.createStatement();){
					try (ResultSet rs=stmt.executeQuery(sql);){
						while(rs.next()) {
							CourseInfo obj = new CourseInfo();
							obj.setCourseId(rs.getInt("course_id"));
							obj.setCourseName(rs.getString("course_name"));
							obj.setDurationOfCourse(rs.getInt("duration_of_course"));
							obj.setInstructorName(rs.getString("instructor_name"));
							obj.setCourseCategory(rs.getString("course_category"));
							obj.setPrice(rs.getInt("price"));
							out.add(obj);
						}
					}} catch ( Exception e) {
						// TODO Auto-generated catch block
						System.out.println("There is no such course");
					}
			return out;
			}
		
		public void addCourseRating(int rating,int courseId,int userId) {
			int row=0;
			String sql = "update enrollment_info set rating = ? where course_id = ? and user_id = ? and rating is null";
			 try (Connection con = TestConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
					ps.setInt(1, rating);
					ps.setInt(2, courseId);
					ps.setInt(3, userId);
					row = ps.executeUpdate();
					} catch ( Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid Rating");
					}
			if(row == 1) {
				System.out.println("Thanks for Your Rating");
				String sql1 = "update course_info set rating = (select avg(rating) from enrollment_info where course_id = "+courseId+") where course_id = "+courseId+"";
				try(Connection con1 = TestConnection.getConnection();
					Statement stmt = con1.createStatement();){
					int row1 = stmt.executeUpdate(sql1);
				} catch ( Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Average Rating cannot be added");
				}
			}
			else
			{
				System.out.print("You Cannot Add Rating:");
				System.out.println("you may already rated this course or the course id you have enterd is not in your course list");
			}
		}	
}
