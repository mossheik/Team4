package com.cg.entity;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Slot{
	
	@Id
	@Column(name="slotNo")
	private String slotNo;
	
	@Column(name="slotStatus")
	private String slotStatus;
	
	public Slot() {
		super();
	}
	
	public Slot(String slotNo, String slotStatus) {
		super();
		this.slotNo = slotNo;
		this.slotStatus = slotStatus;
	}
	
	public String getSlotNo() {
		return slotNo;
	}
	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}
	public String getSlotStatus() {
		return slotStatus;
	}
	public void setSlotStatus(String slotStatus) {
		this.slotStatus = slotStatus;
	}
	@Override
	public String toString() {
		return "Slot [slotNo=" + slotNo + ", slotStatus=" + slotStatus + "]";
	}


}
