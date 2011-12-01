/**
 * 
 */
package edu.course.hibernate;

/**
 * @author Administrator
 *
 */
public abstract class Person {
	
	private String name;
	private Address billingAddress;
	private Address residentAddress;
	
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

}
