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
public class Course {
	//fields
	private int id;
	private String name;
	private String instructor;
	private List<Student> students;
	//constructors
	public Course() {
	}
	
	
	public Course(int id, String name, String instructor, List<Student> students) {
		this.id = id;
		this.name = name;
		this.instructor = instructor;
		this.students = students;
	}


	public Course(String name, String instructor) {
		this.name = name;
		this.instructor = instructor;
	}


	//other methods
	
	//getters setters
}
