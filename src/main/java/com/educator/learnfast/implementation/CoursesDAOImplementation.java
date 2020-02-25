package com.educator.learnfast.implementation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.educator.learnfast.DAO.CoursesDAO;
import com.educator.learnfast.Exception.DbException;
import com.educator.learnfast.Exception.InfoMessages;
import com.educator.learnfast.models.ContentInfo;
import com.educator.learnfast.models.CourseInfo;
import com.educator.learnfast.util.Logger;
import com.educator.learnfast.util.TestConnection;



public class CoursesDAOImplementation implements CoursesDAO {
	Logger logger = Logger.getInstance();
	public boolean saveCourse(CourseInfo course) throws DbException {
		String sqlsave = null;
		 sqlsave = "insert into course_info(course_id,course_name,duration_of_course,instructor_name,instructor_id,course_category,price) "
				+ "values(course_id_seq.nextval,?,?,?,?,?,?)";
		 int row = 0;
		try( Connection con = TestConnection.getConnection();
					PreparedStatement ps = con.prepareStatement(sqlsave);){
						 ps.setString(1, course.getCourseName());
						 ps.setInt(2, course.getDurationOfCourse());
						 ps.setString(3, course.getInstructorName());
						 ps.setInt(4, course.getInstructorId());
						 ps.setString(5, course.getCourseCategory());
						 ps.setInt(6, course.getPrice());
						row = ps.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(InfoMessages.ADDCOURSE);
		}
		catch(Exception e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
		 if(row == 1)
			 return true;
		 else 
			 return false;
	}

		
		public boolean removeCourse(int courseId) throws DbException {
			String sqlremove = "delete course_info where course_id = ?";
			int row = 0;
			try(Connection con = TestConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlremove)){
					ps.setInt(1, courseId);
					row = ps.executeUpdate();
					}catch(SQLException e) {
						throw new DbException(InfoMessages.DELETECOURSE);
					}catch ( Exception e) {
						throw new DbException(InfoMessages.CONNECTION);
				}
			if(row == 1)
				return true;
			else
				return false;
		}
		
		public int getNoOfEnrollment(int courseId) throws Exception {
			String sqlenrollment = "select count(enrollment_id) from enrollment_info where status='ONGOING' and course_id=?";
			int row = 0;
			try(Connection con = TestConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlenrollment);){
				ps.setInt(1,courseId);
				try(ResultSet rs = ps.executeQuery();){
					if(rs.next());
					 row = rs.getInt(1);
			}}catch(SQLException e) {
				throw new DbException(InfoMessages.GETENROLLMENT);
			}catch(Exception e) {
				throw new DbException(InfoMessages.CONNECTION);
			}
			return row;
		}
		
		public ArrayList<CourseInfo> displayCourses(CourseInfo course) throws DbException {
			String sql=null;
			StringBuilder sb1 = new StringBuilder("select *from course_info ");
			if(course.getCourseName().length()!=0) {
				sb1.append("where course_name like '%"+course.getCourseName()+"%'");
				if(course.getInstructorName().length()!=0)
					sb1.append("and instructor_name like '%"+course.getInstructorName()+"%'");
				else if(course.getPrice()==0)
					sb1.append("and price = 0");
			}
			else if(course.getCourseCategory().length()!=0)
				sb1.append("where course_category = '"+course.getCourseCategory()+"'");
			else if(course.getPrice() ==0)
				sb1.append("where price = 0");
			else if(course.getCourseCategory().length()!=0 && course.getInstructorName().length()!=0)
				sb1.append("where course_category = '"+course.getCourseCategory()+"' and instructor_name like '%"+course.getInstructorName()+"%'");
			sql = sb1.toString();
			System.out.println(sql);
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
							System.out.println(obj);
							out.add(obj);
							System.out.println("hi");
						}
					}}catch(DbException e) {
						throw new DbException(InfoMessages.SEARCHCOURSE);
					}
			 		catch ( Exception e) {
			 			throw new DbException(InfoMessages.CONNECTION);
					}
			return out;
			}
		
		public boolean addCourseRating(int rating,int courseId,int userId) throws DbException {
			int row=0,row1 = 0;
			String sql = "update enrollment_info set rating = ? where course_id = ? and user_id = ? and rating is null";
			 try (Connection con = TestConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
					ps.setInt(1, rating);
					ps.setInt(2, courseId);
					ps.setInt(3, userId);
					row = ps.executeUpdate();
					}catch(DbException e) {
						throw new DbException(InfoMessages.ENROLLMENTRATING);
					}
			 catch ( Exception e) {
						throw new DbException(InfoMessages.CONNECTION);
					}
			if(row == 1) {
				System.out.println("Thanks for Your Rating");
				String sql1 = "update course_info set rating = (select avg(rating) from enrollment_info where course_id = "+courseId+") where course_id = "+courseId+"";
				try(Connection con1 = TestConnection.getConnection();
					Statement stmt = con1.createStatement();){
					row1 = stmt.executeUpdate(sql1);
				} catch(DbException e) {
					throw new DbException(InfoMessages.COURSERATING);
				}
				catch ( Exception e) {
					throw new DbException(InfoMessages.CONNECTION);
				}
			}
			else
			{
				logger.info("You Cannot Add Rating:");
				logger.info("you may already rated this course or the course id you have enterd is not in your course list");
			}
			if(row==1&&row1==1) 
				return true;
			else
				return false;
		}

		public ArrayList<ContentInfo> fetchCourseContent(int courseId) throws Exception {
			String sql = "select course_content,chapter_no from content_info where course_id = ?";
			System.out.println("hello");
			System.out.println(courseId);
			ArrayList<ContentInfo> list = new ArrayList<ContentInfo>();
			try(Connection con = TestConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
				ps.setInt(1, courseId);
				try(ResultSet rs = ps.executeQuery();){
					while(rs.next()) {
						System.out.println("hi");
						ContentInfo ci = new ContentInfo();
						ci.setChapterNo(rs.getInt("chapter_no"));
						ci.setCourseContent(rs.getString("course_content"));
						System.out.println(ci.getCourseContent());
						list.add(ci);
					}
				}
			}catch(DbException e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.COURSECONTENT);
			}catch(Exception e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.CONNECTION);
			}
			return list;
		}	
}
