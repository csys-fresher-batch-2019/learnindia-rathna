package com.educator.LearnFast.Courses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import com.educator.LearnFast.Users.TestConnection;

import java.sql.ResultSet;


public class CoursesDAOImplementation implements CoursesDAO {
	public void saveCourse(CourseInfo course) throws Exception {
		String sqlsave = null;
		try {
		 sqlsave = "insert into course_info(course_id,course_name,duration_of_course,instructor_name,instructor_id,course_category,price) "
				+ "values(course_id_seq.nextval,'"+course.courseName+"',"+course.durationOfCourse+",'"+course.instructorName+"',"+course.instructorId+",'"+course.courseCategory+"',"+course.price+")";
		//throw new Exception("You have already enrolled the course");
		}catch(Exception ex) {
			System.out.println("You have already enrolled the course");
			System.out.println(ex.getMessage());
		}
		//System.out.println(sqlsave);
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		int row = stmt.executeUpdate(sqlsave);
		//System.out.println("what?");
		//System.out.println(row);
		//System.out.println(sqlsave);
		con.close();
		}
		
		public void removeCourse(int courseId) throws Exception {
			String sqlremove = "delete course_info where course_id = '"+courseId+"'";
			Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();
			int row = stmt.executeUpdate(sqlremove);
			//System.out.println(row);
			//System.out.println(sqlremove);
			System.out.println("Course Successfully Removed");
			con.close();
		}
		
		public int getNoOfEnrollment(int courseId) throws Exception {
			String sqlenrollment = "select count(enrollment_id) from enrollment_info where status=1 and course_id="+courseId+"";
			//System.out.println(sqlenrollment);
			Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlenrollment);
			rs.next();
				int row = rs.getInt(1);
				System.out.println(row);
			con.close();
			//System.out.println(sqlenrollment);*/
			return row;
		}
		
		public ArrayList<CourseInfo> displayCourses(CourseInfo course) throws Exception{
			int key=0;
			String sql;
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
			else if(course.courseCategory.length() != 0 && course.instructorName.length() !=0 )
				key =6;
			else if(course.instructorName.length()!=0)
				key = 9;
			//System.out.println(key);
			Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = null;
			switch(key) {
			case 0:
				sql = "select *from course_info";
				rs = stmt.executeQuery(sql);
				break;
			case 1:
				sql = "select *from course_info where course_name = '"+course.courseName+"'";
				rs = stmt.executeQuery(sql);
				break;
			case 2:
				sql = "select *from course_info where course_name = '"+course.courseName+"' "
						+ "and instructor_name = '"+course.instructorName+"'";
				rs = stmt.executeQuery(sql);
				break;
			case 3:
				sql = "select *from course_info where course_name = '"+course.courseName+"' and price = 0";
				rs = stmt.executeQuery(sql);
				break;
			case 4:
				sql = "select *from course_info where course_category = '"+course.courseCategory+"'";
				rs = stmt.executeQuery(sql);
				break;
			case 5:
				sql = "select *from course_info where price = 0";
				rs = stmt.executeQuery(sql);
				break;
			case 6:
				sql = "select *from course_info where course_category = '"+course.courseCategory+"' "
						+ "and instructor_name = '"+course.instructorName+"'";
				rs = stmt.executeQuery(sql);
				break;
			default:
				System.out.println("Invalid Operation");
				break;
			}
			//System.out.println("executed");
			ArrayList<CourseInfo> out = new ArrayList<CourseInfo>();
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
			//con.close();
			return out;
		}
		
		public void addCourseRating(int rating,int courseId,int userId) throws Exception {
			Connection con = TestConnection.getConnection();
			String sql = "update enrollment_info set rating = ? where course_id = ? and user_id = ? and rating is null";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, rating);
			ps.setInt(2, courseId);
			ps.setInt(3, userId);
			int row = ps.executeUpdate();
			if(row == 1) {
				System.out.println("Thanks for Your Rating");
				String sql1 = "update course_info set rating = (select avg(rating) from enrollment_info where course_id = "+courseId+") where course_id = "+courseId+"";
				Statement stmt = con.createStatement();
				int row1 = stmt.executeUpdate(sql1);
			}
			else
			{
				System.out.print("You Cannot Add Rating:");
				System.out.println("you may already rated this course or the course id you have enterd is not in your course list");
			}
		}
		
}
