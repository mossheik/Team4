package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
<<<<<<< Updated upstream
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
=======
public class Admin extends Person {
//  Removed security id as it is inheriting from Person
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
>>>>>>> Stashed changes

	@Column(name = "F-Name")
	private String firstName;

	@Column(name = "L-Name")
	private String lastName;

	@Column(name = "Phone Number")
	private String phoneNo;

	@Column(name = "Address")
	private String address;

	@Column(name = "Age")
	private int age;

	public Admin() {
		super();
	}

	public Admin(String userName, String password, String firstName, String lastName, String phoneNo, String address,
			int age) {
		super(userName, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.age = age;

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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", age=" + age + "]";
	}

}
