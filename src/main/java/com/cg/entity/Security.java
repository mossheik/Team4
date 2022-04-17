package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Security extends Person {

	private String firstName;

	private String lastName;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "salary")
	private double salary;

	@Column(name = "securityType")
	private String securityType;

	public Security() {
	}

	public Security(String userName, String password, String firstName, String lastName, String phoneNumber,
			double salary, String securityType) {
		super(userName, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.securityType = securityType;
	}

	public int getSecurityId() {
		return id;
	}

	public void setSecurityId(int id) {
		this.id = id;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getSecurityType() {
		return securityType;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	@Override
	public String toString() {
		return "Security [securityId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", salary=" + salary + ", securityType=" + securityType + "]";
	}

}
