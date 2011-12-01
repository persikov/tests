/**
 * 
 */
package edu.course.hibernate;

/**
 * @author Administrator
 *
 */
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Entity;

@Entity
@SequenceGenerator(name = "ADDRESS_SEQ")
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + number;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number != other.number)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", number="
				+ number + ", id=" + id + "]";
	}
	
	
}
