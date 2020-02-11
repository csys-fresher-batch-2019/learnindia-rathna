package com.educator.LearnFast.Users;

public class UserInfo {
	int userId;
	private String userName;
	private String emailId;
	private String userPassword;
	private int noOfCoursesEnrolled;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getNoOfCoursesEnrolled() {
		return noOfCoursesEnrolled;
	}
	public void setNoOfCoursesEnrolled(int noOfCoursesEnrolled) {
		this.noOfCoursesEnrolled = noOfCoursesEnrolled;
	}
}
