package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Security {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int securityId;

	private String firstName;

	private String lastName;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="securityType")
	private String securityType;

	public Security(int securityId, String firstName, String lastName, String phoneNumber, double salary,
			String securityType) {
		super();
		this.securityId = securityId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.securityType = securityType;
	}

	public int getSecurityId() {
		return securityId;
	}

	public void setSecurityId(int securityId) {
		this.securityId = securityId;
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
		return "Security [securityId=" + securityId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", salary=" + salary + ", securityType=" + securityType + "]";
	}

	
}
