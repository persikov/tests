/**
 * 
 */
package edu.course.hibernate;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Entity;

/**
 * @author Administrator
 *
 */
@Entity
@SequenceGenerator(name = "PERSON_SEQ")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	@OneToOne
	private Address billingAddress;
	@OneToOne
	private Address residentAddress;
	private Long id;
	@Id
	@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="PERSON_SEQ")
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getResidentAddress() {
		return residentAddress;
	}
	public void setResidentAddress(Address residentAddress) {
		this.residentAddress = residentAddress;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((billingAddress == null) ? 0 : billingAddress.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((residentAddress == null) ? 0 : residentAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (billingAddress == null) {
			if (other.billingAddress != null)
				return false;
		} else if (!billingAddress.equals(other.billingAddress))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (residentAddress == null) {
			if (other.residentAddress != null)
				return false;
		} else if (!residentAddress.equals(other.residentAddress))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", billingAddress=" + billingAddress
				+ ", residentAddress=" + residentAddress + ", id=" + id + "]";
	}

}
