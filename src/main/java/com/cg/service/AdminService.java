package com.cg.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.entity.Manager;
import com.cg.entity.Security;
import com.cg.entity.Slot;
import com.cg.entity.Token;
import com.cg.repository.AdminRepository;
import com.cg.repository.ManagerRepository;
import com.cg.repository.SecurityRepository;
import com.cg.repository.SlotRepository;
import com.cg.repository.TokenRepository;


@Service

public class AdminService {
	
	@Autowired 
	public AdminRepository adminRepository;
	@Autowired
	private SecurityRepository securityRepository;
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private SlotRepository slotRepository;
	@Autowired
	private TokenRepository tokenRepository;

	
	//Adding Security
	public String addSecurity(Security security) {
		securityRepository.save(security);
		return "Security Added Succesfully";
	}
	
	//Removing Security
	public String removeSecurity(int securityId) {
		securityRepository.deleteById(securityId);
		return "Security Deleted Succesfully";
	}
	
	//Adding Manager
	public String addManager(Manager manager) {
		managerRepository.save(manager);
		return "Manager Added Succesfully";
	}
	
	//Removing Manager
	public String removeManager(int managerId) {
		managerRepository.deleteById(managerId);
		return "Manager Deleted Succesfully";
	}
	
	//Adding Parking Slots
	public String addSlot(int totalSlot,String type,String status) {
		
		Slot s= new Slot();

		
		//Creating Slots
		if(status.equals("Create") || status.equals("create")) {
			
				//Generating Token as per Slots
				Token token=new Token();
				token.setTokenCount(totalSlot);
				tokenRepository.save(token);
			
				char var = 'A';
				String var1="A";
				int counter =0;
			
				//Generating SlotNo and Adding Slot Table
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
		//Extending Slots
		else if(status.equals("Insert") || status.equals("insert")) {
			
				//Updating Token Count
				Token token = tokenRepository.findById(1).get();
				int tokenCount=token.getTokenCount()+totalSlot;
				token.setTokenCount(tokenCount);
				tokenRepository.save(token);
				
				//Getting Last slotNo
				Slot lastSlotRepo = slotRepository.findTopByOrderBySlotNoDesc();
				String lastSlot = lastSlotRepo.getSlotNo();
				
				char l = lastSlot.charAt(0);
				String ls = lastSlot.substring(1);
				int lst = Integer.parseInt(ls);
				String val = l+"";
				int c = lst;
			
				//Generating SlotNo and Adding Slot Table
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
	
	//Remove Slot
	public String removeSlot(int decr,String slotPos) {
		
		//Decrementing Token as per Slots
		Token token = tokenRepository.findById(1).get();
		int tokenCount=token.getTokenCount()-decr;
		token.setTokenCount(tokenCount);
		tokenRepository.save(token);
				
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
			//Deleting Slot
			slotRepository.deleteBySlotNo(slotPos);
			c++;
		}
		
		
		return "Removed Succesfully";
	}
	
	
	// For Updating Type at any slot Position
	public String updateSlot(String slotPos,String status) {
		Slot s =new Slot();
		
		//Setting Updated Details
		s.setSlotNo(slotPos);
		s.setSlotStatus(status);
		
		slotRepository.save(s);
		return "Update Succesfully";
	}
	
	
	// Updating Slot Type for a Given Range
	public String rangeChangeStatusSlot(String slotPos,int range,String type) {
		
		//Updating Token as per Slots
		Token token = tokenRepository.findById(1).get();
		int tokenCount=token.getTokenCount()+range;
		token.setTokenCount(tokenCount);
		tokenRepository.save(token);
		
		Slot s =new Slot();
		char l = slotPos.charAt(0);
		String ls = slotPos.substring(1);
		int lst = Integer.parseInt(ls);
		String val = l+"";
		int c = lst;
		
		//Setting Updated Slot Status and save Slot
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

