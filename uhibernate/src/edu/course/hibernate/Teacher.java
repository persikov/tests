/**
 * 
 */
package edu.course.hibernate;

import javax.persistence.Entity;

/**
 * @author Administrator
 *
 */

@Entity
public class Teacher extends Person {

	private static final long serialVersionUID = 1L;
	private int seniority;

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + seniority;
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
		Teacher other = (Teacher) obj;
		if (seniority != other.seniority)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [seniority=" + seniority + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getBillingAddress()="
				+ getBillingAddress() + ", getResidentAddress()="
				+ getResidentAddress() + "]";
	}


}
