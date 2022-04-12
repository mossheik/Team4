package com.cg.entity;

import java.util.HashMap;

public class Parking {
	
	public static HashMap<Integer,String> parkingArea;

	public Parking() {
		super();
		parkingArea=new HashMap<Integer,String>();
		parkingArea.put(1, "Vacant");
		parkingArea.put(2, "Vacant");
		parkingArea.put(3, "Vacant");
		
	}

	public Parking(HashMap<Integer, String> parkingArea) {
		super();
		this.parkingArea = parkingArea;
	}

	public HashMap<Integer, String> getParkingArea() {
		return parkingArea;
	}

	public void setParkingArea(HashMap<Integer, String> parkingArea) {
		this.parkingArea = parkingArea;
	}

	@Override
	public String toString() {
		return "Parking [parkingArea=" + parkingArea + "]";
	}
	

}
