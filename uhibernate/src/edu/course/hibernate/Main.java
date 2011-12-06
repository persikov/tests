/**
 * 
 */
package edu.course.hibernate;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Administrator
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello World");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateApp");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();

		
		Address address1 = new Address("Shabazy", "Yehud", 26);
		Address address2 = new Address("Lenina", "Moskow", 17);
		Address address3 = new Address("Baker", "London", 236);

		em.persist(address1);
		em.persist(address2);
		em.persist(address3);

		Teacher teacher1 = new Teacher();
		teacher1.setName("Shimi");
		teacher1.setFavNumber(34);
		em.persist(teacher1);
	
		
		
		teacher1.setSeniority(10);
		teacher1.setBillingAddress(address3);
		teacher1.setResidentAddress(address3);
		

		
		Course hibernate = new Course( teacher1 , "Ultimate Hibernate");
		Course scala = new Course( teacher1 , "Scala");
		
		em.persist(hibernate);
		em.persist(scala);
		
		
		Student st1 = new Student();
		
		st1.setName("Misha");
		st1.setBillingAddress(address1);
		st1.setResidentAddress(address2);
		st1.setYearsInCollege(5);
		st1.setCourses(new HashSet<Course>( Arrays.asList(scala, hibernate)));
		
		Student st2 = new Student();
		
		st2.setName("Barak");
		st2.setBillingAddress(address1);
		st2.setResidentAddress(address1);
		st2.setYearsInCollege(3);
		st2.setCourses(new HashSet<Course>( Arrays.asList(scala)));

		em.persist(st1);
		em.persist(st2);
		
		hibernate.setStudents(new HashSet<Student>(Arrays.asList(st1)));
		scala.setStudents(new HashSet<Student>(Arrays.asList(st1, st2)));
		
		em.getTransaction().commit();
		
		em.close();
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Teacher t11 = em.find(Teacher.class, teacher1.getId());
		
		System.out.println("T11 fav number: " + t11.getFavNumber());
	
		t11.setFavNumber(60);
		em.persist(t11);
		
		System.out.println("T11 fav number: " + t11.getFavNumber());
		
		em.getTransaction().commit();
		em.close();
		
	}

}
