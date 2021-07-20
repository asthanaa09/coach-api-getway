package com.getway.core.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TODO: Add role based authentoication when add security
 * 
 * @author Anurag Asthana
 *
 */
@Document(collection = "user")
public class User extends BaseEntity {

	public static final String SEQUENCE_NAME = "user_sequence";
	
	String username;
	String password;
	
	/**
	 * Ref: https://www.youtube.com/watch?v=qGOB8jT61nM
	 */
	@DBRef
	Role role;
	@DBRef
	Institution institution;
	@DBRef
	Institute institute;
	@DBRef
	Student student;
	
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	Date accessTime;
	Date updatedTime;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Date getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
