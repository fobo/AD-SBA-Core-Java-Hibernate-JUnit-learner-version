package sba.sms.services;

import java.util.List;
import java.util.logging.Logger;
import sba.sms.models.Course;
import sba.sms.models.Student;
/*TODO:
 * Implement StudentI
 * fill out methods (dont forget to try/catch/finally)
 * Set session
 * Set transaction
 * begin and CRUD transaction. REFERENCE: https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
 * commit to DB
 * 
 */

public class StudentService  {



	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public boolean validateStudent(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public Course getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registerStudentToCourse(String email, int i) {
		// TODO Auto-generated method stub
		
	}

	public List<Course> getStudentCourses(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
