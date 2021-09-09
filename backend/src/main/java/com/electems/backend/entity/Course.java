/**
 * 
 */
package com.electems.backend.entity;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="regId" )
	private Register  register;
	/**
	 * @param courseId
	 * @param name
	 * @param duration
	 * @param register
	 */
	public Course(Integer courseId, String name, String duration, Register register) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.duration = duration;
		this.register = register;
	}
	/**
	 * 
	 */
	public Course() {
		super();
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
	 * @return the register
	 */
	public Register getRegister() {
		return register;
	}
	/**
	 * @param register the register to set
	 */
	public void setRegister(Register register) {
		this.register = register;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", duration=" + duration + ", register=" + register
				+ "]";
	}
	
	
}
