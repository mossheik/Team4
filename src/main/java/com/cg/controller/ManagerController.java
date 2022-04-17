package com.cg.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Slot;
import com.cg.service.ManagerService;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/{managerType}/allSlot")
	public List<Slot> getAllPosition(@PathVariable("managerType") String managerType)
	{
		if(managerType.equals("entryManager"))
		{
			return managerService.getAllParkingSlots();
		}else
		{
		//	return "Only Entry Manager have Access!";
		}
		return null;
		
	}
	
	@GetMapping("/{managerType}/availableSlot")
	public List<Slot> getAvailablePosition(@PathVariable("managerType") String managerType)
	{
		if(managerType.equals("entryManager"))
		{
			return managerService.showAvailableParkingSlots();
		}else
		{
			//return "Only Entry Manager have Access!";
		}
		return null;
		
	}
	
	@GetMapping("/{managerType}/genReceipt/{id}")
	public String getReceipt(@PathVariable("managerType") String managerType,@PathVariable("id") int id)
	{
		if(managerType.equals("entryManager"))
		{
			return managerService.generateReceipt(id);
		}else
		{
			return "Only Entry Manager have Access!";
		}
		
	}
	
	@GetMapping("/{managerType}/genBill/{id}")
	public String getBill(@PathVariable("managerType") String managerType,@PathVariable("id") int id)
	{
		if(managerType.equals("exitManager"))
		{
			return managerService.generateBill(id);
		}else
		{
			return "Only Exit Manager have Access!";
		}
		
	}
	
}
