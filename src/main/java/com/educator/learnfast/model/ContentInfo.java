package com.educator.learnfast.model;

public class ContentInfo {
	@Override
	public String toString() {
		return "ContentInfo [courseId=" + courseId + ", courseContent=" + courseContent + ", chapterNo=" + chapterNo
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + chapterNo;
		result = prime * result + ((courseContent == null) ? 0 : courseContent.hashCode());
		result = prime * result + courseId;
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
		ContentInfo other = (ContentInfo) obj;
		if (chapterNo != other.chapterNo)
			return false;
		if (courseContent == null) {
			if (other.courseContent != null)
				return false;
		} else if (!courseContent.equals(other.courseContent))
			return false;
		if (courseId != other.courseId)
			return false;
		return true;
	}

	private int courseId;
	private String courseContent;
	private int chapterNo;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	public int getChapterNo() {
		return chapterNo;
	}

	public void setChapterNo(int chapterNo) {
		this.chapterNo = chapterNo;
	}

}
