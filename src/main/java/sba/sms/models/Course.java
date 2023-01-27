package sba.sms.models;

import java.util.List;

import lombok.*;


@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString

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
