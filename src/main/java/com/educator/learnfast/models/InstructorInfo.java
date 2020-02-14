package com.educator.learnfast.models;

public class InstructorInfo {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaOfInterest == null) ? 0 : areaOfInterest.hashCode());
		result = prime * result + coursesHandling;
		result = prime * result + ((instructorEmail == null) ? 0 : instructorEmail.hashCode());
		result = prime * result + instructorId;
		result = prime * result + ((instructorName == null) ? 0 : instructorName.hashCode());
		result = prime * result + ((instructorPassword == null) ? 0 : instructorPassword.hashCode());
		result = prime * result + rating;
		result = prime * result + ((recentWorks == null) ? 0 : recentWorks.hashCode());
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
		InstructorInfo other = (InstructorInfo) obj;
		if (areaOfInterest == null) {
			if (other.areaOfInterest != null)
				return false;
		} else if (!areaOfInterest.equals(other.areaOfInterest))
			return false;
		if (coursesHandling != other.coursesHandling)
			return false;
		if (instructorEmail == null) {
			if (other.instructorEmail != null)
				return false;
		} else if (!instructorEmail.equals(other.instructorEmail))
			return false;
		if (instructorId != other.instructorId)
			return false;
		if (instructorName == null) {
			if (other.instructorName != null)
				return false;
		} else if (!instructorName.equals(other.instructorName))
			return false;
		if (instructorPassword == null) {
			if (other.instructorPassword != null)
				return false;
		} else if (!instructorPassword.equals(other.instructorPassword))
			return false;
		if (rating != other.rating)
			return false;
		if (recentWorks == null) {
			if (other.recentWorks != null)
				return false;
		} else if (!recentWorks.equals(other.recentWorks))
			return false;
		return true;
	}
	private int instructorId;
	private String instructorName;
	private String instructorEmail;
	private String instructorPassword;
	private String areaOfInterest;
	private int coursesHandling;
	private String recentWorks;
	private int rating;
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getInstructorEmail() {
		return instructorEmail;
	}
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
	public String getInstructorPassword() {
		return instructorPassword;
	}
	public void setInstructorPassword(String instructorPassword) {
		this.instructorPassword = instructorPassword;
	}
	public String getAreaOfInterest() {
		return areaOfInterest;
	}
	public void setAreaOfInterest(String areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}
	public int getCoursesHandling() {
		return coursesHandling;
	}
	public void setCoursesHandling(int coursesHandling) {
		this.coursesHandling = coursesHandling;
	}
	public String getRecentWorks() {
		return recentWorks;
	}
	public void setRecentWorks(String recentWorks) {
		this.recentWorks = recentWorks;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
