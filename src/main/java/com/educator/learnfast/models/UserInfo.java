package com.educator.learnfast.models;

public class UserInfo {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + noOfCoursesEnrolled;
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (noOfCoursesEnrolled != other.noOfCoursesEnrolled)
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}

	int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private int noOfCoursesEnrolled;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", emailId=" + userEmail + ", userPassword="
				+ userPassword + ", noOfCoursesEnrolled=" + noOfCoursesEnrolled + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return userEmail;
	}

	public void setEmailId(String emailId) {
		this.userEmail = emailId;
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
