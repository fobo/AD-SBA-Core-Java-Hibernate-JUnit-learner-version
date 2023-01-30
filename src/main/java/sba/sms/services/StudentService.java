package sba.sms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.*;
import org.hibernate.query.NativeQuery;

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
		try {
			transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
			// come back to catch errors later
		} catch (HibernateException exception) {
			if (transaction != null) {
				transaction.rollback();
				exception.printStackTrace();
			}
		} finally {
			session.close();
		}
		// TODO: handle finally clause
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
		TypedQuery<Student> query = session.createQuery("FROM Student WHERE email = :email", Student.class);
		query.setParameter("email", email);
		student = query.getSingleResult();
		session.close();
		if (student.getPassword().equals(password)) {
			return true;
		} else {
			System.out.println(student.getPassword() + password);
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
		Student student = new Student();
		try {
			transaction = session.beginTransaction();
			TypedQuery<Student> query = session.createQuery("FROM Student WHERE email = :email", Student.class);
			query.setParameter("email", email);
			student = query.getSingleResult();
			transaction.commit();

		} catch (HibernateException exception) {
			if (transaction != null) {
				transaction.rollback();
				exception.printStackTrace();
			}
		} finally {
			session.close();
		}
		return student;
	}

	@Override
	public void registerStudentToCourse(String email, int i) {
		// TODO Auto-generated method stub
		/*
		 * create session create transaction object being transaction create query
		 * insert data into DB commit transaction catch errors no returns
		 */
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		Student student = new Student();
		TypedQuery<Student> query = session.createQuery("FROM Student WHERE email = :email",
				Student.class);
		query.setParameter("email", email);
		student = query.getSingleResult();
		student.registerCourse(courseService.getCourseById(i));
		session.merge(student);
		session.close();
	}

	@Override
	public List<Course> getStudentCourses(String email) {
		// TODO Auto-generated method stub
		/*
		 * create new course list to pass back from method create session create
		 * transaction object begin transaction create query fill course list with
		 * results commit transaction catch errors return data
		 */
		List<Course> courseList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			
			/*
			 * SELECT course.id, course.name, course.instructor
			 * FROM course
			 * JOIN student_courses
			 * ON course.id = student_courses.coursee_id
			 * JOIN student
			 * ON student.email = student_courses.student_email
			 * WHERE student.email = :email
			 */
			NativeQuery<Course> query = session.createNativeQuery(
					"SELECT course.id, course.name, course.instructor" + 
					" FROM course join student_courses "+
					"ON course.id = student_courses.courses_id "+
					"JOIN student "+
					"ON student.email = student_courses.student_email "+
					"WHERE student.email = :email",
					Course.class);
			query.setParameter("email", email);
			courseList = query.getResultList();
			courseList.toString();
			transaction.commit();
			
		} catch (HibernateException exception) {
			if (transaction != null) {
				transaction.rollback();
				exception.printStackTrace();
			}
		} finally {
			session.close();
		}
		// just found this:
		// https://www.tutorialspoint.com/hibernate/hibernate_native_sql.htm come to it
		// later...
		return courseList;
	}

	@Override
	public List<Student> getAllStudents() {
		/*
		 * create new student list to pass back from method create session create
		 * transaction object begin transaction create query fill student list with
		 * results commit transaction catch errors return data
		 */
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		List<Student> studentList = new ArrayList<>();
		TypedQuery<Student> query = session.createQuery("SELECT * FROM Student", Student.class);
		studentList = query.getResultList();
		transaction.commit();
		session.close();
		return studentList;
	}

}
