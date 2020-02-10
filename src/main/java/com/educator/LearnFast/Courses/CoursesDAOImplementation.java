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
				+ "values(course_id_seq.nextval,'"+course.courseName+"',"+course.durationOfCourse+",'"+course.instructorName+"',"+course.instructorId+",'"+course.courseCategory+"',"+course.price+")";
		Connection con = null;
		 Statement stmt = null;
		 int row = 0;
		 try{
					con = TestConnection.getConnection();
					stmt = con.createStatement();
					 try {
							row = stmt.executeUpdate(sqlsave);
					 }
					 catch(SQLException ex) {
						 System.out.println("Error Importing the Course:course  may be already exists or some important course details not available");
					 }
					 con.close();
					 stmt.close();
				}
				catch(Exception ex) {
					System.out.println("Could not Establish Connection with DataBase");
				}
		 if(row == 1)
			 return true;
		 else 
			 return false;
	}

		
		public int removeCourse(int courseId) {
			String sqlremove = "delete course_info where course_id = '"+courseId+"'";
			Connection con = null;
			Statement stmt = null;
			int row = 0;
			try {
				con = TestConnection.getConnection();
				stmt = con.createStatement();
				try {
					row = stmt.executeUpdate(sqlremove);
				} catch (SQLException e) {
					System.out.println("There is no such course");
				}
				con.close();
				stmt.close();
			}catch(Exception e) {
				System.out.println("Could not Establish Connection with DataBase");
			}
			return row;
		}
		
		public int getNoOfEnrollment(int courseId) {
			String sqlenrollment = "select count(enrollment_id) from enrollment_info where status=1 and course_id="+courseId+"";
			Connection con = null;
			Statement stmt = null;
			int row = 0;
			ResultSet rs = null;
			try {
				con = TestConnection.getConnection();
				stmt = con.createStatement();
				try {
					rs = stmt.executeQuery(sqlenrollment);
					if(rs.next());
					 row = rs.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("There is no such course");
				}
				con.close();
				stmt.close();
			}catch(Exception e) {
				System.out.println("Could not Establish Connection with DataBase");
			}
			return row;
		}
		
		public ArrayList<CourseInfo> displayCourses(CourseInfo course) {
			int key=0;
			String sql=null;
			if(course.courseName.length()!=0) {
				if(course.instructorName.length()!=0)
					key = 2;
				else if(course.price==0)
					key = 3;
				else
					key = 1;
			}
			else if(course.courseCategory.length()!=0)
				key = 4;
			else if(course.price ==0)
				key =5;
			else if(course.courseCategory.length()!=0 && course.instructorName.length()!=0)
				key =6;
			else if(course.instructorName.length()!=0)
				key = 9;
			Connection con = null;
			 Statement stmt = null;
			ResultSet rs = null;
			System.out.println(key);
			switch(key) {
			case 0:
				sql = "select *from course_info";
				break;
			case 1:
				sql = "select *from course_info where course_name = '"+course.courseName+"'";
				System.out.println(sql);
				break;
			case 2:
				sql = "select *from course_info where course_name = '"+course.courseName+"' "
						+ "and instructor_name = '"+course.instructorName+"'";
				break;
			case 3:
				sql = "select *from course_info where course_name = '"+course.courseName+"' and price = 0";
				break;
			case 4:
				sql = "select *from course_info where course_category = '"+course.courseCategory+"'";
				break;
			case 5:
				sql = "select *from course_info where price = 0";
				break;
			case 6:
				sql = "select *from course_info where course_category = '"+course.courseCategory+"' "
						+ "and instructor_name = '"+course.instructorName+"'";
				break;
			default:
				System.out.println("Invalid Operation");
				break;
			}
			ArrayList<CourseInfo> out = new ArrayList<CourseInfo>();
			 try{
					con = TestConnection.getConnection();
					stmt = con.createStatement();
					try {
						rs=stmt.executeQuery(sql);
						while(rs.next()) {
							CourseInfo obj = new CourseInfo();
							obj.courseId = rs.getInt("course_id");
							obj.courseName = rs.getString("course_name");
							obj.durationOfCourse = rs.getInt("duration_of_course");
							obj.instructorName = rs.getString("instructor_name");
							obj.courseCategory = rs.getString("course_category");
							obj.price = rs.getInt("price");
							out.add(obj);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("There is no such course");
					}
					con.close();
					stmt.close();
				}
				catch(Exception ex) {
					System.out.println("Could not Establish Connection with DataBase");
				}
			return out;
		}
		
		public void addCourseRating(int rating,int courseId,int userId) {
			Connection con = null;
			PreparedStatement ps = null;
			int row=0;
			String sql = "update enrollment_info set rating = ? where course_id = ? and user_id = ? and rating is null";
			 try {
				con = TestConnection.getConnection();
				 ps = con.prepareStatement(sql);
					ps.setInt(1, rating);
					ps.setInt(2, courseId);
					ps.setInt(3, userId);
					try {
						row = ps.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid Rating");
					}
					con.close();
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Could not establish connection with DB");
			}
			if(row == 1) {
				Connection con1 = null;
				System.out.println("Thanks for Your Rating");
				String sql1 = "update course_info set rating = (select avg(rating) from enrollment_info where course_id = "+courseId+") where course_id = "+courseId+"";
				try {
					con1 = TestConnection.getConnection();
					Statement stmt = con1.createStatement();
					int row1 = stmt.executeUpdate(sql1);
					stmt.close();
					con1.close();
				} catch ( Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				System.out.print("You Cannot Add Rating:");
				System.out.println("you may already rated this course or the course id you have enterd is not in your course list");
			}
		}
		
}
