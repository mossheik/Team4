package com.cg.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bill{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int billId;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="amount")
	private double amount;

	public Bill() {
		super();
	}

	public Bill(int billId, LocalDate date, int amount) {
		super();
		this.billId = billId;
		this.date = date;
		this.amount = amount;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date2) {
		this.date = date2;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount2) {
		this.amount = amount2;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", date=" + date + ", amount=" + amount + ", toString()="
				+ "]";
	}
	
	

}
