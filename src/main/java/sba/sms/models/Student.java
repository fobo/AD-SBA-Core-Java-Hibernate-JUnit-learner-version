package sba.sms.models;

import java.util.List;

import lombok.*;




@Setter
@Getter
@ToString
/*TO DO:
 * Add HQL
 * Finish lombok annotations (declare table, and entity
 * declare column names and lengths for the fields
 * create many to many relationship between the two models (figure that out later, check slides and example project)
 * Add equals method
 * Add hashcode method
 */
public class Student {
	//fields email, name, password, courses
	private String email;
	private String name;
	private String password;
	private List<Course> courses;
	
	//constructors
	public Student() {
	}
	
	public Student(String email, String name, String password, List<Course> courses) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.courses = courses;
	}

	public Student(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	//other methods
	
	//getters and setters
}
	
	
