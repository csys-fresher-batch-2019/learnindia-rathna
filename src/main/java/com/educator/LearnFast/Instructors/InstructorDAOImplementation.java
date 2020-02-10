package com.educator.LearnFast.Instructors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.educator.LearnFast.TestConnection;
import com.educator.LearnFast.Enrollments.EnrollmentDetails;
import com.educator.LearnFast.TestInstructor.TestEnrollmentDetails;
import com.educator.LearnFast.TestInstructor.TestRemoveInstructor;
import com.educator.LearnFast.TestUser.TestDisplayCourse;

public class InstructorDAOImplementation implements InstructorDAO{

	public void saveInstructor(InstructorInfo in) {
		String sql = "insert into instructor_info(instructor_id,instructor_name,instructor_email,instructor_password,area_of_interest)"
				+ " values (instructor_id_seq.nextval,?,?,?,?)";
		int row = 0;
		try(Connection con = TestConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);){
		ps.setString(1, in.instructorName);
		ps.setString(2, in.instructorEmail);
		ps.setString(3, in.instructorPassword);
		ps.setString(4, in.areaOfInterest);
		//System.out.println(sql);
		row = ps.executeUpdate();
		//System.out.println("No.of.rows inserted:"+row);
		System.out.println("Instructor Account Created");
		}catch(Exception e) {
			System.out.println("Cannot add instructor");
		}
	}

	public void removeInstructor(int instructorId) {
		String sql ="delete instructor_info where instructor_id = ?";
		int row = 0;
		try(Connection con = TestConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);){
		ps.setInt(1, instructorId);
		//System.out.println(sql);
		row = ps.executeUpdate();
		//System.out.println("no.of.row.delete:"+row);
		System.out.println("Account Deleted");
		}catch(Exception e)
		{
			System.out.println("Cannot remove Instructor");
		}
	}
	
	public ArrayList<EnrollmentDetails> getEnrollmentDetails(int id){
		String sql = "select course_id,course_name,duration_of_course from course_info where instructor_id = ?";
		ArrayList<EnrollmentDetails> out = new ArrayList<EnrollmentDetails>();
		try(Connection con = TestConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);){
		ps.setInt(1, id);
		try(ResultSet rs = ps.executeQuery();){
		while(rs.next()) {
	
			String sql1 ="select count(enrollment_id) from enrollment_info where course_id = ?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setInt(1, rs.getInt("course_id"));
			ResultSet rs1 = ps1.executeQuery();
			EnrollmentDetails cla = new EnrollmentDetails();
			cla.courseName = rs.getString("course_name");
			cla.duration = rs.getInt("duration_of_course");
			if(rs1.next()) {
			cla.noOfEnrollments = rs1.getInt(1);
			}
			else
				cla.noOfEnrollments = 0;
			out.add(cla);
		}
		}}catch(Exception e) {
			System.out.println();
		}
		return out;
	}
	
	public void instructorLogin(String email,String pass) throws Exception {
		String sql = "select instructor_password from instructor_info where instructor_email = ?";
		try(Connection con = TestConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);){
		ps.setString(1, email);
		try(ResultSet rs = ps.executeQuery();){
		Scanner sc = new Scanner(System.in);
		if(rs.next()) {
			String password = rs.getString(1);
			if(password.equalsIgnoreCase(pass)) {
				String sql2 = "select instructor_id from instructor_info where instructor_email = ?";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setString(1, email);
				ResultSet rs2 = ps2.executeQuery();
				int id = 0;
				if(rs2.next())
					id =  rs2.getInt(1);
				int entry =1;
				while(entry==1) {
					System.out.println("Enter 1 to see Enrollment Details:");
					System.out.println("Enter 2 to Search Course:");
					System.out.println("Enter 3 to Leave Account:");
					System.out.println("Enter 4 to Logout");
					int key = sc.nextInt();
					switch(key) {
					case 1:
						TestEnrollmentDetails.main(id);
						break;
					case 2:
						TestDisplayCourse.main();
						break;
					case 3:
						TestRemoveInstructor.main(id);
						break;
					case 4:
						System.out.println("Logged Out Successfully");
						entry = 0;
						break;
					default:
						System.out.println("Invalid Operation");
						break;
					}
				}
			}
			else
				System.out.println("Invalid username or password please try again");
		}
		else
			System.out.println("Invalid username or password please try again");
	}
		}catch(Exception e) {
			System.out.println("Problem with Instructor Login");
		}
	}
}
