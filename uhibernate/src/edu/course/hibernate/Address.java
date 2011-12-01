/**
 * 
 */
package edu.course.hibernate;

/**
 * @author Administrator
 *
 */
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Entity;

@Entity
@SequenceGenerator(name = "ADDRESS_SEQ")
public class Address {

	private String street;
	private String city;
	private int number;
	private Long id;
	@Id
	@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="ADDRESS_SEQ")
	public Long getId() {
		return id;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String street, String city, int number) {
		super();
		this.street = street;
		this.city = city;
		this.number = number;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
