package com.cg.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.entity.Manager;
import com.cg.entity.Security;
import com.cg.entity.Slot;
import com.cg.repository.AdminRepository;
import com.cg.repository.ManagerRepository;
import com.cg.repository.SecurityRepository;
import com.cg.repository.SlotRepository;


@Service

public class AdminService {
	
	@Autowired 
	public AdminRepository adrepo;
	@Autowired
	private SecurityRepository serepo;
	@Autowired
	private ManagerRepository marepo;
	@Autowired
	private SlotRepository slotRepository;
	
	
	//Parking parking = new Parking();
	//Slots slots = new Slots();
	
	//Adding Security Class
	public String addSecurity(Security security) {
		serepo.save(security);
		return "Security Added Succesfully";
	}
	
	//Removing Security Class
	public String removeSecurity(int securityId) {
		serepo.deleteById(securityId);
		return "Security Deleted Succesfully";
	}
	
	// Adding Manager Class
	public String addManager(Manager manager) {
		marepo.save(manager);
		return "Manager Added Succesfully";
	}
	
	// Removing Manager Class
	public String removeManager(int id) {
		marepo.deleteById(id);
		return "Manager Deleted Succesfully";
	}
	
	// Adding parking slots
	public String addSlot(int totalSlot,String type,String status) {
		Slot s= new Slot();
		
		// For Creating a Table
		if(status.equals("Create") || status.equals("create")) {
			char var = 'A';
			String var1="A";
			int counter =0;
			
				for(int i=0;i<totalSlot;i++)
				{
					counter++;
					if(i %20 ==0 && i!=0) {
						var = (char)(var+1);
						var1="";
						var1 = Character.toString(var);
						counter=1;
						
					}
					if(counter<10) {
						s.setSlotNo(var1+"0"+counter);
					}
					else {
					s.setSlotNo(var1+counter);
					}
					s.setSlotStatus(type);
					slotRepository.save(s);
					
				}
				
				return totalSlot+" Slots Added Succesfully";
		}
		
		// Inserting into the Table
		else if(status.equals("Insert") || status.equals("insert")) {
			
			Slot lastSlotRepo = slotRepository.findTopByOrderBySlotNoDesc();
			String lastSlot = lastSlotRepo.getSlotNo();
			char l = lastSlot.charAt(0);
			String ls = lastSlot.substring(1);
			int lst = Integer.parseInt(ls);
			String val = l+"";
			int c = lst;
			for(int i=lst;i<totalSlot+lst;i++)
			{
				c++;
				if(i %20 ==0) {
					l = (char)(l+1);
					val="";
					val = Character.toString(l);
					c=1;
				}
				if(c<10) {
				s.setSlotNo(val+"0"+c);
				}
				else {
					s.setSlotNo(val+c);
				}
				s.setSlotStatus(type);
				slotRepository.save(s);
				
			}
			return totalSlot+" Slots Inserted Succesfully";

		}
		return "Please Choose Correct Status";
	}
	
	public String removeSlot(int decr,String slotPos) {
		char l = slotPos.charAt(0);
		String ls = slotPos.substring(1);
		int lst = Integer.parseInt(ls);
		String val = l+"";
		int c = lst;
		for(int i=lst;i<decr+lst;i++) {
			if(i %20 ==0) {
				l = (char)(l+1);
				val="";
				val = Character.toString(l);
				c=1;
			}
			if(c<10) {
				slotPos = val+"0"+c;
			}
			else {
				slotPos = val+c;
			}
			
			slotRepository.deleteBySlotNo(slotPos);
			c++;
		}
		
		
		return "Removed Succesfully";
	}
	
	
	// For Updating Type at any slot Position
	public String updateSlot(String slotPos,String status) {
		Slot s =new Slot();
		s.setSlotNo(slotPos);
		s.setSlotStatus(status);
		slotRepository.save(s);
		return "Update Succesfully";
		}
	
	
	// Updating Slot Type for a Given Range
	public String rangeChangeStatusSlot(String slotPos,int range,String type) {
		Slot s =new Slot();
		char l = slotPos.charAt(0);
		String ls = slotPos.substring(1);
		int lst = Integer.parseInt(ls);
		String val = l+"";
		int c = lst;
		for(int i=lst;i<=range+lst;i++) {
			
			if(i %20 ==0) {
				l = (char)(l+1);
				val="";
				val = Character.toString(l);
				c=1;
			}
			if(c<10) {
				s.setSlotNo(val+"0"+c);
				}
			else {
					s.setSlotNo(val+c);
				}
				c++;
				s.setSlotStatus(type);
				slotRepository.save(s);
			
		}
		return "Status updated";
	}
}

