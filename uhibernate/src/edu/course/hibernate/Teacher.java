/**
 * 
 */
package edu.course.hibernate;

/**
 * @author Administrator
 *
 */
import org.hibernate.annotations.Entity;

@Entity
public class Teacher extends Person {

	private int seniority;

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}


}
