/**
 * 
 */
package com.electems.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class Course
 *
 */
@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer courseId;
	private String name;
	private String duration;
	
	/**
	 * @param id
	 * @param name
	 * @param duration
	 */
	public Course(Integer id, String name, String duration) {
		super();
		this.courseId = id;
		this.name = name;
		this.duration = duration;
	}
	
	/**
	 * default constructor
	 */
	public Course() {
		super();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/**
	 * @return the courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	/*
	 * to string method
	 */
	@Override
	public String toString() {
		return "Course [id=" + courseId + ", name=" + name + ", duration=" + duration + "]";
	}
	
}
