package sba.sms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
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
	@Override
	public List<Course> getAllCourses() {
		List<Course> courseList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		TypedQuery<Course> query = session.createQuery("FROM Course", Course.class);
		courseList = query.getResultList();
		courseList.toString();
		transaction.commit();
		session.close();
		// TODO Auto-generated method stub
		return courseList;
	}
	@Override
	public Course getCourseById(int courseId) {
		// TODO Auto-generated method stub
		Course course = new Course();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		TypedQuery<Course> query = session.createQuery("FROM Course WHERE id = :id", Course.class);
		query.setParameter("id", courseId);
		course = query.getSingleResult();
		transaction.commit();
		session.close();
		return course;
	}
	@Override
	public void createCourse(Course course) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(course);
			transaction.commit();
		} catch (HibernateException exception) {
			if (transaction != null) {
				transaction.rollback();
				exception.printStackTrace();
			}
		} finally {
			session.close();
		}
		
	}

}
