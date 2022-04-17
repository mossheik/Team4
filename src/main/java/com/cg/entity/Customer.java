package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@Column(name = "name")
	private String name;

	@Column(name = "vehicleNumber")
	private String vehicleNumber;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="hasToken")
	private boolean hasToken;
	
	@Column(name="slotNo")
	private String slotNo;
	
	@OneToOne(mappedBy = "customer")
	private Bill bill;
	

	
	public Customer() {
		super();
	}



	public Customer(int customerId, String name, String vehicleNumber, String phoneNumber, boolean hasToken,
			String slotNo, Bill bill) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.vehicleNumber = vehicleNumber;
		this.phoneNumber = phoneNumber;
		this.hasToken = hasToken;
		this.slotNo = slotNo;
		this.bill = bill;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getVehicleNumber() {
		return vehicleNumber;
	}



	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public boolean isHasToken() {
		return hasToken;
	}



	public void setHasToken(boolean hasToken) {
		this.hasToken = hasToken;
	}



	public String getSlotNo() {
		return slotNo;
	}



	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}



	public Bill getBill() {
		return bill;
	}



	public void setBill(Bill bill) {
		this.bill = bill;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", vehicleNumber=" + vehicleNumber
				+ ", phoneNumber=" + phoneNumber + ", hasToken=" + hasToken + ", slotNo=" + slotNo + ", bill=" + bill
				+ "]";
	}

	
	

}