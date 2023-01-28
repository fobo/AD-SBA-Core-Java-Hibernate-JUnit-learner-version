package sba.sms.models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

import lombok.*;


@Setter
@Getter
@ToString

/*TO DO:
 * Add HQL --MOVED TO SERVICES
 * Finish lombok annotations -- DONE
 * Add HQL annotations (declare table, and entity) -- DONE
 * declare column names and lengths for the fields -- DONE
 * create many to many relationship between the two models (figure that out later, check slides and example project) -- DONE
 * https://www.baeldung.com/jpa-cascade-types
 * 
 * Add equals method -- DONE
 * Add hashcode method -- DONE
 */
@Table(name = "course")
@Entity
public class Course {
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//automatically generates the primary key value, defaults to AUTO
	//@NonNull
	@Column(name = "id")
	private int id;
	
	@Column(length = 50, name = "name")
	@NonNull
	private String name;
	
	@Column(length = 50, name = "instructor")
	private String instructor;
	
	// fetch type eager, cascade all except remove, mappedBy courses
	@ToString.Exclude
	@ManyToMany(mappedBy = "courses", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
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


	//other methods, auto generated from source
	@Override
	public int hashCode() {
		return Objects.hash(id, instructor, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return id == other.id && Objects.equals(instructor, other.instructor) && Objects.equals(name, other.name);
	}


	
	//getters setters
}
