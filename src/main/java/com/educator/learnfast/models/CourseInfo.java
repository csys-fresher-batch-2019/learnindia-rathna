package com.educator.learnfast.models;

public class CourseInfo {
	@Override
	public String toString() {
		return "CourseInfo [courseId=" + courseId + ", courseName=" + courseName + ", durationOfCourse="
				+ durationOfCourse + ", instructorName=" + instructorName + ", courseCategory=" + courseCategory
				+ ", price=" + price + ", rating=" + rating + ", instructorId=" + instructorId + "]";
	}

	private int courseId;
	private String courseName;
	private int durationOfCourse;
	private String instructorName;
	private String courseCategory;
	private int price;
	private int rating;
	private int instructorId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseCategory == null) ? 0 : courseCategory.hashCode());
		result = prime * result + courseId;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + durationOfCourse;
		result = prime * result + instructorId;
		result = prime * result + ((instructorName == null) ? 0 : instructorName.hashCode());
		result = prime * result + price;
		result = prime * result + rating;
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
		CourseInfo other = (CourseInfo) obj;
		if (courseCategory == null) {
			if (other.courseCategory != null)
				return false;
		} else if (!courseCategory.equals(other.courseCategory))
			return false;
		if (courseId != other.courseId)
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (durationOfCourse != other.durationOfCourse)
			return false;
		if (instructorId != other.instructorId)
			return false;
		if (instructorName == null) {
			if (other.instructorName != null)
				return false;
		} else if (!instructorName.equals(other.instructorName))
			return false;
		if (price != other.price)
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDurationOfCourse() {
		return durationOfCourse;
	}

	public void setDurationOfCourse(int durationOfCourse) {
		this.durationOfCourse = durationOfCourse;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

}
