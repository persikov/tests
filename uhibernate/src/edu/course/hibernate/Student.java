/**
 * 
 */
package edu.course.hibernate;

import java.util.Set;

import javax.persistence.ManyToMany;

import org.hibernate.annotations.Entity;

@Entity
public class Student extends Person {

	private int yearsInCollege;
	private Set<Course> courses;

	public int getYearsInCollege() {
		return yearsInCollege;
	}
	public void setYearsInCollege(int yearsInCollege) {
		this.yearsInCollege = yearsInCollege;
	}
	
	@ManyToMany (mappedBy="students")
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
