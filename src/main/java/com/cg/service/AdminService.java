package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Manager;
import com.cg.entity.Parking;
import com.cg.entity.Security;

import com.cg.repository.ManagerRepository;
import com.cg.repository.SecurityRepository;

@Service
public class AdminService {

	@Autowired
	private SecurityRepository serepo;
	@Autowired
	private ManagerRepository marepo;
	
	Parking parking = new Parking();
	
	public String addSecurity(Security security) {
		serepo.save(security);
		return "Security Added Succesfully";
	}
	public String removeSecurity(int securityId) {
		serepo.deleteById(securityId);
		return "Security Deleted Succesfully";
	}
	
	
	public String addManager(Manager manager) {
		marepo.save(manager);
		return "Manager Added Succesfully";
	}
	
	public String removeManager(int id) {
		marepo.deleteById(id);
		return "Manager Deleted Succesfully";
	}
	
	public String addParkingEnd(int incr,String type) {
		
		if(parking.addParking(incr, type)) {
			return "New Parking Area Added Succesfully";
		}
		else {
			return "Allocation wasn't Succesfull";
		}
	}
	
	public String removeParkingEnd(int decrement) {
		if(parking.removeParking(decrement)) {
			return "Parking Area Deleted Succesfully";
		}
		else {
			return "Deallocation wasn't Succesfull";
		}
	}
	
	public String changeParkingStatus(int position, String status) {
		if(parking.changeParkingStatus(position, status)) {
			return "Parking status changes succesfully";
		}
		else {
			return "Error while changing the parking status";
		}
	}
	
	public String rangeChangeStatusParking(int start, int end, String status) {
		if(parking.rangeChangeStatusParking(start, end, status)) {
			return "Parking status upto the given range changes sucessfully";
		}
		else {
			return "Error while changing the status";
		}
	}
	
	

	
}
