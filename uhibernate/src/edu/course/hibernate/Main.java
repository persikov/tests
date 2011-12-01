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
		
		Teacher teacher1 = new Teacher();
		teacher1.setName("Shimi");
		teacher1.setSeniority(10);
		teacher1.setBillingAddress(address3);
		teacher1.setResidentAddress(address3);
		
		Course hibernate = new Course( teacher1 , "Ultimate Hibernate");
		Course scala = new Course( teacher1 , "Scala");
		
		Student st1 = new Student();
		st1.setName("Misha");
		st1.setBillingAddress(address1);
		st1.setResidentAddress(address2);
		st1.setYearsInCollege(5);
		st1.setCourses(new HashSet<Course>( Arrays.asList(scala, hibernate)));
		
		Student st2 = new Student();
		st1.setName("Barak");
		st1.setBillingAddress(address1);
		st1.setResidentAddress(address1);
		st1.setYearsInCollege(3);
		st1.setCourses(new HashSet<Course>( Arrays.asList(scala)));
		
		hibernate.setStudents(new HashSet<Student>(Arrays.asList(st1)));
		scala.setStudents(new HashSet<Student>(Arrays.asList(st1, st2)));
		
		
		
		em.getTransaction().commit();
		
		em.close();
		
	}

}
