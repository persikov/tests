/**
 * 
 */
package edu.course.hibernate;

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
public abstract class Person {
	
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

}
