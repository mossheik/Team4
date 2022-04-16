package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Manager;
import com.cg.entity.Security;
import com.cg.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adservice;
	
	
	@PostMapping("/addSecurity")
	public String addSecurity(@RequestBody Security sec) {
		return adservice.addSecurity(sec);
	}
	

	@GetMapping("/delSecurity/{securityId}")
	public String removeSecurity(@PathVariable("securityId") int id){
		return adservice.removeSecurity(id);
	}
	
	@PostMapping("/addManager")
	public String addManager(@RequestBody Manager man) {
		return adservice.addManager(man);
	}
	

	@GetMapping("/delManager/{id}")
	public String removeManager(@PathVariable("id") int id){
		return adservice.removeManager(id);
	}
	
	@GetMapping("/addAllSlot/{status}/{totalSlotCount}/{type}")
	public String addParking(@PathVariable("status") String status,@PathVariable("totalSlotCount") int totalSlotCount,@PathVariable("type") String type){
	return adservice.addSlot(totalSlotCount,type,status);
	}
	
	@DeleteMapping("/deleteSlot/{decr}/{start}")
	public String removeSlot(@PathVariable("decr") int decr,@PathVariable("start") String start){
		return adservice.removeSlot(decr, start);
	}
	@PutMapping("/update/{slotNo}/{type}")
	public String update(@PathVariable("slotNo") String slotNo,@PathVariable("type") String type ) {
		return adservice.updateSlot(slotNo,type);
	}
	@PutMapping("/rangeChange/{start}/{end}/{type}")
	public String rangechangeSlot(@PathVariable("start") String start,@PathVariable("end") int end, @PathVariable("type") String type ) {
		return adservice.rangeChangeStatusSlot(start, end, type);
	}
}
