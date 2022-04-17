package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Security extends Person {
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "salary")
	private double salary;
	@Column(name = "security_type")
	private String securityType;

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

	public Security() {
	}

	public Security(String email, String password, String firstName, String lastName, String phoneNumber, double salary,
			String securityType, String role) {
		super(email, password, role);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.securityType = securityType;
	}

}
