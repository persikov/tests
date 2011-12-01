/**
 * 
 */
package edu.course.hibernate;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Administrator
 *
 */
import org.hibernate.annotations.Entity;

@Entity
@SequenceGenerator(name = "STUDENT_SEQ")
public class Student extends Person {

	private int yearsInCollege;
	private Set<Course> courses;
	private Long id;
	@Id
	@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="STUDENT_SEQ")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public int getYearsInCollege() {
		return yearsInCollege;
	}
	public void setYearsInCollege(int yearsInCollege) {
		this.yearsInCollege = yearsInCollege;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
