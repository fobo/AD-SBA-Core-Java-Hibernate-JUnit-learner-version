package sba.sms.models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
/*
 * TO DO: Add HQL 
 * Finish lombok annotations
 *  Add HQL annotations (declare table,
 * and entity) 
 * declare column names and lengths for the fields create many to
 * many relationship between the two models (figure that out later, check slides
 * and example project) Add equals method Add hashcode method
 * ALL FINISHED
 */

@Table(name = "student")
@Entity
public class Student {
	// fields email, name, password, courses
	@Id
	@NonNull
	@Column(length = 50, name = "email")
	private String email;

	@NonNull
	@Column(length = 50, name = "name")
	private String name;

	@NonNull
	@Column(length = 50, name = "password")
	private String password;

	/*
	 * Join table strategy name student_courses , name of student primary key column
	 * student_email and inverse primary key (courses) column courses_id , fetch
	 * type eager, cascade all except remove
	 */
	@ToString.Exclude
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "student_email"), inverseJoinColumns = @JoinColumn(name = "courses_id"))
	private List<Course> courses;

	// constructors
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

	
	
	// other methods
	@Override
	public int hashCode() {
		return Objects.hash(email, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
	//helper method to add a course to a students list of courses
	public void registerCourse(Course course) {
		this.courses.add(course); //adds course to student
		course.getStudents().add(this); //adds student to course
	}


	// getters and setters
}
