package sba.sms.models;

import java.util.List;

import lombok.*;


@AllArgsConstructor
@RequiredArgsConstructor
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


	//other methods
	
	//getters setters
}
