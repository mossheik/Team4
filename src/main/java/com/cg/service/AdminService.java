package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Manager;
import com.cg.entity.Security;
import com.cg.entity.Slot;
import com.cg.entity.Token;
import com.cg.repository.ManagerRepository;
import com.cg.repository.SecurityRepository;
import com.cg.repository.SlotRepository;

@Service
public class AdminService {

	@Autowired
	private SecurityRepository securityRepository;
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private SlotRepository slotRepository;
		
	public String addSecurity(Security security) {
		securityRepository.save(security);
		return "Security Added Succesfully";
	}

	public String removeSecurity(int securityId) {
		securityRepository.deleteById(securityId);
		return "Security Deleted Succesfully";
	}
	
	public String addManager(Manager manager) {
		managerRepository.save(manager);
		return "Manager Added Succesfully";
	}

	public String removeManager(int id) {
		managerRepository.deleteById(id);
		return "Manager Deleted Succesfully";
	}
	
	//FOR TESTING START
	public String addSlot(int totalSlot,String type) {
		for(int i=0;i<totalSlot;i++)
		{
			Slot s= new Slot();
			s.setSlotNo("A"+i);
			s.setSlotStatus(type);
			slotRepository.save(s);
		}
		Token.tokenCount=Token.tokenCount+totalSlot;
		return totalSlot+" Slots Added Succesfully";
	}
	
	//TESTING END
	
	
	
	/*
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
	}*/
	
	
	
	
	public String addParkingEnd(int increment,String type) {
		
		try {
			long currentSize = slotRepository.count();
			long requiredSize = currentSize + increment;
			for (long i = currentSize; i < requiredSize; ++i) {
				//slotRepository.save(requestBody);
			}
			return "New Parking Area Added Succesfully";
		} catch (Exception e) {
			return "Allocation wasn't Succesfull";
		}
	}
	/*
	public String removeParkingEnd(int decrement) {
		if (parking.removeParking(decrement)) {
			return "Parking Area Deleted Succesfully";
		} else {
			return "Deallocation wasn't Succesfull";
		}
	}

	public String changeParkingStatus(int position, String status) {
		if (parking.changeParkingStatus(position, status)) {
			return "Parking status changes succesfully";
		} else {
			return "Error while changing the parking status";
		}
	}

	public String rangeChangeStatusParking(int start, int end, String status) {
		if (parking.rangeChangeStatusParking(start, end, status)) {
			return "Parking status upto the given range changes sucessfully";
		} else {
			return "Error while changing the status";
		}
	}
	
	*/

}
