package sba.sms.models;

import java.util.List;

import lombok.*;



@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Student {
	//fields email, name, password, courses
	private String email;
	private String name;
	private String password;
	private List<Course> courses;
	
	//constructors
	
	//other methods
	
	//getters and setters
}
	
	
