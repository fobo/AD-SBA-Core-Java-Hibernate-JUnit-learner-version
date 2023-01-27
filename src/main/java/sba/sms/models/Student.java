package sba.sms.models;

import java.util.List;

public class Student {
	//fields email, name, password, courses
	String email;
	String name;
	String password;
	List<Course> courses;
	
	//constructors
	
	//other methods
	
	//getters and setters
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
