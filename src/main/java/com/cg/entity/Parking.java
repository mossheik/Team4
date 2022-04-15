package com.cg.entity;

import java.util.HashMap;

public class Parking {
	// Not required now
	public static HashMap<Integer, String> parkingArea;

	public Parking() {
		super();
		parkingArea = new HashMap<Integer, String>();
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

	public boolean addParking(int increment, String type) {
		try {
			int currentSize = parkingArea.size();
			int requiredSize = currentSize + increment;
			for (int i = currentSize; i < requiredSize; ++i) {
				parkingArea.put(i, type);
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean removeParking(int decrement) {
		try {
			int currentSize = parkingArea.size();
			for (int i = 0; i < decrement; ++i) {
				parkingArea.remove(--currentSize);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean rangeChangeStatusParking(int start, int end, String status) {
		try {
			for (int i = start; i < end; ++i) {
				parkingArea.replace(i, status);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean changeParkingStatus(int position, String status) {
		try {
			parkingArea.replace(position, status);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Parking [parkingArea=" + parkingArea + "]";
	}

}
