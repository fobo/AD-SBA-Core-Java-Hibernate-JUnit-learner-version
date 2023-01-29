package sba.sms.services;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.*;

import jakarta.persistence.*;
import sba.sms.dao.StudentI;
import sba.sms.models.Course;
import sba.sms.models.Student;
import sba.sms.utils.HibernateUtil;
/*TODO:
 * Implement StudentI
 * fill out methods (dont forget to try/catch/finally)
 * Set session
 * Set transaction
 * begin and CRUD transaction. REFERENCE: https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
 * commit to DB
 * 
 */

public class StudentService implements StudentI {
	private static final CourseService courseService = new CourseService();

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		/*
		 * create new transaction object create new session object begin transaction
		 * create query to insert data into DB commit transaction catch errors no return
		 * data
		 */
		// these three lines can be used for any DB call
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		session.persist(student);
		transaction.commit();
		session.close();
		// come back to catch errors later
	}
	@Override
	public boolean validateStudent(String email, String password) { // checks for correct student-password relationship
		// TODO Auto-generated method stub
		/*
		 * create new Student object create new transaction object create new session
		 * object begin transaction create query fill Student object with data check if
		 * data from object matches data input from user commit transaction return
		 * boolean value based on result
		 * 
		 */
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Student student = new Student();
		session.close();
		if (student.getPassword() == password) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public Student getStudentByEmail(String email) {
		// TODO Auto-generated method stub

		/*
		 * create new Student object create new transaction object create new session
		 * object begin transaction create query fill Student object with data commit
		 * transaction return Student data
		 * 
		 */
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Student student = new Student();
		Query query = session.createNamedQuery("SELECT * FROM Student WHERE email = :email"); //deprecated? Unsure what else to use here
		query.setParameter("email", email);
		student = (Student) query.getSingleResult();
		transaction.commit();
		session.close();
		
		return student;
	}
	@Override
	public void registerStudentToCourse(String email, int i) {
		// TODO Auto-generated method stub
		/*
		 * create session create transaction object being transaction create query
		 * insert data into DB commit transaction catch errors no returns
		 */

	}
	@Override
	public List<Course> getStudentCourses(String email) {
		// TODO Auto-generated method stub
		/*
		 * create new course list to pass back from method create session create
		 * transaction object begin transaction create query fill course list with
		 * results commit transaction catch errors return data
		 */
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		/*
		 * create new student list to pass back from method create session create
		 * transaction object begin transaction create query fill student list with
		 * results commit transaction catch errors return data
		 */
		// TODO Auto-generated method stub
		return null;
	}

}
