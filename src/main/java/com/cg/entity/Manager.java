package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Manager extends Person {

	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "address")
	private String address;
	@Column(name = "phoneNumber")
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Manager() {
	}

	public Manager(String firstName, String lastName, String address, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Manager [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}

}
