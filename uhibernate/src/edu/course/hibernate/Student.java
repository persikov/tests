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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + yearsInCollege;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (yearsInCollege != other.yearsInCollege)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [yearsInCollege=" + yearsInCollege + ", courses="
				+ courses + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getBillingAddress()=" + getBillingAddress()
				+ ", getResidentAddress()=" + getResidentAddress() + "]";
	}
	
}
