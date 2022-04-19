package com.cg.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Entity
public class Slot {

	@Id
	@Column(name = "slotNo")
	private String slotNo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "slotStatus")
	private SlotStatus slotStatus;

	public String getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

	public SlotStatus getSlotStatus() {
		return slotStatus;
	}
	

	public void setSlotStatus(SlotStatus slotStatus) {
		this.slotStatus = slotStatus;
	}

	public void setSlotStatus(String type) {
		this.slotStatus = SlotStatus.valueOf(type);
	}

	public Slot() {
		super();
	}

	public Slot(String slotNo, SlotStatus slotStatus) {
		super();
		this.slotNo = slotNo;
		this.slotStatus = slotStatus;
	}

	@Override
	public String toString() {
		return "Slot [slotNo=" + slotNo + ", slotStatus=" + slotStatus + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(slotNo, slotStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		return Objects.equals(slotNo, other.slotNo) && slotStatus == other.slotStatus;
	}
}
