package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Manager;
import com.cg.entity.Security;
import com.cg.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/addSecurity")
	public String addSecurity(@RequestBody Security sec) {
		return adminService.addSecurity(sec);
	}
	

	@GetMapping("/delSecurity/{securityId}")
	public String removeSecurity(@PathVariable("securityId") int id){
		return adminService.removeSecurity(id);
	}
	
	@PostMapping("/addManager")
	public String addManager(@RequestBody Manager man) {
		return adminService.addManager(man);
	}
	

	@GetMapping("/delManager/{id}")
	public String removeManager(@PathVariable("id") int id){
		return adminService.removeManager(id);
	}
	
	
	@GetMapping("/addParking/{incr}/{type}")
	public String addParkingEnd(@PathVariable("incr") int incr,@PathVariable("type") String type ){
		return adminService.addParkingEnd(incr, type);
	}
	
	//FOR TESTING
	@GetMapping("/addAllSlot/{totalSlotCount}/{type}")
	public String addParking(@PathVariable("totalSlotCount") int totalSlotCount,@PathVariable("type") String type ){
		return adminService.addSlot(totalSlotCount,type);
	}
	//END HERE
	//CHECK
	@GetMapping("/removeParking/{decrement}")
	public String removeParkingEnd(@PathVariable("decrement") int decrement){
		return null;
		//return adminService.removeParkingEnd(decrement);
	}
	
	@GetMapping("/changeStatus/{position}/{status}")
	public String changeParkingStatus(@PathVariable("position") int position,@PathVariable("status") String status ){
		return status;
		//return adminService.changeParkingStatus(position, status);
	}
	
	@GetMapping("/rangechangeStatus/{start}/{end}/{status}")
	public String rangeChangeParkingStatus(@PathVariable("start") int start,@PathVariable("end") int end, @PathVariable("end") String status ){
		return status;
		//return adminService.rangeChangeStatusParking(start, end, status);
	}
}
