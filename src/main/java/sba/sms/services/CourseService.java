package sba.sms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import sba.sms.dao.CourseI;
import sba.sms.models.Course;
import sba.sms.utils.HibernateUtil;

/*TODO:
 * Implement CourseI
 * fill out methods (dont forget to try/catch/finally)
 * Set session
 * Set transaction
 * begin and CRUD transaction. REFERENCE: https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
 * commit to DB
 * 
 */
public class CourseService implements CourseI {

	public List<Course> getAllCourses() {
		List<Course> courseList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		TypedQuery<Course> query = session.createNamedQuery("SELECT * FROM course", Course.class);
		courseList = query.getResultList();
		transaction.commit();
		session.close();
		// TODO Auto-generated method stub
		return courseList;
	}

	public Course getCourseById(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

}
