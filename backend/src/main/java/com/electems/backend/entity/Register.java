/**
 * 
 */
package com.electems.backend.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Register Class
 *
 */
@Entity
@Table(name="Register")
public class Register {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer regId;
	private String fullName;
	private String phoneNumber;
	private String userName;
	private String email;
	private String password;
	private Date dob;
	
	/**
	 * Declared variable projects of type Project for class project manager
	 *
	 */

	@OneToMany
	private List<Course> courses;
	
	/**
	 * @param id
	 * @param fullName
	 * @param phoneNumber
	 * @param userName
	 * @param email
	 * @param password
	 * @param dob
	 * @param courses
	 */
	public Register(final Integer id,final String fullName,final String phoneNumber,final String userName,final String email,final String password,
			final Date dob,final List<Course> courses) {
		super();
		this.regId = id;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.courses = courses;
	}
	
	/**
	 * default constructor
	 */
	public Register() {
		super();
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return regId;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(final Integer id) {
		this.regId = id;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(final Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(final List<Course> courses) {
		this.courses = courses;
	}
	
	/* 
	 * to string method
	 */
	@Override
	public String toString() {
		return "Register [id=" + regId + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", userName="
				+ userName + ", email=" + email + ", password=" + password + ", dob=" + dob + ", courses=" + courses
				+ "]";
	}
	
}
