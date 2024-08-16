package com.nikhil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Courses 
{
	@Id
	@Column(name="course_id")
	private Integer id;
	
	private String courseName;
	
	private Integer coursePrice;
	
	public Courses()
	{
		System.out.println("Zero Param Constructor of Courses");
	}

	@Override
	public String toString() {
		return "Cousrses [id=" + id + ", courseName=" + courseName + ", coursePrice=" + coursePrice + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(Integer coursePrice) {
		this.coursePrice = coursePrice;
	}

}
