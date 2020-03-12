package com.educator.learnfast.model;

public class InstructorInfo {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaOfInterest == null) ? 0 : areaOfInterest.hashCode());
		result = prime * result + ((instructorEmail == null) ? 0 : instructorEmail.hashCode());
		result = prime * result + instructorId;
		result = prime * result + ((instructorName == null) ? 0 : instructorName.hashCode());
		result = prime * result + ((instructorPassword == null) ? 0 : instructorPassword.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "InstructorInfo [instructorId=" + instructorId + ", instructorName=" + instructorName
				+ ", instructorEmail=" + instructorEmail + ", instructorPassword=" + instructorPassword
				+ ", areaOfInterest=" + areaOfInterest + "]";
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
		return true;
	}

	private int instructorId;
	private String instructorName;
	private String instructorEmail;
	private String instructorPassword;
	private String areaOfInterest;

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
}
