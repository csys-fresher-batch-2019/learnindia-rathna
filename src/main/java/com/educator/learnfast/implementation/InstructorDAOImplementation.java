package com.educator.learnfast.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.educator.learnfast.DAO.InstructorDAO;
import com.educator.learnfast.models.EnrollmentDetails;
import com.educator.learnfast.models.InstructorInfo;
import com.educator.learnfast.util.TestConnection;

public class InstructorDAOImplementation implements InstructorDAO{

	public boolean saveInstructor(InstructorInfo in) {
		int row = 0;
		String sql = "insert into instructor_info(instructor_id,instructor_name,instructor_email,instructor_password,area_of_interest)"
				+ " values (instructor_id_seq.nextval,?,?,?,?)";
		try(Connection con = TestConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);){
		ps.setString(1, in.getInstructorName());
		ps.setString(2, in.getInstructorEmail());
		ps.setString(3, in.getInstructorPassword());
		ps.setString(4, in.getAreaOfInterest());
		row = ps.executeUpdate();
		System.out.println("Instructor Account Created");
		}catch(Exception e) {
			System.out.println("Cannot add instructor");
		}
		if(row>0) {
			return true;
		}
		else
			return false;
	}

	public boolean removeInstructor(int instructorId) {
		int row = 0;
		String sql ="delete instructor_info where instructor_id = ?";
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
		if(row>0)
			return true;
		else
			return false;
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
			try(Connection con1 = TestConnection.getConnection();
			PreparedStatement ps1 = con1.prepareStatement(sql1);){
			ps1.setInt(1, rs.getInt("course_id"));
			try(ResultSet rs1 = ps1.executeQuery();){
			EnrollmentDetails cla = new EnrollmentDetails();
			cla.setCourseName(rs.getString("course_name"));
			cla.setDuration( rs.getInt("duration_of_course"));
			if(rs1.next()) {
			cla.setNoOfEnrollments(rs1.getInt(1));
			}
			else
				cla.setNoOfEnrollments(0);
			out.add(cla);
		}}catch(Exception e) {
			System.out.println("Cannot fetch enorllment details for the given course");
		}
		}}	
		}catch(Exception e) {
			System.out.println();
		}
		return out;
	}
	
	public InstructorInfo instructorLogin(String email,String pass){
		InstructorInfo out = new InstructorInfo();
		String sql = "select *from instructor_info where instructor_email = ?";
		try(Connection con = TestConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);){
		ps.setString(1, email);
		try(ResultSet rs = ps.executeQuery();){
		Scanner sc = new Scanner(System.in);
		if(rs.next()) {
			String password = rs.getString("instructor_email");
			if(password.equals(pass)) {
				out.setInstructorId(rs.getInt("instructor_id"));
				out.setInstructorName(rs.getString("isntructor_name"));
				out.setInstructorEmail(rs.getString("instructor_email"));
				out.setInstructorPassword(rs.getString("instructor_password"));
				out.setAreaOfInterest(rs.getString("area_of_interest"));
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
		return out;
	}
}
